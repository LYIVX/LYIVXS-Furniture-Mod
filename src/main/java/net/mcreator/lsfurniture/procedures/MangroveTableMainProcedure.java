package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class MangroveTableMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		MangroveTableStraightProProcedure.execute(world, x, y, z);
		MangroveTableCornerProProcedure.execute(world, x, y, z);
		MangroveTableJunctionProProcedure.execute(world, x, y, z);
		MangroveTableCrossProProcedure.execute(world, x, y, z);
		MangroveTableEndProProcedure.execute(world, x, y, z);
		MangroveTableNoneProProcedure.execute(world, x, y, z);
	}
}
