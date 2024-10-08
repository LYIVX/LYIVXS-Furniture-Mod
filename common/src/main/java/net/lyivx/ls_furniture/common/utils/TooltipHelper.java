package net.lyivx.ls_furniture.common.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class TooltipHelper {

    private static final ResourceLocation ITEM_FONT = new ResourceLocation("minecraft", "alt");

    // copied from Shulker Box
    public static void appendInventoryContent(ItemStack stack, List<Component> tooltip) {
        CompoundTag compoundnbt = stack.getTagElement("BlockEntityTag");
        if (compoundnbt != null) {
            if (compoundnbt.contains("LootTable", 8)) {
                tooltip.add(Component.literal("???????"));
            }

            if (compoundnbt.contains("Items", 9)) {
                NonNullList<ItemStack> inventory = NonNullList.withSize(27, ItemStack.EMPTY);
                ContainerHelper.loadAllItems(compoundnbt, inventory);
                int i = 0;
                int j = 0;

                for(ItemStack itemstack : inventory) {
                    if (!itemstack.isEmpty()) {
                        ++j;
                        if (i <= 4) {
                            ++i;
                            MutableComponent itemComponent = Component.empty()
                                    .append(itemstack.getHoverName())
                                    .append(" x").append(String.valueOf(itemstack.getCount()));

                            tooltip.add(itemComponent.withStyle(itemstack.getRarity().color));
                        }
                    }
                }

                if (j - i > 0) {
                    tooltip.add((Component.translatable("container.shulkerBox.more", j - i)).withStyle(ChatFormatting.ITALIC, ChatFormatting.GRAY));
                }
            }
        }
    }
}
