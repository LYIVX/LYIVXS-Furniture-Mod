package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class DrawerRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakDrawerRecipeProcedure.execute(entity);
		DarkOakDrawerRecipeProcedure.execute(entity);
		SpruceDrawerRecipeProcedure.execute(entity);
		AcaciaDrawerRecipeProcedure.execute(entity);
		BirchDrawerRecipeProcedure.execute(entity);
		JungleDrawerRecipeProcedure.execute(entity);
		MangroveDrawerRecipeProcedure.execute(entity);
		CrimsonDrawerRecipeProcedure.execute(entity);
		WarpedDrawerRecipeProcedure.execute(entity);
	}
}
