package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveWardrobeDisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveWardrobeDisplayItem;

public class MangroveWardrobeDisplayItemRenderer extends GeoItemRenderer<MangroveWardrobeDisplayItem> {
	public MangroveWardrobeDisplayItemRenderer() {
		super(new MangroveWardrobeDisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveWardrobeDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
