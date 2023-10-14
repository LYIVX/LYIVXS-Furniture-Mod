package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class LeavesRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakLeavesRecipeProcedure.execute(entity);
		DarkOakLeavesRecipeProcedure.execute(entity);
		SpruceLeavesRecipeProcedure.execute(entity);
		AcaciaLeavesRecipeProcedure.execute(entity);
		BirchLeavesRecipeProcedure.execute(entity);
		JungleLeavesRecipeProcedure.execute(entity);
		MangroveLeavesRecipeProcedure.execute(entity);
	}
}
