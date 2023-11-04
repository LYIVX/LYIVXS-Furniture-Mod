package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.GraniteOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.GraniteOvenDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GraniteOvenDisplayItemRenderer extends GeoItemRenderer<GraniteOvenDisplayItem> {
	public GraniteOvenDisplayItemRenderer() {
		super(new GraniteOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(GraniteOvenDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
