package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchWardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.BirchWardrobe1DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BirchWardrobe1DisplayItemRenderer extends GeoItemRenderer<BirchWardrobe1DisplayItem> {
	public BirchWardrobe1DisplayItemRenderer() {
		super(new BirchWardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchWardrobe1DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
