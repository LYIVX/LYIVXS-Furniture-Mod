package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class DarkOakWhiteMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		DarkOakWhiteProProcedure.execute(world, x, y, z);
		DarkOakWhiteEndProProcedure.execute(world, x, y, z);
		DarkOakWhiteStraightProProcedure.execute(world, x, y, z);
		DarkOakWhiteCornerProProcedure.execute(world, x, y, z);
	}
}
