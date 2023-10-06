package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class AcaciaWhiteMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		AcaciaWhiteProProcedure.execute(world, x, y, z);
		AcaciaWhiteStraightProProcedure.execute(world, x, y, z);
		AcaciaWhiteCornerProProcedure.execute(world, x, y, z);
		AcaciaWhiteEndProProcedure.execute(world, x, y, z);
	}
}
