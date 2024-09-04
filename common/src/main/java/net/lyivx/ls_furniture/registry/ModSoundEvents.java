package net.lyivx.ls_furniture.registry;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class ModSoundEvents {

    public static final ResourcefulRegistry<SoundEvent> SOUNDS = ResourcefulRegistries.create
            (BuiltInRegistries.SOUND_EVENT, LYIVXsFurnitureMod.MOD_ID);

    public static final Supplier<SoundEvent> DRAWER_OPEN = SOUNDS.register("block.drawer.open", () ->
            SoundEvent.createVariableRangeEvent(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block.drawer.open")));

    public static final Supplier<SoundEvent> DRAWER_CLOSE = SOUNDS.register("block.drawer.close", () ->
            SoundEvent.createVariableRangeEvent(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block.drawer.close")));

    public static final Supplier<SoundEvent> CHAIR_TUCK = SOUNDS.register("block.chair-stool.tuck", () ->
            SoundEvent.createVariableRangeEvent(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block.chair-stool.tuck")));

    public static final Supplier<SoundEvent> CHAIR_UNTUCK = SOUNDS.register("block.chair-stool.untuck", () ->
            SoundEvent.createVariableRangeEvent(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block.chair-stool.untuck")));

    public static final Supplier<SoundEvent> TOOL_USE = SOUNDS.register("item.tool.use", () ->
            SoundEvent.createVariableRangeEvent(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "item.tool.use")));

    public static final Supplier<SoundEvent> WORKSTATION_TAKE = SOUNDS.register("block.workstation.ui.take_result", () ->
            SoundEvent.createVariableRangeEvent(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block.workstation.ui.take_result")));

    public static final Supplier<SoundEvent> WORKSTATION_SELECT = SOUNDS.register("block.workstation.ui.select_recipe", () ->
            SoundEvent.createVariableRangeEvent(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block.workstation.ui.select_recipe")));

    public static final Supplier<SoundEvent> BLINDS = SOUNDS.register("block.blinds.use", () ->
            SoundEvent.createVariableRangeEvent(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block.blinds.use")));

    public static final Supplier<SoundEvent> ATTACH_TO_LETTER = SOUNDS.register("item.letter.add_attachment", () ->
            SoundEvent.createVariableRangeEvent(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "item.letter.add_attachment")));

    public static final Supplier<SoundEvent> DETACH_TO_LETTER = SOUNDS.register("item.letter.remove_attachment", () ->
            SoundEvent.createVariableRangeEvent(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "item.letter.remove_attachment")));

    public static final Supplier<SoundEvent> MAILBOX_UPDATE = SOUNDS.register("block.mailbox.update", () ->
            SoundEvent.createVariableRangeEvent(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block.mailbox.update")));

    public static final Supplier<SoundEvent> MAIL_RECEIVED = SOUNDS.register("event.mail_received", () ->
            SoundEvent.createVariableRangeEvent(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "event.mail_received")));

}