package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceDeskDisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceDeskDisplayItem;

public class SpruceDeskDisplayItemRenderer extends GeoItemRenderer<SpruceDeskDisplayItem> {
	public SpruceDeskDisplayItemRenderer() {
		super(new SpruceDeskDisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceDeskDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
