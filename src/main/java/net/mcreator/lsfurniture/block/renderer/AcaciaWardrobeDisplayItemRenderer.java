package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaWardrobeDisplayModel;
import net.mcreator.lsfurniture.block.display.AcaciaWardrobeDisplayItem;

public class AcaciaWardrobeDisplayItemRenderer extends GeoItemRenderer<AcaciaWardrobeDisplayItem> {
	public AcaciaWardrobeDisplayItemRenderer() {
		super(new AcaciaWardrobeDisplayModel());
	}

	@Override
	public RenderType getRenderType(AcaciaWardrobeDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
