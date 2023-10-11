package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class DisablePlacementProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(new ResourceLocation("forge:tool")))) {
			return true;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("forge:ingots")))) {
			return true;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("forge:dyes")))) {
			return true;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("ls_furniture:bark")))) {
			return true;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("forge:dusts")))) {
			return true;
		}
		return false;
	}
}
