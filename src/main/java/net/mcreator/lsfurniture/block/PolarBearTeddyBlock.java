
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

import net.mcreator.lsfurniture.procedures.PolarBearTeddyOnBlockRightClickedProcedure;

import java.util.List;
import java.util.Collections;

public class PolarBearTeddyBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public PolarBearTeddyBlock() {
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
			default -> Shapes.or(box(2.54532, 0, 7.85786, 6.54532, 1.6, 10.25786), box(9.65468, 0, 7.85786, 13.65468, 1.6, 10.25786), box(0.40217, 0, 3.13917, 4.40217, 1.6, 6.33917), box(11.79783, 0, 3.13917, 15.79783, 1.6, 6.33917),
					box(5.3, 0, 1.24558, 10.9, 4.4, 6.84558), box(5.7, 0, 6.84558, 10.5, 4, 11.64558), box(6.7, 0.8, 11.64558, 9.5, 3.6, 14.44558), box(7.1, 0.8, 14.44558, 9.1, 2, 15.64558), box(9.1, 3.2, 13.24558, 9.9, 4, 13.64558),
					box(6.3, 3.2, 13.24558, 7.1, 4, 13.64558));
			case NORTH -> Shapes.or(box(9.45468, 0, 5.74214, 13.45468, 1.6, 8.14214), box(2.34532, 0, 5.74214, 6.34532, 1.6, 8.14214), box(11.59783, 0, 9.66083, 15.59783, 1.6, 12.86083), box(0.20217, 0, 9.66083, 4.20217, 1.6, 12.86083),
					box(5.1, 0, 9.15442, 10.7, 4.4, 14.75442), box(5.5, 0, 4.35442, 10.3, 4, 9.15442), box(6.5, 0.8, 1.55442, 9.3, 3.6, 4.35442), box(6.9, 0.8, 0.35442, 8.9, 2, 1.55442), box(6.1, 3.2, 2.35442, 6.9, 4, 2.75442),
					box(8.9, 3.2, 2.35442, 9.7, 4, 2.75442));
			case EAST -> Shapes.or(box(7.85786, 0, 9.45468, 10.25786, 1.6, 13.45468), box(7.85786, 0, 2.34532, 10.25786, 1.6, 6.34532), box(3.13917, 0, 11.59783, 6.33917, 1.6, 15.59783), box(3.13917, 0, 0.20217, 6.33917, 1.6, 4.20217),
					box(1.24558, 0, 5.1, 6.84558, 4.4, 10.7), box(6.84558, 0, 5.5, 11.64558, 4, 10.3), box(11.64558, 0.8, 6.5, 14.44558, 3.6, 9.3), box(14.44558, 0.8, 6.9, 15.64558, 2, 8.9), box(13.24558, 3.2, 6.1, 13.64558, 4, 6.9),
					box(13.24558, 3.2, 8.9, 13.64558, 4, 9.7));
			case WEST -> Shapes.or(box(5.74214, 0, 2.54532, 8.14214, 1.6, 6.54532), box(5.74214, 0, 9.65468, 8.14214, 1.6, 13.65468), box(9.66083, 0, 0.40217, 12.86083, 1.6, 4.40217), box(9.66083, 0, 11.79783, 12.86083, 1.6, 15.79783),
					box(9.15442, 0, 5.3, 14.75442, 4.4, 10.9), box(4.35442, 0, 5.7, 9.15442, 4, 10.5), box(1.55442, 0.8, 6.7, 4.35442, 3.6, 9.5), box(0.35442, 0.8, 7.1, 1.55442, 2, 9.1), box(2.35442, 3.2, 9.1, 2.75442, 4, 9.9),
					box(2.35442, 3.2, 6.3, 2.75442, 4, 7.1));
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
		PolarBearTeddyOnBlockRightClickedProcedure.execute(world, x, y, z);
		return InteractionResult.SUCCESS;
	}
}
