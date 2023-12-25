package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AndesiteOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.AndesiteOvenDisplayItem;

public class AndesiteOvenDisplayItemRenderer extends GeoItemRenderer<AndesiteOvenDisplayItem> {
	public AndesiteOvenDisplayItemRenderer() {
		super(new AndesiteOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(AndesiteOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
