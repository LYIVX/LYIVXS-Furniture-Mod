package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class DarkOakBlindsMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		DarkOakBlindsEndProProcedure.execute(world, x, y, z);
		DarkOakBlindsNoneProProcedure.execute(world, x, y, z);
	}
}
