package net.lyivx.ls_furniture.forge;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.client.forge.ClientEvents;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;

@Mod(LYIVXsFurnitureMod.MOD_ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class LYIVXsFurnitureModForge {
    public LYIVXsFurnitureModForge(IEventBus bus) {
        LYIVXsFurnitureMod.init();

        NeoForge.EVENT_BUS.addListener(LYIVXsFurnitureModForge::onPlace);
        NeoForge.EVENT_BUS.addListener(LYIVXsFurnitureModForge::onServerStart);

        bus.addListener(LYIVXsFurnitureModForge::onCommonSetup);
        bus.addListener(LYIVXsFurnitureModForge::onCreativeModeTabs);

        bus.addListener(ClientEvents::onRegisterBlockColors);
        bus.addListener(ClientEvents::onRegisterItemColors);
    }

    public static void onCommonSetup(FMLCommonSetupEvent event) {

    }

    public static void onPlace(PlayerInteractEvent.RightClickBlock event) {

    }

    public static void onServerStart(ServerAboutToStartEvent event) {

    }

    public static void onCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        LYIVXsFurnitureMod.initCreativeTabContents(event.getTabKey(), event::accept);
    }

}