package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.Darkoakwardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.Darkoakwardrobe2DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class Darkoakwardrobe2DisplayItemRenderer extends GeoItemRenderer<Darkoakwardrobe2DisplayItem> {
	public Darkoakwardrobe2DisplayItemRenderer() {
		super(new Darkoakwardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(Darkoakwardrobe2DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
