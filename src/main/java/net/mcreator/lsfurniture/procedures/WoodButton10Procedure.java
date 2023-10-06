package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.lsfurniture.init.LsFurnitureModItems;
import net.mcreator.lsfurniture.init.LsFurnitureModBlocks;

import java.util.function.Supplier;
import java.util.Map;

public class WoodButton10Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.OAK_CUPBOARD.get());
			_setstack.setCount(1);
			((Slot) _slots.get(5)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.OVEN_VENT.get());
			_setstack.setCount(1);
			((Slot) _slots.get(6)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(Blocks.AIR);
			_setstack.setCount(1);
			((Slot) _slots.get(7)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(Blocks.AIR);
			_setstack.setCount(1);
			((Slot) _slots.get(8)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(LsFurnitureModItems.SAW.get());
			_setstack.setCount(1);
			((Slot) _slots.get(9)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.OAK_CUPBOARD_VENT.get());
			_setstack.setCount(1);
			((Slot) _slots.get(47)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		OakCupboardVentRecipeProcedure.execute(world, x, y, z, entity);
		DarkOakCupboardVentRecipeProcedure.execute(world, x, y, z, entity);
		SpruceCupboardVentRecipeProcedure.execute(world, x, y, z, entity);
		AcaciaCupboardVentRecipeProcedure.execute(world, x, y, z, entity);
		BirchCupboardVentRecipeProcedure.execute(world, x, y, z, entity);
		JungleCupboardVentRecipeProcedure.execute(world, x, y, z, entity);
		MangroveCupboardVentRecipeProcedure.execute(world, x, y, z, entity);
		CrimsonCupboardVentRecipeProcedure.execute(world, x, y, z, entity);
		WarpedCupboardVentRecipeProcedure.execute(world, x, y, z, entity);
	}
}
