package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class DarkOakTableMainProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		DarkOakTableNoneProcedureProcedure.execute(world, x, y, z);
		DarkOakTableEndProcedureProcedure.execute(world, x, y, z);
		DarkOakTableStraightProcedureProcedure.execute(world, x, y, z);
		DarkOakTableCornerProcedureProcedure.execute(world, x, y, z);
		DarkOakTableJunctionProcedureProcedure.execute(world, x, y, z);
		DarkOakTableCrossProcedureProcedure.execute(world, x, y, z);
	}
}
