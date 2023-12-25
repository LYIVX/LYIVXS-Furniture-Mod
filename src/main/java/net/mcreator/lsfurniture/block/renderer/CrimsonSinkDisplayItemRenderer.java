package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.CrimsonSinkDisplayItem;

public class CrimsonSinkDisplayItemRenderer extends GeoItemRenderer<CrimsonSinkDisplayItem> {
	public CrimsonSinkDisplayItemRenderer() {
		super(new CrimsonSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(CrimsonSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
