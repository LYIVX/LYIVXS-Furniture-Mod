package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class CounterRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakCounterRecipeProcedure.execute(entity);
		DarkOakCounterRecipeProcedure.execute(entity);
		SpruceCounterRecipeProcedure.execute(entity);
		AcaciaCounterRecipeProcedure.execute(entity);
		BirchCounterRecipeProcedure.execute(entity);
		JungleCounterRecipeProcedure.execute(entity);
		MangroveCounterRecipeProcedure.execute(entity);
		CrimsonCounterRecipeProcedure.execute(entity);
		WarpedCounterRecipeProcedure.execute(entity);
	}
}
