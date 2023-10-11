
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lsfurniture.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.lsfurniture.world.inventory.WoodGUIMenu;
import net.mcreator.lsfurniture.world.inventory.WardrobeDrawersMenu;
import net.mcreator.lsfurniture.world.inventory.WardrobeCupboardMenu;
import net.mcreator.lsfurniture.world.inventory.TeddysGUIMenu;
import net.mcreator.lsfurniture.world.inventory.ShelveMenu;
import net.mcreator.lsfurniture.world.inventory.OvenMenu;
import net.mcreator.lsfurniture.world.inventory.MetalGUIMenu;
import net.mcreator.lsfurniture.world.inventory.MailBoxMenu;
import net.mcreator.lsfurniture.world.inventory.FridgeMenu;
import net.mcreator.lsfurniture.world.inventory.FreezerMenu;
import net.mcreator.lsfurniture.world.inventory.DrawerMenu;
import net.mcreator.lsfurniture.world.inventory.DeskMenu;
import net.mcreator.lsfurniture.world.inventory.DecorationsGUIMenu;
import net.mcreator.lsfurniture.world.inventory.CupboardMenu;
import net.mcreator.lsfurniture.world.inventory.CounterMenu;
import net.mcreator.lsfurniture.world.inventory.ChiselGUIMenu;
import net.mcreator.lsfurniture.LsFurnitureMod;

public class LsFurnitureModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, LsFurnitureMod.MODID);
	public static final RegistryObject<MenuType<DeskMenu>> DESK = REGISTRY.register("desk", () -> IForgeMenuType.create(DeskMenu::new));
	public static final RegistryObject<MenuType<DrawerMenu>> DRAWER = REGISTRY.register("drawer", () -> IForgeMenuType.create(DrawerMenu::new));
	public static final RegistryObject<MenuType<ShelveMenu>> SHELVE = REGISTRY.register("shelve", () -> IForgeMenuType.create(ShelveMenu::new));
	public static final RegistryObject<MenuType<CounterMenu>> COUNTER = REGISTRY.register("counter", () -> IForgeMenuType.create(CounterMenu::new));
	public static final RegistryObject<MenuType<OvenMenu>> OVEN = REGISTRY.register("oven", () -> IForgeMenuType.create(OvenMenu::new));
	public static final RegistryObject<MenuType<FridgeMenu>> FRIDGE = REGISTRY.register("fridge", () -> IForgeMenuType.create(FridgeMenu::new));
	public static final RegistryObject<MenuType<FreezerMenu>> FREEZER = REGISTRY.register("freezer", () -> IForgeMenuType.create(FreezerMenu::new));
	public static final RegistryObject<MenuType<WardrobeDrawersMenu>> WARDROBE_DRAWERS = REGISTRY.register("wardrobe_drawers", () -> IForgeMenuType.create(WardrobeDrawersMenu::new));
	public static final RegistryObject<MenuType<WardrobeCupboardMenu>> WARDROBE_CUPBOARD = REGISTRY.register("wardrobe_cupboard", () -> IForgeMenuType.create(WardrobeCupboardMenu::new));
	public static final RegistryObject<MenuType<MailBoxMenu>> MAIL_BOX = REGISTRY.register("mail_box", () -> IForgeMenuType.create(MailBoxMenu::new));
	public static final RegistryObject<MenuType<CupboardMenu>> CUPBOARD = REGISTRY.register("cupboard", () -> IForgeMenuType.create(CupboardMenu::new));
	public static final RegistryObject<MenuType<WoodGUIMenu>> WOOD_GUI = REGISTRY.register("wood_gui", () -> IForgeMenuType.create(WoodGUIMenu::new));
	public static final RegistryObject<MenuType<MetalGUIMenu>> METAL_GUI = REGISTRY.register("metal_gui", () -> IForgeMenuType.create(MetalGUIMenu::new));
	public static final RegistryObject<MenuType<DecorationsGUIMenu>> DECORATIONS_GUI = REGISTRY.register("decorations_gui", () -> IForgeMenuType.create(DecorationsGUIMenu::new));
	public static final RegistryObject<MenuType<TeddysGUIMenu>> TEDDYS_GUI = REGISTRY.register("teddys_gui", () -> IForgeMenuType.create(TeddysGUIMenu::new));
	public static final RegistryObject<MenuType<ChiselGUIMenu>> CHISEL_GUI = REGISTRY.register("chisel_gui", () -> IForgeMenuType.create(ChiselGUIMenu::new));
}
