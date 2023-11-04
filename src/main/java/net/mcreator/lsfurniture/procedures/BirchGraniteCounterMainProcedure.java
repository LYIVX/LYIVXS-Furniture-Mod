package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class BirchGraniteCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BirchGraniteCounterProProcedure.execute(world, x, y, z);
		BirchGraniteCounterCornerProProcedure.execute(world, x, y, z);
	}
}
