package net.lyivx.ls_furniture.neoforge;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.client.neoforge.ClientEvents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;

@Mod(LYIVXsFurnitureMod.MOD_ID)
public class LYIVXsFurnitureModNeoForge {
    public LYIVXsFurnitureModNeoForge(IEventBus bus) {
        LYIVXsFurnitureMod.init();

        bus.addListener(this::onCommonSetup);
        bus.addListener(this::onCreativeModeTabs);
        bus.addListener(ClientEvents::onRegisterBlockColors);
        bus.addListener(ClientEvents::onRegisterItemColors);

        NeoForge.EVENT_BUS.register(this);

    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onPlace(PlayerInteractEvent.RightClickBlock event) {

    }

    @SubscribeEvent
    public  void onServerStart(ServerAboutToStartEvent event) {

    }

    private void onCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        LYIVXsFurnitureMod.initCreativeTabContents(event.getTabKey(), event::accept);
    }

}