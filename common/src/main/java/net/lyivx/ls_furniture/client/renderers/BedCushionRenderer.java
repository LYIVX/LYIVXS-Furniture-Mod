package net.lyivx.ls_furniture.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.lyivx.ls_furniture.common.blocks.entity.BedBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BedPart;
import org.jetbrains.annotations.NotNull;

import static net.lyivx.ls_furniture.common.blocks.ModBedBlock.PART;
import static net.lyivx.ls_furniture.common.blocks.SofaBlock.FACING;

public class BedCushionRenderer implements BlockEntityRenderer<BedBlockEntity> {

    private final BlockRenderDispatcher blockRenderer;

    public BedCushionRenderer(BlockEntityRendererProvider.Context context) {
        this.blockRenderer = context.getBlockRenderDispatcher();
    }

    @Override
    public void render(@NotNull BedBlockEntity blockEntity, float partialTicks, @NotNull PoseStack stack, @NotNull MultiBufferSource source, int light, int overlay) {
        if (!blockEntity.hasColor()) return;
        Direction direction = blockEntity.getBlockState().getValue(FACING);
        BedPart type = blockEntity.getBlockState().getValue(PART);
        BakedModel model = LYIVXsFurnitureModClient.getModel(blockRenderer, blockEntity.getModel());
        stack.pushPose();
        stack.translate(0, 3d/16d, 0);
        if (direction == Direction.NORTH && (type == BedPart.FOOT)) {
            stack.mulPose(Axis.YP.rotationDegrees(180));
            stack.translate(-1, 0, -1);

        } else if (direction == Direction.WEST && (type == BedPart.FOOT)) {
            stack.mulPose(Axis.YP.rotationDegrees(270));
            stack.translate(0, 0, -1);

        } else if (direction == Direction.SOUTH && (type == BedPart.FOOT)) {
            stack.mulPose(Axis.YP.rotationDegrees(0));
            stack.translate(0, 0, 0);

        } else if (direction == Direction.EAST && (type == BedPart.FOOT)) {
            stack.mulPose(Axis.YP.rotationDegrees(90));
            stack.translate(-1, 0, 0);

        } else if (direction == Direction.NORTH && type == BedPart.HEAD) { //NORTH
            stack.mulPose(Axis.YP.rotationDegrees(180));
            stack.translate(-1, 3d/16d, -1);

        } else if (direction == Direction.WEST && type == BedPart.HEAD) { //WEST
            stack.mulPose(Axis.YP.rotationDegrees(270));
            stack.translate(0, 3d/16d, -1);

        } else if (direction == Direction.SOUTH && type == BedPart.HEAD) { //SOUTH
            stack.mulPose(Axis.YP.rotationDegrees(0));
            stack.translate(0, 3d/16d, 0);

        } else if (direction == Direction.EAST && type == BedPart.HEAD) { //EAST
            stack.mulPose(Axis.YP.rotationDegrees( 90));
            stack.translate(-1, 3d/16d, 0);
        }

            blockRenderer.getModelRenderer().renderModel(stack.last(), source.getBuffer(Sheets.cutoutBlockSheet()), null, model, 1f, 1f, 1f, light, OverlayTexture.NO_OVERLAY);
        stack.popPose();
    }
}