package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SprucewardrobeDisplayModel;
import net.mcreator.lsfurniture.block.display.SprucewardrobeDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SprucewardrobeDisplayItemRenderer extends GeoItemRenderer<SprucewardrobeDisplayItem> {
	public SprucewardrobeDisplayItemRenderer() {
		super(new SprucewardrobeDisplayModel());
	}

	@Override
	public RenderType getRenderType(SprucewardrobeDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
