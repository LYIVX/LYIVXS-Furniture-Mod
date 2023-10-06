package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class WarpedCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		WarpedCounterProProcedure.execute(world, x, y, z);
		WarpedCounterCornerProProcedure.execute(world, x, y, z);
	}
}
