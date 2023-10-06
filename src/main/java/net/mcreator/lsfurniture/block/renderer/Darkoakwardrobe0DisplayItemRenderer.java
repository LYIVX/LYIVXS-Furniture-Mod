package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.Darkoakwardrobe0DisplayModel;
import net.mcreator.lsfurniture.block.display.Darkoakwardrobe0DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class Darkoakwardrobe0DisplayItemRenderer extends GeoItemRenderer<Darkoakwardrobe0DisplayItem> {
	public Darkoakwardrobe0DisplayItemRenderer() {
		super(new Darkoakwardrobe0DisplayModel());
	}

	@Override
	public RenderType getRenderType(Darkoakwardrobe0DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
