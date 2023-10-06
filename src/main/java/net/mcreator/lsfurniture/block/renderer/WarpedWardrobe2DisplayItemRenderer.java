package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.WarpedWardrobe2DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class WarpedWardrobe2DisplayItemRenderer extends GeoItemRenderer<WarpedWardrobe2DisplayItem> {
	public WarpedWardrobe2DisplayItemRenderer() {
		super(new WarpedWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(WarpedWardrobe2DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
