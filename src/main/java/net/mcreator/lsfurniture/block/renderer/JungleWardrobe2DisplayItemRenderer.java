package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.JungleWardrobe2DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class JungleWardrobe2DisplayItemRenderer extends GeoItemRenderer<JungleWardrobe2DisplayItem> {
	public JungleWardrobe2DisplayItemRenderer() {
		super(new JungleWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleWardrobe2DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
