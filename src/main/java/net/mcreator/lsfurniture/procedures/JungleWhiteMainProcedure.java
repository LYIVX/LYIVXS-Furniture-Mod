package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class JungleWhiteMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		JungleWhiteProProcedure.execute(world, x, y, z);
		JungleWhiteStraightProProcedure.execute(world, x, y, z);
		JungleWhiteCornerProProcedure.execute(world, x, y, z);
		JungleWhiteEndProProcedure.execute(world, x, y, z);
	}
}
