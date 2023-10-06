package net.mcreator.lsfurniture.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import net.mcreator.lsfurniture.world.inventory.FurnitureRecipesMenu;
import net.mcreator.lsfurniture.network.FurnitureRecipesButtonMessage;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class FurnitureRecipesScreen extends AbstractContainerScreen<FurnitureRecipesMenu> {
	private final static HashMap<String, Object> guistate = FurnitureRecipesMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_tab_deselect1;
	ImageButton imagebutton_tab_deselect2;
	ImageButton imagebutton_furniture_crafter_button_default;
	ImageButton imagebutton_furniture_crafter_button_default1;
	ImageButton imagebutton_furniture_crafter_button_default2;
	ImageButton imagebutton_furniture_crafter_button_default3;
	ImageButton imagebutton_furniture_crafter_button_default4;
	ImageButton imagebutton_furniture_crafter_button_default5;
	ImageButton imagebutton_furniture_crafter_button_default6;
	ImageButton imagebutton_furniture_crafter_button_default7;
	ImageButton imagebutton_furniture_crafter_button_default8;
	ImageButton imagebutton_furniture_crafter_button_default9;
	ImageButton imagebutton_furniture_crafter_button_default10;
	ImageButton imagebutton_furniture_crafter_button_default11;
	ImageButton imagebutton_furniture_crafter_button_default12;
	ImageButton imagebutton_furniture_crafter_button_default13;
	ImageButton imagebutton_furniture_crafter_button_default14;
	ImageButton imagebutton_furniture_crafter_button_default15;
	ImageButton imagebutton_furniture_crafter_button_default16;
	ImageButton imagebutton_furniture_crafter_button_default17;
	ImageButton imagebutton_furniture_crafter_button_default18;
	ImageButton imagebutton_furniture_crafter_button_default19;
	ImageButton imagebutton_furniture_crafter_button_default20;
	ImageButton imagebutton_furniture_crafter_button_default21;
	ImageButton imagebutton_furniture_crafter_button_default22;
	ImageButton imagebutton_furniture_crafter_button_default23;
	ImageButton imagebutton_furniture_crafter_button_default24;
	ImageButton imagebutton_furniture_crafter_button_default25;
	ImageButton imagebutton_furniture_crafter_button_default26;
	ImageButton imagebutton_furniture_crafter_button_default27;
	ImageButton imagebutton_furniture_crafter_button_default28;
	ImageButton imagebutton_furniture_crafter_button_default29;
	ImageButton imagebutton_furniture_crafter_button_default30;
	ImageButton imagebutton_furniture_crafter_button_default31;
	ImageButton imagebutton_furniture_crafter_button_default32;
	ImageButton imagebutton_furniture_crafter_button_default33;
	ImageButton imagebutton_furniture_crafter_button_default34;
	ImageButton imagebutton_furniture_crafter_button_default35;
	ImageButton imagebutton_file_button;
	ImageButton imagebutton_tab_deselect_left_edge;

	public FurnitureRecipesScreen(FurnitureRecipesMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 276;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ls_furniture:textures/screens/furniture_recipes.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 27 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_recipes.tooltip_empty"), mouseX, mouseY);
		if (mouseX > leftPos + 35 && mouseX < leftPos + 59 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_recipes.tooltip_empty1"), mouseX, mouseY);
		if (mouseX > leftPos + 67 && mouseX < leftPos + 91 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_recipes.tooltip_empty2"), mouseX, mouseY);
		if (mouseX > leftPos + 99 && mouseX < leftPos + 123 && mouseY > topPos + -25 && mouseY < topPos + -1)
			this.renderTooltip(ms, Component.translatable("gui.ls_furniture.furniture_recipes.tooltip_empty3"), mouseX, mouseY);
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
		this.blit(ms, this.leftPos + 31, this.topPos + -29, 0, 0, 32, 34, 32, 34);

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
		this.font.draw(poseStack, Component.translatable("gui.ls_furniture.furniture_recipes.label_furniture"), 12, 5, -12829636);
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
		imagebutton_tab_deselect1 = new ImageButton(this.leftPos + 63, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect1.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureRecipesButtonMessage(0, x, y, z));
				FurnitureRecipesButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect1", imagebutton_tab_deselect1);
		this.addRenderableWidget(imagebutton_tab_deselect1);
		imagebutton_tab_deselect2 = new ImageButton(this.leftPos + 95, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect2.png"), 32, 64, e -> {
		});
		guistate.put("button:imagebutton_tab_deselect2", imagebutton_tab_deselect2);
		this.addRenderableWidget(imagebutton_tab_deselect2);
		imagebutton_furniture_crafter_button_default = new ImageButton(this.leftPos + 61, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default.png"), 17, 36, e -> {
		});
		guistate.put("button:imagebutton_furniture_crafter_button_default", imagebutton_furniture_crafter_button_default);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default);
		imagebutton_furniture_crafter_button_default1 = new ImageButton(this.leftPos + 78, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default1.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default1", imagebutton_furniture_crafter_button_default1);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default1);
		imagebutton_furniture_crafter_button_default2 = new ImageButton(this.leftPos + 95, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default2.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default2", imagebutton_furniture_crafter_button_default2);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default2);
		imagebutton_furniture_crafter_button_default3 = new ImageButton(this.leftPos + 112, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default3.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default3", imagebutton_furniture_crafter_button_default3);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default3);
		imagebutton_furniture_crafter_button_default4 = new ImageButton(this.leftPos + 129, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default4.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default4", imagebutton_furniture_crafter_button_default4);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default4);
		imagebutton_furniture_crafter_button_default5 = new ImageButton(this.leftPos + 146, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default5.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default5", imagebutton_furniture_crafter_button_default5);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default5);
		imagebutton_furniture_crafter_button_default6 = new ImageButton(this.leftPos + 163, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default6.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default6", imagebutton_furniture_crafter_button_default6);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default6);
		imagebutton_furniture_crafter_button_default7 = new ImageButton(this.leftPos + 180, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default7.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default7", imagebutton_furniture_crafter_button_default7);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default7);
		imagebutton_furniture_crafter_button_default8 = new ImageButton(this.leftPos + 197, this.topPos + 9, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default8.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default8", imagebutton_furniture_crafter_button_default8);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default8);
		imagebutton_furniture_crafter_button_default9 = new ImageButton(this.leftPos + 61, this.topPos + 27, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default9.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default9", imagebutton_furniture_crafter_button_default9);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default9);
		imagebutton_furniture_crafter_button_default10 = new ImageButton(this.leftPos + 78, this.topPos + 27, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default10.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default10", imagebutton_furniture_crafter_button_default10);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default10);
		imagebutton_furniture_crafter_button_default11 = new ImageButton(this.leftPos + 95, this.topPos + 27, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default11.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default11", imagebutton_furniture_crafter_button_default11);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default11);
		imagebutton_furniture_crafter_button_default12 = new ImageButton(this.leftPos + 112, this.topPos + 27, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default12.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default12", imagebutton_furniture_crafter_button_default12);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default12);
		imagebutton_furniture_crafter_button_default13 = new ImageButton(this.leftPos + 129, this.topPos + 27, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default13.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default13", imagebutton_furniture_crafter_button_default13);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default13);
		imagebutton_furniture_crafter_button_default14 = new ImageButton(this.leftPos + 146, this.topPos + 27, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default14.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default14", imagebutton_furniture_crafter_button_default14);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default14);
		imagebutton_furniture_crafter_button_default15 = new ImageButton(this.leftPos + 163, this.topPos + 27, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default15.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default15", imagebutton_furniture_crafter_button_default15);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default15);
		imagebutton_furniture_crafter_button_default16 = new ImageButton(this.leftPos + 180, this.topPos + 27, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default16.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default16", imagebutton_furniture_crafter_button_default16);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default16);
		imagebutton_furniture_crafter_button_default17 = new ImageButton(this.leftPos + 197, this.topPos + 27, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default17.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default17", imagebutton_furniture_crafter_button_default17);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default17);
		imagebutton_furniture_crafter_button_default18 = new ImageButton(this.leftPos + 61, this.topPos + 45, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default18.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default18", imagebutton_furniture_crafter_button_default18);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default18);
		imagebutton_furniture_crafter_button_default19 = new ImageButton(this.leftPos + 78, this.topPos + 45, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default19.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default19", imagebutton_furniture_crafter_button_default19);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default19);
		imagebutton_furniture_crafter_button_default20 = new ImageButton(this.leftPos + 95, this.topPos + 45, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default20.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default20", imagebutton_furniture_crafter_button_default20);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default20);
		imagebutton_furniture_crafter_button_default21 = new ImageButton(this.leftPos + 112, this.topPos + 45, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default21.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default21", imagebutton_furniture_crafter_button_default21);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default21);
		imagebutton_furniture_crafter_button_default22 = new ImageButton(this.leftPos + 129, this.topPos + 45, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default22.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default22", imagebutton_furniture_crafter_button_default22);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default22);
		imagebutton_furniture_crafter_button_default23 = new ImageButton(this.leftPos + 146, this.topPos + 45, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default23.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default23", imagebutton_furniture_crafter_button_default23);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default23);
		imagebutton_furniture_crafter_button_default24 = new ImageButton(this.leftPos + 163, this.topPos + 45, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default24.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default24", imagebutton_furniture_crafter_button_default24);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default24);
		imagebutton_furniture_crafter_button_default25 = new ImageButton(this.leftPos + 180, this.topPos + 45, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default25.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default25", imagebutton_furniture_crafter_button_default25);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default25);
		imagebutton_furniture_crafter_button_default26 = new ImageButton(this.leftPos + 197, this.topPos + 45, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default26.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default26", imagebutton_furniture_crafter_button_default26);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default26);
		imagebutton_furniture_crafter_button_default27 = new ImageButton(this.leftPos + 61, this.topPos + 63, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default27.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default27", imagebutton_furniture_crafter_button_default27);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default27);
		imagebutton_furniture_crafter_button_default28 = new ImageButton(this.leftPos + 78, this.topPos + 63, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default28.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default28", imagebutton_furniture_crafter_button_default28);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default28);
		imagebutton_furniture_crafter_button_default29 = new ImageButton(this.leftPos + 95, this.topPos + 63, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default29.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default29", imagebutton_furniture_crafter_button_default29);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default29);
		imagebutton_furniture_crafter_button_default30 = new ImageButton(this.leftPos + 112, this.topPos + 63, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default30.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default30", imagebutton_furniture_crafter_button_default30);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default30);
		imagebutton_furniture_crafter_button_default31 = new ImageButton(this.leftPos + 129, this.topPos + 63, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default31.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default31", imagebutton_furniture_crafter_button_default31);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default31);
		imagebutton_furniture_crafter_button_default32 = new ImageButton(this.leftPos + 146, this.topPos + 63, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default32.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default32", imagebutton_furniture_crafter_button_default32);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default32);
		imagebutton_furniture_crafter_button_default33 = new ImageButton(this.leftPos + 163, this.topPos + 63, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default33.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default33", imagebutton_furniture_crafter_button_default33);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default33);
		imagebutton_furniture_crafter_button_default34 = new ImageButton(this.leftPos + 180, this.topPos + 63, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default34.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default34", imagebutton_furniture_crafter_button_default34);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default34);
		imagebutton_furniture_crafter_button_default35 = new ImageButton(this.leftPos + 197, this.topPos + 63, 17, 18, 0, 0, 18, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_furniture_crafter_button_default35.png"), 17, 36,
				e -> {
				});
		guistate.put("button:imagebutton_furniture_crafter_button_default35", imagebutton_furniture_crafter_button_default35);
		this.addRenderableWidget(imagebutton_furniture_crafter_button_default35);
		imagebutton_file_button = new ImageButton(this.leftPos + 255, this.topPos + 146, 16, 16, 0, 0, 16, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_file_button.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_file_button", imagebutton_file_button);
		this.addRenderableWidget(imagebutton_file_button);
		imagebutton_tab_deselect_left_edge = new ImageButton(this.leftPos + 0, this.topPos + -29, 32, 32, 0, 0, 32, new ResourceLocation("ls_furniture:textures/screens/atlas/imagebutton_tab_deselect_left_edge.png"), 32, 64, e -> {
			if (true) {
				LsFurnitureMod.PACKET_HANDLER.sendToServer(new FurnitureRecipesButtonMessage(39, x, y, z));
				FurnitureRecipesButtonMessage.handleButtonAction(entity, 39, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_deselect_left_edge", imagebutton_tab_deselect_left_edge);
		this.addRenderableWidget(imagebutton_tab_deselect_left_edge);
	}
}
