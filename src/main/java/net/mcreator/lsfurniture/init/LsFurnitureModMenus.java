
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lsfurniture.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.lsfurniture.world.inventory.WardrobeDrawersMenu;
import net.mcreator.lsfurniture.world.inventory.WardrobeCupboardMenu;
import net.mcreator.lsfurniture.world.inventory.ShelveMenu;
import net.mcreator.lsfurniture.world.inventory.RecipeExplainerMenu;
import net.mcreator.lsfurniture.world.inventory.OvenMenu;
import net.mcreator.lsfurniture.world.inventory.MailBoxMenu;
import net.mcreator.lsfurniture.world.inventory.FurnitureWoodMenu;
import net.mcreator.lsfurniture.world.inventory.FurnitureTeddysMenu;
import net.mcreator.lsfurniture.world.inventory.FurnitureMetalMenu;
import net.mcreator.lsfurniture.world.inventory.FurnitureDecorationsMenu;
import net.mcreator.lsfurniture.world.inventory.FurnitureChiselMenu;
import net.mcreator.lsfurniture.world.inventory.FridgeMenu;
import net.mcreator.lsfurniture.world.inventory.FreezerMenu;
import net.mcreator.lsfurniture.world.inventory.DrawerMenu;
import net.mcreator.lsfurniture.world.inventory.DeskMenu;
import net.mcreator.lsfurniture.world.inventory.CupboardMenu;
import net.mcreator.lsfurniture.world.inventory.CounterMenu;
import net.mcreator.lsfurniture.LsFurnitureMod;

public class LsFurnitureModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, LsFurnitureMod.MODID);
	public static final RegistryObject<MenuType<DeskMenu>> DESK = REGISTRY.register("desk", () -> IForgeMenuType.create(DeskMenu::new));
	public static final RegistryObject<MenuType<FurnitureWoodMenu>> FURNITURE_WOOD = REGISTRY.register("furniture_wood", () -> IForgeMenuType.create(FurnitureWoodMenu::new));
	public static final RegistryObject<MenuType<FurnitureMetalMenu>> FURNITURE_METAL = REGISTRY.register("furniture_metal", () -> IForgeMenuType.create(FurnitureMetalMenu::new));
	public static final RegistryObject<MenuType<DrawerMenu>> DRAWER = REGISTRY.register("drawer", () -> IForgeMenuType.create(DrawerMenu::new));
	public static final RegistryObject<MenuType<ShelveMenu>> SHELVE = REGISTRY.register("shelve", () -> IForgeMenuType.create(ShelveMenu::new));
	public static final RegistryObject<MenuType<CounterMenu>> COUNTER = REGISTRY.register("counter", () -> IForgeMenuType.create(CounterMenu::new));
	public static final RegistryObject<MenuType<OvenMenu>> OVEN = REGISTRY.register("oven", () -> IForgeMenuType.create(OvenMenu::new));
	public static final RegistryObject<MenuType<FurnitureTeddysMenu>> FURNITURE_TEDDYS = REGISTRY.register("furniture_teddys", () -> IForgeMenuType.create(FurnitureTeddysMenu::new));
	public static final RegistryObject<MenuType<FridgeMenu>> FRIDGE = REGISTRY.register("fridge", () -> IForgeMenuType.create(FridgeMenu::new));
	public static final RegistryObject<MenuType<FreezerMenu>> FREEZER = REGISTRY.register("freezer", () -> IForgeMenuType.create(FreezerMenu::new));
	public static final RegistryObject<MenuType<WardrobeDrawersMenu>> WARDROBE_DRAWERS = REGISTRY.register("wardrobe_drawers", () -> IForgeMenuType.create(WardrobeDrawersMenu::new));
	public static final RegistryObject<MenuType<WardrobeCupboardMenu>> WARDROBE_CUPBOARD = REGISTRY.register("wardrobe_cupboard", () -> IForgeMenuType.create(WardrobeCupboardMenu::new));
	public static final RegistryObject<MenuType<MailBoxMenu>> MAIL_BOX = REGISTRY.register("mail_box", () -> IForgeMenuType.create(MailBoxMenu::new));
	public static final RegistryObject<MenuType<CupboardMenu>> CUPBOARD = REGISTRY.register("cupboard", () -> IForgeMenuType.create(CupboardMenu::new));
	public static final RegistryObject<MenuType<RecipeExplainerMenu>> RECIPE_EXPLAINER = REGISTRY.register("recipe_explainer", () -> IForgeMenuType.create(RecipeExplainerMenu::new));
	public static final RegistryObject<MenuType<FurnitureDecorationsMenu>> FURNITURE_DECORATIONS = REGISTRY.register("furniture_decorations", () -> IForgeMenuType.create(FurnitureDecorationsMenu::new));
	public static final RegistryObject<MenuType<FurnitureChiselMenu>> FURNITURE_CHISEL = REGISTRY.register("furniture_chisel", () -> IForgeMenuType.create(FurnitureChiselMenu::new));
}
