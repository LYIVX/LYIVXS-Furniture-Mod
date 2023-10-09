package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class StoolRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakStoolRecipeProcedure.execute(entity);
		DarkOakStoolRecipeProcedure.execute(entity);
		SpruceStoolRecipeProcedure.execute(entity);
		AcaciaStoolRecipeProcedure.execute(entity);
		BirchStoolRecipeProcedure.execute(entity);
		JungleStoolRecipeProcedure.execute(entity);
		MangroveStoolRecipeProcedure.execute(entity);
		CrimsonStoolRecipeProcedure.execute(entity);
		WarpedStoolRecipeProcedure.execute(entity);
	}
}
