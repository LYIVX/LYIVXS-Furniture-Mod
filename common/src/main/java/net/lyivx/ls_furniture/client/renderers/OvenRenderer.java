package net.lyivx.ls_furniture.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.lyivx.ls_furniture.common.blocks.CounterOvenBlock;
import net.lyivx.ls_furniture.common.blocks.entity.CounterOvenBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class OvenRenderer implements BlockEntityRenderer<CounterOvenBlockEntity> {
    private final ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

    public OvenRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(CounterOvenBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

        ItemStack itemStack = blockEntity.getItem(0);  // Get the item in slot 0

        if (!itemStack.isEmpty()) {

            System.out.println("Rendering item: {}" + itemStack);

            poseStack.pushPose();

            // Adjust these values to position the item correctly within the oven
            poseStack.translate(0.5, 0.4, 0.5);
            poseStack.scale(0.5f, 0.5f, 0.5f);  // Scale down the item if needed

            // Rotate the item based on the block's facing direction
            Direction facing = blockEntity.getBlockState().getValue(CounterOvenBlock.FACING);
            poseStack.mulPose(facing.getRotation());

            // Render the item
            itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), 0);

            poseStack.popPose();
        }
    }
}