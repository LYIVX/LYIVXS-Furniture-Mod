
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lsfurniture.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.lsfurniture.client.gui.WoodGUIScreen;
import net.mcreator.lsfurniture.client.gui.WardrobeDrawersScreen;
import net.mcreator.lsfurniture.client.gui.WardrobeCupboardScreen;
import net.mcreator.lsfurniture.client.gui.TeddysGUIScreen;
import net.mcreator.lsfurniture.client.gui.ShelveScreen;
import net.mcreator.lsfurniture.client.gui.OvenScreen;
import net.mcreator.lsfurniture.client.gui.MetalGUIScreen;
import net.mcreator.lsfurniture.client.gui.MailBoxScreen;
import net.mcreator.lsfurniture.client.gui.FridgeScreen;
import net.mcreator.lsfurniture.client.gui.FreezerScreen;
import net.mcreator.lsfurniture.client.gui.DrawerScreen;
import net.mcreator.lsfurniture.client.gui.DeskScreen;
import net.mcreator.lsfurniture.client.gui.DecorationsGUIScreen;
import net.mcreator.lsfurniture.client.gui.CupboardScreen;
import net.mcreator.lsfurniture.client.gui.CounterScreen;
import net.mcreator.lsfurniture.client.gui.ChiselGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LsFurnitureModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(LsFurnitureModMenus.DESK.get(), DeskScreen::new);
			MenuScreens.register(LsFurnitureModMenus.DRAWER.get(), DrawerScreen::new);
			MenuScreens.register(LsFurnitureModMenus.SHELVE.get(), ShelveScreen::new);
			MenuScreens.register(LsFurnitureModMenus.COUNTER.get(), CounterScreen::new);
			MenuScreens.register(LsFurnitureModMenus.OVEN.get(), OvenScreen::new);
			MenuScreens.register(LsFurnitureModMenus.FRIDGE.get(), FridgeScreen::new);
			MenuScreens.register(LsFurnitureModMenus.FREEZER.get(), FreezerScreen::new);
			MenuScreens.register(LsFurnitureModMenus.WARDROBE_DRAWERS.get(), WardrobeDrawersScreen::new);
			MenuScreens.register(LsFurnitureModMenus.WARDROBE_CUPBOARD.get(), WardrobeCupboardScreen::new);
			MenuScreens.register(LsFurnitureModMenus.MAIL_BOX.get(), MailBoxScreen::new);
			MenuScreens.register(LsFurnitureModMenus.CUPBOARD.get(), CupboardScreen::new);
			MenuScreens.register(LsFurnitureModMenus.WOOD_GUI.get(), WoodGUIScreen::new);
			MenuScreens.register(LsFurnitureModMenus.METAL_GUI.get(), MetalGUIScreen::new);
			MenuScreens.register(LsFurnitureModMenus.DECORATIONS_GUI.get(), DecorationsGUIScreen::new);
			MenuScreens.register(LsFurnitureModMenus.TEDDYS_GUI.get(), TeddysGUIScreen::new);
			MenuScreens.register(LsFurnitureModMenus.CHISEL_GUI.get(), ChiselGUIScreen::new);
		});
	}
}
