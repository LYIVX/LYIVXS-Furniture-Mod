package net.lyivx.ls_furniture.forge;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClientRegisterers;
import net.lyivx.ls_furniture.client.forge.ClientEvents;
import net.lyivx.ls_furniture.client.screens.WorkstationScreen;
import net.lyivx.ls_furniture.registry.ModMenus;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = LYIVXsFurnitureMod.MOD_ID, value = Dist.CLIENT)
public class LYIVXsFurnitureModForgeClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        LYIVXsFurnitureModClient.init();

        System.out.println("Registering Workstation Screen");
        MenuScreens.register(ModMenus.WORKSTATION_MENU.get(), WorkstationScreen::new);

    }

    @SubscribeEvent
    public static void onModelLoading(ModelEvent.RegisterAdditional event) {
        LYIVXsFurnitureModClient.registerModel(event::register);
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