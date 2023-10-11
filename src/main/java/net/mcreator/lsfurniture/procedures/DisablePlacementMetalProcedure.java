package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class DisablePlacementMetalProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(new ResourceLocation("forge:ingots"))) || itemstack.is(ItemTags.create(new ResourceLocation("forge:dusts"))) || itemstack.is(ItemTags.create(new ResourceLocation("ls_furniture:bark")))) {
			return false;
		}
		return true;
	}
}
