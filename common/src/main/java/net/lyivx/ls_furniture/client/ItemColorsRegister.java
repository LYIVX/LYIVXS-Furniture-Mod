package net.lyivx.ls_furniture.client;

import net.minecraft.world.level.ItemLike;

@FunctionalInterface
public interface ItemColorsRegister
{
    void apply(ItemColor color, ItemLike... items);
}