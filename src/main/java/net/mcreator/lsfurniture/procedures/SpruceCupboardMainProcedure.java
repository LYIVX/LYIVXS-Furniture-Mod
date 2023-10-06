package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class SpruceCupboardMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		SpruceCupboardProProcedure.execute(world, x, y, z);
		SpruceCupboardCornerProProcedure.execute(world, x, y, z);
	}
}
