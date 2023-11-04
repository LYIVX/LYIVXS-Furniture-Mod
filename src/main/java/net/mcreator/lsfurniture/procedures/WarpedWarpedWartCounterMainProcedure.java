package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class WarpedWarpedWartCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		WarpedWarpedWartCounterProProcedure.execute(world, x, y, z);
		WarpedWarpedWartCounterCornerProProcedure.execute(world, x, y, z);
	}
}
