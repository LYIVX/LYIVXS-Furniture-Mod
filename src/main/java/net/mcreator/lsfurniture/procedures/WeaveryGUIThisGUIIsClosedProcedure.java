package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.lsfurniture.network.LsFurnitureModVariables;

public class WeaveryGUIThisGUIIsClosedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "Weavery";
			entity.getCapability(LsFurnitureModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Furniture_Crafter_Menu = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
