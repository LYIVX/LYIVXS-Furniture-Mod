package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class DarkOakCupboardMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		DarkOakCupboardProProcedure.execute(world, x, y, z);
		DarkOakCupboardCornerProProcedure.execute(world, x, y, z);
	}
}
