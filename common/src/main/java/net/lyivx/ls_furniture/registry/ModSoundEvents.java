package net.lyivx.ls_furniture.registry;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;

public class ModSoundEvents {

    public static final ResourcefulRegistry<SoundEvent> SOUNDS = ResourcefulRegistries.create
            (BuiltInRegistries.SOUND_EVENT, LYIVXsFurnitureMod.MOD_ID);

    public static final Supplier<SoundEvent> DRAWER_OPEN = SOUNDS.register("block.drawer.open", () ->
            SoundEvent.createVariableRangeEvent(createResourceLocation("block.drawer.open")));

    public static final Supplier<SoundEvent> DRAWER_CLOSE = SOUNDS.register("block.drawer.close", () ->
            SoundEvent.createVariableRangeEvent(createResourceLocation("block.drawer.close")));

    public static final Supplier<SoundEvent> CHAIR_TUCK = SOUNDS.register("block.chair-stool.tuck", () ->
            SoundEvent.createVariableRangeEvent(createResourceLocation("block.chair-stool.tuck")));

    public static final Supplier<SoundEvent> CHAIR_UNTUCK = SOUNDS.register("block.chair-stool.untuck", () ->
            SoundEvent.createVariableRangeEvent(createResourceLocation("block.chair-stool.untuck")));

    public static final Supplier<SoundEvent> TOOL_USE = SOUNDS.register("item.tool.use", () ->
            SoundEvent.createVariableRangeEvent(createResourceLocation("item.tool.use")));

    public static final Supplier<SoundEvent> WORKSTATION_TAKE = SOUNDS.register("block.workstation.ui.take_result", () ->
            SoundEvent.createVariableRangeEvent(createResourceLocation("block.workstation.ui.take_result")));

    public static final Supplier<SoundEvent> WORKSTATION_SELECT = SOUNDS.register("block.workstation.ui.select_recipe", () ->
            SoundEvent.createVariableRangeEvent(createResourceLocation("block.workstation.ui.select_recipe")));

    public static final Supplier<SoundEvent> BLINDS = SOUNDS.register("block.blinds.use", () ->
            SoundEvent.createVariableRangeEvent(createResourceLocation("block.blinds.use")));

    public static final Supplier<SoundEvent> ATTACH_TO_LETTER = SOUNDS.register("item.letter.add_attachment", () ->
            SoundEvent.createVariableRangeEvent(createResourceLocation("item.letter.add_attachment")));

    public static final Supplier<SoundEvent> DETACH_TO_LETTER = SOUNDS.register("item.letter.remove_attachment", () ->
            SoundEvent.createVariableRangeEvent(createResourceLocation("item.letter.remove_attachment")));

    public static final Supplier<SoundEvent> MAILBOX_UPDATE = SOUNDS.register("block.mailbox.update", () ->
            SoundEvent.createVariableRangeEvent(createResourceLocation("block.mailbox.update")));

    public static final Supplier<SoundEvent> MAIL_RECEIVED = SOUNDS.register("event.mail_received", () ->
            SoundEvent.createVariableRangeEvent(createResourceLocation("event.mail_received")));

}