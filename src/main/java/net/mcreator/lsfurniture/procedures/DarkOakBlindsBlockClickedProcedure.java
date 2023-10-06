package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.init.LsFurnitureModBlocks;

import java.util.Map;

public class DarkOakBlindsBlockClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState top = Blocks.AIR.defaultBlockState();
		BlockState bottom = Blocks.AIR.defaultBlockState();
		BlockState topc = Blocks.AIR.defaultBlockState();
		BlockState bottomc = Blocks.AIR.defaultBlockState();
		String open = "";
		String closed = "";
		top = LsFurnitureModBlocks.DARK_OAK_BLINDS_TOP.get().defaultBlockState();
		bottom = LsFurnitureModBlocks.DARK_OAK_BLINDS_BOTTOM.get().defaultBlockState();
		topc = LsFurnitureModBlocks.DARK_OAK_BLINDS_TOP_CLOSED.get().defaultBlockState();
		bottomc = LsFurnitureModBlocks.DARK_OAK_BLINDS_BOTTOM_CLOSED.get().defaultBlockState();
		open = "dark_oak_blinds";
		closed = "dark_oak_blinds_closed";
		if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation((("forge" + ":" + open)).toLowerCase(java.util.Locale.ENGLISH)))) && (world.getBlockState(new BlockPos(x, y, z))).getBlock() == top.getBlock()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = topc;
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
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).is(BlockTags.create(new ResourceLocation((("forge" + ":" + open)).toLowerCase(java.util.Locale.ENGLISH))))
					&& (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == bottom.getBlock()) {
				{
					BlockPos _bp = new BlockPos(x, y - 1, z);
					BlockState _bs = bottomc;
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
		} else if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation((("forge" + ":" + open)).toLowerCase(java.util.Locale.ENGLISH))))
				&& (world.getBlockState(new BlockPos(x, y, z))).getBlock() == bottom.getBlock()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = bottomc;
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
			if ((world.getBlockState(new BlockPos(x, y + 1, z))).is(BlockTags.create(new ResourceLocation((("forge" + ":" + open)).toLowerCase(java.util.Locale.ENGLISH))))
					&& (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == top.getBlock()) {
				{
					BlockPos _bp = new BlockPos(x, y + 1, z);
					BlockState _bs = topc;
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
		} else if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation((("forge" + ":" + closed)).toLowerCase(java.util.Locale.ENGLISH))))
				&& (world.getBlockState(new BlockPos(x, y, z))).getBlock() == topc.getBlock()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = top;
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
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).is(BlockTags.create(new ResourceLocation((("forge" + ":" + closed)).toLowerCase(java.util.Locale.ENGLISH))))
					&& (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == bottomc.getBlock()) {
				{
					BlockPos _bp = new BlockPos(x, y - 1, z);
					BlockState _bs = bottom;
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
		} else if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation((("forge" + ":" + closed)).toLowerCase(java.util.Locale.ENGLISH))))
				&& (world.getBlockState(new BlockPos(x, y, z))).getBlock() == bottomc.getBlock()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = bottom;
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
			if ((world.getBlockState(new BlockPos(x, y + 1, z))).is(BlockTags.create(new ResourceLocation((("forge" + ":" + closed)).toLowerCase(java.util.Locale.ENGLISH))))
					&& (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == topc.getBlock()) {
				{
					BlockPos _bp = new BlockPos(x, y + 1, z);
					BlockState _bs = top;
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
}
