package net.lyivx.ls_furniture.neoforge;

import com.google.common.collect.Maps;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClientRegisterers;
import net.lyivx.ls_furniture.client.neoforge.ClientEvents;
import net.lyivx.ls_furniture.client.screens.WorkstationScreen;
import net.lyivx.ls_furniture.registry.ModMenus;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;

import java.util.Map;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createModelResourceLocation;
import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;

@Mod(LYIVXsFurnitureMod.MOD_ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LYIVXsFurnitureModNeoForgeClient {
    private static IEventBus modEventBus;

    public LYIVXsFurnitureModNeoForgeClient(IEventBus bus) {
        modEventBus = bus;
        modEventBus.addListener(LYIVXsFurnitureModNeoForgeClient::onClientSetup);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            LYIVXsFurnitureModClient.init();
        });
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenus.WORKSTATION_MENU.get(), WorkstationScreen::new);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        var registerer = new LYIVXsFurnitureModClientRegisterers() {
            @Override
            public <T extends BlockEntity> void registerBlockEntity(BlockEntityType<? extends T> blockEntityType, BlockEntityRendererProvider<T> blockEntityRendererProvider) {
                event.registerBlockEntityRenderer(blockEntityType, blockEntityRendererProvider);
            }

            @Override
            public <T extends Entity> void registerEntity(EntityType<? extends T> entityType, EntityRendererProvider<T> entityRendererProvider) {
                event.registerEntityRenderer(entityType, entityRendererProvider);
            }
        };
        LYIVXsFurnitureModClient.registerEntityRenderers(registerer);
        LYIVXsFurnitureModClient.registerBlockRenderers(registerer);
    }

    @SubscribeEvent
    public static void onRegisterBlockColors(RegisterColorHandlersEvent.Block event) {
        ClientEvents.onRegisterBlockColors(event);
    }

    @SubscribeEvent
    public static void onRegisterItemColors(RegisterColorHandlersEvent.Item event) {
        ClientEvents.onRegisterItemColors(event);
    }
}