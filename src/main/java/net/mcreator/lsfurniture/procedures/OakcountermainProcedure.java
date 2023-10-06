package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class OakcountermainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		OakcounterproProcedure.execute(world, x, y, z);
		OakcountercornerproProcedure.execute(world, x, y, z);
	}
}
