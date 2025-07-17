package net.lyivx.ls_furniture.neoforge;

import dev.architectury.event.events.common.LifecycleEvent;
import net.lyivx.ls_core.LYIVXsCore;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.lyivx.ls_furniture.client.neoforge.ClientEvents;
import net.lyivx.ls_furniture.client.screens.WorkstationScreen;
import net.lyivx.ls_furniture.registry.ModFuels;
import net.lyivx.ls_furniture.registry.ModMenus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.api.distmarker.Dist;
import net.lyivx.ls_furniture.client.renderers.SinkRenderer;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;

@Mod(LYIVXsFurnitureMod.MOD_ID)
public class LYIVXsFurnitureModNeoForge {
    public LYIVXsFurnitureModNeoForge(IEventBus bus) {
        LYIVXsFurnitureMod.init();

        LifecycleEvent.SETUP.register(LYIVXsCore::setup);

        bus.addListener(this::onCommonSetup);
        bus.addListener(this::onCreativeModeTabs);
        bus.addListener(this::onClientSetup);

        NeoForge.EVENT_BUS.register(this);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            bus.addListener(this::registerRenderers);
        }
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        LYIVXsFurnitureModClient.init();
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModFuels.init();
            // Any other setup code
        });   
    }

    @SubscribeEvent
    public void onPlace(PlayerInteractEvent.RightClickBlock event) {

    }

    @SubscribeEvent
    public void onServerStart(ServerAboutToStartEvent event) {

    }

    private void onCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        LYIVXsFurnitureMod.addCreativeTabContents(event.getTabKey(), event::accept);
    }

    private void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntitys.COUNTER_SINK_ENTITY.get(), SinkRenderer::new);
    }
}