
package net.mcreator.lsfurniture.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.procedures.BlazeTeddyOnBlockRightClickedProcedure;

import java.util.List;
import java.util.Collections;

public class BlazeTeddyBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public BlazeTeddyBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.WOOL).strength(0.8f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(9.5, 3, 8.5, 10.5, 7, 9.5), box(5.5, 4.5, 6.5, 6.5, 8.5, 7.5), box(7.5, 3.5, 9, 8.5, 7.5, 10), box(8.5, 1.5, 5.5, 9.5, 5.5, 6.5), box(6, 1, 8, 7, 5, 9), box(6.5, 3, 5, 7.5, 7, 6), box(8, 0, 7, 9, 4, 8),
					box(4.5, 5.5, 7, 5.5, 9.5, 8), box(10.5, 5, 7, 11.5, 9, 8), box(8.5, 5, 4.5, 9.5, 9, 5.5), box(8.5, 4, 6.5, 9.5, 8, 7.5), box(7, 4, 7, 8, 8, 8), box(6, 8.5, 6, 10, 12.5, 10));
			case NORTH -> Shapes.or(box(5.5, 3, 6.5, 6.5, 7, 7.5), box(9.5, 4.5, 8.5, 10.5, 8.5, 9.5), box(7.5, 3.5, 6, 8.5, 7.5, 7), box(6.5, 1.5, 9.5, 7.5, 5.5, 10.5), box(9, 1, 7, 10, 5, 8), box(8.5, 3, 10, 9.5, 7, 11), box(7, 0, 8, 8, 4, 9),
					box(10.5, 5.5, 8, 11.5, 9.5, 9), box(4.5, 5, 8, 5.5, 9, 9), box(6.5, 5, 10.5, 7.5, 9, 11.5), box(6.5, 4, 8.5, 7.5, 8, 9.5), box(8, 4, 8, 9, 8, 9), box(6, 8.5, 6, 10, 12.5, 10));
			case EAST -> Shapes.or(box(8.5, 3, 5.5, 9.5, 7, 6.5), box(6.5, 4.5, 9.5, 7.5, 8.5, 10.5), box(9, 3.5, 7.5, 10, 7.5, 8.5), box(5.5, 1.5, 6.5, 6.5, 5.5, 7.5), box(8, 1, 9, 9, 5, 10), box(5, 3, 8.5, 6, 7, 9.5), box(7, 0, 7, 8, 4, 8),
					box(7, 5.5, 10.5, 8, 9.5, 11.5), box(7, 5, 4.5, 8, 9, 5.5), box(4.5, 5, 6.5, 5.5, 9, 7.5), box(6.5, 4, 6.5, 7.5, 8, 7.5), box(7, 4, 8, 8, 8, 9), box(6, 8.5, 6, 10, 12.5, 10));
			case WEST -> Shapes.or(box(6.5, 3, 9.5, 7.5, 7, 10.5), box(8.5, 4.5, 5.5, 9.5, 8.5, 6.5), box(6, 3.5, 7.5, 7, 7.5, 8.5), box(9.5, 1.5, 8.5, 10.5, 5.5, 9.5), box(7, 1, 6, 8, 5, 7), box(10, 3, 6.5, 11, 7, 7.5), box(8, 0, 8, 9, 4, 9),
					box(8, 5.5, 4.5, 9, 9.5, 5.5), box(8, 5, 10.5, 9, 9, 11.5), box(10.5, 5, 8.5, 11.5, 9, 9.5), box(8.5, 4, 8.5, 9.5, 8, 9.5), box(8, 4, 7, 9, 8, 8), box(6, 8.5, 6, 10, 12.5, 10));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		BlazeTeddyOnBlockRightClickedProcedure.execute(world, x, y, z);
		return InteractionResult.SUCCESS;
	}
}
