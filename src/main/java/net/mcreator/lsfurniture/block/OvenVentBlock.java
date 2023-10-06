
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
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.procedures.OvenVentOnBlockRightClickedProcedure;

import java.util.List;
import java.util.Collections;

public class OvenVentBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public OvenVentBlock() {
		super(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5f, 6f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(4, 5, 0, 12, 16, 4), box(3, 3, 0, 13, 5, 5), box(2, 1, 0, 14, 3, 6), box(14, 0, 0, 15, 1, 7), box(1, 0, 0, 2, 1, 7), box(2, 0, 0, 14, 1, 1), box(2, 0, 6, 14, 1, 7), box(2, 0.25, 1, 14, 1, 6),
					box(6, 0.175, 6.8, 6.5, 0.775, 7.1), box(7, 0.175, 6.8, 7.5, 0.775, 7.1), box(8.5, 0.175, 6.8, 10, 0.775, 7.1));
			case NORTH -> Shapes.or(box(4, 5, 12, 12, 16, 16), box(3, 3, 11, 13, 5, 16), box(2, 1, 10, 14, 3, 16), box(1, 0, 9, 2, 1, 16), box(14, 0, 9, 15, 1, 16), box(2, 0, 15, 14, 1, 16), box(2, 0, 9, 14, 1, 10), box(2, 0.25, 10, 14, 1, 15),
					box(9.5, 0.175, 8.9, 10, 0.775, 9.2), box(8.5, 0.175, 8.9, 9, 0.775, 9.2), box(6, 0.175, 8.9, 7.5, 0.775, 9.2));
			case EAST -> Shapes.or(box(0, 5, 4, 4, 16, 12), box(0, 3, 3, 5, 5, 13), box(0, 1, 2, 6, 3, 14), box(0, 0, 1, 7, 1, 2), box(0, 0, 14, 7, 1, 15), box(0, 0, 2, 1, 1, 14), box(6, 0, 2, 7, 1, 14), box(1, 0.25, 2, 6, 1, 14),
					box(6.8, 0.175, 9.5, 7.1, 0.775, 10), box(6.8, 0.175, 8.5, 7.1, 0.775, 9), box(6.8, 0.175, 6, 7.1, 0.775, 7.5));
			case WEST -> Shapes.or(box(12, 5, 4, 16, 16, 12), box(11, 3, 3, 16, 5, 13), box(10, 1, 2, 16, 3, 14), box(9, 0, 14, 16, 1, 15), box(9, 0, 1, 16, 1, 2), box(15, 0, 2, 16, 1, 14), box(9, 0, 2, 10, 1, 14), box(10, 0.25, 2, 15, 1, 14),
					box(8.9, 0.175, 6, 9.2, 0.775, 6.5), box(8.9, 0.175, 7, 9.2, 0.775, 7.5), box(8.9, 0.175, 8.5, 9.2, 0.775, 10));
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
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if (player.getInventory().getSelected().getItem() instanceof PickaxeItem tieredItem)
			return tieredItem.getTier().getLevel() >= 1;
		return false;
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
		OvenVentOnBlockRightClickedProcedure.execute(world, x, y, z);
		return InteractionResult.SUCCESS;
	}
}
