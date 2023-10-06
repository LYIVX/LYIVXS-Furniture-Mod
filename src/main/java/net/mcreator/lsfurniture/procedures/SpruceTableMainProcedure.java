package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class SpruceTableMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		SpruceTableStraightProProcedure.execute(world, x, y, z);
		SpruceTableCornerProProcedure.execute(world, x, y, z);
		SpruceTableJunctionProProcedure.execute(world, x, y, z);
		SpruceTableCrossProProcedure.execute(world, x, y, z);
		SpruceTableEndProProcedure.execute(world, x, y, z);
		SpruceTableNoneProProcedure.execute(world, x, y, z);
	}
}
