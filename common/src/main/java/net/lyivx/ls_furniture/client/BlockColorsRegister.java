package net.lyivx.ls_furniture.client;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.world.level.block.Block;

@FunctionalInterface
public interface BlockColorsRegister
{
    void apply(BlockColor color, Block... blocks);
}