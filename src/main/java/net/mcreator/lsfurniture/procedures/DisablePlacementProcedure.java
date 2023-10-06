package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class DisablePlacementProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(new ResourceLocation("forge:tool")))) {
			return true;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("forge:metal")))) {
			return true;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("forge:dye")))) {
			return true;
		}
		return false;
	}
}
