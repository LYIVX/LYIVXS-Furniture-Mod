package net.lyivx.ls_furniture.common.recipes;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.Locale;

public record FilterableRecipe(RecipeHolder<WorkstationRecipe> recipeHolder, ItemStack output) {

    public static FilterableRecipe of(RecipeHolder<WorkstationRecipe> recipeHolder) {
        return new FilterableRecipe(recipeHolder, recipeHolder.value().getResultItem(RegistryAccess.EMPTY));
    }

    public boolean matchFilter(String filter) {
        return output.getDisplayName().getString().toLowerCase(Locale.ROOT).contains(filter);
    }

    public WorkstationRecipe recipe() {
        return recipeHolder.value();
    }
}