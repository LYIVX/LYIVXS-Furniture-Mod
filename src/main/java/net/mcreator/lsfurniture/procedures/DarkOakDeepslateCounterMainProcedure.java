package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class DarkOakDeepslateCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		DarkOakDeepslateCounterProProcedure.execute(world, x, y, z);
		DarkOakDeepslateCounterCornerProProcedure.execute(world, x, y, z);
	}
}
