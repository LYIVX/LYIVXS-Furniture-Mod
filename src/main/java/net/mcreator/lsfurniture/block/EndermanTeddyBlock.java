
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
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.procedures.EndermanTeddyOnBlockRightClickedProcedure;

import java.util.List;
import java.util.Collections;

public class EndermanTeddyBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public EndermanTeddyBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.WOOL).strength(0.8f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(6.6932, 7.74417, 7.4966, 9.3068, 11.66458, 8.8034), box(6.6932, 11.22897, 6.8432, 9.3068, 13.84258, 9.4568), box(6.85655, 11.55567, 7.00655, 9.14345, 13.84258, 9.29345),
					box(9.3068, 1.86357, 7.8233, 9.9602, 11.66458, 8.4767), box(6.0398, 1.86357, 7.8233, 6.6932, 11.66458, 8.4767), box(8.3267, -0.09663, 7.8233, 8.9801, 9.70438, 8.4767), box(7.0199, -0.09663, 7.8233, 7.6733, 9.70438, 8.4767));
			case NORTH -> Shapes.or(box(6.6932, 7.74417, 7.1966, 9.3068, 11.66458, 8.5034), box(6.6932, 11.22897, 6.5432, 9.3068, 13.84258, 9.1568), box(6.85655, 11.55567, 6.70655, 9.14345, 13.84258, 8.99345),
					box(6.0398, 1.86357, 7.5233, 6.6932, 11.66458, 8.1767), box(9.3068, 1.86357, 7.5233, 9.9602, 11.66458, 8.1767), box(7.0199, -0.09663, 7.5233, 7.6733, 9.70438, 8.1767), box(8.3267, -0.09663, 7.5233, 8.9801, 9.70438, 8.1767));
			case EAST -> Shapes.or(box(7.4966, 7.74417, 6.6932, 8.8034, 11.66458, 9.3068), box(6.8432, 11.22897, 6.6932, 9.4568, 13.84258, 9.3068), box(7.00655, 11.55567, 6.85655, 9.29345, 13.84258, 9.14345),
					box(7.8233, 1.86357, 6.0398, 8.4767, 11.66458, 6.6932), box(7.8233, 1.86357, 9.3068, 8.4767, 11.66458, 9.9602), box(7.8233, -0.09663, 7.0199, 8.4767, 9.70438, 7.6733), box(7.8233, -0.09663, 8.3267, 8.4767, 9.70438, 8.9801));
			case WEST -> Shapes.or(box(7.1966, 7.74417, 6.6932, 8.5034, 11.66458, 9.3068), box(6.5432, 11.22897, 6.6932, 9.1568, 13.84258, 9.3068), box(6.70655, 11.55567, 6.85655, 8.99345, 13.84258, 9.14345),
					box(7.5233, 1.86357, 9.3068, 8.1767, 11.66458, 9.9602), box(7.5233, 1.86357, 6.0398, 8.1767, 11.66458, 6.6932), box(7.5233, -0.09663, 8.3267, 8.1767, 9.70438, 8.9801), box(7.5233, -0.09663, 7.0199, 8.1767, 9.70438, 7.6733));
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
		EndermanTeddyOnBlockRightClickedProcedure.execute(world, x, y, z);
		return InteractionResult.SUCCESS;
	}
}
