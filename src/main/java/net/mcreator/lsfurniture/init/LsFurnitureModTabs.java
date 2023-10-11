
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lsfurniture.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class LsFurnitureModTabs {
	public static CreativeModeTab TAB_TAB;
	public static CreativeModeTab TAB_TAB_2;

	public static void load() {
		TAB_TAB = new CreativeModeTab("tabtab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(LsFurnitureModBlocks.FURNITURE_CRAFTER_BETA.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_TAB_2 = new CreativeModeTab("tabtab_2") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(LsFurnitureModBlocks.FURNITURE_CRAFTER_BETA.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
