package net.lyivx.ls_furniture.common.blocks.entity;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public abstract class HorizontalDirectionalBlockEntity extends BaseEntityBlock {
    public static final EnumProperty<Direction> FACING;

    protected HorizontalDirectionalBlockEntity(BlockBehaviour.Properties properties) {
        super(properties);
    }

    protected abstract MapCodec<? extends HorizontalDirectionalBlockEntity> codec();

    protected BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue(FACING, rotation.rotate((Direction)state.getValue(FACING)));
    }

    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
    }

    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
    }
}
