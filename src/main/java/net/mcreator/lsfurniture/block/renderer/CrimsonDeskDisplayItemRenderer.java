package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonDeskDisplayModel;
import net.mcreator.lsfurniture.block.display.CrimsonDeskDisplayItem;

public class CrimsonDeskDisplayItemRenderer extends GeoItemRenderer<CrimsonDeskDisplayItem> {
	public CrimsonDeskDisplayItemRenderer() {
		super(new CrimsonDeskDisplayModel());
	}

	@Override
	public RenderType getRenderType(CrimsonDeskDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
