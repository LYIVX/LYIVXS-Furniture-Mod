package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.BirchWardrobe2DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BirchWardrobe2DisplayItemRenderer extends GeoItemRenderer<BirchWardrobe2DisplayItem> {
	public BirchWardrobe2DisplayItemRenderer() {
		super(new BirchWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchWardrobe2DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
