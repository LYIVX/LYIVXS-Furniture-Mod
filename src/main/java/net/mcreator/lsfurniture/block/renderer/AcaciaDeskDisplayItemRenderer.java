package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaDeskDisplayModel;
import net.mcreator.lsfurniture.block.display.AcaciaDeskDisplayItem;

public class AcaciaDeskDisplayItemRenderer extends GeoItemRenderer<AcaciaDeskDisplayItem> {
	public AcaciaDeskDisplayItemRenderer() {
		super(new AcaciaDeskDisplayModel());
	}

	@Override
	public RenderType getRenderType(AcaciaDeskDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
