package net.lyivx.ls_furniture.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import net.lyivx.ls_furniture.common.blocks.entity.ChoppingBoardBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ChoppingBoardRenderer implements BlockEntityRenderer<ChoppingBoardBlockEntity> {
    private final ItemRenderer itemRenderer;

    public ChoppingBoardRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    public void render(ChoppingBoardBlockEntity ChoppingBoard, float f, @NotNull PoseStack poseStack, @NotNull MultiBufferSource source, int i, int j) {
        int k = (int) ChoppingBoard.getBlockPos().asLong();

        ItemStack itemStack = ChoppingBoard.getItem();
        if (!itemStack.isEmpty()) {
            try (var stack = new CloseablePoseStack(poseStack)) {
                stack.translate(0.5D, 0.59375D, 0.5D);
                stack.mulPose(Axis.YP.rotationDegrees(180.0F));

                stack.scale(0.7F, 0.7F, 0.7F);
                this.itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, i, j, poseStack, source, ChoppingBoard.getLevel(), k);
            }
        }

    }
}