package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.Darkoakwardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.Darkoakwardrobe1DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class Darkoakwardrobe1DisplayItemRenderer extends GeoItemRenderer<Darkoakwardrobe1DisplayItem> {
	public Darkoakwardrobe1DisplayItemRenderer() {
		super(new Darkoakwardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(Darkoakwardrobe1DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
