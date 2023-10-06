package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class BirchCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BirchCounterProProcedure.execute(world, x, y, z);
		BirchCounterCornerProProcedure.execute(world, x, y, z);
	}
}
