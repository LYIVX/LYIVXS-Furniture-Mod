package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleCupboardDisplayModel;
import net.mcreator.lsfurniture.block.display.JungleCupboardDisplayItem;

public class JungleCupboardDisplayItemRenderer extends GeoItemRenderer<JungleCupboardDisplayItem> {
	public JungleCupboardDisplayItemRenderer() {
		super(new JungleCupboardDisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleCupboardDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
