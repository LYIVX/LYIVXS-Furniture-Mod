package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchWardrobeDisplayModel;
import net.mcreator.lsfurniture.block.display.BirchWardrobeDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BirchWardrobeDisplayItemRenderer extends GeoItemRenderer<BirchWardrobeDisplayItem> {
	public BirchWardrobeDisplayItemRenderer() {
		super(new BirchWardrobeDisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchWardrobeDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
