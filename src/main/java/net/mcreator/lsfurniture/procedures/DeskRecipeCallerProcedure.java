package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class DeskRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakDeskRecipeProcedure.execute(entity);
		DarkOakDeskRecipeProcedure.execute(entity);
		SpruceDeskRecipeProcedure.execute(entity);
		AcaciaDeskRecipeProcedure.execute(entity);
		BirchDeskRecipeProcedure.execute(entity);
		JungleDeskRecipeProcedure.execute(entity);
		MangroveDeskRecipeProcedure.execute(entity);
		CrimsonDeskRecipeProcedure.execute(entity);
		WarpedDeskRecipeProcedure.execute(entity);
	}
}
