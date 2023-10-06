package net.mcreator.lsfurniture.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.Minecraft;

import net.mcreator.lsfurniture.world.inventory.FurnitureChiselMenu;
import net.mcreator.lsfurniture.procedures.DisablePictureBlock3Procedure;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class FurnitureChiselScreen extends AbstractContainerScreen<FurnitureChiselMenu> {
	private final static HashMap<String, Object> guistate = FurnitureChiselMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox ConnectedTextures;

	public FurnitureChiselScreen(FurnitureChiselMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 203;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ls_furniture:textures/screens/furniture_chisel.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (DisablePictureBlock3Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/block.png"));
			this.blit(ms, this.leftPos + 13, this.topPos + 27, 0, 0, 14, 14, 14, 14);
		}

		RenderSystem.setShaderTexture(0, new ResourceLocation("ls_furniture:textures/screens/furniture_crafter_brown_background.png"));
		this.blit(ms, this.leftPos + 38, this.topPos + 7, 0, 0, 155, 74, 155, 74);

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
		this.font.draw(poseStack, Component.translatable("gui.ls_furniture.furniture_chisel.label_chisel"), 6, 15, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.ls_furniture.furniture_chisel.label_connected"), 3, 43, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.ls_furniture.furniture_chisel.label_textures"), 3, 51, -12829636);
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
		ConnectedTextures = new Checkbox(this.leftPos + 10, this.topPos + 61, 20, 20, Component.translatable("gui.ls_furniture.furniture_chisel.ConnectedTextures"), false);
		guistate.put("checkbox:ConnectedTextures", ConnectedTextures);
		this.addRenderableWidget(ConnectedTextures);
	}
}
