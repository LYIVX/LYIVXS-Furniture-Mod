package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AndesiteOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.AndesiteOvenDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AndesiteOvenDisplayItemRenderer extends GeoItemRenderer<AndesiteOvenDisplayItem> {
	public AndesiteOvenDisplayItemRenderer() {
		super(new AndesiteOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(AndesiteOvenDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
