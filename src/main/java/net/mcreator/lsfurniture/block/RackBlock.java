
package net.mcreator.lsfurniture.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class RackBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public RackBlock() {
		super(BlockBehaviour.Properties.of(Material.HEAVY_METAL).sound(SoundType.ANVIL).strength(4f, 5f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(16, 0.2, 2, 17, 2.1, 3), box(7, 0.2, 2, 8, 2.1, 3), box(7, 0.1, 4, 8, 2.1, 5), box(7, 0.1, 6, 8, 2.1, 7), box(16, 0.1, 6, 17, 2.1, 7), box(16, 0.1, 4, 17, 2.1, 5), box(8, 1.1, 4, 16, 2.1, 5),
					box(8, 1.1, 6, 16, 2.1, 7), box(8, 1.1, 2, 16, 2.1, 3));
			case NORTH -> Shapes.or(box(-1, 0.2, 13, 0, 2.1, 14), box(8, 0.2, 13, 9, 2.1, 14), box(8, 0.1, 11, 9, 2.1, 12), box(8, 0.1, 9, 9, 2.1, 10), box(-1, 0.1, 9, 0, 2.1, 10), box(-1, 0.1, 11, 0, 2.1, 12), box(0, 1.1, 11, 8, 2.1, 12),
					box(0, 1.1, 9, 8, 2.1, 10), box(0, 1.1, 13, 8, 2.1, 14));
			case EAST -> Shapes.or(box(2, 0.2, -1, 3, 2.1, 0), box(2, 0.2, 8, 3, 2.1, 9), box(4, 0.1, 8, 5, 2.1, 9), box(6, 0.1, 8, 7, 2.1, 9), box(6, 0.1, -1, 7, 2.1, 0), box(4, 0.1, -1, 5, 2.1, 0), box(4, 1.1, 0, 5, 2.1, 8),
					box(6, 1.1, 0, 7, 2.1, 8), box(2, 1.1, 0, 3, 2.1, 8));
			case WEST -> Shapes.or(box(13, 0.2, 16, 14, 2.1, 17), box(13, 0.2, 7, 14, 2.1, 8), box(11, 0.1, 7, 12, 2.1, 8), box(9, 0.1, 7, 10, 2.1, 8), box(9, 0.1, 16, 10, 2.1, 17), box(11, 0.1, 16, 12, 2.1, 17), box(11, 1.1, 8, 12, 2.1, 16),
					box(9, 1.1, 8, 10, 2.1, 16), box(13, 1.1, 8, 14, 2.1, 16));
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
}
