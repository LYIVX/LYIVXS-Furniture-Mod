package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.lsfurniture.init.LsFurnitureModItems;
import net.mcreator.lsfurniture.init.LsFurnitureModBlocks;

import java.util.function.Supplier;
import java.util.Map;

public class DeepslatePathRecipeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double Slot0Number = 0;
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(0) >= 1
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Blocks.POLISHED_DEEPSLATE.asItem()
				&& new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(4) >= 1
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == LsFurnitureModItems.CHISEL.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_1.get());
				_setstack.setCount(4);
				((Slot) _slots.get(5)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_2.get());
				_setstack.setCount(4);
				((Slot) _slots.get(6)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_3.get());
				_setstack.setCount(4);
				((Slot) _slots.get(7)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_4.get());
				_setstack.setCount(4);
				((Slot) _slots.get(8)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_5.get());
				_setstack.setCount(4);
				((Slot) _slots.get(9)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_6.get());
				_setstack.setCount(4);
				((Slot) _slots.get(10)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_71.get());
				_setstack.setCount(4);
				((Slot) _slots.get(11)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_72.get());
				_setstack.setCount(4);
				((Slot) _slots.get(12)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_73.get());
				_setstack.setCount(4);
				((Slot) _slots.get(13)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_74.get());
				_setstack.setCount(4);
				((Slot) _slots.get(14)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_75.get());
				_setstack.setCount(4);
				((Slot) _slots.get(15)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_8.get());
				_setstack.setCount(4);
				((Slot) _slots.get(16)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_91.get());
				_setstack.setCount(4);
				((Slot) _slots.get(17)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_92.get());
				_setstack.setCount(4);
				((Slot) _slots.get(18)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_10.get());
				_setstack.setCount(4);
				((Slot) _slots.get(19)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_11.get());
				_setstack.setCount(4);
				((Slot) _slots.get(20)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_12.get());
				_setstack.setCount(4);
				((Slot) _slots.get(21)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_131.get());
				_setstack.setCount(4);
				((Slot) _slots.get(22)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_132.get());
				_setstack.setCount(4);
				((Slot) _slots.get(23)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.BLACKSTONE_PATH_133.get());
				_setstack.setCount(4);
				((Slot) _slots.get(24)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}
