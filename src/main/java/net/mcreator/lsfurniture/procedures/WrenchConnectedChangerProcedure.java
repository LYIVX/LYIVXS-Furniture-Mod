package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.init.LsFurnitureModBlocks;

import java.util.Map;

public class WrenchConnectedChangerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.CONNECTING_OAK_SMALL_BRICKS.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.FRAMED_OAK_SMALL_BRICKS.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.FRAMED_OAK_SMALL_BRICKS.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.CONNECTING_OAK_SMALL_BRICKS.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.CONNECTING_OAK_BIG_BRICKS.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.FRAMED_OAK_BIG_BRICKS.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.FRAMED_OAK_BIG_BRICKS.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.CONNECTING_OAK_BIG_BRICKS.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.CONNECTING_OAK_CHECKERED.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.FRAMED_OAK_CHECKERED.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.FRAMED_OAK_CHECKERED.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.CONNECTING_OAK_CHECKERED.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.CONNECTING_OAK_CHECKED.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.FRAMED_OAK_CHECKED.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.FRAMED_OAK_CHECKED.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.CONNECTING_OAK_CHECKED.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.CONNECTING_OAK_DIAGONAL.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.FRAMED_OAK_DIAGONAL.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.FRAMED_OAK_DIAGONAL.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.CONNECTING_OAK_DIAGONAL.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.CONNECTING_OAK_DUNES.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.FRAMED_OAK_DUNES.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.FRAMED_OAK_DUNES.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.CONNECTING_OAK_DUNES.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.CONNECTING_OAK_HORIZONTAL_STRIPES.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.FRAMED_OAK_HORIZONTAL_STRIPES.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.FRAMED_OAK_HORIZONTAL_STRIPES.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.CONNECTING_OAK_HORIZONTAL_STRIPES.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.CONNECTING_OAK_VERTICAL_STRIPES.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.FRAMED_OAK_VERTICAL_STRIPES.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.FRAMED_OAK_VERTICAL_STRIPES.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.CONNECTING_OAK_VERTICAL_STRIPES.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.CONNECTING_OAK_MOSAIC.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.FRAMED_OAK_MOSAIC.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.FRAMED_OAK_MOSAIC.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.CONNECTING_OAK_MOSAIC.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.CONNECTING_OAK_SLASH.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.FRAMED_OAK_SLASH.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.FRAMED_OAK_SLASH.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.CONNECTING_OAK_SLASH.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.CONNECTING_OAK_SWIRL.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.FRAMED_OAK_SWIRL.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.FRAMED_OAK_SWIRL.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.CONNECTING_OAK_SWIRL.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.CONNECTING_OAK_SWIRL.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.FRAMED_OAK_SWIRL.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.FRAMED_OAK_SWIRL.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.CONNECTING_OAK_SWIRL.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.CONNECTING_OAK_WAVEY.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.FRAMED_OAK_WAVEY.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == LsFurnitureModBlocks.FRAMED_OAK_WAVEY.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = LsFurnitureModBlocks.CONNECTING_OAK_WAVEY.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
	}
}
