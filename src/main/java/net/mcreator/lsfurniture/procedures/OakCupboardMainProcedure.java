package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class OakCupboardMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		OakCupboardProProcedure.execute(world, x, y, z);
		OakCupboardCornerProProcedure.execute(world, x, y, z);
	}
}
