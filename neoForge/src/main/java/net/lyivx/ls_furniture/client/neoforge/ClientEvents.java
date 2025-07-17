package net.lyivx.ls_furniture.client.neoforge;

import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

public class ClientEvents {
    public static void onRegisterBlockColors(RegisterColorHandlersEvent.Block event)
    {
        LYIVXsFurnitureModClient.registerBlockColors(event::register);
    }

    /* TODO: public static void onRegisterItemColors(RegisterColorHandlersEvent.Item event)
    {
        LYIVXsFurnitureModClient.registerItemColors(event::register);
    }*/
}