package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class OvenFuelRemainingProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		return "Uses: " + new java.text.DecimalFormat("##").format((new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "fuelticks")) / 100);
	}
}
