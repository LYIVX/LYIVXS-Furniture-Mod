package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.CrimsonCounterDisplayItem;

public class CrimsonCounterDisplayItemRenderer extends GeoItemRenderer<CrimsonCounterDisplayItem> {
	public CrimsonCounterDisplayItemRenderer() {
		super(new CrimsonCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(CrimsonCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
