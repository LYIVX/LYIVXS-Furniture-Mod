package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.CrimsonOvenDisplayItem;

public class CrimsonOvenDisplayItemRenderer extends GeoItemRenderer<CrimsonOvenDisplayItem> {
	public CrimsonOvenDisplayItemRenderer() {
		super(new CrimsonOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(CrimsonOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
