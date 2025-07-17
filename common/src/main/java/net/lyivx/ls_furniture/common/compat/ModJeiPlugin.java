package net.lyivx.ls_furniture.common.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.library.plugins.vanilla.crafting.VanillaRecipes;
import net.lyivx.ls_furniture.common.menus.WorkstationMenu;
import net.lyivx.ls_furniture.common.recipes.ChoppingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.CuttingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.WorkstationRecipe;
import net.lyivx.ls_furniture.common.recipes.WorldInteractionRecipe;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModMenus;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.SmokingRecipe;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;
import static net.lyivx.ls_furniture.common.compat.WorkstationRecipeCategory.WORKSTATION_RECIPE_TYPE;

@JeiPlugin
public class ModJeiPlugin implements IModPlugin {

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
        IIngredientManager ingredientManager = registration.getIngredientManager();
        VanillaRecipes vanillaRecipes = new VanillaRecipes(ingredientManager);

        // Access recipes through JEI's IRecipeRegistration interface
        // Skip loading the custom recipes if we can't get a RecipeManager
        try {
            Minecraft minecraft = Minecraft.getInstance();
            RecipeManager rm = Objects.requireNonNull(minecraft.level.getServer()).getRecipeManager();
            
            List<WorkstationRecipe> recipesCraftingWorkstation = rm.getRecipes().stream()
                    .filter(holder -> holder.value() instanceof WorkstationRecipe)
                    .map(holder -> (WorkstationRecipe) holder.value())
                    .collect(Collectors.toList());
            registration.addRecipes(WorkstationRecipeCategory.WORKSTATION_RECIPE_TYPE, recipesCraftingWorkstation);
    
            List<WorldInteractionRecipe> recipesCraftingWorldInteraction = rm.getRecipes().stream()
                    .filter(holder -> holder.value() instanceof WorldInteractionRecipe)
                    .map(holder -> (WorldInteractionRecipe) holder.value())
                    .collect(Collectors.toList());
            registration.addRecipes(WorldInteractionRecipeCategory.WORLD_INTERACTION_RECIPE_TYPE, recipesCraftingWorldInteraction);
    
            List<ChoppingBoardRecipe> recipesCraftingChoppingBoard = rm.getRecipes().stream()
                    .filter(holder -> holder.value() instanceof ChoppingBoardRecipe)
                    .map(holder -> (ChoppingBoardRecipe) holder.value())
                    .collect(Collectors.toList());
            registration.addRecipes(ChoppingBoardCategory.CHOPPING_BOARD_RECIPE_TYPE, recipesCraftingChoppingBoard);
    
            List<CuttingBoardRecipe> recipesCraftingCuttingBoard = rm.getRecipes().stream()
                    .filter(holder -> holder.value() instanceof CuttingBoardRecipe)
                    .map(holder -> (CuttingBoardRecipe) holder.value())
                    .collect(Collectors.toList());
            registration.addRecipes(CuttingBoardCategory.CUTTING_BOARD_RECIPE_TYPE, recipesCraftingCuttingBoard);
        } catch (Exception e) {
            // If we can't get the recipe manager, log the error but don't crash
            System.err.println("Failed to load recipes for JEI: " + e.getMessage());
        }
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.WORKSTATION.get()), WorkstationRecipeCategory.WORKSTATION_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(Blocks.GRASS_BLOCK), WorldInteractionRecipeCategory.WORLD_INTERACTION_RECIPE_TYPE);
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

    @Override
    public ResourceLocation getPluginUid() {
        return createResourceLocation("jei_mod_plugin");
    }
}

