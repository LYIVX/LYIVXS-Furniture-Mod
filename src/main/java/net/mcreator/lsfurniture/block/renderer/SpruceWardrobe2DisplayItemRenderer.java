package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceWardrobe2DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SpruceWardrobe2DisplayItemRenderer extends GeoItemRenderer<SpruceWardrobe2DisplayItem> {
	public SpruceWardrobe2DisplayItemRenderer() {
		super(new SpruceWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceWardrobe2DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
