package net.lyivx.ls_furniture.neoforge;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClientRegisterers;
import net.lyivx.ls_furniture.client.screens.WorkstationScreen;
import net.lyivx.ls_furniture.registry.ModMenus;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = LYIVXsFurnitureMod.MOD_ID, value = Dist.CLIENT)
public class LYIVXsFurnitureModNeoForgeClient {

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
}