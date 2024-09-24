package net.lyivx.ls_furniture.common.recipes;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;

import java.util.Locale;

public record FilterableRecipe(WorkstationRecipe recipe, ItemStack output) {

    public static FilterableRecipe of(WorkstationRecipe recipe) {
        return new FilterableRecipe(recipe, recipe.getResultItem(RegistryAccess.EMPTY));
    }

    public boolean matchFilter(String filter) {
        return output.getDisplayName().getString().toLowerCase(Locale.ROOT).contains(filter);
    }
}