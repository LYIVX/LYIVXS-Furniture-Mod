package net.lyivx.ls_furniture.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.lyivx.ls_furniture.common.blocks.LampBlock;
import net.lyivx.ls_furniture.common.blocks.entity.LampBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.NotNull;


public class LampShadeRenderer implements BlockEntityRenderer<LampBlockEntity> {

    private final BlockRenderDispatcher blockRenderer;

    public LampShadeRenderer(BlockEntityRendererProvider.Context context) {
        this.blockRenderer = context.getBlockRenderDispatcher();
    }

    @Override
    public void render(@NotNull LampBlockEntity blockEntity, float partialTicks, @NotNull PoseStack stack, @NotNull MultiBufferSource source, int light, int overlay) {
        if (!blockEntity.hasColor()) return;

        if (blockEntity.isRemoved()) {
            return; // Do not render if the entity is removed
        }

        Direction direction = blockEntity.getBlockState().getValue(LampBlock.FACING);
        float rotation = -direction.toYRot() + 180f;
        BakedModel model = LYIVXsFurnitureModClient.getModel(blockRenderer, blockEntity.getModel());

        stack.pushPose();
        stack.translate(0, 0, 0);

        switch (direction) {
            case NORTH:
                stack.mulPose(Axis.YP.rotationDegrees(180));
                stack.translate(-1, 0, -1.125);

                break;
            case SOUTH:
                stack.translate(0, 0, -0.125);
                break;

            case WEST:
                stack.mulPose(Axis.YP.rotationDegrees(90));
                stack.translate(-1, 0, 0.125);
                break;
            case EAST:
                stack.mulPose(Axis.YP.rotationDegrees(270));
                stack.translate(0, 0, -0.875);
                break;
        }

        blockRenderer.getModelRenderer().renderModel(stack.last(), source.getBuffer(Sheets.cutoutBlockSheet()), null, model, 1f, 1f, 1f, light, OverlayTexture.NO_OVERLAY);
        stack.popPose();
    }
}
