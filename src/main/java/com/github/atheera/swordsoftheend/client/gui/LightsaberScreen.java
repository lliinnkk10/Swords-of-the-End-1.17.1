package com.github.atheera.swordsoftheend.client.gui;

import com.github.atheera.swordsoftheend.SOTE;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class LightsaberScreen extends AbstractContainerScreen<LightsaberContainer> {

    private final ResourceLocation GUI = new ResourceLocation(SOTE.MOD_ID, "textures/gui/lightsaber_gui.png");

    public LightsaberScreen(LightsaberContainer container, Inventory inv, Component component) {
        super(container, inv, component);
    }

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, GUI);
        int relX = (this.width - this.imageWidth) / 2;
        int relY = (this. height - this.imageHeight) / 2;
        this.blit(matrixStack, relX, relY, 0, 0, 180, 152);
    }
}