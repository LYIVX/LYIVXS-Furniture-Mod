package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonCupboardDisplayModel;
import net.mcreator.lsfurniture.block.display.CrimsonCupboardDisplayItem;

public class CrimsonCupboardDisplayItemRenderer extends GeoItemRenderer<CrimsonCupboardDisplayItem> {
	public CrimsonCupboardDisplayItemRenderer() {
		super(new CrimsonCupboardDisplayModel());
	}

	@Override
	public RenderType getRenderType(CrimsonCupboardDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
