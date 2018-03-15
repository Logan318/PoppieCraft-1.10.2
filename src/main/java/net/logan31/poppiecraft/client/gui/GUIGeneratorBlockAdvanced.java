package net.logan31.poppiecraft.client.gui;

import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.container.ContainerGeneratorBlockAdvanced;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockAdvanced;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

/**
 * Created by johanjulien on 17/10/2017.
 */
public class GUIGeneratorBlockAdvanced extends GuiContainer {

    private TileEntityGeneratorBlockAdvanced te;
    private IInventory playerInv;


    public GUIGeneratorBlockAdvanced(IInventory playerInv, TileEntityGeneratorBlockAdvanced te) {
        super(new ContainerGeneratorBlockAdvanced(playerInv, te));

        this.xSize = 176;
        this.ySize = 166;

        this.te = te;
        this.playerInv = playerInv;
    }


    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation( References.MODID, "textures/gui/container/GUIGeneratorBlockAdvanced.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);


    }
}
