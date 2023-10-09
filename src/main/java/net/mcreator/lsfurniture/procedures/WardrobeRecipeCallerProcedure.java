package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class WardrobeRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakWardrobeRecipeProcedure.execute(entity);
		DarkOakWardrobeRecipeProcedure.execute(entity);
		SpruceWardrobeRecipeProcedure.execute(entity);
		AcaciaWardrobeRecipeProcedure.execute(entity);
		BirchWardrobeRecipeProcedure.execute(entity);
		JungleWardrobeRecipeProcedure.execute(entity);
		MangroveWardrobeRecipeProcedure.execute(entity);
		CrimsonWardrobeRecipeProcedure.execute(entity);
		WarpedWardrobeRecipeProcedure.execute(entity);
	}
}
