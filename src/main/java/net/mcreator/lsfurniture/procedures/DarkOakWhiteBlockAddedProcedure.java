package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class DarkOakWhiteBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String groupTag = "";
		groupTag = "forge" + ":" + "dark_oak_white_sofa_tag";
		if ((world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))) {
			DarkOakWhiteMainProcedure.execute(world, x, y, (z - 1));
		}
		if ((world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))) {
			DarkOakWhiteMainProcedure.execute(world, (x + 1), y, z);
		}
		if ((world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))) {
			DarkOakWhiteMainProcedure.execute(world, x, y, (z + 1));
		}
		if ((world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))) {
			DarkOakWhiteMainProcedure.execute(world, (x - 1), y, z);
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))) {
			DarkOakWhiteMainProcedure.execute(world, x, y, z);
		}
	}
}
