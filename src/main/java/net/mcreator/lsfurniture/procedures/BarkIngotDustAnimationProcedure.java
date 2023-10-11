package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

public class BarkIngotDustAnimationProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("bark_slot") > 1) {
			entity.getPersistentData().putDouble("bark_slot", (entity.getPersistentData().getDouble("bark_slot") - 1));
		} else {
			entity.getPersistentData().putDouble("bark_slot", 61);
		}
	}
}
