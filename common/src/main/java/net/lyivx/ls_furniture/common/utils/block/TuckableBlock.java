package net.lyivx.ls_furniture.common.utils.block;

import net.lyivx.ls_furniture.common.blocks.ChairBlock;
import net.lyivx.ls_furniture.common.blocks.CounterIslandBlock;
import net.lyivx.ls_furniture.common.blocks.ShelfBlock;
import net.lyivx.ls_furniture.common.blocks.TableBlock;
import net.lyivx.ls_furniture.common.blocks.properties.HorizontalConnectionType;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.entity.SeatEntity;
import net.lyivx.ls_furniture.registry.ModBlocksTags;
import net.lyivx.ls_furniture.registry.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.AABB;

public interface TuckableBlock {
    BooleanProperty TUCKED = ModBlockStateProperties.TUCKED;

    static boolean tryTuck(BlockState state, Level level, BlockPos pos, Player player) {
        boolean tucked = state.getValue(TUCKED);
        if (!player.isCrouching() || !canTuckUnderBlockInfront(state, level, pos)) return false;

        if (tucked) {
            level.setBlockAndUpdate(pos, state.setValue(TUCKED, false));
            level.playSound(null, pos, ModSoundEvents.CHAIR_UNTUCK.get(), SoundSource.BLOCKS);
            return true;
        }

        if (!isBlockedFromTucking(state, level, pos)) {
            level.setBlockAndUpdate(pos, state.setValue(TUCKED, true));
            level.playSound(null, pos, ModSoundEvents.CHAIR_TUCK.get(), SoundSource.BLOCKS);
            return true;
        }

        return false;
    }

    static boolean canTuckUnderBlockInfront(BlockState state, Level level, BlockPos pos) {
        Direction forward = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        BlockState forwardState = level.getBlockState(pos.relative(forward));
        Block forwardBlock = forwardState.getBlock();

        if (forwardBlock instanceof ShelfBlock) return forwardState.getValue(ShelfBlock.SHAPE) == HorizontalConnectionType.MIDDLE || forwardState.getValue(BlockStateProperties.HORIZONTAL_FACING) != forward;
        if (forwardBlock instanceof SlabBlock) return forwardState.getValue(SlabBlock.TYPE) == SlabType.TOP;
        if (forwardBlock instanceof TableBlock) return true;
        if (forwardBlock instanceof CounterIslandBlock) return true;
        if (forwardBlock instanceof StairBlock) {
            StairsShape shape = forwardState.getValue(StairBlock.SHAPE);
            Direction facing_dir = forwardState.getValue(BlockStateProperties.HORIZONTAL_FACING);

            return forwardState.getValue(StairBlock.HALF) == Half.TOP && (forward == facing_dir ||
                    shape == StairsShape.OUTER_LEFT && forward == facing_dir.getCounterClockWise() ||
                    shape == StairsShape.OUTER_RIGHT && forward == facing_dir.getClockWise());
        }

        return forwardState.is(ModBlocksTags.CHAIRS_TUCKABLE_UNDER);
    }

    static boolean isBlockedFromTucking(BlockState state, Level level, BlockPos pos) {
        if (!level.getEntitiesOfClass(SeatEntity.class, new AABB(pos)).isEmpty()) return true;

        Direction facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        BlockState left = level.getBlockState(pos.relative(facing).relative(facing.getCounterClockWise()));
        BlockState right = level.getBlockState(pos.relative(facing).relative(facing.getClockWise()));

        if (left.getBlock() instanceof ChairBlock && left.getValue(TUCKED)
                && left.getValue(BlockStateProperties.HORIZONTAL_FACING) == facing.getClockWise()) return true;
        if (right.getBlock() instanceof ChairBlock && right.getValue(TUCKED)
                && right.getValue(BlockStateProperties.HORIZONTAL_FACING) == facing.getCounterClockWise()) return true;

        return false;
    }
}