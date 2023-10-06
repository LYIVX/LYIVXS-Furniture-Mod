package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class JungleCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		JungleCounterProProcedure.execute(world, x, y, z);
		JungleCounterCornerProProcedure.execute(world, x, y, z);
	}
}
