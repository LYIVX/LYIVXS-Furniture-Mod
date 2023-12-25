package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.FridgeFreezerBlockDisplayModel;
import net.mcreator.lsfurniture.block.display.FridgeFreezerBlockDisplayItem;

public class FridgeFreezerBlockDisplayItemRenderer extends GeoItemRenderer<FridgeFreezerBlockDisplayItem> {
	public FridgeFreezerBlockDisplayItemRenderer() {
		super(new FridgeFreezerBlockDisplayModel());
	}

	@Override
	public RenderType getRenderType(FridgeFreezerBlockDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
