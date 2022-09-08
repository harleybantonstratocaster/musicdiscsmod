package com.pnm.musicdiscsmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.pnm.musicdiscsmod.MusicDiscsMod;
import com.pnm.musicdiscsmod.inventory.PortableJukeboxInventory;
import com.pnm.musicdiscsmod.item.PortableJukeboxItem;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;


public class PortableJukeboxScreen extends AbstractContainerScreen<PortableJukeboxContainer> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(MusicDiscsMod.MOD_ID,"textures/gui/portable_jukebox.png");
    public PortableJukeboxScreen(PortableJukeboxContainer pMenu, Inventory playerInv, Component title) {
        super(pMenu, playerInv, title);

    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}
