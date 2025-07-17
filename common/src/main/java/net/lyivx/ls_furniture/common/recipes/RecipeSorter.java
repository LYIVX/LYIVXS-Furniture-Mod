package net.lyivx.ls_furniture.common.recipes;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.lyivx.ls_furniture.config.ConfigProvider;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import com.mojang.datafixers.util.Pair;
import net.minecraft.world.item.ItemStack;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class RecipeSorter {

    private static final List<Item> REGISTRATION_ORDER = new ArrayList<>();
    private static boolean isInitialized = false;

    private static void initializeIfNeeded() {
        if (!isInitialized) {
            REGISTRATION_ORDER.addAll(BuiltInRegistries.ITEM.stream().toList());
            isInitialized = true;
        }
    }

    public static void sort(List<RecipeHolder<WorkstationRecipe>> recipes, Level level) {
        initializeIfNeeded();

        if (ConfigProvider.shouldSortRecipes()) {
            recipes.sort(Comparator.comparingInt(recipe -> {
                Item resultItem = recipe.value().result().getItem();
                int index = REGISTRATION_ORDER.indexOf(resultItem);
                return index != -1 ? index : Integer.MAX_VALUE;
            }));
        } else {
            recipes.sort(Comparator.comparing(recipe ->
                    recipe.value().result().getItem().getDescriptionId()));
        }
    }

    public static List<Item> getRegistrationOrder() {
        initializeIfNeeded();
        return new ArrayList<>(REGISTRATION_ORDER);
    }
}