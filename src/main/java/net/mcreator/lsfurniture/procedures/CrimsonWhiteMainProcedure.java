package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class CrimsonWhiteMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		CrimsonWhiteProProcedure.execute(world, x, y, z);
		CrimsonWhiteStraightProProcedure.execute(world, x, y, z);
		CrimsonWhiteCronerProProcedure.execute(world, x, y, z);
		CrimsonWhiteEndProProcedure.execute(world, x, y, z);
	}
}
