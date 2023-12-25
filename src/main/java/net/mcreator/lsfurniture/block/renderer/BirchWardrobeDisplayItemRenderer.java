package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchWardrobeDisplayModel;
import net.mcreator.lsfurniture.block.display.BirchWardrobeDisplayItem;

public class BirchWardrobeDisplayItemRenderer extends GeoItemRenderer<BirchWardrobeDisplayItem> {
	public BirchWardrobeDisplayItemRenderer() {
		super(new BirchWardrobeDisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchWardrobeDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
