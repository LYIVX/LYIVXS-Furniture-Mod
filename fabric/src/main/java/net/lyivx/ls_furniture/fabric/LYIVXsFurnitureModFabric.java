package net.lyivx.ls_furniture.fabric;

import dev.architectury.event.events.common.LifecycleEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;

import net.lyivx.ls_core.LYIVXsCore;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.config.ModMenuApiImpl;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

import java.nio.file.Files;
import java.nio.file.Path;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.*;

public class LYIVXsFurnitureModFabric implements ModInitializer {


    @Override
    public void onInitialize() {
        LYIVXsFurnitureMod.init();

        LifecycleEvent.SETUP.register(LYIVXsCore::setup);

        ItemGroupEvents.MODIFY_ENTRIES_ALL.register((tab, stacks) -> {
            ResourceLocation loc = BuiltInRegistries.CREATIVE_MODE_TAB.getKey(tab);
            if (loc == null) return;
            ResourceKey<CreativeModeTab> key = ResourceKey.create(Registries.CREATIVE_MODE_TAB, loc);
            LYIVXsFurnitureMod.initCreativeTabContents(key, stacks::accept);
        });
    }


    public static ResourceLocation res(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}