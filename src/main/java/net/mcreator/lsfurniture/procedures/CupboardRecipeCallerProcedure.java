package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class CupboardRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakCupboardRecipeProcedure.execute(entity);
		DarkOakCupboardRecipeProcedure.execute(entity);
		SpruceCupboardRecipeProcedure.execute(entity);
		AcaciaCupboardRecipeProcedure.execute(entity);
		BirchCupboardRecipeProcedure.execute(entity);
		JungleCupboardRecipeProcedure.execute(entity);
		MangroveCupboardRecipeProcedure.execute(entity);
		CrimsonCupboardRecipeProcedure.execute(entity);
		WarpedCupboardRecipeProcedure.execute(entity);
	}
}
