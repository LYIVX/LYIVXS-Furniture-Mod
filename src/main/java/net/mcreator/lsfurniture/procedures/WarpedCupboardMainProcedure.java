package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class WarpedCupboardMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		WarpedCupboardProProcedure.execute(world, x, y, z);
		WarpedCupboardCornerProProcedure.execute(world, x, y, z);
	}
}
