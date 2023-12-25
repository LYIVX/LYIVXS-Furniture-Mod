package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWardrobeDisplayModel;
import net.mcreator.lsfurniture.block.display.WarpedWardrobeDisplayItem;

public class WarpedWardrobeDisplayItemRenderer extends GeoItemRenderer<WarpedWardrobeDisplayItem> {
	public WarpedWardrobeDisplayItemRenderer() {
		super(new WarpedWardrobeDisplayModel());
	}

	@Override
	public RenderType getRenderType(WarpedWardrobeDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
