package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceAndesiteSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceAndesiteSinkDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SpruceAndesiteSinkDisplayItemRenderer extends GeoItemRenderer<SpruceAndesiteSinkDisplayItem> {
	public SpruceAndesiteSinkDisplayItemRenderer() {
		super(new SpruceAndesiteSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceAndesiteSinkDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
