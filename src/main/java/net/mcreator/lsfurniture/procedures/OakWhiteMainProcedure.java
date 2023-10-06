package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class OakWhiteMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		OakWhiteProProcedure.execute(world, x, y, z);
		OakWhiteEndProProcedure.execute(world, x, y, z);
		OakWhiteStraightProProcedure.execute(world, x, y, z);
		OakWhiteCornerProProcedure.execute(world, x, y, z);
	}
}
