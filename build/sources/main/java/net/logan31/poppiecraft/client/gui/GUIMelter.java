package net.logan31.poppiecraft.client.gui;

import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.container.ContainerMelter;
import net.logan31.poppiecraft.tileentity.TileEntityMelter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.logan31.poppiecraft.client.gui.ProgressBar;
import net.minecraftforge.client.model.b3d.B3DModel;
import scala.swing.event.ForegroundChanged;

/**
 * Created by johanjulien on 17/10/2017.
 */
public class GUIMelter extends GuiContainer {

    private TileEntityMelter te;
    private IInventory playerInv;
    private ProgressBar progressBar;

    public static final ResourceLocation TEXTURE = new ResourceLocation(References.MODID,
            "textures/gui/container/GUIMelter.png");


    public GUIMelter(IInventory playerInv, TileEntityMelter te) {
        super(new ContainerMelter(playerInv, te));

        this.xSize = 176;
        this.ySize = 166;

        this.te = te;
        this.playerInv = playerInv;
        this.progressBar = new ProgressBar( TEXTURE, ProgressBar.ProgressBarDirection.DIAGONAL_UP_RIGHT, 14, 14, 135, 36, 176, 0 );
    }


    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer( mouseX, mouseY );
    }

    @Override
    public void initGui() {
        super.initGui();

    }
}
