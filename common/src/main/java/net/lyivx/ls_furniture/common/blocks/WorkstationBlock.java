package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.common.menus.WorkstationMenu;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.stream.Stream;

public class WorkstationBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<WorkstationBlock> CODEC = simpleCodec(WorkstationBlock::new);
    private static final Component CONTAINER_TITLE = Component.translatable("container.ls_furniture.workstation");
    public static final EnumProperty<WorkstationModelType> MODEL_TYPE = EnumProperty.create("model", WorkstationModelType.class);

    public WorkstationBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(MODEL_TYPE, WorkstationModelType.MAIN));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, MODEL_TYPE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        Level level = blockPlaceContext.getLevel();
        Direction direction = blockPlaceContext.getHorizontalDirection().getCounterClockWise();
        BlockPos posAbove = blockPos.above();
        BlockPos posClockWise = blockPos.relative(direction);
        BlockPos posClockWiseAbove = blockPos.relative(direction).above();

        if (blockPos.getY() < level.getMaxBuildHeight() - 1
                && level.getBlockState(posAbove).canBeReplaced(blockPlaceContext)
                && level.getBlockState(posClockWise).canBeReplaced(blockPlaceContext)
                && level.getBlockState(posClockWiseAbove).canBeReplaced(blockPlaceContext)) {
            return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
        }
        return null;
    }



    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand handIn, @NotNull BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;
        BlockPos containerPos = state.getValue(MODEL_TYPE) == WorkstationModelType.MAIN ? pos : pos.relative(state.getValue(FACING).getCounterClockWise());
        player.openMenu(state.getMenuProvider(level, pos));
        player.awardStat(Stats.INTERACT_WITH_STONECUTTER);
        return InteractionResult.CONSUME;
    }

    @Nullable
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((i, inventory, player) ->
                new WorkstationMenu(i, inventory, ContainerLevelAccess.create(level, pos)), CONTAINER_TITLE);
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (level.isClientSide) {
            super.playerWillDestroy(level, pos, state, player);
            return state;
        }
        WorkstationModelType workstationModel = state.getValue(MODEL_TYPE);
        if (workstationModel == WorkstationModelType.MAIN) {
            BlockPos leftpos = pos.relative(state.getValue(FACING).getClockWise());
            BlockPos leftuppos = pos.relative(state.getValue(FACING).getClockWise()).above();
            BlockPos uppos = pos.above();
            BlockState leftstate = level.getBlockState(leftpos);
            if (leftstate.getBlock() == this) {
                level.setBlock(leftpos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.setBlock(leftuppos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.setBlock(uppos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.levelEvent(player, LevelEvent.PARTICLES_DESTROY_BLOCK, leftpos, Block.getId(leftstate));
            }
        }
        if (workstationModel == WorkstationModelType.MAIN_UP) {
            BlockPos leftpos = pos.relative(state.getValue(FACING).getClockWise());
            BlockPos leftbelowpos = pos.relative(state.getValue(FACING).getClockWise()).below();
            BlockPos belowpos = pos.below();
            BlockState belowstate = level.getBlockState(belowpos);
            if (belowstate.getBlock() == this) {
                level.setBlock(leftpos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.setBlock(leftbelowpos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.setBlock(belowpos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.levelEvent(player, LevelEvent.PARTICLES_DESTROY_BLOCK, belowpos, Block.getId(belowstate));
            }
        }
        if (workstationModel == WorkstationModelType.SIDE) {
            BlockPos rightpos = pos.relative(state.getValue(FACING).getCounterClockWise());
            BlockPos rightuppos = pos.relative(state.getValue(FACING).getCounterClockWise()).above();
            BlockPos uppos = pos.above();
            BlockState rightstate = level.getBlockState(rightpos);
            if (rightstate.getBlock() == this) {
                level.setBlock(rightpos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.setBlock(rightuppos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.setBlock(uppos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.levelEvent(player, LevelEvent.PARTICLES_DESTROY_BLOCK, rightpos, Block.getId(rightstate));
            }
        }
        if (workstationModel == WorkstationModelType.SIDE_UP) {
            BlockPos belowpos = pos.below();
            BlockPos rightpos = pos.relative(state.getValue(FACING).getCounterClockWise());
            BlockPos rightbelowpos = pos.relative(state.getValue(FACING).getCounterClockWise()).below();
            BlockState otherstate = level.getBlockState(belowpos);
            if (otherstate.getBlock() == this) {
                level.setBlock(belowpos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.setBlock(rightpos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.setBlock(rightbelowpos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.levelEvent(player, LevelEvent.PARTICLES_DESTROY_BLOCK, belowpos, Block.getId(otherstate));
            }
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (!level.isClientSide) {
            BlockPos blockpos = pos.relative(state.getValue(FACING).getClockWise());
            level.setBlock(blockpos, state.setValue(MODEL_TYPE, WorkstationModelType.SIDE), Block.UPDATE_ALL);
            level.setBlock(blockpos.above(), state.setValue(MODEL_TYPE, WorkstationModelType.SIDE_UP), Block.UPDATE_ALL);
            level.setBlock(pos.above(), state.setValue(MODEL_TYPE, WorkstationModelType.MAIN_UP), Block.UPDATE_ALL);
            level.blockUpdated(pos, Blocks.AIR);
            state.updateNeighbourShapes(level, pos, Block.UPDATE_ALL);
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return state.getValue(MODEL_TYPE) == WorkstationModelType.MAIN ? RenderShape.MODEL : RenderShape.INVISIBLE;
    }

    @Deprecated
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.relative(state.getValue(FACING).getClockWise())).canBeReplaced();
    }

    public enum WorkstationModelType implements StringRepresentable {
        MAIN, SIDE, MAIN_UP, SIDE_UP;

        @Override
        public String getSerializedName() {
            return name().toLowerCase(Locale.ROOT);
        }

        @Override
        public String toString() {
            return getSerializedName();
        }
    }

    private static final VoxelShape BASE_LOWER_RIGHT_SHAPE = Stream.of(Block.box(0, 0, 0, 4, 2, 4), Block.box(0, 11, 0, 4, 13, 4), Block.box(1, 1, 1, 3, 11, 3), Block.box(1, 1, 13, 3, 11, 15), Block.box(0, 0, 12, 4, 2, 16), Block.box(0, 11, 12, 4, 13, 16), Block.box(29, 1, 13, 31, 11, 15), Block.box(28, 0, 12, 32, 2, 16), Block.box(28, 11, 12, 32, 13, 16), Block.box(29, 1, 1, 31, 11, 3), Block.box(28, 0, 0, 32, 2, 4), Block.box(28, 11, 0, 32, 13, 4), Block.box(0, 13, 0, 32, 16, 16), Block.box(5, 0, 0, 14, 3, 15), Block.box(14.25, 0, 2, 23.35, 2, 12), Block.box(16.049999999999997, 2, 2, 21.15, 3, 12), Block.box(5, 3, 2, 14, 6, 13.3), Block.box(0, 16, 14, 2, 26, 16), Block.box(10, 16, 14, 12, 26, 16), Block.box(20, 16, 14, 22, 26, 16), Block.box(30, 16, 14, 32, 26, 16), Block.box(22, 16, 14.5, 30, 26, 15.5), Block.box(12, 16, 14.5, 20, 26, 15.5), Block.box(2, 16, 14.5, 10, 26, 15.5), Block.box(21.2, 16, 3.1999999999999993, 31, 19, 13), Block.box(21.5, 19, 5, 31.299999999999997, 22, 11.2)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BASE_UPPER_RIGHT_SHAPE = Stream.of(Block.box(0, -16, 0, 4, -14, 4), Block.box(0, -5, 0, 4, -3, 4), Block.box(1, -15, 1, 3, -5, 3), Block.box(1, -15, 13, 3, -5, 15), Block.box(0, -16, 12, 4, -14, 16), Block.box(0, -5, 12, 4, -3, 16), Block.box(29, -15, 13, 31, -5, 15), Block.box(28, -16, 12, 32, -14, 16), Block.box(28, -5, 12, 32, -3, 16), Block.box(29, -15, 1, 31, -5, 3), Block.box(28, -16, 0, 32, -14, 4), Block.box(28, -5, 0, 32, -3, 4), Block.box(0, -3, 0, 32, 0, 16), Block.box(5, -16, 0, 14, -13, 15), Block.box(14.25, -16, 2, 23.35, -14, 12), Block.box(16.049999999999997, -14, 2, 21.15, -13, 12), Block.box(5, -13, 2, 14, -10, 13.3), Block.box(0, 0, 14, 2, 10, 16), Block.box(10, 0, 14, 12, 10, 16), Block.box(20, 0, 14, 22, 10, 16), Block.box(30, 0, 14, 32, 10, 16), Block.box(22, 0, 14.5, 30, 10, 15.5), Block.box(12, 0, 14.5, 20, 10, 15.5), Block.box(2, 0, 14.5, 10, 10, 15.5), Block.box(21.2, 0, 3.1999999999999993, 31, 3, 13), Block.box(21.5, 3, 5, 31.3, 6, 11.2)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BASE_LOWER_LEFT_SHAPE = Stream.of(Block.box(-16, 0, 0, -12, 2, 4), Block.box(-16, 11, 0, -12, 13, 4), Block.box(-15, 1, 1, -13, 11, 3), Block.box(-15, 1, 13, -13, 11, 15), Block.box(-16, 0, 12, -12, 2, 16), Block.box(-16, 11, 12, -12, 13, 16), Block.box(13, 1, 13, 15, 11, 15), Block.box(12, 0, 12, 16, 2, 16), Block.box(12, 11, 12, 16, 13, 16), Block.box(13, 1, 1, 15, 11, 3), Block.box(12, 0, 0, 16, 2, 4), Block.box(12, 11, 0, 16, 13, 4), Block.box(-16, 13, 0, 16, 16, 16), Block.box(-11, 0, 0, -2, 3, 15), Block.box(-1.75, 0, 2, 7.350000000000001, 2, 12), Block.box(0.04999999999999716, 2, 2, 5.149999999999999, 3, 12), Block.box(-11, 3, 2, -2, 6, 13.3), Block.box(-16, 16, 14, -14, 26, 16), Block.box(-6, 16, 14, -4, 26, 16), Block.box(4, 16, 14, 6, 26, 16), Block.box(14, 16, 14, 16, 26, 16), Block.box(6, 16, 14.5, 14, 26, 15.5), Block.box(-4, 16, 14.5, 4, 26, 15.5), Block.box(-14, 16, 14.5, -6, 26, 15.5), Block.box(5.199999999999999, 16, 3.1999999999999993, 15, 19, 13), Block.box(5.5, 19, 5, 15.3, 22, 11.2)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BASE_UPPER_LEFT_SHAPE = Stream.of(Block.box(-16, -16, 0, -12, -14, 4), Block.box(-16, -5, 0, -12, -3, 4), Block.box(-15, -15, 1, -13, -5, 3), Block.box(-15, -15, 13, -13, -5, 15), Block.box(-16, -16, 12, -12, -14, 16), Block.box(-16, -5, 12, -12, -3, 16), Block.box(13, -15, 13, 15, -5, 15), Block.box(12, -16, 12, 16, -14, 16), Block.box(12, -5, 12, 16, -3, 16), Block.box(13, -15, 1, 15, -5, 3), Block.box(12, -16, 0, 16, -14, 4), Block.box(12, -5, 0, 16, -3, 4), Block.box(-16, -3, 0, 16, 0, 16), Block.box(-11, -16, 0, -2, -13, 15), Block.box(-1.75, -16, 2, 7.350000000000001, -14, 12), Block.box(0.04999999999999716, -14, 2, 5.149999999999999, -13, 12), Block.box(-11, -13, 2, -2, -10, 13.3), Block.box(-16, 0, 14, -14, 10, 16), Block.box(-6, 0, 14, -4, 10, 16), Block.box(4, 0, 14, 6, 10, 16), Block.box(14, 0, 14, 16, 10, 16), Block.box(6, 0, 14.5, 14, 10, 15.5), Block.box(-4, 0, 14.5, 4, 10, 15.5), Block.box(-14, 0, 14.5, -6, 10, 15.5), Block.box(5.199999999999999, 0, 3.1999999999999993, 15, 3, 13), Block.box(5.5, 3, 5, 15.3, 6, 11.2)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape[] RIGHT_SHAPES = new VoxelShape[8];
    private static final VoxelShape[] LEFT_SHAPES = new VoxelShape[8];

    static {
        RIGHT_SHAPES[0] = ShapeUtil.rotateShape(BASE_UPPER_RIGHT_SHAPE, Direction.SOUTH); //South
        RIGHT_SHAPES[1] = ShapeUtil.rotateShape(BASE_UPPER_RIGHT_SHAPE, Direction.WEST); //West
        RIGHT_SHAPES[2] = ShapeUtil.rotateShape(BASE_UPPER_RIGHT_SHAPE, Direction.NORTH); //North
        RIGHT_SHAPES[3] = ShapeUtil.rotateShape(BASE_UPPER_RIGHT_SHAPE, Direction.EAST); //East
        RIGHT_SHAPES[4] = ShapeUtil.rotateShape(BASE_LOWER_RIGHT_SHAPE, Direction.SOUTH); //South Lower
        RIGHT_SHAPES[5] = ShapeUtil.rotateShape(BASE_LOWER_RIGHT_SHAPE, Direction.WEST); //West Lower
        RIGHT_SHAPES[6] = ShapeUtil.rotateShape(BASE_LOWER_RIGHT_SHAPE, Direction.NORTH); //North Lower
        RIGHT_SHAPES[7] = ShapeUtil.rotateShape(BASE_LOWER_RIGHT_SHAPE, Direction.EAST); //East Lower
    }
    static {
        LEFT_SHAPES[0] = ShapeUtil.rotateShape(BASE_UPPER_LEFT_SHAPE, Direction.SOUTH); //South
        LEFT_SHAPES[1] = ShapeUtil.rotateShape(BASE_UPPER_LEFT_SHAPE, Direction.WEST); //West
        LEFT_SHAPES[2] = ShapeUtil.rotateShape(BASE_UPPER_LEFT_SHAPE, Direction.NORTH); //North
        LEFT_SHAPES[3] = ShapeUtil.rotateShape(BASE_UPPER_LEFT_SHAPE, Direction.EAST); //East
        LEFT_SHAPES[4] = ShapeUtil.rotateShape(BASE_LOWER_LEFT_SHAPE, Direction.SOUTH); //South Lower
        LEFT_SHAPES[5] = ShapeUtil.rotateShape(BASE_LOWER_LEFT_SHAPE, Direction.WEST); //West Lower
        LEFT_SHAPES[6] = ShapeUtil.rotateShape(BASE_LOWER_LEFT_SHAPE, Direction.NORTH); //North Lower
        LEFT_SHAPES[7] = ShapeUtil.rotateShape(BASE_LOWER_LEFT_SHAPE, Direction.EAST); //East Lower
    }

    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext ctx) {
        Direction direction = state.getValue(FACING);
        if (direction == Direction.NORTH) {
            if (state.getValue(MODEL_TYPE) == WorkstationModelType.MAIN) {
                return BASE_LOWER_RIGHT_SHAPE;

            }
            else if (state.getValue(MODEL_TYPE) == WorkstationModelType.MAIN_UP) {

                return BASE_UPPER_RIGHT_SHAPE;

            }
            else if (state.getValue(MODEL_TYPE) == WorkstationModelType.SIDE) {

                return BASE_LOWER_LEFT_SHAPE;

            }
            else if (state.getValue(MODEL_TYPE) == WorkstationModelType.SIDE_UP) {

                return BASE_UPPER_LEFT_SHAPE;

            }

        } else if (direction == Direction.EAST) {
            if (state.getValue(MODEL_TYPE) == WorkstationModelType.MAIN) {

                return RIGHT_SHAPES[4 + direction.get2DDataValue()];

            }
            else if (state.getValue(MODEL_TYPE) == WorkstationModelType.MAIN_UP) {

                return RIGHT_SHAPES[direction.get2DDataValue()];

            }
            else if (state.getValue(MODEL_TYPE) == WorkstationModelType.SIDE) {

                return LEFT_SHAPES[4 + direction.get2DDataValue()];

            }
            else if (state.getValue(MODEL_TYPE) == WorkstationModelType.SIDE_UP) {

                return LEFT_SHAPES[direction.get2DDataValue()];

            }

        }  else if (direction == Direction.SOUTH) {
            if (state.getValue(MODEL_TYPE) == WorkstationModelType.MAIN) {

                return RIGHT_SHAPES[4 + direction.get2DDataValue()];

            }
            else if (state.getValue(MODEL_TYPE) == WorkstationModelType.MAIN_UP) {

                return RIGHT_SHAPES[direction.get2DDataValue()];

            }
            else if (state.getValue(MODEL_TYPE) == WorkstationModelType.SIDE) {

                return LEFT_SHAPES[4 + direction.get2DDataValue()];

            }
            else if (state.getValue(MODEL_TYPE) == WorkstationModelType.SIDE_UP) {

                return LEFT_SHAPES[direction.get2DDataValue()];

            }

        }  else if (direction == Direction.WEST) {
            if (state.getValue(MODEL_TYPE) == WorkstationModelType.MAIN) {

                return RIGHT_SHAPES[4 + direction.get2DDataValue()];

            }
            else if (state.getValue(MODEL_TYPE) == WorkstationModelType.MAIN_UP) {

                return RIGHT_SHAPES[direction.get2DDataValue()];

            }
            else if (state.getValue(MODEL_TYPE) == WorkstationModelType.SIDE) {

                return LEFT_SHAPES[4 + direction.get2DDataValue()];

            }
            else if (state.getValue(MODEL_TYPE) == WorkstationModelType.SIDE_UP) {

                return LEFT_SHAPES[direction.get2DDataValue()];

            }
        }
            return RIGHT_SHAPES[4 + direction.get2DDataValue()];
    }
}