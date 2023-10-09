package net.mcreator.lsfurniture.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import net.mcreator.lsfurniture.world.inventory.FurnitureMetalMenu;
import net.mcreator.lsfurniture.network.FurnitureMetalButtonMessage;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class FurnitureMetalScreen extends AbstractContainerScreen<FurnitureMetalMenu> {
	private final static HashMap<String, Object> guistate = FurnitureMetalMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_tab_deselect2;
	ImageButton imagebutton_furniture_crafter_button_default;
	ImageButton imagebutton_furniture_crafter_button_default1;
	ImageButton imagebutton_furniture_crafter_button_default2;
	ImageButton imagebutton_furniture_crafter_button_default3;
	ImageButton imagebutton_furniture_crafter_button_default4;
	ImageButton imagebutton_furniture_crafter_button_default5;
	ImageButton imagebutton_furniture_crafter_button_default6;
	ImageButton imagebutton_tab_deselect_left_edge;
	ImageButton imagebutton_oak_wood;
	ImageButton imagebutton_toddys;
	ImageButton imagebutton_question_mark;
	ImageButton imagebutton_furniture_crafter_button_default7;
	ImageButton imagebutton_furniture_crafter_button_default8;
	ImageButton imagebutton_furniture_crafter_button_default9;
	ImageButton imagebutton_tab_deselect3;
	ImageButton imagebutton_computer;

	public FurnitureMetalScreen(FurnitureMetalMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 276;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ls_furniture:textures/screens/furniture_metal.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 27 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_metal.tooltip_empty"), mouseX, mouseY);
		if (mouseX > leftPos + 36 && mouseX < leftPos + 60 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_metal.tooltip_empty2"), mouseX, mouseY);
		if (mouseX > leftPos + 69 && mouseX < leftPos + 93 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_metal.tooltip_empty3"), mouseX, mouseY);
		if (mouseX > leftPos + 18 && mouseX < leftPos + 42 && mouseY > topPos + 107 && mouseY < topPos + 131)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_metal.tooltip_recipe_explainer"), mouseX, mouseY);
		if (mouseX > leftPos + 102 && mouseX < leftPos + 126 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_metal.tooltip_decorations"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/furniture_crafter_brown_background.png"));
		this.blit(ms, this.leftPos + 60, this.topPos + 8, 0, 0, 155, 74, 155, 74);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/triangle_arrow_down.png"));
		this.blit(ms, this.leftPos + 22, this.topPos + 71, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/triangle_arrow_down.png"));
		this.blit(ms, this.leftPos + 238, this.topPos + 71, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/tab_select.png"));
		this.blit(ms, this.leftPos + 32, this.topPos + -31, 0, 0, 32, 34, 32, 34);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/iron_ingot.png"));
		this.blit(ms, this.leftPos + 36, this.topPos + -25, 0, 0, 24, 24, 24, 24);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/block.png"));
		this.blit(ms, this.leftPos + 14, this.topPos + 18, 0, 0, 14, 14, 14, 14);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/block.png"));
		this.blit(ms, this.leftPos + 32, this.topPos + 18, 0, 0, 14, 14, 14, 14);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/dye.png"));
		this.blit(ms, this.leftPos + 31, this.topPos + 35, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/ingot_1.png"));
		this.blit(ms, this.leftPos + 13, this.topPos + 35, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/tool.png"));
		this.blit(ms, this.leftPos + 22, this.topPos + 53, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, Component.translatable("gui.ls_furniture.furniture_metal.label_furniture"), 14, 6, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.ls_furniture.furniture_metal.label_recipe"), 230, 6, -12829636);
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
		imagebutton_tab_deselect2 = new ImageButton(this.leftPos + 65, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect2.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(0, x, y, z));
				FurnitureMetalButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect2", imagebutton_tab_deselect2);
		this.addRenderableWidget(imagebutton_tab_deselect2);
		imagebutton_furniture_crafter_button_default = new ImageButton(this.leftPos + 61, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default.png"), 17, 36, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(1, x, y, z));
				FurnitureMetalButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_furniture_crafter_button_default", imagebutton_furniture_crafter_button_default);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default);
		imagebutton_furniture_crafter_button_default1 = new ImageButton(this.leftPos + 78, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default1.png"), 17, 36,
				e -> {
					if (true) {
						LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(2, x, y, z));
						FurnitureMetalButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default1", imagebutton_furniture_crafter_button_default1);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default1);
		imagebutton_furniture_crafter_button_default2 = new ImageButton(this.leftPos + 95, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default2.png"), 17, 36,
				e -> {
					if (true) {
						LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(3, x, y, z));
						FurnitureMetalButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default2", imagebutton_furniture_crafter_button_default2);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default2);
		imagebutton_furniture_crafter_button_default3 = new ImageButton(this.leftPos + 112, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default3.png"), 17, 36,
				e -> {
					if (true) {
						LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(4, x, y, z));
						FurnitureMetalButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default3", imagebutton_furniture_crafter_button_default3);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default3);
		imagebutton_furniture_crafter_button_default4 = new ImageButton(this.leftPos + 129, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default4.png"), 17, 36,
				e -> {
					if (true) {
						LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(5, x, y, z));
						FurnitureMetalButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default4", imagebutton_furniture_crafter_button_default4);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default4);
		imagebutton_furniture_crafter_button_default5 = new ImageButton(this.leftPos + 146, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default5.png"), 17, 36,
				e -> {
					if (true) {
						LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(6, x, y, z));
						FurnitureMetalButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default5", imagebutton_furniture_crafter_button_default5);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default5);
		imagebutton_furniture_crafter_button_default6 = new ImageButton(this.leftPos + 163, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default6.png"), 17, 36,
				e -> {
					if (true) {
						LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(7, x, y, z));
						FurnitureMetalButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default6", imagebutton_furniture_crafter_button_default6);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default6);
		imagebutton_tab_deselect_left_edge = new ImageButton(this.leftPos + 0, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect_left_edge.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(8, x, y, z));
				FurnitureMetalButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect_left_edge", imagebutton_tab_deselect_left_edge);
		this.addRenderableWidget(imagebutton_tab_deselect_left_edge);
		imagebutton_oak_wood = new ImageButton(this.leftPos + 4, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_oak_wood.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(9, x, y, z));
				FurnitureMetalButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:imagebutton_oak_wood", imagebutton_oak_wood);
		this.addRenderableWidget(imagebutton_oak_wood);
		imagebutton_toddys = new ImageButton(this.leftPos + 69, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_toddys.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(10, x, y, z));
				FurnitureMetalButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_toddys", imagebutton_toddys);
		this.addRenderableWidget(imagebutton_toddys);
		imagebutton_question_mark = new ImageButton(this.leftPos + 22, this.topPos + 110, 16, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_question_mark.png"), 16, 36, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(11, x, y, z));
				FurnitureMetalButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_question_mark", imagebutton_question_mark);
		this.addRenderableWidget(imagebutton_question_mark);
		imagebutton_furniture_crafter_button_default7 = new ImageButton(this.leftPos + 180, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default7.png"), 17, 36,
				e -> {
					if (true) {
						LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(12, x, y, z));
						FurnitureMetalButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default7", imagebutton_furniture_crafter_button_default7);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default7);
		imagebutton_furniture_crafter_button_default8 = new ImageButton(this.leftPos + 197, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default8.png"), 17, 36,
				e -> {
					if (true) {
						LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(13, x, y, z));
						FurnitureMetalButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default8", imagebutton_furniture_crafter_button_default8);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default8);
		imagebutton_furniture_crafter_button_default9 = new ImageButton(this.leftPos + 61, this.topPos + 27, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default9.png"), 17, 36,
				e -> {
					if (true) {
						LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(14, x, y, z));
						FurnitureMetalButtonMessage.handleButtonAction(entity, 14, x, y, z);
					}
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default9", imagebutton_furniture_crafter_button_default9);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default9);
		imagebutton_tab_deselect3 = new ImageButton(this.leftPos + 98, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect3.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(15, x, y, z));
				FurnitureMetalButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect3", imagebutton_tab_deselect3);
		this.addRenderableWidget(imagebutton_tab_deselect3);
		imagebutton_computer = new ImageButton(this.leftPos + 103, this.topPos + -25, 24, 24, 0, 0, 24, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_computer.png"), 24, 48, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureMetalButtonMessage(16, x, y, z));
				FurnitureMetalButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}
		});
		guistate.put("button:imagebutton_computer", imagebutton_computer);
		this.addRenderableWidget(imagebutton_computer);
	}
}
