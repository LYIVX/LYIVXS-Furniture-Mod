package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class OakBlindsMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		OakBlindsEndProProcedure.execute(world, x, y, z);
		OakBlindsNoneProProcedure.execute(world, x, y, z);
	}
}
