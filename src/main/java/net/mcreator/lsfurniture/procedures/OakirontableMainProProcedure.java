package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class OakirontableMainProProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		OakirontableNoneProProcedure.execute(world, x, y, z);
		OakirontableEndProProcedure.execute(world, x, y, z);
		OakirontableStraightProProcedure.execute(world, x, y, z);
		OakirontableCornerProProcedure.execute(world, x, y, z);
		OakirontableJunctionProProcedure.execute(world, x, y, z);
		OakirontableCrossProProcedure.execute(world, x, y, z);
	}
}
