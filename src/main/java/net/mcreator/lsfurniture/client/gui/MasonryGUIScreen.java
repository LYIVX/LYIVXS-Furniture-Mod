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

import net.mcreator.lsfurniture.world.inventory.MasonryGUIMenu;
import net.mcreator.lsfurniture.procedures.Disablepictureadditional3Procedure;
import net.mcreator.lsfurniture.procedures.Disablepictureadditional2Procedure;
import net.mcreator.lsfurniture.procedures.DisablePictureToolProcedure;
import net.mcreator.lsfurniture.procedures.DisablePictureDyeProcedure;
import net.mcreator.lsfurniture.procedures.DisablePictureBlock2Procedure;
import net.mcreator.lsfurniture.procedures.DisablePictureBlock1Procedure;
import net.mcreator.lsfurniture.procedures.DisablePictureAdditional4Procedure;
import net.mcreator.lsfurniture.procedures.CheckedProcedure;
import net.mcreator.lsfurniture.network.MasonryGUIButtonMessage;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class MasonryGUIScreen extends AbstractContainerScreen<MasonryGUIMenu> {
	private final static HashMap<String, Object> guistate = MasonryGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox Connected;
	ImageButton imagebutton_tab_deselect_left_edge;
	ImageButton imagebutton_tab_deselect;
	ImageButton imagebutton_tab_deselect1;
	ImageButton imagebutton_tab_deselect_right_edge_2;
	ImageButton imagebutton_oak_wood;
	ImageButton imagebutton_tab_select_right_edge_1;
	ImageButton imagebutton_stone;
	ImageButton imagebutton_iron_ingot;
	ImageButton imagebutton_wool;
	ImageButton imagebutton_arrow_left;
	ImageButton imagebutton_arrow_right;
	ImageButton imagebutton_comparitor;
	ImageButton imagebutton_arrow_left1;
	ImageButton imagebutton_arrow_right1;

	public MasonryGUIScreen(MasonryGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 188;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ls_furniture:textures/screens/masonry_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 27 && mouseY > topPos + -31 && mouseY < topPos + -7)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.masonry_gui.tooltip_carpentry"), mouseX, mouseY);
		if (mouseX > leftPos + 42 && mouseX < leftPos + 66 && mouseY > topPos + -31 && mouseY < topPos + -7)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.masonry_gui.tooltip_masonry"), mouseX, mouseY);
		if (mouseX > leftPos + 81 && mouseX < leftPos + 105 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.masonry_gui.tooltip_metalurgy"), mouseX, mouseY);
		if (mouseX > leftPos + 120 && mouseX < leftPos + 144 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.masonry_gui.tooltip_weavery"), mouseX, mouseY);
		if (mouseX > leftPos + 159 && mouseX < leftPos + 183 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.masonry_gui.tooltip_engineering"), mouseX, mouseY);
		if (mouseX > leftPos + 4 && mouseX < leftPos + 28 && mouseY > topPos + 44 && mouseY < topPos + 68)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.masonry_gui.tooltip_connected_textures"), mouseX, mouseY);
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

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/tab_right_horizontal_deselect.png"));
		this.blit(ms, this.leftPos + 181, this.topPos + 62, 0, 0, 16, 25, 16, 25);

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
		this.font.draw(poseStack, Component.translatable("gui.ls_furniture.masonry_gui.label_carpentry"), 5, -2, -12829636);
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
		imagebutton_tab_deselect_left_edge = new ImageButton(this.leftPos + 0, this.topPos + -35, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect_left_edge.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new MasonryGUIButtonMessage(0, x, y, z));
				MasonryGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect_left_edge", imagebutton_tab_deselect_left_edge);
		this.addRenderableWidget(imagebutton_tab_deselect_left_edge);
		imagebutton_tab_deselect = new ImageButton(this.leftPos + 78, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new MasonryGUIButtonMessage(1, x, y, z));
				MasonryGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect", imagebutton_tab_deselect);
		this.addRenderableWidget(imagebutton_tab_deselect);
		imagebutton_tab_deselect1 = new ImageButton(this.leftPos + 117, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect1.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new MasonryGUIButtonMessage(2, x, y, z));
				MasonryGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect1", imagebutton_tab_deselect1);
		this.addRenderableWidget(imagebutton_tab_deselect1);
		imagebutton_tab_deselect_right_edge_2 = new ImageButton(this.leftPos + 156, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect_right_edge_2.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new MasonryGUIButtonMessage(3, x, y, z));
				MasonryGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect_right_edge_2", imagebutton_tab_deselect_right_edge_2);
		this.addRenderableWidget(imagebutton_tab_deselect_right_edge_2);
		imagebutton_oak_wood = new ImageButton(this.leftPos + 4, this.topPos + -31, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_oak_wood.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new MasonryGUIButtonMessage(4, x, y, z));
				MasonryGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_oak_wood", imagebutton_oak_wood);
		this.addRenderableWidget(imagebutton_oak_wood);
		imagebutton_tab_select_right_edge_1 = new ImageButton(this.leftPos + 39, this.topPos + -37, 32, 40, 0, 0, 40, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_select_right_edge_1.png"), 32, 80, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new MasonryGUIButtonMessage(5, x, y, z));
				MasonryGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_select_right_edge_1", imagebutton_tab_select_right_edge_1);
		this.addRenderableWidget(imagebutton_tab_select_right_edge_1);
		imagebutton_stone = new ImageButton(this.leftPos + 43, this.topPos + -31, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_stone.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new MasonryGUIButtonMessage(6, x, y, z));
				MasonryGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_stone", imagebutton_stone);
		this.addRenderableWidget(imagebutton_stone);
		imagebutton_iron_ingot = new ImageButton(this.leftPos + 82, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_iron_ingot.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new MasonryGUIButtonMessage(7, x, y, z));
				MasonryGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_iron_ingot", imagebutton_iron_ingot);
		this.addRenderableWidget(imagebutton_iron_ingot);
		imagebutton_wool = new ImageButton(this.leftPos + 121, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_wool.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new MasonryGUIButtonMessage(8, x, y, z));
				MasonryGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_wool", imagebutton_wool);
		this.addRenderableWidget(imagebutton_wool);
		imagebutton_arrow_left = new ImageButton(this.leftPos + -15, this.topPos + -28, 11, 17, 0, 0, 17, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_arrow_left.png"), 11, 34, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new MasonryGUIButtonMessage(9, x, y, z));
				MasonryGUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_left", imagebutton_arrow_left);
		this.addRenderableWidget(imagebutton_arrow_left);
		imagebutton_arrow_right = new ImageButton(this.leftPos + 193, this.topPos + -22, 11, 17, 0, 0, 17, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_arrow_right.png"), 11, 34, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new MasonryGUIButtonMessage(10, x, y, z));
				MasonryGUIButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_right", imagebutton_arrow_right);
		this.addRenderableWidget(imagebutton_arrow_right);
		imagebutton_comparitor = new ImageButton(this.leftPos + 160, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_comparitor.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new MasonryGUIButtonMessage(11, x, y, z));
				MasonryGUIButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_comparitor", imagebutton_comparitor);
		this.addRenderableWidget(imagebutton_comparitor);
		imagebutton_arrow_left1 = new ImageButton(this.leftPos + 41, this.topPos + 65, 11, 17, 0, 0, 17, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_arrow_left1.png"), 11, 34, e -> {
		});
		guistate.put("button:imagebutton_arrow_left1", imagebutton_arrow_left1);
		this.addRenderableWidget(imagebutton_arrow_left1);
		imagebutton_arrow_right1 = new ImageButton(this.leftPos + 181, this.topPos + 66, 11, 17, 0, 0, 17, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_arrow_right1.png"), 11, 34, e -> {
		});
		guistate.put("button:imagebutton_arrow_right1", imagebutton_arrow_right1);
		this.addRenderableWidget(imagebutton_arrow_right1);
		Connected = new Checkbox(this.leftPos + 6, this.topPos + 46, 20, 20, Component.translatable("gui.ls_furniture.masonry_gui.Connected"),

				CheckedProcedure.execute());
		guistate.put("checkbox:Connected", Connected);
		this.addRenderableWidget(Connected);
	}
}
