package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class PathRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		StonePathRecipeProcedure.execute(entity);
		CobblestonePathRecipeProcedure.execute(entity);
		BlackstonePathRecipeProcedure.execute(entity);
		DeepslatePathRecipeProcedure.execute(entity);
		AndesitePathRecipeProcedure.execute(entity);
		DioritePathRecipeProcedure.execute(entity);
		GranitPathRecipeProcedure.execute(entity);
		OakPathRecipeProcedure.execute(entity);
		DarkOakPathRecipeProcedure.execute(entity);
		SprucePathRecipeProcedure.execute(entity);
		AcaciaPathRecipeProcedure.execute(entity);
		BirchPathRecipeProcedure.execute(entity);
		JunglePathRecipeProcedure.execute(entity);
		MangrovePathRecipeProcedure.execute(entity);
		CrimsonPathRecipeProcedure.execute(entity);
		WarpedPathRecipeProcedure.execute(entity);
	}
}
