package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.DarkOakCounterDisplayItem;

public class DarkOakCounterDisplayItemRenderer extends GeoItemRenderer<DarkOakCounterDisplayItem> {
	public DarkOakCounterDisplayItemRenderer() {
		super(new DarkOakCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(DarkOakCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
