package net.logan31.poppiecraft.client.gui;

import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.container.ContainerFoundry;
import net.logan31.poppiecraft.tileentity.TileEntityFoundry;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by johanjulien on 17/10/2017.
 */
public class GUIFoundry extends GuiContainer {

    private TileEntityFoundry te;
    private IInventory playerInv;
    private ProgressBar progressBar;
    private int x;




    public static final ResourceLocation TEXTURE = new ResourceLocation(References.MODID,"textures/gui/container/GUIFoundry.png");


    public GUIFoundry(IInventory playerInv, TileEntityFoundry te) {
        super(new ContainerFoundry(playerInv, te));

        this.xSize = 176;
        this.ySize = 166;

        this.te = te;
        this.playerInv = playerInv;
    }


    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

        if(TileEntityFoundry.foundryBurnTime > 0) {
            int k = this.getBurnLeftScaled(13);

            this.drawTexturedModalRect(i + 48, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        if(TileEntityFoundry.durationSmelting >= 0) {
            this.drawTexturedModalRect( i + 95, j + 34, 176, 14, TileEntityFoundry.durationSmelting / (40 * TileEntityFoundry.levelFoundry) + 1, 16 );
        }

    }


    private int getBurnLeftScaled(int pixels)
    {

        return TileEntityFoundry.foundryBurnTime * pixels / 1000;
    }

}
