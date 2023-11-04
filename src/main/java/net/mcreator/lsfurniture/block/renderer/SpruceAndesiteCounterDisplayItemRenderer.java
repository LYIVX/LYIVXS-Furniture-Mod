package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceAndesiteCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceAndesiteCounterDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SpruceAndesiteCounterDisplayItemRenderer extends GeoItemRenderer<SpruceAndesiteCounterDisplayItem> {
	public SpruceAndesiteCounterDisplayItemRenderer() {
		super(new SpruceAndesiteCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceAndesiteCounterDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
