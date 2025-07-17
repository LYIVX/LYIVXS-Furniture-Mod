package net.lyivx.ls_furniture.client.screens.widgets;

import net.minecraft.core.BlockPos;
import net.minecraft.world.ticks.LevelTickAccess;
import net.minecraft.world.ticks.ScheduledTick;

public class NoOpTickAccess<T> implements LevelTickAccess<T> {

    @Override
    public void schedule(ScheduledTick<T> scheduledTick) {
        // No-op: Do nothing when a tick is scheduled
    }

    @Override
    public boolean hasScheduledTick(BlockPos pos, T object) {
        return false;  // No ticks are ever scheduled
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public boolean willTickThisTick(BlockPos pos, T type) {
        return false;
    }
}