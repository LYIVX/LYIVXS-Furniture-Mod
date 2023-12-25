package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonWardrobeDisplayModel;
import net.mcreator.lsfurniture.block.display.CrimsonWardrobeDisplayItem;

public class CrimsonWardrobeDisplayItemRenderer extends GeoItemRenderer<CrimsonWardrobeDisplayItem> {
	public CrimsonWardrobeDisplayItemRenderer() {
		super(new CrimsonWardrobeDisplayModel());
	}

	@Override
	public RenderType getRenderType(CrimsonWardrobeDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
