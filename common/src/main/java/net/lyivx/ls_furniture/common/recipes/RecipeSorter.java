package net.lyivx.ls_furniture.common.recipes;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.lyivx.ls_furniture.common.config.Configs;
import net.lyivx.ls_furniture.common.network.NetworkRecipeSync;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class RecipeSorter {

    private static final List<Item> ITEM_ORDER = new ArrayList<>();
    private static final List<Item> UNSORTED = new ArrayList<>();


    //called from server side by recipe stuff.
    public static void accept(List<WorkstationRecipe> workstationRecipes) {
        UNSORTED.clear();
        workstationRecipes.forEach(r -> UNSORTED.add(r.getResultItem(RegistryAccess.EMPTY).getItem()));
    }

    public static void acceptOrder(IntList list) {
        UNSORTED.clear();
        ITEM_ORDER.clear();
        list.forEach(i -> ITEM_ORDER.add(BuiltInRegistries.ITEM.byId(i)));
    }

    // don't think we can repopulate off-thread
    public static void refreshIfNeeded(RegistryAccess reg) {
        if (UNSORTED.isEmpty()) return;
        ITEM_ORDER.clear();

        CreativeModeTab customTab = ModItems.ITEM_GROUP.get();


        if (!customTab.hasAnyItems()) {
            // this is NOT a client only method. Calling on server thread is valid.
            CreativeModeTabs.tryRebuildTabContents(FeatureFlags.VANILLA_SET, false, reg);
        }

        List<Item> customTabItems = ModItems.ITEMS.getEntries().stream()
                .map(Supplier::get)
                .collect(Collectors.toList());

        for (Item item : customTabItems) {
            if (UNSORTED.contains(item)) {
                ITEM_ORDER.add(item);
                UNSORTED.remove(item);
            }
        }


        UNSORTED.clear();
    }


    public static void sort(List<WorkstationRecipe> recipes, Level level) {
        if (Configs.SORT_RECIPES) {
            //Just runs once if needed. Needs to be the same from server and client
            refreshIfNeeded(level.registryAccess());

            recipes.sort(Comparator.comparingInt(value ->
                    BuiltInRegistries.ITEM.getId(value.getResultItem(RegistryAccess.EMPTY).getItem())));
        }
    }

    public static void sendOrderToClient(@Nullable ServerPlayer player) {
        IntList list = new IntArrayList();
        ITEM_ORDER.forEach(i -> list.add(BuiltInRegistries.ITEM.getId(i)));
        NetworkRecipeSync.SyncRecipeOrder message = new NetworkRecipeSync.SyncRecipeOrder(list);
        if (player != null) {
            NetworkRecipeSync.CHANNEL.sendToClientPlayer(player, message);
        } else {
            NetworkRecipeSync.CHANNEL.sendToAllClientPlayers(message);
        }
    }
}