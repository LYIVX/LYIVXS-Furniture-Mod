package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class AcaciaCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		AcaciaCounterProProcedure.execute(world, x, y, z);
		AcaciaCounterCornerProProcedure.execute(world, x, y, z);
	}
}
