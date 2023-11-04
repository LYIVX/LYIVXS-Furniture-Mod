package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class OakBricksCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		OakBricksCounterProProcedure.execute(world, x, y, z);
		OakBricksCounterCornerProProcedure.execute(world, x, y, z);
	}
}
