package net.mcreator.lsfurniture.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.Minecraft;

import net.mcreator.lsfurniture.world.inventory.GlassblowerGUIMenu;
import net.mcreator.lsfurniture.procedures.Disablepictureadditional3Procedure;
import net.mcreator.lsfurniture.procedures.Disablepictureadditional2Procedure;
import net.mcreator.lsfurniture.procedures.DisablePictureToolProcedure;
import net.mcreator.lsfurniture.procedures.DisablePictureDyeProcedure;
import net.mcreator.lsfurniture.procedures.DisablePictureBlock2Procedure;
import net.mcreator.lsfurniture.procedures.DisablePictureBlock1Procedure;
import net.mcreator.lsfurniture.procedures.DisablePictureAdditional4Procedure;
import net.mcreator.lsfurniture.procedures.CheckedProcedure;
import net.mcreator.lsfurniture.network.GlassblowerGUIButtonMessage;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class GlassblowerGUIScreen extends AbstractContainerScreen<GlassblowerGUIMenu> {
	private final static HashMap<String, Object> guistate = GlassblowerGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox Connected;
	ImageButton imagebutton_tab_deselect_right_edge_3;
	ImageButton imagebutton_button;
	ImageButton imagebutton_book_brown;
	ImageButton imagebutton_arrow_left;
	ImageButton imagebutton_arrow_right;
	ImageButton imagebutton_tab_select_left_edge;
	ImageButton imagebutton_glass;
	ImageButton imagebutton_leaves;

	public GlassblowerGUIScreen(GlassblowerGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 188;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ls_furniture:textures/screens/glassblower_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 27 && mouseY > topPos + -31 && mouseY < topPos + -7)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.glassblower_gui.tooltip_carpentry"), mouseX, mouseY);
		if (mouseX > leftPos + 42 && mouseX < leftPos + 66 && mouseY > topPos + -31 && mouseY < topPos + -7)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.glassblower_gui.tooltip_masonry"), mouseX, mouseY);
		if (mouseX > leftPos + -25 && mouseX < leftPos + -1 && mouseY > topPos + -2 && mouseY < topPos + 22)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.glassblower_gui.tooltip_connected_textures"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/tab_large.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + -6, 0, 0, 68, 12, 68, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/furniture_crafter_brown_background_chisel.png"));
		this.blit(ms, this.leftPos + 53, this.topPos + 7, 0, 0, 127, 72, 127, 72);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/tab_horizontal_left_plain_deselect.png"));
		this.blit(ms, this.leftPos + -31, this.topPos + -6, 0, 0, 32, 32, 32, 32);

		if (DisablePictureBlock1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/block.png"));
			this.blit(ms, this.leftPos + 8, this.topPos + 8, 0, 0, 16, 16, 16, 16);
		}
		if (DisablePictureBlock2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/additional.png"));
			this.blit(ms, this.leftPos + 28, this.topPos + 8, 0, 0, 16, 16, 16, 16);
		}
		if (Disablepictureadditional2Procedure.execute(world, x, y, z, entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/dust.png"));
			this.blit(ms, this.leftPos + 8, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (Disablepictureadditional3Procedure.execute(world, x, y, z, entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/ingot_1.png"));
			this.blit(ms, this.leftPos + 8, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (DisablePictureAdditional4Procedure.execute(world, x, y, z, entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/bark_slot.png"));
			this.blit(ms, this.leftPos + 8, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (DisablePictureDyeProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/dye.png"));
			this.blit(ms, this.leftPos + 28, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (DisablePictureToolProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/chisel_slot.png"));
			this.blit(ms, this.leftPos + 28, this.topPos + 48, 0, 0, 16, 16, 16, 16);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.ls_furniture.glassblower_gui.label_carpentry"), 5, -2, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		imagebutton_tab_deselect_right_edge_3 = new ImageButton(this.leftPos + 39, this.topPos + -35, 32, 35, 0, 0, 35, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect_right_edge_3.png"), 32, 70, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new GlassblowerGUIButtonMessage(0, x, y, z));
				GlassblowerGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect_right_edge_3", imagebutton_tab_deselect_right_edge_3);
		this.addRenderableWidget(imagebutton_tab_deselect_right_edge_3);
		imagebutton_button = new ImageButton(this.leftPos + 6, this.topPos + 46, 20, 20, 0, 0, 20, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_button.png"), 20, 40, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new GlassblowerGUIButtonMessage(1, x, y, z));
				GlassblowerGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_button", imagebutton_button);
		this.addRenderableWidget(imagebutton_button);
		imagebutton_book_brown = new ImageButton(this.leftPos + 8, this.topPos + 48, 16, 16, 0, 0, 16, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_book_brown.png"), 16, 32, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new GlassblowerGUIButtonMessage(2, x, y, z));
				GlassblowerGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_book_brown", imagebutton_book_brown);
		this.addRenderableWidget(imagebutton_book_brown);
		imagebutton_arrow_left = new ImageButton(this.leftPos + -15, this.topPos + -28, 11, 17, 0, 0, 17, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_arrow_left.png"), 11, 34, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new GlassblowerGUIButtonMessage(3, x, y, z));
				GlassblowerGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_left", imagebutton_arrow_left);
		this.addRenderableWidget(imagebutton_arrow_left);
		imagebutton_arrow_right = new ImageButton(this.leftPos + 193, this.topPos + -22, 11, 17, 0, 0, 17, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_arrow_right.png"), 11, 34, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new GlassblowerGUIButtonMessage(4, x, y, z));
				GlassblowerGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_right", imagebutton_arrow_right);
		this.addRenderableWidget(imagebutton_arrow_right);
		imagebutton_tab_select_left_edge = new ImageButton(this.leftPos + 0, this.topPos + -37, 32, 35, 0, 0, 35, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_select_left_edge.png"), 32, 70, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new GlassblowerGUIButtonMessage(5, x, y, z));
				GlassblowerGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_select_left_edge", imagebutton_tab_select_left_edge);
		this.addRenderableWidget(imagebutton_tab_select_left_edge);
		imagebutton_glass = new ImageButton(this.leftPos + 4, this.topPos + -31, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_glass.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new GlassblowerGUIButtonMessage(6, x, y, z));
				GlassblowerGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_glass", imagebutton_glass);
		this.addRenderableWidget(imagebutton_glass);
		imagebutton_leaves = new ImageButton(this.leftPos + 43, this.topPos + -31, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_leaves.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new GlassblowerGUIButtonMessage(7, x, y, z));
				GlassblowerGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_leaves", imagebutton_leaves);
		this.addRenderableWidget(imagebutton_leaves);
		Connected = new Checkbox(this.leftPos + -23, this.topPos + 0, 20, 20, Component.translatable("gui.ls_furniture.glassblower_gui.Connected"),

				CheckedProcedure.execute());
		guistate.put("checkbox:Connected", Connected);
		this.addRenderableWidget(Connected);
	}
}
