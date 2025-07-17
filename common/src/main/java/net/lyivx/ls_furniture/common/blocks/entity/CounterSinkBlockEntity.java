package net.lyivx.ls_furniture.common.blocks.entity;

import net.lyivx.ls_furniture.config.ConfigProvider;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class CounterSinkBlockEntity extends LiquidHolderBlockEntity {

    public CounterSinkBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntitys.COUNTER_SINK_ENTITY.get(), 
              pos, 
              state, 
              ConfigProvider.getSinkCapacityBuckets() * LiquidHolderBlockEntity.BUCKET_VOLUME);
    }

    // Add any sink-specific logic here later if needed
    // For example, you might want to override setFluid or add methods
    // to interact with the faucet part of the sink model, if applicable.
} 