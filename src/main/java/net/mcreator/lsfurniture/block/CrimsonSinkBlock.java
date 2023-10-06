
package net.mcreator.lsfurniture.block;

import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.procedures.SinkOnBlockRightClickedProcedure;
import net.mcreator.lsfurniture.init.LsFurnitureModBlockEntities;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Collections;

public class CrimsonSinkBlock extends BaseEntityBlock implements EntityBlock {
	public static final IntegerProperty ANIMATION = IntegerProperty.create("animation", 0, (int) 2);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public CrimsonSinkBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD)
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("block.wood.break")), () -> new SoundEvent(new ResourceLocation("block.metal.step")), () -> new SoundEvent(new ResourceLocation("block.wood.place")),
						() -> new SoundEvent(new ResourceLocation("block.wood.hit")), () -> new SoundEvent(new ResourceLocation("block.wood.fall"))))
				.strength(2f, 3f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return LsFurnitureModBlockEntities.CRIMSON_SINK.get().create(blockPos, blockState);
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
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {

		return switch (state.getValue(FACING)) {
			default ->
				Shapes.join(Shapes.or(box(0, 0, 0, 16, 16, 15), box(0, 14, 0, 16, 16, 16), box(0, 16, 0, 16, 18, 1), box(1, 16, 2, 15, 17, 14), box(7, 17, 2, 9, 20, 4), box(7, 20, 2, 9, 22, 7)), box(3, 13, 4, 13, 17, 12), BooleanOp.ONLY_FIRST);
			case NORTH ->
				Shapes.join(Shapes.or(box(0, 0, 1, 16, 16, 16), box(0, 14, 0, 16, 16, 16), box(0, 16, 15, 16, 18, 16), box(1, 16, 2, 15, 17, 14), box(7, 17, 12, 9, 20, 14), box(7, 20, 9, 9, 22, 14)), box(3, 13, 4, 13, 17, 12), BooleanOp.ONLY_FIRST);
			case EAST ->
				Shapes.join(Shapes.or(box(0, 0, 0, 15, 16, 16), box(0, 14, 0, 16, 16, 16), box(0, 16, 0, 1, 18, 16), box(2, 16, 1, 14, 17, 15), box(2, 17, 7, 4, 20, 9), box(2, 20, 7, 7, 22, 9)), box(4, 13, 3, 12, 17, 13), BooleanOp.ONLY_FIRST);
			case WEST ->
				Shapes.join(Shapes.or(box(1, 0, 0, 16, 16, 16), box(0, 14, 0, 16, 16, 16), box(15, 16, 0, 16, 18, 16), box(2, 16, 1, 14, 17, 15), box(12, 17, 7, 14, 20, 9), box(9, 20, 7, 14, 22, 9)), box(4, 13, 3, 12, 17, 13), BooleanOp.ONLY_FIRST);
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(ANIMATION, FACING);
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
		if (player.getInventory().getSelected().getItem() instanceof TieredItem tieredItem)
			return tieredItem.getTier().getLevel() >= 0;
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

		SinkOnBlockRightClickedProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}
}
