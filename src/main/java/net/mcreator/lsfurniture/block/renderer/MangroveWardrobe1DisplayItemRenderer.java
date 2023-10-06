package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveWardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveWardrobe1DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MangroveWardrobe1DisplayItemRenderer extends GeoItemRenderer<MangroveWardrobe1DisplayItem> {
	public MangroveWardrobe1DisplayItemRenderer() {
		super(new MangroveWardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveWardrobe1DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
