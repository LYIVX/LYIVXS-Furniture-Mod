package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class ShelveRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakShelveRecipeProcedure.execute(entity);
		DarkOakShelveRecipeProcedure.execute(entity);
		SpruceShelveRecipeProcedure.execute(entity);
		AcaciaShelveRecipeProcedure.execute(entity);
		BirchShelveRecipeProcedure.execute(entity);
		JungleShelveRecipeProcedure.execute(entity);
		MangroveShelveRecipeProcedure.execute(entity);
		CrimsonShelveRecipeProcedure.execute(entity);
		WarpedShelveRecipeProcedure.execute(entity);
	}
}
