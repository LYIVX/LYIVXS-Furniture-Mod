package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class SofaMainProProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		SofaNoneProProcedure.execute(world, x, y, z);
		SofaEndProcedure.execute(world, x, y, z);
		SofaStraightProcedure.execute(world, x, y, z);
		SofaCornerProcedure.execute(world, x, y, z);
	}
}
