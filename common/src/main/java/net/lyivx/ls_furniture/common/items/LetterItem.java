package net.lyivx.ls_furniture.common.items;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.lyivx.ls_furniture.registry.ModComponents;
import net.lyivx.ls_furniture.registry.ModSoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class LetterItem extends Item {
    public LetterItem(Properties properties) {
        super(properties);
    }

    private void openGui(ItemStack stack, Player playerEntity, InteractionHand hand) {
        playerEntity.level().playSound(null, playerEntity.blockPosition(), SoundEvents.BOOK_PAGE_TURN, SoundSource.PLAYERS, 1.0f, 1.0f);
        LYIVXsFurnitureModClient.openLetterGui(stack, playerEntity, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        if(itemStack.has(ModComponents.Letter_Author.get())) {
            list.add(Component.translatable("tooltip.ls_furniture.letter.author", itemStack.get(ModComponents.Letter_Author.get())).withStyle(ChatFormatting.GRAY));
        }
        if(itemStack.has(DataComponents.CONTAINER)) {
            ItemStack attachment = itemStack.get(DataComponents.CONTAINER).copyOne();
            list.add(Component.translatable("tooltip.ls_furniture.letter.attachment", attachment.getItem().getDescription()).withStyle(ChatFormatting.GRAY));
        }
    }

    public static ItemStack addAttachment(ItemStack letter, ItemStack attachment) {
        if(letter.has(DataComponents.CONTAINER)) {
            return attachment;
        } else {
            ArrayList<ItemStack> contents = new ArrayList(1);
            contents.add(attachment);
            letter.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(contents));
            return ItemStack.EMPTY;
        }
    }

    public static ItemStack removeAttachment(ItemStack letter) {
        if(letter.has(DataComponents.CONTAINER)) {
            ItemStack attachment = letter.get(DataComponents.CONTAINER).copyOne();
            letter.remove(DataComponents.CONTAINER);
            return attachment;
        }
        return ItemStack.EMPTY;
    }

    public static void signLetter(ItemStack letter, String author) {
        if(!letter.has(ModComponents.Letter_Author.get())) {
            letter.set(ModComponents.Letter_Author.get(), author);
        }
    }

    public static boolean canEditLetter(ItemStack letter) {
        return !letter.has(ModComponents.Letter_Author.get()) ;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player playerEntity, InteractionHand hand) {
        ItemStack letter = playerEntity.getItemInHand(hand);
        if(playerEntity.isCrouching()) {
            if(hand != InteractionHand.OFF_HAND) {
                ItemStack result = removeAttachment(letter);
                if(!result.isEmpty()) {
                    playerEntity.addItem(result);
                    if(world.isClientSide()) {
                        playerEntity.displayClientMessage(Component.translatable("msg.ls_furniture.letter.attachment_removed"), true);
                        playerEntity.playSound(ModSoundEvents.DETACH_TO_LETTER.get(), 1.0f, 1.0f);
                    }
                    return InteractionResultHolder.sidedSuccess(letter, world.isClientSide());
                }
                ItemStack offHandStack = playerEntity.getItemInHand(InteractionHand.OFF_HAND);
                if(!offHandStack.isEmpty()) {
                    result = addAttachment(letter, offHandStack);
                    playerEntity.setItemInHand(InteractionHand.OFF_HAND, result);
                    if(result.isEmpty()) {
                        if(world.isClientSide()) {
                            playerEntity.displayClientMessage(Component.translatable("msg.ls_furniture.letter.attachment_added", offHandStack.getItem().getDescription()), true);
                            playerEntity.playSound(ModSoundEvents.ATTACH_TO_LETTER.get(), 1.0f, 1.0f);
                        }
                        return InteractionResultHolder.sidedSuccess(letter, world.isClientSide());
                    }
                }
                return InteractionResultHolder.fail(letter);
            }
            return InteractionResultHolder.fail(letter);
        } else {
            if(world.isClientSide()) openGui(letter, playerEntity, hand);
            return InteractionResultHolder.sidedSuccess(letter, world.isClientSide());
        }
    }
}