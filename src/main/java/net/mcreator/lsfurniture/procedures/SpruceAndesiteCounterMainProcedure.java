package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;

public class SpruceAndesiteCounterMainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		SpruceAndesiteCounterProProcedure.execute(world, x, y, z);
		SpruceAndesiteCounterCornerProProcedure.execute(world, x, y, z);
	}
}
