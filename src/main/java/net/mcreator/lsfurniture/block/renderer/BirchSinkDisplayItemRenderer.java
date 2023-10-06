package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.BirchSinkDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BirchSinkDisplayItemRenderer extends GeoItemRenderer<BirchSinkDisplayItem> {
	public BirchSinkDisplayItemRenderer() {
		super(new BirchSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchSinkDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
