package net.lyivx.ls_furniture.common.recipes;

import net.lyivx.ls_furniture.config.ConfigProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.*;

public class RecipeSorter {

    private static final List<Item> REGISTRATION_ORDER = new ArrayList<>();
    private static boolean isInitialized = false;

    private static void initializeIfNeeded() {
        if (!isInitialized) {
            REGISTRATION_ORDER.addAll(BuiltInRegistries.ITEM.stream().toList());
            isInitialized = true;
        }
    }

    public static void sort(List<WorkstationRecipe> recipes, Level level) {
        initializeIfNeeded();

        if (ConfigProvider.shouldSortRecipes()) {
            recipes.sort(Comparator.comparingInt(recipe -> {
                Item resultItem = recipe.output().getItem();
                int index = REGISTRATION_ORDER.indexOf(resultItem);
                return index != -1 ? index : Integer.MAX_VALUE;
            }));
        } else {
            recipes.sort(Comparator.comparing(recipe ->
                    recipe.output().getItem().getDescriptionId()));
        }
    }

    public static List<Item> getRegistrationOrder() {
        initializeIfNeeded();
        return new ArrayList<>(REGISTRATION_ORDER);
    }
}