package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class JungleTableMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		JungleTableStraightProProcedure.execute(world, x, y, z);
		JungleTableCornerProProcedure.execute(world, x, y, z);
		JungleTableJunctionProProcedure.execute(world, x, y, z);
		JungleTableCrossProProcedure.execute(world, x, y, z);
		JungleTableEndProProcedure.execute(world, x, y, z);
		JungleTableNoneProProcedure.execute(world, x, y, z);
	}
}
