package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.DarkOakSinkDisplayItem;

public class DarkOakSinkDisplayItemRenderer extends GeoItemRenderer<DarkOakSinkDisplayItem> {
	public DarkOakSinkDisplayItemRenderer() {
		super(new DarkOakSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(DarkOakSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
