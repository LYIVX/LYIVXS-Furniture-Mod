package net.lyivx.ls_furniture.client;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.client.renderers.*;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.TransientCraftingContainer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.commons.lang3.NotImplementedException;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public class LYIVXsFurnitureModClient {

    public static void init() {
        initRenderTypes();
    }

    public static void registerBlockRenderers(LYIVXsFurnitureModClientRegisterers registerer) {
        registerer.registerBlockEntity(ModBlockEntitys.PLATE_ENTITY.get(), PlateRenderer::new);
        registerer.registerBlockEntity(ModBlockEntitys.SHELF_ENTITY.get(), ShelfRenderer::new);
        registerer.registerBlockEntity(ModBlockEntitys.CHAIR_ENTITY.get(), ChairCushionRenderer::new);
        registerer.registerBlockEntity(ModBlockEntitys.STOOL_ENTITY.get(), StoolCushionRenderer::new);
        registerer.registerBlockEntity(ModBlockEntitys.SOFA_ENTITY.get(), SofaCushionRenderer::new);
        registerer.registerBlockEntity(ModBlockEntitys.LAMP_ENTITY.get(), LampCushionRenderer::new);
        registerer.registerBlockEntity(ModBlockEntitys.BED_ENTITY.get(), BedCushionRenderer::new);
        registerer.registerBlockEntity(ModBlockEntitys.CHOPPING_BOARD_ENTITY.get(), ChoppingBoardRenderer::new);
        registerer.registerBlockEntity(ModBlockEntitys.CUTTING_BOARD_ENTITY.get(), CuttingBoardRenderer::new);
        registerer.registerBlockEntity(ModBlockEntitys.CUSTOM_CHEST_ENTITY.get(), CustomChestRenderer::new);
        registerer.registerBlockEntity(ModBlockEntitys.COUNTER_OVEN_ENTITY.get(), OvenRenderer::new);
    }

    public static void registerEntityRenderers(LYIVXsFurnitureModClientRegisterers registerer) {
        registerer.registerEntity(ModEntities.SEAT.get(), SeatRenderer::new);
    }

    public static void registerBlockColors(BlockColorsRegister register)
    {
        register.apply((state, reader, pos, index) -> {
            return reader != null && pos != null ? BiomeColors.getAverageFoliageColor(reader, pos) : FoliageColor.getDefaultColor();
        }, ModBlocks.OAK_BUSH.get(), ModBlocks.JUNGLE_BUSH.get(), ModBlocks.ACACIA_BUSH.get(), ModBlocks.DARK_OAK_BUSH.get());

        register.apply((state, reader, pos, i) -> {
            return FoliageColor.getEvergreenColor();
        }, ModBlocks.SPRUCE_BUSH.get());

        register.apply((state, reader, pos, i) -> {
            return FoliageColor.getBirchColor();
        }, ModBlocks.BIRCH_BUSH.get());

        register.apply((state, reader, pos, i) -> {
            return FoliageColor.getMangroveColor();
        }, ModBlocks.MANGROVE_BUSH.get());
    }

    public static void registerItemColors(ItemColorsRegister register)
    {
        register.apply((stack, index) -> {
            BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return Minecraft.getInstance().getBlockColors().getColor(state, null, null, index);
        }, ModBlocks.OAK_BUSH.get(), ModBlocks.SPRUCE_BUSH.get(), ModBlocks.BIRCH_BUSH.get(), ModBlocks.JUNGLE_BUSH.get(), ModBlocks.ACACIA_BUSH.get(), ModBlocks.DARK_OAK_BUSH.get(), ModBlocks.MANGROVE_BUSH.get());
    }

    public static void initRenderTypes() {
        setRenderType(ModBlocks.WORKSTATION.get(), RenderType.cutout());

        setRenderType(ModBlocks.MICROWAVE.get(), RenderType.cutout());

        setRenderType(ModBlocks.OAK_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.SPRUCE_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.BIRCH_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.JUNGLE_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.ACACIA_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.DARK_OAK_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.MANGROVE_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.CHERRY_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.BAMBOO_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.CRIMSON_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.WARPED_DRAWER.get(), RenderType.cutout());
        
        setRenderType(ModBlocks.OAK_COUNTER_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.SPRUCE_COUNTER_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.BIRCH_COUNTER_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.JUNGLE_COUNTER_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.ACACIA_COUNTER_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.DARK_OAK_COUNTER_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.MANGROVE_COUNTER_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.CHERRY_COUNTER_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.BAMBOO_COUNTER_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.CRIMSON_COUNTER_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.WARPED_COUNTER_CUPBOARD.get(), RenderType.cutout());
                
        setRenderType(ModBlocks.OAK_COUNTER_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.SPRUCE_COUNTER_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.BIRCH_COUNTER_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.JUNGLE_COUNTER_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.ACACIA_COUNTER_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.DARK_OAK_COUNTER_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.MANGROVE_COUNTER_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.CHERRY_COUNTER_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.BAMBOO_COUNTER_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.CRIMSON_COUNTER_DRAWER.get(), RenderType.cutout());
        setRenderType(ModBlocks.WARPED_COUNTER_DRAWER.get(), RenderType.cutout());
        
        setRenderType(ModBlocks.OAK_CABINET_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.SPRUCE_CABINET_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.BIRCH_CABINET_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.JUNGLE_CABINET_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.ACACIA_CABINET_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.DARK_OAK_CABINET_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.MANGROVE_CABINET_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.CHERRY_CABINET_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.BAMBOO_CABINET_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.CRIMSON_CABINET_CUPBOARD.get(), RenderType.cutout());
        setRenderType(ModBlocks.WARPED_CABINET_CUPBOARD.get(), RenderType.cutout());
        
        setRenderType(ModBlocks.OAK_COUNTER_OVEN.get(), RenderType.cutout());
        setRenderType(ModBlocks.SPRUCE_COUNTER_OVEN.get(), RenderType.cutout());
        setRenderType(ModBlocks.BIRCH_COUNTER_OVEN.get(), RenderType.cutout());
        setRenderType(ModBlocks.JUNGLE_COUNTER_OVEN.get(), RenderType.cutout());
        setRenderType(ModBlocks.ACACIA_COUNTER_OVEN.get(), RenderType.cutout());
        setRenderType(ModBlocks.DARK_OAK_COUNTER_OVEN.get(), RenderType.cutout());
        setRenderType(ModBlocks.MANGROVE_COUNTER_OVEN.get(), RenderType.cutout());
        setRenderType(ModBlocks.CHERRY_COUNTER_OVEN.get(), RenderType.cutout());
        setRenderType(ModBlocks.BAMBOO_COUNTER_OVEN.get(), RenderType.cutout());
        setRenderType(ModBlocks.CRIMSON_COUNTER_OVEN.get(), RenderType.cutout());
        setRenderType(ModBlocks.WARPED_COUNTER_OVEN.get(), RenderType.cutout());

        setRenderType(ModBlocks.OAK_CHAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.SPRUCE_CHAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.BIRCH_CHAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.JUNGLE_CHAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.ACACIA_CHAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.DARK_OAK_CHAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.MANGROVE_CHAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.CHERRY_CHAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.BAMBOO_CHAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.CRIMSON_CHAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.WARPED_CHAIR.get(), RenderType.cutout());
        
        setRenderType(ModBlocks.OAK_WARDROBE.get(), RenderType.cutout());
        setRenderType(ModBlocks.SPRUCE_WARDROBE.get(), RenderType.cutout());
        setRenderType(ModBlocks.BIRCH_WARDROBE.get(), RenderType.cutout());
        setRenderType(ModBlocks.JUNGLE_WARDROBE.get(), RenderType.cutout());
        setRenderType(ModBlocks.ACACIA_WARDROBE.get(), RenderType.cutout());
        setRenderType(ModBlocks.DARK_OAK_WARDROBE.get(), RenderType.cutout());
        setRenderType(ModBlocks.MANGROVE_WARDROBE.get(), RenderType.cutout());
        setRenderType(ModBlocks.CHERRY_WARDROBE.get(), RenderType.cutout());
        setRenderType(ModBlocks.BAMBOO_WARDROBE.get(), RenderType.cutout());
        setRenderType(ModBlocks.CRIMSON_WARDROBE.get(), RenderType.cutout());
        setRenderType(ModBlocks.WARPED_WARDROBE.get(), RenderType.cutout());    
        
        setRenderType(ModBlocks.OAK_BUSH.get(), RenderType.cutout());
        setRenderType(ModBlocks.SPRUCE_BUSH.get(), RenderType.cutout());
        setRenderType(ModBlocks.BIRCH_BUSH.get(), RenderType.cutout());
        setRenderType(ModBlocks.JUNGLE_BUSH.get(), RenderType.cutout());
        setRenderType(ModBlocks.ACACIA_BUSH.get(), RenderType.cutout());
        setRenderType(ModBlocks.DARK_OAK_BUSH.get(), RenderType.cutout());
        setRenderType(ModBlocks.MANGROVE_BUSH.get(), RenderType.cutout());
        setRenderType(ModBlocks.CHERRY_BUSH.get(), RenderType.cutout());
        setRenderType(ModBlocks.CRIMSON_BUSH.get(), RenderType.cutout());
        setRenderType(ModBlocks.WARPED_BUSH.get(), RenderType.cutout());
        setRenderType(ModBlocks.AZALEA_BUSH.get(), RenderType.cutout());
        setRenderType(ModBlocks.FLOWERING_AZALEA_BUSH.get(), RenderType.cutout());   
        
        setRenderType(ModBlocks.OAK_PLATFORM.get(), RenderType.cutout());
        setRenderType(ModBlocks.SPRUCE_PLATFORM.get(), RenderType.cutout());
        setRenderType(ModBlocks.BIRCH_PLATFORM.get(), RenderType.cutout());
        setRenderType(ModBlocks.JUNGLE_PLATFORM.get(), RenderType.cutout());
        setRenderType(ModBlocks.ACACIA_PLATFORM.get(), RenderType.cutout());
        setRenderType(ModBlocks.DARK_OAK_PLATFORM.get(), RenderType.cutout());
        setRenderType(ModBlocks.MANGROVE_PLATFORM.get(), RenderType.cutout());
        setRenderType(ModBlocks.CHERRY_PLATFORM.get(), RenderType.cutout());
        setRenderType(ModBlocks.CRIMSON_PLATFORM.get(), RenderType.cutout());
        setRenderType(ModBlocks.WARPED_PLATFORM.get(), RenderType.cutout());
        
        setRenderType(ModBlocks.OAK_STAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.SPRUCE_STAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.BIRCH_STAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.JUNGLE_STAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.ACACIA_STAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.DARK_OAK_STAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.MANGROVE_STAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.CHERRY_STAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.CRIMSON_STAIR.get(), RenderType.cutout());
        setRenderType(ModBlocks.WARPED_STAIR.get(), RenderType.cutout());
        
        setRenderType(ModBlocks.OAK_CHAIN_LINK_FENCE.get(), RenderType.cutout());
        setRenderType(ModBlocks.SPRUCE_CHAIN_LINK_FENCE.get(), RenderType.cutout());
        setRenderType(ModBlocks.BIRCH_CHAIN_LINK_FENCE.get(), RenderType.cutout());
        setRenderType(ModBlocks.JUNGLE_CHAIN_LINK_FENCE.get(), RenderType.cutout());
        setRenderType(ModBlocks.ACACIA_CHAIN_LINK_FENCE.get(), RenderType.cutout());
        setRenderType(ModBlocks.DARK_OAK_CHAIN_LINK_FENCE.get(), RenderType.cutout());
        setRenderType(ModBlocks.MANGROVE_CHAIN_LINK_FENCE.get(), RenderType.cutout());
        setRenderType(ModBlocks.CHERRY_CHAIN_LINK_FENCE.get(), RenderType.cutout());
        setRenderType(ModBlocks.BAMBOO_CHAIN_LINK_FENCE.get(), RenderType.cutout());
        setRenderType(ModBlocks.CRIMSON_CHAIN_LINK_FENCE.get(), RenderType.cutout());
        setRenderType(ModBlocks.WARPED_CHAIN_LINK_FENCE.get(), RenderType.cutout());

        setRenderType(ModBlocks.OAK_CHAIN_LINK_FENCE_GATE.get(), RenderType.cutout());
        setRenderType(ModBlocks.SPRUCE_CHAIN_LINK_FENCE_GATE.get(), RenderType.cutout());
        setRenderType(ModBlocks.BIRCH_CHAIN_LINK_FENCE_GATE.get(), RenderType.cutout());
        setRenderType(ModBlocks.JUNGLE_CHAIN_LINK_FENCE_GATE.get(), RenderType.cutout());
        setRenderType(ModBlocks.ACACIA_CHAIN_LINK_FENCE_GATE.get(), RenderType.cutout());
        setRenderType(ModBlocks.DARK_OAK_CHAIN_LINK_FENCE_GATE.get(), RenderType.cutout());
        setRenderType(ModBlocks.MANGROVE_CHAIN_LINK_FENCE_GATE.get(), RenderType.cutout());
        setRenderType(ModBlocks.CHERRY_CHAIN_LINK_FENCE_GATE.get(), RenderType.cutout());
        setRenderType(ModBlocks.BAMBOO_CHAIN_LINK_FENCE_GATE.get(), RenderType.cutout());
        setRenderType(ModBlocks.CRIMSON_CHAIN_LINK_FENCE_GATE.get(), RenderType.cutout());
        setRenderType(ModBlocks.WARPED_CHAIN_LINK_FENCE_GATE.get(), RenderType.cutout());

    }

    public static void registerModel(Consumer<ResourceLocation> modelLoader) {
        for (DyeColor value : DyeColor.values()) {
            modelLoader.accept(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/chair/cushion/" + value.getName()));
            modelLoader.accept(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/chair/cushion/tucked/" + value.getName()));
            modelLoader.accept(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/stool/cushion/" + value.getName()));
            modelLoader.accept(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/stool/cushion/tucked/" + value.getName()));
            modelLoader.accept(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/sofa/cushion/" + value.getName()));
            modelLoader.accept(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/sofa/cushion/inner/" + value.getName()));
            modelLoader.accept(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/sofa/cushion/left/" + value.getName()));
            modelLoader.accept(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/sofa/cushion/middle/" + value.getName()));
            modelLoader.accept(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/sofa/cushion/outer/" + value.getName()));
            modelLoader.accept(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/sofa/cushion/right/" + value.getName()));
            modelLoader.accept(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/lamp/cushion/" + value.getName()));
            modelLoader.accept(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/bed/cushion/head/" + value.getName()));
            modelLoader.accept(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/bed/cushion/foot/" + value.getName()));
        }
    }

    @ExpectPlatform
    public static void setRenderType(Block block, RenderType type) {
        throw new NotImplementedException();
    }

    @ExpectPlatform
    public static BakedModel getModel(BlockRenderDispatcher dispatcher, @NotNull ResourceLocation model) {
        throw new NotImplementedException();
    }




    private static boolean hasManyRecipes = false;

    public static void onTagsUpdated() {
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            CraftingContainer dummy = new TransientCraftingContainer(new AbstractContainerMenu(null, -1) {
                public ItemStack quickMoveStack(Player player, int index) {
                    return ItemStack.EMPTY;
                }

                public boolean stillValid(Player player) {
                    return false;
                }
            }, 1, 1);
            dummy.setItem(0, Items.OAK_LOG.getDefaultInstance());

        }
    }

    public static boolean hasManyRecipes() {
        return hasManyRecipes;
    }
}
