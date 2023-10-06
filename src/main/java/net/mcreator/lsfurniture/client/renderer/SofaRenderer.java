
package net.mcreator.lsfurniture.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.lsfurniture.entity.SofaEntity;
import net.mcreator.lsfurniture.client.model.ModelSeat;

public class SofaRenderer extends MobRenderer<SofaEntity, ModelSeat<SofaEntity>> {
	public SofaRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSeat(context.bakeLayer(ModelSeat.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(SofaEntity entity) {
		return new ResourceLocation("ls_furniture:textures/entities/seat.png");
	}
}
