package net.lyivx.ls_furniture.common.network;

import dev.architectury.networking.NetworkManager;
import io.netty.buffer.Unpooled;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.blocks.entity.TombstoneBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;

public class UpdateTombstonePacket {
    public static final ResourceLocation ID = new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "update_tombstone");

    public static void register() {
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, ID, (buf, context) -> {
            BlockPos pos = buf.readBlockPos();
            String[] lines = new String[4];
            for (int i = 0; i < 4; i++) {
                lines[i] = buf.readUtf();
            }
            context.queue(() -> {
                BlockEntity be = context.getPlayer().level().getBlockEntity(pos);
                if (be instanceof TombstoneBlockEntity tombstone) {
                    tombstone.setLines(lines);
                }
            });
        });
    }

    public static void send(BlockPos pos, String[] lines) {
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        buf.writeBlockPos(pos);
        for (String line : lines) {
            buf.writeUtf(line);
        }
        NetworkManager.sendToServer(ID, buf);
    }
}