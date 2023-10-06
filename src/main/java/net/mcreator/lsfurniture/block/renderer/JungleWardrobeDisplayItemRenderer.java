package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleWardrobeDisplayModel;
import net.mcreator.lsfurniture.block.display.JungleWardrobeDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class JungleWardrobeDisplayItemRenderer extends GeoItemRenderer<JungleWardrobeDisplayItem> {
	public JungleWardrobeDisplayItemRenderer() {
		super(new JungleWardrobeDisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleWardrobeDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
