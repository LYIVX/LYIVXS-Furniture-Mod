package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class WardrobeBlockDestroyedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("forge:wardrobe")))) {
			world.destroyBlock(new BlockPos(x, y + 1, z), false);
		} else if ((world.getBlockState(new BlockPos(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("forge:wardrobe")))) {
			world.destroyBlock(new BlockPos(x, y - 1, z), false);
		}
	}
}
