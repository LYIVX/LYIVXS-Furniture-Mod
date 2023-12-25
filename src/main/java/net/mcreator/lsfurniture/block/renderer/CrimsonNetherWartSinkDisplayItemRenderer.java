package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonNetherWartSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.CrimsonNetherWartSinkDisplayItem;

public class CrimsonNetherWartSinkDisplayItemRenderer extends GeoItemRenderer<CrimsonNetherWartSinkDisplayItem> {
	public CrimsonNetherWartSinkDisplayItemRenderer() {
		super(new CrimsonNetherWartSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(CrimsonNetherWartSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
