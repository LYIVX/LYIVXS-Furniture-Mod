package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.DarkOakOvenDisplayItem;

public class DarkOakOvenDisplayItemRenderer extends GeoItemRenderer<DarkOakOvenDisplayItem> {
	public DarkOakOvenDisplayItemRenderer() {
		super(new DarkOakOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(DarkOakOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
