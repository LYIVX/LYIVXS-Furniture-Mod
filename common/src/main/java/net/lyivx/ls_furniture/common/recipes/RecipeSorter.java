package net.lyivx.ls_furniture.common.recipes;

import net.lyivx.ls_furniture.common.config.Configs;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;

import java.util.*;

public class RecipeSorter {

    private static final List<Item> REGISTRATION_ORDER = new ArrayList<>();

    public static void registerItem(Item item) {
        if (!REGISTRATION_ORDER.contains(item)) {
            REGISTRATION_ORDER.add(item);
        }
    }

    public static void sort(List<RecipeHolder<WorkstationRecipe>> recipes, Level level) {
        if (Configs.SORT_RECIPES) {
            recipes.sort(Comparator.comparingInt(recipe -> {
                Item resultItem = recipe.value().output().getItem();
                int index = REGISTRATION_ORDER.indexOf(resultItem);
                return index != -1 ? index : Integer.MAX_VALUE;
            }));
        } else {
            recipes.sort(Comparator.comparing(recipe ->
                    recipe.value().output().getItem().getDescriptionId()));
        }
    }

    public static List<Item> getRegistrationOrder() {
        return new ArrayList<>(REGISTRATION_ORDER);
    }
}