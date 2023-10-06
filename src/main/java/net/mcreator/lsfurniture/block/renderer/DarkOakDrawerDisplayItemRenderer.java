package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakDrawerDisplayModel;
import net.mcreator.lsfurniture.block.display.DarkOakDrawerDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class DarkOakDrawerDisplayItemRenderer extends GeoItemRenderer<DarkOakDrawerDisplayItem> {
	public DarkOakDrawerDisplayItemRenderer() {
		super(new DarkOakDrawerDisplayModel());
	}

	@Override
	public RenderType getRenderType(DarkOakDrawerDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
