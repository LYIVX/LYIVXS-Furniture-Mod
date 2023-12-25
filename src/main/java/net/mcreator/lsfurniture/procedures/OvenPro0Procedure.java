package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class OvenPro0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		OvenProProcedure.execute(world, x, y, z);
		OvenPro2Procedure.execute(world, x, y, z);
		{
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp)
				world.setBlock(_pos, _bs.setValue(_integerProp, 0), 3);
		}
	}
}
