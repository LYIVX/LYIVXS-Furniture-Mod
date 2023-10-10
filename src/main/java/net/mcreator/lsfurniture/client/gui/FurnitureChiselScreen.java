package net.mcreator.lsfurniture.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import net.mcreator.lsfurniture.world.inventory.FurnitureChiselMenu;
import net.mcreator.lsfurniture.procedures.DisablePictureToolProcedure;
import net.mcreator.lsfurniture.procedures.DisablePictureBlock1Procedure;
import net.mcreator.lsfurniture.network.FurnitureChiselButtonMessage;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class FurnitureChiselScreen extends AbstractContainerScreen<FurnitureChiselMenu> {
	private final static HashMap<String, Object> guistate = FurnitureChiselMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_question_mark;
	ImageButton imagebutton_tab_deselect1;
	ImageButton imagebutton_computer;
	ImageButton imagebutton_tab_deselect_left_edge;
	ImageButton imagebutton_oak_wood;
	ImageButton imagebutton_tab_deselect;
	ImageButton imagebutton_iron_ingot;
	ImageButton imagebutton_tab_deselect2;
	ImageButton imagebutton_toddys;

	public FurnitureChiselScreen(FurnitureChiselMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 212;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ls_furniture:textures/screens/furniture_chisel.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 27 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_chisel.tooltip_empty"), mouseX, mouseY);
		if (mouseX > leftPos + 36 && mouseX < leftPos + 60 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_chisel.tooltip_empty2"), mouseX, mouseY);
		if (mouseX > leftPos + 69 && mouseX < leftPos + 93 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_chisel.tooltip_empty3"), mouseX, mouseY);
		if (mouseX > leftPos + 13 && mouseX < leftPos + 37 && mouseY > topPos + 52 && mouseY < topPos + 76)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_chisel.tooltip_recipe_explainer"), mouseX, mouseY);
		if (mouseX > leftPos + 102 && mouseX < leftPos + 126 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_chisel.tooltip_decorations"), mouseX, mouseY);
		if (mouseX > leftPos + 135 && mouseX < leftPos + 159 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_chisel.tooltip_chisel"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (DisablePictureBlock1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/block.png"));
			this.blit(ms, this.leftPos + 18, this.topPos + 17, 0, 0, 14, 14, 14, 14);
		}
		if (DisablePictureToolProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/chisel_slot.png"));
			this.blit(ms, this.leftPos + 17, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/furniture_crafter_brown_background.png"));
		this.blit(ms, this.leftPos + 48, this.topPos + 7, 0, 0, 155, 74, 155, 74);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/tab_select.png"));
		this.blit(ms, this.leftPos + 131, this.topPos + -31, 0, 0, 32, 34, 32, 34);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/chisel.png"));
		this.blit(ms, this.leftPos + 135, this.topPos + -25, 0, 0, 24, 24, 24, 24);

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
		this.font.draw(poseStack, Component.translatable("gui.ls_furniture.furniture_chisel.label_furniture"), 8, 5, -12829636);
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
		imagebutton_question_mark = new ImageButton(this.leftPos + 17, this.topPos + 56, 16, 16, 0, 0, 16, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_question_mark.png"), 16, 32, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureChiselButtonMessage(0, x, y, z));
				FurnitureChiselButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_question_mark", imagebutton_question_mark);
		this.addRenderableWidget(imagebutton_question_mark);
		imagebutton_tab_deselect1 = new ImageButton(this.leftPos + 98, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect1.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureChiselButtonMessage(1, x, y, z));
				FurnitureChiselButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect1", imagebutton_tab_deselect1);
		this.addRenderableWidget(imagebutton_tab_deselect1);
		imagebutton_computer = new ImageButton(this.leftPos + 103, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_computer.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureChiselButtonMessage(2, x, y, z));
				FurnitureChiselButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_computer", imagebutton_computer);
		this.addRenderableWidget(imagebutton_computer);
		imagebutton_tab_deselect_left_edge = new ImageButton(this.leftPos + 0, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect_left_edge.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureChiselButtonMessage(3, x, y, z));
				FurnitureChiselButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect_left_edge", imagebutton_tab_deselect_left_edge);
		this.addRenderableWidget(imagebutton_tab_deselect_left_edge);
		imagebutton_oak_wood = new ImageButton(this.leftPos + 4, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_oak_wood.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureChiselButtonMessage(4, x, y, z));
				FurnitureChiselButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_oak_wood", imagebutton_oak_wood);
		this.addRenderableWidget(imagebutton_oak_wood);
		imagebutton_tab_deselect = new ImageButton(this.leftPos + 32, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureChiselButtonMessage(5, x, y, z));
				FurnitureChiselButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect", imagebutton_tab_deselect);
		this.addRenderableWidget(imagebutton_tab_deselect);
		imagebutton_iron_ingot = new ImageButton(this.leftPos + 36, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_iron_ingot.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureChiselButtonMessage(6, x, y, z));
				FurnitureChiselButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_iron_ingot", imagebutton_iron_ingot);
		this.addRenderableWidget(imagebutton_iron_ingot);
		imagebutton_tab_deselect2 = new ImageButton(this.leftPos + 65, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect2.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureChiselButtonMessage(7, x, y, z));
				FurnitureChiselButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect2", imagebutton_tab_deselect2);
		this.addRenderableWidget(imagebutton_tab_deselect2);
		imagebutton_toddys = new ImageButton(this.leftPos + 69, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_toddys.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureChiselButtonMessage(8, x, y, z));
				FurnitureChiselButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_toddys", imagebutton_toddys);
		this.addRenderableWidget(imagebutton_toddys);
	}
}
