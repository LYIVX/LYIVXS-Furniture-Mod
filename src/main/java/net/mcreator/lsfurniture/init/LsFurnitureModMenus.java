
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lsfurniture.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.lsfurniture.world.inventory.WeaveryGUIMenu;
import net.mcreator.lsfurniture.world.inventory.WardrobeDrawersMenu;
import net.mcreator.lsfurniture.world.inventory.WardrobeCupboardMenu;
import net.mcreator.lsfurniture.world.inventory.ShelveMenu;
import net.mcreator.lsfurniture.world.inventory.OvenMenu;
import net.mcreator.lsfurniture.world.inventory.MetalurgyGUIMenu;
import net.mcreator.lsfurniture.world.inventory.MasonryGUIMenu;
import net.mcreator.lsfurniture.world.inventory.MailBoxMenu;
import net.mcreator.lsfurniture.world.inventory.GlassblowerGUIMenu;
import net.mcreator.lsfurniture.world.inventory.FridgeMenu;
import net.mcreator.lsfurniture.world.inventory.FreezerMenu;
import net.mcreator.lsfurniture.world.inventory.EngineeringGUIMenu;
import net.mcreator.lsfurniture.world.inventory.DrawerMenu;
import net.mcreator.lsfurniture.world.inventory.DeskMenu;
import net.mcreator.lsfurniture.world.inventory.CupboardMenu;
import net.mcreator.lsfurniture.world.inventory.CounterMenu;
import net.mcreator.lsfurniture.world.inventory.CarpentryGUIMenu;
import net.mcreator.lsfurniture.world.inventory.Carpentry2GUIMenu;
import net.mcreator.lsfurniture.world.inventory.BotanistGUIMenu;
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
	public static final RegistryObject<MenuType<CarpentryGUIMenu>> CARPENTRY_GUI = REGISTRY.register("carpentry_gui", () -> IForgeMenuType.create(CarpentryGUIMenu::new));
	public static final RegistryObject<MenuType<MasonryGUIMenu>> MASONRY_GUI = REGISTRY.register("masonry_gui", () -> IForgeMenuType.create(MasonryGUIMenu::new));
	public static final RegistryObject<MenuType<MetalurgyGUIMenu>> METALURGY_GUI = REGISTRY.register("metalurgy_gui", () -> IForgeMenuType.create(MetalurgyGUIMenu::new));
	public static final RegistryObject<MenuType<WeaveryGUIMenu>> WEAVERY_GUI = REGISTRY.register("weavery_gui", () -> IForgeMenuType.create(WeaveryGUIMenu::new));
	public static final RegistryObject<MenuType<EngineeringGUIMenu>> ENGINEERING_GUI = REGISTRY.register("engineering_gui", () -> IForgeMenuType.create(EngineeringGUIMenu::new));
	public static final RegistryObject<MenuType<GlassblowerGUIMenu>> GLASSBLOWER_GUI = REGISTRY.register("glassblower_gui", () -> IForgeMenuType.create(GlassblowerGUIMenu::new));
	public static final RegistryObject<MenuType<BotanistGUIMenu>> BOTANIST_GUI = REGISTRY.register("botanist_gui", () -> IForgeMenuType.create(BotanistGUIMenu::new));
	public static final RegistryObject<MenuType<Carpentry2GUIMenu>> CARPENTRY_2_GUI = REGISTRY.register("carpentry_2_gui", () -> IForgeMenuType.create(Carpentry2GUIMenu::new));
}
