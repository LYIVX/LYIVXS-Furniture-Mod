
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lsfurniture.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.lsfurniture.item.ShearItem;
import net.mcreator.lsfurniture.item.SawItem;
import net.mcreator.lsfurniture.item.HammerItem;
import net.mcreator.lsfurniture.item.ChiselItem;
import net.mcreator.lsfurniture.item.AnyIngotItem;
import net.mcreator.lsfurniture.item.AnyDyeItem;
import net.mcreator.lsfurniture.block.display.WarpedWardrobeDisplayItem;
import net.mcreator.lsfurniture.block.display.WarpedWardrobe2DisplayItem;
import net.mcreator.lsfurniture.block.display.WarpedWardrobe1DisplayItem;
import net.mcreator.lsfurniture.block.display.WarpedSinkDisplayItem;
import net.mcreator.lsfurniture.block.display.WarpedOvenDisplayItem;
import net.mcreator.lsfurniture.block.display.WarpedDrawerDisplayItem;
import net.mcreator.lsfurniture.block.display.WarpedDeskDisplayItem;
import net.mcreator.lsfurniture.block.display.WarpedCupboardDisplayItem;
import net.mcreator.lsfurniture.block.display.WarpedCounterDisplayItem;
import net.mcreator.lsfurniture.block.display.ToasterDisplayItem;
import net.mcreator.lsfurniture.block.display.SprucewardrobeDisplayItem;
import net.mcreator.lsfurniture.block.display.SpruceWardrobe2DisplayItem;
import net.mcreator.lsfurniture.block.display.SpruceWardrobe1DisplayItem;
import net.mcreator.lsfurniture.block.display.SpruceSinkDisplayItem;
import net.mcreator.lsfurniture.block.display.SpruceOvenDisplayItem;
import net.mcreator.lsfurniture.block.display.SpruceDrawerDisplayItem;
import net.mcreator.lsfurniture.block.display.SpruceDeskDisplayItem;
import net.mcreator.lsfurniture.block.display.SpruceCupboardDisplayItem;
import net.mcreator.lsfurniture.block.display.SpruceCounterDisplayItem;
import net.mcreator.lsfurniture.block.display.OakWardrobe2DisplayItem;
import net.mcreator.lsfurniture.block.display.OakWardrobe1DisplayItem;
import net.mcreator.lsfurniture.block.display.OakWardrobe0DisplayItem;
import net.mcreator.lsfurniture.block.display.OakSinkDisplayItem;
import net.mcreator.lsfurniture.block.display.OakOvenDisplayItem;
import net.mcreator.lsfurniture.block.display.OakDrawerDisplayItem;
import net.mcreator.lsfurniture.block.display.OakDeskDisplayItem;
import net.mcreator.lsfurniture.block.display.OakCupboardDisplayItem;
import net.mcreator.lsfurniture.block.display.OakCounterDisplayItem;
import net.mcreator.lsfurniture.block.display.MicrowaveDisplayItem;
import net.mcreator.lsfurniture.block.display.MangroveWardrobeDisplayItem;
import net.mcreator.lsfurniture.block.display.MangroveWardrobe2DisplayItem;
import net.mcreator.lsfurniture.block.display.MangroveWardrobe1DisplayItem;
import net.mcreator.lsfurniture.block.display.MangroveSinkDisplayItem;
import net.mcreator.lsfurniture.block.display.MangroveOvenDisplayItem;
import net.mcreator.lsfurniture.block.display.MangroveDrawerDisplayItem;
import net.mcreator.lsfurniture.block.display.MangroveDeskDisplayItem;
import net.mcreator.lsfurniture.block.display.MangroveCupboardDisplayItem;
import net.mcreator.lsfurniture.block.display.MangroveCounterDisplayItem;
import net.mcreator.lsfurniture.block.display.KettleDisplayItem;
import net.mcreator.lsfurniture.block.display.JungleWardrobeDisplayItem;
import net.mcreator.lsfurniture.block.display.JungleWardrobe2DisplayItem;
import net.mcreator.lsfurniture.block.display.JungleWardrobe1DisplayItem;
import net.mcreator.lsfurniture.block.display.JungleSinkDisplayItem;
import net.mcreator.lsfurniture.block.display.JungleOvenDisplayItem;
import net.mcreator.lsfurniture.block.display.JungleDrawerDisplayItem;
import net.mcreator.lsfurniture.block.display.JungleDeskDisplayItem;
import net.mcreator.lsfurniture.block.display.JungleCupboardDisplayItem;
import net.mcreator.lsfurniture.block.display.JungleCounterDisplayItem;
import net.mcreator.lsfurniture.block.display.FurnitureCrafterBetaDisplayItem;
import net.mcreator.lsfurniture.block.display.FridgeFreezerBlockDisplayItem;
import net.mcreator.lsfurniture.block.display.FridgeFreezerBlock2DisplayItem;
import net.mcreator.lsfurniture.block.display.FridgeFreezerBlock1DisplayItem;
import net.mcreator.lsfurniture.block.display.Darkoakwardrobe2DisplayItem;
import net.mcreator.lsfurniture.block.display.Darkoakwardrobe1DisplayItem;
import net.mcreator.lsfurniture.block.display.Darkoakwardrobe0DisplayItem;
import net.mcreator.lsfurniture.block.display.DarkoakDeskDisplayItem;
import net.mcreator.lsfurniture.block.display.DarkOakSinkDisplayItem;
import net.mcreator.lsfurniture.block.display.DarkOakOvenDisplayItem;
import net.mcreator.lsfurniture.block.display.DarkOakDrawerDisplayItem;
import net.mcreator.lsfurniture.block.display.DarkOakCupboardDisplayItem;
import net.mcreator.lsfurniture.block.display.DarkOakCounterDisplayItem;
import net.mcreator.lsfurniture.block.display.CrimsonWardrobeDisplayItem;
import net.mcreator.lsfurniture.block.display.CrimsonWardrobe2DisplayItem;
import net.mcreator.lsfurniture.block.display.CrimsonWardrobe1DisplayItem;
import net.mcreator.lsfurniture.block.display.CrimsonSinkDisplayItem;
import net.mcreator.lsfurniture.block.display.CrimsonOvenDisplayItem;
import net.mcreator.lsfurniture.block.display.CrimsonDrawerDisplayItem;
import net.mcreator.lsfurniture.block.display.CrimsonDeskDisplayItem;
import net.mcreator.lsfurniture.block.display.CrimsonCupboardDisplayItem;
import net.mcreator.lsfurniture.block.display.CrimsonCounterDisplayItem;
import net.mcreator.lsfurniture.block.display.BirchWardrobeDisplayItem;
import net.mcreator.lsfurniture.block.display.BirchWardrobe2DisplayItem;
import net.mcreator.lsfurniture.block.display.BirchWardrobe1DisplayItem;
import net.mcreator.lsfurniture.block.display.BirchSinkDisplayItem;
import net.mcreator.lsfurniture.block.display.BirchOvenDisplayItem;
import net.mcreator.lsfurniture.block.display.BirchDrawerDisplayItem;
import net.mcreator.lsfurniture.block.display.BirchDeskDisplayItem;
import net.mcreator.lsfurniture.block.display.BirchCupboardDisplayItem;
import net.mcreator.lsfurniture.block.display.BirchCounterDisplayItem;
import net.mcreator.lsfurniture.block.display.AcaciaWardrobeDisplayItem;
import net.mcreator.lsfurniture.block.display.AcaciaWardrobe2DisplayItem;
import net.mcreator.lsfurniture.block.display.AcaciaWardrobe1DisplayItem;
import net.mcreator.lsfurniture.block.display.AcaciaSinkDisplayItem;
import net.mcreator.lsfurniture.block.display.AcaciaOvenDisplayItem;
import net.mcreator.lsfurniture.block.display.AcaciaDrawerDisplayItem;
import net.mcreator.lsfurniture.block.display.AcaciaDeskDisplayItem;
import net.mcreator.lsfurniture.block.display.AcaciaCupboardDisplayItem;
import net.mcreator.lsfurniture.block.display.AcaciaCounterDisplayItem;
import net.mcreator.lsfurniture.LsFurnitureMod;

