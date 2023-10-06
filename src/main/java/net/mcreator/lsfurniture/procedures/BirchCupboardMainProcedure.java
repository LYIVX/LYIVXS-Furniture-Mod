package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class BirchCupboardMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BirchCupboardProProcedure.execute(world, x, y, z);
		BirchCupboardCornerProProcedure.execute(world, x, y, z);
	}
}
