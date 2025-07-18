package net.lyivx.ls_furniture.common.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.library.plugins.vanilla.crafting.VanillaRecipes;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.menus.OvenMenu;
import net.lyivx.ls_furniture.common.menus.WorkstationMenu;
import net.lyivx.ls_furniture.common.recipes.ChoppingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.CuttingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.RecipeSorter;
import net.lyivx.ls_furniture.common.recipes.WorkstationRecipe;
import net.lyivx.ls_furniture.common.recipes.WorldInteractionRecipe;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModItems;
import net.lyivx.ls_furniture.registry.ModMenus;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.SmokerScreen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SmokerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.MOD_ID;
import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;
import static net.lyivx.ls_furniture.common.compat.WorkstationRecipeCategory.WORKSTATION_RECIPE_TYPE;
import static net.lyivx.ls_furniture.common.compat.WorldInteractionRecipeCategory.WORLD_INTERACTION_RECIPE_TYPE;

@JeiPlugin
public class ModJeiPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return createResourceLocation("jei_mod_plugin");
    }

    @Nullable
    private IRecipeCategory<SmokingRecipe> smokingCategory;

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new WorkstationRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new WorldInteractionRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new ChoppingBoardCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new CuttingBoardCategory(registry.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        
        // Get all WorkstationRecipes and their holders (make a mutable copy to avoid UnsupportedOperationException)
        List<RecipeHolder<WorkstationRecipe>> recipeHolders = new ArrayList<>(recipeManager.getAllRecipesFor(ModRecipes.WORKSTATION_RECIPE.get()));
        
        // Sort our mutable copy of the recipe holders
        this.sortRecipesManually(recipeHolders);
        
        // Extract the recipe values from holders
        List<WorkstationRecipe> workstationRecipes = recipeHolders.stream()
                .map(RecipeHolder::value)
                .collect(Collectors.toList());
        
        // Group recipes by their material type AND ingredient count
        Map<String, List<WorkstationRecipe>> groupedRecipes = groupRecipesByMaterialAndCount(workstationRecipes);
        
        // Convert the grouped recipes into a list of recipe lists
        List<List<WorkstationRecipe>> organizedRecipes = new ArrayList<>();
        
        // Add groups in alphabetical order of material name
        List<String> sortedKeys = new ArrayList<>(groupedRecipes.keySet());
        Collections.sort(sortedKeys);
        
        for (String key : sortedKeys) {
            // The recipes within each group are already sorted
            organizedRecipes.add(groupedRecipes.get(key));
        }
        
        // Register the organized recipes
        registration.addRecipes(WORKSTATION_RECIPE_TYPE, organizedRecipes);

        IIngredientManager ingredientManager = registration.getIngredientManager();
        VanillaRecipes vanillaRecipes = new VanillaRecipes(ingredientManager);

        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<WorldInteractionRecipe> recipesCraftingWorldInteraction = rm.getAllRecipesFor(ModRecipes.WORLD_INTERACTION_RECIPE.get())
                .stream().map(RecipeHolder::value).collect(Collectors.toList());
        registration.addRecipes(WORLD_INTERACTION_RECIPE_TYPE, recipesCraftingWorldInteraction);

        List<ChoppingBoardRecipe> recipesCraftingChoppingBoard = rm.getAllRecipesFor(ModRecipes.CHOPPING_BOARD_RECIPE.get())
                .stream().map(RecipeHolder::value).collect(Collectors.toList());
        registration.addRecipes(ChoppingBoardCategory.CHOPPING_BOARD_RECIPE_TYPE, recipesCraftingChoppingBoard);

        List<CuttingBoardRecipe> recipesCraftingCuttingBoard = rm.getAllRecipesFor(ModRecipes.CUTTING_BOARD_RECIPE.get())
                .stream().map(RecipeHolder::value).collect(Collectors.toList());
        registration.addRecipes(CuttingBoardCategory.CUTTING_BOARD_RECIPE_TYPE, recipesCraftingCuttingBoard);
    }
    
    /**
     * Sort recipes manually following the same logic as RecipeSorter
     */
    private void sortRecipesManually(List<RecipeHolder<WorkstationRecipe>> recipes) {
        // Sort by result item's registry ID or description ID
        recipes.sort(Comparator.comparing(recipe -> {
            Item resultItem = recipe.value().result().getItem();
            String itemId = BuiltInRegistries.ITEM.getKey(resultItem).toString();
            return itemId;
        }));
    }

    /**
     * Groups recipes by their material type (oak, acacia, etc.) AND ingredient count
     * This ensures recipes with different input counts are separated
     * While maintaining the sorted order
     */
    private Map<String, List<WorkstationRecipe>> groupRecipesByMaterialAndCount(List<WorkstationRecipe> recipes) {
        // Use LinkedHashMap to preserve insertion order of keys
        Map<String, List<WorkstationRecipe>> grouped = new LinkedHashMap<>();
        
        for (WorkstationRecipe recipe : recipes) {
            // Extract the material type from the input item
            String material = extractMaterialType(recipe);
            // Include the ingredient count in the key to separate recipes with different counts
            int count = recipe.getInputCount();
            String key = material + "_count_" + count;
            
            if (!grouped.containsKey(key)) {
                grouped.put(key, new ArrayList<>());
            }
            grouped.get(key).add(recipe);
        }
        
        // Log the grouping results
        System.out.println("Created " + grouped.size() + " recipe groups by material and count");
        for (Map.Entry<String, List<WorkstationRecipe>> entry : grouped.entrySet()) {
            System.out.println("Group: " + entry.getKey() + ", Recipes: " + entry.getValue().size());
        }
        
        return grouped;
    }
    
    /**
     * Extracts the material type from a recipe based on its input
     */
    private String extractMaterialType(WorkstationRecipe recipe) {
        ItemStack[] matchingStacks = recipe.ingredient().getItems();
        if (matchingStacks.length > 0) {
            Item item = matchingStacks[0].getItem();
            ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
            if (itemId != null) {
                String id = itemId.toString();
                
                // If it's a furniture pack item, extract the material type from the ID
                if (id.contains("furniture_pack")) {
                    String[] parts = id.split(":");
                    if (parts.length > 1) {
                        String name = parts[1]; // Get the part after the namespace
                        String[] nameParts = name.split("_furniture_pack");
                        if (nameParts.length > 0) {
                            return nameParts[0]; // The wood type (oak, acacia, etc.)
                        }
                    }
                }
                
                return id; // Fallback to using the full item ID
            }
        }
        
        return "unknown"; // Fallback for unknown materials
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModItems.WORKSTATION.get()), WORKSTATION_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(Blocks.GRASS_BLOCK), WORLD_INTERACTION_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CHOPPING_BOARD.get()), ChoppingBoardCategory.CHOPPING_BOARD_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CUTTING_BOARD.get()), CuttingBoardCategory.CUTTING_BOARD_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.OAK_COUNTER_OVEN.get()), RecipeTypes.SMOKING);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.SPRUCE_COUNTER_OVEN.get()), RecipeTypes.SMOKING);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.BIRCH_COUNTER_OVEN.get()), RecipeTypes.SMOKING);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.JUNGLE_COUNTER_OVEN.get()), RecipeTypes.SMOKING);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ACACIA_COUNTER_OVEN.get()), RecipeTypes.SMOKING);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.DARK_OAK_COUNTER_OVEN.get()), RecipeTypes.SMOKING);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MANGROVE_COUNTER_OVEN.get()), RecipeTypes.SMOKING);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CHERRY_COUNTER_OVEN.get()), RecipeTypes.SMOKING);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.BAMBOO_COUNTER_OVEN.get()), RecipeTypes.SMOKING);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CRIMSON_COUNTER_OVEN.get()), RecipeTypes.SMOKING);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.WARPED_COUNTER_OVEN.get()), RecipeTypes.SMOKING);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(WorkstationMenu.class,
                ModMenus.WORKSTATION_MENU.get(), WORKSTATION_RECIPE_TYPE,
                0, 2, 2, 36
        );
    }

}

