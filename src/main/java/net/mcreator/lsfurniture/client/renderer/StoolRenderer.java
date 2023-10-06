
package net.mcreator.lsfurniture.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.lsfurniture.entity.StoolEntity;
import net.mcreator.lsfurniture.client.model.ModelSeat;

public class StoolRenderer extends MobRenderer<StoolEntity, ModelSeat<StoolEntity>> {
	public StoolRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSeat(context.bakeLayer(ModelSeat.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(StoolEntity entity) {
		return new ResourceLocation("ls_furniture:textures/entities/seat.png");
	}
}
