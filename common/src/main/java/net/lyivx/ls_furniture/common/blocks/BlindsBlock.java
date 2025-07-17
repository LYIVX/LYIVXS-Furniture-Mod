package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.blocks.properties.HorizontalConnectionType;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.registry.ModItemTags;
import net.lyivx.ls_furniture.registry.ModSoundEvents;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlindsBlock extends Block implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<HorizontalConnectionType> HORIZONTAL_CONNECTION_TYPE = ModBlockStateProperties.HORIZONTAL_CONNECTION_TYPE;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final DirectionProperty VERTICAL_CONNECTION_TYPE = ModBlockStateProperties.VERTICAL_CONNECTION_TYPE_UP_DOWN;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape NORTH = Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST = Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D);
    protected static final VoxelShape SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D);
    protected static final VoxelShape WEST = Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);



    public BlindsBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HORIZONTAL_CONNECTION_TYPE, HorizontalConnectionType.SINGLE)
                .setValue(VERTICAL_CONNECTION_TYPE, Direction.UP)
                .setValue(OPEN, false)
                //.setValue(POWERED, false)
                .setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        HorizontalConnectionType type = state.getValue(HORIZONTAL_CONNECTION_TYPE);

        return switch (state.getValue(FACING)) {
            default -> NORTH;
            case EAST -> EAST;
            case SOUTH -> SOUTH;
            case WEST -> WEST;
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        Direction facing = context.getClickedFace();

        BlockPos clickedPos = context.getClickedPos();
        Direction clickedFace = context.getClickedFace();
        BlockPos clickedFacingPos = clickedPos.relative(clickedFace);
        BlockState clickedFacingState = level.getBlockState(clickedFacingPos);

        // Smart facing, if right clicked on another curtain
        if (clickedFacingState.getBlock() instanceof BlindsBlock) {
            Direction clickedFacingFace = clickedFacingState.getValue(FACING);
            // Do not do smart placement if relative front of back of curtain
            if (clickedFacingFace != clickedFace && clickedFacingFace.getOpposite() != clickedFace) facing = clickedFacingFace;
        }
        if (facing.getAxis().isVertical()) facing = context.getHorizontalDirection().getOpposite();

        BlockState stateL = level.getBlockState(pos.relative(facing.getClockWise()));
        BlockState stateR = level.getBlockState(pos.relative(facing.getCounterClockWise()));
        boolean sideL = (stateL.getBlock() instanceof BlindsBlock && stateL.getValue(VERTICAL_CONNECTION_TYPE) == Direction.UP && (stateL.getValue(FACING) == facing));
        boolean sideR = (stateR.getBlock() instanceof BlindsBlock && stateR.getValue(VERTICAL_CONNECTION_TYPE) == Direction.UP && (stateR.getValue(FACING) == facing));

        boolean open = sideL && sideR ? stateL.getValue(OPEN) || stateR.getValue(OPEN) : (sideR ? stateR.getValue(OPEN) : (sideL ? stateL.getValue(OPEN) : true));

        if (context.getLevel().getBlockState(pos.above()).getBlock() instanceof BlindsBlock) {
            return this.defaultBlockState().setValue(FACING, facing).setValue(OPEN, open).setValue(VERTICAL_CONNECTION_TYPE, Direction.DOWN).setValue(WATERLOGGED, level.getFluidState(pos).getType() == Fluids.WATER);
        }

        return this.defaultBlockState().setValue(FACING, facing).setValue(OPEN, open).setValue(WATERLOGGED, level.getFluidState(pos).getType() == Fluids.WATER);
    }

    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {

    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        Direction facing = state.getValue(FACING);
        Direction facing_vertical = state.getValue(VERTICAL_CONNECTION_TYPE);

        if (direction != facing.getClockWise() && direction != facing.getCounterClockWise()) return state;

        BlockState stateL = level.getBlockState(currentPos.relative(facing.getClockWise()));
        BlockState stateR = level.getBlockState(currentPos.relative(facing.getCounterClockWise()));
        boolean sideL = (stateL.getBlock() instanceof BlindsBlock && stateL.getValue(VERTICAL_CONNECTION_TYPE) == facing_vertical && (stateL.getValue(FACING) == facing));
        boolean sideR = (stateR.getBlock() instanceof BlindsBlock && stateR.getValue(VERTICAL_CONNECTION_TYPE) == facing_vertical && (stateR.getValue(FACING) == facing));
        HorizontalConnectionType type = sideL && sideR ? HorizontalConnectionType.MIDDLE : (sideR ? HorizontalConnectionType.LEFT : (sideL ? HorizontalConnectionType.RIGHT : HorizontalConnectionType.SINGLE));

        return state.setValue(HORIZONTAL_CONNECTION_TYPE, type);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
        super.neighborChanged(state, level, pos, neighborBlock, fromPos, moving);

        if (level.getBlockState(pos.above()).getBlock() instanceof BlindsBlock) {
            BlockState newState = state.setValue(VERTICAL_CONNECTION_TYPE, Direction.DOWN);
            level.setBlock(pos, newState, 3); // Replace '3' with the appropriate block update flag if needed
        } else if (!(level.getBlockState(pos.above()).getBlock() instanceof BlindsBlock)) {
            BlockState newState = state.setValue(VERTICAL_CONNECTION_TYPE, Direction.UP);
            level.setBlock(pos, newState, 3); // Replace '3' with the appropriate block update flag if needed
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getItemInHand(hand).is(ModItemTags.BLINDS) && state.getValue(FACING) == Direction.UP && hit.getDirection() == Direction.UP) {
            return InteractionResult.FAIL;
        }

        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if (item instanceof WrenchItem) {
            return InteractionResult.FAIL;
        }

        if (state.getValue(WATERLOGGED)) level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));

        if (state.getValue(VERTICAL_CONNECTION_TYPE) == Direction.UP) toggleFromTop(state, level, pos);
        else toggleFromTop(level.getBlockState(pos.above()), level, pos.above());


        level.playSound(null, pos, ModSoundEvents.BLINDS.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    public void toggleFromTop(BlockState state, Level level, BlockPos pos) {
        boolean open = !state.getValue(OPEN);
        Direction facing = state.getValue(FACING);
        Direction relativeLeft = facing.getClockWise();
        Direction relativeRight = facing.getCounterClockWise();

        toggleVertical(state, level, pos, open);
        toggleHorizontal(state, level, pos, open, facing, relativeLeft);
        toggleHorizontal(state, level, pos, open, facing, relativeRight);
    }

    public void toggleHorizontal(BlockState state, Level level, BlockPos pos, boolean open, Direction facing, Direction dir) {
        BlockPos facingHorizontalPos = pos.relative(dir);
        BlockState facingHorizontalState = level.getBlockState(facingHorizontalPos);

        if (facingHorizontalState.getBlock() instanceof BlindsBlock && facingHorizontalState.getValue(FACING) == facing &&
                state.getValue(VERTICAL_CONNECTION_TYPE) == facingHorizontalState.getValue(VERTICAL_CONNECTION_TYPE)) {
            toggleVertical(facingHorizontalState, level, facingHorizontalPos, open);
            toggleHorizontal(facingHorizontalState, level, facingHorizontalPos, open, facing, dir);
        }
    }

    public void toggleVertical(BlockState state, Level level, BlockPos pos, boolean open) {
        // To keep track of the positions we've already processed to avoid infinite loops
        Set<BlockPos> processed = new HashSet<>();
        toggleVerticalRecursive(state, level, pos, open, processed);
    }

    private void toggleVerticalRecursive(BlockState state, Level level, BlockPos pos, boolean open, Set<BlockPos> processed) {
        // Check if we've already processed this position
        if (processed.contains(pos)) {
            return;
        }

        // Mark this position as processed
        processed.add(pos);

        // Update the current block's state
        level.setBlockAndUpdate(pos, state.setValue(OPEN, open));

        // Get the direction of the blinds
        Direction verticalDirection = state.getValue(VERTICAL_CONNECTION_TYPE);

        // Calculate the next position in the vertical direction
        BlockPos nextPos = pos.relative(verticalDirection);
        BlockState nextState = level.getBlockState(nextPos);

        // Recursively toggle all vertically connected blinds in the positive direction
        if (nextState.getBlock() instanceof BlindsBlock && nextState.getValue(VERTICAL_CONNECTION_TYPE) == verticalDirection) {
            toggleVerticalRecursive(nextState, level, nextPos, open, processed);
        }

        // Calculate the previous position in the vertical direction
        BlockPos prevPos = pos.relative(verticalDirection.getOpposite());
        BlockState prevState = level.getBlockState(prevPos);

        // Recursively toggle all vertically connected blinds in the negative direction
        if (prevState.getBlock() instanceof BlindsBlock && prevState.getValue(VERTICAL_CONNECTION_TYPE) == verticalDirection.getOpposite()) {
            toggleVerticalRecursive(prevState, level, prevPos, open, processed);
        }
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HORIZONTAL_CONNECTION_TYPE, OPEN, VERTICAL_CONNECTION_TYPE, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.properties"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.wrenchable"));
        } else {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }

    public List<Property<?>> getWrenchableProperties() {
        return List.of(FACING);
    }
}