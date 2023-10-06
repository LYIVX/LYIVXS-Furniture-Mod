package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class JungleCupboardMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		JungleCupboardProProcedure.execute(world, x, y, z);
		JungleCupboardCornerProProcedure.execute(world, x, y, z);
	}
}
