package net.lyivx.ls_furniture.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.lyivx.ls_furniture.common.blocks.entity.StoolBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.NotNull;

import static net.lyivx.ls_furniture.common.blocks.ShelfBlock.FACING;

public class StoolCushionRenderer implements BlockEntityRenderer<StoolBlockEntity> {

    private final BlockRenderDispatcher blockRenderer;

    public StoolCushionRenderer(BlockEntityRendererProvider.Context context) {
        this.blockRenderer = context.getBlockRenderDispatcher();
    }

    @Override
    public void render(@NotNull StoolBlockEntity blockEntity, float partialTicks, @NotNull PoseStack stack, @NotNull MultiBufferSource source, int light, int overlay) {
        if (!blockEntity.hasColor()) return;
        Direction direction = blockEntity.getBlockState().getValue(FACING);
        float rotation = -direction.toYRot() + 180f;
        BakedModel model = LYIVXsFurnitureModClient.getModel(blockRenderer, blockEntity.getModel());
        stack.pushPose();
        stack.translate(0, 11d/16d, 0);
        if (rotation == 0) {
            stack.mulPose(Axis.YP.rotationDegrees(0));

        } else if (rotation == 90) {
            stack.mulPose(Axis.YP.rotationDegrees(90));
            stack.translate(-1, 0, 0);

        } else if (rotation == 180) {
            stack.mulPose(Axis.YP.rotationDegrees(180));
            stack.translate(-1, 0, -1);

        } else {
            stack.mulPose(Axis.YP.rotationDegrees(270));
            stack.translate(0, 0, -1);

        }
        blockRenderer.getModelRenderer().renderModel(stack.last(), source.getBuffer(Sheets.cutoutBlockSheet()), null, model, 1f, 1f, 1f, light, OverlayTexture.NO_OVERLAY);
        stack.popPose();
    }
}