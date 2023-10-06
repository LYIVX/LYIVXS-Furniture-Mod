package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class OakBlindsClosedMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		OakBlindsClosedEndProProcedure.execute(world, x, y, z);
		OakBlindsClosedNoneProProcedure.execute(world, x, y, z);
	}
}
