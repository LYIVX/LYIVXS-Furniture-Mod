package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class SofaRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakWhiteSofaRecipeProcedure.execute(entity);
		DarkOakWhiteSofaRecipeProcedure.execute(entity);
		SpruceWhiteSofaRecipeProcedure.execute(entity);
		AcaciaWhiteSofaRecipeProcedure.execute(entity);
		BirchWhiteSofaRecipeProcedure.execute(entity);
		JungleWhiteSofaRecipeProcedure.execute(entity);
		MangroveWhiteSofaRecipeProcedure.execute(entity);
		CrimsonWhiteSofaRecipeProcedure.execute(entity);
		WarpedWhiteSofaRecipeProcedure.execute(entity);
	}
}
