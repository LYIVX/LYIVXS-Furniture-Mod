package net.lyivx.ls_furniture.client.util;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.architectury.fluid.FluidStack;
import net.lyivx.ls_furniture.common.blocks.entity.LiquidHolderBlockEntity;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.FastColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import org.joml.Matrix4f;

/**
 * Author: MrCrayfish (Modified for Architectury)
 */
public class SimpleFluidRenderer
{
    public static void drawContainer(Level level, BlockPos pos, LiquidHolderBlockEntity blockEntity, AABB box, PoseStack poseStack, MultiBufferSource source, int light)
    {
        Fluid fluid = blockEntity.getFluid();
        FluidStack fluidStack = FluidStack.create(fluid, blockEntity.getStoredAmount());

        if(!fluidStack.isEmpty())
        {
            TextureAtlasSprite[] sprites = FluidRenderUtil.getSprites(fluid);
            if (sprites == null || sprites.length < 1 || sprites[0] == null) {
                return;
            }
            TextureAtlasSprite still = sprites[0];

            int colour = FluidRenderUtil.getColor(fluidStack, level, pos);

            if (fluid.isSame(Fluids.WATER)) {
                 int biomeColor = BiomeColors.getAverageWaterColor(level, pos);
                 colour = biomeColor;
            }

            float red = FastColor.ARGB32.red(colour) / 255F;
            float green = FastColor.ARGB32.green(colour) / 255F;
            float blue = FastColor.ARGB32.blue(colour) / 255F;
            float alpha = 1.0f;

            float fullness = (float) blockEntity.getStoredAmount() / blockEntity.getCapacity();
            float minY = (float)box.minY;
            float maxY = (float)box.maxY;
            float fluidHeight = (maxY - minY) * fullness;
            float offset = minY + fluidHeight;
            offset = Math.min(offset, maxY);
            offset = Math.max(offset, minY);

            float uScale = still.getU1() - still.getU0();
            float vScale = still.getV1() - still.getV0();
            float u0 = still.getU0() + uScale * (float) (box.minX - Math.floor(box.minX));
            float u1 = still.getU0() + uScale * (float) (box.maxX - Math.floor(box.minX));
            float v0 = still.getV0() + vScale * (float) (box.minZ - Math.floor(box.minZ));
            float v1 = still.getV0() + vScale * (float) (box.maxZ - Math.floor(box.minZ));

            RenderType type = RenderType.translucent();
            VertexConsumer consumer = source.getBuffer(type);
            Matrix4f matrix = poseStack.last().pose();
            consumer.addVertex(matrix, (float) box.minX, offset, (float) box.minZ).setColor(red, green, blue, alpha).setUv(u0, v0).setLight(light).setNormal(0, 1, 0);
            consumer.addVertex(matrix, (float) box.minX, offset, (float) box.maxZ).setColor(red, green, blue, alpha).setUv(u0, v1).setLight(light).setNormal(0, 1, 0);
            consumer.addVertex(matrix, (float) box.maxX, offset, (float) box.maxZ).setColor(red, green, blue, alpha).setUv(u1, v1).setLight(light).setNormal(0, 1, 0);
            consumer.addVertex(matrix, (float) box.maxX, offset, (float) box.minZ).setColor(red, green, blue, alpha).setUv(u1, v0).setLight(light).setNormal(0, 1, 0);
        }
    }

    /**
     * Utility method for creating the AABB box used for rendering fluids. This method creates an
     * AABB that is rotated according to the given direction. The given min and max values are
     * assumed to be east facing position. The values must be in local pixel space.
     *
     * @param direction the direction the box should be facing
     * @param minX      the min x value of box
     * @param minY      the min y value of box
     * @param minZ      the min z value of box
     * @param maxX      the max x value of box
     * @param maxY      the max y value of box
     * @param maxZ      the max z value of box
     * @return A new rotated AABB
     */
    public static AABB createRotatedBox(Direction direction, double minX, double minY, double minZ, double maxX, double maxY, double maxZ)
    {
        minX /= 16.0;
        minY /= 16.0;
        minZ /= 16.0;
        maxX /= 16.0;
        maxY /= 16.0;
        maxZ /= 16.0;
        return switch(direction)
        {
            case WEST -> new AABB(1 - maxX, minY, 1 - maxZ, 1 - minX, maxY, 1 - minZ);
            case NORTH -> new AABB(minZ, minY, 1 - maxX, maxZ, maxY, 1 - minX);
            case SOUTH -> new AABB(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX);
            default -> new AABB(minX, minY, minZ, maxX, maxY, maxZ);
        };
    }
}