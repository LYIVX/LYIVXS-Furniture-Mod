package net.lyivx.ls_furniture.client.neoforge;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class LYIVXsFurnitureModClientImpl {
    @SuppressWarnings("deprecation")
    public static void setRenderType(Block block, RenderType type) {
        ItemBlockRenderTypes.setRenderLayer(block, type);
    }

    public static BakedModel getModel(BlockRenderDispatcher dispatcher, ResourceLocation model) {
        return dispatcher.getBlockModelShaper().getModelManager().getModel(model);
    }
}
