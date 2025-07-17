package net.lyivx.ls_furniture.registry;

import com.mojang.serialization.Codec;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;

public class ModComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_ATTACHMENTS = DeferredRegister.create(LYIVXsFurnitureMod.MOD_ID, Registries.DATA_COMPONENT_TYPE);


    public static final RegistrySupplier<DataComponentType<String>> Letter_Author = DATA_ATTACHMENTS.register("letter_author", () -> DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final RegistrySupplier<DataComponentType<String>> Letter_Text = DATA_ATTACHMENTS.register("letter_text", () -> DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());

}
