package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class SpruceCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		SpruceCounterProProcedure.execute(world, x, y, z);
		SpruceCounterCornerProProcedure.execute(world, x, y, z);
	}
}
