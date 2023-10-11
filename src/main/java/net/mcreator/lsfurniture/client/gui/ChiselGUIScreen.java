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

import net.mcreator.lsfurniture.world.inventory.ChiselGUIMenu;
import net.mcreator.lsfurniture.procedures.DisablePicyureToolChiselProcedure;
import net.mcreator.lsfurniture.procedures.DisablePictureBlock1Procedure;
import net.mcreator.lsfurniture.procedures.DisablePictureAdditionalChisel4Procedure;
import net.mcreator.lsfurniture.procedures.DisablePictureAdditionalChisel3Procedure;
import net.mcreator.lsfurniture.procedures.DisablePictureAdditionalChisel2Procedure;
import net.mcreator.lsfurniture.procedures.CheckedProcedure;
import net.mcreator.lsfurniture.network.ChiselGUIButtonMessage;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ChiselGUIScreen extends AbstractContainerScreen<ChiselGUIMenu> {
	private final static HashMap<String, Object> guistate = ChiselGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox Connected;
	ImageButton imagebutton_book_brown;
	ImageButton imagebutton_tab_deselect_right_edge;
	ImageButton imagebutton_tab_deselect;
	ImageButton imagebutton_tab_deselect1;
	ImageButton imagebutton_tab_deselect_left_edge;
	ImageButton imagebutton_tab_select;
	ImageButton imagebutton_oak_wood;
	ImageButton imagebutton_iron_ingot;
	ImageButton imagebutton_computer;
	ImageButton imagebutton_toddys;
	ImageButton imagebutton_chisel;

	public ChiselGUIScreen(ChiselGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ls_furniture:textures/screens/chisel_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 27 && mouseY > topPos + -31 && mouseY < topPos + -7)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.chisel_gui.tooltip_wood"), mouseX, mouseY);
		if (mouseX > leftPos + 39 && mouseX < leftPos + 63 && mouseY > topPos + -31 && mouseY < topPos + -7)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.chisel_gui.tooltip_metal"), mouseX, mouseY);
		if (mouseX > leftPos + 75 && mouseX < leftPos + 99 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.chisel_gui.tooltip_decorations"), mouseX, mouseY);
		if (mouseX > leftPos + 111 && mouseX < leftPos + 135 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.chisel_gui.tooltip_teddys"), mouseX, mouseY);
		if (mouseX > leftPos + 147 && mouseX < leftPos + 171 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.chisel_gui.tooltip_chisel"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/tab_select_right.png"));
		this.blit(ms, this.leftPos + 172, this.topPos + 0, 0, 0, 22, 32, 22, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/tab_large.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + -6, 0, 0, 68, 12, 68, 12);

		if (DisablePictureBlock1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/block.png"));
			this.blit(ms, this.leftPos + 13, this.topPos + 25, 0, 0, 16, 16, 16, 16);
		}
		if (DisablePicyureToolChiselProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/chisel_slot.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 45, 0, 0, 16, 16, 16, 16);
		}
		if (DisablePictureAdditionalChisel2Procedure.execute(world, x, y, z, entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/bark_slot.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 25, 0, 0, 16, 16, 16, 16);
		}
		if (DisablePictureAdditionalChisel3Procedure.execute(world, x, y, z, entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/ingot_1.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 25, 0, 0, 16, 16, 16, 16);
		}
		if (DisablePictureAdditionalChisel4Procedure.execute(world, x, y, z, entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/dust.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 25, 0, 0, 16, 16, 16, 16);
		}

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/tab.png"));
		this.blit(ms, this.leftPos + -97, this.topPos + 27, 0, 0, 96, 32, 96, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/tab_select_right.png"));
		this.blit(ms, this.leftPos + 172, this.topPos + 54, 0, 0, 22, 32, 22, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/tab_select_right_2.png"));
		this.blit(ms, this.leftPos + 172, this.topPos + 27, 0, 0, 22, 32, 22, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/furniture_crafter_brown_background_chisel.png"));
		this.blit(ms, this.leftPos + 60, this.topPos + 7, 0, 0, 127, 72, 127, 72);

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
		this.font.draw(poseStack, Component.translatable("gui.ls_furniture.chisel_gui.label_wood"), 5, -2, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.ls_furniture.chisel_gui.label_connected"), -83, 34, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.ls_furniture.chisel_gui.label_textures"), -83, 45, -12829636);
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
		imagebutton_book_brown = new ImageButton(this.leftPos + 14, this.topPos + 45, 16, 16, 0, 0, 16, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_book_brown.png"), 16, 32, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new ChiselGUIButtonMessage(0, x, y, z));
				ChiselGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_book_brown", imagebutton_book_brown);
		this.addRenderableWidget(imagebutton_book_brown);
		imagebutton_tab_deselect_right_edge = new ImageButton(this.leftPos + 36, this.topPos + -35, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect_right_edge.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new ChiselGUIButtonMessage(1, x, y, z));
				ChiselGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect_right_edge", imagebutton_tab_deselect_right_edge);
		this.addRenderableWidget(imagebutton_tab_deselect_right_edge);
		imagebutton_tab_deselect = new ImageButton(this.leftPos + 72, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new ChiselGUIButtonMessage(2, x, y, z));
				ChiselGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect", imagebutton_tab_deselect);
		this.addRenderableWidget(imagebutton_tab_deselect);
		imagebutton_tab_deselect1 = new ImageButton(this.leftPos + 108, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect1.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new ChiselGUIButtonMessage(3, x, y, z));
				ChiselGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect1", imagebutton_tab_deselect1);
		this.addRenderableWidget(imagebutton_tab_deselect1);
		imagebutton_tab_deselect_left_edge = new ImageButton(this.leftPos + 0, this.topPos + -35, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect_left_edge.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new ChiselGUIButtonMessage(4, x, y, z));
				ChiselGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect_left_edge", imagebutton_tab_deselect_left_edge);
		this.addRenderableWidget(imagebutton_tab_deselect_left_edge);
		imagebutton_tab_select = new ImageButton(this.leftPos + 144, this.topPos + -31, 32, 34, 0, 0, 34, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_select.png"), 32, 68, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new ChiselGUIButtonMessage(5, x, y, z));
				ChiselGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_select", imagebutton_tab_select);
		this.addRenderableWidget(imagebutton_tab_select);
		imagebutton_oak_wood = new ImageButton(this.leftPos + 4, this.topPos + -31, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_oak_wood.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new ChiselGUIButtonMessage(6, x, y, z));
				ChiselGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_oak_wood", imagebutton_oak_wood);
		this.addRenderableWidget(imagebutton_oak_wood);
		imagebutton_iron_ingot = new ImageButton(this.leftPos + 40, this.topPos + -31, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_iron_ingot.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new ChiselGUIButtonMessage(7, x, y, z));
				ChiselGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_iron_ingot", imagebutton_iron_ingot);
		this.addRenderableWidget(imagebutton_iron_ingot);
		imagebutton_computer = new ImageButton(this.leftPos + 76, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_computer.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new ChiselGUIButtonMessage(8, x, y, z));
				ChiselGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_computer", imagebutton_computer);
		this.addRenderableWidget(imagebutton_computer);
		imagebutton_toddys = new ImageButton(this.leftPos + 112, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_toddys.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new ChiselGUIButtonMessage(9, x, y, z));
				ChiselGUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:imagebutton_toddys", imagebutton_toddys);
		this.addRenderableWidget(imagebutton_toddys);
		imagebutton_chisel = new ImageButton(this.leftPos + 148, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_chisel.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new ChiselGUIButtonMessage(10, x, y, z));
				ChiselGUIButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_chisel", imagebutton_chisel);
		this.addRenderableWidget(imagebutton_chisel);
		Connected = new Checkbox(this.leftPos + -27, this.topPos + 33, 20, 20, Component.translatable("gui.ls_furniture.chisel_gui.Connected"),

				CheckedProcedure.execute());
		guistate.put("checkbox:Connected", Connected);
		this.addRenderableWidget(Connected);
	}
}
