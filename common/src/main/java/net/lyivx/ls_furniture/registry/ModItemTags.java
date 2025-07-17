package net.lyivx.ls_furniture.registry;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;


public class ModItemTags {

    public static final TagKey<Item> BLINDS = itemTag("blinds");
    public static final TagKey<Item> CHAIRS = itemTag("chairs");
    public static final TagKey<Item> CURTAINS = itemTag("curtains");
    public static final TagKey<Item> DRAWERS = itemTag("drawers");
    public static final TagKey<Item> LAMPS = itemTag("lamps");
    public static final TagKey<Item> SHELVES = itemTag("shelves");
    public static final TagKey<Item> SOFAS = itemTag("sofas");
    public static final TagKey<Item> STOOLS = itemTag("stools");
    public static final TagKey<Item> TABLES = itemTag("tables");

    public static final TagKey<Item> FLOWER_BOX_PLACEABLES = itemTag("flower_box_placeables");
    public static final TagKey<Item> FLOWER_BOX_BANNED = itemTag("flower_box_banned");

    public static final TagKey<Item> HAMMER = itemTag("hammers");
    public static final TagKey<Item> WRENCH = itemTag("wrenches");
    public static final TagKey<Item> SAW = itemTag("saws");

    public static final TagKey<Item> CRATE_BLACKLIST_TAG = itemTag("crate_blacklist");
    public static final TagKey<Item> MAIL_TAG = itemTag("mail");

    private static TagKey<Item> itemTag(String name) {
        return TagKey.create(Registries.ITEM, createResourceLocation(name));
    }

    public static void init() {}
}