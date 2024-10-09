package net.lyivx.ls_furniture.common.keybinds;

import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import net.lyivx.ls_furniture.client.screens.ModConfigScreen;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class ModConfigKeybind {
    private static final KeyMapping OPEN_CONFIG_KEY = new KeyMapping(
            "key.ls_furniture.openconfig",
            GLFW.GLFW_KEY_M,
            "key.ls_furniture.categories.ls_furniture"
    );

    public static void registerKeybinding() {
        KeyMappingRegistry.register(OPEN_CONFIG_KEY);
    }

    public static void checkKeybinding() {
        while (OPEN_CONFIG_KEY.consumeClick()) {
            Minecraft.getInstance().setScreen(new ModConfigScreen(
                    Minecraft.getInstance().screen,
                    Minecraft.getInstance().options,
                    ModConfigScreen.CategoryType.GENERAL
            ));
        }
    }
}

