package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class CupboardVentRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakCupboardVentRecipeProcedure.execute(entity);
		DarkOakCupboardVentRecipeProcedure.execute(entity);
		SpruceCupboardVentRecipeProcedure.execute(entity);
		AcaciaCupboardVentRecipeProcedure.execute(entity);
		BirchCupboardVentRecipeProcedure.execute(entity);
		JungleCupboardVentRecipeProcedure.execute(entity);
		MangroveCupboardVentRecipeProcedure.execute(entity);
		CrimsonCupboardVentRecipeProcedure.execute(entity);
		WarpedCupboardVentRecipeProcedure.execute(entity);
	}
}
