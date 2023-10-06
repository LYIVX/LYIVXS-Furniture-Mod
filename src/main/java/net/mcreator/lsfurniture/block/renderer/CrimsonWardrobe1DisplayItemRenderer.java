package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonWardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.CrimsonWardrobe1DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CrimsonWardrobe1DisplayItemRenderer extends GeoItemRenderer<CrimsonWardrobe1DisplayItem> {
	public CrimsonWardrobe1DisplayItemRenderer() {
		super(new CrimsonWardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(CrimsonWardrobe1DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
