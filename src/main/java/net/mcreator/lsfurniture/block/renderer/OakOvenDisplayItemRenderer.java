package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.OakOvenDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class OakOvenDisplayItemRenderer extends GeoItemRenderer<OakOvenDisplayItem> {
	public OakOvenDisplayItemRenderer() {
		super(new OakOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(OakOvenDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
