package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakCupboardDisplayModel;
import net.mcreator.lsfurniture.block.display.DarkOakCupboardDisplayItem;

public class DarkOakCupboardDisplayItemRenderer extends GeoItemRenderer<DarkOakCupboardDisplayItem> {
	public DarkOakCupboardDisplayItemRenderer() {
		super(new DarkOakCupboardDisplayModel());
	}

	@Override
	public RenderType getRenderType(DarkOakCupboardDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