public class LsFurnitureModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, LsFurnitureMod.MODID);
	public static final RegistryObject<Item> FURNITURE_CRAFTER_BETA = REGISTRY.register(LsFurnitureModBlocks.FURNITURE_CRAFTER_BETA.getId().getPath(),
			() -> new FurnitureCrafterBetaDisplayItem(LsFurnitureModBlocks.FURNITURE_CRAFTER_BETA.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> SAW = REGISTRY.register("saw", () -> new SawItem());
	public static final RegistryObject<Item> HAMMER = REGISTRY.register("hammer", () -> new HammerItem());
	public static final RegistryObject<Item> SHEAR = REGISTRY.register("shear", () -> new ShearItem());
	public static final RegistryObject<Item> PLATE = block(LsFurnitureModBlocks.PLATE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> COMPUTER_OFF = block(LsFurnitureModBlocks.COMPUTER_OFF, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> TV_STAND_OFF = block(LsFurnitureModBlocks.TV_STAND_OFF, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_APPLE_CREATE = block(LsFurnitureModBlocks.OAK_APPLE_CREATE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_CREATE = block(LsFurnitureModBlocks.OAK_CREATE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_WHITE_SOFA = block(LsFurnitureModBlocks.OAK_WHITE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_WHITE_SOFA = block(LsFurnitureModBlocks.DARK_OAK_WHITE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> SPRUCE_WHITE_SOFA = block(LsFurnitureModBlocks.SPRUCE_WHITE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ACACIA_WHITE_SOFA = block(LsFurnitureModBlocks.ACACIA_WHITE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BIRCH_WHITE_SOFA = block(LsFurnitureModBlocks.BIRCH_WHITE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> JUNGLE_WHITE_SOFA = block(LsFurnitureModBlocks.JUNGLE_WHITE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> MANGROVE_WHITE_SOFA = block(LsFurnitureModBlocks.MANGROVE_WHITE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CRIMSON_WHITE_SOFA = block(LsFurnitureModBlocks.CRIMSON_WHITE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> WARPED_WHITE_SOFA = block(LsFurnitureModBlocks.WARPED_WHITE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_BLACK_SOFA = block(LsFurnitureModBlocks.OAK_BLACK_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_BLUE_SOFA = block(LsFurnitureModBlocks.OAK_BLUE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_BROWN_SOFA = block(LsFurnitureModBlocks.OAK_BROWN_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_CYAN_SOFA = block(LsFurnitureModBlocks.OAK_CYAN_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_GRAY_SOFA = block(LsFurnitureModBlocks.OAK_GRAY_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_GREEN_SOFA = block(LsFurnitureModBlocks.OAK_GREEN_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_LIGHT_BLUE_SOFA = block(LsFurnitureModBlocks.OAK_LIGHT_BLUE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_LIGHT_GRAY_SOFA = block(LsFurnitureModBlocks.OAK_LIGHT_GRAY_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_LIME_SOFA = block(LsFurnitureModBlocks.OAK_LIME_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_MAGENTA_SOFA = block(LsFurnitureModBlocks.OAK_MAGENTA_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_ORANGE_SOFA = block(LsFurnitureModBlocks.OAK_ORANGE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_PINK_SOFA = block(LsFurnitureModBlocks.OAK_PINK_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_PURPLE_SOFA = block(LsFurnitureModBlocks.OAK_PURPLE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_RED_SOFA = block(LsFurnitureModBlocks.OAK_RED_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_YELLOW_SOFA = block(LsFurnitureModBlocks.OAK_YELLOW_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_BLACK_SOFA = block(LsFurnitureModBlocks.DARK_OAK_BLACK_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_BLUE_SOFA = block(LsFurnitureModBlocks.DARK_OAK_BLUE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_BROWN_SOFA = block(LsFurnitureModBlocks.DARK_OAK_BROWN_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_CYAN_SOFA = block(LsFurnitureModBlocks.DARK_OAK_CYAN_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_GRAY_SOFA = block(LsFurnitureModBlocks.DARK_OAK_GRAY_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_GREEN_SOFA = block(LsFurnitureModBlocks.DARK_OAK_GREEN_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_LIGHT_BLUE_SOFA = block(LsFurnitureModBlocks.DARK_OAK_LIGHT_BLUE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_LIGHT_GRAY_SOFA = block(LsFurnitureModBlocks.DARK_OAK_LIGHT_GRAY_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_LIME_SOFA = block(LsFurnitureModBlocks.DARK_OAK_LIME_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_MAGENTA_SOFA = block(LsFurnitureModBlocks.DARK_OAK_MAGENTA_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_ORANGE_SOFA = block(LsFurnitureModBlocks.DARK_OAK_ORANGE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_PINK_SOFA = block(LsFurnitureModBlocks.DARK_OAK_PINK_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_PURPLE_SOFA = block(LsFurnitureModBlocks.DARK_OAK_PURPLE_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_RED_SOFA = block(LsFurnitureModBlocks.DARK_OAK_RED_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_YELLOW_SOFA = block(LsFurnitureModBlocks.DARK_OAK_YELLOW_SOFA, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_CHAIR = block(LsFurnitureModBlocks.OAK_CHAIR, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_CHAIR = block(LsFurnitureModBlocks.DARK_OAK_CHAIR, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> SPRUCE_CHAIR = block(LsFurnitureModBlocks.SPRUCE_CHAIR, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ACACIA_CHAIR = block(LsFurnitureModBlocks.ACACIA_CHAIR, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BIRCH_CHAIR = block(LsFurnitureModBlocks.BIRCH_CHAIR, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> JUNGLE_CHAIR = block(LsFurnitureModBlocks.JUNGLE_CHAIR, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> MANGROVE_CHAIR = block(LsFurnitureModBlocks.MANGROVE_CHAIR, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CRIMSON_CHAIR = block(LsFurnitureModBlocks.CRIMSON_CHAIR, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> WARPED_CHAIR = block(LsFurnitureModBlocks.WARPED_CHAIR, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_STOOL = block(LsFurnitureModBlocks.OAK_STOOL, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_STOOL = block(LsFurnitureModBlocks.DARK_OAK_STOOL, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> SPRUCE_STOOL = block(LsFurnitureModBlocks.SPRUCE_STOOL, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ACACIA_STOOL = block(LsFurnitureModBlocks.ACACIA_STOOL, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BIRCH_STOOL = block(LsFurnitureModBlocks.BIRCH_STOOL, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> JUNGLE_STOOL = block(LsFurnitureModBlocks.JUNGLE_STOOL, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> MANGROVE_STOOL = block(LsFurnitureModBlocks.MANGROVE_STOOL, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CRIMSON_STOOL = block(LsFurnitureModBlocks.CRIMSON_STOOL, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> WARPED_STOOL = block(LsFurnitureModBlocks.WARPED_STOOL, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> TABLE_NONE = block(LsFurnitureModBlocks.TABLE_NONE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_TABLE_NONE = block(LsFurnitureModBlocks.DARK_OAK_TABLE_NONE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> SPRUCE_TABLE_NONE = block(LsFurnitureModBlocks.SPRUCE_TABLE_NONE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ACACIA_TABLE_NONE = block(LsFurnitureModBlocks.ACACIA_TABLE_NONE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BIRCH_TABLE_NONE = block(LsFurnitureModBlocks.BIRCH_TABLE_NONE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> JUNGLE_TABLE_NONE = block(LsFurnitureModBlocks.JUNGLE_TABLE_NONE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> MANGROVE_TABLE_NONE = block(LsFurnitureModBlocks.MANGROVE_TABLE_NONE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CRIMSON_TABLE_NONE = block(LsFurnitureModBlocks.CRIMSON_TABLE_NONE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> WARPED_TABLE_NONE = block(LsFurnitureModBlocks.WARPED_TABLE_NONE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_IRON_TABLE_NONE = block(LsFurnitureModBlocks.OAK_IRON_TABLE_NONE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_GOLD_TABLE_NONE = block(LsFurnitureModBlocks.OAK_GOLD_TABLE_NONE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> IRON_NONE = block(LsFurnitureModBlocks.IRON_NONE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_WARDROBE_0 = REGISTRY.register(LsFurnitureModBlocks.OAK_WARDROBE_0.getId().getPath(),
			() -> new OakWardrobe0DisplayItem(LsFurnitureModBlocks.OAK_WARDROBE_0.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> DARKOAKWARDROBE_0 = REGISTRY.register(LsFurnitureModBlocks.DARKOAKWARDROBE_0.getId().getPath(),
			() -> new Darkoakwardrobe0DisplayItem(LsFurnitureModBlocks.DARKOAKWARDROBE_0.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> SPRUCEWARDROBE = REGISTRY.register(LsFurnitureModBlocks.SPRUCEWARDROBE.getId().getPath(),
			() -> new SprucewardrobeDisplayItem(LsFurnitureModBlocks.SPRUCEWARDROBE.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> ACACIA_WARDROBE = REGISTRY.register(LsFurnitureModBlocks.ACACIA_WARDROBE.getId().getPath(),
			() -> new AcaciaWardrobeDisplayItem(LsFurnitureModBlocks.ACACIA_WARDROBE.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> BIRCH_WARDROBE = REGISTRY.register(LsFurnitureModBlocks.BIRCH_WARDROBE.getId().getPath(),
			() -> new BirchWardrobeDisplayItem(LsFurnitureModBlocks.BIRCH_WARDROBE.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> JUNGLE_WARDROBE = REGISTRY.register(LsFurnitureModBlocks.JUNGLE_WARDROBE.getId().getPath(),
			() -> new JungleWardrobeDisplayItem(LsFurnitureModBlocks.JUNGLE_WARDROBE.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> MANGROVE_WARDROBE = REGISTRY.register(LsFurnitureModBlocks.MANGROVE_WARDROBE.getId().getPath(),
			() -> new MangroveWardrobeDisplayItem(LsFurnitureModBlocks.MANGROVE_WARDROBE.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> CRIMSON_WARDROBE = REGISTRY.register(LsFurnitureModBlocks.CRIMSON_WARDROBE.getId().getPath(),
			() -> new CrimsonWardrobeDisplayItem(LsFurnitureModBlocks.CRIMSON_WARDROBE.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> WARPED_WARDROBE = REGISTRY.register(LsFurnitureModBlocks.WARPED_WARDROBE.getId().getPath(),
			() -> new WarpedWardrobeDisplayItem(LsFurnitureModBlocks.WARPED_WARDROBE.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> OAK_DESK = REGISTRY.register(LsFurnitureModBlocks.OAK_DESK.getId().getPath(), () -> new OakDeskDisplayItem(LsFurnitureModBlocks.OAK_DESK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> DARKOAK_DESK = REGISTRY.register(LsFurnitureModBlocks.DARKOAK_DESK.getId().getPath(),
			() -> new DarkoakDeskDisplayItem(LsFurnitureModBlocks.DARKOAK_DESK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> SPRUCE_DESK = REGISTRY.register(LsFurnitureModBlocks.SPRUCE_DESK.getId().getPath(),
			() -> new SpruceDeskDisplayItem(LsFurnitureModBlocks.SPRUCE_DESK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> ACACIA_DESK = REGISTRY.register(LsFurnitureModBlocks.ACACIA_DESK.getId().getPath(),
			() -> new AcaciaDeskDisplayItem(LsFurnitureModBlocks.ACACIA_DESK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> BIRCH_DESK = REGISTRY.register(LsFurnitureModBlocks.BIRCH_DESK.getId().getPath(),
			() -> new BirchDeskDisplayItem(LsFurnitureModBlocks.BIRCH_DESK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> JUNGLE_DESK = REGISTRY.register(LsFurnitureModBlocks.JUNGLE_DESK.getId().getPath(),
			() -> new JungleDeskDisplayItem(LsFurnitureModBlocks.JUNGLE_DESK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> MANGROVE_DESK = REGISTRY.register(LsFurnitureModBlocks.MANGROVE_DESK.getId().getPath(),
			() -> new MangroveDeskDisplayItem(LsFurnitureModBlocks.MANGROVE_DESK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> CRIMSON_DESK = REGISTRY.register(LsFurnitureModBlocks.CRIMSON_DESK.getId().getPath(),
			() -> new CrimsonDeskDisplayItem(LsFurnitureModBlocks.CRIMSON_DESK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> WARPED_DESK = REGISTRY.register(LsFurnitureModBlocks.WARPED_DESK.getId().getPath(),
			() -> new WarpedDeskDisplayItem(LsFurnitureModBlocks.WARPED_DESK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> OAK_DRAWER = REGISTRY.register(LsFurnitureModBlocks.OAK_DRAWER.getId().getPath(),
			() -> new OakDrawerDisplayItem(LsFurnitureModBlocks.OAK_DRAWER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> DARK_OAK_DRAWER = REGISTRY.register(LsFurnitureModBlocks.DARK_OAK_DRAWER.getId().getPath(),
			() -> new DarkOakDrawerDisplayItem(LsFurnitureModBlocks.DARK_OAK_DRAWER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> SPRUCE_DRAWER = REGISTRY.register(LsFurnitureModBlocks.SPRUCE_DRAWER.getId().getPath(),
			() -> new SpruceDrawerDisplayItem(LsFurnitureModBlocks.SPRUCE_DRAWER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> ACACIA_DRAWER = REGISTRY.register(LsFurnitureModBlocks.ACACIA_DRAWER.getId().getPath(),
			() -> new AcaciaDrawerDisplayItem(LsFurnitureModBlocks.ACACIA_DRAWER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> BIRCH_DRAWER = REGISTRY.register(LsFurnitureModBlocks.BIRCH_DRAWER.getId().getPath(),
			() -> new BirchDrawerDisplayItem(LsFurnitureModBlocks.BIRCH_DRAWER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> JUNGLE_DRAWER = REGISTRY.register(LsFurnitureModBlocks.JUNGLE_DRAWER.getId().getPath(),
			() -> new JungleDrawerDisplayItem(LsFurnitureModBlocks.JUNGLE_DRAWER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> MANGROVE_DRAWER = REGISTRY.register(LsFurnitureModBlocks.MANGROVE_DRAWER.getId().getPath(),
			() -> new MangroveDrawerDisplayItem(LsFurnitureModBlocks.MANGROVE_DRAWER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> CRIMSON_DRAWER = REGISTRY.register(LsFurnitureModBlocks.CRIMSON_DRAWER.getId().getPath(),
			() -> new CrimsonDrawerDisplayItem(LsFurnitureModBlocks.CRIMSON_DRAWER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> WARPED_DRAWER = REGISTRY.register(LsFurnitureModBlocks.WARPED_DRAWER.getId().getPath(),
			() -> new WarpedDrawerDisplayItem(LsFurnitureModBlocks.WARPED_DRAWER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> OAK_COUNTER = REGISTRY.register(LsFurnitureModBlocks.OAK_COUNTER.getId().getPath(),
			() -> new OakCounterDisplayItem(LsFurnitureModBlocks.OAK_COUNTER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> DARK_OAK_COUNTER = REGISTRY.register(LsFurnitureModBlocks.DARK_OAK_COUNTER.getId().getPath(),
			() -> new DarkOakCounterDisplayItem(LsFurnitureModBlocks.DARK_OAK_COUNTER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> SPRUCE_COUNTER = REGISTRY.register(LsFurnitureModBlocks.SPRUCE_COUNTER.getId().getPath(),
			() -> new SpruceCounterDisplayItem(LsFurnitureModBlocks.SPRUCE_COUNTER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> ACACIA_COUNTER = REGISTRY.register(LsFurnitureModBlocks.ACACIA_COUNTER.getId().getPath(),
			() -> new AcaciaCounterDisplayItem(LsFurnitureModBlocks.ACACIA_COUNTER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> BIRCH_COUNTER = REGISTRY.register(LsFurnitureModBlocks.BIRCH_COUNTER.getId().getPath(),
			() -> new BirchCounterDisplayItem(LsFurnitureModBlocks.BIRCH_COUNTER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> JUNGLE_COUNTER = REGISTRY.register(LsFurnitureModBlocks.JUNGLE_COUNTER.getId().getPath(),
			() -> new JungleCounterDisplayItem(LsFurnitureModBlocks.JUNGLE_COUNTER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> MANGROVE_COUNTER = REGISTRY.register(LsFurnitureModBlocks.MANGROVE_COUNTER.getId().getPath(),
			() -> new MangroveCounterDisplayItem(LsFurnitureModBlocks.MANGROVE_COUNTER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> CRIMSON_COUNTER = REGISTRY.register(LsFurnitureModBlocks.CRIMSON_COUNTER.getId().getPath(),
			() -> new CrimsonCounterDisplayItem(LsFurnitureModBlocks.CRIMSON_COUNTER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> WARPED_COUNTER = REGISTRY.register(LsFurnitureModBlocks.WARPED_COUNTER.getId().getPath(),
			() -> new WarpedCounterDisplayItem(LsFurnitureModBlocks.WARPED_COUNTER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> OAK_SINK = REGISTRY.register(LsFurnitureModBlocks.OAK_SINK.getId().getPath(), () -> new OakSinkDisplayItem(LsFurnitureModBlocks.OAK_SINK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> DARK_OAK_SINK = REGISTRY.register(LsFurnitureModBlocks.DARK_OAK_SINK.getId().getPath(),
			() -> new DarkOakSinkDisplayItem(LsFurnitureModBlocks.DARK_OAK_SINK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> SPRUCE_SINK = REGISTRY.register(LsFurnitureModBlocks.SPRUCE_SINK.getId().getPath(),
			() -> new SpruceSinkDisplayItem(LsFurnitureModBlocks.SPRUCE_SINK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> ACACIA_SINK = REGISTRY.register(LsFurnitureModBlocks.ACACIA_SINK.getId().getPath(),
			() -> new AcaciaSinkDisplayItem(LsFurnitureModBlocks.ACACIA_SINK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> BIRCH_SINK = REGISTRY.register(LsFurnitureModBlocks.BIRCH_SINK.getId().getPath(),
			() -> new BirchSinkDisplayItem(LsFurnitureModBlocks.BIRCH_SINK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> JUNGLE_SINK = REGISTRY.register(LsFurnitureModBlocks.JUNGLE_SINK.getId().getPath(),
			() -> new JungleSinkDisplayItem(LsFurnitureModBlocks.JUNGLE_SINK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> MANGROVE_SINK = REGISTRY.register(LsFurnitureModBlocks.MANGROVE_SINK.getId().getPath(),
			() -> new MangroveSinkDisplayItem(LsFurnitureModBlocks.MANGROVE_SINK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> CRIMSON_SINK = REGISTRY.register(LsFurnitureModBlocks.CRIMSON_SINK.getId().getPath(),
			() -> new CrimsonSinkDisplayItem(LsFurnitureModBlocks.CRIMSON_SINK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> WARPED_SINK = REGISTRY.register(LsFurnitureModBlocks.WARPED_SINK.getId().getPath(),
			() -> new WarpedSinkDisplayItem(LsFurnitureModBlocks.WARPED_SINK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> OAK_OVEN = REGISTRY.register(LsFurnitureModBlocks.OAK_OVEN.getId().getPath(), () -> new OakOvenDisplayItem(LsFurnitureModBlocks.OAK_OVEN.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> DARK_OAK_OVEN = REGISTRY.register(LsFurnitureModBlocks.DARK_OAK_OVEN.getId().getPath(),
			() -> new DarkOakOvenDisplayItem(LsFurnitureModBlocks.DARK_OAK_OVEN.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> SPRUCE_OVEN = REGISTRY.register(LsFurnitureModBlocks.SPRUCE_OVEN.getId().getPath(),
			() -> new SpruceOvenDisplayItem(LsFurnitureModBlocks.SPRUCE_OVEN.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> ACACIA_OVEN = REGISTRY.register(LsFurnitureModBlocks.ACACIA_OVEN.getId().getPath(),
			() -> new AcaciaOvenDisplayItem(LsFurnitureModBlocks.ACACIA_OVEN.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> BIRCH_OVEN = REGISTRY.register(LsFurnitureModBlocks.BIRCH_OVEN.getId().getPath(),
			() -> new BirchOvenDisplayItem(LsFurnitureModBlocks.BIRCH_OVEN.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> JUNGLE_OVEN = REGISTRY.register(LsFurnitureModBlocks.JUNGLE_OVEN.getId().getPath(),
			() -> new JungleOvenDisplayItem(LsFurnitureModBlocks.JUNGLE_OVEN.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> MANGROVE_OVEN = REGISTRY.register(LsFurnitureModBlocks.MANGROVE_OVEN.getId().getPath(),
			() -> new MangroveOvenDisplayItem(LsFurnitureModBlocks.MANGROVE_OVEN.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> WARPED_OVEN = REGISTRY.register(LsFurnitureModBlocks.WARPED_OVEN.getId().getPath(),
			() -> new WarpedOvenDisplayItem(LsFurnitureModBlocks.WARPED_OVEN.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> CRIMSON_OVEN = REGISTRY.register(LsFurnitureModBlocks.CRIMSON_OVEN.getId().getPath(),
			() -> new CrimsonOvenDisplayItem(LsFurnitureModBlocks.CRIMSON_OVEN.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> OAK_CUPBOARD = REGISTRY.register(LsFurnitureModBlocks.OAK_CUPBOARD.getId().getPath(),
			() -> new OakCupboardDisplayItem(LsFurnitureModBlocks.OAK_CUPBOARD.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> DARK_OAK_CUPBOARD = REGISTRY.register(LsFurnitureModBlocks.DARK_OAK_CUPBOARD.getId().getPath(),
			() -> new DarkOakCupboardDisplayItem(LsFurnitureModBlocks.DARK_OAK_CUPBOARD.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> ACACIA_CUPBOARD = REGISTRY.register(LsFurnitureModBlocks.ACACIA_CUPBOARD.getId().getPath(),
			() -> new AcaciaCupboardDisplayItem(LsFurnitureModBlocks.ACACIA_CUPBOARD.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> SPRUCE_CUPBOARD = REGISTRY.register(LsFurnitureModBlocks.SPRUCE_CUPBOARD.getId().getPath(),
			() -> new SpruceCupboardDisplayItem(LsFurnitureModBlocks.SPRUCE_CUPBOARD.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> BIRCH_CUPBOARD = REGISTRY.register(LsFurnitureModBlocks.BIRCH_CUPBOARD.getId().getPath(),
			() -> new BirchCupboardDisplayItem(LsFurnitureModBlocks.BIRCH_CUPBOARD.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> JUNGLE_CUPBOARD = REGISTRY.register(LsFurnitureModBlocks.JUNGLE_CUPBOARD.getId().getPath(),
			() -> new JungleCupboardDisplayItem(LsFurnitureModBlocks.JUNGLE_CUPBOARD.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> MANGROVE_CUPBOARD = REGISTRY.register(LsFurnitureModBlocks.MANGROVE_CUPBOARD.getId().getPath(),
			() -> new MangroveCupboardDisplayItem(LsFurnitureModBlocks.MANGROVE_CUPBOARD.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> CRIMSON_CUPBOARD = REGISTRY.register(LsFurnitureModBlocks.CRIMSON_CUPBOARD.getId().getPath(),
			() -> new CrimsonCupboardDisplayItem(LsFurnitureModBlocks.CRIMSON_CUPBOARD.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> WARPED_CUPBOARD = REGISTRY.register(LsFurnitureModBlocks.WARPED_CUPBOARD.getId().getPath(),
			() -> new WarpedCupboardDisplayItem(LsFurnitureModBlocks.WARPED_CUPBOARD.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> OAK_CUPBOARD_VENT = block(LsFurnitureModBlocks.OAK_CUPBOARD_VENT, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_CUPBOARD_VENT = block(LsFurnitureModBlocks.DARK_OAK_CUPBOARD_VENT, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> SPRUCE_CUPBOARD_VENT = block(LsFurnitureModBlocks.SPRUCE_CUPBOARD_VENT, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ACACIA_CUPBOARD_VENT = block(LsFurnitureModBlocks.ACACIA_CUPBOARD_VENT, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BIRCH_CUPBOARD_VENT = block(LsFurnitureModBlocks.BIRCH_CUPBOARD_VENT, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> JUNGLE_CUPBOARD_VENT = block(LsFurnitureModBlocks.JUNGLE_CUPBOARD_VENT, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> MANGROVE_CUPBOARD_VENT = block(LsFurnitureModBlocks.MANGROVE_CUPBOARD_VENT, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CRIMSON_CUPBOARD_VENT = block(LsFurnitureModBlocks.CRIMSON_CUPBOARD_VENT, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> WARPED_CUPBOARD_VENT = block(LsFurnitureModBlocks.WARPED_CUPBOARD_VENT, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_SHELVE = block(LsFurnitureModBlocks.OAK_SHELVE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_SHELVE = block(LsFurnitureModBlocks.DARK_OAK_SHELVE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> SPRUCE_SHELVE = block(LsFurnitureModBlocks.SPRUCE_SHELVE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ACACIA_SHELVE = block(LsFurnitureModBlocks.ACACIA_SHELVE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BIRCH_SHELVE = block(LsFurnitureModBlocks.BIRCH_SHELVE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> JUNGLE_SHELVE = block(LsFurnitureModBlocks.JUNGLE_SHELVE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> MANGROVE_SHELVE = block(LsFurnitureModBlocks.MANGROVE_SHELVE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CRIMSON_SHELVE = block(LsFurnitureModBlocks.CRIMSON_SHELVE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> WARPED_SHELVE = block(LsFurnitureModBlocks.WARPED_SHELVE, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_MAIL_BOX = block(LsFurnitureModBlocks.OAK_MAIL_BOX, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_MAIL_BOX = block(LsFurnitureModBlocks.DARK_OAK_MAIL_BOX, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> SPRUCE_MAIL_BOX = block(LsFurnitureModBlocks.SPRUCE_MAIL_BOX, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ACACIA_MAIL_BOX = block(LsFurnitureModBlocks.ACACIA_MAIL_BOX, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BIRCH_MAIL_BOX = block(LsFurnitureModBlocks.BIRCH_MAIL_BOX, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> JUNGLE_MAIL_BOX = block(LsFurnitureModBlocks.JUNGLE_MAIL_BOX, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> MANGROVE_MAIL_BOX = block(LsFurnitureModBlocks.MANGROVE_MAIL_BOX, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CRIMSON_MAIL_BOX = block(LsFurnitureModBlocks.CRIMSON_MAIL_BOX, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> WARPED_MAIL_BOX = block(LsFurnitureModBlocks.WARPED_MAIL_BOX, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_BLINDS_TOP = block(LsFurnitureModBlocks.OAK_BLINDS_TOP, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> FRIDGE_FREEZER_BLOCK = REGISTRY.register(LsFurnitureModBlocks.FRIDGE_FREEZER_BLOCK.getId().getPath(),
			() -> new FridgeFreezerBlockDisplayItem(LsFurnitureModBlocks.FRIDGE_FREEZER_BLOCK.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> OVEN_VENT = block(LsFurnitureModBlocks.OVEN_VENT, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DRAINER = block(LsFurnitureModBlocks.DRAINER, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> RACK = block(LsFurnitureModBlocks.RACK, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> MICROWAVE = REGISTRY.register(LsFurnitureModBlocks.MICROWAVE.getId().getPath(), () -> new MicrowaveDisplayItem(LsFurnitureModBlocks.MICROWAVE.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> KETTLE = REGISTRY.register(LsFurnitureModBlocks.KETTLE.getId().getPath(), () -> new KettleDisplayItem(LsFurnitureModBlocks.KETTLE.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> TOASTER = REGISTRY.register(LsFurnitureModBlocks.TOASTER.getId().getPath(), () -> new ToasterDisplayItem(LsFurnitureModBlocks.TOASTER.get(), new Item.Properties().tab(LsFurnitureModTabs.TAB_TAB)));
	public static final RegistryObject<Item> BAT_TEDDY = block(LsFurnitureModBlocks.BAT_TEDDY, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLAZE_TEDDY = block(LsFurnitureModBlocks.BLAZE_TEDDY, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CHICKEN_TEDDY = block(LsFurnitureModBlocks.CHICKEN_TEDDY, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CREPPER_TEDDY = block(LsFurnitureModBlocks.CREPPER_TEDDY, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ENDERMAN_TEDDY = block(LsFurnitureModBlocks.ENDERMAN_TEDDY, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GHAST_TEDDY = block(LsFurnitureModBlocks.GHAST_TEDDY, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> IRON_GOLEM_TEDDY = block(LsFurnitureModBlocks.IRON_GOLEM_TEDDY, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> POLAR_BEAR_TEDDY = block(LsFurnitureModBlocks.POLAR_BEAR_TEDDY, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> SLIME_TEDDY = block(LsFurnitureModBlocks.SLIME_TEDDY, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> SNOW_GOLEM_TEDDY = block(LsFurnitureModBlocks.SNOW_GOLEM_TEDDY, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> HORSE_TEDDY = block(LsFurnitureModBlocks.HORSE_TEDDY, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> AXOLOTL_TEDDY = block(LsFurnitureModBlocks.AXOLOTL_TEDDY, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> COBBLESTONE_PATH_2 = block(LsFurnitureModBlocks.COBBLESTONE_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> COBBLESTONE_PATH_1 = block(LsFurnitureModBlocks.COBBLESTONE_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> COBBLESTONE_PATH_3 = block(LsFurnitureModBlocks.COBBLESTONE_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_1 = block(LsFurnitureModBlocks.STONE_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_1 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_1 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_1 = block(LsFurnitureModBlocks.ANDESITE_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_1 = block(LsFurnitureModBlocks.DIORITE_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_1 = block(LsFurnitureModBlocks.GRANITE_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_PLANK_PATH_1 = block(LsFurnitureModBlocks.OAK_PLANK_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARKOAK_PLANK_PATH_1 = block(LsFurnitureModBlocks.DARKOAK_PLANK_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> SPRUCE_PLANK_PATH_1 = block(LsFurnitureModBlocks.SPRUCE_PLANK_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ACACIA_PLANK_PATH_1 = block(LsFurnitureModBlocks.ACACIA_PLANK_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BIRCH_PLANK_PATH_1 = block(LsFurnitureModBlocks.BIRCH_PLANK_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> JUNGLE_PLANK_PATH_1 = block(LsFurnitureModBlocks.JUNGLE_PLANK_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> MANGROVE_PLANK_PATH_1 = block(LsFurnitureModBlocks.MANGROVE_PLANK_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CRIMSON_PLANK_PATH_1 = block(LsFurnitureModBlocks.CRIMSON_PLANK_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> WARPED_PLANK_PATH_1 = block(LsFurnitureModBlocks.WARPED_PLANK_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CHERRY_PLANK_PATH_1 = block(LsFurnitureModBlocks.CHERRY_PLANK_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BAMBOO_PLANK_PATH_1 = block(LsFurnitureModBlocks.BAMBOO_PLANK_PATH_1, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_2 = block(LsFurnitureModBlocks.STONE_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_2 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_2 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_2 = block(LsFurnitureModBlocks.ANDESITE_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_2 = block(LsFurnitureModBlocks.DIORITE_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_2 = block(LsFurnitureModBlocks.GRANITE_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_PLANK_PATH_2 = block(LsFurnitureModBlocks.OAK_PLANK_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_PLANK_PATH_2 = block(LsFurnitureModBlocks.DARK_OAK_PLANK_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> SPRUCE_PLANK_PATH_2 = block(LsFurnitureModBlocks.SPRUCE_PLANK_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ACACIA_PLANK_PATH_2 = block(LsFurnitureModBlocks.ACACIA_PLANK_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BIRCH_PLANK_PATH_2 = block(LsFurnitureModBlocks.BIRCH_PLANK_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> JUNGLE_PLANK_PATH_2 = block(LsFurnitureModBlocks.JUNGLE_PLANK_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> MANGROVE_PLANK_PATH_2 = block(LsFurnitureModBlocks.MANGROVE_PLANK_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CRIMSON_PLANK_PATH_2 = block(LsFurnitureModBlocks.CRIMSON_PLANK_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> WARPED_PLANK_PATH_2 = block(LsFurnitureModBlocks.WARPED_PLANK_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CHERRY_PLANK_PATH_2 = block(LsFurnitureModBlocks.CHERRY_PLANK_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BAMBOO_PLANK_PATH_2 = block(LsFurnitureModBlocks.BAMBOO_PLANK_PATH_2, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_3 = block(LsFurnitureModBlocks.STONE_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_3 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_3 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_3 = block(LsFurnitureModBlocks.ANDESITE_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_3 = block(LsFurnitureModBlocks.DIORITE_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_3 = block(LsFurnitureModBlocks.GRANITE_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_4 = block(LsFurnitureModBlocks.STONE_PATH_4, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_4 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_4, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_4 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_4, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_4 = block(LsFurnitureModBlocks.ANDESITE_PATH_4, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_4 = block(LsFurnitureModBlocks.DIORITE_PATH_4, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_4 = block(LsFurnitureModBlocks.GRANITE_PATH_4, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_5 = block(LsFurnitureModBlocks.STONE_PATH_5, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_5 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_5, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_5 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_5, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_5 = block(LsFurnitureModBlocks.ANDESITE_PATH_5, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_5 = block(LsFurnitureModBlocks.DIORITE_PATH_5, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_5 = block(LsFurnitureModBlocks.GRANITE_PATH_5, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> OAK_PLANK_PATH_3 = block(LsFurnitureModBlocks.OAK_PLANK_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_PLANK_PATH_3 = block(LsFurnitureModBlocks.DARK_OAK_PLANK_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> SPRUCE_PLANK_PATH_3 = block(LsFurnitureModBlocks.SPRUCE_PLANK_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ACACIA_PLANK_PATH_3 = block(LsFurnitureModBlocks.ACACIA_PLANK_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BIRCH_PLANK_PATH_3 = block(LsFurnitureModBlocks.BIRCH_PLANK_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> JUNGLE_PLANK_PATH_3 = block(LsFurnitureModBlocks.JUNGLE_PLANK_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> MANGROVE_PLANK_PATH_3 = block(LsFurnitureModBlocks.MANGROVE_PLANK_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CRIMSON_PLANK_PATH_3 = block(LsFurnitureModBlocks.CRIMSON_PLANK_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> WARPED_PLANK_PATH_3 = block(LsFurnitureModBlocks.WARPED_PLANK_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> CHERRY_PLANK_PATH_3 = block(LsFurnitureModBlocks.CHERRY_PLANK_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BAMBOO_PLANK_PATH_3 = block(LsFurnitureModBlocks.BAMBOO_PLANK_PATH_3, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_6 = block(LsFurnitureModBlocks.STONE_PATH_6, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_6 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_6, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_6 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_6, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_6 = block(LsFurnitureModBlocks.ANDESITE_PATH_6, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_6 = block(LsFurnitureModBlocks.DIORITE_PATH_6, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_6 = block(LsFurnitureModBlocks.GRANITE_PATH_6, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_71 = block(LsFurnitureModBlocks.STONE_PATH_71, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_71 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_71, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_71 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_71, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_71 = block(LsFurnitureModBlocks.ANDESITE_PATH_71, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_71 = block(LsFurnitureModBlocks.DIORITE_PATH_71, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_71 = block(LsFurnitureModBlocks.GRANITE_PATH_71, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_72 = block(LsFurnitureModBlocks.STONE_PATH_72, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_72 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_72, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_72 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_72, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_72 = block(LsFurnitureModBlocks.ANDESITE_PATH_72, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_72 = block(LsFurnitureModBlocks.DIORITE_PATH_72, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_72 = block(LsFurnitureModBlocks.GRANITE_PATH_72, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_73 = block(LsFurnitureModBlocks.STONE_PATH_73, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_73 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_73, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_73 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_73, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_73 = block(LsFurnitureModBlocks.ANDESITE_PATH_73, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_73 = block(LsFurnitureModBlocks.DIORITE_PATH_73, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_73 = block(LsFurnitureModBlocks.GRANITE_PATH_73, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_74 = block(LsFurnitureModBlocks.STONE_PATH_74, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_74 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_74, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_74 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_74, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_74 = block(LsFurnitureModBlocks.ANDESITE_PATH_74, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_74 = block(LsFurnitureModBlocks.DIORITE_PATH_74, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_74 = block(LsFurnitureModBlocks.GRANITE_PATH_74, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_75 = block(LsFurnitureModBlocks.STONE_PATH_75, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_75 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_75, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_75 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_75, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_75 = block(LsFurnitureModBlocks.ANDESITE_PATH_75, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_75 = block(LsFurnitureModBlocks.DIORITE_PATH_75, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_75 = block(LsFurnitureModBlocks.GRANITE_PATH_75, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_8 = block(LsFurnitureModBlocks.STONE_PATH_8, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_8 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_8, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_8 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_8, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_8 = block(LsFurnitureModBlocks.ANDESITE_PATH_8, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_8 = block(LsFurnitureModBlocks.DIORITE_PATH_8, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_8 = block(LsFurnitureModBlocks.GRANITE_PATH_8, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_91 = block(LsFurnitureModBlocks.STONE_PATH_91, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_91 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_91, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_91 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_91, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_91 = block(LsFurnitureModBlocks.ANDESITE_PATH_91, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_91 = block(LsFurnitureModBlocks.DIORITE_PATH_91, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_91 = block(LsFurnitureModBlocks.GRANITE_PATH_91, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_92 = block(LsFurnitureModBlocks.STONE_PATH_92, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_92 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_92, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_92 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_92, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_92 = block(LsFurnitureModBlocks.DIORITE_PATH_92, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_92 = block(LsFurnitureModBlocks.ANDESITE_PATH_92, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_92 = block(LsFurnitureModBlocks.GRANITE_PATH_92, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_10 = block(LsFurnitureModBlocks.STONE_PATH_10, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_10 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_10, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_10 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_10, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_10 = block(LsFurnitureModBlocks.ANDESITE_PATH_10, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_10 = block(LsFurnitureModBlocks.DIORITE_PATH_10, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_10 = block(LsFurnitureModBlocks.GRANITE_PATH_10, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_11 = block(LsFurnitureModBlocks.STONE_PATH_11, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_11 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_11, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_11 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_11, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_11 = block(LsFurnitureModBlocks.ANDESITE_PATH_11, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_11 = block(LsFurnitureModBlocks.DIORITE_PATH_11, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_11 = block(LsFurnitureModBlocks.GRANITE_PATH_11, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_12 = block(LsFurnitureModBlocks.STONE_PATH_12, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_12 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_12, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_12 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_12, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_12 = block(LsFurnitureModBlocks.ANDESITE_PATH_12, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_12 = block(LsFurnitureModBlocks.DIORITE_PATH_12, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_12 = block(LsFurnitureModBlocks.GRANITE_PATH_12, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_131 = block(LsFurnitureModBlocks.STONE_PATH_131, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_131 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_131, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_131 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_131, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_131 = block(LsFurnitureModBlocks.ANDESITE_PATH_131, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_131 = block(LsFurnitureModBlocks.DIORITE_PATH_131, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_131 = block(LsFurnitureModBlocks.GRANITE_PATH_131, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_132 = block(LsFurnitureModBlocks.STONE_PATH_132, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_132 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_132, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_132 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_132, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_132 = block(LsFurnitureModBlocks.ANDESITE_PATH_132, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_132 = block(LsFurnitureModBlocks.DIORITE_PATH_132, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_132 = block(LsFurnitureModBlocks.GRANITE_PATH_132, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> STONE_PATH_133 = block(LsFurnitureModBlocks.STONE_PATH_133, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> BLACKSTONE_PATH_133 = block(LsFurnitureModBlocks.BLACKSTONE_PATH_133, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DEEPSLATE_PATH_133 = block(LsFurnitureModBlocks.DEEPSLATE_PATH_133, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> ANDESITE_PATH_133 = block(LsFurnitureModBlocks.ANDESITE_PATH_133, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DIORITE_PATH_133 = block(LsFurnitureModBlocks.DIORITE_PATH_133, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> GRANITE_PATH_133 = block(LsFurnitureModBlocks.GRANITE_PATH_133, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> TABLE_STRAIGHT = block(LsFurnitureModBlocks.TABLE_STRAIGHT, null);
	public static final RegistryObject<Item> TABLE_CORNER = block(LsFurnitureModBlocks.TABLE_CORNER, null);
	public static final RegistryObject<Item> TABLE_JUNCTION = block(LsFurnitureModBlocks.TABLE_JUNCTION, null);
	public static final RegistryObject<Item> TABLE_CROSS = block(LsFurnitureModBlocks.TABLE_CROSS, null);
	public static final RegistryObject<Item> TABLE_END = block(LsFurnitureModBlocks.TABLE_END, null);
	public static final RegistryObject<Item> OAK_GOLD_TABLE_STRAIGHT = block(LsFurnitureModBlocks.OAK_GOLD_TABLE_STRAIGHT, null);
	public static final RegistryObject<Item> OAK_GOLD_TABLE_CORNER = block(LsFurnitureModBlocks.OAK_GOLD_TABLE_CORNER, null);
	public static final RegistryObject<Item> OAK_GOLD_TABLE_JUNCTION = block(LsFurnitureModBlocks.OAK_GOLD_TABLE_JUNCTION, null);
	public static final RegistryObject<Item> OAK_GOLD_TABLE_CROSS = block(LsFurnitureModBlocks.OAK_GOLD_TABLE_CROSS, null);
	public static final RegistryObject<Item> OAK_GOLD_TABLE_END = block(LsFurnitureModBlocks.OAK_GOLD_TABLE_END, null);
	public static final RegistryObject<Item> DARK_OAK_TABLE_STRAIGHT = block(LsFurnitureModBlocks.DARK_OAK_TABLE_STRAIGHT, null);
	public static final RegistryObject<Item> DARK_OAK_TABLE_CORNER = block(LsFurnitureModBlocks.DARK_OAK_TABLE_CORNER, null);
	public static final RegistryObject<Item> DARK_OAK_TABLE_JUNCTION = block(LsFurnitureModBlocks.DARK_OAK_TABLE_JUNCTION, null);
	public static final RegistryObject<Item> DARK_OAK_TABLE_CROSS = block(LsFurnitureModBlocks.DARK_OAK_TABLE_CROSS, null);
	public static final RegistryObject<Item> DARK_OAK_TABLE_END = block(LsFurnitureModBlocks.DARK_OAK_TABLE_END, null);
	public static final RegistryObject<Item> OAK_YELLOW_RIGHT_END = block(LsFurnitureModBlocks.OAK_YELLOW_RIGHT_END, null);
	public static final RegistryObject<Item> OAK_YELLOW_LEFT_END = block(LsFurnitureModBlocks.OAK_YELLOW_LEFT_END, null);
	public static final RegistryObject<Item> OAK_YELLOW_STRAIGHT = block(LsFurnitureModBlocks.OAK_YELLOW_STRAIGHT, null);
	public static final RegistryObject<Item> OAK_YELLOW_CORNER = block(LsFurnitureModBlocks.OAK_YELLOW_CORNER, null);
	public static final RegistryObject<Item> OAK_YELLOW_OUTER = block(LsFurnitureModBlocks.OAK_YELLOW_OUTER, null);
	public static final RegistryObject<Item> ANY_WOOL = block(LsFurnitureModBlocks.ANY_WOOL, null);
	public static final RegistryObject<Item> ANY_DYE = REGISTRY.register("any_dye", () -> new AnyDyeItem());
	public static final RegistryObject<Item> ANY_WOOD = block(LsFurnitureModBlocks.ANY_WOOD, null);
	public static final RegistryObject<Item> FRIDGE_FREEZER_BLOCK_1 = REGISTRY.register(LsFurnitureModBlocks.FRIDGE_FREEZER_BLOCK_1.getId().getPath(),
			() -> new FridgeFreezerBlock1DisplayItem(LsFurnitureModBlocks.FRIDGE_FREEZER_BLOCK_1.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> FRIDGE_FREEZER_BLOCK_2 = REGISTRY.register(LsFurnitureModBlocks.FRIDGE_FREEZER_BLOCK_2.getId().getPath(),
			() -> new FridgeFreezerBlock2DisplayItem(LsFurnitureModBlocks.FRIDGE_FREEZER_BLOCK_2.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> APPLE_PLATE = block(LsFurnitureModBlocks.APPLE_PLATE, null);
	public static final RegistryObject<Item> ANY_PLANKS = block(LsFurnitureModBlocks.ANY_PLANKS, null);
	public static final RegistryObject<Item> ANY_INGOT = REGISTRY.register("any_ingot", () -> new AnyIngotItem());
	public static final RegistryObject<Item> OAK_IRON_TABLE_CORNER = block(LsFurnitureModBlocks.OAK_IRON_TABLE_CORNER, null);
	public static final RegistryObject<Item> OAK_IRON_TABLE_JUNCTION = block(LsFurnitureModBlocks.OAK_IRON_TABLE_JUNCTION, null);
	public static final RegistryObject<Item> OAK_IRON_TABLE_CROSS = block(LsFurnitureModBlocks.OAK_IRON_TABLE_CROSS, null);
	public static final RegistryObject<Item> OAK_IRON_TABLE_END = block(LsFurnitureModBlocks.OAK_IRON_TABLE_END, null);
	public static final RegistryObject<Item> OAK_IRON_TABLE_STRAIGHT = block(LsFurnitureModBlocks.OAK_IRON_TABLE_STRAIGHT, null);
	public static final RegistryObject<Item> COMPUTER_ON = block(LsFurnitureModBlocks.COMPUTER_ON, null);
	public static final RegistryObject<Item> COMPUTER_MINECRAFT = block(LsFurnitureModBlocks.COMPUTER_MINECRAFT, null);
	public static final RegistryObject<Item> COMPUTER_COD = block(LsFurnitureModBlocks.COMPUTER_COD, null);
	public static final RegistryObject<Item> DRAINER_PLATE = block(LsFurnitureModBlocks.DRAINER_PLATE, null);
	public static final RegistryObject<Item> DRANIER_1_PLATE = block(LsFurnitureModBlocks.DRANIER_1_PLATE, null);
	public static final RegistryObject<Item> DRAINER_2_PLATES = block(LsFurnitureModBlocks.DRAINER_2_PLATES, null);
	public static final RegistryObject<Item> OAK_WARDROBE_1 = REGISTRY.register(LsFurnitureModBlocks.OAK_WARDROBE_1.getId().getPath(), () -> new OakWardrobe1DisplayItem(LsFurnitureModBlocks.OAK_WARDROBE_1.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> OAK_WARDROBE_2 = REGISTRY.register(LsFurnitureModBlocks.OAK_WARDROBE_2.getId().getPath(), () -> new OakWardrobe2DisplayItem(LsFurnitureModBlocks.OAK_WARDROBE_2.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> DARKOAKWARDROBE_1 = REGISTRY.register(LsFurnitureModBlocks.DARKOAKWARDROBE_1.getId().getPath(),
			() -> new Darkoakwardrobe1DisplayItem(LsFurnitureModBlocks.DARKOAKWARDROBE_1.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> DARKOAKWARDROBE_2 = REGISTRY.register(LsFurnitureModBlocks.DARKOAKWARDROBE_2.getId().getPath(),
			() -> new Darkoakwardrobe2DisplayItem(LsFurnitureModBlocks.DARKOAKWARDROBE_2.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> SPRUCE_WARDROBE_1 = REGISTRY.register(LsFurnitureModBlocks.SPRUCE_WARDROBE_1.getId().getPath(),
			() -> new SpruceWardrobe1DisplayItem(LsFurnitureModBlocks.SPRUCE_WARDROBE_1.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> SPRUCE_WARDROBE_2 = REGISTRY.register(LsFurnitureModBlocks.SPRUCE_WARDROBE_2.getId().getPath(),
			() -> new SpruceWardrobe2DisplayItem(LsFurnitureModBlocks.SPRUCE_WARDROBE_2.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> ACACIA_WARDROBE_1 = REGISTRY.register(LsFurnitureModBlocks.ACACIA_WARDROBE_1.getId().getPath(),
			() -> new AcaciaWardrobe1DisplayItem(LsFurnitureModBlocks.ACACIA_WARDROBE_1.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> ACACIA_WARDROBE_2 = REGISTRY.register(LsFurnitureModBlocks.ACACIA_WARDROBE_2.getId().getPath(),
			() -> new AcaciaWardrobe2DisplayItem(LsFurnitureModBlocks.ACACIA_WARDROBE_2.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> BIRCH_WARDROBE_1 = REGISTRY.register(LsFurnitureModBlocks.BIRCH_WARDROBE_1.getId().getPath(),
			() -> new BirchWardrobe1DisplayItem(LsFurnitureModBlocks.BIRCH_WARDROBE_1.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> BIRCH_WARDROBE_2 = REGISTRY.register(LsFurnitureModBlocks.BIRCH_WARDROBE_2.getId().getPath(),
			() -> new BirchWardrobe2DisplayItem(LsFurnitureModBlocks.BIRCH_WARDROBE_2.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> JUNGLE_WARDROBE_1 = REGISTRY.register(LsFurnitureModBlocks.JUNGLE_WARDROBE_1.getId().getPath(),
			() -> new JungleWardrobe1DisplayItem(LsFurnitureModBlocks.JUNGLE_WARDROBE_1.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> JUNGLE_WARDROBE_2 = REGISTRY.register(LsFurnitureModBlocks.JUNGLE_WARDROBE_2.getId().getPath(),
			() -> new JungleWardrobe2DisplayItem(LsFurnitureModBlocks.JUNGLE_WARDROBE_2.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> MANGROVE_WARDROBE_1 = REGISTRY.register(LsFurnitureModBlocks.MANGROVE_WARDROBE_1.getId().getPath(),
			() -> new MangroveWardrobe1DisplayItem(LsFurnitureModBlocks.MANGROVE_WARDROBE_1.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> MANGROVE_WARDROBE_2 = REGISTRY.register(LsFurnitureModBlocks.MANGROVE_WARDROBE_2.getId().getPath(),
			() -> new MangroveWardrobe2DisplayItem(LsFurnitureModBlocks.MANGROVE_WARDROBE_2.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> CRIMSON_WARDROBE_1 = REGISTRY.register(LsFurnitureModBlocks.CRIMSON_WARDROBE_1.getId().getPath(),
			() -> new CrimsonWardrobe1DisplayItem(LsFurnitureModBlocks.CRIMSON_WARDROBE_1.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> CRIMSON_WARDROBE_2 = REGISTRY.register(LsFurnitureModBlocks.CRIMSON_WARDROBE_2.getId().getPath(),
			() -> new CrimsonWardrobe2DisplayItem(LsFurnitureModBlocks.CRIMSON_WARDROBE_2.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> WARPED_WARDROBE_1 = REGISTRY.register(LsFurnitureModBlocks.WARPED_WARDROBE_1.getId().getPath(),
			() -> new WarpedWardrobe1DisplayItem(LsFurnitureModBlocks.WARPED_WARDROBE_1.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> WARPED_WARDROBE_2 = REGISTRY.register(LsFurnitureModBlocks.WARPED_WARDROBE_2.getId().getPath(),
			() -> new WarpedWardrobe2DisplayItem(LsFurnitureModBlocks.WARPED_WARDROBE_2.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> OAK_WHITE_RIGHT_END = block(LsFurnitureModBlocks.OAK_WHITE_RIGHT_END, null);
	public static final RegistryObject<Item> OAK_WHITE_LEFT_END = block(LsFurnitureModBlocks.OAK_WHITE_LEFT_END, null);
	public static final RegistryObject<Item> OAK_WHITE_STRAIGHT = block(LsFurnitureModBlocks.OAK_WHITE_STRAIGHT, null);
	public static final RegistryObject<Item> OAK_WHITE_CORNER = block(LsFurnitureModBlocks.OAK_WHITE_CORNER, null);
	public static final RegistryObject<Item> IRON_STRAIGHT = block(LsFurnitureModBlocks.IRON_STRAIGHT, null);
	public static final RegistryObject<Item> IRON_JUNCTION = block(LsFurnitureModBlocks.IRON_JUNCTION, null);
	public static final RegistryObject<Item> IRON_CORNER = block(LsFurnitureModBlocks.IRON_CORNER, null);
	public static final RegistryObject<Item> IRON_END = block(LsFurnitureModBlocks.IRON_END, null);
	public static final RegistryObject<Item> IRON_CROSS = block(LsFurnitureModBlocks.IRON_CROSS, null);
	public static final RegistryObject<Item> OVEN_VENT_ON = block(LsFurnitureModBlocks.OVEN_VENT_ON, null);
	public static final RegistryObject<Item> OAK_CUPBOARD_VENT_ON = block(LsFurnitureModBlocks.OAK_CUPBOARD_VENT_ON, null);
	public static final RegistryObject<Item> OAK_CUPBOARD_CORNER = block(LsFurnitureModBlocks.OAK_CUPBOARD_CORNER, null);
	public static final RegistryObject<Item> OAK_COUNTER_CORNER = block(LsFurnitureModBlocks.OAK_COUNTER_CORNER, null);
	public static final RegistryObject<Item> DARK_OAK_COUNTER_CORNER = block(LsFurnitureModBlocks.DARK_OAK_COUNTER_CORNER, null);
	public static final RegistryObject<Item> SPRUCE_COUNTER_CORNER = block(LsFurnitureModBlocks.SPRUCE_COUNTER_CORNER, null);
	public static final RegistryObject<Item> ACACIA_COUNTER_CORNER = block(LsFurnitureModBlocks.ACACIA_COUNTER_CORNER, null);
	public static final RegistryObject<Item> BIRCH_COUNTER_CORNER = block(LsFurnitureModBlocks.BIRCH_COUNTER_CORNER, null);
	public static final RegistryObject<Item> JUNGLE_COUNTER_CORNER = block(LsFurnitureModBlocks.JUNGLE_COUNTER_CORNER, null);
	public static final RegistryObject<Item> MANGROVE_COUNTER_CORNER = block(LsFurnitureModBlocks.MANGROVE_COUNTER_CORNER, null);
	public static final RegistryObject<Item> CRIMSON_COUNTER_CORNER = block(LsFurnitureModBlocks.CRIMSON_COUNTER_CORNER, null);
	public static final RegistryObject<Item> WARPED_COUNTER_CORNER = block(LsFurnitureModBlocks.WARPED_COUNTER_CORNER, null);
	public static final RegistryObject<Item> DARK_OAK_CUPBOARD_VENT_ON = block(LsFurnitureModBlocks.DARK_OAK_CUPBOARD_VENT_ON, null);
	public static final RegistryObject<Item> SPRUCE_CUPBOARD_VENT_ON = block(LsFurnitureModBlocks.SPRUCE_CUPBOARD_VENT_ON, null);
	public static final RegistryObject<Item> ACACIA_CUPBOARD_VENT_ON = block(LsFurnitureModBlocks.ACACIA_CUPBOARD_VENT_ON, null);
	public static final RegistryObject<Item> BIRCH_CUPBOARD_VENT_ON = block(LsFurnitureModBlocks.BIRCH_CUPBOARD_VENT_ON, null);
	public static final RegistryObject<Item> JUNGLE_CUPBOARD_VENT_ON = block(LsFurnitureModBlocks.JUNGLE_CUPBOARD_VENT_ON, null);
	public static final RegistryObject<Item> MANGROVE_CUPBOARD_VENT_ON = block(LsFurnitureModBlocks.MANGROVE_CUPBOARD_VENT_ON, null);
	public static final RegistryObject<Item> CRIMSON_CUPBOARD_VENT_ON = block(LsFurnitureModBlocks.CRIMSON_CUPBOARD_VENT_ON, null);
	public static final RegistryObject<Item> WARPED_CUPBOARD_VENT_ON = block(LsFurnitureModBlocks.WARPED_CUPBOARD_VENT_ON, null);
	public static final RegistryObject<Item> DARK_OAK_CUPBOARD_CORNER = block(LsFurnitureModBlocks.DARK_OAK_CUPBOARD_CORNER, null);
	public static final RegistryObject<Item> ACACIA_CUPBOARD_CORNER = block(LsFurnitureModBlocks.ACACIA_CUPBOARD_CORNER, null);
	public static final RegistryObject<Item> SPRUCE_CUPBOARD_CORNER = block(LsFurnitureModBlocks.SPRUCE_CUPBOARD_CORNER, null);
	public static final RegistryObject<Item> BIRCH_CUPBOARD_CORNER = block(LsFurnitureModBlocks.BIRCH_CUPBOARD_CORNER, null);
	public static final RegistryObject<Item> JUNGLE_CUPBOARD_CORNER = block(LsFurnitureModBlocks.JUNGLE_CUPBOARD_CORNER, null);
	public static final RegistryObject<Item> MANGROVE_CUPBOARD_CORNER = block(LsFurnitureModBlocks.MANGROVE_CUPBOARD_CORNER, null);
	public static final RegistryObject<Item> CRIMSON_CUPBOARD_CORNER = block(LsFurnitureModBlocks.CRIMSON_CUPBOARD_CORNER, null);
	public static final RegistryObject<Item> WARPED_CUPBOARD_CORNER = block(LsFurnitureModBlocks.WARPED_CUPBOARD_CORNER, null);
	public static final RegistryObject<Item> ANY_STONE = block(LsFurnitureModBlocks.ANY_STONE, null);
	public static final RegistryObject<Item> ANY_STONE_PLANK = block(LsFurnitureModBlocks.ANY_STONE_PLANK, null);
	public static final RegistryObject<Item> DARK_OAK_WHITE_RIGHT_END = block(LsFurnitureModBlocks.DARK_OAK_WHITE_RIGHT_END, null);
	public static final RegistryObject<Item> DARK_OAK_WHITE_LEFT_END = block(LsFurnitureModBlocks.DARK_OAK_WHITE_LEFT_END, null);
	public static final RegistryObject<Item> DARK_OAK_WHITE_STRAIGHT = block(LsFurnitureModBlocks.DARK_OAK_WHITE_STRAIGHT, null);
	public static final RegistryObject<Item> DARK_OAK_WHITE_CORNER = block(LsFurnitureModBlocks.DARK_OAK_WHITE_CORNER, null);
	public static final RegistryObject<Item> SPRUCE_WHITE_RIGHT_END = block(LsFurnitureModBlocks.SPRUCE_WHITE_RIGHT_END, null);
	public static final RegistryObject<Item> SPRUCE_WHITE_LEFT_END = block(LsFurnitureModBlocks.SPRUCE_WHITE_LEFT_END, null);
	public static final RegistryObject<Item> SPRUCE_WHITE_STRAIGHT = block(LsFurnitureModBlocks.SPRUCE_WHITE_STRAIGHT, null);
	public static final RegistryObject<Item> SPRUCE_WHITE_CORNER = block(LsFurnitureModBlocks.SPRUCE_WHITE_CORNER, null);
	public static final RegistryObject<Item> ACACIA_WHITE_RIGHT_END = block(LsFurnitureModBlocks.ACACIA_WHITE_RIGHT_END, null);
	public static final RegistryObject<Item> ACACIA_WHITE_LEFT_END = block(LsFurnitureModBlocks.ACACIA_WHITE_LEFT_END, null);
	public static final RegistryObject<Item> ACACIA_WHITE_STARIGHT = block(LsFurnitureModBlocks.ACACIA_WHITE_STARIGHT, null);
	public static final RegistryObject<Item> ACACIA_WHITE_CORNER = block(LsFurnitureModBlocks.ACACIA_WHITE_CORNER, null);
	public static final RegistryObject<Item> BIRCH_WHITE_RIGHT_END = block(LsFurnitureModBlocks.BIRCH_WHITE_RIGHT_END, null);
	public static final RegistryObject<Item> BIRCH_WHITE_LEFT_END = block(LsFurnitureModBlocks.BIRCH_WHITE_LEFT_END, null);
	public static final RegistryObject<Item> BIRCH_WHITE_STARIGHT = block(LsFurnitureModBlocks.BIRCH_WHITE_STARIGHT, null);
	public static final RegistryObject<Item> BIRCH_WHITE_CORNER = block(LsFurnitureModBlocks.BIRCH_WHITE_CORNER, null);
	public static final RegistryObject<Item> JUNGLE_WHITE_RIGHT_END = block(LsFurnitureModBlocks.JUNGLE_WHITE_RIGHT_END, null);
	public static final RegistryObject<Item> JUNGLE_WHITE_LEFT_END = block(LsFurnitureModBlocks.JUNGLE_WHITE_LEFT_END, null);
	public static final RegistryObject<Item> JUNGLE_WHITE_STRAIGHT = block(LsFurnitureModBlocks.JUNGLE_WHITE_STRAIGHT, null);
	public static final RegistryObject<Item> JUNGLE_WHITE_CORNER = block(LsFurnitureModBlocks.JUNGLE_WHITE_CORNER, null);
	public static final RegistryObject<Item> MANGROVE_WHITE_RIGHT_END = block(LsFurnitureModBlocks.MANGROVE_WHITE_RIGHT_END, null);
	public static final RegistryObject<Item> MANGROVE_WHITE_LEFT_END = block(LsFurnitureModBlocks.MANGROVE_WHITE_LEFT_END, null);
	public static final RegistryObject<Item> MANGROVE_WHITE_STRAIGHT = block(LsFurnitureModBlocks.MANGROVE_WHITE_STRAIGHT, null);
	public static final RegistryObject<Item> MANGROVE_WHITE_CORNER = block(LsFurnitureModBlocks.MANGROVE_WHITE_CORNER, null);
	public static final RegistryObject<Item> CRIMSON_WHITE_RIGHT_END = block(LsFurnitureModBlocks.CRIMSON_WHITE_RIGHT_END, null);
	public static final RegistryObject<Item> CRIMSON_WHITE_LEFT_END = block(LsFurnitureModBlocks.CRIMSON_WHITE_LEFT_END, null);
	public static final RegistryObject<Item> CRIMSON_WHITE_STRAIGHT = block(LsFurnitureModBlocks.CRIMSON_WHITE_STRAIGHT, null);
	public static final RegistryObject<Item> CRIMSON_WHITE_CORNER = block(LsFurnitureModBlocks.CRIMSON_WHITE_CORNER, null);
	public static final RegistryObject<Item> WARPED_WHITE_RIGHT_END = block(LsFurnitureModBlocks.WARPED_WHITE_RIGHT_END, null);
	public static final RegistryObject<Item> WARPED_WHITE_LEFT_END = block(LsFurnitureModBlocks.WARPED_WHITE_LEFT_END, null);
	public static final RegistryObject<Item> WARPED_WHITE_STRAIGHT = block(LsFurnitureModBlocks.WARPED_WHITE_STRAIGHT, null);
	public static final RegistryObject<Item> WARPED_WHITE_CORNER = block(LsFurnitureModBlocks.WARPED_WHITE_CORNER, null);
	public static final RegistryObject<Item> SPRUCE_TABLE_STRAIGHT = block(LsFurnitureModBlocks.SPRUCE_TABLE_STRAIGHT, null);
	public static final RegistryObject<Item> SPRUCE_TABLE_CORNER = block(LsFurnitureModBlocks.SPRUCE_TABLE_CORNER, null);
	public static final RegistryObject<Item> SPRUCE_TABLE_JUNCTION = block(LsFurnitureModBlocks.SPRUCE_TABLE_JUNCTION, null);
	public static final RegistryObject<Item> SPRUCE_TABLE_CROSS = block(LsFurnitureModBlocks.SPRUCE_TABLE_CROSS, null);
	public static final RegistryObject<Item> SPRUCE_TABLE_END = block(LsFurnitureModBlocks.SPRUCE_TABLE_END, null);
	public static final RegistryObject<Item> ACACIA_TABLE_STRAIGHT = block(LsFurnitureModBlocks.ACACIA_TABLE_STRAIGHT, null);
	public static final RegistryObject<Item> ACACIA_TABLE_CORNER = block(LsFurnitureModBlocks.ACACIA_TABLE_CORNER, null);
	public static final RegistryObject<Item> ACACIA_TABLE_JUNCTION = block(LsFurnitureModBlocks.ACACIA_TABLE_JUNCTION, null);
	public static final RegistryObject<Item> ACACIA_TABLE_CROSS = block(LsFurnitureModBlocks.ACACIA_TABLE_CROSS, null);
	public static final RegistryObject<Item> ACACIA_TABLE_END = block(LsFurnitureModBlocks.ACACIA_TABLE_END, null);
	public static final RegistryObject<Item> BIRCH_TABLE_STRAIGHT = block(LsFurnitureModBlocks.BIRCH_TABLE_STRAIGHT, null);
	public static final RegistryObject<Item> BIRCH_TABLE_CORNER = block(LsFurnitureModBlocks.BIRCH_TABLE_CORNER, null);
	public static final RegistryObject<Item> BIRCH_TABLE_JUNCTION = block(LsFurnitureModBlocks.BIRCH_TABLE_JUNCTION, null);
	public static final RegistryObject<Item> BIRCH_TABLE_CROSS = block(LsFurnitureModBlocks.BIRCH_TABLE_CROSS, null);
	public static final RegistryObject<Item> BIRCH_TABLE_END = block(LsFurnitureModBlocks.BIRCH_TABLE_END, null);
	public static final RegistryObject<Item> JUNGLE_TABLE_STRAIGHT = block(LsFurnitureModBlocks.JUNGLE_TABLE_STRAIGHT, null);
	public static final RegistryObject<Item> JUNGLE_TABLE_CORNER = block(LsFurnitureModBlocks.JUNGLE_TABLE_CORNER, null);
	public static final RegistryObject<Item> JUNGLE_TABLE_JUNCTION = block(LsFurnitureModBlocks.JUNGLE_TABLE_JUNCTION, null);
	public static final RegistryObject<Item> JUNGLE_TABLE_CROSS = block(LsFurnitureModBlocks.JUNGLE_TABLE_CROSS, null);
	public static final RegistryObject<Item> JUNGLE_TABLE_END = block(LsFurnitureModBlocks.JUNGLE_TABLE_END, null);
	public static final RegistryObject<Item> MANGROVE_TABLE_STRAIGHT = block(LsFurnitureModBlocks.MANGROVE_TABLE_STRAIGHT, null);
	public static final RegistryObject<Item> MANGROVE_TABLE_CORNER = block(LsFurnitureModBlocks.MANGROVE_TABLE_CORNER, null);
	public static final RegistryObject<Item> MANGROVE_TABLE_JUNCTION = block(LsFurnitureModBlocks.MANGROVE_TABLE_JUNCTION, null);
	public static final RegistryObject<Item> MANGROVE_TABLE_CROSS = block(LsFurnitureModBlocks.MANGROVE_TABLE_CROSS, null);
	public static final RegistryObject<Item> MANGROVE_TABLE_END = block(LsFurnitureModBlocks.MANGROVE_TABLE_END, null);
	public static final RegistryObject<Item> CRIMSON_TABLE_STRAIGHT = block(LsFurnitureModBlocks.CRIMSON_TABLE_STRAIGHT, null);
	public static final RegistryObject<Item> CRIMSON_TABLE_CORNER = block(LsFurnitureModBlocks.CRIMSON_TABLE_CORNER, null);
	public static final RegistryObject<Item> CRIMSON_TABLE_JUNCTION = block(LsFurnitureModBlocks.CRIMSON_TABLE_JUNCTION, null);
	public static final RegistryObject<Item> CRIMSON_TABLE_CROSS = block(LsFurnitureModBlocks.CRIMSON_TABLE_CROSS, null);
	public static final RegistryObject<Item> CRIMSON_TABLE_END = block(LsFurnitureModBlocks.CRIMSON_TABLE_END, null);
	public static final RegistryObject<Item> WARPED_TABLE_STRAIGHT = block(LsFurnitureModBlocks.WARPED_TABLE_STRAIGHT, null);
	public static final RegistryObject<Item> WARPED_TABLE_CORNER = block(LsFurnitureModBlocks.WARPED_TABLE_CORNER, null);
	public static final RegistryObject<Item> WARPED_TABLE_JUNCTION = block(LsFurnitureModBlocks.WARPED_TABLE_JUNCTION, null);
	public static final RegistryObject<Item> WARPED_TABLE_CROSS = block(LsFurnitureModBlocks.WARPED_TABLE_CROSS, null);
	public static final RegistryObject<Item> WARPED_TABLE_END = block(LsFurnitureModBlocks.WARPED_TABLE_END, null);
	public static final RegistryObject<Item> OAK_BLINDS_BOTTOM = block(LsFurnitureModBlocks.OAK_BLINDS_BOTTOM, null);
	public static final RegistryObject<Item> OAK_BLINDS_TOP_CLOSED = block(LsFurnitureModBlocks.OAK_BLINDS_TOP_CLOSED, null);
	public static final RegistryObject<Item> OAK_BLINDS_BOTTOM_CLOSED = block(LsFurnitureModBlocks.OAK_BLINDS_BOTTOM_CLOSED, null);
	public static final RegistryObject<Item> TV_STAND_ON = block(LsFurnitureModBlocks.TV_STAND_ON, null);
	public static final RegistryObject<Item> TV_STAND_MINECRAFT = block(LsFurnitureModBlocks.TV_STAND_MINECRAFT, null);
	public static final RegistryObject<Item> TV_STAND_COD = block(LsFurnitureModBlocks.TV_STAND_COD, null);
	public static final RegistryObject<Item> TV_WALL_OFF = block(LsFurnitureModBlocks.TV_WALL_OFF, null);
	public static final RegistryObject<Item> TV_WALL_ON = block(LsFurnitureModBlocks.TV_WALL_ON, null);
	public static final RegistryObject<Item> TV_WALL_MINECRAFT = block(LsFurnitureModBlocks.TV_WALL_MINECRAFT, null);
	public static final RegistryObject<Item> TV_WALL_COD = block(LsFurnitureModBlocks.TV_WALL_COD, null);
	public static final RegistryObject<Item> DARK_OAK_BLINDS_TOP = block(LsFurnitureModBlocks.DARK_OAK_BLINDS_TOP, LsFurnitureModTabs.TAB_TAB);
	public static final RegistryObject<Item> DARK_OAK_BLINDS_BOTTOM = block(LsFurnitureModBlocks.DARK_OAK_BLINDS_BOTTOM, null);
	public static final RegistryObject<Item> DARK_OAK_BLINDS_TOP_CLOSED = block(LsFurnitureModBlocks.DARK_OAK_BLINDS_TOP_CLOSED, null);
	public static final RegistryObject<Item> DARK_OAK_BLINDS_BOTTOM_CLOSED = block(LsFurnitureModBlocks.DARK_OAK_BLINDS_BOTTOM_CLOSED, null);
	public static final RegistryObject<Item> CHISEL = REGISTRY.register("chisel", () -> new ChiselItem());
	public static final RegistryObject<Item> TEST = block(LsFurnitureModBlocks.TEST, LsFurnitureModTabs.TAB_TAB);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
