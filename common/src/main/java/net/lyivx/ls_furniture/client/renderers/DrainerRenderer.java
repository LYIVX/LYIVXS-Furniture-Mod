package net.lyivx.ls_furniture.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lyivx.ls_furniture.common.blocks.entity.DrainerBlockEntity;
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
public class DrainerRenderer implements BlockEntityRenderer<DrainerBlockEntity> {

    public DrainerRenderer(BlockEntityRendererProvider.Context context) {

    }

    public void render(DrainerBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Direction direction = blockEntity.getBlockState().getValue(FACING);
        float rotation = direction.toYRot();
        NonNullList<ItemStack> items = blockEntity.getItems();
        poseStack.pushPose();


        if (rotation == 0) {
            poseStack.translate(0.65, 0.265, 0.695);
            poseStack.mulPose(Axis.XP.rotationDegrees(rotation + 90));

        } else if (rotation == 90) {
            poseStack.translate(0.305, 0.265, 0.85);
            poseStack.mulPose(Axis.ZP.rotationDegrees(rotation + 0));

        } else if (rotation == 180) {
            poseStack.translate(0.35, 0.265, 0.3);
            poseStack.mulPose(Axis.XP.rotationDegrees(rotation + 90));
            poseStack.mulPose(Axis.YP.rotationDegrees(rotation));

        } else {
            poseStack.translate(0.7, 0.265, 0.15);
            poseStack.mulPose(Axis.ZP.rotationDegrees(rotation + 180));
            poseStack.mulPose(Axis.XP.rotationDegrees(rotation - 90));

        }

        for(int j = 0; j < items.size(); j++) {
            ItemStack stack = items.get(j);
            if (stack.isEmpty()) continue;

            poseStack.pushPose();

            poseStack.translate(0.15 - 0.05, 0 - 0.125 * (j % 2), -0.225 + 0.13);
            poseStack.scale(1.5F, 1.5F, 1.5F);

            Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), 0);

            poseStack.popPose();

        }
        poseStack.popPose();
    }
}