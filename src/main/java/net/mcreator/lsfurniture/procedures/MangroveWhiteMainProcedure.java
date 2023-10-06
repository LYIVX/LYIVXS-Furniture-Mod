package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class MangroveWhiteMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		MangroveWhiteProProcedure.execute(world, x, y, z);
		MangroveWhiteStraightProProcedure.execute(world, x, y, z);
		MangroveWhiteCornerProProcedure.execute(world, x, y, z);
		MangroveWhiteEndProProcedure.execute(world, x, y, z);
	}
}
