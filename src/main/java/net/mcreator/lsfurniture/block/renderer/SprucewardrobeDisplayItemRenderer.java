package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SprucewardrobeDisplayModel;
import net.mcreator.lsfurniture.block.display.SprucewardrobeDisplayItem;

public class SprucewardrobeDisplayItemRenderer extends GeoItemRenderer<SprucewardrobeDisplayItem> {
	public SprucewardrobeDisplayItemRenderer() {
		super(new SprucewardrobeDisplayModel());
	}

	@Override
	public RenderType getRenderType(SprucewardrobeDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
