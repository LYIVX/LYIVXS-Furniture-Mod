package net.mcreator.lsfurniture.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.lsfurniture.init.LsFurnitureModBlocks;

public class SetDeepslatePathsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String tag = "";
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_1.get());
			final int _sltid = 2;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_2.get());
			final int _sltid = 3;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_3.get());
			final int _sltid = 4;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_4.get());
			final int _sltid = 5;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_5.get());
			final int _sltid = 6;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_6.get());
			final int _sltid = 7;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_71.get());
			final int _sltid = 8;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_72.get());
			final int _sltid = 9;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_73.get());
			final int _sltid = 10;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_74.get());
			final int _sltid = 11;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_75.get());
			final int _sltid = 12;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_8.get());
			final int _sltid = 13;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_91.get());
			final int _sltid = 14;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_92.get());
			final int _sltid = 15;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_10.get());
			final int _sltid = 16;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_11.get());
			final int _sltid = 17;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_12.get());
			final int _sltid = 18;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_131.get());
			final int _sltid = 19;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_132.get());
			final int _sltid = 20;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(LsFurnitureModBlocks.DEEPSLATE_PATH_133.get());
			final int _sltid = 21;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
	}
}
