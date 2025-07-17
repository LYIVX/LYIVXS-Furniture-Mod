package net.lyivx.ls_furniture.client.forge;

import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.data.event.GatherDataEvent;

public class ClientEvents {
    public static void onRegisterBlockColors(RegisterColorHandlersEvent.Block event)
    {
        LYIVXsFurnitureModClient.registerBlockColors(event::register);
    }

    public static void onRegisterItemColors(RegisterColorHandlersEvent.Item event)
    {
        LYIVXsFurnitureModClient.registerItemColors(event::register);
    }
}