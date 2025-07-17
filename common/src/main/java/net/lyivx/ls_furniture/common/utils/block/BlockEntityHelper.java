package net.lyivx.ls_furniture.common.utils.block;

import net.minecraft.core.Holder;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;

public class BlockEntityHelper {


    @SuppressWarnings({"unchecked", "ConstantConditions"})
    public static void playSoundToPlayer(ServerPlayer player, SoundEvent sound, SoundSource source, float volume, float pitch) {
        ClientboundSoundPacket pkt = new ClientboundSoundPacket(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(sound), source, player.getX(), player.getY(), player.getZ(), volume, pitch, player.level().getRandom().nextLong());
        player.connection.send(pkt);
    }
    @SuppressWarnings({"ConstantConditions"})
    public static void broadcastUpdate(BlockEntity blockEntity, boolean updateRedstone) {
        blockEntity.setChanged();
        blockEntity.getLevel().sendBlockUpdated(blockEntity.getBlockPos(), blockEntity.getBlockState(), blockEntity.getBlockState(), Block.UPDATE_ALL);
        if(updateRedstone) blockEntity.getLevel().updateNeighbourForOutputSignal(blockEntity.getBlockPos(), blockEntity.getBlockState().getBlock());
    }
}