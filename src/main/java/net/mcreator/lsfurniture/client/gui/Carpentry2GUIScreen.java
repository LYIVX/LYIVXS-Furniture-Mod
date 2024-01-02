package net.mcreator.lsfurniture.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Checkbox;

import net.mcreator.lsfurniture.world.inventory.Carpentry2GUIMenu;
import net.mcreator.lsfurniture.procedures.Disablepictureadditional3Procedure;
import net.mcreator.lsfurniture.procedures.Disablepictureadditional2Procedure;
import net.mcreator.lsfurniture.procedures.DisablePictureToolProcedure;
import net.mcreator.lsfurniture.procedures.DisablePictureDyeProcedure;
import net.mcreator.lsfurniture.procedures.DisablePictureBlock2Procedure;
import net.mcreator.lsfurniture.procedures.DisablePictureBlock1Procedure;
import net.mcreator.lsfurniture.procedures.DisablePictureAdditional4Procedure;
import net.mcreator.lsfurniture.procedures.CheckedProcedure;
import net.mcreator.lsfurniture.network.Carpentry2GUIButtonMessage;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class Carpentry2GUIScreen extends AbstractContainerScreen<Carpentry2GUIMenu> {
	private final static HashMap<String, Object> guistate = Carpentry2GUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox Connected;
	ImageButton imagebutton_tab_deselect;
	ImageButton imagebutton_tab_deselect1;
	ImageButton imagebutton_tab_select_left_edge;
	ImageButton imagebutton_tab_deselect_right_edge_2;
	ImageButton imagebutton_tab_deselect_right_edge_3;
	ImageButton imagebutton_oak_wood;
	ImageButton imagebutton_stone;
	ImageButton imagebutton_iron_ingot;
	ImageButton imagebutton_wool;
	ImageButton imagebutton_arrow_left;
	ImageButton imagebutton_arrow_right;
	ImageButton imagebutton_comparitor;

	public Carpentry2GUIScreen(Carpentry2GUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 188;
		this.imageHeight = 152;
	}

	private static final ResourceLocation texture = new ResourceLocation("ls_furniture:textures/screens/carpentry_2_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		if (mouseX > leftPos + 4 && mouseX < leftPos + 28 && mouseY > topPos + -32 && mouseY < topPos + -8)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.carpentry_2_gui.tooltip_carpentry"), mouseX, mouseY);
		if (mouseX > leftPos + 43 && mouseX < leftPos + 67 && mouseY > topPos + -31 && mouseY < topPos + -7)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.carpentry_2_gui.tooltip_masonry"), mouseX, mouseY);
		if (mouseX > leftPos + 82 && mouseX < leftPos + 106 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.carpentry_2_gui.tooltip_metalurgy"), mouseX, mouseY);
		if (mouseX > leftPos + 121 && mouseX < leftPos + 145 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.carpentry_2_gui.tooltip_weavery"), mouseX, mouseY);
		if (mouseX > leftPos + 160 && mouseX < leftPos + 184 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.carpentry_2_gui.tooltip_engineering"), mouseX, mouseY);
		if (mouseX > leftPos + 4 && mouseX < leftPos + 28 && mouseY > topPos + 43 && mouseY < topPos + 67)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.carpentry_2_gui.tooltip_connected_textures"), mouseX, mouseY);
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
		this.blit(ms, this.leftPos + 227, this.topPos + 44, 0, 0, 127, 72, 127, 72);

		if (DisablePictureBlock1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/block.png"));
			this.blit(ms, this.leftPos + 8, this.topPos + 7, 0, 0, 16, 16, 16, 16);
		}
		if (DisablePictureBlock2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/additional.png"));
			this.blit(ms, this.leftPos + 28, this.topPos + 7, 0, 0, 16, 16, 16, 16);
		}
		if (Disablepictureadditional2Procedure.execute(world, x, y, z, entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/dust.png"));
			this.blit(ms, this.leftPos + 8, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (Disablepictureadditional3Procedure.execute(world, x, y, z, entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/ingot_1.png"));
			this.blit(ms, this.leftPos + 8, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (DisablePictureAdditional4Procedure.execute(world, x, y, z, entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/bark_slot.png"));
			this.blit(ms, this.leftPos + 8, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (DisablePictureDyeProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/dye.png"));
			this.blit(ms, this.leftPos + 28, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (DisablePictureToolProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/tool.png"));
			this.blit(ms, this.leftPos + 28, this.topPos + 47, 0, 0, 16, 16, 16, 16);
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
		this.font.draw(poseStack, Component.translatable("gui.ls_furniture.carpentry_2_gui.label_carpentry"), 5, -4, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_tab_deselect = new ImageButton(this.leftPos + 78, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new Carpentry2GUIButtonMessage(0, x, y, z));
				Carpentry2GUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect", imagebutton_tab_deselect);
		this.addRenderableWidget(imagebutton_tab_deselect);
		imagebutton_tab_deselect1 = new ImageButton(this.leftPos + 117, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect1.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new Carpentry2GUIButtonMessage(1, x, y, z));
				Carpentry2GUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect1", imagebutton_tab_deselect1);
		this.addRenderableWidget(imagebutton_tab_deselect1);
		imagebutton_tab_select_left_edge = new ImageButton(this.leftPos + 0, this.topPos + -37, 32, 35, 0, 0, 35, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_select_left_edge.png"), 32, 70, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new Carpentry2GUIButtonMessage(2, x, y, z));
				Carpentry2GUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_select_left_edge", imagebutton_tab_select_left_edge);
		this.addRenderableWidget(imagebutton_tab_select_left_edge);
		imagebutton_tab_deselect_right_edge_2 = new ImageButton(this.leftPos + 156, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect_right_edge_2.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new Carpentry2GUIButtonMessage(3, x, y, z));
				Carpentry2GUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect_right_edge_2", imagebutton_tab_deselect_right_edge_2);
		this.addRenderableWidget(imagebutton_tab_deselect_right_edge_2);
		imagebutton_tab_deselect_right_edge_3 = new ImageButton(this.leftPos + 39, this.topPos + -35, 32, 35, 0, 0, 35, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect_right_edge_3.png"), 32, 70, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new Carpentry2GUIButtonMessage(4, x, y, z));
				Carpentry2GUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect_right_edge_3", imagebutton_tab_deselect_right_edge_3);
		this.addRenderableWidget(imagebutton_tab_deselect_right_edge_3);
		imagebutton_oak_wood = new ImageButton(this.leftPos + 4, this.topPos + -32, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_oak_wood.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new Carpentry2GUIButtonMessage(5, x, y, z));
				Carpentry2GUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_oak_wood", imagebutton_oak_wood);
		this.addRenderableWidget(imagebutton_oak_wood);
		imagebutton_stone = new ImageButton(this.leftPos + 43, this.topPos + -31, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_stone.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new Carpentry2GUIButtonMessage(6, x, y, z));
				Carpentry2GUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_stone", imagebutton_stone);
		this.addRenderableWidget(imagebutton_stone);
		imagebutton_iron_ingot = new ImageButton(this.leftPos + 82, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_iron_ingot.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new Carpentry2GUIButtonMessage(7, x, y, z));
				Carpentry2GUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_iron_ingot", imagebutton_iron_ingot);
		this.addRenderableWidget(imagebutton_iron_ingot);
		imagebutton_wool = new ImageButton(this.leftPos + 121, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_wool.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new Carpentry2GUIButtonMessage(8, x, y, z));
				Carpentry2GUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_wool", imagebutton_wool);
		this.addRenderableWidget(imagebutton_wool);
		imagebutton_arrow_left = new ImageButton(this.leftPos + -16, this.topPos + -35, 11, 17, 0, 0, 17, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_arrow_left.png"), 11, 34, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new Carpentry2GUIButtonMessage(9, x, y, z));
				Carpentry2GUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_left", imagebutton_arrow_left);
		this.addRenderableWidget(imagebutton_arrow_left);
		imagebutton_arrow_right = new ImageButton(this.leftPos + 192, this.topPos + -29, 11, 17, 0, 0, 17, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_arrow_right.png"), 11, 34, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new Carpentry2GUIButtonMessage(10, x, y, z));
				Carpentry2GUIButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_right", imagebutton_arrow_right);
		this.addRenderableWidget(imagebutton_arrow_right);
		imagebutton_comparitor = new ImageButton(this.leftPos + 160, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_comparitor.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new Carpentry2GUIButtonMessage(11, x, y, z));
				Carpentry2GUIButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_comparitor", imagebutton_comparitor);
		this.addRenderableWidget(imagebutton_comparitor);
		Connected = new Checkbox(this.leftPos + 6, this.topPos + 45, 20, 20, Component.translatable("gui.ls_furniture.carpentry_2_gui.Connected"),

				CheckedProcedure.execute());
		guistate.put("checkbox:Connected", Connected);
		this.addRenderableWidget(Connected);
	}
}
