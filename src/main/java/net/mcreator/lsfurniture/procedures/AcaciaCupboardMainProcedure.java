package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class AcaciaCupboardMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		AcaciaCupboardProProcedure.execute(world, x, y, z);
		AcaciaCupboardCornerProProcedure.execute(world, x, y, z);
	}
}
