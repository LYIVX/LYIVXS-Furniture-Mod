package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class SpruceWhiteMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		SpruceWhiteProProcedure.execute(world, x, y, z);
		SpruceWhiteEndProProcedure.execute(world, x, y, z);
		SpruceWhiteStraightProProcedure.execute(world, x, y, z);
		SpruceWhiteCornerProProcedure.execute(world, x, y, z);
	}
}
