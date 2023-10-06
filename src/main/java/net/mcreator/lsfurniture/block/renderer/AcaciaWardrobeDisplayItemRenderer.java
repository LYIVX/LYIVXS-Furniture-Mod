package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaWardrobeDisplayModel;
import net.mcreator.lsfurniture.block.display.AcaciaWardrobeDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AcaciaWardrobeDisplayItemRenderer extends GeoItemRenderer<AcaciaWardrobeDisplayItem> {
	public AcaciaWardrobeDisplayItemRenderer() {
		super(new AcaciaWardrobeDisplayModel());
	}

	@Override
	public RenderType getRenderType(AcaciaWardrobeDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
