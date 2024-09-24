package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.common.blocks.entity.FridgeBlockEntity;
import net.lyivx.ls_furniture.common.blocks.entity.FreezerBlockEntity;
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
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.stream.Stream;

public class FridgeFreezerBlock extends BaseEntityBlock {
    public static final MapCodec<FridgeFreezerBlock> CODEC = simpleCodec(FridgeFreezerBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final EnumProperty<FridgeModelType> MODEL_TYPE = EnumProperty.create("model", FridgeModelType.class);


    public FridgeFreezerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(MODEL_TYPE, FridgeModelType.BOTTOM)
                .setValue(OPEN, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
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
        if (state.getValue(MODEL_TYPE) == FridgeModelType.BOTTOM) {
            if (blockEntity instanceof FridgeBlockEntity fridgeBlockEntity) {
                player.openMenu(fridgeBlockEntity);
                PiglinAi.angerNearbyPiglins(player, true);
                return InteractionResult.SUCCESS;
            }
        } else if (state.getValue(MODEL_TYPE) == FridgeModelType.TOP ) {
            if (blockEntity instanceof FreezerBlockEntity freezerBlockEntity) {
                player.openMenu(freezerBlockEntity);
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

    private static Direction getNeighbourDirection(FridgeModelType modelType) {
        return modelType == FridgeModelType.BOTTOM ? Direction.UP : Direction.DOWN;
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            FridgeModelType modelType = state.getValue(MODEL_TYPE);
            BlockPos otherPos = pos.relative(getNeighbourDirection(modelType));
            BlockState otherState = level.getBlockState(otherPos);

            if (otherState.getBlock() == this && otherState.getValue(MODEL_TYPE) != modelType) {
                BlockPos bottomPos = modelType == FridgeModelType.BOTTOM ? pos : otherPos;
                BlockPos topPos = modelType == FridgeModelType.TOP ? pos : otherPos;

                // Destroy bottom part
                level.setBlock(bottomPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.levelEvent(player, 2001, bottomPos, Block.getId(state));

                // Destroy top part
                level.setBlock(topPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.levelEvent(player, 2001, topPos, Block.getId(otherState));

                if (!player.isCreative()) {
                    dropResources(state, level, pos, null, player, player.getMainHandItem());
                    dropResources(otherState, level, otherPos, null, player, player.getMainHandItem());
                }
            }
        }

        return super.playerWillDestroy(level, pos, state, player);
    }


    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (!level.isClientSide) {
            level.setBlock(pos.above(), state.setValue(MODEL_TYPE, FridgeModelType.TOP), Block.UPDATE_ALL);
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
        if (blockEntity instanceof FridgeBlockEntity fridgeBE) fridgeBE.recheckOpen();
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        if (state.getValue(MODEL_TYPE) == FridgeModelType.TOP ) {
            return new FreezerBlockEntity(pos, state);
        } return new FridgeBlockEntity(pos, state);
    }


    public enum FridgeModelType implements StringRepresentable {
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
            Block.box(0, 0, 1, 16, 32, 16),
            Block.box(2, 2, 0, 14, 21, 1),
            Block.box(2, 24, 0, 14, 30, 1),
            Block.box(12, 28, -1, 13, 29, 0),
            Block.box(12, 25, -1, 13, 26, 0),
            Block.box(12, 25, -2, 13, 29, -1),
            Block.box(12, 16, -2, 13, 20, -1),
            Block.box(12, 19, -1, 13, 20, 0),
            Block.box(12, 16, -1, 13, 17, 0)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BASE_UPPER_SHAPE = Stream.of(
            Block.box(0, -16, 1, 16, 16, 16),
            Block.box(2, -14, 0, 14, 5, 1),
            Block.box(2, 8, 0, 14, 14, 1),
            Block.box(12, 12, -1, 13, 13, 0),
            Block.box(12, 9, -1, 13, 10, 0),
            Block.box(12, 9, -2, 13, 13, -1),
            Block.box(12, 0, -2, 13, 4, -1),
            Block.box(12, 3, -1, 13, 4, 0),
            Block.box(12, 0, -1, 13, 1, 0)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BASE_LOWER_OPEN_SHAPE = Stream.of(
            Block.box(0, 0, 1, 16, 2, 16),
            Block.box(0, 21, 1, 16, 32, 16),
            Block.box(2, 24, 0, 14, 30, 1),
            Block.box(12, 28, -1, 13, 29, 0),
            Block.box(12, 25, -1, 13, 26, 0),
            Block.box(12, 25, -2, 13, 29, -1),
            Block.box(0, 2, 1, 2, 21, 16),
            Block.box(14, 2, 1, 16, 21, 16),
            Block.box(2, 2, 14, 14, 21, 16),
            Block.box(2, 8, 2, 14, 9, 14),
            Block.box(2, 15, 2, 14, 16, 14),
            Block.box(1, 2, 0, 3, 21, 2),
            Block.box(2, 2, -1, 4, 21, 1),
            Block.box(3, 2, -2, 5, 21, 0),
            Block.box(4, 2, -3, 6, 21, -1),
            Block.box(5, 2, -4, 7, 21, -2),
            Block.box(6, 2, -5, 8, 21, -3),
            Block.box(7, 2, -6, 9, 21, -4),
            Block.box(8, 2, -7, 10, 21, -5),
            Block.box(9, 2, -8, 11, 21, -6),
            Block.box(8, 16, -8, 9, 20, -7),
            Block.box(7, 16, -9, 8, 20, -8),
            Block.box(7.5, 16, -8.5, 8.5, 20, -7.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BASE_UPPER_OPEN_SHAPE = Stream.of(
            Block.box(0, 14, 1, 16, 16, 16),
            Block.box(0, 7, 1, 2, 14, 16),
            Block.box(14, 7, 1, 16, 14, 16),
            Block.box(2, 7, 14, 14, 14, 16),
            Block.box(1, 8, 0, 3, 14, 2),
            Block.box(2, 8, -1, 4, 14, 1),
            Block.box(3, 8, -2, 5, 14, 0),
            Block.box(4, 8, -3, 6, 14, -1),
            Block.box(5, 8, -4, 7, 14, -2),
            Block.box(6, 8, -5, 8, 14, -3),
            Block.box(7, 8, -6, 9, 14, -4),
            Block.box(8, 8, -7, 10, 14, -5),
            Block.box(9, 8, -8, 11, 14, -6),
            Block.box(8, 9, -8, 9, 13, -7),
            Block.box(7, 9, -9, 8, 13, -8),
            Block.box(7.5, 9, -8.5, 8.5, 13, -7.5),
            Block.box(2, 7, 1, 14, 8, 3),
            Block.box(0, -16, 1, 16, 7, 16),
            Block.box(2, -14, 0, 14, 5, 2),
            Block.box(12, 3, -1, 13, 4, 0),
            Block.box(12, 0, -1, 13, 1, 0),
            Block.box(12, 0, -2, 13, 4, -1)
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
        if (state.getValue(MODEL_TYPE) == FridgeModelType.BOTTOM && !state.getValue(OPEN)) {
            return SHAPES[4 + direction.get2DDataValue()];
        } else if (state.getValue(MODEL_TYPE) == FridgeModelType.BOTTOM && state.getValue(OPEN)) {
            return SHAPES_OPEN[4 + direction.get2DDataValue()];
        } else if (state.getValue(MODEL_TYPE) == FridgeModelType.TOP && !state.getValue(OPEN)) {
            return SHAPES[direction.get2DDataValue()];
        } else if (state.getValue(MODEL_TYPE) == FridgeModelType.TOP && state.getValue(OPEN)) {
            return SHAPES_OPEN[direction.get2DDataValue()];
        }
        return SHAPES[shape];
    }
}
