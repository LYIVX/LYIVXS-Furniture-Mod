package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class LogRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakLogsRecipeProcedure.execute(entity);
		DarkOakLogsRecipeProcedure.execute(entity);
		SpruceLogsRecipeProcedure.execute(entity);
		AcaciaLogsRecipeProcedure.execute(entity);
		BirchLogsRecipeProcedure.execute(entity);
		JungleLogsRecipeProcedure.execute(entity);
		MangroveLogsRecipeProcedure.execute(entity);
	}
}
