package net.lyivx.ls_furniture.common.network;

import it.unimi.dsi.fastutil.ints.IntList;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.recipes.RecipeSorter;
import net.mehvahdjukaar.moonlight.api.platform.network.Message;
import net.mehvahdjukaar.moonlight.api.platform.network.NetworkDir;
import net.mehvahdjukaar.moonlight.api.platform.network.NetworkHelper;
import net.minecraft.network.FriendlyByteBuf;

public class NetworkRecipeSync {

    public static void init() {

        NetworkHelper.addRegistration(LYIVXsFurnitureMod.MOD_ID, event ->
                event.register(NetworkDir.CLIENTBOUND, SyncRecipeOrder.class, SyncRecipeOrder::new));
    }

    public record SyncRecipeOrder(IntList list) implements Message {

        public SyncRecipeOrder(FriendlyByteBuf buf) {
            this(buf.readIntIdList());
        }

        @Override
        public void write(FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeIntIdList(list);
        }

        @Override
        public void handle(NetworkHelper.Context context) {
            RecipeSorter.acceptOrder(list);

        }
    }
}