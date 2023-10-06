package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.CrimsonWardrobe2DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CrimsonWardrobe2DisplayItemRenderer extends GeoItemRenderer<CrimsonWardrobe2DisplayItem> {
	public CrimsonWardrobe2DisplayItemRenderer() {
		super(new CrimsonWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(CrimsonWardrobe2DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
