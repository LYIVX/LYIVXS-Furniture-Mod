package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakWardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.OakWardrobe1DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class OakWardrobe1DisplayItemRenderer extends GeoItemRenderer<OakWardrobe1DisplayItem> {
	public OakWardrobe1DisplayItemRenderer() {
		super(new OakWardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(OakWardrobe1DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
