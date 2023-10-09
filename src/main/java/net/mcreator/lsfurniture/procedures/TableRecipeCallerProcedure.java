package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class TableRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakTableRecipeProcedure.execute(entity);
		DarkOakTableRecipeProcedure.execute(entity);
		SpruceTableRecipeProcedure.execute(entity);
		AcaciaTableRecipeProcedure.execute(entity);
		BirchTableRecipeProcedure.execute(entity);
		JungleTableRecipeProcedure.execute(entity);
		MangroveTableRecipeProcedure.execute(entity);
		CrimsonTableRecipeProcedure.execute(entity);
		WarpedTableRecipeProcedure.execute(entity);
	}
}
