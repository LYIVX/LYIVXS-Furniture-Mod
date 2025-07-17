package net.lyivx.ls_furniture.client.renderers;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lyivx.ls_furniture.common.entity.SeatEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@Environment(value= EnvType.CLIENT)
public class SeatRenderer extends EntityRenderer<SeatEntity, EntityRenderState> {
    public SeatRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }
}