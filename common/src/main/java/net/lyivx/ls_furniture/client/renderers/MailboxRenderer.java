package net.lyivx.ls_furniture.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.lyivx.ls_furniture.common.blocks.entity.MailboxBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Matrix4f;

public class MailboxRenderer implements BlockEntityRenderer<MailboxBlockEntity> {
    private final BlockEntityRendererProvider.Context context;
    private static final float[] sideRotationY2D = { 0, 0, 2, 0, 3, 1 };
    private static final int TEXT_COLOR_TRANSPARENT = FastColor.ARGB32.color(0, 255, 255, 255);
    public MailboxRenderer(BlockEntityRendererProvider.Context context) {
        this.context = context;
    }

    private float getRotationYForSide2D (Direction side) {
        return sideRotationY2D[side.ordinal()] * 90 * (float)Math.PI / 180f;
    }

    @Override
    public void render(MailboxBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {

        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        Level level = blockEntity.getLevel();
        if (level == null) return;

        String ownerDisplayName = blockEntity.getOwnerDisplayName() != null ? blockEntity.getOwnerDisplayName().getString() : "";

        float distance = (float)Math.sqrt(blockEntity.getBlockPos().distToCenterSqr(player.position()));
        float alpha = Math.max(1f - ((distance) / 10), 0.05f);

        if (distance > 10) return;

        float Line1Offset = -1f/16f;

        BlockState blockState = blockEntity.getBlockState();
        Direction side = blockState.getValue(HorizontalDirectionalBlock.FACING);

        poseStack.pushPose();

        try {

            switch (side) {
                case NORTH:
                    poseStack.translate(0.5f, 0.775f, 0.6545f);
                    break;
                case SOUTH:
                    poseStack.translate(0.5f, 0.775f, 0.3455f);
                    break;
                case WEST:
                    poseStack.translate(0.6545f, 0.775f, 0.5f);
                    break;
                case EAST:
                    poseStack.translate(0.3455f, 0.775f, 0.5f);
                    break;
            }

            poseStack.mulPoseMatrix((new Matrix4f()).rotateYXZ(getRotationYForSide2D(side), 0, 0));
            poseStack.translate(-0.5f, 0, -0.5f);

            // Adjust position to render on the block face
            float zOffset = 15.05f / 16f;

            packedLight = 255;

            renderLine(ownerDisplayName, Line1Offset, zOffset, packedLight, poseStack, buffer, alpha);
        } finally {
            poseStack.popPose();  // Ensure poseStack is always popped, even in case of exception
        }

    }

    private void renderLine(String text, float yOffset, float zOffset, int packedLight, PoseStack poseStack, MultiBufferSource buffer, float alpha) {

        Font textRenderer = this.context.getFont();
        int textWidth = textRenderer.width(text);

        poseStack.pushPose();
        // Adjust position to render on the block face
        poseStack.translate(0.5f, yOffset, zOffset);
        // Flip Text Upside Down & Shrink
        poseStack.scale(1/192f, -1/192f, 1f);

        int color = 0xFFFFFF;
        color = (int) (255 * alpha) << 24 | TEXT_COLOR_TRANSPARENT;
        float x = (float) -textWidth / 2;
        float y = 0;
        boolean dropShadow = false;
        Matrix4f matrix = poseStack.last().pose();
        Font.DisplayMode displayMode = Font.DisplayMode.NORMAL;
        int backgroundColor = 0;

        textRenderer.drawInBatch(text, x, y, color, dropShadow, matrix, buffer, displayMode, backgroundColor, packedLight);
        poseStack.popPose();
    }
}