package net.lyivx.ls_furniture.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.lyivx.ls_furniture.common.blocks.TombstoneBlock;
import net.lyivx.ls_furniture.common.blocks.entity.TombstoneBlockEntity;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Matrix4f;

public class TombstoneRenderer implements BlockEntityRenderer<TombstoneBlockEntity> {
    private final Font font;
    private static final float[] sideRotationY2D = {0, 0, 2, 0, 3, 1};

    public TombstoneRenderer(BlockEntityRendererProvider.Context context) {
        this.font = context.getFont();
    }

    private float getRotationYForSide2D(Direction side) {
        return sideRotationY2D[side.ordinal()] * 90 * (float) Math.PI / 180f;
    }

    @Override
    public void render(TombstoneBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        String[] lines = blockEntity.getLines();
        float[] textSizes = blockEntity.getTextSizes();
        DyeColor color = blockEntity.getColor();
        boolean isGlowing = blockEntity.isGlowing();

        poseStack.pushPose();

        BlockState blockState = blockEntity.getBlockState();
        Direction side = blockState.getValue(HorizontalDirectionalBlock.FACING);

        switch (side) {
            case NORTH:
                poseStack.translate(0.5f, 0.63f, 11.99 / 16d);
                break;
            case SOUTH:
                poseStack.translate(0.5f, 0.63f, 4.01 / 16d);
                break;
            case WEST:
                poseStack.translate(11.99 / 16d, 0.63f, 0.5f);
                break;
            case EAST:
                poseStack.translate(4.01 / 16d, 0.63f, 0.5f);
                break;
        }

        poseStack.mulPose((new org.joml.Matrix4f()).rotateY(getRotationYForSide2D(side)));

        // Move slightly in front of the block face

        // Scale and flip the text
        float baseScale = 0.01f;
        poseStack.scale(baseScale, -baseScale, baseScale);

        Matrix4f matrix = poseStack.last().pose();
        int textColor = color.getTextColor() | 0xFF000000; // Ensure full alpha
        int packedLightForText = isGlowing ? 15728880 : packedLight; // Max light value if glowing


        int a = (color.getTextColor() >> 24) & 0xFF;
        int r = (int) (((color.getTextColor() >> 16) & 0xFF) * 0.4f);
        int g = (int) (((color.getTextColor() >> 8) & 0xFF) * 0.4f);

        int b = (int) ((color.getTextColor() & 0xFF) * 0.4f);

        int outlineColor = ((color == DyeColor.BLACK) ? -988212 : (a << 24) | (r << 16) | (g << 8) | b); // Light gray for white text, white for other colors


        float lineHeight = 20f; // Base height between lines
        float totalHeight = lineHeight * (lines.length - 1);
        float startY = -totalHeight / 2;

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (line != null && !line.isEmpty()) {
                float lineScale = textSizes[i];
                float y = startY + i * lineHeight;

                poseStack.pushPose();

                // Translate to the line's position
                poseStack.translate(0, y, 0);

                // Apply scaling
                poseStack.scale(lineScale, lineScale, 1);

                // Center the text horizontally
                float x = -this.font.width(line) / 2f;

                if (isGlowing) {
                    // Render outline effect
                    renderOutline(line, x, 0, outlineColor, poseStack.last().pose(), buffer, packedLightForText);
                }

                // Render main text
                this.font.drawInBatch(line, x, 0, textColor, false, poseStack.last().pose(), buffer, Font.DisplayMode.POLYGON_OFFSET, 0, packedLightForText);

                poseStack.popPose();
            }
        }

        poseStack.popPose();
    }

    private void renderOutline(String text, float x, float y, int color, Matrix4f matrix, MultiBufferSource buffer, int packedLight) {
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                if (xOffset != 0 || yOffset != 0) {
                    this.font.drawInBatch(text, x + xOffset * 0.5f, y + yOffset * 0.5f, color, false, matrix, buffer, Font.DisplayMode.NORMAL, 0, packedLight);
                }
            }
        }
    }
}