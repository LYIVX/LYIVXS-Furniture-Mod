package net.lyivx.ls_furniture.common.network;

import it.unimi.dsi.fastutil.ints.IntList;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.recipes.RecipeSorter;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;

public class NetworkRecipeSync {

    public static final ResourceLocation SYNC_RECIPE_ORDER = createResourceLocation("sync_recipe_order");

    public static void init() {
        // Register the packet on both client and server
        // This is a placeholder - you'll need to implement this according to your mod loader
        // registerPacket(SYNC_RECIPE_ORDER, SyncRecipeOrder::new, SyncRecipeOrder::handle);
    }

    public static class SyncRecipeOrder {
        private final IntList list;

        public SyncRecipeOrder(IntList list) {
            this.list = list;
        }

        public SyncRecipeOrder(FriendlyByteBuf buf) {
            this.list = buf.readIntIdList();
        }

        public void write(FriendlyByteBuf buf) {
            buf.writeIntIdList(list);
        }

        public void handle(Supplier<NetworkContext> contextSupplier) {
            NetworkContext context = contextSupplier.get();
            context.enqueueWork(() -> {
                RecipeSorter.acceptOrder(list);
            });
            context.setPacketHandled(true);
        }
    }

    // This is a placeholder interface - implement according to your mod loader
    public interface NetworkContext {
        void enqueueWork(Runnable runnable);
        void setPacketHandled(boolean handled);
    }
}