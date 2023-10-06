package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveWardrobe2DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MangroveWardrobe2DisplayItemRenderer extends GeoItemRenderer<MangroveWardrobe2DisplayItem> {
	public MangroveWardrobe2DisplayItemRenderer() {
		super(new MangroveWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveWardrobe2DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
