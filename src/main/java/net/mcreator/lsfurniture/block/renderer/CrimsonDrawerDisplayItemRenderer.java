package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonDrawerDisplayModel;
import net.mcreator.lsfurniture.block.display.CrimsonDrawerDisplayItem;

public class CrimsonDrawerDisplayItemRenderer extends GeoItemRenderer<CrimsonDrawerDisplayItem> {
	public CrimsonDrawerDisplayItemRenderer() {
		super(new CrimsonDrawerDisplayModel());
	}

	@Override
	public RenderType getRenderType(CrimsonDrawerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
