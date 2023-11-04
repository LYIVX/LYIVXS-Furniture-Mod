
package net.mcreator.lsfurniture.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FluidState;
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
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.procedures.ChairBlockDestroyedProcedure;
import net.mcreator.lsfurniture.procedures.ChairAddedProcedure;

import java.util.List;
import java.util.Collections;

public class BirchChairBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public BirchChairBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(3, 0, 11, 5, 7, 13), box(11, 0, 11, 13, 7, 13), box(11, 0, 3, 13, 7, 5), box(3, 0, 3, 5, 7, 5), box(3, 7, 3, 13, 8, 13), box(3, 8, 3, 5, 20, 5), box(5, 8.5, 3.5, 11, 19.5, 4.5), box(11, 8, 3, 13, 20, 5));
			case NORTH -> Shapes.or(box(11, 0, 3, 13, 7, 5), box(3, 0, 3, 5, 7, 5), box(3, 0, 11, 5, 7, 13), box(11, 0, 11, 13, 7, 13), box(3, 7, 3, 13, 8, 13), box(11, 8, 11, 13, 20, 13), box(5, 8.5, 11.5, 11, 19.5, 12.5), box(3, 8, 11, 5, 20, 13));
			case EAST -> Shapes.or(box(11, 0, 11, 13, 7, 13), box(11, 0, 3, 13, 7, 5), box(3, 0, 3, 5, 7, 5), box(3, 0, 11, 5, 7, 13), box(3, 7, 3, 13, 8, 13), box(3, 8, 11, 5, 20, 13), box(3.5, 8.5, 5, 4.5, 19.5, 11), box(3, 8, 3, 5, 20, 5));
			case WEST -> Shapes.or(box(3, 0, 3, 5, 7, 5), box(3, 0, 11, 5, 7, 13), box(11, 0, 11, 13, 7, 13), box(11, 0, 3, 13, 7, 5), box(3, 7, 3, 13, 8, 13), box(11, 8, 3, 13, 20, 5), box(11.5, 8.5, 5, 12.5, 19.5, 11), box(11, 8, 11, 13, 20, 13));
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
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		ChairAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		ChairBlockDestroyedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}

	@Override
	public void wasExploded(Level world, BlockPos pos, Explosion e) {
		super.wasExploded(world, pos, e);
		ChairBlockDestroyedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
