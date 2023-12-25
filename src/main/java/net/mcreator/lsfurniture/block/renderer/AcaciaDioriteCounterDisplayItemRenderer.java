package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaDioriteCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.AcaciaDioriteCounterDisplayItem;

public class AcaciaDioriteCounterDisplayItemRenderer extends GeoItemRenderer<AcaciaDioriteCounterDisplayItem> {
	public AcaciaDioriteCounterDisplayItemRenderer() {
		super(new AcaciaDioriteCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(AcaciaDioriteCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
