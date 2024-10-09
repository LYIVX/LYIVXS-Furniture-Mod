package net.lyivx.ls_furniture.client.screens.widgets;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class CustomOptionsList extends ContainerObjectSelectionList<CustomOptionsList.Entry> {
    private static final int BIG_BUTTON_WIDTH = 310;
    private static final int DEFAULT_ITEM_HEIGHT = 25;
    private final OptionsSubScreen screen;

    public CustomOptionsList(Minecraft minecraft, int width, OptionsSubScreen screen) {
        super(minecraft, width, screen.layout.getContentHeight(), screen.layout.getHeaderHeight(), DEFAULT_ITEM_HEIGHT);
        this.centerListVertically = false;
        this.screen = screen;
    }

    public void addBig(OptionInstance<?> option) {
        this.addEntry(CustomOptionsList.OptionEntry.big(this.minecraft.options, option, this.screen));
    }

    public void addSmall(OptionInstance<?>... options) {
        for (int i = 0; i < options.length; i += 2) {
            OptionInstance<?> optionInstance = i < options.length - 1 ? options[i + 1] : null;
            this.addEntry(CustomOptionsList.OptionEntry.small(this.minecraft.options, options[i], optionInstance, this.screen));
        }
    }

    public void addSmall(List<AbstractWidget> options) {
        for (int i = 0; i < options.size(); i += 2) {
            this.addSmall(options.get(i), i < options.size() - 1 ? options.get(i + 1) : null);
        }
    }

    public void addSmall(AbstractWidget leftOption, @Nullable AbstractWidget rightOption) {
        this.addEntry(CustomOptionsList.Entry.small(leftOption, rightOption, this.screen));
    }

    public void addTitle(Component title) {
        this.addEntry(CustomOptionsList.TitleEntry.create(title, this.screen));
    }

    public int getRowWidth() {
        return BIG_BUTTON_WIDTH;
    }

    @Nullable
    public AbstractWidget findOption(OptionInstance<?> option) {
        for (Entry entry : this.children()) {
            if (entry instanceof OptionEntry optionEntry) {
                AbstractWidget abstractWidget = optionEntry.options.get(option);
                if (abstractWidget != null) {
                    return abstractWidget;
                }
            }
        }
        return null;
    }

    public Optional<GuiEventListener> getMouseOver(double mouseX, double mouseY) {
        for (Entry entry : this.children()) {
            for (GuiEventListener guiEventListener : entry.children()) {
                if (guiEventListener.isMouseOver(mouseX, mouseY)) {
                    return Optional.of(guiEventListener);
                }
            }
        }
        return Optional.empty();
    }

    @Environment(EnvType.CLIENT)
    protected static class OptionEntry extends Entry {
        final Map<OptionInstance<?>, AbstractWidget> options;

        private OptionEntry(Map<OptionInstance<?>, AbstractWidget> options, OptionsSubScreen screen) {
            super(ImmutableList.copyOf(options.values()), screen);
            this.options = options;
        }

        public static OptionEntry big(Options options, OptionInstance<?> option, OptionsSubScreen screen) {
            return new OptionEntry(ImmutableMap.of(option, option.createButton(options, 0, 0, BIG_BUTTON_WIDTH)), screen);
        }

        public static OptionEntry small(Options options, OptionInstance<?> leftOption, @Nullable OptionInstance<?> rightOption, OptionsSubScreen screen) {
            AbstractWidget abstractWidget = leftOption.createButton(options);
            return rightOption == null ? new OptionEntry(ImmutableMap.of(leftOption, abstractWidget), screen) : new OptionEntry(ImmutableMap.of(leftOption, abstractWidget, rightOption, rightOption.createButton(options)), screen);
        }
    }

    @Environment(EnvType.CLIENT)
    protected static class TitleEntry extends Entry {
        private final Component title;

        private TitleEntry(Component title, Screen screen) {
            super(ImmutableList.of(), screen);
            this.title = title;
        }

        public static TitleEntry create(Component title, Screen screen) {
            return new TitleEntry(title, screen);
        }

        @Override
        public void render(GuiGraphics guiGraphics, int index, int top, int left, int width, int height, int mouseX, int mouseY, boolean hovering, float partialTick) {
            guiGraphics.drawCenteredString(Minecraft.getInstance().font, this.title, left + width / 2, top + 5, 0xFFFFFF);
        }
    }

    @Environment(EnvType.CLIENT)
    protected static class Entry extends ContainerObjectSelectionList.Entry<Entry> {
        private final List<AbstractWidget> children;
        private final Screen screen;
        private static final int X_OFFSET = 160;

        Entry(List<AbstractWidget> children, Screen screen) {
            this.children = ImmutableList.copyOf(children);
            this.screen = screen;
        }

        public static Entry big(List<AbstractWidget> options, Screen screen) {
            return new Entry(options, screen);
        }

        public static Entry small(AbstractWidget leftOption, @Nullable AbstractWidget rightOption, Screen screen) {
            return rightOption == null ? new Entry(ImmutableList.of(leftOption), screen) : new Entry(ImmutableList.of(leftOption, rightOption), screen);
        }

        public void render(GuiGraphics guiGraphics, int index, int top, int left, int width, int height, int mouseX, int mouseY, boolean hovering, float partialTick) {
            int i = 80;
            int j = this.screen.width / 2 - 155;

            for (AbstractWidget abstractWidget : this.children) {
                abstractWidget.setPosition(j + i, top + 3);
                abstractWidget.render(guiGraphics, mouseX, mouseY, partialTick);
                i += X_OFFSET;
            }
        }

        public List<? extends GuiEventListener> children() {
            return this.children;
        }

        public List<? extends NarratableEntry> narratables() {
            return this.children;
        }
    }
}