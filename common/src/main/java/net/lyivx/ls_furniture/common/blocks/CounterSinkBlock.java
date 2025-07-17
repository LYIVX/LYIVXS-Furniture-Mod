package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.blocks.entity.CounterSinkBlockEntity;
import net.lyivx.ls_furniture.common.blocks.entity.LiquidHolderBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.FluidInteractionUtil;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.config.ConfigProvider;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
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
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class CounterSinkBlock extends Block implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock, EntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty HAS_WATER = ModBlockStateProperties.HAS_WATER;

    protected static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.box(0, 16, 15, 16, 18, 16),
            Block.box(0, 14, 0, 2, 16, 16),
            Block.box(2, 14, 0, 14, 16, 2),
            Block.box(14, 14, 0, 16, 16, 16),
            Block.box(2, 14, 13, 14, 16, 16),
            Block.box(0, 0, 1, 2, 14, 16),
            Block.box(14, 0, 1, 16, 14, 16),
            Block.box(2, 0, 14, 14, 14, 16),
            Block.box(2, 12, 1, 14, 14, 3),
            Block.box(2, 0, 1, 14, 12, 14),
            Block.box(3, 11, 4, 13, 13, 12),
            Block.box(13, 13, 2, 15, 17, 14),
            Block.box(1, 13, 2, 3, 17, 14),
            Block.box(3, 13, 12, 13, 17, 14),
            Block.box(3, 13, 3, 13, 17, 4),
            Block.box(3, 14, 2, 13, 17, 3),
            Block.box(7, 17, 12, 9, 20, 14),
            Block.box(7, 20, 9, 9, 22, 14),
            Block.box(7.5, 19, 9.5, 8.5, 20, 10.5),
            Block.box(4, 17.4, 11.5, 5, 18.4, 12.5),
            Block.box(4, 17.4, 13.5, 5, 18.4, 14.5),
            Block.box(5, 17.4, 12.5, 6, 18.4, 13.5),
            Block.box(3, 17.4, 12.5, 4, 18.4, 13.5),
            Block.box(4, 17.4, 12.5, 5, 18.4, 13.5),
            Block.box(4, 17, 12.5, 5, 18, 13.5),
            Block.box(11, 17, 12.5, 12, 18, 13.5),
            Block.box(11, 17.4, 13.5, 12, 18.4, 14.5),
            Block.box(12, 17.4, 12.5, 13, 18.4, 13.5),
            Block.box(10, 17.4, 12.5, 11, 18.4, 13.5),
            Block.box(11, 17.4, 12.5, 12, 18.4, 13.5),
            Block.box(11, 17.4, 11.5, 12, 18.4, 12.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.WEST);

    protected static final VoxelShape[] SHAPES = new VoxelShape[] {
            SHAPE_SOUTH, SHAPE_WEST, SHAPE_NORTH, SHAPE_EAST
    };


    public CounterSinkBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HAS_WATER, false));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CounterSinkBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();

        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof CounterSinkBlockEntity sinkBE)) {
            return InteractionResult.FAIL;
        }

        // --- Handle Empty Hand Interaction (Fill from below) ---
        if (stack.isEmpty()) {
            BlockPos sourcePos = pos.below(2);
            FluidState fluidStateBelow = level.getFluidState(sourcePos);

            if (fluidStateBelow.isSource() && !fluidStateBelow.isEmpty()) {
                Fluid fluidBelow = fluidStateBelow.getType();
                if (!ConfigProvider.isSinkUniversal() && fluidBelow != Fluids.WATER) {
                    return InteractionResult.FAIL;
                }

                int currentAmount = sinkBE.getStoredAmount();
                int capacity = sinkBE.getCapacity();
                int amountToAdd = LiquidHolderBlockEntity.BUCKET_VOLUME;

                if ((sinkBE.isEmpty() || sinkBE.getFluid() == fluidBelow) && currentAmount + amountToAdd <= capacity) {
                    sinkBE.setFluidAndAmount(fluidBelow, currentAmount + amountToAdd);
                    level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.FAIL;
                }
            } else {
                return InteractionResult.PASS;
            }
        }
        if (item instanceof WrenchItem) {
            return InteractionResult.PASS;
        }

        // --- Handle Filling with Fluid Container ---
        Fluid fluidToFill = FluidInteractionUtil.getFluidFromItemStack(stack);
        if (fluidToFill != Fluids.EMPTY && item != Items.BUCKET) {
            if (!ConfigProvider.isSinkUniversal() && fluidToFill != Fluids.WATER) {
                return InteractionResult.FAIL;
            }

            int currentAmount = sinkBE.getStoredAmount();
            int capacity = sinkBE.getCapacity();
            int amountToAdd = LiquidHolderBlockEntity.BUCKET_VOLUME;

            if ((sinkBE.isEmpty() || sinkBE.getFluid() == fluidToFill) && currentAmount + amountToAdd <= capacity) {
                sinkBE.setFluidAndAmount(fluidToFill, currentAmount + amountToAdd);
                if (!player.isCreative()) {
                    player.setItemInHand(hand, Items.BUCKET.getDefaultInstance());
                }
                SoundEvent fillSound = null;
                if (fluidToFill == Fluids.WATER) fillSound = SoundEvents.BUCKET_EMPTY;
                else if (fluidToFill == Fluids.LAVA) fillSound = SoundEvents.BUCKET_EMPTY_LAVA;

                if (fillSound != null) {
                    level.playSound(null, pos, fillSound, SoundSource.BLOCKS, 1.0F, 1.0F);
                }
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.FAIL;
            }
        }

        // --- Handle Emptying with an Empty Bucket ---
        if (item == Items.BUCKET) {
            int currentAmount = sinkBE.getStoredAmount();
            int amountToRemove = LiquidHolderBlockEntity.BUCKET_VOLUME;
            Fluid fluidInSink = sinkBE.getFluid();

            if (!sinkBE.isEmpty() && currentAmount >= amountToRemove) {
                Item filledBucketItem = fluidInSink.getBucket();
                if (filledBucketItem != Items.AIR) {
                    sinkBE.setFluidAndAmount(fluidInSink, currentAmount - amountToRemove);
                    if (!player.isCreative()) {
                        ItemStack filledBucketStack = filledBucketItem.getDefaultInstance();
                        stack.shrink(1);
                        if (stack.isEmpty()) {
                            player.setItemInHand(hand, filledBucketStack);
                        } else if (!player.getInventory().add(filledBucketStack)) {
                            player.drop(filledBucketStack, false);
                        }
                    }
                    SoundEvent emptySound = null;
                    if (fluidInSink == Fluids.WATER) emptySound = SoundEvents.BUCKET_FILL;
                    else if (fluidInSink == Fluids.LAVA) emptySound = SoundEvents.BUCKET_FILL_LAVA;

                    if (emptySound != null) {
                        level.playSound(null, pos, emptySound, SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.FAIL;
                }
            } else {
                return InteractionResult.FAIL;
            }
        }

        // Default case if item interaction wasn't handled
        return InteractionResult.CONSUME;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());

    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int shape = state.getValue(FACING).get2DDataValue();
        return SHAPES[shape];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED,HAS_WATER);
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