package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class OakBlindsBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String groupTag = "";
		groupTag = "forge" + ":" + "oak_blinds";
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))) {
			OakBlindsMainProcedure.execute(world, x, (y - 1), z);
		}
		if ((world.getBlockState(new BlockPos(x, y + 1, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))) {
			OakBlindsMainProcedure.execute(world, x, (y + 1), z);
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation((groupTag).toLowerCase(java.util.Locale.ENGLISH))))) {
			OakBlindsMainProcedure.execute(world, x, y, z);
		}
	}
}
