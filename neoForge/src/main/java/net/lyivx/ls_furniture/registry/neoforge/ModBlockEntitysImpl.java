package net.lyivx.ls_furniture.registry.neoforge;

import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import java.util.Set;

public class ModBlockEntitysImpl {

    public static <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(ModBlockEntitys.BlockEntityFactory<E> factory, Block... blocks) {
        return new BlockEntityType<>(factory::create, Set.of(blocks), false);
    }
}