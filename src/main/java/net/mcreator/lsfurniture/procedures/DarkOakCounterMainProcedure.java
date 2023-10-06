package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class DarkOakCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		DarkOakCounterProProcedure.execute(world, x, y, z);
		DarkOakCounterCornerProProcedure.execute(world, x, y, z);
	}
}
