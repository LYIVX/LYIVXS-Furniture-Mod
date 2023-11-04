package net.mcreator.lsfurniture.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.lsfurniture.network.LsFurnitureModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WorldStartProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "Carpentry";
			entity.getCapability(LsFurnitureModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Furniture_Crafter_Menu = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (ModList.get().isLoaded("patchouli") && LsFurnitureModVariables.MapVariables.get(world).patchouli_given == false) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"give @p patchouli:guide_book{\"patchouli:book\":\"ls_furniture:guide_book\"}");
			LsFurnitureModVariables.MapVariables.get(world).patchouli_given = true;
			LsFurnitureModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
