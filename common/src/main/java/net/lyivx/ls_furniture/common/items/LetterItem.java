package net.lyivx.ls_furniture.common.items;

import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.lyivx.ls_furniture.registry.ModSoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
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
import net.minecraft.world.level.Level;

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
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltipComponents, TooltipFlag flag) {
        if(stack.hasTag()) {
            CompoundTag letterTag = stack.getTag();
            if(letterTag.contains("Author")) {
                tooltipComponents.add(Component.translatable("tooltip.ls_furniture.letter.author", letterTag.getString("Author")).withStyle(ChatFormatting.GRAY));
            }
            if(letterTag.contains("Attachment")) {
                ItemStack attachment = ItemStack.of(letterTag.getCompound("Attachment"));
                tooltipComponents.add(Component.translatable("tooltip.ls_furniture.letter.attachment", attachment.getItem().getDescription()).withStyle(ChatFormatting.GRAY));
            }
        }
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.ls_furniture.letter_add"));
            tooltipComponents.add(Component.translatable("tooltip.ls_furniture.letter_remove"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, level, tooltipComponents, flag);
    }

    public static ItemStack addAttachment(ItemStack letter, ItemStack attachment) {
        CompoundTag letterTag = letter.getOrCreateTag();
        if(!letterTag.contains("Attachment")) {
            CompoundTag attachmentTag = new CompoundTag();
            letterTag.put("Attachment", attachment.save(attachmentTag));
            letter.setTag(letterTag);
            return ItemStack.EMPTY;
        }
        return attachment;
    }

    public static ItemStack removeAttachment(ItemStack letter) {
        CompoundTag letterTag = letter.getOrCreateTag();
        if(letterTag.contains("Attachment")) {
            ItemStack attachment = ItemStack.of(letterTag.getCompound("Attachment"));
            letterTag.remove("Attachment");
            letter.setTag(letterTag);
            return attachment;
        }
        return ItemStack.EMPTY;
    }

    public static void signLetter(ItemStack letter, String author) {
        CompoundTag letterTag = letter.getOrCreateTag();
        if(!letterTag.contains("Author")) letterTag.putString("Author", author);
        letter.setTag(letterTag);
    }

    public static boolean canEditLetter(ItemStack letter) {
        CompoundTag letterTag = letter.getOrCreateTag();
        if(letterTag.contains("Author")) return false;
        return true;
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