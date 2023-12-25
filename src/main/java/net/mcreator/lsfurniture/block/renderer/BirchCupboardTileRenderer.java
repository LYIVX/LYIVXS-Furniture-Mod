package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchCupboardBlockModel;
import net.mcreator.lsfurniture.block.entity.BirchCupboardTileEntity;

public class BirchCupboardTileRenderer extends GeoBlockRenderer<BirchCupboardTileEntity> {
	public BirchCupboardTileRenderer() {
		super(new BirchCupboardBlockModel());
	}

	@Override
	public RenderType getRenderType(BirchCupboardTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
