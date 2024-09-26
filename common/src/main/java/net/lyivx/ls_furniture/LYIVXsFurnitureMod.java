package net.lyivx.ls_furniture;

import net.lyivx.ls_furniture.client.screens.ConfigScreen;
import net.lyivx.ls_furniture.client.screens.ConfigurationScreen;
import net.lyivx.ls_furniture.common.blocks.entity.TombstoneBlockEntity;
import net.lyivx.ls_furniture.common.config.Configs;
import net.lyivx.ls_furniture.common.config.CustomConfigSpec;
import net.lyivx.ls_furniture.common.network.UpdateTombstonePacket;
import net.lyivx.ls_furniture.common.recipes.RecipeSorter;
import net.lyivx.ls_furniture.registry.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Consumer;

public class LYIVXsFurnitureMod {
    public static final String MOD_ID = "ls_furniture";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static void init() {
        ModBlocks.BLOCKS.init();
        ModBlockEntitys.BLOCK_ENTITIES.init();
        ModItems.ITEMS.init();
        ModEntities.ENTITIES.init();
        ModSoundEvents.SOUNDS.init();

        ModRecipes.RECIPE_TYPES.init();
        ModRecipes.RECIPE_SERIALIZERS.init();

        ModMenus.MENUS.init();

        ModBlocksTags.init();
        ModEntitiesTypeTags.init();
        ModItemTags.init();

        ConfigScreen.initConfig();
        Configs.saveConfig();
    }

    public static ResourceLocation res(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public static void initCreativeTabContents(ResourceKey<CreativeModeTab> tab, Consumer<ItemLike> adder) {
        if (tab.equals(ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation("functional_blocks")))) {
            ModItems.DECO.boundStream().forEach(adder);
        } else if (tab.equals(ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation("ingredients")))) {
            ModItems.MISC.boundStream().forEach(adder);
            ModItems.FOODS.boundStream().forEach(adder);
            ModItems.INGREDIENTS.boundStream().forEach(adder);
        } else if (tab.equals(ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation("tools_and_utilities")))) {
            ModItems.TOOLS.boundStream().forEach(adder);
        }
    }
}

