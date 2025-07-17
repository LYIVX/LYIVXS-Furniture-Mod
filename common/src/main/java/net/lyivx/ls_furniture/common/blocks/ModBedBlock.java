package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_core.common.utils.WoolHelper;
import net.lyivx.ls_furniture.common.blocks.entity.LockableBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.ColorType;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class ModBedBlock extends BedBlock implements EntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<BedPart> PART = BlockStateProperties.BED_PART;
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;
    public static final EnumProperty<ColorType> COLOR = ModBlockStateProperties.COLOR;


    public ModBedBlock(Properties properties) {
        super(DyeColor.WHITE, properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any())
                .setValue(PART, BedPart.FOOT))
                .setValue(OCCUPIED, false)
                .setValue(COLOR, ColorType.DEFAULT));
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, COLOR, PART, OCCUPIED);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LockableBlockEntity(pos, state);
    }

    private static Direction getNeighbourDirection(BedPart part, Direction direction) {
        return part == BedPart.FOOT ? direction : direction.getOpposite();
    }

    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide && player.isCreative()) {
            BedPart bedPart = (BedPart)state.getValue(PART);
            if (bedPart == BedPart.FOOT) {
                BlockPos blockPos = pos.relative(getNeighbourDirection(bedPart, (Direction)state.getValue(FACING)));
                BlockState blockState = level.getBlockState(blockPos);
                if (blockState.is(this) && blockState.getValue(PART) == BedPart.HEAD) {
                    level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 35);
                    level.levelEvent(player, 2001, blockPos, Block.getId(blockState));
                }
            }
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    public static ColorType getColorTypeFromDye(DyeColor dyeColor) {
        for (ColorType colorType : ColorType.values()) {
            if (colorType.getDyeColor() == dyeColor) {
                return colorType;
            }
        }
        return ColorType.WHITE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        DyeColor woolDye = WoolHelper.getDyeColor(stack.getItem());
        if (woolDye != null && (state.getValue(COLOR) == ColorType.DEFAULT)) {
            ColorType newColorType = getColorTypeFromDye(woolDye);

            state = state.setValue(COLOR, newColorType);

            if (!player.isCreative()) {
                stack.shrink(1);
            }

            level.setBlock(pos, state, Block.UPDATE_ALL);
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);

            return InteractionResult.SUCCESS;
        }

        DyeColor dye = stack.getItem() instanceof DyeItem dyeItem ? dyeItem.getDyeColor() : null;
        if (dye != null && (state.getValue(COLOR) != ColorType.DEFAULT)) {
            ColorType newColorType = getColorTypeFromDye(dye);

            state = state.setValue(COLOR, newColorType);

            if (!player.isCreative()) {
                stack.shrink(1);
            }

            level.setBlock(pos, state, Block.UPDATE_ALL);
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);

            return InteractionResult.SUCCESS;
        }

        if (stack.is(ModItems.SHEARS.get()) && (state.getValue(COLOR) != ColorType.DEFAULT)) {
            dropCushion(state, level, pos);
            state = state.setValue(COLOR, ColorType.DEFAULT);

            level.setBlock(pos, state, Block.UPDATE_ALL);
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.SUCCESS;
    }

    private boolean kickVillagerOutOfBed(Level level, BlockPos pos) {
        List<Villager> list = level.getEntitiesOfClass(Villager.class, new AABB(pos), LivingEntity::isSleeping);
        if (list.isEmpty()) {
            return false;
        } else {
            ((Villager)list.get(0)).stopSleeping();
            return true;
        }
    }

    @Override
    public void onRemove(BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean moving) {
        if (!state.is(newState.getBlock())) {
            dropCushion(state, level, pos);
        }
        super.onRemove(state, level, pos, newState, moving);
    }

    public void dropCushion(BlockState state, Level level, BlockPos pos) {
        if (state.hasProperty(COLOR) && state.getValue(COLOR) != ColorType.DEFAULT) {
            Block block = WoolHelper.getBlock(state.getValue(COLOR).getDyeColor());
            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(block != null ? block : Blocks.WHITE_WOOL));
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
            return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING).getOpposite();
        int shape = state.getValue(FACING).get2DDataValue();
        if (state.getValue(PART) == BedPart.HEAD) {
            return SHAPES[direction.get2DDataValue()];
        } else if (state.getValue(PART) == BedPart.FOOT) {
            return SHAPES[4 + direction.get2DDataValue()];
        }
        return SHAPES[shape];
    }

    private static final VoxelShape HEAD_SHAPE = Stream.of(
            Block.box(0, 0, -16, 2, 2, -14),
            Block.box(0, 2, 12, 16, 6.5, 16),
            Block.box(0, 6, 12.45, 16, 10.5, 16),
            Block.box(0, 10, 13.2, 16, 12, 16.75),
            Block.box(0, 12, 13.95, 16, 14, 17.5),
            Block.box(0, 2, -16, 16, 6.5, 12),
            Block.box(14, 0, -16, 16, 2, -14),
            Block.box(14, 0, 14, 16, 2, 16),
            Block.box(0, 0, 14, 2, 2, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape FOOT_SHAPE = Stream.of(
            Block.box(0, 0, 0, 2, 2, 2),
            Block.box(0, 2, 28, 16, 6.5, 32),
            Block.box(0, 6, 28.45, 16, 10.5, 32),
            Block.box(0, 10, 29.2, 16, 12, 32.75),
            Block.box(0, 12, 29.95, 16, 14, 33.5),
            Block.box(0, 2, 0, 16, 6.5, 28),
            Block.box(14, 0, 0, 16, 2, 2),
            Block.box(14, 0, 30, 16, 2, 32),
            Block.box(0, 0, 30, 2, 2, 32)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape[] SHAPES = new VoxelShape[8];

    static {
        SHAPES[0] = ShapeUtil.rotateShape(HEAD_SHAPE, Direction.SOUTH); //South
        SHAPES[1] = ShapeUtil.rotateShape(HEAD_SHAPE, Direction.WEST); //West
        SHAPES[2] = ShapeUtil.rotateShape(HEAD_SHAPE, Direction.NORTH); //North
        SHAPES[3] = ShapeUtil.rotateShape(HEAD_SHAPE, Direction.EAST); //East
        SHAPES[4] = ShapeUtil.rotateShape(FOOT_SHAPE, Direction.SOUTH); //South Lower
        SHAPES[5] = ShapeUtil.rotateShape(FOOT_SHAPE, Direction.WEST); //West Lower
        SHAPES[6] = ShapeUtil.rotateShape(FOOT_SHAPE, Direction.NORTH); //North Lower
        SHAPES[7] = ShapeUtil.rotateShape(FOOT_SHAPE, Direction.EAST); //East Lower
    }
}
