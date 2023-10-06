
package net.mcreator.lsfurniture.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AnyDyeItem extends Item {
	public AnyDyeItem() {
		super(new Item.Properties().tab(null).stacksTo(64).rarity(Rarity.COMMON));
	}
}
