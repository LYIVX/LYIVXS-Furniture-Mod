package net.lyivx.ls_furniture.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lyivx.ls_furniture.common.blocks.entity.PlateBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import static net.lyivx.ls_furniture.common.blocks.ShelfBlock.FACING;

@Environment(value= EnvType.CLIENT)
public class PlateRenderer implements BlockEntityRenderer<PlateBlockEntity> {

    public PlateRenderer(BlockEntityRendererProvider.Context context) {
    }

    public void render(PlateBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Direction direction = blockEntity.getBlockState().getValue(FACING);
        float rotation = -direction.toYRot() + 180f;
        NonNullList<ItemStack> items = blockEntity.getItems();
        poseStack.pushPose();
        if (rotation == 0) {
            poseStack.translate(0.7, 0.275, 0.47);
            poseStack.mulPose(Axis.ZP.rotationDegrees(rotation - 180));
            poseStack.mulPose(Axis.XP.rotationDegrees(rotation - 180 ));

        } else if (rotation == 90) {
            poseStack.translate(0.47, -.1, 0.7);
            poseStack.mulPose(Axis.ZP.rotationDegrees(rotation -180));
            poseStack.mulPose(Axis.YP.rotationDegrees(rotation - 90 ));

        } else if (rotation == 180) {
            poseStack.translate(0.7, -0.125, 0.53);
            poseStack.mulPose(Axis.ZP.rotationDegrees(rotation - 180));
        } else {
            poseStack.translate(0.53, -.1, 0.3);
            poseStack.mulPose(Axis.ZP.rotationDegrees(rotation));
        }
        poseStack.mulPose(Axis.YP.rotationDegrees(rotation));
        poseStack.mulPose(Axis.XP.rotationDegrees(rotation - 90));
        for(int j = 0; j < items.size(); j++) {
            ItemStack stack = items.get(j);
            if (stack.isEmpty()) continue;

            int renderCount = getAmount(stack.getCount());
            for (int i = 0; i < renderCount; ++i) {
                float fx = (-0.10375f * (float)(i - 1) * 0.5f) % 0.09f;
                float fy = (-0.04375f * (float)(i - 1) * 0.5f) % 0.09f;
                float fz = (-0.05375f * (float)(i - 1) * 0.5f) % 0.09f;

                poseStack.pushPose();

                poseStack.translate(0.15 - 0.05 * (j % 2), 0 - 0.02 * (j % 2), -0.225 + 0.13 * (j / 0.75));
                poseStack.translate(fx, fy, fz);
                poseStack.scale(0.6F, 0.6F, 0.6F);
                Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), 0);

                poseStack.popPose();
            }

        }
        poseStack.popPose();
    }

    public int getAmount(int count) {
        if (count > 48) return 5;
        if (count > 32) return 4;
        if (count > 16) return 3;
        if (count > 1) return 2;
        return 1;
    }
}