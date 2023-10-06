package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class CrimsonCupboardMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		CrimsonCupboardProProcedure.execute(world, x, y, z);
		CrimsonCupboardCornerProProcedure.execute(world, x, y, z);
	}
}
