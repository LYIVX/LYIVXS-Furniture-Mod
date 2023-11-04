package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class OvenRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakOvenRecipeProcedure.execute(entity);
		DarkOakOvenRecipeProcedure.execute(entity);
		SpruceOvenRecipeProcedure.execute(entity);
		AcaciaOvenRecipeProcedure.execute(entity);
		BirchOvenRecipeProcedure.execute(entity);
		JungleOvenRecipeProcedure.execute(entity);
		MangroveOvenRecipeProcedure.execute(entity);
		CrimsonOvenRecipeProcedure.execute(entity);
		WarpedOvenRecipeProcedure.execute(entity);
		BricksOvenRecipeProcedure.execute(entity);
		DeepslateOvenRecipeProcedure.execute(entity);
		AndesiteOvenRecipeProcedure.execute(entity);
		DioriteOvenRecipeProcedure.execute(entity);
		GraniteOvenRecipeProcedure.execute(entity);
		NetherBricksOvenRecipeProcedure.execute(entity);
		QuartzOvenRecipeProcedure.execute(entity);
		NetherWartOvenRecipeProcedure.execute(entity);
		WarpedWartOvenRecipeProcedure.execute(entity);
	}
}
