package net.lyivx.ls_furniture.neoforge;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.client.neoforge.ClientEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LYIVXsFurnitureMod.MOD_ID)
public class LYIVXsFurnitureModForge {
    public LYIVXsFurnitureModForge() {
        LYIVXsFurnitureMod.init();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.addListener(LYIVXsFurnitureModForge::onPlace);
        MinecraftForge.EVENT_BUS.addListener(LYIVXsFurnitureModForge::onServerStart);

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