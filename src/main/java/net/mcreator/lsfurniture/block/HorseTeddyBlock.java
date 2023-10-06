
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

import net.mcreator.lsfurniture.procedures.HorseTeddyOnBlockRightClickedProcedure;

import java.util.List;
import java.util.Collections;

public class HorseTeddyBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public HorseTeddyBlock() {
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
			default -> Shapes.or(box(6, 4.4, 4.35, 10, 8.4, 13.15), box(7.4, 2.4, 3.55, 8.6, 8, 5.15), box(6, 0, 4.35, 7.6, 4.4, 5.95), box(8.4, 0, 4.35, 10, 4.4, 5.95), box(6, 0, 11.55, 7.6, 4.4, 13.15), box(8.4, 0, 11.55, 10, 4.4, 13.15),
					box(6.8, 10.8, 10.45, 9.2, 12.8, 13.25), box(7.2, 10.8, 13.25, 8.8, 12.8, 15.25), box(6.8, 12.6, 10.454, 7.6, 13.8, 10.854), box(8.4, 12.6, 10.454, 9.2, 13.8, 10.854), box(7.2, 6.4, 10.45, 8.8, 11.2, 13.25),
					box(7.6, 6.4, 9.65, 8.4, 12.8, 10.45));
			case NORTH -> Shapes.or(box(6, 4.4, 2.85, 10, 8.4, 11.65), box(7.4, 2.4, 10.85, 8.6, 8, 12.45), box(8.4, 0, 10.05, 10, 4.4, 11.65), box(6, 0, 10.05, 7.6, 4.4, 11.65), box(8.4, 0, 2.85, 10, 4.4, 4.45), box(6, 0, 2.85, 7.6, 4.4, 4.45),
					box(6.8, 10.8, 2.75, 9.2, 12.8, 5.55), box(7.2, 10.8, 0.75, 8.8, 12.8, 2.75), box(8.4, 12.6, 5.146, 9.2, 13.8, 5.546), box(6.8, 12.6, 5.146, 7.6, 13.8, 5.546), box(7.2, 6.4, 2.75, 8.8, 11.2, 5.55),
					box(7.6, 6.4, 5.55, 8.4, 12.8, 6.35));
			case EAST -> Shapes.or(box(4.35, 4.4, 6, 13.15, 8.4, 10), box(3.55, 2.4, 7.4, 5.15, 8, 8.6), box(4.35, 0, 8.4, 5.95, 4.4, 10), box(4.35, 0, 6, 5.95, 4.4, 7.6), box(11.55, 0, 8.4, 13.15, 4.4, 10), box(11.55, 0, 6, 13.15, 4.4, 7.6),
					box(10.45, 10.8, 6.8, 13.25, 12.8, 9.2), box(13.25, 10.8, 7.2, 15.25, 12.8, 8.8), box(10.454, 12.6, 8.4, 10.854, 13.8, 9.2), box(10.454, 12.6, 6.8, 10.854, 13.8, 7.6), box(10.45, 6.4, 7.2, 13.25, 11.2, 8.8),
					box(9.65, 6.4, 7.6, 10.45, 12.8, 8.4));
			case WEST -> Shapes.or(box(2.85, 4.4, 6, 11.65, 8.4, 10), box(10.85, 2.4, 7.4, 12.45, 8, 8.6), box(10.05, 0, 6, 11.65, 4.4, 7.6), box(10.05, 0, 8.4, 11.65, 4.4, 10), box(2.85, 0, 6, 4.45, 4.4, 7.6), box(2.85, 0, 8.4, 4.45, 4.4, 10),
					box(2.75, 10.8, 6.8, 5.55, 12.8, 9.2), box(0.75, 10.8, 7.2, 2.75, 12.8, 8.8), box(5.146, 12.6, 6.8, 5.546, 13.8, 7.6), box(5.146, 12.6, 8.4, 5.546, 13.8, 9.2), box(2.75, 6.4, 7.2, 5.55, 11.2, 8.8),
					box(5.55, 6.4, 7.6, 6.35, 12.8, 8.4));
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
		HorseTeddyOnBlockRightClickedProcedure.execute(world, x, y, z);
		return InteractionResult.SUCCESS;
	}
}
