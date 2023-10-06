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

import java.util.Map;

public class JungleWhiteEndProProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String groupTag = "";
		BlockState model = Blocks.AIR.defaultBlockState();
		BlockState model2 = Blocks.AIR.defaultBlockState();
		model = LsFurnitureModBlocks.JUNGLE_WHITE_LEFT_END.get().defaultBlockState();
		model2 = LsFurnitureModBlocks.JUNGLE_WHITE_RIGHT_END.get().defaultBlockState();
		groupTag = "forge" + ":" + "jungle_white_sofa_tag";
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(new BlockPos(x, y, z))))) == Direction.WEST && (world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))) && !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == model2.getBlock())) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = model2;
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
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
		}
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(new BlockPos(x, y, z))))) == Direction.WEST && !(world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& (world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))) && !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == model.getBlock())) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = model;
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
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
		}
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(new BlockPos(x, y, z))))) == Direction.EAST && (world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))) && !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == model.getBlock())) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = model;
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
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
		}
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(new BlockPos(x, y, z))))) == Direction.EAST && !(world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& (world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))) && !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == model2.getBlock())) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = model2;
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
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
		}
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(new BlockPos(x, y, z))))) == Direction.NORTH && !(world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& (world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))) && !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == model2.getBlock())) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = model2;
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
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
		}
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(new BlockPos(x, y, z))))) == Direction.NORTH && !(world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& (world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))) && !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == model.getBlock())) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = model;
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
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
		}
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(new BlockPos(x, y, z))))) == Direction.SOUTH && !(world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& (world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))) && !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == model.getBlock())) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = model;
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
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
		}
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(new BlockPos(x, y, z))))) == Direction.SOUTH && !(world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& (world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH)))) && !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == model2.getBlock())) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = model2;
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
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
		}
	}
}
