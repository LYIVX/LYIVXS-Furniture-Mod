package net.lyivx.ls_furniture.common.utils.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

public class BlockPart {

    // Gives part of the block that was interacted with, starts from 0
    public static int get1D(BlockPos blockPos, Vec3 clickedPos, Direction axisDir, int parts) {
        Direction.Axis axis = axisDir.getAxis();
        double posNormal = clickedPos.get(axis) - (double) blockPos.get(axis);
        if (axisDir == Direction.SOUTH || axisDir == Direction.EAST || (axisDir == Direction.UP && posNormal != 0.5)) posNormal = 1d - posNormal;
        double partSize = 1d / parts;
        int part = (int)Math.min(posNormal / partSize, parts - 1);
        return part;
    }

    public static int get2D(BlockPos blockPos, Vec3 clickedPos, Direction axisDir, Direction axisDir2, int partsX, int partsY) {
        int slotX = BlockPart.get1D(blockPos, clickedPos, axisDir, partsX);
        int slotY = BlockPart.get1D(blockPos, clickedPos, axisDir2, partsY);

        //width * y + x
        int part = partsX * slotY + slotX;
        return part;
    }
}