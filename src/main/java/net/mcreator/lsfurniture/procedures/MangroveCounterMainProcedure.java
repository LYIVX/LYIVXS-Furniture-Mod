package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class MangroveCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		MangroveCounterProProcedure.execute(world, x, y, z);
		MangroveCounterCornerProProcedure.execute(world, x, y, z);
	}
}
