package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class ChairRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakChairRecipeProcedure.execute(entity);
		DarkoakChairRecipeProcedure.execute(entity);
		SpruceChairRecipeProcedure.execute(entity);
		AcaciaChairRecipeProcedure.execute(entity);
		BirchChairRecipeProcedure.execute(entity);
		JungleChairRecipeProcedure.execute(entity);
		MangroveChairRecipeProcedure.execute(entity);
		CrimsonChairRecipeProcedure.execute(entity);
		WarpedChairRecipeProcedure.execute(entity);
		OakWhiteChairRecipeProcedure.execute(entity);
		DarOakWhiteChairRecipeProcedure.execute(entity);
		SpruceWhiteChairRecipeProcedure.execute(entity);
		AcaciaWhiteChairRecipeProcedure.execute(entity);
		BirchWhiteChairRecipeProcedure.execute(entity);
		JungleWhiteChairRecipeProcedure.execute(entity);
		MangroveWhiteChairRecipeProcedure.execute(entity);
		CrimsonWhiteChairRecipeProcedure.execute(entity);
		WarpedWhiteChairRecipeProcedure.execute(entity);
	}
}
