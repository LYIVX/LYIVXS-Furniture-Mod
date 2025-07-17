package net.lyivx.ls_furniture.neoforge;

import dev.architectury.event.events.common.LifecycleEvent;
import net.lyivx.ls_core.LYIVXsCore;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;

@Mod(LYIVXsFurnitureMod.MOD_ID)
public class LYIVXsFurnitureModNeoForge {
    public LYIVXsFurnitureModNeoForge(ModContainer container) {
        LYIVXsFurnitureMod.init();

        LifecycleEvent.SETUP.register(LYIVXsCore::setup);

        IEventBus bus = container.getEventBus();
        bus.addListener(this::onCommonSetup);
        bus.addListener(this::onClientSetup);
        bus.addListener(this::onCreativeModeTabs);

        NeoForge.EVENT_BUS.register(this);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        LYIVXsFurnitureModClient.init();
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onPlace(PlayerInteractEvent.RightClickBlock event) {

    }

    @SubscribeEvent
    public void onServerStart(ServerAboutToStartEvent event) {

    }

    private void onCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        LYIVXsFurnitureMod.initCreativeTabContents(event.getTabKey(), event::accept);
    }

}