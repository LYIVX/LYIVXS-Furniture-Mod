package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceWardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceWardrobe1DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SpruceWardrobe1DisplayItemRenderer extends GeoItemRenderer<SpruceWardrobe1DisplayItem> {
	public SpruceWardrobe1DisplayItemRenderer() {
		super(new SpruceWardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceWardrobe1DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
