package net.lyivx.ls_furniture.common.blocks;

import com.google.common.base.Ticker;
import dev.architectury.event.events.common.TickEvent;
import net.lyivx.ls_furniture.common.blocks.entity.MailboxBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.ColorType;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.lyivx.ls_furniture.registry.ModBlocksTags;
import net.lyivx.ls_furniture.registry.ModSoundEvents;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MailboxBlock extends BaseEntityBlock implements WrenchItem.WrenchableBlock {
    public static ArrayList<MailboxBlock> ALL_MAILBOXES = new ArrayList<>();
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty HAS_MAIL = ModBlockStateProperties.HAS_MAIL;

    protected static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.box(7, 0, 7, 9, 10, 9),
            Block.box(5, 10, 3.5, 11, 12, 12.5),
            Block.box(9, 12, 3.5, 11, 13, 12.5),
            Block.box(5, 12, 3.5, 7, 13, 12.5),
            Block.box(6, 13, 3.5, 7, 14, 12.5),
            Block.box(9, 13, 3.5, 10, 14, 12.5),
            Block.box(7, 14, 3.5, 9, 15, 12.5),
            Block.box(7, 12, 11.5, 9, 14, 12.5),
            Block.box(4, 12, 3, 5, 13, 13),
            Block.box(5, 13, 3, 6, 14, 13),
            Block.box(6, 14, 3, 7, 15, 13),
            Block.box(7, 15, 3, 9, 16, 13),
            Block.box(9, 14, 3, 10, 15, 13),
            Block.box(10, 13, 3, 11, 14, 13),
            Block.box(11, 12, 3, 12, 13, 13),
            Block.box(10.999999999999998, 11, 4, 12.049999999999999, 12, 9),
            Block.box(10.999999999999998, 10, 8, 12.049999999999999, 11, 9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.WEST);

    protected static final VoxelShape SHAPE_NORTH_OPEN = Stream.of(
            Block.box(7, 0, 7, 9, 10, 9),
            Block.box(5, 10, 3.5, 11, 12, 12.5),
            Block.box(9, 12, 3.5, 11, 13, 12.5),
            Block.box(5, 12, 3.5, 7, 13, 12.5),
            Block.box(6, 13, 3.5, 7, 14, 12.5),
            Block.box(9, 13, 3.5, 10, 14, 12.5),
            Block.box(7, 14, 3.5, 9, 15, 12.5),
            Block.box(7, 12, 11.5, 9, 14, 12.5),
            Block.box(4, 12, 3, 5, 13, 13),
            Block.box(5, 13, 3, 6, 14, 13),
            Block.box(6, 14, 3, 7, 15, 13),
            Block.box(7, 15, 3, 9, 16, 13),
            Block.box(9, 14, 3, 10, 15, 13),
            Block.box(10, 13, 3, 11, 14, 13),
            Block.box(11, 12, 3, 12, 13, 13),
            Block.box(10.999999999999998, 11, 4, 12.049999999999999, 16, 5),
            Block.box(10.999999999999998, 15, 5, 12.049999999999999, 16, 6)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.WEST);
    protected static final VoxelShape[] SHAPES = new VoxelShape[] {
            SHAPE_SOUTH, SHAPE_WEST, SHAPE_NORTH, SHAPE_EAST,
            SHAPE_SOUTH_OPEN, SHAPE_WEST_OPEN, SHAPE_NORTH_OPEN, SHAPE_EAST_OPEN
    };

    public MailboxBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HAS_MAIL, false));
        ALL_MAILBOXES.add(this);
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, ModBlockEntitys.MAILBOX_ENTITY.get(), MailboxBlockEntity::tick);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if(!(blockEntity instanceof MailboxBlockEntity)) return InteractionResult.FAIL;
        MailboxBlockEntity mailbox = (MailboxBlockEntity) blockEntity;

        if(!mailbox.hasOwner()) {
            mailbox.setOwner(player);
            player.displayClientMessage(Component.translatable("msg.ls_furniture.mailbox.set_owner"), true);
            return InteractionResult.sidedSuccess(false);
        }

        if(mailbox.isOwner(player)) {
            mailbox.updateDisplayName(player);
            player.openMenu(mailbox);
            return InteractionResult.sidedSuccess(false);
        }

        if(player.getItemInHand(hand).isEmpty()) {
            player.displayClientMessage(Component.translatable("msg.ls_furniture.mailbox.no_permission"), true);
            return InteractionResult.FAIL;
        }

        if(mailbox.isFull()) {
            player.displayClientMessage(Component.translatable("msg.ls_furniture.mailbox.full"), true);
            return InteractionResult.FAIL;
        }

        ItemStack result = mailbox.addMail(player.getItemInHand(hand));
        player.setItemInHand(hand, result);

        if(result.isEmpty()) {
            Component ownerName = mailbox.getOwnerDisplayName();

            if (ownerName != null) {
                player.displayClientMessage(Component.translatable("msg.ls_furniture.mailbox.mail_delivered_to", ownerName), true);
            } else {
                player.displayClientMessage(Component.translatable("msg.ls_furniture.mailbox.mail_delivered"), true);
            }
            return InteractionResult.sidedSuccess(false);
        }


        player.displayClientMessage(Component.translatable("msg.ls_furniture.mailbox.invalid_mail"), true);
        return InteractionResult.FAIL;
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

    @Override
    public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState state, BlockEntity blockEntity, ItemStack stack) {
        if(!level.isClientSide()) {
            if(blockEntity != null) {
                if(blockEntity instanceof MailboxBlockEntity mailboxBlockEntity) {
                    if(mailboxBlockEntity.isOwner(player) || (player.isCreative() && (player.hasPermissions(1) || state.is(ModBlocksTags.NON_OP_CREATIVE_CAN_DESTROY_TAG)))) {
                        super.playerDestroy(level, player, blockPos, state, blockEntity, stack);
                    } else {
                        player.displayClientMessage(Component.translatable("msg.ls_furniture.mailbox.no_permission"), true);
                    }
                }
            }
        }
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MailboxBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        MailboxBlockEntity mailbox = (MailboxBlockEntity) blockEntity;
        if (entity instanceof Player player) {
            mailbox.setOwner(player);
            player.displayClientMessage(Component.translatable("msg.ls_furniture.mailbox.set_owner"), true);
        }
        if(stack.hasCustomHoverName()) {
            BlockEntity tileEntity = level.getBlockEntity(pos);
            if(tileEntity instanceof MailboxBlockEntity) {
                ((MailboxBlockEntity) tileEntity).setCustomName(stack.getHoverName());
            }
        }
        mailbox.setChanged();
        level.sendBlockUpdated(pos, state, state, 3);
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HAS_MAIL);
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
        if (state.getValue(HAS_MAIL)) shape += 4;
        return SHAPES[shape];
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