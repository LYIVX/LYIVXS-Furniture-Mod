package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.init.LsFurnitureModBlocks;

public class IronTableJunctionProProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String groupTag = "";
		BlockState model = Blocks.AIR.defaultBlockState();
		model = LsFurnitureModBlocks.IRON_JUNCTION.get().defaultBlockState();
		groupTag = "forge" + ":" + "iron_table";
		if ((world.getBlockState(new BlockPos(x, y, z - 1)).isFaceSturdy(world, new BlockPos(x, y, z - 1), Direction.SOUTH)
				|| (world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))))
				&& (world.getBlockState(new BlockPos(x + 1, y, z)).isFaceSturdy(world, new BlockPos(x + 1, y, z), Direction.WEST)
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))))
				&& (world.getBlockState(new BlockPos(x, y, z + 1)).isFaceSturdy(world, new BlockPos(x, y, z + 1), Direction.NORTH)
						|| (world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))))
				&& !world.getBlockState(new BlockPos(x - 1, y, z)).isFaceSturdy(world, new BlockPos(x - 1, y, z), Direction.EAST)
				&& !(world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))) && !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == model.getBlock())) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = model;
				BlockEntity _be = world.getBlockEntity(_bp);
				CompoundTag _bnbt = null;
				if (_be != null) {
					_bnbt = _be.saveWithFullMetadata();
					_be.setRemoved();
				}
				world.setBlock(_bp, _bs, 3);
				if (_bnbt != null) {
					_be = world.getBlockEntity(_bp);
					if (_be != null) {
						try {
							_be.load(_bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
			{
				Direction _dir = Direction.EAST;
				BlockPos _pos = new BlockPos(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
		}
		if (!world.getBlockState(new BlockPos(x, y, z - 1)).isFaceSturdy(world, new BlockPos(x, y, z - 1), Direction.SOUTH)
				&& !(world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& (world.getBlockState(new BlockPos(x + 1, y, z)).isFaceSturdy(world, new BlockPos(x + 1, y, z), Direction.WEST)
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))))
				&& (world.getBlockState(new BlockPos(x, y, z + 1)).isFaceSturdy(world, new BlockPos(x, y, z + 1), Direction.NORTH)
						|| (world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))))
				&& (world.getBlockState(new BlockPos(x - 1, y, z)).isFaceSturdy(world, new BlockPos(x - 1, y, z), Direction.EAST)
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))))
				&& !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == model.getBlock())) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = model;
				BlockEntity _be = world.getBlockEntity(_bp);
				CompoundTag _bnbt = null;
				if (_be != null) {
					_bnbt = _be.saveWithFullMetadata();
					_be.setRemoved();
				}
				world.setBlock(_bp, _bs, 3);
				if (_bnbt != null) {
					_be = world.getBlockEntity(_bp);
					if (_be != null) {
						try {
							_be.load(_bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
			{
				Direction _dir = Direction.SOUTH;
				BlockPos _pos = new BlockPos(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z - 1)).isFaceSturdy(world, new BlockPos(x, y, z - 1), Direction.SOUTH)
				|| (world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))))
				&& !world.getBlockState(new BlockPos(x + 1, y, z)).isFaceSturdy(world, new BlockPos(x + 1, y, z), Direction.WEST)
				&& !(world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& (world.getBlockState(new BlockPos(x, y, z + 1)).isFaceSturdy(world, new BlockPos(x, y, z + 1), Direction.NORTH)
						|| (world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))))
				&& (world.getBlockState(new BlockPos(x - 1, y, z)).isFaceSturdy(world, new BlockPos(x - 1, y, z), Direction.EAST)
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))))
				&& !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == model.getBlock())) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = model;
				BlockEntity _be = world.getBlockEntity(_bp);
				CompoundTag _bnbt = null;
				if (_be != null) {
					_bnbt = _be.saveWithFullMetadata();
					_be.setRemoved();
				}
				world.setBlock(_bp, _bs, 3);
				if (_bnbt != null) {
					_be = world.getBlockEntity(_bp);
					if (_be != null) {
						try {
							_be.load(_bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
			{
				Direction _dir = Direction.WEST;
				BlockPos _pos = new BlockPos(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z - 1)).isFaceSturdy(world, new BlockPos(x, y, z - 1), Direction.SOUTH)
				|| (world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))))
				&& (world.getBlockState(new BlockPos(x + 1, y, z)).isFaceSturdy(world, new BlockPos(x + 1, y, z), Direction.WEST)
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))))
				&& !world.getBlockState(new BlockPos(x, y, z + 1)).isFaceSturdy(world, new BlockPos(x, y, z + 1), Direction.NORTH)
				&& !(world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& (world.getBlockState(new BlockPos(x - 1, y, z)).isFaceSturdy(world, new BlockPos(x - 1, y, z), Direction.EAST)
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))))
				&& !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == model.getBlock())) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = model;
				BlockEntity _be = world.getBlockEntity(_bp);
				CompoundTag _bnbt = null;
				if (_be != null) {
					_bnbt = _be.saveWithFullMetadata();
					_be.setRemoved();
				}
				world.setBlock(_bp, _bs, 3);
				if (_bnbt != null) {
					_be = world.getBlockEntity(_bp);
					if (_be != null) {
						try {
							_be.load(_bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
			{
				Direction _dir = Direction.NORTH;
				BlockPos _pos = new BlockPos(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
		}
	}
}
