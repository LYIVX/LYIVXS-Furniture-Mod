package net.lyivx.ls_furniture;

import net.lyivx.ls_core.LYIVXsCore;
import net.lyivx.ls_furniture.registry.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Consumer;

import static net.minecraft.world.item.CreativeModeTabs.*;

public class LYIVXsFurnitureMod {
    public static final String MOD_ID = "ls_furniture";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static void init() {
        ModBlocks.BLOCKS.init();
        ModBlockEntitys.BLOCK_ENTITIES.init();
        ModItems.ITEMS.init();
        ModCreativeTab.CREATIVE_MODE_TABS.init();
        ModEntities.ENTITIES.init();
        ModSoundEvents.SOUNDS.init();
        ModMenus.MENUS.init();

        ModRecipes.Register();

        ModComponents.DATA_ATTACHMENTS.register();

        ModNetworks.init();

        ModBlocksTags.init();
        ModEntitiesTypeTags.init();
        ModItemTags.init();

        LYIVXsCore.setup();
    }

    public static ResourceLocation createResourceLocation(String location) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, location);
    }

    public static void addCreativeTabContents(ResourceKey<CreativeModeTab> tab, Consumer<ItemLike> consumer) {
        if (tab == FUNCTIONAL_BLOCKS) {
            ModItems.DECO.boundStream().forEach(consumer);
        } else if (tab == INGREDIENTS) {
            ModItems.MISC.boundStream().forEach(consumer);
            ModItems.FOODS.boundStream().forEach(consumer);
            ModItems.INGREDIENTS.boundStream().forEach(consumer);
            ModItems.INGREDIENTS_BURNABLE_100.boundStream().forEach(consumer);
            ModItems.INGREDIENTS_BURNABLE_200.boundStream().forEach(consumer);
        } else if (tab == TOOLS_AND_UTILITIES) {
            ModItems.TOOLS.boundStream().forEach(consumer);
        }
    }
}

