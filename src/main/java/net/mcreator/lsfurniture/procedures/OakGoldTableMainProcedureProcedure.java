package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class OakGoldTableMainProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		OakGoldTableNoneProcedureProcedure.execute(world, x, y, z);
		OakGoldTableEndProcedureProcedure.execute(world, x, y, z);
		OakGoldTableStraightProcedureProcedure.execute(world, x, y, z);
		OakGoldTableCornerProcedureProcedure.execute(world, x, y, z);
		OakGoldTableJunctionProcedureProcedure.execute(world, x, y, z);
		OakGoldTableCrossProcedureProcedure.execute(world, x, y, z);
	}
}
