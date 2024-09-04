package net.lyivx.ls_furniture.common.items;

import net.lyivx.ls_furniture.registry.ModSoundEvents;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WrenchItem extends Item {

    private double selectedPropertyIndex = 0;

    public WrenchItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.ls_furniture.wrench"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, level, tooltipComponents, flag);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        BlockState state = level.getBlockState(pos);

        if (state.getBlock() instanceof WrenchItem.WrenchableBlock wrenchBlock) {
            List<Property<?>> wrenchProperties = wrenchBlock.getWrenchableProperties();

            // Reset the property index if it's out of bounds
            if (wrenchProperties.isEmpty()) {
                return InteractionResult.PASS;
            }

            // Calculate the index based on the properties available for the block
            int numProperties = wrenchProperties.size();
            if (selectedPropertyIndex >= numProperties) {
                selectedPropertyIndex = 0;
            }

            boolean isShiftDown = player != null && player.isShiftKeyDown();
            boolean result = tryWrenchBlock(state, level, pos, player, hand, wrenchBlock, wrenchProperties, isShiftDown);
            return result ? InteractionResult.SUCCESS : InteractionResult.PASS;
        }

        return InteractionResult.PASS;
    }

    private String formatString(String input) {
        return Arrays.stream(input.replace("_", " ").split("\\s+"))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    private Property<?> getNextWrenchableProperty(BlockState state, List<Property<?>> properties) {
        if (properties.isEmpty()) return null;

        int currentIndex = properties.indexOf(state.getValues().keySet().stream()
                .filter(properties::contains)
                .findFirst()
                .orElse(null));

        return properties.get((currentIndex + 1) % properties.size());
    }

    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> T getNextPropertyValue(Property<T> property, T currentValue) {
        if (property instanceof BooleanProperty) {
            return (T) Boolean.valueOf(!((Boolean) currentValue));
        } else if (property instanceof EnumProperty) {
            Enum<?> currentEnum = (Enum<?>) currentValue;
            Enum<?>[] enumValues = ((EnumProperty<?>) property).getPossibleValues().toArray(new Enum[0]);
            int nextIndex = (Arrays.asList(enumValues).indexOf(currentEnum) + 1) % enumValues.length;
            return (T) enumValues[nextIndex];
        } else if (property instanceof IntegerProperty) {
            IntegerProperty intProperty = (IntegerProperty) property;
            int min = intProperty.getPossibleValues().stream().mapToInt(v -> (Integer) v).min().orElse(0);
            int max = intProperty.getPossibleValues().stream().mapToInt(v -> (Integer) v).max().orElse(0);
            int currentInt = (Integer) currentValue;
            int nextInt = (currentInt + 1 - min) % (max - min + 1) + min;
            return (T) Integer.valueOf(nextInt);
        }
        return currentValue; // This shouldn't happen for these properties
    }

    private boolean tryWrenchBlock(BlockState state, LevelAccessor level, BlockPos pos, Player player, InteractionHand hand, WrenchableBlock wrenchableBlock, List<Property<?>> wrenchProperties, boolean isShiftDown ) {
        List<Property<?>> wrenchableProperties = wrenchableBlock.getWrenchableProperties();

        if (wrenchableProperties.isEmpty()) return false;

        if (isShiftDown) {
            // Cycle through properties without changing values
            selectedPropertyIndex = (selectedPropertyIndex + 0.5) % wrenchableProperties.size();
            Property<?> nextProperty = wrenchableProperties.get((int) selectedPropertyIndex);

            // Send message to player about the selected property
            if (level instanceof Level && !((Level) level).isClientSide()) {
                String propertyName = formatString(nextProperty.getName());
                player.displayClientMessage(Component.literal("Selected: " + propertyName), true);
            }
        } else {
            // Change the value of the currently selected property
            Property<?> propertyToChange = wrenchableProperties.get((int) selectedPropertyIndex);
            if (propertyToChange != null && state.hasProperty(propertyToChange)) {
                state = cyclePropertyValue(state, propertyToChange);
                state = wrenchableBlock.updateAfterCycle(state, level, pos);
                level.setBlock(pos, state, 18); // Update block without notifying neighbors
                level.playSound(null, pos, getUseSound(), SoundSource.BLOCKS, 1.0f, 1.0f);

                // Send message to player about the property change
                if (level instanceof Level && !((Level) level).isClientSide()) {
                    String propertyName = formatString(propertyToChange.getName());
                    String value = formatString(getPropertyValueAsString(state, propertyToChange));
                    player.displayClientMessage(Component.literal(propertyName + ": " + value), true);
                }
            }
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> BlockState cyclePropertyValue(BlockState state, Property<T> property) {
        T currentValue = state.getValue(property);
        T nextValue = getNextPropertyValue(property, currentValue);
        return state.setValue(property, nextValue);
    }

    private <T extends Comparable<T>> String getPropertyValueAsString(BlockState state, Property<T> property) {
        return property.getName(state.getValue(property));
    }

    private SoundEvent getUseSound() {
        return ModSoundEvents.TOOL_USE.get();
    }

    public interface WrenchableBlock {
        List<Property<?>> getWrenchableProperties();
        default BlockState updateAfterCycle(BlockState state, LevelAccessor level, BlockPos pos) {
            return state;
        }
    }
}
