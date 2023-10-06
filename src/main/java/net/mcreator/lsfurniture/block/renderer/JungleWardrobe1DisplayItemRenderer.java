package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleWardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.JungleWardrobe1DisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class JungleWardrobe1DisplayItemRenderer extends GeoItemRenderer<JungleWardrobe1DisplayItem> {
	public JungleWardrobe1DisplayItemRenderer() {
		super(new JungleWardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleWardrobe1DisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
