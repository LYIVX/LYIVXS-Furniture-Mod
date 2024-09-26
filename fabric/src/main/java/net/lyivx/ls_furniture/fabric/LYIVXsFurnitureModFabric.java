package net.lyivx.ls_furniture.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.config.ModMenuApiImpl;
import net.lyivx.ls_furniture.registry.ModRecipes;
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