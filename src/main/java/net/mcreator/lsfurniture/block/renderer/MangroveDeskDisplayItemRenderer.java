package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveDeskDisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveDeskDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MangroveDeskDisplayItemRenderer extends GeoItemRenderer<MangroveDeskDisplayItem> {
	public MangroveDeskDisplayItemRenderer() {
		super(new MangroveDeskDisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveDeskDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
