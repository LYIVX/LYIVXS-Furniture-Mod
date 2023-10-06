package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class WarpedTableMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		WarpedTableStraightProProcedure.execute(world, x, y, z);
		WarpedTableCornerProProcedure.execute(world, x, y, z);
		WarpedTableJunctionProProcedure.execute(world, x, y, z);
		WarpedTableCrossProProcedure.execute(world, x, y, z);
		WarpedTableEndProProcedure.execute(world, x, y, z);
		WarpedTableNoneProProcedure.execute(world, x, y, z);
	}
}
