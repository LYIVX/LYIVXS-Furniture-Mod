package net.lyivx.ls_furniture.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.MOD_ID;

public class LYIVXsFurnitureModFabric implements ModInitializer {


    @Override
    public void onInitialize() {
        LYIVXsFurnitureMod.init();

        ItemGroupEvents.MODIFY_ENTRIES_ALL.register((group, items) -> {
            ResourceLocation key = BuiltInRegistries.CREATIVE_MODE_TAB.getKey(group);
            if (key == null) return;
            LYIVXsFurnitureMod.addCreativeTabContents(ResourceKey.create(Registries.CREATIVE_MODE_TAB, key), items::accept);
        });
    }
}