package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceDrawerDisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceDrawerDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SpruceDrawerDisplayItemRenderer extends GeoItemRenderer<SpruceDrawerDisplayItem> {
	public SpruceDrawerDisplayItemRenderer() {
		super(new SpruceDrawerDisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceDrawerDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
