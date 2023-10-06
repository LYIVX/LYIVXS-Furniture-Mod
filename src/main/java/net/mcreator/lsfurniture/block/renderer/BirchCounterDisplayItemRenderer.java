package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.BirchCounterDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BirchCounterDisplayItemRenderer extends GeoItemRenderer<BirchCounterDisplayItem> {
	public BirchCounterDisplayItemRenderer() {
		super(new BirchCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchCounterDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
