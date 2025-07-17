package net.lyivx.ls_furniture.common.recipes;

import net.lyivx.ls_furniture.config.ConfigProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RecipeSorter {

    private static final List<Item> REGISTRATION_ORDER = new ArrayList<>();
    private static boolean isInitialized = false;

    private static void initializeIfNeeded() {
        if (!isInitialized) {
            REGISTRATION_ORDER.addAll(BuiltInRegistries.ITEM.stream().toList());
            isInitialized = true;
        }
    }

    public static void sort(Optional<RecipeHolder<WorkstationRecipe>> recipes, Level level) {
        initializeIfNeeded();

        if (ConfigProvider.shouldSortRecipes()) {
            recipes.stream().toList().sort(Comparator.comparingInt(recipe -> {
                Item resultItem = recipe.value().result().getItem();
                int index = REGISTRATION_ORDER.indexOf(resultItem);
                return index != -1 ? index : Integer.MAX_VALUE;
            }));
        } else {
            recipes.stream().toList().sort(Comparator.comparing(recipe ->
                    recipe.value().result().getItem().getDescriptionId()));
        }
    }

    public static List<Item> getRegistrationOrder() {
        initializeIfNeeded();
        return new ArrayList<>(REGISTRATION_ORDER);
    }
}