package net.lyivx.ls_furniture.common.recipes;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.lyivx.ls_furniture.common.config.Configs;
import net.lyivx.ls_furniture.common.network.NetworkRecipeSync;
import net.lyivx.ls_furniture.registry.ModItems;
import net.mehvahdjukaar.moonlight.api.platform.network.NetworkHelper;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
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

    private static final List<Item> ITEM_ORDER = new ArrayList<>();
    private static final List<Item> UNSORTED = new ArrayList<>();


    //called from server side by recipe stuff.
    public static void accept(List<RecipeHolder<WorkstationRecipe>> sawmillRecipes) {
        sawmillRecipes.forEach(r -> UNSORTED.add(r.value().getResultItem(RegistryAccess.EMPTY).getItem()));
    }

    public static void acceptOrder(IntList list) {
        UNSORTED.clear();
        list.forEach(i -> ITEM_ORDER.add(BuiltInRegistries.ITEM.byId(i)));
    }

    // dont think we can repopulate offthread
    public static void refreshIfNeeded(RegistryAccess reg) {
        if (UNSORTED.isEmpty()) return;
        if (!CreativeModeTabs.getDefaultTab().hasAnyItems()) {
            CreativeModeTabs.tryRebuildTabContents(FeatureFlags.VANILLA_SET, false, reg);
        }
        Map<CreativeModeTab, List<Item>> tabContent = new HashMap<>();

        for (var t : CreativeModeTabs.tabs()) {
            List<Pair<Item, Integer>> weights = new ArrayList<>();
            var list = tabContent.computeIfAbsent(t,
                    creativeModeTabs -> t.getDisplayItems().stream().map(ItemStack::getItem).toList());
            var iterator = UNSORTED.iterator();
            while (iterator.hasNext()) {
                var i = iterator.next();
                int index = list.indexOf(i);
                if (index != -1) {
                    weights.add(Pair.of(i, index));
                    iterator.remove();
                }
            }
            weights.sort(Comparator.comparingInt(Pair::getSecond));
            ITEM_ORDER.addAll(weights.stream().map(Pair::getFirst).toList());
        }

        UNSORTED.clear();
    }


    public static void sort(List<RecipeHolder<WorkstationRecipe>> recipes, Level level) {
        if (Configs.SORT_RECIPES) {
            //Just runs once if needed. Needs to be the same from server and client
            refreshIfNeeded(level.registryAccess());

            recipes.sort(Comparator.comparingInt(value ->
                    ITEM_ORDER.indexOf(value.value().getResultItem(RegistryAccess.EMPTY).getItem())));
        }
    }

    public static void sendOrderToClient(@Nullable ServerPlayer player) {
        IntList list = new IntArrayList();
        ITEM_ORDER.forEach(i -> list.add(BuiltInRegistries.ITEM.getId(i)));
        NetworkRecipeSync.SyncRecipeOrder message = new NetworkRecipeSync.SyncRecipeOrder(list);
        if (player != null) {
            NetworkHelper.sendToClientPlayer(player, message);
        } else {
            NetworkHelper.sendToAllClientPlayers(message);
        }
    }
}