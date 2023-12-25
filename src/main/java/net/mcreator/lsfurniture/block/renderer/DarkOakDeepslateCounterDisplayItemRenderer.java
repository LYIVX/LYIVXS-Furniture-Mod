package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakDeepslateCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.DarkOakDeepslateCounterDisplayItem;

public class DarkOakDeepslateCounterDisplayItemRenderer extends GeoItemRenderer<DarkOakDeepslateCounterDisplayItem> {
	public DarkOakDeepslateCounterDisplayItemRenderer() {
		super(new DarkOakDeepslateCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(DarkOakDeepslateCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
