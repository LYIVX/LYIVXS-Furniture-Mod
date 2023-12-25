package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.JungleWardrobe2DisplayItem;

public class JungleWardrobe2DisplayItemRenderer extends GeoItemRenderer<JungleWardrobe2DisplayItem> {
	public JungleWardrobe2DisplayItemRenderer() {
		super(new JungleWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleWardrobe2DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
