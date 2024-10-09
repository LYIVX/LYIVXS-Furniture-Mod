package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.common.blocks.entity.CounterOvenBlockEntity;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class CounterOvenBlock extends AbstractFurnaceBlock implements WrenchItem.WrenchableBlock {
    public static final MapCodec<CounterOvenBlock> CODEC = simpleCodec(CounterOvenBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    protected static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.box(0, 0, 1, 16, 14, 16),
            Block.box(0, 14, 0, 16, 16, 16),
            Block.box(4, 11, -1, 12, 12, 0),
            Block.box(12, 11, -1, 13, 12, 1),
            Block.box(3, 11, -1, 4, 12, 1),
            Block.box(0, 16, 15, 16, 18, 16),
            Block.box(2, 16, 2, 7, 17, 7),
            Block.box(2.5, 16, 8.5, 6.5, 17, 12.5),
            Block.box(9.5, 16, 2.5, 13.5, 17, 6.5),
            Block.box(9, 16, 8, 14, 17, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.WEST);

    protected static final VoxelShape SHAPE_NORTH_OPEN = Stream.of(
            Block.box(9, 16, 8, 14, 17, 13),
            Block.box(0, 0, 1, 16, 2, 16),
            Block.box(0, 12, 1, 16, 14, 16),
            Block.box(0, 14, 0, 16, 16, 16),
            Block.box(0, 16, 15, 16, 18, 16),
            Block.box(0, 2, 1, 2, 12, 14),
            Block.box(14, 2, 1, 16, 12, 14),
            Block.box(13, 4, 2, 14, 5, 14),
            Block.box(2, 4, 2, 3, 5, 14),
            Block.box(3, 2, 2, 13, 3, 13),
            Block.box(2, 5, -3.9000000000000004, 14, 6, 9),
            Block.box(2, 2, 0.5, 14, 3, 1.5),
            Block.box(2, 2.4, -0.5, 14, 3.4, 0.5),
            Block.box(2, 2.8499999999999996, -1.5, 14, 3.8499999999999996, -0.5),
            Block.box(2, 3.25, -2.5, 14, 4.25, -1.5),
            Block.box(2, 3.6999999999999997, -3.5, 14, 4.700000000000001, -2.5),
            Block.box(2, 4.1, -4.5, 14, 5.1, -3.5),
            Block.box(2, 4.949999999999999, -6.5, 14, 5.949999999999999, -5.5),
            Block.box(2, 5.349999999999998, -7.5, 14, 6.349999999999998, -6.5),
            Block.box(2, 5.649999999999999, -8.3, 14, 6.649999999999999, -7.300000000000001),
            Block.box(12, 4.349999999999998, -8.6, 13, 5.349999999999998, -7.6),
            Block.box(12, 5.349999999999998, -8.4, 13, 6.349999999999998, -7.4),
            Block.box(3, 5.349999999999998, -8.4, 4, 6.349999999999998, -7.4),
            Block.box(3, 4.349999999999998, -8.6, 4, 5.349999999999998, -7.6),
            Block.box(3, 3.849999999999998, -8.9, 13, 4.349999999999998, -7.9),
            Block.box(2, 4.5, -5.5, 14, 5.5, -4.5),
            Block.box(0, 2, 14, 16, 12, 16),
            Block.box(2, 16, 2, 7, 17, 7),
            Block.box(2.5, 16, 8.5, 6.5, 17, 12.5),
            Block.box(9.5, 16, 2.5, 13.5, 17, 6.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.WEST);
    protected static final VoxelShape[] SHAPES = new VoxelShape[] {
            SHAPE_SOUTH, SHAPE_WEST, SHAPE_NORTH, SHAPE_EAST,
            SHAPE_SOUTH_OPEN, SHAPE_WEST_OPEN, SHAPE_NORTH_OPEN, SHAPE_EAST_OPEN
    };

    public CounterOvenBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(OPEN, false)
                .setValue(LIT, false));
    }

    @Override
    protected MapCodec<? extends AbstractFurnaceBlock> codec() {
        return CODEC;
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CounterOvenBlockEntity(pos, state);
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CounterOvenBlockEntity counterOvenBE) counterOvenBE.recheckOpen();
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createFurnaceTicker(level, blockEntityType, ModBlockEntitys.COUNTER_OVEN_ENTITY.get());
    }

    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CounterOvenBlockEntity) {
            player.openMenu((MenuProvider)blockEntity);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }

    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if ((Boolean)state.getValue(LIT)) {
            double d = (double)pos.getX() + 0.5;
            double e = (double)pos.getY();
            double f = (double)pos.getZ() + 0.5;
            if (random.nextDouble() < 0.1) {
                level.playLocalSound(d, e, f, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = (Direction)state.getValue(FACING);
            Direction.Axis axis = direction.getAxis();
            double g = 0.52;
            double h = random.nextDouble() * 0.6 - 0.3;
            double i = axis == Axis.X ? (double)direction.getStepX() * 0.52 : h;
            double j = random.nextDouble() * 6.0 / 16.0;
            double k = axis == Axis.Z ? (double)direction.getStepZ() * 0.52 : h;
            level.addParticle(ParticleTypes.SMOKE, d + i, e + j, f + k, 0.0, 0.0, 0.0);
            level.addParticle(ParticleTypes.FLAME, d + i, e + j, f + k, 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CounterOvenBlockEntity) {
            player.openMenu((MenuProvider)blockEntity);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }

        return InteractionResult.CONSUME;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = stack.getItem();
        if (item instanceof WrenchItem) {
            return ItemInteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN, LIT);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int shape = state.getValue(FACING).get2DDataValue();
        if (state.getValue(OPEN)) shape += 4;
        return SHAPES[shape];
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.properties"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.wrenchable"));
        } else {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, context, tooltip, flag);
    }

    public List<Property<?>> getWrenchableProperties() {
        return List.of(FACING);
    }
}
