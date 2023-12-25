
package net.mcreator.lsfurniture.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.HitResult;
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
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.procedures.SeatBlockDestroyedProcedure;
import net.mcreator.lsfurniture.procedures.SeatAddedProcedure;
import net.mcreator.lsfurniture.procedures.BirchWhiteBlockAddedProcedure;
import net.mcreator.lsfurniture.init.LsFurnitureModBlocks;

import java.util.List;
import java.util.Collections;

public class BirchWhiteLeftEndBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public BirchWhiteLeftEndBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
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
			default -> Shapes.or(box(0, 10, -0.5, 16, 12, 3), box(0, 12, -1.3, 16, 14, 2.2), box(0, 14, -2.1, 16, 16, 1.4), box(14, 0, 14, 16, 2, 16), box(0, 0, 14, 2, 2, 16), box(0, 0, 0, 2, 2, 2), box(14, 0, 0, 16, 2, 2), box(3, 2, 3, 13, 6, 16),
					box(13, 2, 3, 16, 6, 16), box(0, 2, 3, 3, 10, 16), box(0, 2, 0, 16, 10, 3));
			case NORTH -> Shapes.or(box(0, 10, 13, 16, 12, 16.5), box(0, 12, 13.8, 16, 14, 17.3), box(0, 14, 14.6, 16, 16, 18.1), box(0, 0, 0, 2, 2, 2), box(14, 0, 0, 16, 2, 2), box(14, 0, 14, 16, 2, 16), box(0, 0, 14, 2, 2, 16),
					box(3, 2, 0, 13, 6, 13), box(0, 2, 0, 3, 6, 13), box(13, 2, 0, 16, 10, 13), box(0, 2, 13, 16, 10, 16));
			case EAST -> Shapes.or(box(-0.5, 10, 0, 3, 12, 16), box(-1.3, 12, 0, 2.2, 14, 16), box(-2.1, 14, 0, 1.4, 16, 16), box(14, 0, 0, 16, 2, 2), box(14, 0, 14, 16, 2, 16), box(0, 0, 14, 2, 2, 16), box(0, 0, 0, 2, 2, 2), box(3, 2, 3, 16, 6, 13),
					box(3, 2, 0, 16, 6, 3), box(3, 2, 13, 16, 10, 16), box(0, 2, 0, 3, 10, 16));
			case WEST -> Shapes.or(box(13, 10, 0, 16.5, 12, 16), box(13.8, 12, 0, 17.3, 14, 16), box(14.6, 14, 0, 18.1, 16, 16), box(0, 0, 14, 2, 2, 16), box(0, 0, 0, 2, 2, 2), box(14, 0, 0, 16, 2, 2), box(14, 0, 14, 16, 2, 16),
					box(0, 2, 3, 13, 6, 13), box(0, 2, 13, 13, 6, 16), box(0, 2, 0, 13, 10, 3), box(13, 2, 0, 16, 10, 16));
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
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(LsFurnitureModBlocks.BIRCH_WHITE_SOFA.get());
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(LsFurnitureModBlocks.BIRCH_WHITE_SOFA.get()));
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		SeatAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		BirchWhiteBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		SeatBlockDestroyedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}

	@Override
	public void wasExploded(Level world, BlockPos pos, Explosion e) {
		super.wasExploded(world, pos, e);
		SeatBlockDestroyedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
