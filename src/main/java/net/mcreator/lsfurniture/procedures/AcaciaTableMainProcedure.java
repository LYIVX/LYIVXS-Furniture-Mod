package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class AcaciaTableMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		AcaciaTableStraightProProcedure.execute(world, x, y, z);
		AcaciaTableCornerProProcedure.execute(world, x, y, z);
		AcaciaTableJunctionProProcedure.execute(world, x, y, z);
		AcaciaTableCrossProProcedure.execute(world, x, y, z);
		AcaciaTableEndProProcedure.execute(world, x, y, z);
		AcaciaTableNoneProProcedure.execute(world, x, y, z);
	}
}
