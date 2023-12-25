package net.mcreator.lsfurniture.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.init.LsFurnitureModParticleTypes;
import net.mcreator.lsfurniture.LsFurnitureMod;

public class KettleOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		{
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp)
				world.setBlock(_pos, _bs.setValue(_integerProp, 0), 3);
		}
		{
			int _value = 1;
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
				world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_button.click_on")), SoundSource.BLOCKS, (float) 0.4, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_button.click_on")), SoundSource.BLOCKS, (float) 0.4, 1, false);
			}
		}
		LsFurnitureMod.queueServerWork(10, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bubble_column.upwards_ambient")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bubble_column.upwards_ambient")), SoundSource.BLOCKS, 1, 1, false);
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
			}.getDirection(blockstate)) == Direction.NORTH) {
				LsFurnitureMod.queueServerWork(2, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.8), (y + 0.8), (z + 0.7), 2, 0.01, 0.1, 0.01, 0.1);
					LsFurnitureMod.queueServerWork(2, () -> {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.8), (y + 0.8), (z + 0.7), 2, 0.01, 0.1, 0.01, 0.1);
						LsFurnitureMod.queueServerWork(2, () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.8), (y + 0.8), (z + 0.7), 2, 0.01, 0.1, 0.01, 0.1);
							LsFurnitureMod.queueServerWork(2, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.8), (y + 0.8), (z + 0.7), 2, 0.01, 0.1, 0.01, 0.1);
								LsFurnitureMod.queueServerWork(2, () -> {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.8), (y + 0.8), (z + 0.7), 2, 0.01, 0.1, 0.01, 0.1);
									LsFurnitureMod.queueServerWork(2, () -> {
										if (world instanceof ServerLevel _level)
											_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.8), (y + 0.8), (z + 0.7), 2, 0.01, 0.1, 0.01, 0.1);
										LsFurnitureMod.queueServerWork(2, () -> {
											if (world instanceof ServerLevel _level)
												_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.8), (y + 0.8), (z + 0.7), 2, 0.01, 0.1, 0.01, 0.1);
											LsFurnitureMod.queueServerWork(2, () -> {
												if (world instanceof ServerLevel _level)
													_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.8), (y + 0.8), (z + 0.7), 2, 0.01, 0.1, 0.01, 0.1);
												LsFurnitureMod.queueServerWork(2, () -> {
													if (world instanceof ServerLevel _level)
														_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.8), (y + 0.8), (z + 0.7), 2, 0.01, 0.1, 0.01, 0.1);
													LsFurnitureMod.queueServerWork(2, () -> {
														if (world instanceof ServerLevel _level)
															_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.8), (y + 0.8), (z + 0.7), 2, 0.01, 0.1, 0.01, 0.1);
														LsFurnitureMod.queueServerWork(2, () -> {
															if (world instanceof ServerLevel _level)
																_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.8), (y + 0.8), (z + 0.7), 2, 0.01, 0.1, 0.01, 0.1);
														});
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			} else if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)) == Direction.SOUTH) {
				LsFurnitureMod.queueServerWork(2, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.2), (y + 0.8), (z + 0.3), 2, 0.01, 0.1, 0.01, 0.1);
					LsFurnitureMod.queueServerWork(2, () -> {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.2), (y + 0.8), (z + 0.3), 2, 0.01, 0.1, 0.01, 0.1);
						LsFurnitureMod.queueServerWork(2, () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.2), (y + 0.8), (z + 0.3), 2, 0.01, 0.1, 0.01, 0.1);
							LsFurnitureMod.queueServerWork(2, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.2), (y + 0.8), (z + 0.3), 2, 0.01, 0.1, 0.01, 0.1);
								LsFurnitureMod.queueServerWork(2, () -> {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.2), (y + 0.8), (z + 0.3), 2, 0.01, 0.1, 0.01, 0.1);
									LsFurnitureMod.queueServerWork(2, () -> {
										if (world instanceof ServerLevel _level)
											_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.2), (y + 0.8), (z + 0.3), 2, 0.01, 0.1, 0.01, 0.1);
										LsFurnitureMod.queueServerWork(2, () -> {
											if (world instanceof ServerLevel _level)
												_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.2), (y + 0.8), (z + 0.3), 2, 0.01, 0.1, 0.01, 0.1);
											LsFurnitureMod.queueServerWork(2, () -> {
												if (world instanceof ServerLevel _level)
													_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.2), (y + 0.8), (z + 0.3), 2, 0.01, 0.1, 0.01, 0.1);
												LsFurnitureMod.queueServerWork(2, () -> {
													if (world instanceof ServerLevel _level)
														_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.2), (y + 0.8), (z + 0.3), 2, 0.01, 0.1, 0.01, 0.1);
													LsFurnitureMod.queueServerWork(2, () -> {
														if (world instanceof ServerLevel _level)
															_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.2), (y + 0.8), (z + 0.3), 2, 0.01, 0.1, 0.01, 0.1);
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			} else if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)) == Direction.EAST) {
				LsFurnitureMod.queueServerWork(2, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.3), (y + 0.8), (z + 0.8), 2, 0.01, 0.1, 0.01, 0.1);
					LsFurnitureMod.queueServerWork(2, () -> {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.3), (y + 0.8), (z + 0.8), 2, 0.01, 0.1, 0.01, 0.1);
						LsFurnitureMod.queueServerWork(2, () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.3), (y + 0.8), (z + 0.8), 2, 0.01, 0.1, 0.01, 0.1);
							LsFurnitureMod.queueServerWork(2, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.3), (y + 0.8), (z + 0.8), 2, 0.01, 0.1, 0.01, 0.1);
								LsFurnitureMod.queueServerWork(2, () -> {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.3), (y + 0.8), (z + 0.8), 2, 0.01, 0.1, 0.01, 0.1);
									LsFurnitureMod.queueServerWork(2, () -> {
										if (world instanceof ServerLevel _level)
											_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.3), (y + 0.8), (z + 0.8), 2, 0.01, 0.1, 0.01, 0.1);
										LsFurnitureMod.queueServerWork(2, () -> {
											if (world instanceof ServerLevel _level)
												_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.3), (y + 0.8), (z + 0.8), 2, 0.01, 0.1, 0.01, 0.1);
											LsFurnitureMod.queueServerWork(2, () -> {
												if (world instanceof ServerLevel _level)
													_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.3), (y + 0.8), (z + 0.8), 2, 0.01, 0.1, 0.01, 0.1);
												LsFurnitureMod.queueServerWork(2, () -> {
													if (world instanceof ServerLevel _level)
														_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.3), (y + 0.8), (z + 0.8), 2, 0.01, 0.1, 0.01, 0.1);
													LsFurnitureMod.queueServerWork(2, () -> {
														if (world instanceof ServerLevel _level)
															_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.3), (y + 0.8), (z + 0.8), 2, 0.01, 0.1, 0.01, 0.1);
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			} else if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)) == Direction.WEST) {
				LsFurnitureMod.queueServerWork(2, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.7), (y + 0.8), (z + 0.2), 2, 0.01, 0.1, 0.01, 0.1);
					LsFurnitureMod.queueServerWork(2, () -> {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.7), (y + 0.8), (z + 0.2), 2, 0.01, 0.1, 0.01, 0.1);
						LsFurnitureMod.queueServerWork(2, () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.7), (y + 0.8), (z + 0.2), 2, 0.01, 0.1, 0.01, 0.1);
							LsFurnitureMod.queueServerWork(2, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.7), (y + 0.8), (z + 0.2), 2, 0.01, 0.1, 0.01, 0.1);
								LsFurnitureMod.queueServerWork(2, () -> {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.7), (y + 0.8), (z + 0.2), 2, 0.01, 0.1, 0.01, 0.1);
									LsFurnitureMod.queueServerWork(2, () -> {
										if (world instanceof ServerLevel _level)
											_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.7), (y + 0.8), (z + 0.2), 2, 0.01, 0.1, 0.01, 0.1);
										LsFurnitureMod.queueServerWork(2, () -> {
											if (world instanceof ServerLevel _level)
												_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.7), (y + 0.8), (z + 0.2), 2, 0.01, 0.1, 0.01, 0.1);
											LsFurnitureMod.queueServerWork(2, () -> {
												if (world instanceof ServerLevel _level)
													_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.7), (y + 0.8), (z + 0.2), 2, 0.01, 0.1, 0.01, 0.1);
												LsFurnitureMod.queueServerWork(2, () -> {
													if (world instanceof ServerLevel _level)
														_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.7), (y + 0.8), (z + 0.2), 2, 0.01, 0.1, 0.01, 0.1);
													LsFurnitureMod.queueServerWork(2, () -> {
														if (world instanceof ServerLevel _level)
															_level.sendParticles((SimpleParticleType) (LsFurnitureModParticleTypes.KETTLE_PARTICLE.get()), (x + 0.7), (y + 0.8), (z + 0.2), 2, 0.01, 0.1, 0.01, 0.1);
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			}
			LsFurnitureMod.queueServerWork(40, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_button.click_off")), SoundSource.BLOCKS, (float) 0.4, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_button.click_off")), SoundSource.BLOCKS, (float) 0.4, 1, false);
					}
				}
			});
		});
	}
}
