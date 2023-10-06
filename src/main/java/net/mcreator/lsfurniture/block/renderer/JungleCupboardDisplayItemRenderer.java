package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleCupboardDisplayModel;
import net.mcreator.lsfurniture.block.display.JungleCupboardDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class JungleCupboardDisplayItemRenderer extends GeoItemRenderer<JungleCupboardDisplayItem> {
	public JungleCupboardDisplayItemRenderer() {
		super(new JungleCupboardDisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleCupboardDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
