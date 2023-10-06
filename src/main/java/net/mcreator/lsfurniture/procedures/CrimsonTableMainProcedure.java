package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class CrimsonTableMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		CrimsonTableStraightProProcedure.execute(world, x, y, z);
		CrimsonTableCornerProProcedure.execute(world, x, y, z);
		CrimsonTableJunctionProProcedure.execute(world, x, y, z);
		CrimsonTableCrossProProcedure.execute(world, x, y, z);
		CrimsonTableEndProProcedure.execute(world, x, y, z);
		CrimsonTableNoneProProcedure.execute(world, x, y, z);
	}
}
