package com.ultricem.exoterra.block.custom.simplegenerator;

import com.ultricem.exoterra.ExoTerra;
import com.ultricem.exoterra.utils.MagicHelpers;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.awt.*;
import java.util.Arrays;

public class SimpleGeneratorScreen extends AbstractContainerScreen<SimpleGeneratorContainer> {

    private static final ResourceLocation background = ResourceLocation.fromNamespaceAndPath(ExoTerra.MOD_ID, "textures/gui/simple_generator.png");

    private final SimpleGeneratorContainer container;

    public SimpleGeneratorScreen(SimpleGeneratorContainer container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);
        this.container = container;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        //this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);

        this.renderTooltip(guiGraphics, mouseX, mouseY); // @mcp: renderTooltip = renderHoveredToolTip
        if (mouseX > (leftPos + 7) && mouseX < (leftPos + 7) + 18 && mouseY > (topPos + 7) && mouseY < (topPos + 7) + 73)
            guiGraphics.renderTooltip(font, Language.getInstance().getVisualOrder(Arrays.asList(
                    Component.translatable("screen.exoterra.energy", MagicHelpers.withSuffix(this.container.getEnergy()), MagicHelpers.withSuffix(this.container.getMaxPower())),
                    this.container.getRemaining() <= 0 ?
                            Component.translatable("screen.exoterra.no_fuel") :
                            Component.translatable("screen.exoterra.burn_time", MagicHelpers.ticksInSeconds(this.container.getRemaining()))
            )), mouseX, mouseY);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        guiGraphics.blit(background, leftPos, topPos, 0, 0, imageWidth, imageHeight);

        int maxHeight = 13;
        if (this.container.getMaxBurn() > 0) {
            int remaining = (this.container.getRemaining() * maxHeight) / this.container.getMaxBurn();
            guiGraphics.blit(background, leftPos + 66, topPos + 26 + 13 - remaining, 176, 13 - remaining, 14, remaining + 1);
        }

        int maxEnergy = this.container.getMaxPower(), height = 70;
        if (maxEnergy > 0) {
            int remaining = (this.container.getEnergy() * height) / maxEnergy;
            guiGraphics.blit(background, leftPos + 8, topPos + 78 - remaining, 176, 84 - remaining, 16, remaining + 1);
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(font, I18n.get("block.exoterra.simple_generator"), 55, 8, Color.DARK_GRAY.getRGB(), false);
    }
}
