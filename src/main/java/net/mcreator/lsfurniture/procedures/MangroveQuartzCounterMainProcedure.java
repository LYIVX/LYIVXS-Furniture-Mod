package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class MangroveQuartzCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		MangroveQuartzCounterProProcedure.execute(world, x, y, z);
		MangroveQuartzCounterCornerProProcedure.execute(world, x, y, z);
	}
}
