package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class JungleNetherBricksCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		JungleNetherBricksCounterProProcedure.execute(world, x, y, z);
		JungleNetherBricksCounterCornerProProcedure.execute(world, x, y, z);
	}
}
