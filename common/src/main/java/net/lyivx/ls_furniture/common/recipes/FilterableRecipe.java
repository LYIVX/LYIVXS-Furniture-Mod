package net.lyivx.ls_furniture.common.recipes;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;

import java.util.Locale;

public record FilterableRecipe(WorkstationRecipe recipeHolder, ItemStack output) {

    public static FilterableRecipe of(WorkstationRecipe recipeHolder) {
        return new FilterableRecipe(recipeHolder, recipeHolder.output());
    }

    public boolean matchFilter(String filter) {
        return output.getDisplayName().getString().toLowerCase(Locale.ROOT).contains(filter);
    }

    public WorkstationRecipe recipe() {
        return recipeHolder;
    }
}