package net.logan31.poppiecraft.client.gui;

import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.container.ContainerGeneratorBlock;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlock;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.items.CapabilityItemHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by johanjulien on 29/07/2017.
 */
public class GUIGeneratorBlock extends GuiContainer {

    private TileEntityGeneratorBlock te;
    private IInventory playerInv;

    public GUIGeneratorBlock(IInventory playerInv, TileEntityGeneratorBlock te) {
        super(new ContainerGeneratorBlock(playerInv, te));

        this.xSize = 176;
        this.ySize = 166;

        this.te = te;
        this.playerInv = playerInv;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MODID, "textures/gui/container/GUIGeneratorBlock.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }


}
