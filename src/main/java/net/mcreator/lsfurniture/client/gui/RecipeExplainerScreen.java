package net.mcreator.lsfurniture.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import net.mcreator.lsfurniture.world.inventory.RecipeExplainerMenu;
import net.mcreator.lsfurniture.network.RecipeExplainerButtonMessage;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class RecipeExplainerScreen extends AbstractContainerScreen<RecipeExplainerMenu> {
	private final static HashMap<String, Object> guistate = RecipeExplainerMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_tab_horizontal_right_deselect;
	ImageButton imagebutton_tab_deselect_right_edge;
	ImageButton imagebutton_toddys;
	ImageButton imagebutton_iron_ingot;
	ImageButton imagebutton_tab_horizontal_left_plain_desele;
	ImageButton imagebutton_computer;
	ImageButton imagebutton_tab_deselect;
	ImageButton imagebutton_oak_wood;

	public RecipeExplainerScreen(RecipeExplainerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 63;
		this.imageHeight = 84;
	}

	private static final ResourceLocation texture = new ResourceLocation("ls_furniture:textures/screens/recipe_explainer.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		if (mouseX > leftPos + 4 && mouseX < leftPos + 28 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.recipe_explainer.tooltip_wood"), mouseX, mouseY);
		if (mouseX > leftPos + 35 && mouseX < leftPos + 59 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.recipe_explainer.tooltip_metal"), mouseX, mouseY);
		if (mouseX > leftPos + 64 && mouseX < leftPos + 88 && mouseY > topPos + 4 && mouseY < topPos + 28)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.recipe_explainer.tooltip_teddys"), mouseX, mouseY);
		if (mouseX > leftPos + 6 && mouseX < leftPos + 30 && mouseY > topPos + 3 && mouseY < topPos + 27)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.recipe_explainer.tooltip_primary"), mouseX, mouseY);
		if (mouseX > leftPos + 33 && mouseX < leftPos + 57 && mouseY > topPos + 3 && mouseY < topPos + 27)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.recipe_explainer.tooltip_secondary"), mouseX, mouseY);
		if (mouseX > leftPos + 6 && mouseX < leftPos + 30 && mouseY > topPos + 30 && mouseY < topPos + 54)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.recipe_explainer.tooltip_additional"), mouseX, mouseY);
		if (mouseX > leftPos + 33 && mouseX < leftPos + 57 && mouseY > topPos + 30 && mouseY < topPos + 54)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.recipe_explainer.tooltip_dye"), mouseX, mouseY);
		if (mouseX > leftPos + 20 && mouseX < leftPos + 44 && mouseY > topPos + 55 && mouseY < topPos + 79)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.recipe_explainer.tooltip_tool"), mouseX, mouseY);
		if (mouseX > leftPos + 40 && mouseX < leftPos + 64 && mouseY > topPos + 55 && mouseY < topPos + 79)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.recipe_explainer.tooltip_clicking_the_recipe_button_will"), mouseX, mouseY);
		if (mouseX > leftPos + -25 && mouseX < leftPos + -1 && mouseY > topPos + 4 && mouseY < topPos + 28)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.recipe_explainer.tooltip_decorations"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/recipe_explainer_grid.png"));
		this.blit(ms, this.leftPos + -3, this.topPos + -12, 0, 0, 68, 113, 68, 113);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/block.png"));
		this.blit(ms, this.leftPos + 11, this.topPos + 8, 0, 0, 14, 14, 14, 14);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/block.png"));
		this.blit(ms, this.leftPos + 38, this.topPos + 8, 0, 0, 14, 14, 14, 14);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/ingot_1.png"));
		this.blit(ms, this.leftPos + 10, this.topPos + 34, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/dye.png"));
		this.blit(ms, this.leftPos + 37, this.topPos + 34, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/tool.png"));
		this.blit(ms, this.leftPos + 24, this.topPos + 60, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/question_mark.png"));
		this.blit(ms, this.leftPos + 43, this.topPos + 59, 0, 0, 16, 18, 16, 18);

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
		imagebutton_tab_horizontal_right_deselect = new ImageButton(this.leftPos + 60, this.topPos + 0, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_horizontal_right_deselect.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new RecipeExplainerButtonMessage(0, x, y, z));
				RecipeExplainerButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_horizontal_right_deselect", imagebutton_tab_horizontal_right_deselect);
		this.addRenderableWidget(imagebutton_tab_horizontal_right_deselect);
		imagebutton_tab_deselect_right_edge = new ImageButton(this.leftPos + 31, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect_right_edge.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new RecipeExplainerButtonMessage(1, x, y, z));
				RecipeExplainerButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect_right_edge", imagebutton_tab_deselect_right_edge);
		this.addRenderableWidget(imagebutton_tab_deselect_right_edge);
		imagebutton_toddys = new ImageButton(this.leftPos + 64, this.topPos + 4, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_toddys.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new RecipeExplainerButtonMessage(2, x, y, z));
				RecipeExplainerButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_toddys", imagebutton_toddys);
		this.addRenderableWidget(imagebutton_toddys);
		imagebutton_iron_ingot = new ImageButton(this.leftPos + 35, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_iron_ingot.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new RecipeExplainerButtonMessage(3, x, y, z));
				RecipeExplainerButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_iron_ingot", imagebutton_iron_ingot);
		this.addRenderableWidget(imagebutton_iron_ingot);
		imagebutton_tab_horizontal_left_plain_desele = new ImageButton(this.leftPos + -31, this.topPos + 0, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_horizontal_left_plain_desele.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new RecipeExplainerButtonMessage(4, x, y, z));
				RecipeExplainerButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_horizontal_left_plain_desele", imagebutton_tab_horizontal_left_plain_desele);
		this.addRenderableWidget(imagebutton_tab_horizontal_left_plain_desele);
		imagebutton_computer = new ImageButton(this.leftPos + -24, this.topPos + 4, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_computer.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new RecipeExplainerButtonMessage(5, x, y, z));
				RecipeExplainerButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_computer", imagebutton_computer);
		this.addRenderableWidget(imagebutton_computer);
		imagebutton_tab_deselect = new ImageButton(this.leftPos + 0, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new RecipeExplainerButtonMessage(6, x, y, z));
				RecipeExplainerButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect", imagebutton_tab_deselect);
		this.addRenderableWidget(imagebutton_tab_deselect);
		imagebutton_oak_wood = new ImageButton(this.leftPos + 5, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_oak_wood.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new RecipeExplainerButtonMessage(7, x, y, z));
				RecipeExplainerButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_oak_wood", imagebutton_oak_wood);
		this.addRenderableWidget(imagebutton_oak_wood);
	}
}
