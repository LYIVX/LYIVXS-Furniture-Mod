package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class IronTableMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		IronTableNoneProProcedure.execute(world, x, y, z);
		IronTableEndProProcedure.execute(world, x, y, z);
		IronTableStraightProProcedure.execute(world, x, y, z);
		IronTableCornerProProcedure.execute(world, x, y, z);
		IronTableJunctionProProcedure.execute(world, x, y, z);
		IronTableCrossProProcedure.execute(world, x, y, z);
	}
}
