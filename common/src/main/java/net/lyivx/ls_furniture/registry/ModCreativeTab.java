package net.lyivx.ls_furniture.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

import static net.lyivx.ls_furniture.registry.ModItems.ITEMS;

public class ModCreativeTab {

    public static final ResourcefulRegistry<CreativeModeTab> CREATIVE_MODE_TABS = ResourcefulRegistries.create(BuiltInRegistries.CREATIVE_MODE_TAB, LYIVXsFurnitureMod.MOD_ID);

    public static final RegistryEntry<CreativeModeTab> ITEM_GROUP = CREATIVE_MODE_TABS.register("tab", () ->
            CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).title(Component.translatable("itemGroup.ls_furniture.tab"))
                    .icon(() -> {
                        ItemStack iconStack = ModItems.WORKSTATION.get().getDefaultInstance();
                        CompoundTag tag = new CompoundTag();
                        tag.putBoolean("isCreativeTabIcon", true);
                        iconStack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
                        return iconStack;
                    })
                    .displayItems((itemDisplayParameters, output) -> ITEMS.stream().map(item -> setSpecialItemStackNbt(item.get().getDefaultInstance())).forEach(output::accept)).build());


    private static ItemStack setSpecialItemStackNbt(ItemStack itemStack) {
        return itemStack;
    }
}