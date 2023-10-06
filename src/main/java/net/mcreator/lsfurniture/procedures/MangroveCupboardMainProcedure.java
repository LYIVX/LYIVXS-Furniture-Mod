package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class MangroveCupboardMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		MangroveCupboardProProcedure.execute(world, x, y, z);
		MangroveCupboardCornerProProcedure.execute(world, x, y, z);
	}
}
