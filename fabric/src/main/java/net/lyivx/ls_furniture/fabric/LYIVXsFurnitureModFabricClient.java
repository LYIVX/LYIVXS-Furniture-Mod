package net.lyivx.ls_furniture.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClientRegisterers;
import net.lyivx.ls_furniture.client.screens.WorkstationScreen;
import net.lyivx.ls_furniture.registry.ModMenus;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createModelResourceLocation;
import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;

public class LYIVXsFurnitureModFabricClient implements ClientModInitializer {

    @Override
    @SuppressWarnings("deprecation")
    public void onInitializeClient() {
        LYIVXsFurnitureModClient.init();

        MenuScreens.register(ModMenus.WORKSTATION_MENU.get(), WorkstationScreen::new);

        LYIVXsFurnitureModClient.registerBlockColors(ColorProviderRegistry.BLOCK::register);
        LYIVXsFurnitureModClient.registerItemColors(ColorProviderRegistry.ITEM::register);

        var register = new FabricClientRegister();
        LYIVXsFurnitureModClient.registerBlockRenderers(register);
        LYIVXsFurnitureModClient.registerEntityRenderers(register);

    }





    private static class FabricClientRegister implements LYIVXsFurnitureModClientRegisterers {

        @Override
        public <T extends BlockEntity> void registerBlockEntity(BlockEntityType<? extends T> blockEntityType, BlockEntityRendererProvider<T> blockEntityRendererProvider) {
            BlockEntityRenderers.register(blockEntityType, blockEntityRendererProvider);
        }

        @Override
        public <T extends Entity> void registerEntity(EntityType<? extends T> entityType, EntityRendererProvider<T> entityRendererProvider) {
            EntityRendererRegistry.register(entityType, entityRendererProvider);
        }
    }
}
