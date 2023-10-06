package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class BirchTableMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BirchTableStraightProProcedure.execute(world, x, y, z);
		BirchTableCornerProProcedure.execute(world, x, y, z);
		BirchTableJunctionProProcedure.execute(world, x, y, z);
		BirchTableCrossProProcedure.execute(world, x, y, z);
		BirchTableEndProProcedure.execute(world, x, y, z);
		BirchTableNoneProProcedure.execute(world, x, y, z);
	}
}
