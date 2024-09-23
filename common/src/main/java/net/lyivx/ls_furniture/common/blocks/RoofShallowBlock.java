//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
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

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RoofShallowBlock extends Block implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
    public static final EnumProperty<StairsShape> SHAPE = BlockStateProperties.STAIRS_SHAPE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty IS_DOUBLE = ModBlockStateProperties.IS_DOUBLE;
    private final Block base;
    private final BlockState baseState;

    protected static final VoxelShape BOTTOM_SHAPE_STRAIGHT = Shapes.join(Block.box(0, 0, 0, 16, 4, 16), Block.box(0, 4, 8, 16, 8, 16), BooleanOp.OR);
    protected static final VoxelShape BOTTOM_SHAPE_INNER_LEFT = Stream.of(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 4, 8, 16, 8, 16),
            Block.box(8, 4, 0, 16, 8, 8)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape BOTTOM_SHAPE_INNER_RIGHT = Stream.of(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 4, 8, 16, 8, 16),
            Block.box(0, 4, 0, 8, 8, 8)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape BOTTOM_SHAPE_OUTER_LEFT = Shapes.join(Block.box(0, 0, 0, 16, 4, 16), Block.box(8, 4, 8, 16, 8, 16), BooleanOp.OR);
    protected static final VoxelShape BOTTOM_SHAPE_OUTER_RIGHT = Shapes.join(Block.box(0, 0, 0, 16, 4, 16), Block.box(0, 4, 8, 8, 8, 16), BooleanOp.OR);
    protected static final VoxelShape TOP_SHAPE_STRAIGHT = Shapes.join(Block.box(0, 12, 0, 16, 16, 16), Block.box(0, 8, 8, 16, 12, 16), BooleanOp.OR);
    protected static final VoxelShape TOP_SHAPE_INNER_LEFT = Stream.of(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(0, 8, 8, 16, 12, 16),
            Block.box(8, 8, 0, 16, 12, 8)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape TOP_SHAPE_INNER_RIGHT = Stream.of(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(0, 8, 8, 16, 12, 16),
            Block.box(0, 8, 0, 8, 12, 8)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape TOP_SHAPE_OUTER_LEFT = Shapes.join(Block.box(0, 12, 0, 16, 16, 16), Block.box(8, 8, 8, 16, 12, 16), BooleanOp.OR);
    protected static final VoxelShape TOP_SHAPE_OUTER_RIGHT = Shapes.join(Block.box(0, 12, 0, 16, 16, 16), Block.box(0, 8, 8, 8, 12, 16), BooleanOp.OR);
    
    protected static final VoxelShape DOUBLE_BOTTOM_SHAPE_STRAIGHT = Stream.of(
            Block.box(0, 12, 8, 16, 16, 16),
            Block.box(0, 8, 0, 16, 12, 16),
            Block.box(0, 0, 0, 16, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape DOUBLE_BOTTOM_SHAPE_INNER_LEFT = Stream.of(
            Block.box(0, 12, 8, 16, 16, 16),
            Block.box(8, 12, 0, 16, 16, 8),
            Block.box(0, 8, 0, 16, 12, 16),
            Block.box(0, 0, 0, 16, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape DOUBLE_BOTTOM_SHAPE_INNER_RIGHT = Stream.of(
            Block.box(0, 12, 8, 16, 16, 16),
            Block.box(0, 12, 0, 8, 16, 8),
            Block.box(0, 8, 0, 16, 12, 16),
            Block.box(0, 0, 0, 16, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape DOUBLE_BOTTOM_SHAPE_OUTER_LEFT = Stream.of(
            Block.box(8, 12, 8, 16, 16, 16),
            Block.box(0, 8, 0, 16, 12, 16),
            Block.box(0, 0, 0, 16, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape DOUBLE_BOTTOM_SHAPE_OUTER_RIGHT = Stream.of(
            Block.box(0, 12, 8, 8, 16, 16),
            Block.box(0, 8, 0, 16, 12, 16),
            Block.box(0, 0, 0, 16, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape DOUBLE_TOP_SHAPE_STRAIGHT = Stream.of(
            Block.box(0, 0, 8, 16, 4, 16),
            Block.box(0, 4, 0, 16, 8, 16),
            Block.box(0, 8, 0, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape DOUBLE_TOP_SHAPE_INNER_LEFT = Stream.of(
            Block.box(0, 0, 8, 16, 4, 16),
            Block.box(8, 0, 0, 16, 4, 8),
            Block.box(0, 4, 0, 16, 8, 16),
            Block.box(0, 8, 0, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape DOUBLE_TOP_SHAPE_INNER_RIGHT = Stream.of(
            Block.box(0, 0, 8, 16, 4, 16),
            Block.box(0, 0, 0, 8, 4, 8),
            Block.box(0, 4, 0, 16, 8, 16),
            Block.box(0, 8, 0, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape DOUBLE_TOP_SHAPE_OUTER_LEFT = Stream.of(
            Block.box(8, 0, 8, 16, 4, 16),
            Block.box(0, 4, 0, 16, 8, 16),
            Block.box(0, 8, 0, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape DOUBLE_TOP_SHAPE_OUTER_RIGHT = Stream.of(
            Block.box(0, 0, 8, 8, 4, 16),
            Block.box(0, 4, 0, 16, 8, 16),
            Block.box(0, 8, 0, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    
    
    
    private static VoxelShape[] makeShapes(VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner) {
        return (VoxelShape[])IntStream.range(0, 16).mapToObj((i) -> {
            return makeStairShape(i, slabShape, nwCorner, neCorner, swCorner, seCorner);
        }).toArray((i) -> {
            return new VoxelShape[i];
        });
    }

    private static VoxelShape makeStairShape(int bitfield, VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner) {
        VoxelShape voxelShape = slabShape;
        if ((bitfield & 1) != 0) {
            voxelShape = Shapes.or(voxelShape, nwCorner);
        }

        if ((bitfield & 2) != 0) {
            voxelShape = Shapes.or(voxelShape, neCorner);
        }

        if ((bitfield & 4) != 0) {
            voxelShape = Shapes.or(voxelShape, swCorner);
        }

        if ((bitfield & 8) != 0) {
            voxelShape = Shapes.or(voxelShape, seCorner);
        }

        return voxelShape;
    }

    public RoofShallowBlock(BlockState baseState, BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any())
                .setValue(FACING, Direction.NORTH))
                .setValue(HALF, Half.BOTTOM))
                .setValue(SHAPE, StairsShape.STRAIGHT))
                .setValue(WATERLOGGED, false)
                .setValue(IS_DOUBLE, false));
        this.base = baseState.getBlock();
        this.baseState = baseState;
    }

    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    private static final VoxelShape[] BOTTOM_SHAPES_STRAIGHT = new VoxelShape[4];
    static {
        BOTTOM_SHAPES_STRAIGHT[0] = ShapeUtil.rotateShape(BOTTOM_SHAPE_STRAIGHT, Direction.NORTH); //South
        BOTTOM_SHAPES_STRAIGHT[1] = ShapeUtil.rotateShape(BOTTOM_SHAPE_STRAIGHT, Direction.EAST); //West
        BOTTOM_SHAPES_STRAIGHT[2] = ShapeUtil.rotateShape(BOTTOM_SHAPE_STRAIGHT, Direction.SOUTH); //North
        BOTTOM_SHAPES_STRAIGHT[3] = ShapeUtil.rotateShape(BOTTOM_SHAPE_STRAIGHT, Direction.WEST); //East
    }

    private static final VoxelShape[] BOTTOM_SHAPES_INNER_LEFT = new VoxelShape[4];
    static {
        BOTTOM_SHAPES_INNER_LEFT[0] = ShapeUtil.rotateShape(BOTTOM_SHAPE_INNER_LEFT, Direction.NORTH); //South
        BOTTOM_SHAPES_INNER_LEFT[1] = ShapeUtil.rotateShape(BOTTOM_SHAPE_INNER_LEFT, Direction.EAST); //West
        BOTTOM_SHAPES_INNER_LEFT[2] = ShapeUtil.rotateShape(BOTTOM_SHAPE_INNER_LEFT, Direction.SOUTH); //North
        BOTTOM_SHAPES_INNER_LEFT[3] = ShapeUtil.rotateShape(BOTTOM_SHAPE_INNER_LEFT, Direction.WEST); //East
    }

    private static final VoxelShape[] BOTTOM_SHAPES_INNER_RIGHT = new VoxelShape[4];
    static {
        BOTTOM_SHAPES_INNER_RIGHT[0] = ShapeUtil.rotateShape(BOTTOM_SHAPE_INNER_RIGHT, Direction.NORTH); //South
        BOTTOM_SHAPES_INNER_RIGHT[1] = ShapeUtil.rotateShape(BOTTOM_SHAPE_INNER_RIGHT, Direction.EAST); //West
        BOTTOM_SHAPES_INNER_RIGHT[2] = ShapeUtil.rotateShape(BOTTOM_SHAPE_INNER_RIGHT, Direction.SOUTH); //North
        BOTTOM_SHAPES_INNER_RIGHT[3] = ShapeUtil.rotateShape(BOTTOM_SHAPE_INNER_RIGHT, Direction.WEST); //East
    }

    private static final VoxelShape[] BOTTOM_SHAPES_OUTER_LEFT = new VoxelShape[4];
    static {
        BOTTOM_SHAPES_OUTER_LEFT[0] = ShapeUtil.rotateShape(BOTTOM_SHAPE_OUTER_LEFT, Direction.NORTH); //South
        BOTTOM_SHAPES_OUTER_LEFT[1] = ShapeUtil.rotateShape(BOTTOM_SHAPE_OUTER_LEFT, Direction.EAST); //West
        BOTTOM_SHAPES_OUTER_LEFT[2] = ShapeUtil.rotateShape(BOTTOM_SHAPE_OUTER_LEFT, Direction.SOUTH); //North
        BOTTOM_SHAPES_OUTER_LEFT[3] = ShapeUtil.rotateShape(BOTTOM_SHAPE_OUTER_LEFT, Direction.WEST); //East
    }

    private static final VoxelShape[] BOTTOM_SHAPES_OUTER_RIGHT = new VoxelShape[4];
    static {
        BOTTOM_SHAPES_OUTER_RIGHT[0] = ShapeUtil.rotateShape(BOTTOM_SHAPE_OUTER_RIGHT, Direction.NORTH); //South
        BOTTOM_SHAPES_OUTER_RIGHT[1] = ShapeUtil.rotateShape(BOTTOM_SHAPE_OUTER_RIGHT, Direction.EAST); //West
        BOTTOM_SHAPES_OUTER_RIGHT[2] = ShapeUtil.rotateShape(BOTTOM_SHAPE_OUTER_RIGHT, Direction.SOUTH); //North
        BOTTOM_SHAPES_OUTER_RIGHT[3] = ShapeUtil.rotateShape(BOTTOM_SHAPE_OUTER_RIGHT, Direction.WEST); //East
    }
    private static final VoxelShape[] TOP_SHAPES_STRAIGHT = new VoxelShape[4];
    static {
        TOP_SHAPES_STRAIGHT[0] = ShapeUtil.rotateShape(TOP_SHAPE_STRAIGHT, Direction.NORTH); //South
        TOP_SHAPES_STRAIGHT[1] = ShapeUtil.rotateShape(TOP_SHAPE_STRAIGHT, Direction.EAST); //West
        TOP_SHAPES_STRAIGHT[2] = ShapeUtil.rotateShape(TOP_SHAPE_STRAIGHT, Direction.SOUTH); //North
        TOP_SHAPES_STRAIGHT[3] = ShapeUtil.rotateShape(TOP_SHAPE_STRAIGHT, Direction.WEST); //East
    }

    private static final VoxelShape[] TOP_SHAPES_INNER_LEFT = new VoxelShape[4];
    static {
        TOP_SHAPES_INNER_LEFT[0] = ShapeUtil.rotateShape(TOP_SHAPE_INNER_LEFT, Direction.NORTH); //South
        TOP_SHAPES_INNER_LEFT[1] = ShapeUtil.rotateShape(TOP_SHAPE_INNER_LEFT, Direction.EAST); //West
        TOP_SHAPES_INNER_LEFT[2] = ShapeUtil.rotateShape(TOP_SHAPE_INNER_LEFT, Direction.SOUTH); //North
        TOP_SHAPES_INNER_LEFT[3] = ShapeUtil.rotateShape(TOP_SHAPE_INNER_LEFT, Direction.WEST); //East
    }

    private static final VoxelShape[] TOP_SHAPES_INNER_RIGHT = new VoxelShape[4];
    static {
        TOP_SHAPES_INNER_RIGHT[0] = ShapeUtil.rotateShape(TOP_SHAPE_INNER_RIGHT, Direction.NORTH); //South
        TOP_SHAPES_INNER_RIGHT[1] = ShapeUtil.rotateShape(TOP_SHAPE_INNER_RIGHT, Direction.EAST); //West
        TOP_SHAPES_INNER_RIGHT[2] = ShapeUtil.rotateShape(TOP_SHAPE_INNER_RIGHT, Direction.SOUTH); //North
        TOP_SHAPES_INNER_RIGHT[3] = ShapeUtil.rotateShape(TOP_SHAPE_INNER_RIGHT, Direction.WEST); //East
    }

    private static final VoxelShape[] TOP_SHAPES_OUTER_LEFT = new VoxelShape[4];
    static {
        TOP_SHAPES_OUTER_LEFT[0] = ShapeUtil.rotateShape(TOP_SHAPE_OUTER_LEFT, Direction.NORTH); //South
        TOP_SHAPES_OUTER_LEFT[1] = ShapeUtil.rotateShape(TOP_SHAPE_OUTER_LEFT, Direction.EAST); //West
        TOP_SHAPES_OUTER_LEFT[2] = ShapeUtil.rotateShape(TOP_SHAPE_OUTER_LEFT, Direction.SOUTH); //North
        TOP_SHAPES_OUTER_LEFT[3] = ShapeUtil.rotateShape(TOP_SHAPE_OUTER_LEFT, Direction.WEST); //East
    }

    private static final VoxelShape[] TOP_SHAPES_OUTER_RIGHT = new VoxelShape[4];
    static {
        TOP_SHAPES_OUTER_RIGHT[0] = ShapeUtil.rotateShape(TOP_SHAPE_OUTER_RIGHT, Direction.NORTH); //South
        TOP_SHAPES_OUTER_RIGHT[1] = ShapeUtil.rotateShape(TOP_SHAPE_OUTER_RIGHT, Direction.EAST); //West
        TOP_SHAPES_OUTER_RIGHT[2] = ShapeUtil.rotateShape(TOP_SHAPE_OUTER_RIGHT, Direction.SOUTH); //North
        TOP_SHAPES_OUTER_RIGHT[3] = ShapeUtil.rotateShape(TOP_SHAPE_OUTER_RIGHT, Direction.WEST); //East
    }



    private static final VoxelShape[] DOUBLE_BOTTOM_SHAPES_STRAIGHT = new VoxelShape[4];
    static {
        DOUBLE_BOTTOM_SHAPES_STRAIGHT[0] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_STRAIGHT, Direction.NORTH); //South
        DOUBLE_BOTTOM_SHAPES_STRAIGHT[1] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_STRAIGHT, Direction.EAST); //West
        DOUBLE_BOTTOM_SHAPES_STRAIGHT[2] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_STRAIGHT, Direction.SOUTH); //North
        DOUBLE_BOTTOM_SHAPES_STRAIGHT[3] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_STRAIGHT, Direction.WEST); //East
    }

    private static final VoxelShape[] DOUBLE_BOTTOM_SHAPES_INNER_LEFT = new VoxelShape[4];
    static {
        DOUBLE_BOTTOM_SHAPES_INNER_LEFT[0] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_INNER_LEFT, Direction.NORTH); //South
        DOUBLE_BOTTOM_SHAPES_INNER_LEFT[1] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_INNER_LEFT, Direction.EAST); //West
        DOUBLE_BOTTOM_SHAPES_INNER_LEFT[2] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_INNER_LEFT, Direction.SOUTH); //North
        DOUBLE_BOTTOM_SHAPES_INNER_LEFT[3] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_INNER_LEFT, Direction.WEST); //East
    }

    private static final VoxelShape[] DOUBLE_BOTTOM_SHAPES_INNER_RIGHT = new VoxelShape[4];
    static {
        DOUBLE_BOTTOM_SHAPES_INNER_RIGHT[0] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_INNER_RIGHT, Direction.NORTH); //South
        DOUBLE_BOTTOM_SHAPES_INNER_RIGHT[1] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_INNER_RIGHT, Direction.EAST); //West
        DOUBLE_BOTTOM_SHAPES_INNER_RIGHT[2] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_INNER_RIGHT, Direction.SOUTH); //North
        DOUBLE_BOTTOM_SHAPES_INNER_RIGHT[3] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_INNER_RIGHT, Direction.WEST); //East
    }

    private static final VoxelShape[] DOUBLE_BOTTOM_SHAPES_OUTER_LEFT = new VoxelShape[4];
    static {
        DOUBLE_BOTTOM_SHAPES_OUTER_LEFT[0] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_OUTER_LEFT, Direction.NORTH); //South
        DOUBLE_BOTTOM_SHAPES_OUTER_LEFT[1] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_OUTER_LEFT, Direction.EAST); //West
        DOUBLE_BOTTOM_SHAPES_OUTER_LEFT[2] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_OUTER_LEFT, Direction.SOUTH); //North
        DOUBLE_BOTTOM_SHAPES_OUTER_LEFT[3] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_OUTER_LEFT, Direction.WEST); //East
    }

    private static final VoxelShape[] DOUBLE_BOTTOM_SHAPES_OUTER_RIGHT = new VoxelShape[4];
    static {
        DOUBLE_BOTTOM_SHAPES_OUTER_RIGHT[0] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_OUTER_RIGHT, Direction.NORTH); //South
        DOUBLE_BOTTOM_SHAPES_OUTER_RIGHT[1] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_OUTER_RIGHT, Direction.EAST); //West
        DOUBLE_BOTTOM_SHAPES_OUTER_RIGHT[2] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_OUTER_RIGHT, Direction.SOUTH); //North
        DOUBLE_BOTTOM_SHAPES_OUTER_RIGHT[3] = ShapeUtil.rotateShape(DOUBLE_BOTTOM_SHAPE_OUTER_RIGHT, Direction.WEST); //East
    }
    private static final VoxelShape[] DOUBLE_TOP_SHAPES_STRAIGHT = new VoxelShape[4];
    static {
        DOUBLE_TOP_SHAPES_STRAIGHT[0] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_STRAIGHT, Direction.NORTH); //South
        DOUBLE_TOP_SHAPES_STRAIGHT[1] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_STRAIGHT, Direction.EAST); //West
        DOUBLE_TOP_SHAPES_STRAIGHT[2] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_STRAIGHT, Direction.SOUTH); //North
        DOUBLE_TOP_SHAPES_STRAIGHT[3] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_STRAIGHT, Direction.WEST); //East
    }

    private static final VoxelShape[] DOUBLE_TOP_SHAPES_INNER_LEFT = new VoxelShape[4];
    static {
        DOUBLE_TOP_SHAPES_INNER_LEFT[0] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_INNER_LEFT, Direction.NORTH); //South
        DOUBLE_TOP_SHAPES_INNER_LEFT[1] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_INNER_LEFT, Direction.EAST); //West
        DOUBLE_TOP_SHAPES_INNER_LEFT[2] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_INNER_LEFT, Direction.SOUTH); //North
        DOUBLE_TOP_SHAPES_INNER_LEFT[3] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_INNER_LEFT, Direction.WEST); //East
    }

    private static final VoxelShape[] DOUBLE_TOP_SHAPES_INNER_RIGHT = new VoxelShape[4];
    static {
        DOUBLE_TOP_SHAPES_INNER_RIGHT[0] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_INNER_RIGHT, Direction.NORTH); //South
        DOUBLE_TOP_SHAPES_INNER_RIGHT[1] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_INNER_RIGHT, Direction.EAST); //West
        DOUBLE_TOP_SHAPES_INNER_RIGHT[2] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_INNER_RIGHT, Direction.SOUTH); //North
        DOUBLE_TOP_SHAPES_INNER_RIGHT[3] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_INNER_RIGHT, Direction.WEST); //East
    }

    private static final VoxelShape[] DOUBLE_TOP_SHAPES_OUTER_LEFT = new VoxelShape[4];
    static {
        DOUBLE_TOP_SHAPES_OUTER_LEFT[0] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_OUTER_LEFT, Direction.NORTH); //South
        DOUBLE_TOP_SHAPES_OUTER_LEFT[1] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_OUTER_LEFT, Direction.EAST); //West
        DOUBLE_TOP_SHAPES_OUTER_LEFT[2] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_OUTER_LEFT, Direction.SOUTH); //North
        DOUBLE_TOP_SHAPES_OUTER_LEFT[3] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_OUTER_LEFT, Direction.WEST); //East
    }

    private static final VoxelShape[] DOUBLE_TOP_SHAPES_OUTER_RIGHT = new VoxelShape[4];
    static {
        DOUBLE_TOP_SHAPES_OUTER_RIGHT[0] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_OUTER_RIGHT, Direction.NORTH); //South
        DOUBLE_TOP_SHAPES_OUTER_RIGHT[1] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_OUTER_RIGHT, Direction.EAST); //West
        DOUBLE_TOP_SHAPES_OUTER_RIGHT[2] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_OUTER_RIGHT, Direction.SOUTH); //North
        DOUBLE_TOP_SHAPES_OUTER_RIGHT[3] = ShapeUtil.rotateShape(DOUBLE_TOP_SHAPE_OUTER_RIGHT, Direction.WEST); //East
    }
    
    
    
    
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        boolean isTOP = (state.getValue(HALF) == Half.TOP);
        boolean isDOUBLE = (state.getValue(IS_DOUBLE));
        StairsShape shape = state.getValue(SHAPE);  // Assuming SHAPE is a BlockState property

        if (!isTOP) {
            if(!isDOUBLE) {
                if (shape.equals(StairsShape.STRAIGHT)) {
                    return BOTTOM_SHAPES_STRAIGHT[direction.get2DDataValue()];
                } else if (shape.equals(StairsShape.INNER_LEFT)) {
                    return BOTTOM_SHAPES_INNER_LEFT[direction.get2DDataValue()];
                } else if (shape.equals(StairsShape.INNER_RIGHT)) {
                    return BOTTOM_SHAPES_INNER_RIGHT[direction.get2DDataValue()]; // Corrected this
                } else if (shape.equals(StairsShape.OUTER_LEFT)) {
                    return BOTTOM_SHAPES_OUTER_LEFT[direction.get2DDataValue()];  // Corrected this
                } else if (shape.equals(StairsShape.OUTER_RIGHT)) {
                    return BOTTOM_SHAPES_OUTER_RIGHT[direction.get2DDataValue()];  // Corrected this
                }
            } else {
                if (shape.equals(StairsShape.STRAIGHT)) {
                    return DOUBLE_BOTTOM_SHAPES_STRAIGHT[direction.get2DDataValue()];
                } else if (shape.equals(StairsShape.INNER_LEFT)) {
                    return DOUBLE_BOTTOM_SHAPES_INNER_LEFT[direction.get2DDataValue()];
                } else if (shape.equals(StairsShape.INNER_RIGHT)) {
                    return DOUBLE_BOTTOM_SHAPES_INNER_RIGHT[direction.get2DDataValue()]; // Corrected this
                } else if (shape.equals(StairsShape.OUTER_LEFT)) {
                    return DOUBLE_BOTTOM_SHAPES_OUTER_LEFT[direction.get2DDataValue()];  // Corrected this
                } else if (shape.equals(StairsShape.OUTER_RIGHT)) {
                    return DOUBLE_BOTTOM_SHAPES_OUTER_RIGHT[direction.get2DDataValue()];  // Corrected this
                }
            }
        } else {
            if(!isDOUBLE) {
                if (shape.equals(StairsShape.STRAIGHT)) {
                    return TOP_SHAPES_STRAIGHT[direction.get2DDataValue()];
                } else if (shape.equals(StairsShape.INNER_LEFT)) {
                    return TOP_SHAPES_INNER_LEFT[direction.get2DDataValue()];
                } else if (shape.equals(StairsShape.INNER_RIGHT)) {
                    return TOP_SHAPES_INNER_RIGHT[direction.get2DDataValue()]; // Corrected this
                } else if (shape.equals(StairsShape.OUTER_LEFT)) {
                    return TOP_SHAPES_OUTER_LEFT[direction.get2DDataValue()];  // Corrected this
                } else if (shape.equals(StairsShape.OUTER_RIGHT)) {
                    return TOP_SHAPES_OUTER_RIGHT[direction.get2DDataValue()];  // Corrected this
                }
            } else {
                if (shape.equals(StairsShape.STRAIGHT)) {
                    return DOUBLE_TOP_SHAPES_STRAIGHT[direction.get2DDataValue()];
                } else if (shape.equals(StairsShape.INNER_LEFT)) {
                    return DOUBLE_TOP_SHAPES_INNER_LEFT[direction.get2DDataValue()];
                } else if (shape.equals(StairsShape.INNER_RIGHT)) {
                    return DOUBLE_TOP_SHAPES_INNER_RIGHT[direction.get2DDataValue()]; // Corrected this
                } else if (shape.equals(StairsShape.OUTER_LEFT)) {
                    return DOUBLE_TOP_SHAPES_OUTER_LEFT[direction.get2DDataValue()];  // Corrected this
                } else if (shape.equals(StairsShape.OUTER_RIGHT)) {
                    return DOUBLE_TOP_SHAPES_OUTER_RIGHT[direction.get2DDataValue()];  // Corrected this
                }
            }
        }
        return BOTTOM_SHAPES_STRAIGHT[direction.get2DDataValue()]; // Default return
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        this.base.animateTick(state, level, pos, random);
    }

    public void attack(BlockState state, Level level, BlockPos pos, Player player) {
        this.baseState.attack(level, pos, player);
    }

    public void destroy(LevelAccessor level, BlockPos pos, BlockState state) {
        this.base.destroy(level, pos, state);
    }

    public float getExplosionResistance() {
        return this.base.getExplosionResistance();
    }

    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if (!state.is(state.getBlock())) {
            level.neighborChanged(this.baseState, pos, Blocks.AIR, pos, false);
            this.base.onPlace(this.baseState, level, pos, oldState, false);
        }
    }

    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!state.is(newState.getBlock())) {
            this.baseState.onRemove(level, pos, newState, movedByPiston);
        }
    }

    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        this.base.stepOn(level, pos, state, entity);
    }

    public boolean isRandomlyTicking(BlockState state) {
        return this.base.isRandomlyTicking(state);
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.base.randomTick(state, level, pos, random);
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.base.tick(state, level, pos, random);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (state.getValue(HALF) == Half.BOTTOM) {
            if (hit.getDirection() != Direction.UP) {
                return InteractionResult.FAIL;
            }
        } else {
            if (hit.getDirection() != Direction.DOWN) {
                return InteractionResult.FAIL;
            }
        }

        if (!level.isClientSide() && stack.getItem() == this.asItem()) {
            BlockState newState = state.setValue(IS_DOUBLE, true);
            level.setBlock(pos, newState, 3);

            if (!player.isCreative()) {
                stack.shrink(1);
            }
            return InteractionResult.SUCCESS;
        }
        return this.baseState.use(level, player, hand, hit);
    }

    private <T extends Comparable<T>> BlockState copyProperty(BlockState fromState, BlockState toState, Property<T> property) {
        T value = fromState.getValue(property);  // Get the value of the property from the old state
        return toState.setValue(property, value); // Set the value on the new state
    }

    public void wasExploded(Level level, BlockPos pos, Explosion explosion) {
        this.base.wasExploded(level, pos, explosion);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getClickedFace();
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(blockPos);
        BlockState blockState = (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection())).setValue(HALF, direction != Direction.DOWN && (direction == Direction.UP || !(context.getClickLocation().y - (double)blockPos.getY() > 0.5)) ? Half.BOTTOM : Half.TOP)).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return (BlockState)blockState.setValue(SHAPE, getStairsShape(blockState, context.getLevel(), blockPos));
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if ((Boolean)state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return direction.getAxis().isHorizontal() ? (BlockState)state.setValue(SHAPE, getStairsShape(state, level, pos)) : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    private static StairsShape getStairsShape(BlockState state, BlockGetter level, BlockPos pos) {
        Direction direction = (Direction)state.getValue(FACING);
        BlockState blockState = level.getBlockState(pos.relative(direction));
        if (isStairs(blockState) && state.getValue(HALF) == blockState.getValue(HALF)) {
            Direction direction2 = (Direction)blockState.getValue(FACING);
            if (direction2.getAxis() != ((Direction)state.getValue(FACING)).getAxis() && canTakeShape(state, level, pos, direction2.getOpposite())) {
                if (direction2 == direction.getCounterClockWise()) {
                    return StairsShape.OUTER_LEFT;
                }

                return StairsShape.OUTER_RIGHT;
            }
        }

        BlockState blockState2 = level.getBlockState(pos.relative(direction.getOpposite()));
        if (isStairs(blockState2) && state.getValue(HALF) == blockState2.getValue(HALF)) {
            Direction direction3 = (Direction)blockState2.getValue(FACING);
            if (direction3.getAxis() != ((Direction)state.getValue(FACING)).getAxis() && canTakeShape(state, level, pos, direction3)) {
                if (direction3 == direction.getCounterClockWise()) {
                    return StairsShape.INNER_LEFT;
                }

                return StairsShape.INNER_RIGHT;
            }
        }

        return StairsShape.STRAIGHT;
    }

    private static boolean canTakeShape(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
        BlockState blockState = level.getBlockState(pos.relative(face));
        return !isStairs(blockState) || blockState.getValue(FACING) != state.getValue(FACING) || blockState.getValue(HALF) != state.getValue(HALF);
    }

    public static boolean isStairs(BlockState state) {
        return state.getBlock() instanceof RoofShallowBlock;
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue(FACING, rotation.rotate((Direction)state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        Direction direction = (Direction)state.getValue(FACING);
        StairsShape stairsShape = (StairsShape)state.getValue(SHAPE);
        switch (mirror) {
            case LEFT_RIGHT:
                if (direction.getAxis() == Axis.Z) {
                    switch (stairsShape) {
                        case INNER_LEFT -> {
                            return (BlockState)state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT);
                        }
                        case INNER_RIGHT -> {
                            return (BlockState)state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT);
                        }
                        case OUTER_LEFT -> {
                            return (BlockState)state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT);
                        }
                        case OUTER_RIGHT -> {
                            return (BlockState)state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT);
                        }
                        default -> {
                            return state.rotate(Rotation.CLOCKWISE_180);
                        }
                    }
                }
                break;
            case FRONT_BACK:
                if (direction.getAxis() == Axis.X) {
                    switch (stairsShape) {
                        case INNER_LEFT -> {
                            return (BlockState)state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT);
                        }
                        case INNER_RIGHT -> {
                            return (BlockState)state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT);
                        }
                        case OUTER_LEFT -> {
                            return (BlockState)state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT);
                        }
                        case OUTER_RIGHT -> {
                            return (BlockState)state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT);
                        }
                        case STRAIGHT -> {
                            return state.rotate(Rotation.CLOCKWISE_180);
                        }
                    }
                }
        }

        return super.mirror(state, mirror);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, HALF, SHAPE, WATERLOGGED, IS_DOUBLE});
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }
}
