package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaCupboardDisplayModel;
import net.mcreator.lsfurniture.block.display.AcaciaCupboardDisplayItem;

public class AcaciaCupboardDisplayItemRenderer extends GeoItemRenderer<AcaciaCupboardDisplayItem> {
	public AcaciaCupboardDisplayItemRenderer() {
		super(new AcaciaCupboardDisplayModel());
	}

	@Override
	public RenderType getRenderType(AcaciaCupboardDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
