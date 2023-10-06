
package net.mcreator.lsfurniture.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AnyIngotItem extends Item {
	public AnyIngotItem() {
		super(new Item.Properties().tab(null).stacksTo(64).rarity(Rarity.COMMON));
	}
}
