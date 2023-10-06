package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakWardrobe0DisplayModel;
import net.mcreator.lsfurniture.block.display.OakWardrobe0DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class OakWardrobe0DisplayItemRenderer extends GeoItemRenderer<OakWardrobe0DisplayItem> {
	public OakWardrobe0DisplayItemRenderer() {
		super(new OakWardrobe0DisplayModel());
	}

	@Override
	public RenderType getRenderType(OakWardrobe0DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
