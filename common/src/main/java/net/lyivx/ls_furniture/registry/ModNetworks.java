package net.lyivx.ls_furniture.registry;

import dev.architectury.networking.NetworkManager;
import net.lyivx.ls_furniture.common.network.ServerboundLetterUpdateMessage;

public class ModNetworks {

    public static void init() {

        NetworkManager.registerReceiver(NetworkManager.Side.C2S, ServerboundLetterUpdateMessage.TYPE, ServerboundLetterUpdateMessage.STREAM_CODEC, new ServerboundLetterUpdateMessage.Receiver());
    }
}
