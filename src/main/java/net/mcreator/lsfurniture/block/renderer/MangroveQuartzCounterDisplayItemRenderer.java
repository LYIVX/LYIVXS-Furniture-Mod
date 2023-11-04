package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveQuartzCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveQuartzCounterDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MangroveQuartzCounterDisplayItemRenderer extends GeoItemRenderer<MangroveQuartzCounterDisplayItem> {
	public MangroveQuartzCounterDisplayItemRenderer() {
		super(new MangroveQuartzCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveQuartzCounterDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
