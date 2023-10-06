package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveDrawerDisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveDrawerDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MangroveDrawerDisplayItemRenderer extends GeoItemRenderer<MangroveDrawerDisplayItem> {
	public MangroveDrawerDisplayItemRenderer() {
		super(new MangroveDrawerDisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveDrawerDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
