package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class WarpedWhiteMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		WarpedWhiteProProcedure.execute(world, x, y, z);
		WarpedWhiteStraightProProcedure.execute(world, x, y, z);
		WarpedWhiteCornerProProcedure.execute(world, x, y, z);
		WarpedWhiteEndProProcedure.execute(world, x, y, z);
	}
}
