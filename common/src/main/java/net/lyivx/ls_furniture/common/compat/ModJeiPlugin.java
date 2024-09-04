package net.lyivx.ls_furniture.common.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.recipes.ChoppingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.CuttingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.WorkstationRecipe;
import net.lyivx.ls_furniture.common.recipes.WorldInteractionRecipe;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class ModJeiPlugin implements IModPlugin {

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new WorkstationRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new WorldInteractionRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new ChoppingBoardCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new CuttingBoardCategory(registry.getJeiHelpers().getGuiHelper()));

    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<WorkstationRecipe> recipesCraftingWorkstation = rm.getAllRecipesFor(ModRecipes.WORKSTATION_RECIPE.get());
        registration.addRecipes(WorkstationRecipeCategory.WORKSTATION_RECIPE_TYPE, recipesCraftingWorkstation);

        List<WorldInteractionRecipe> recipesCraftingWorldInteraction = rm.getAllRecipesFor(ModRecipes.WORLD_INTERACTION_RECIPE.get());
        registration.addRecipes(WorldInteractionRecipeCategory.WORLD_INTERACTION_RECIPE_TYPE, recipesCraftingWorldInteraction);

        List<ChoppingBoardRecipe> recipesCraftingChoppingBoard = rm.getAllRecipesFor(ModRecipes.CHOPPING_BOARD_RECIPE.get());
        registration.addRecipes(ChoppingBoardCategory.CHOPPING_BOARD_RECIPE_TYPE, recipesCraftingChoppingBoard);

        List<CuttingBoardRecipe> recipesCraftingCuttingBoard = rm.getAllRecipesFor(ModRecipes.CUTTING_BOARD_RECIPE.get());
        registration.addRecipes(CuttingBoardCategory.CUTTING_BOARD_RECIPE_TYPE, recipesCraftingCuttingBoard);

    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.WORKSTATION.get()), WorkstationRecipeCategory.WORKSTATION_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(Blocks.GRASS_BLOCK), WorldInteractionRecipeCategory.WORLD_INTERACTION_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CHOPPING_BOARD.get()), ChoppingBoardCategory.CHOPPING_BOARD_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CUTTING_BOARD.get()), CuttingBoardCategory.CUTTING_BOARD_RECIPE_TYPE);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        //registration.addRecipeClickArea(CookingPotScreen.class, 89, 25, 24, 17, FDRecipeTypes.COOKING);
    }

    /*@Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(WorkstationMenu.class,
                LYIVXsFurnitureMod.WORKSTATION_MENU.get(),
                WORKSTATION_RECIPE_TYPE,
                0, 2, 2, 36
        );
    }*/

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "jei_mod_plugin");
    }
}

