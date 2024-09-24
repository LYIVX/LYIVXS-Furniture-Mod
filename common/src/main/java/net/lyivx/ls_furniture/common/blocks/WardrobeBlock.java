package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.blocks.entity.WardrobeBottomBlockEntity;
import net.lyivx.ls_furniture.common.blocks.entity.WardrobeTopBlockEntity;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.stream.Stream;

public class WardrobeBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final EnumProperty<WardrobeModelType> MODEL_TYPE = EnumProperty.create("model", WardrobeModelType.class);


    public WardrobeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(MODEL_TYPE, WardrobeModelType.BOTTOM)
                .setValue(OPEN, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, MODEL_TYPE, OPEN);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        Level level = context.getLevel();
        if (level.getBlockState(blockPos.above()).canBeReplaced(context)) {
            return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
        }
        return null;
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (state.getValue(MODEL_TYPE) == WardrobeModelType.BOTTOM) {
            if (blockEntity instanceof WardrobeBottomBlockEntity drawerBlockEntity) {
                player.openMenu(drawerBlockEntity);
                PiglinAi.angerNearbyPiglins(player, true);
                return InteractionResult.SUCCESS;
            }
        } else if (state.getValue(MODEL_TYPE) == WardrobeModelType.TOP ) {
            if (blockEntity instanceof WardrobeTopBlockEntity drawerBlockEntity) {
                player.openMenu(drawerBlockEntity);
                PiglinAi.angerNearbyPiglins(player, true);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.CONSUME;
    }

    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.is(newState.getBlock())) return;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof Container) {
            Containers.dropContents(level, pos, (Container)blockEntity);
            level.updateNeighbourForOutputSignal(pos, this);
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    private static Direction getNeighbourDirection(WardrobeModelType modelType) {
        return modelType == WardrobeModelType.BOTTOM ? Direction.UP : Direction.DOWN;
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            WardrobeModelType modelType = state.getValue(MODEL_TYPE);
            BlockPos otherPos = pos.relative(getNeighbourDirection(modelType));
            BlockState otherState = level.getBlockState(otherPos);

            if (otherState.getBlock() == this && otherState.getValue(MODEL_TYPE) != modelType) {
                BlockPos bottomPos = modelType == WardrobeModelType.BOTTOM ? pos : otherPos;
                BlockPos topPos = modelType == WardrobeModelType.TOP ? pos : otherPos;

                // Destroy bottom part
                level.setBlock(bottomPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.levelEvent(player, 2001, bottomPos, Block.getId(state));

                // Destroy top part
                level.setBlock(topPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.levelEvent(player, 2001, topPos, Block.getId(otherState));

                if (!player.isCreative()) {
                    // Make sure items are dropped correctly
                    dropResources(state, level, pos, null, player, player.getMainHandItem());
                    dropResources(otherState, level, otherPos, null, player, player.getMainHandItem());
                }
            }
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (!level.isClientSide) {
            level.setBlock(pos.above(), state.setValue(MODEL_TYPE, WardrobeModelType.TOP), Block.UPDATE_ALL);
            level.blockUpdated(pos, Blocks.AIR);
            state.updateNeighbourShapes(level, pos, Block.UPDATE_ALL);
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof WardrobeBottomBlockEntity wardrobeBE) wardrobeBE.recheckOpen();
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        if (state.getValue(MODEL_TYPE) == WardrobeModelType.TOP ) {
            return new WardrobeTopBlockEntity(pos, state);
        } return new WardrobeBottomBlockEntity(pos, state);
    }


    public enum WardrobeModelType implements StringRepresentable {
        BOTTOM, TOP;

        @Override
        public String getSerializedName() {
            return name().toLowerCase(Locale.ROOT);
        }

        @Override
        public String toString() {
            return getSerializedName();
        }
    }


    private static final VoxelShape BASE_LOWER_SHAPE = Stream.of(
            Block.box(0, 0, 0, 1, 32, 16),
            Block.box(15, 0, 0, 16, 32, 16),
            Block.box(1, 31, 0, 15, 32, 16),
            Block.box(1, 13, 0, 15, 14, 16),
            Block.box(1, 2, 0, 15, 3, 16),
            Block.box(1, 0, 1, 15, 2, 16),
            Block.box(1, 3, 1, 15, 13, 16),
            Block.box(1, 14, 1, 15, 31, 16),
            Block.box(8.25, 14.5, 0, 14.5, 30.5, 15),
            Block.box(1.5, 14.5, 0, 7.75, 30.5, 15),
            Block.box(1.5, 8.5, 0, 14.5, 12.5, 15),
            Block.box(1.5, 3.5, 0, 14.5, 7.5, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BASE_UPPER_SHAPE = Stream.of(
            Block.box(0, -16, 0, 1, 16, 16),
            Block.box(15, -16, 0, 16, 16, 16),
            Block.box(1, 15, 0, 15, 16, 16),
            Block.box(1, -3, 0, 15, -2, 16),
            Block.box(1, -14, 0, 15, -13, 16),
            Block.box(1, -16, 1, 15, -14, 16),
            Block.box(1, -13, 1, 15, -3, 16),
            Block.box(1, -2, 1, 15, 15, 16),
            Block.box(8.25, -1.5, 0, 14.5, 14.5, 15),
            Block.box(1.5, -1.5, 0, 7.75, 14.5, 15),
            Block.box(1.5, -7.5, 0, 14.5, -3.5, 15),
            Block.box(1.5, -12.5, 0, 14.5, -8.5, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BASE_LOWER_OPEN_SHAPE = Stream.of(
            Block.box(1.5, 8.5, -3, 14.5, 12.5, -2),
            Block.box(3, 10, 10, 13, 12, 11),
            Block.box(13, 10, -2, 14, 12, 11),
            Block.box(2, 10, -2, 3, 12, 11),
            Block.box(2, 9, -2, 14, 10, 11),
            Block.box(1.5, 3.5, -6, 14.5, 7.5, -5),
            Block.box(3, 5, 7, 13, 7, 8),
            Block.box(13, 5, -5, 14, 7, 8),
            Block.box(2, 5, -5, 3, 7, 8),
            Block.box(2, 4, -5, 14, 5, 8),
            Block.box(1, 27, 15, 15, 31, 16),
            Block.box(1, 14, 15, 15, 27, 16),
            Block.box(1, 0, 15, 15, 13, 16),
            Block.box(15, 27, 0, 16, 31, 16),
            Block.box(0, 27, 0, 1, 31, 16),
            Block.box(0, 14, 0, 1, 27, 16),
            Block.box(0, 0, 0, 1, 13, 16),
            Block.box(1, 0, 1, 15, 2, 2),
            Block.box(1, 2, 0, 15, 3, 15),
            Block.box(15, 0, 0, 16, 13, 16),
            Block.box(15, 14, 0, 16, 27, 16),
            Block.box(0, 13, 0, 16, 14, 16),
            Block.box(0, 31, 0, 16, 32, 16),
            Block.box(2, 3, 1, 14, 4, 2),
            Block.box(1, 3, 1, 2, 13, 2),
            Block.box(2, 12, 1, 14, 13, 2),
            Block.box(2, 7, 1, 14, 9, 2),
            Block.box(14, 3, 1, 15, 13, 2),
            Block.box(14, 15, 1, 15, 30, 2),
            Block.box(1, 14, 1, 15, 15, 2),
            Block.box(7.5, 15, 1, 8.5, 30, 2),
            Block.box(1, 15, 1, 2, 30, 2),
            Block.box(1, 30, 1, 15, 31, 2),
            Block.box(1.5, 27, 0, 7.75, 30.5, 1),
            Block.box(1.5, 14.5, 0, 7.75, 27, 1),
            Block.box(8.25, 27, 0, 14.5, 30.5, 1),
            Block.box(8.25, 14.5, 0, 14.5, 27, 1)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BASE_UPPER_OPEN_SHAPE = Stream.of(
            Block.box(14, -1, 1, 15, 14, 15),
            Block.box(1, -2, 1, 15, -1, 15),
            Block.box(7.5, -1, 1, 8.5, 14, 2),
            Block.box(1, -1, 1, 2, 14, 15),
            Block.box(1.5, -7.5, 0, 14.5, -3.5, 1),
            Block.box(3, -6, 13, 13, -4, 14),
            Block.box(13, -6, 1, 14, -4, 14),
            Block.box(2, -6, 1, 3, -4, 14),
            Block.box(2, -12, 1, 14, -11, 14),
            Block.box(2, -11, 1, 3, -9, 14),
            Block.box(1, 11, 15, 15, 15, 16),
            Block.box(1, -2, 15, 15, 11, 16),
            Block.box(1, -16, 15, 15, -3, 16),
            Block.box(15, 11, 0, 16, 15, 16),
            Block.box(0, 11, 0, 1, 15, 16),
            Block.box(0, -2, 0, 1, 11, 16),
            Block.box(0, -16, 0, 1, -3, 16),
            Block.box(1, -16, 1, 15, -14, 2),
            Block.box(1, -14, 0, 15, -13, 15),
            Block.box(15, -16, 0, 16, -3, 16),
            Block.box(15, -2, 0, 16, 11, 16),
            Block.box(0, -3, 0, 16, -2, 16),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(2, -13, 1, 14, -12, 2),
            Block.box(1, -13, 1, 2, -3, 2),
            Block.box(2, -4, 1, 14, -3, 2),
            Block.box(2, -9, 1, 14, -7, 2),
            Block.box(14, -13, 1, 15, -3, 2),
            Block.box(13, -11, 1, 14, -9, 14),
            Block.box(3, -11, 13, 13, -9, 14),
            Block.box(1.5, -12.5, 0, 14.5, -8.5, 1),
            Block.box(2, -7, 1, 14, -6, 14),
            Block.box(1, 14, 1, 15, 15, 15),
            Block.box(1, -1.5, 0, 2, 14.5, 1),
            Block.box(1.5, -1.5, -0.5, 2.5, 14.5, 0.5),
            Block.box(2.5, -1.5, -1.5, 3.5, 14.5, -0.5),
            Block.box(2, -1.5, -1, 3, 14.5, 0),
            Block.box(3.5, -1.5, -2.5, 4.5, 14.5, -1.5),
            Block.box(3, -1.5, -2, 4, 14.5, -1),
            Block.box(4.5, -1.5, -3.5, 5.5, 14.5, -2.5),
            Block.box(5, -1.5, -4, 6, 14.5, -3),
            Block.box(5.5, -1.5, -4.5, 6.5, 14.5, -3.5),
            Block.box(13.899999999999999, -1.5, -0.25, 14.899999999999999, 14.5, 0.75),
            Block.box(13.500000000000002, -1.5, -1.25, 14.500000000000002, 14.5, -0.25),
            Block.box(12.650000000000002, -1.5, -3.25, 13.650000000000002, 14.5, -2.25),
            Block.box(13.075, -1.5, -2.25, 14.075, 14.5, -1.25),
            Block.box(11.850000000000005, -1.5, -5.25, 12.850000000000005, 14.5, -4.25),
            Block.box(11.700000000000006, -1.5, -5.75, 12.700000000000006, 14.5, -4.75),
            Block.box(12.250000000000002, -1.5, -4.25, 13.250000000000002, 14.5, -3.25),
            Block.box(12.050000000000004, -1.5, -4.75, 13.050000000000004, 14.5, -3.75),
            Block.box(12.450000000000001, -1.5, -3.75, 13.450000000000001, 14.5, -2.75),
            Block.box(12.875000000000002, -1.5, -2.75, 13.875000000000002, 14.5, -1.75),
            Block.box(13.274999999999999, -1.5, -1.75, 14.274999999999999, 14.5, -0.75),
            Block.box(13.700000000000001, -1.5, -0.75, 14.700000000000001, 14.5, 0.25),
            Block.box(4, -1.5, -3, 5, 14.5, -2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape[] SHAPES = new VoxelShape[8];
    private static final VoxelShape[] SHAPES_OPEN = new VoxelShape[8];

    static {
        SHAPES[0] = ShapeUtil.rotateShape(BASE_UPPER_SHAPE, Direction.SOUTH); //South
        SHAPES[1] = ShapeUtil.rotateShape(BASE_UPPER_SHAPE, Direction.WEST); //West
        SHAPES[2] = ShapeUtil.rotateShape(BASE_UPPER_SHAPE, Direction.NORTH); //North
        SHAPES[3] = ShapeUtil.rotateShape(BASE_UPPER_SHAPE, Direction.EAST); //East
        SHAPES[4] = ShapeUtil.rotateShape(BASE_LOWER_SHAPE, Direction.SOUTH); //South Lower
        SHAPES[5] = ShapeUtil.rotateShape(BASE_LOWER_SHAPE, Direction.WEST); //West Lower
        SHAPES[6] = ShapeUtil.rotateShape(BASE_LOWER_SHAPE, Direction.NORTH); //North Lower
        SHAPES[7] = ShapeUtil.rotateShape(BASE_LOWER_SHAPE, Direction.EAST); //East Lower
    }
    static {
        SHAPES_OPEN[0] = ShapeUtil.rotateShape(BASE_UPPER_OPEN_SHAPE, Direction.SOUTH); //South
        SHAPES_OPEN[1] = ShapeUtil.rotateShape(BASE_UPPER_OPEN_SHAPE, Direction.WEST); //West
        SHAPES_OPEN[2] = ShapeUtil.rotateShape(BASE_UPPER_OPEN_SHAPE, Direction.NORTH); //North
        SHAPES_OPEN[3] = ShapeUtil.rotateShape(BASE_UPPER_OPEN_SHAPE, Direction.EAST); //East
        SHAPES_OPEN[4] = ShapeUtil.rotateShape(BASE_LOWER_OPEN_SHAPE, Direction.SOUTH); //South Lower
        SHAPES_OPEN[5] = ShapeUtil.rotateShape(BASE_LOWER_OPEN_SHAPE, Direction.WEST); //West Lower
        SHAPES_OPEN[6] = ShapeUtil.rotateShape(BASE_LOWER_OPEN_SHAPE, Direction.NORTH); //North Lower
        SHAPES_OPEN[7] = ShapeUtil.rotateShape(BASE_LOWER_OPEN_SHAPE, Direction.EAST); //East Lower
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        int shape = state.getValue(FACING).get2DDataValue();
        if (state.getValue(MODEL_TYPE) == WardrobeModelType.BOTTOM && !state.getValue(OPEN)) {
            return SHAPES[4 + direction.get2DDataValue()];
        } else if (state.getValue(MODEL_TYPE) == WardrobeModelType.BOTTOM && state.getValue(OPEN)) {
            return SHAPES_OPEN[4 + direction.get2DDataValue()];
        } else if (state.getValue(MODEL_TYPE) == WardrobeModelType.TOP && !state.getValue(OPEN)) {
            return SHAPES[direction.get2DDataValue()];
        } else if (state.getValue(MODEL_TYPE) == WardrobeModelType.TOP && state.getValue(OPEN)) {
            return SHAPES_OPEN[direction.get2DDataValue()];
        }
        return SHAPES[shape];
    }
}
