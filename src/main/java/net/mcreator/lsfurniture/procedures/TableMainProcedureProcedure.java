package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class TableMainProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		TableNoneProcedureProcedure.execute(world, x, y, z);
		TableEndProcedureProcedure.execute(world, x, y, z);
		TableStraightProcedureProcedure.execute(world, x, y, z);
		TableCornerProcedureProcedure.execute(world, x, y, z);
		TableJunctionProcedureProcedure.execute(world, x, y, z);
		TableCrossProcedureProcedure.execute(world, x, y, z);
	}
}
