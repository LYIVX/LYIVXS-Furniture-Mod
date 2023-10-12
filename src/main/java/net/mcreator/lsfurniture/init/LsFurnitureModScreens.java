
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lsfurniture.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.lsfurniture.client.gui.WeaveryGUIScreen;
import net.mcreator.lsfurniture.client.gui.WardrobeDrawersScreen;
import net.mcreator.lsfurniture.client.gui.WardrobeCupboardScreen;
import net.mcreator.lsfurniture.client.gui.ShelveScreen;
import net.mcreator.lsfurniture.client.gui.OvenScreen;
import net.mcreator.lsfurniture.client.gui.MetalurgyGUIScreen;
import net.mcreator.lsfurniture.client.gui.MasonryGUIScreen;
import net.mcreator.lsfurniture.client.gui.MailBoxScreen;
import net.mcreator.lsfurniture.client.gui.GlassblowerGUIScreen;
import net.mcreator.lsfurniture.client.gui.FridgeScreen;
import net.mcreator.lsfurniture.client.gui.FreezerScreen;
import net.mcreator.lsfurniture.client.gui.EngineeringGUIScreen;
import net.mcreator.lsfurniture.client.gui.DrawerScreen;
import net.mcreator.lsfurniture.client.gui.DeskScreen;
import net.mcreator.lsfurniture.client.gui.CupboardScreen;
import net.mcreator.lsfurniture.client.gui.CounterScreen;
import net.mcreator.lsfurniture.client.gui.CarpentryGUIScreen;
import net.mcreator.lsfurniture.client.gui.BotanistGUIScreen;

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
			MenuScreens.register(LsFurnitureModMenus.CARPENTRY_GUI.get(), CarpentryGUIScreen::new);
			MenuScreens.register(LsFurnitureModMenus.MASONRY_GUI.get(), MasonryGUIScreen::new);
			MenuScreens.register(LsFurnitureModMenus.METALURGY_GUI.get(), MetalurgyGUIScreen::new);
			MenuScreens.register(LsFurnitureModMenus.WEAVERY_GUI.get(), WeaveryGUIScreen::new);
			MenuScreens.register(LsFurnitureModMenus.ENGINEERING_GUI.get(), EngineeringGUIScreen::new);
			MenuScreens.register(LsFurnitureModMenus.GLASSBLOWER_GUI.get(), GlassblowerGUIScreen::new);
			MenuScreens.register(LsFurnitureModMenus.BOTANIST_GUI.get(), BotanistGUIScreen::new);
		});
	}
}
