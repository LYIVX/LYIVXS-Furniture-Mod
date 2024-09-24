package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.common.blocks.entity.LockableBlockEntity;
import net.lyivx.ls_furniture.common.blocks.entity.RailingBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.SawItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.common.utils.block.ILockable;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class RailingBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock, HammerItem.HammerableBlock {
    public static final MapCodec<RailingBlock> CODEC = simpleCodec(RailingBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty NORTH_RAILING = ModBlockStateProperties.NORTH_RAILING;
    public static final BooleanProperty EAST_RAILING = ModBlockStateProperties.EAST_RAILING;
    public static final BooleanProperty SOUTH_RAILING = ModBlockStateProperties.SOUTH_RAILING;
    public static final BooleanProperty WEST_RAILING = ModBlockStateProperties.WEST_RAILING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty UPDATE = ModBlockStateProperties.UPDATE;

    protected static final VoxelShape RAILING_NORTH = Stream.of(
            Block.box(3, 0, 0, 5, 14, 2),
            Block.box(11, 0, 0, 13, 14, 2),
            Block.box(0, 14, 0, 16, 16, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape RAILING_EAST = ShapeUtil.rotateShape(RAILING_NORTH, Direction.EAST);
    protected static final VoxelShape RAILING_SOUTH = ShapeUtil.rotateShape(RAILING_NORTH, Direction.SOUTH);
    protected static final VoxelShape RAILING_WEST = ShapeUtil.rotateShape(RAILING_NORTH, Direction.WEST);

    public RailingBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(NORTH_RAILING, true)
                .setValue(EAST_RAILING, false)
                .setValue(SOUTH_RAILING, false)
                .setValue(WEST_RAILING, false)
                .setValue(WATERLOGGED, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape shape = Shapes.empty(); // Start with an empty shape

        if (state.getValue(NORTH_RAILING)) {
            shape = Shapes.or(shape, RAILING_NORTH); // Add NORTH railing
        }
        if (state.getValue(EAST_RAILING)) {
            shape = Shapes.or(shape, RAILING_EAST); // Add EAST railing
        }
        if (state.getValue(SOUTH_RAILING)) {
            shape = Shapes.or(shape, RAILING_SOUTH); // Add SOUTH railing
        }
        if (state.getValue(WEST_RAILING)) {
            shape = Shapes.or(shape, RAILING_WEST); // Add WEST railing
        }

        return shape;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getHorizontalDirection();
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;

        // Initialize railing states
        boolean railing1 = false;
        boolean railing2 = false;
        boolean railing3 = false;
        boolean railing4 = false;

        // Determine the railing states based on the facing direction
        switch (facing) {
            case NORTH -> railing1 = true;
            case SOUTH -> railing3 = true;
            case EAST -> railing2 = true;
            case WEST -> railing4 = true;
            default -> {
                // Handle unexpected directions (though this case should not normally occur)
                railing1 = false;
                railing2 = false;
                railing3 = false;
                railing4 = false;
            }
        }

        // Create and return the block state
        return this.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(NORTH_RAILING, railing1)
                .setValue(EAST_RAILING, railing2)
                .setValue(SOUTH_RAILING, railing3)
                .setValue(WEST_RAILING, railing4)
                .setValue(WATERLOGGED, waterlogged);
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if (item instanceof HammerItem || item instanceof WrenchItem || item instanceof SawItem) {
            return InteractionResult.FAIL;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof ILockable lockable && lockable.isLocked()) {
            player.displayClientMessage(Component.translatable("msg.ls_furniture.locked"), true);
            return InteractionResult.FAIL;
        }

        Direction facing = state.getValue(FACING);

        if (!player.isCreative()) {
            player.getItemInHand(hand).shrink(1);
        }

        Direction hitFace = hit.getDirection();
        Vec3 hitPosition = hit.getLocation();
        double xOffset = hitPosition.x - pos.getX();
        double zOffset = hitPosition.z - pos.getZ();

        if (item == this.asItem()) {
            if (xOffset > 0.01 && xOffset < 0.99 && zOffset > 0.01 && zOffset < 0.99) {

                if (hitFace == Direction.SOUTH) {
                    if (zOffset < 0.5) {
                        if (xOffset < 0.5) {
                            level.setBlock(pos, state.setValue(WEST_RAILING, true), 3);
                            return InteractionResult.SUCCESS;
                        } else {
                            level.setBlock(pos, state.setValue(EAST_RAILING, true), 3);
                            return InteractionResult.SUCCESS;
                        }
                    }
                }
                if (hitFace == Direction.WEST) {
                    if (xOffset < 0.5) {
                        return InteractionResult.SUCCESS;
                    } else {
                        if (zOffset < 0.5) {
                            level.setBlock(pos, state.setValue(NORTH_RAILING, true), 3);
                            return InteractionResult.SUCCESS;
                        } else {
                            level.setBlock(pos, state.setValue(SOUTH_RAILING, true), 3);
                            return InteractionResult.SUCCESS;
                        }
                    }
                }
                if (hitFace == Direction.EAST) {
                    if (xOffset < 0.5) {
                        if (zOffset < 0.5) {
                            level.setBlock(pos, state.setValue(NORTH_RAILING, true), 3);
                            return InteractionResult.SUCCESS;
                        } else {
                            level.setBlock(pos, state.setValue(SOUTH_RAILING, true), 3);
                            return InteractionResult.SUCCESS;
                        }
                    } else {
                        return InteractionResult.SUCCESS;
                    }
                }
                if (hitFace == Direction.NORTH) {
                    if (zOffset < 0.5) {
                        return InteractionResult.SUCCESS;
                    } else {
                        if (xOffset < 0.5) {
                            level.setBlock(pos, state.setValue(WEST_RAILING, true), 3);
                            return InteractionResult.SUCCESS;
                        } else {
                            level.setBlock(pos, state.setValue(EAST_RAILING, true), 3);
                            return InteractionResult.SUCCESS;
                        }
                    }
                }
            } else return InteractionResult.FAIL;
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));

        BlockEntity blockEntity = level.getBlockEntity(currentPos);
        if (blockEntity instanceof ILockable lockable && lockable.isLocked()) {
            return state; // Return the current state if the block is locked
        }

        return state;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, NORTH_RAILING, EAST_RAILING, SOUTH_RAILING, WEST_RAILING, UPDATE, WATERLOGGED);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        boolean leg1 = state.getValue(NORTH_RAILING);
        boolean leg2 = state.getValue(EAST_RAILING);
        boolean leg3 = state.getValue(SOUTH_RAILING);
        boolean leg4 = state.getValue(WEST_RAILING);
        return switch(rotation) {
            case NONE -> state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
            case CLOCKWISE_90 -> state
                    .setValue(FACING, rotation.rotate(state.getValue(FACING)))
                    .setValue(NORTH_RAILING, leg4)
                    .setValue(EAST_RAILING, leg1)
                    .setValue(SOUTH_RAILING, leg2)
                    .setValue(WEST_RAILING, leg3);
            case CLOCKWISE_180 -> state
                    .setValue(FACING, rotation.rotate(state.getValue(FACING)))
                    .setValue(NORTH_RAILING, leg3)
                    .setValue(EAST_RAILING, leg4)
                    .setValue(SOUTH_RAILING, leg1).setValue(WEST_RAILING, leg2);
            case COUNTERCLOCKWISE_90 -> state
                    .setValue(FACING, rotation.rotate(state.getValue(FACING)))
                    .setValue(NORTH_RAILING, leg2)
                    .setValue(EAST_RAILING, leg3)
                    .setValue(SOUTH_RAILING, leg4)
                    .setValue(WEST_RAILING, leg1);
        };
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL; // Critical for visibility
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.properties"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.connectable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.lockable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.hammerable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.wrenchable"));
        } else {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }

    public List<Property<?>> getHammerableProperties() {
        return List.of(NORTH_RAILING, EAST_RAILING, SOUTH_RAILING, WEST_RAILING);
    }

    public List<Property<?>> getWrenchableProperties() {
        return List.of(FACING);
    }

    @Override
    public BlockState updateAfterCycle(BlockState state, LevelAccessor level, BlockPos pos) {
        return WrenchItem.WrenchableBlock.super.updateAfterCycle(state, level, pos);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RailingBlockEntity(pos, state);
    }
}