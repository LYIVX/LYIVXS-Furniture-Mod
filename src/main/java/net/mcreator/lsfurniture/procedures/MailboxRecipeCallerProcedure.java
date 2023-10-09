package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class MailboxRecipeCallerProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OakMailBoxRecipeProcedure.execute(entity);
		DarkOakMailBoxRecipeProcedure.execute(entity);
		SpruceMailBoxRecipeProcedure.execute(entity);
		AcaciaMailBoxRecipeProcedure.execute(entity);
		BirchMailBoxRecipeProcedure.execute(entity);
		JungleMailBoxRecipeProcedure.execute(entity);
		MangroveMailBoxRecipeProcedure.execute(entity);
		CrimsonMailBoxRecipeProcedure.execute(entity);
		WarpedMailBoxRecipeProcedure.execute(entity);
	}
}
