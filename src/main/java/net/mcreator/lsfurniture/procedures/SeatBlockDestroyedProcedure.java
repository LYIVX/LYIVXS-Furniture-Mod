package net.mcreator.lsfurniture.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.lsfurniture.entity.SeatEntity;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class SeatBlockDestroyedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(SeatEntity.class, AABB.ofSize(new Vec3((x + 0.5), y, (z + 0.5)), 0.1, 0.1, 0.1), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3((x + 0.5), y, (z + 0.5));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!entityiterator.level.isClientSide())
						entityiterator.discard();
				}
			}
		}
	}
}
