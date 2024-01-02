package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

import java.util.HashMap;

public class LogRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		OakLogsRecipeProcedure.execute(entity, guistate);
		DarkOakLogsRecipeProcedure.execute(entity, guistate);
		SpruceLogsRecipeProcedure.execute(entity, guistate);
		AcaciaLogsRecipeProcedure.execute(entity, guistate);
		BirchLogsRecipeProcedure.execute(entity, guistate);
		JungleLogsRecipeProcedure.execute(entity, guistate);
		MangroveLogsRecipeProcedure.execute(entity, guistate);
		CrimsonStemsRecipeProcedure.execute(entity, guistate);
		WarpedStemsRecipeProcedure.execute(entity, guistate);
	}
}
