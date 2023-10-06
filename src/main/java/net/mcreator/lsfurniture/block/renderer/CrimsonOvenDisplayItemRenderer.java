package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.CrimsonOvenDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CrimsonOvenDisplayItemRenderer extends GeoItemRenderer<CrimsonOvenDisplayItem> {
	public CrimsonOvenDisplayItemRenderer() {
		super(new CrimsonOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(CrimsonOvenDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
