package net.lyivx.ls_furniture.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.lyivx.ls_furniture.common.blocks.entity.SofaBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.SofaType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.NotNull;

import static net.lyivx.ls_furniture.common.blocks.SofaBlock.FACING;
import static net.lyivx.ls_furniture.common.blocks.SofaBlock.SHAPE;

public class SofaCushionRenderer implements BlockEntityRenderer<SofaBlockEntity> {

    private final BlockRenderDispatcher blockRenderer;

    public SofaCushionRenderer(BlockEntityRendererProvider.Context context) {
        this.blockRenderer = context.getBlockRenderDispatcher();
    }

    @Override
    public void render(@NotNull SofaBlockEntity blockEntity, float partialTicks, @NotNull PoseStack stack, @NotNull MultiBufferSource source, int light, int overlay) {
        if (!blockEntity.hasColor()) return;
        Direction direction = blockEntity.getBlockState().getValue(FACING);
        SofaType type = blockEntity.getBlockState().getValue(SHAPE);
        BakedModel model = LYIVXsFurnitureModClient.getModel(blockRenderer, blockEntity.getModel());
        stack.pushPose();
        stack.translate(0, 6d/16d, 0);
        if (direction == Direction.NORTH && !(type == SofaType.INNER_RIGHT) && !(type == SofaType.OUTER_RIGHT)) {
            stack.mulPose(Axis.YP.rotationDegrees(0));

        } else if (direction == Direction.WEST && !(type == SofaType.INNER_RIGHT) && !(type == SofaType.OUTER_RIGHT)) {
            stack.mulPose(Axis.YP.rotationDegrees(90));
            stack.translate(-1, 0, 0);

        } else if (direction == Direction.SOUTH && !(type == SofaType.INNER_RIGHT) && !(type == SofaType.OUTER_RIGHT)) {
            stack.mulPose(Axis.YP.rotationDegrees(180));
            stack.translate(-1, 0, -1);

        } else if (direction == Direction.EAST && !(type == SofaType.INNER_RIGHT) && !(type == SofaType.OUTER_RIGHT)) {
            stack.mulPose(Axis.YP.rotationDegrees(270));
            stack.translate(0, 0, -1);

        } else if (direction == Direction.NORTH && type == SofaType.INNER_RIGHT) { //NORTH
            stack.mulPose(Axis.YP.rotationDegrees(270));
            stack.translate(0, 0, -1);

        } else if (direction == Direction.WEST && type == SofaType.INNER_RIGHT) { //WEST
            stack.mulPose(Axis.YP.rotationDegrees(0));
            stack.translate(0, 0, 0);

        } else if (direction == Direction.SOUTH && type == SofaType.INNER_RIGHT) { //SOUTH
            stack.mulPose(Axis.YP.rotationDegrees(90));
            stack.translate(-1, 0, 0);

        } else if (direction == Direction.EAST && type == SofaType.INNER_RIGHT) { //EAST
            stack.mulPose(Axis.YP.rotationDegrees( 180));
            stack.translate(-1, 0, -1);



        } else if (direction == Direction.NORTH && type == SofaType.OUTER_RIGHT) { //NORTH
            stack.mulPose(Axis.YP.rotationDegrees(270));
            stack.translate(0, 0, -1);

        } else if (direction == Direction.WEST && type == SofaType.OUTER_RIGHT) { //WEST
            stack.mulPose(Axis.YP.rotationDegrees(0));
            stack.translate(0, 0, 0);

        } else if (direction == Direction.SOUTH && type == SofaType.OUTER_RIGHT) { //SOUTH
            stack.mulPose(Axis.YP.rotationDegrees(90));
            stack.translate(-1, 0, 0);

        } else if (direction == Direction.EAST && type == SofaType.OUTER_RIGHT) { //EAST
            stack.mulPose(Axis.YP.rotationDegrees( 180));
            stack.translate(-1, 0, -1);
        }
        
        
            blockRenderer.getModelRenderer().renderModel(stack.last(), source.getBuffer(Sheets.cutoutBlockSheet()), null, model, 1f, 1f, 1f, light, OverlayTexture.NO_OVERLAY);
        stack.popPose();
    }
}