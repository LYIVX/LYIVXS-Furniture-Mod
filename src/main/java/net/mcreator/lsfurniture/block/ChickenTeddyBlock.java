
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

import net.mcreator.lsfurniture.procedures.ChickenTeddyOnBlockRightClickedProcedure;

import java.util.List;
import java.util.Collections;

public class ChickenTeddyBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public ChickenTeddyBlock() {
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
			default -> Shapes.or(box(6.4, 2.5, 9.4, 9.6, 7.3, 11.8), box(6.4, 4.1, 11.8, 9.6, 5.7, 13.4), box(7.2, 2.5, 11, 8.8, 4.1, 12.6), box(5.6, 0.1, 3.8, 10.4, 4.9, 10.2), box(10.4, 0.9, 4.6, 11.2, 4.1, 9.4), box(4.8, 0.9, 4.6, 5.6, 4.1, 9.4));
			case NORTH -> Shapes.or(box(6.4, 2.5, 4.2, 9.6, 7.3, 6.6), box(6.4, 4.1, 2.6, 9.6, 5.7, 4.2), box(7.2, 2.5, 3.4, 8.8, 4.1, 5), box(5.6, 0.1, 5.8, 10.4, 4.9, 12.2), box(4.8, 0.9, 6.6, 5.6, 4.1, 11.4), box(10.4, 0.9, 6.6, 11.2, 4.1, 11.4));
			case EAST ->
				Shapes.or(box(9.4, 2.5, 6.4, 11.8, 7.3, 9.6), box(11.8, 4.1, 6.4, 13.4, 5.7, 9.6), box(11, 2.5, 7.2, 12.6, 4.1, 8.8), box(3.8, 0.1, 5.6, 10.2, 4.9, 10.4), box(4.6, 0.9, 4.8, 9.4, 4.1, 5.6), box(4.6, 0.9, 10.4, 9.4, 4.1, 11.2));
			case WEST -> Shapes.or(box(4.2, 2.5, 6.4, 6.6, 7.3, 9.6), box(2.6, 4.1, 6.4, 4.2, 5.7, 9.6), box(3.4, 2.5, 7.2, 5, 4.1, 8.8), box(5.8, 0.1, 5.6, 12.2, 4.9, 10.4), box(6.6, 0.9, 10.4, 11.4, 4.1, 11.2), box(6.6, 0.9, 4.8, 11.4, 4.1, 5.6));
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
		ChickenTeddyOnBlockRightClickedProcedure.execute(world, x, y, z);
		return InteractionResult.SUCCESS;
	}
}
