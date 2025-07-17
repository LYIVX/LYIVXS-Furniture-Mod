package net.lyivx.ls_furniture.common.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;

import java.util.Locale;

public record FilterableRecipe(RecipeHolder<WorkstationRecipe> recipeHolder, ItemStack output) {

    public static FilterableRecipe of(RecipeHolder<WorkstationRecipe> recipeHolder) {
        return new FilterableRecipe(recipeHolder, recipeHolder.value().result());
    }

    public boolean matchFilter(String filter) {
        return output.getDisplayName().getString().toLowerCase(Locale.ROOT).contains(filter);
    }

    public WorkstationRecipe recipe() {
        return recipeHolder.value();
    }
}