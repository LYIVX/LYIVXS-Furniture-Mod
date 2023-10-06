package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class BirchWhiteMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BirchWhiteProProcedure.execute(world, x, y, z);
		BirchWhiteStraightProProcedure.execute(world, x, y, z);
		BirchWhiteCornerProProcedure.execute(world, x, y, z);
		BirchWhiteEndProProcedure.execute(world, x, y, z);
	}
}
