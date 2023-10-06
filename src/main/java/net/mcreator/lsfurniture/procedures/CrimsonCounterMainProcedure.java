package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class CrimsonCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		CrimsonCounterProProcedure.execute(world, x, y, z);
		CrimsonCounterCornerProProcedure.execute(world, x, y, z);
	}
}
