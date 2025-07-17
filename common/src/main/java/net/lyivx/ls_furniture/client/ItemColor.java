package net.lyivx.ls_furniture.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.item.ItemStack;

@Environment(EnvType.CLIENT)
public interface ItemColor {
    int getColor(ItemStack itemStack, int i);
}
