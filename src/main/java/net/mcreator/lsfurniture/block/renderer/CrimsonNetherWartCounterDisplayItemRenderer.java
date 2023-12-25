package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonNetherWartCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.CrimsonNetherWartCounterDisplayItem;

public class CrimsonNetherWartCounterDisplayItemRenderer extends GeoItemRenderer<CrimsonNetherWartCounterDisplayItem> {
	public CrimsonNetherWartCounterDisplayItemRenderer() {
		super(new CrimsonNetherWartCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(CrimsonNetherWartCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
