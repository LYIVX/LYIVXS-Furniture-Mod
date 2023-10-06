package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaWardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.AcaciaWardrobe1DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AcaciaWardrobe1DisplayItemRenderer extends GeoItemRenderer<AcaciaWardrobe1DisplayItem> {
	public AcaciaWardrobe1DisplayItemRenderer() {
		super(new AcaciaWardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(AcaciaWardrobe1DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
