package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.JungleOvenDisplayItem;

public class JungleOvenDisplayItemRenderer extends GeoItemRenderer<JungleOvenDisplayItem> {
	public JungleOvenDisplayItemRenderer() {
		super(new JungleOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
