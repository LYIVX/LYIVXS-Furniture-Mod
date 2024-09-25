package net.lyivx.ls_furniture.client.screens;

import dev.architectury.networking.NetworkManager;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.items.LetterItem;
import net.lyivx.ls_furniture.common.network.ServerboundLetterUpdateMessage;
import net.lyivx.ls_furniture.registry.ModComponents;
import net.minecraft.SharedConstants;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.font.TextFieldHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringUtil;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;

public class LetterScreen extends Screen {
    private static final Component SCREEN_NAME = Component.translatable("item.ls_furniture.letter");
    private static final Component SIGN_LETTER = Component.translatable("book.signButton");
    private static final ResourceLocation LETTER_BACKGROUND = createResourceLocation("textures/gui/letter.png");

    // Max length is 16 lines of 18 characters
    private static final int LETTER_MAX_LENGTH = 288;

    private InteractionHand hand;
    private ItemStack letter;
    private Player playerEntity;
    private boolean editable = false;
    private String letterText;
    private TextFieldHelper letterEdit = null;
    private int frameTick = 0;

    public LetterScreen(ItemStack letter, Player playerEntity, InteractionHand hand) {
        super(SCREEN_NAME);
        this.hand = hand;
        this.letter = letter;
        this.playerEntity = playerEntity;
        letterText = letter.has(ModComponents.Letter_Text.get()) ? letter.get(ModComponents.Letter_Text.get()) : "";
        editable = LetterItem.canEditLetter(letter);
        if(editable) {
            letterEdit = new TextFieldHelper(this::getText, this::setText, this::getClipboard, this::setClipboard, (s) -> s.length() < LETTER_MAX_LENGTH);
        }
    }

    private void setClipboard(String s) {
        if (this.minecraft != null) {
            TextFieldHelper.setClipboardContents(this.minecraft, s);
        }
    }

    private String getClipboard() {
        return this.minecraft != null ? TextFieldHelper.getClipboardContents(this.minecraft) : "";
    }

    private String getText() {
        return letterText;
    }

    private void setText(String s) {
        letterText = s;
    }

    private void sendUpdate(Optional<String> author) {
        int slot = this.hand == InteractionHand.MAIN_HAND ? this.playerEntity.getInventory().selected : Inventory.SLOT_OFFHAND;
        NetworkManager.sendToServer(new ServerboundLetterUpdateMessage(slot, getText(), author));
    }

    @Override
    protected void init() {
        super.init();
        if(editable) {
            this.addRenderableWidget(Button.builder(SIGN_LETTER, (button) -> {
                sendUpdate(Optional.of(playerEntity.getGameProfile().getName()));
                this.minecraft.setScreen(null);
            }).bounds(this.width / 2 - 102, 196, 100, 20).build());
            this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, (button) -> {
                sendUpdate(Optional.empty());
                this.minecraft.setScreen(null);
            }).bounds(this.width / 2 + 2, 196, 100, 20).build());
        } else {
            this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, (button) -> {
                this.minecraft.setScreen(null);
            }).bounds(this.width / 2 - 50, 196, 100, 20).build());
        }
    }

    @Override
    public boolean charTyped(char c, int n) {
        if(super.charTyped(c, n)) {
            return true;
        }
        if(editable && StringUtil.isAllowedChatCharacter(c)) {
            letterEdit.insertText(Character.toString(c));
            return true;
        }
        return false;
    }

    @Override
    public boolean keyPressed(int key, int m, int n) {
        if(key == 256 && shouldCloseOnEsc()) {
            onClose();
            return true;
        }
        if(editable) {
            if(Screen.isSelectAll(key)) {
                letterEdit.selectAll();
                return true;
            } else if(Screen.isCopy(key)) {
                letterEdit.copy();
                return true;
            } else if(Screen.isCut(key)) {
                letterEdit.cut();
                return true;
            } else if(Screen.isPaste(key)) {
                letterEdit.paste();
                return true;
            } else {
                switch(key) {
                    case 257:
                    case 335:
                        letterEdit.insertText("\n");
                        return true;
                    case 259:
                        letterEdit.removeCharsFromCursor(-1);
                        return true;
                    default:
                        return false;
                }
            }
        }
        return false;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.setFocused((GuiEventListener)null);
        int startX = (this.width - 192) / 2;
        guiGraphics.blit(LETTER_BACKGROUND, startX, 2, 0, 0, 192, 192);

        // text and cursor rendering
        if(editable) {
            if(frameTick / 6 % 2 == 0) {
                guiGraphics.drawWordWrap(font, Component.literal(letterText).append("_"), startX + 36, 20, 108, 0);
            } else {
                guiGraphics.drawWordWrap(font, Component.literal(letterText).append(" "), startX + 36, 20, 108, 0);
            }
        } else {
            guiGraphics.drawWordWrap(font, Component.literal(letterText), startX + 36, 20, 108, 0);
        }

        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void tick() {
        super.tick();
        if(editable) ++frameTick;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    @Override
    public void onClose() {
        super.onClose();
    }
}