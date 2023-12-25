package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakDrawerDisplayModel;
import net.mcreator.lsfurniture.block.display.DarkOakDrawerDisplayItem;

public class DarkOakDrawerDisplayItemRenderer extends GeoItemRenderer<DarkOakDrawerDisplayItem> {
	public DarkOakDrawerDisplayItemRenderer() {
		super(new DarkOakDrawerDisplayModel());
	}

	@Override
	public RenderType getRenderType(DarkOakDrawerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
