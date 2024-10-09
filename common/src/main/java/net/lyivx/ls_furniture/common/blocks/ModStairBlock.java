package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.common.blocks.entity.LockableBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.blocks.properties.StairType;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.common.utils.block.ILockable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
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
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class ModStairBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock, HammerItem.HammerableBlock {
    public static final MapCodec<ModStairBlock> CODEC = simpleCodec(ModStairBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<StairType> TYPE = ModBlockStateProperties.STAIR_TYPE;
    public static final EnumProperty<StairModelType> MODEL_TYPE = EnumProperty.create("model", StairModelType.class);


    public static final VoxelShape RAIL = Stream.of(
            Block.box(14, 14.5, 0.25, 16, 16.5, 2.25),
            Block.box(14, 15.5, 1.25, 16, 17.5, 3.25),
            Block.box(14, 16.5, 2.25, 16, 18.5, 4.25),
            Block.box(14, 19.5, 5.25, 16, 21.5, 7.25),
            Block.box(14, 18.5, 4.25, 16, 20.5, 6.25),
            Block.box(14, 17.5, 3.25, 16, 19.5, 5.25),
            Block.box(14, 22.5, 8.25, 16, 24.5, 10.25),
            Block.box(14, 21.5, 7.25, 16, 23.5, 9.25),
            Block.box(14, 20.5, 6.25, 16, 22.5, 8.25),
            Block.box(14, 25.5, 11.25, 16, 27.5, 13.25),
            Block.box(14, 24.5, 10.25, 16, 26.5, 12.25),
            Block.box(14, 23.5, 9.25, 16, 25.5, 11.25),
            Block.box(14, 28.5, 14.25, 16, 30.5, 16.25),
            Block.box(14, 29.5, 15.25, 16, 31.5, 17.25),
            Block.box(14, 27.5, 13.25, 16, 29.5, 15.25),
            Block.box(14, 26.5, 12.25, 16, 28.5, 14.25),
            Block.box(0, 14.5, 0.25, 2, 16.5, 2.25),
            Block.box(0, 15.5, 1.25, 2, 17.5, 3.25),
            Block.box(0, 16.5, 2.25, 2, 18.5, 4.25),
            Block.box(0, 19.5, 5.25, 2, 21.5, 7.25),
            Block.box(0, 18.5, 4.25, 2, 20.5, 6.25),
            Block.box(0, 17.5, 3.25, 2, 19.5, 5.25),
            Block.box(0, 22.5, 8.25, 2, 24.5, 10.25),
            Block.box(0, 21.5, 7.25, 2, 23.5, 9.25),
            Block.box(0, 20.5, 6.25, 2, 22.5, 8.25),
            Block.box(0, 25.5, 11.25, 2, 27.5, 13.25),
            Block.box(0, 24.5, 10.25, 2, 26.5, 12.25),
            Block.box(0, 23.5, 9.25, 2, 25.5, 11.25),
            Block.box(0, 28.5, 14.25, 2, 30.5, 16.25),
            Block.box(0, 29.5, 15.25, 2, 31.5, 17.25),
            Block.box(0, 29.5, 15.25, 2, 31.5, 17.25),
            Block.box(0, 28.5, 14.25, 2, 30.5, 16.25),
            Block.box(0, 23.5, 9.25, 2, 25.5, 11.25),
            Block.box(0, 24.5, 10.25, 2, 26.5, 12.25),
            Block.box(0, 25.5, 11.25, 2, 27.5, 13.25),
            Block.box(0, 20.5, 6.25, 2, 22.5, 8.25),
            Block.box(0, 21.5, 7.25, 2, 23.5, 9.25),
            Block.box(0, 22.5, 8.25, 2, 24.5, 10.25),
            Block.box(0, 17.5, 3.25, 2, 19.5, 5.25),
            Block.box(0, 18.5, 4.25, 2, 20.5, 6.25),
            Block.box(0, 19.5, 5.25, 2, 21.5, 7.25),
            Block.box(0, 16.5, 2.25, 2, 18.5, 4.25),
            Block.box(0, 15.5, 1.25, 2, 17.5, 3.25),
            Block.box(0, 14.5, 0.25, 2, 16.5, 2.25),
            Block.box(14, 26.5, 12.25, 16, 28.5, 14.25),
            Block.box(14, 27.5, 13.25, 16, 29.5, 15.25),
            Block.box(14, 29.5, 15.25, 16, 31.5, 17.25),
            Block.box(14, 28.5, 14.25, 16, 30.5, 16.25),
            Block.box(14, 23.5, 9.25, 16, 25.5, 11.25),
            Block.box(14, 24.5, 10.25, 16, 26.5, 12.25),
            Block.box(14, 25.5, 11.25, 16, 27.5, 13.25),
            Block.box(14, 20.5, 6.25, 16, 22.5, 8.25),
            Block.box(14, 21.5, 7.25, 16, 23.5, 9.25),
            Block.box(14, 22.5, 8.25, 16, 24.5, 10.25),
            Block.box(14, 17.5, 3.25, 16, 19.5, 5.25),
            Block.box(14, 18.5, 4.25, 16, 20.5, 6.25),
            Block.box(14, 19.5, 5.25, 16, 21.5, 7.25),
            Block.box(14, 16.5, 2.25, 16, 18.5, 4.25),
            Block.box(14, 15.5, 1.25, 16, 17.5, 3.25),
            Block.box(14, 14.5, 0.25, 16, 16.5, 2.25),
            Block.box(0, 27.5, 13.25, 2, 29.5, 15.25),
            Block.box(0, 26.5, 12.25, 2, 28.5, 14.25),
            Block.box(0, 15, 15.25, 2, 17, 17.25),
            Block.box(0, 14, 14.25, 2, 16, 16.25),
            Block.box(0, 9, 9.25, 2, 11, 11.25),
            Block.box(0, 10, 10.25, 2, 12, 12.25),
            Block.box(0, 11, 11.25, 2, 13, 13.25),
            Block.box(0, 6, 6.25, 2, 8, 8.25),
            Block.box(0, 7, 7.25, 2, 9, 9.25),
            Block.box(0, 8, 8.25, 2, 10, 10.25),
            Block.box(0, 3, 3.25, 2, 5, 5.25),
            Block.box(0, 4, 4.25, 2, 6, 6.25),
            Block.box(0, 5, 5.25, 2, 7, 7.25),
            Block.box(0, 2, 2.25, 2, 4, 4.25),
            Block.box(0, 1, 1.25, 2, 3, 3.25),
            Block.box(0, 0, 0.25, 2, 2, 2.25),
            Block.box(14, 12, 12.25, 16, 14, 14.25),
            Block.box(14, 13, 13.25, 16, 15, 15.25),
            Block.box(14, 15, 15.25, 16, 17, 17.25),
            Block.box(14, 14, 14.25, 16, 16, 16.25),
            Block.box(14, 9, 9.25, 16, 11, 11.25),
            Block.box(14, 10, 10.25, 16, 12, 12.25),
            Block.box(14, 11, 11.25, 16, 13, 13.25),
            Block.box(14, 6, 6.25, 16, 8, 8.25),
            Block.box(14, 7, 7.25, 16, 9, 9.25),
            Block.box(14, 8, 8.25, 16, 10, 10.25),
            Block.box(14, 3, 3.25, 16, 5, 5.25),
            Block.box(14, 4, 4.25, 16, 6, 6.25),
            Block.box(14, 5, 5.25, 16, 7, 7.25),
            Block.box(14, 2, 2.25, 16, 4, 4.25),
            Block.box(14, 1, 1.25, 16, 3, 3.25),
            Block.box(14, 0, 0.25, 16, 2, 2.25),
            Block.box(0, 12, 12.25, 2, 14, 14.25),
            Block.box(0, 13, 13.25, 2, 15, 15.25),
            Block.box(0, 4, 3, 2, 18, 5),
            Block.box(0, 12, 11, 2, 26, 13),
            Block.box(14, 12, 11, 16, 26, 13),
            Block.box(14, 4, 3, 16, 18, 5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape RAIL_RIGHT = Stream.of(
            Block.box(0, 12, 11, 2, 26, 13),
            Block.box(0, 4, 3, 2, 18, 5),
            Block.box(0, 13, 13.25, 2, 15, 15.25),
            Block.box(0, 12, 12.25, 2, 14, 14.25),
            Block.box(0, 0, 0.25, 2, 2, 2.25),
            Block.box(0, 1, 1.25, 2, 3, 3.25),
            Block.box(0, 2, 2.25, 2, 4, 4.25),
            Block.box(0, 5, 5.25, 2, 7, 7.25),
            Block.box(0, 4, 4.25, 2, 6, 6.25),
            Block.box(0, 3, 3.25, 2, 5, 5.25),
            Block.box(0, 8, 8.25, 2, 10, 10.25),
            Block.box(0, 7, 7.25, 2, 9, 9.25),
            Block.box(0, 6, 6.25, 2, 8, 8.25),
            Block.box(0, 11, 11.25, 2, 13, 13.25),
            Block.box(0, 10, 10.25, 2, 12, 12.25),
            Block.box(0, 9, 9.25, 2, 11, 11.25),
            Block.box(0, 14, 14.25, 2, 16, 16.25),
            Block.box(0, 15, 15.25, 2, 17, 17.25),
            Block.box(0, 26.5, 12.25, 2, 28.5, 14.25),
            Block.box(0, 27.5, 13.25, 2, 29.5, 15.25),
            Block.box(0, 14.5, 0.25, 2, 16.5, 2.25),
            Block.box(0, 15.5, 1.25, 2, 17.5, 3.25),
            Block.box(0, 16.5, 2.25, 2, 18.5, 4.25),
            Block.box(0, 19.5, 5.25, 2, 21.5, 7.25),
            Block.box(0, 18.5, 4.25, 2, 20.5, 6.25),
            Block.box(0, 17.5, 3.25, 2, 19.5, 5.25),
            Block.box(0, 22.5, 8.25, 2, 24.5, 10.25),
            Block.box(0, 21.5, 7.25, 2, 23.5, 9.25),
            Block.box(0, 20.5, 6.25, 2, 22.5, 8.25),
            Block.box(0, 25.5, 11.25, 2, 27.5, 13.25),
            Block.box(0, 24.5, 10.25, 2, 26.5, 12.25),
            Block.box(0, 23.5, 9.25, 2, 25.5, 11.25),
            Block.box(0, 28.5, 14.25, 2, 30.5, 16.25),
            Block.box(0, 29.5, 15.25, 2, 31.5, 17.25),
            Block.box(0, 29.5, 15.25, 2, 31.5, 17.25),
            Block.box(0, 28.5, 14.25, 2, 30.5, 16.25),
            Block.box(0, 23.5, 9.25, 2, 25.5, 11.25),
            Block.box(0, 24.5, 10.25, 2, 26.5, 12.25),
            Block.box(0, 25.5, 11.25, 2, 27.5, 13.25),
            Block.box(0, 20.5, 6.25, 2, 22.5, 8.25),
            Block.box(0, 21.5, 7.25, 2, 23.5, 9.25),
            Block.box(0, 22.5, 8.25, 2, 24.5, 10.25),
            Block.box(0, 17.5, 3.25, 2, 19.5, 5.25),
            Block.box(0, 18.5, 4.25, 2, 20.5, 6.25),
            Block.box(0, 19.5, 5.25, 2, 21.5, 7.25),
            Block.box(0, 16.5, 2.25, 2, 18.5, 4.25),
            Block.box(0, 15.5, 1.25, 2, 17.5, 3.25),
            Block.box(0, 14.5, 0.25, 2, 16.5, 2.25)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape RAIL_LEFT = Stream.of(
            Block.box(14, 14.5, 0.25, 16, 16.5, 2.25),
            Block.box(14, 15.5, 1.25, 16, 17.5, 3.25),
            Block.box(14, 16.5, 2.25, 16, 18.5, 4.25),
            Block.box(14, 19.5, 5.25, 16, 21.5, 7.25),
            Block.box(14, 18.5, 4.25, 16, 20.5, 6.25),
            Block.box(14, 17.5, 3.25, 16, 19.5, 5.25),
            Block.box(14, 22.5, 8.25, 16, 24.5, 10.25),
            Block.box(14, 21.5, 7.25, 16, 23.5, 9.25),
            Block.box(14, 20.5, 6.25, 16, 22.5, 8.25),
            Block.box(14, 25.5, 11.25, 16, 27.5, 13.25),
            Block.box(14, 24.5, 10.25, 16, 26.5, 12.25),
            Block.box(14, 23.5, 9.25, 16, 25.5, 11.25),
            Block.box(14, 28.5, 14.25, 16, 30.5, 16.25),
            Block.box(14, 29.5, 15.25, 16, 31.5, 17.25),
            Block.box(14, 27.5, 13.25, 16, 29.5, 15.25),
            Block.box(14, 26.5, 12.25, 16, 28.5, 14.25),
            Block.box(14, 26.5, 12.25, 16, 28.5, 14.25),
            Block.box(14, 27.5, 13.25, 16, 29.5, 15.25),
            Block.box(14, 29.5, 15.25, 16, 31.5, 17.25),
            Block.box(14, 28.5, 14.25, 16, 30.5, 16.25),
            Block.box(14, 23.5, 9.25, 16, 25.5, 11.25),
            Block.box(14, 24.5, 10.25, 16, 26.5, 12.25),
            Block.box(14, 25.5, 11.25, 16, 27.5, 13.25),
            Block.box(14, 20.5, 6.25, 16, 22.5, 8.25),
            Block.box(14, 21.5, 7.25, 16, 23.5, 9.25),
            Block.box(14, 22.5, 8.25, 16, 24.5, 10.25),
            Block.box(14, 17.5, 3.25, 16, 19.5, 5.25),
            Block.box(14, 18.5, 4.25, 16, 20.5, 6.25),
            Block.box(14, 19.5, 5.25, 16, 21.5, 7.25),
            Block.box(14, 16.5, 2.25, 16, 18.5, 4.25),
            Block.box(14, 15.5, 1.25, 16, 17.5, 3.25),
            Block.box(14, 14.5, 0.25, 16, 16.5, 2.25),
            Block.box(14, 12, 12.25, 16, 14, 14.25),
            Block.box(14, 13, 13.25, 16, 15, 15.25),
            Block.box(14, 15, 15.25, 16, 17, 17.25),
            Block.box(14, 14, 14.25, 16, 16, 16.25),
            Block.box(14, 9, 9.25, 16, 11, 11.25),
            Block.box(14, 10, 10.25, 16, 12, 12.25),
            Block.box(14, 11, 11.25, 16, 13, 13.25),
            Block.box(14, 6, 6.25, 16, 8, 8.25),
            Block.box(14, 7, 7.25, 16, 9, 9.25),
            Block.box(14, 8, 8.25, 16, 10, 10.25),
            Block.box(14, 3, 3.25, 16, 5, 5.25),
            Block.box(14, 4, 4.25, 16, 6, 6.25),
            Block.box(14, 5, 5.25, 16, 7, 7.25),
            Block.box(14, 2, 2.25, 16, 4, 4.25),
            Block.box(14, 1, 1.25, 16, 3, 3.25),
            Block.box(14, 0, 0.25, 16, 2, 2.25),
            Block.box(14, 12, 11, 16, 26, 13),
            Block.box(14, 4, 3, 16, 18, 5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape BASE = Stream.of(Block.box(0, 14, 11.75, 16, 15, 17.05), Block.box(0, 8.5, 6.25, 16, 9.5, 11.55), Block.box(0, 3, 1, 16, 4, 6.3)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape BASE_INNER = Stream.of(Block.box(11.775, 14, 0, 17.075000000000003, 15, 11.05), Block.box(11.775, 14, 11.05, 17.075000000000003, 15, 17.05), Block.box(0, 14, 11.75, 11.774999999999999, 15, 17.05), Block.box(0, 8.5, 6.25, 11.575, 9.5, 11.55), Block.box(1.0250000000000004, 3, 0, 6.325, 4, 2.9749999999999996), Block.box(1.0250000000000004, 3, 2.975, 6.325, 4, 6.3), Block.box(0, 3, 1, 1.025, 4, 6.3), Block.box(6.2749999999999995, 8.5, 0, 11.575, 9.5, 6.25)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape BASE_OUTER = Stream.of(Block.box(11.75, 14, 11.75, 16, 15, 16), Block.box(6.25, 8.5, 6.249999999999999, 16, 9.5, 11.549999999999999), Block.box(6.3, 3, 1, 16, 4, 6.3), Block.box(1.025, 3, 1, 6.325, 4, 16), Block.box(6.25, 8.5, 11.55, 11.549999999999999, 9.5, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape LOWER_RAIL = Stream.of(
            Block.box(14, -1.5, 0.25, 16, 0.5, 2.25),
            Block.box(14, -0.5, 1.25, 16, 1.5, 3.25),
            Block.box(14, 0.5, 2.25, 16, 2.5, 4.25),
            Block.box(14, 3.5, 5.25, 16, 5.5, 7.25),
            Block.box(14, 2.5, 4.25, 16, 4.5, 6.25),
            Block.box(14, 1.5, 3.25, 16, 3.5, 5.25),
            Block.box(14, 6.5, 8.25, 16, 8.5, 10.25),
            Block.box(14, 5.5, 7.25, 16, 7.5, 9.25),
            Block.box(14, 4.5, 6.25, 16, 6.5, 8.25),
            Block.box(14, 9.5, 11.25, 16, 11.5, 13.25),
            Block.box(14, 8.5, 10.25, 16, 10.5, 12.25),
            Block.box(14, 7.5, 9.25, 16, 9.5, 11.25),
            Block.box(14, 12.5, 14.25, 16, 14.5, 16.25),
            Block.box(14, 13.5, 15.25, 16, 15.5, 17.25),
            Block.box(14, 11.5, 13.25, 16, 13.5, 15.25),
            Block.box(14, 10.5, 12.25, 16, 12.5, 14.25),
            Block.box(0, -1.5, 0.25, 2, 0.5, 2.25),
            Block.box(0, -0.5, 1.25, 2, 1.5, 3.25),
            Block.box(0, 0.5, 2.25, 2, 2.5, 4.25),
            Block.box(0, 3.5, 5.25, 2, 5.5, 7.25),
            Block.box(0, 2.5, 4.25, 2, 4.5, 6.25),
            Block.box(0, 1.5, 3.25, 2, 3.5, 5.25),
            Block.box(0, 6.5, 8.25, 2, 8.5, 10.25),
            Block.box(0, 5.5, 7.25, 2, 7.5, 9.25),
            Block.box(0, 4.5, 6.25, 2, 6.5, 8.25),
            Block.box(0, 9.5, 11.25, 2, 11.5, 13.25),
            Block.box(0, 8.5, 10.25, 2, 10.5, 12.25),
            Block.box(0, 7.5, 9.25, 2, 9.5, 11.25),
            Block.box(0, 12.5, 14.25, 2, 14.5, 16.25),
            Block.box(0, 13.5, 15.25, 2, 15.5, 17.25),
            Block.box(0, 13.5, 15.25, 2, 15.5, 17.25),
            Block.box(0, 12.5, 14.25, 2, 14.5, 16.25),
            Block.box(0, 7.5, 9.25, 2, 9.5, 11.25),
            Block.box(0, 8.5, 10.25, 2, 10.5, 12.25),
            Block.box(0, 9.5, 11.25, 2, 11.5, 13.25),
            Block.box(0, 4.5, 6.25, 2, 6.5, 8.25),
            Block.box(0, 5.5, 7.25, 2, 7.5, 9.25),
            Block.box(0, 6.5, 8.25, 2, 8.5, 10.25),
            Block.box(0, 1.5, 3.25, 2, 3.5, 5.25),
            Block.box(0, 2.5, 4.25, 2, 4.5, 6.25),
            Block.box(0, 3.5, 5.25, 2, 5.5, 7.25),
            Block.box(0, 0.5, 2.25, 2, 2.5, 4.25),
            Block.box(0, -0.5, 1.25, 2, 1.5, 3.25),
            Block.box(0, -1.5, 0.25, 2, 0.5, 2.25),
            Block.box(14, 10.5, 12.25, 16, 12.5, 14.25),
            Block.box(14, 11.5, 13.25, 16, 13.5, 15.25),
            Block.box(14, 13.5, 15.25, 16, 15.5, 17.25),
            Block.box(14, 12.5, 14.25, 16, 14.5, 16.25),
            Block.box(14, 7.5, 9.25, 16, 9.5, 11.25),
            Block.box(14, 8.5, 10.25, 16, 10.5, 12.25),
            Block.box(14, 9.5, 11.25, 16, 11.5, 13.25),
            Block.box(14, 4.5, 6.25, 16, 6.5, 8.25),
            Block.box(14, 5.5, 7.25, 16, 7.5, 9.25),
            Block.box(14, 6.5, 8.25, 16, 8.5, 10.25),
            Block.box(14, 1.5, 3.25, 16, 3.5, 5.25),
            Block.box(14, 2.5, 4.25, 16, 4.5, 6.25),
            Block.box(14, 3.5, 5.25, 16, 5.5, 7.25),
            Block.box(14, 0.5, 2.25, 16, 2.5, 4.25),
            Block.box(14, -0.5, 1.25, 16, 1.5, 3.25),
            Block.box(14, -1.5, 0.25, 16, 0.5, 2.25),
            Block.box(0, 11.5, 13.25, 2, 13.5, 15.25),
            Block.box(0, 10.5, 12.25, 2, 12.5, 14.25),
            Block.box(0, -1, 15.25, 2, 1, 17.25),
            Block.box(0, -2, 14.25, 2, 0, 16.25),
            Block.box(0, -7, 9.25, 2, -5, 11.25),
            Block.box(0, -6, 10.25, 2, -4, 12.25),
            Block.box(0, -5, 11.25, 2, -3, 13.25),
            Block.box(0, -10, 6.25, 2, -8, 8.25),
            Block.box(0, -9, 7.25, 2, -7, 9.25),
            Block.box(0, -8, 8.25, 2, -6, 10.25),
            Block.box(0, -13, 3.25, 2, -11, 5.25),
            Block.box(0, -12, 4.25, 2, -10, 6.25),
            Block.box(0, -11, 5.25, 2, -9, 7.25),
            Block.box(0, -14, 2.25, 2, -12, 4.25),
            Block.box(0, -15, 1.25, 2, -13, 3.25),
            Block.box(0, -16, 0.25, 2, -14, 2.25),
            Block.box(14, -4, 12.25, 16, -2, 14.25),
            Block.box(14, -3, 13.25, 16, -1, 15.25),
            Block.box(14, -1, 15.25, 16, 1, 17.25),
            Block.box(14, -2, 14.25, 16, 0, 16.25),
            Block.box(14, -7, 9.25, 16, -5, 11.25),
            Block.box(14, -6, 10.25, 16, -4, 12.25),
            Block.box(14, -5, 11.25, 16, -3, 13.25),
            Block.box(14, -10, 6.25, 16, -8, 8.25),
            Block.box(14, -9, 7.25, 16, -7, 9.25),
            Block.box(14, -8, 8.25, 16, -6, 10.25),
            Block.box(14, -13, 3.25, 16, -11, 5.25),
            Block.box(14, -12, 4.25, 16, -10, 6.25),
            Block.box(14, -11, 5.25, 16, -9, 7.25),
            Block.box(14, -14, 2.25, 16, -12, 4.25),
            Block.box(14, -15, 1.25, 16, -13, 3.25),
            Block.box(14, -16, 0.25, 16, -14, 2.25),
            Block.box(0, -4, 12.25, 2, -2, 14.25),
            Block.box(0, -3, 13.25, 2, -1, 15.25),
            Block.box(0, -12, 3, 2, 2, 5),
            Block.box(0, -4, 11, 2, 10, 13),
            Block.box(14, -4, 11, 16, 10, 13),
            Block.box(14, -12, 3, 16, 2, 5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape LOWER_RAIL_RIGHT = Stream.of(
            Block.box(0, -4, 11, 2, 10, 13),
            Block.box(0, -12, 3, 2, 2, 5),
            Block.box(0, -3, 13.25, 2, -1, 15.25),
            Block.box(0, -4, 12.25, 2, -2, 14.25),
            Block.box(0, -16, 0.25, 2, -14, 2.25),
            Block.box(0, -15, 1.25, 2, -13, 3.25),
            Block.box(0, -14, 2.25, 2, -12, 4.25),
            Block.box(0, -11, 5.25, 2, -9, 7.25),
            Block.box(0, -12, 4.25, 2, -10, 6.25),
            Block.box(0, -13, 3.25, 2, -11, 5.25),
            Block.box(0, -8, 8.25, 2, -6, 10.25),
            Block.box(0, -9, 7.25, 2, -7, 9.25),
            Block.box(0, -10, 6.25, 2, -8, 8.25),
            Block.box(0, -5, 11.25, 2, -3, 13.25),
            Block.box(0, -6, 10.25, 2, -4, 12.25),
            Block.box(0, -7, 9.25, 2, -5, 11.25),
            Block.box(0, -2, 14.25, 2, 0, 16.25),
            Block.box(0, -1, 15.25, 2, 1, 17.25),
            Block.box(0, 10.5, 12.25, 2, 12.5, 14.25),
            Block.box(0, 11.5, 13.25, 2, 13.5, 15.25),
            Block.box(0, -1.5, 0.25, 2, 0.5, 2.25),
            Block.box(0, -0.5, 1.25, 2, 1.5, 3.25),
            Block.box(0, 0.5, 2.25, 2, 2.5, 4.25),
            Block.box(0, 3.5, 5.25, 2, 5.5, 7.25),
            Block.box(0, 2.5, 4.25, 2, 4.5, 6.25),
            Block.box(0, 1.5, 3.25, 2, 3.5, 5.25),
            Block.box(0, 6.5, 8.25, 2, 8.5, 10.25),
            Block.box(0, 5.5, 7.25, 2, 7.5, 9.25),
            Block.box(0, 4.5, 6.25, 2, 6.5, 8.25),
            Block.box(0, 9.5, 11.25, 2, 11.5, 13.25),
            Block.box(0, 8.5, 10.25, 2, 10.5, 12.25),
            Block.box(0, 7.5, 9.25, 2, 9.5, 11.25),
            Block.box(0, 12.5, 14.25, 2, 14.5, 16.25),
            Block.box(0, 13.5, 15.25, 2, 15.5, 17.25),
            Block.box(0, 13.5, 15.25, 2, 15.5, 17.25),
            Block.box(0, 12.5, 14.25, 2, 14.5, 16.25),
            Block.box(0, 7.5, 9.25, 2, 9.5, 11.25),
            Block.box(0, 8.5, 10.25, 2, 10.5, 12.25),
            Block.box(0, 9.5, 11.25, 2, 11.5, 13.25),
            Block.box(0, 4.5, 6.25, 2, 6.5, 8.25),
            Block.box(0, 5.5, 7.25, 2, 7.5, 9.25),
            Block.box(0, 6.5, 8.25, 2, 8.5, 10.25),
            Block.box(0, 1.5, 3.25, 2, 3.5, 5.25),
            Block.box(0, 2.5, 4.25, 2, 4.5, 6.25),
            Block.box(0, 3.5, 5.25, 2, 5.5, 7.25),
            Block.box(0, 0.5, 2.25, 2, 2.5, 4.25),
            Block.box(0, -0.5, 1.25, 2, 1.5, 3.25),
            Block.box(0, -1.5, 0.25, 2, 0.5, 2.25)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape LOWER_RAIL_LEFT = Stream.of(
            Block.box(14, -1.5, 0.25, 16, 0.5, 2.25),
            Block.box(14, -0.5, 1.25, 16, 1.5, 3.25),
            Block.box(14, 0.5, 2.25, 16, 2.5, 4.25),
            Block.box(14, 3.5, 5.25, 16, 5.5, 7.25),
            Block.box(14, 2.5, 4.25, 16, 4.5, 6.25),
            Block.box(14, 1.5, 3.25, 16, 3.5, 5.25),
            Block.box(14, 6.5, 8.25, 16, 8.5, 10.25),
            Block.box(14, 5.5, 7.25, 16, 7.5, 9.25),
            Block.box(14, 4.5, 6.25, 16, 6.5, 8.25),
            Block.box(14, 9.5, 11.25, 16, 11.5, 13.25),
            Block.box(14, 8.5, 10.25, 16, 10.5, 12.25),
            Block.box(14, 7.5, 9.25, 16, 9.5, 11.25),
            Block.box(14, 12.5, 14.25, 16, 14.5, 16.25),
            Block.box(14, 13.5, 15.25, 16, 15.5, 17.25),
            Block.box(14, 11.5, 13.25, 16, 13.5, 15.25),
            Block.box(14, 10.5, 12.25, 16, 12.5, 14.25),
            Block.box(14, 10.5, 12.25, 16, 12.5, 14.25),
            Block.box(14, 11.5, 13.25, 16, 13.5, 15.25),
            Block.box(14, 13.5, 15.25, 16, 15.5, 17.25),
            Block.box(14, 12.5, 14.25, 16, 14.5, 16.25),
            Block.box(14, 7.5, 9.25, 16, 9.5, 11.25),
            Block.box(14, 8.5, 10.25, 16, 10.5, 12.25),
            Block.box(14, 9.5, 11.25, 16, 11.5, 13.25),
            Block.box(14, 4.5, 6.25, 16, 6.5, 8.25),
            Block.box(14, 5.5, 7.25, 16, 7.5, 9.25),
            Block.box(14, 6.5, 8.25, 16, 8.5, 10.25),
            Block.box(14, 1.5, 3.25, 16, 3.5, 5.25),
            Block.box(14, 2.5, 4.25, 16, 4.5, 6.25),
            Block.box(14, 3.5, 5.25, 16, 5.5, 7.25),
            Block.box(14, 0.5, 2.25, 16, 2.5, 4.25),
            Block.box(14, -0.5, 1.25, 16, 1.5, 3.25),
            Block.box(14, -1.5, 0.25, 16, 0.5, 2.25),
            Block.box(14, -4, 12.25, 16, -2, 14.25),
            Block.box(14, -3, 13.25, 16, -1, 15.25),
            Block.box(14, -1, 15.25, 16, 1, 17.25),
            Block.box(14, -2, 14.25, 16, 0, 16.25),
            Block.box(14, -7, 9.25, 16, -5, 11.25),
            Block.box(14, -6, 10.25, 16, -4, 12.25),
            Block.box(14, -5, 11.25, 16, -3, 13.25),
            Block.box(14, -10, 6.25, 16, -8, 8.25),
            Block.box(14, -9, 7.25, 16, -7, 9.25),
            Block.box(14, -8, 8.25, 16, -6, 10.25),
            Block.box(14, -13, 3.25, 16, -11, 5.25),
            Block.box(14, -12, 4.25, 16, -10, 6.25),
            Block.box(14, -11, 5.25, 16, -9, 7.25),
            Block.box(14, -14, 2.25, 16, -12, 4.25),
            Block.box(14, -15, 1.25, 16, -13, 3.25),
            Block.box(14, -16, 0.25, 16, -14, 2.25),
            Block.box(14, -4, 11, 16, 10, 13),
            Block.box(14, -12, 3, 16, 2, 5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape LOWER_BASE = Stream.of(
        Block.box(0, -13, 1, 15.999999999999998, -12, 6.3),
        Block.box(0, -7.5, 6.25, 15.999999999999998, -6.5, 11.55),
        Block.box(0, -2, 11.75, 15.999999999999998, -1, 17.05)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape LOWER_BASE_INNER = Stream.of(
        Block.box(11.775, -2, 0, 17.075, -1, 11.05),
        Block.box(11.775, -2, 11.05, 17.075, -1, 17.05),
        Block.box(0, -2, 11.75, 11.775, -1, 17.05),
        Block.box(0, -7.5, 6.25, 11.575, -6.5, 11.55),
        Block.box(1.025, -13, 0, 6.325, -12, 2.975),
        Block.box(1.025, -13, 2.975, 6.325, -12, 6.3),
        Block.box(0, -13, 1, 1.025, -12, 6.3),
        Block.box(6.275, -7.5, 0, 11.575, -6.5, 6.25)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape LOWER_BASE_OUTER = Stream.of(
        Block.box(11.75, -2, 11.75, 16, -1, 16),
        Block.box(6.25, -7.5, 6.25, 16, -6.5, 11.55),
        Block.box(6.3, -13, 1, 16, -12, 6.3),
        Block.box(1.025, -13, 1, 6.325, -12, 16),
        Block.box(6.25, -7.5, 11.55, 11.55, -6.5, 16)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape SINGLE = Shapes.or(RAIL, BASE);
    public static final VoxelShape SINGLE_EAST = ShapeUtil.rotateShape(SINGLE, Direction.EAST);
    public static final VoxelShape SINGLE_SOUTH = ShapeUtil.rotateShape(SINGLE, Direction.SOUTH);
    public static final VoxelShape SINGLE_WEST = ShapeUtil.rotateShape(SINGLE, Direction.WEST);

    public static final VoxelShape LOWER_SINGLE = Shapes.or(LOWER_RAIL, LOWER_BASE);
    public static final VoxelShape LOWER_SINGLE_EAST = ShapeUtil.rotateShape(LOWER_SINGLE, Direction.EAST);
    public static final VoxelShape LOWER_SINGLE_SOUTH = ShapeUtil.rotateShape(LOWER_SINGLE, Direction.SOUTH);
    public static final VoxelShape LOWER_SINGLE_WEST = ShapeUtil.rotateShape(LOWER_SINGLE, Direction.WEST);

    public static final VoxelShape MIDDLE = Shapes.or(BASE);
    public static final VoxelShape MIDDLE_EAST = ShapeUtil.rotateShape(MIDDLE, Direction.EAST);
    public static final VoxelShape MIDDLE_SOUTH = ShapeUtil.rotateShape(MIDDLE, Direction.SOUTH);
    public static final VoxelShape MIDDLE_WEST = ShapeUtil.rotateShape(MIDDLE, Direction.WEST);

    public static final VoxelShape LOWER_MIDDLE = Shapes.or(LOWER_BASE);
    public static final VoxelShape LOWER_MIDDLE_EAST = ShapeUtil.rotateShape(LOWER_MIDDLE, Direction.EAST);
    public static final VoxelShape LOWER_MIDDLE_SOUTH = ShapeUtil.rotateShape(LOWER_MIDDLE, Direction.SOUTH);
    public static final VoxelShape LOWER_MIDDLE_WEST = ShapeUtil.rotateShape(LOWER_MIDDLE, Direction.WEST);

    public static final VoxelShape OUTER = Shapes.or(BASE_OUTER);
    public static final VoxelShape OUTER_EAST = ShapeUtil.rotateShape(OUTER, Direction.EAST);
    public static final VoxelShape OUTER_SOUTH = ShapeUtil.rotateShape(OUTER, Direction.SOUTH);
    public static final VoxelShape OUTER_WEST = ShapeUtil.rotateShape(OUTER, Direction.WEST);

    public static final VoxelShape LOWER_OUTER = Shapes.or(LOWER_BASE_OUTER);
    public static final VoxelShape LOWER_OUTER_EAST = ShapeUtil.rotateShape(LOWER_OUTER, Direction.EAST);
    public static final VoxelShape LOWER_OUTER_SOUTH = ShapeUtil.rotateShape(LOWER_OUTER, Direction.SOUTH);
    public static final VoxelShape LOWER_OUTER_WEST = ShapeUtil.rotateShape(LOWER_OUTER, Direction.WEST);

    public static final VoxelShape INNER = Shapes.or(BASE_INNER);
    public static final VoxelShape INNER_EAST = ShapeUtil.rotateShape(INNER, Direction.EAST);
    public static final VoxelShape INNER_SOUTH = ShapeUtil.rotateShape(INNER, Direction.SOUTH);
    public static final VoxelShape INNER_WEST = ShapeUtil.rotateShape(INNER, Direction.WEST);

    public static final VoxelShape LOWER_INNER = Shapes.or(LOWER_BASE_INNER);
    public static final VoxelShape LOWER_INNER_EAST = ShapeUtil.rotateShape(LOWER_INNER, Direction.EAST);
    public static final VoxelShape LOWER_INNER_SOUTH = ShapeUtil.rotateShape(LOWER_INNER, Direction.SOUTH);
    public static final VoxelShape LOWER_INNER_WEST = ShapeUtil.rotateShape(LOWER_INNER, Direction.WEST);

    public static final VoxelShape RIGHT = Shapes.or(RAIL_RIGHT, BASE);
    public static final VoxelShape RIGHT_EAST = ShapeUtil.rotateShape(RIGHT, Direction.EAST);
    public static final VoxelShape RIGHT_SOUTH = ShapeUtil.rotateShape(RIGHT, Direction.SOUTH);
    public static final VoxelShape RIGHT_WEST = ShapeUtil.rotateShape(RIGHT, Direction.WEST);

    public static final VoxelShape LOWER_RIGHT = Shapes.or(LOWER_RAIL_RIGHT, LOWER_BASE);
    public static final VoxelShape LOWER_RIGHT_EAST = ShapeUtil.rotateShape(LOWER_RIGHT, Direction.EAST);
    public static final VoxelShape LOWER_RIGHT_SOUTH = ShapeUtil.rotateShape(LOWER_RIGHT, Direction.SOUTH);
    public static final VoxelShape LOWER_RIGHT_WEST = ShapeUtil.rotateShape(LOWER_RIGHT, Direction.WEST);

    public static final VoxelShape LEFT = Shapes.or(RAIL_LEFT, BASE);
    public static final VoxelShape LEFT_EAST = ShapeUtil.rotateShape(LEFT, Direction.EAST);
    public static final VoxelShape LEFT_SOUTH = ShapeUtil.rotateShape(LEFT, Direction.SOUTH);
    public static final VoxelShape LEFT_WEST = ShapeUtil.rotateShape(LEFT, Direction.WEST);

    public static final VoxelShape LOWER_LEFT = Shapes.or(LOWER_RAIL_LEFT, LOWER_BASE);
    public static final VoxelShape LOWER_LEFT_EAST = ShapeUtil.rotateShape(LOWER_LEFT, Direction.EAST);
    public static final VoxelShape LOWER_LEFT_SOUTH = ShapeUtil.rotateShape(LOWER_LEFT, Direction.SOUTH);
    public static final VoxelShape LOWER_LEFT_WEST = ShapeUtil.rotateShape(LOWER_LEFT, Direction.WEST);


    public ModStairBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(MODEL_TYPE, StairModelType.BOTTOM));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(blockPos);
        BlockState blockState = this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return blockState.setValue(TYPE, getConnection(blockState, context.getLevel(), blockPos));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));

        BlockEntity blockEntity = level.getBlockEntity(currentPos);
        if (blockEntity instanceof ILockable lockable && lockable.isLocked()) {
            return state; // Return the current state if the block is locked
        }

        return direction.getAxis().isHorizontal() ? state.setValue(TYPE, getConnection(state, (Level) level, currentPos)) : super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    public enum StairModelType implements StringRepresentable {
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

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        StairType shape = state.getValue(TYPE);
        StairModelType modelShape = state.getValue(MODEL_TYPE);
        if (modelShape == StairModelType.BOTTOM) {
            return switch (shape) {
                case SINGLE -> switch (facing) {
                    case EAST -> SINGLE_EAST;
                    case SOUTH -> SINGLE_SOUTH;
                    case WEST -> SINGLE_WEST;
                    default -> SINGLE;
                };
                case MIDDLE -> switch (facing) {
                    case EAST -> MIDDLE_EAST;
                    case SOUTH -> MIDDLE_SOUTH;
                    case WEST -> MIDDLE_WEST;
                    default -> MIDDLE;
                };
                case OUTER_LEFT -> switch (facing) {
                    case EAST -> OUTER_EAST;
                    case SOUTH -> OUTER_SOUTH;
                    case WEST -> OUTER_WEST;
                    default -> OUTER;
                };
                case OUTER_RIGHT -> switch (facing) {
                    case EAST -> OUTER_SOUTH;
                    case SOUTH -> OUTER_WEST;
                    case WEST -> OUTER;
                    default -> OUTER_EAST;
                };
                case LEFT -> switch (facing) {
                    case EAST -> LEFT_EAST;
                    case SOUTH -> LEFT_SOUTH;
                    case WEST -> LEFT_WEST;
                    default -> LEFT;
                };
                case RIGHT -> switch (facing) {
                    case EAST -> RIGHT_EAST;
                    case SOUTH -> RIGHT_SOUTH;
                    case WEST -> RIGHT_WEST;
                    default -> RIGHT;
                };
                case INNER_RIGHT -> switch (facing) {
                    case EAST -> INNER_SOUTH;
                    case SOUTH -> INNER_WEST;
                    case WEST -> INNER;
                    default -> INNER_EAST;
                };
                case INNER_LEFT -> switch (facing) {
                    case EAST -> INNER_EAST;
                    case SOUTH -> INNER_SOUTH;
                    case WEST -> INNER_WEST;
                    default -> INNER;
                };
            };
        } else {
            return switch (shape) {
                case SINGLE -> switch (facing) {
                    case EAST -> LOWER_SINGLE_EAST;
                    case SOUTH -> LOWER_SINGLE_SOUTH;
                    case WEST -> LOWER_SINGLE_WEST;
                    default -> LOWER_SINGLE;
                };
                case MIDDLE -> switch (facing) {
                    case EAST -> LOWER_MIDDLE_EAST;
                    case SOUTH -> LOWER_MIDDLE_SOUTH;
                    case WEST -> LOWER_MIDDLE_WEST;
                    default -> LOWER_MIDDLE;
                };
                case OUTER_LEFT -> switch (facing) {
                    case EAST -> LOWER_OUTER_EAST;
                    case SOUTH -> LOWER_OUTER_SOUTH;
                    case WEST -> LOWER_OUTER_WEST;
                    default -> LOWER_OUTER;
                };
                case OUTER_RIGHT -> switch (facing) {
                    case EAST -> LOWER_OUTER_SOUTH;
                    case SOUTH -> LOWER_OUTER_WEST;
                    case WEST -> LOWER_OUTER;
                    default -> LOWER_OUTER_EAST;
                };
                case LEFT -> switch (facing) {
                    case EAST -> LOWER_LEFT_EAST;
                    case SOUTH -> LOWER_LEFT_SOUTH;
                    case WEST -> LOWER_LEFT_WEST;
                    default -> LOWER_LEFT;
                };
                case RIGHT -> switch (facing) {
                    case EAST -> LOWER_RIGHT_EAST;
                    case SOUTH -> LOWER_RIGHT_SOUTH;
                    case WEST -> LOWER_RIGHT_WEST;
                    default -> LOWER_RIGHT;
                };
                case INNER_RIGHT -> switch (facing) {
                    case EAST -> LOWER_INNER_SOUTH;
                    case SOUTH -> LOWER_INNER_WEST;
                    case WEST -> LOWER_INNER;
                    default -> LOWER_INNER_EAST;
                };
                case INNER_LEFT -> switch (facing) {
                    case EAST -> LOWER_INNER_EAST;
                    case SOUTH -> LOWER_INNER_SOUTH;
                    case WEST -> LOWER_INNER_WEST;
                    default -> LOWER_INNER;
                };
            };
        }
    }

    private static Direction getNeighbourDirection(StairModelType modelType) {
        return modelType == StairModelType.BOTTOM ? Direction.UP : Direction.DOWN;
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            StairModelType modelType = state.getValue(MODEL_TYPE);
            BlockPos otherPos = pos.relative(getNeighbourDirection(modelType));
            BlockState otherState = level.getBlockState(otherPos);

            if (otherState.getBlock() == this && otherState.getValue(MODEL_TYPE) != modelType) {
                BlockPos bottomPos = modelType == StairModelType.BOTTOM ? pos : otherPos;
                BlockPos topPos = modelType == StairModelType.TOP ? pos : otherPos;

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
        BlockPos blockpos = pos.above();
        level.setBlock(blockpos, state.setValue(MODEL_TYPE, StairModelType.TOP), Block.UPDATE_ALL);

    }



    @Override
    public RenderShape getRenderShape(BlockState state) {
        return state.getValue(MODEL_TYPE) == StairModelType.BOTTOM ? RenderShape.MODEL : RenderShape.INVISIBLE;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        Item item = stack.getItem();
        if (item instanceof HammerItem || item instanceof WrenchItem) {
            return ItemInteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        if (hitResult.getDirection() != Direction.UP) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        if (!(stack.getItem() instanceof BlockItem blockItem)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        Block blockInHand = blockItem.getBlock();
        if (!(blockInHand instanceof PlatformBlock || blockInHand instanceof ModStairBlock)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        Direction facing = state.getValue(FACING);
        StairModelType modelType = state.getValue(MODEL_TYPE);
        BlockPos targetPos = getTargetPos(pos, facing, modelType);

        if (!canPlaceBlock(level, targetPos, modelType)) {
            return ItemInteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        return placeBlock(level, targetPos, blockInHand, facing, player, stack, modelType);

    }

    private BlockPos getTargetPos(BlockPos pos, Direction facing, StairModelType modelType) {
        if (modelType == StairModelType.TOP) {
            return pos.relative(facing.getOpposite());
        } else {
            return pos.above().relative(facing.getOpposite());
        }
    }

    private boolean canPlaceBlock(Level level, BlockPos pos, StairModelType modelType) {
        BlockState state = level.getBlockState(pos);
        BlockState stateAbove = level.getBlockState(pos.above());
        return state.canBeReplaced() && stateAbove.canBeReplaced();
    }

    private ItemInteractionResult placeBlock(Level level, BlockPos pos, Block blockToPlace, Direction facing, Player player, ItemStack stack, StairModelType modelType) {
        boolean isStairBlock = blockToPlace instanceof ModStairBlock;
        BlockState newState = createNewBlockState(blockToPlace, facing, level, pos);

        if (isStairBlock) {
            BlockState typeNewState = createStairTypeNewState(blockToPlace, facing, level, pos);
            placeStairBlocks(level, pos, newState, typeNewState, modelType);
        } else {
            level.setBlock(pos, newState, 3);
        }

        // Play the block place sound
        playPlaceSound(level, pos, blockToPlace);

        if (!player.isCreative()) {
            stack.shrink(1);
        }
        newState.updateNeighbourShapes(level, pos, 3);
        return ItemInteractionResult.SUCCESS;
    }

    private BlockState createNewBlockState(Block block, Direction facing, Level level, BlockPos pos) {
        return block.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(WATERLOGGED, level.getFluidState(pos).getType() == Fluids.WATER);
    }

    private BlockState createStairTypeNewState(Block block, Direction facing, Level level, BlockPos pos) {
        return createNewBlockState(block, facing, level, pos)
                .setValue(MODEL_TYPE, StairModelType.TOP);
    }

    private void placeStairBlocks(Level level, BlockPos pos, BlockState newState, BlockState typeNewState, StairModelType modelType) {
        level.setBlock(pos, newState, 3);
        level.setBlock(pos.above(), typeNewState, 3);
    }

    private void playPlaceSound(Level level, BlockPos pos, Block block) {
        SoundType soundType = block.defaultBlockState().getSoundType();
        level.playSound(null, pos, soundType.getPlaceSound(), SoundSource.BLOCKS,
                (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);
    }




    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE, WATERLOGGED, MODEL_TYPE);
    }

    public static StairType getConnection(BlockState state, Level level, BlockPos pos) {
        Direction facing = state.getValue(FACING);

        Direction dir1;
        BlockState state1 = level.getBlockState(pos.relative(facing));
        if (state1.getBlock() instanceof ModStairBlock && (dir1 = state1.getValue(FACING)).getAxis() != state.getValue(FACING).getAxis() && isDifferentOrientation(state, level, pos, dir1.getOpposite())) {
            if (dir1 == facing.getCounterClockWise()) {
                return StairType.INNER_LEFT;
            }
            return StairType.INNER_RIGHT;
        }

        Direction dir2;
        BlockState state2 = level.getBlockState(pos.relative(facing.getOpposite()));
        if (state2.getBlock() instanceof ModStairBlock && (dir2 = state2.getValue(FACING)).getAxis() != state.getValue(FACING).getAxis() && isDifferentOrientation(state, level, pos, dir2)) {
            if (dir2 == facing.getCounterClockWise()) {
                return StairType.OUTER_LEFT;
            }
            return StairType.OUTER_RIGHT;
        }

        boolean left = canConnect(level, pos, state.getValue(FACING).getCounterClockWise());
        boolean right = canConnect(level, pos, state.getValue(FACING).getClockWise());
        if (left && right) {
            return StairType.MIDDLE;
        }
        else if (left) {
            return StairType.LEFT;
        }
        else if (right) {
            return StairType.RIGHT;
        }
        return StairType.SINGLE;
    }

    public static boolean canConnect(Level level, BlockPos pos, Direction direction) {
        BlockState state = level.getBlockState(pos.relative(direction));
        return state.getBlock() instanceof ModStairBlock;
    }

    public static boolean isDifferentOrientation(BlockState state, Level level, BlockPos pos, Direction dir) {
        BlockState blockState = level.getBlockState(pos.relative(dir));
        return !(blockState.getBlock() instanceof ModStairBlock) || blockState.getValue(FACING) != state.getValue(FACING);
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
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
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
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
        super.appendHoverText(stack, context, tooltip, flag);
    }

    public List<Property<?>> getHammerableProperties() {
        return List.of(TYPE);
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
        return new LockableBlockEntity(pos, state);
    }
}