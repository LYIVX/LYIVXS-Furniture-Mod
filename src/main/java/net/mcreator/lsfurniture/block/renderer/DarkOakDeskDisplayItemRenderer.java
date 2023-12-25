package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakDeskDisplayModel;
import net.mcreator.lsfurniture.block.display.DarkOakDeskDisplayItem;

public class DarkOakDeskDisplayItemRenderer extends GeoItemRenderer<DarkOakDeskDisplayItem> {
	public DarkOakDeskDisplayItemRenderer() {
		super(new DarkOakDeskDisplayModel());
	}

	@Override
	public RenderType getRenderType(DarkOakDeskDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
