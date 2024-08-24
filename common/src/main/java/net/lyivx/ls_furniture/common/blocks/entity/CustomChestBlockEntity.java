package net.lyivx.ls_furniture.common.blocks.entity;

import net.lyivx.ls_furniture.common.blocks.CustomChestBlock;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;


public class CustomChestBlockEntity extends ChestBlockEntity {

    public CustomChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntitys.CUSTOM_CHEST_ENTITY.get(), blockPos, blockState);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.ls_furniture." + getBlock().chestType + "_chest");
    }

    public CustomChestBlock getBlock() {
        return (CustomChestBlock) getBlockState().getBlock();
    }
}