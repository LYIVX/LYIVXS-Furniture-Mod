package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class AacaciaDioriteCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		AacaciaDioriteCounterProProcedure.execute(world, x, y, z);
		AacaciaDioriteCounterCornerProProcedure.execute(world, x, y, z);
	}
}
