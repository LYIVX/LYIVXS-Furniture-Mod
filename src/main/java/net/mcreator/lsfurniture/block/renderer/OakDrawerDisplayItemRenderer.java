package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakDrawerDisplayModel;
import net.mcreator.lsfurniture.block.display.OakDrawerDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class OakDrawerDisplayItemRenderer extends GeoItemRenderer<OakDrawerDisplayItem> {
	public OakDrawerDisplayItemRenderer() {
		super(new OakDrawerDisplayModel());
	}

	@Override
	public RenderType getRenderType(OakDrawerDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
