package net.logan31.poppiecraft.container;

import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;


/**
 * Created by johanjulien on 29/07/2017.
 */
public class ContainerGeneratorBlock extends Container {

    private TileEntityGeneratorBlock te;

    public ContainerGeneratorBlock(IInventory playerInv, TileEntityGeneratorBlock te) {
        this.te = te;

        IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        this.addSlotToContainer(new SlotItemHandler(handler, 0, 62, 17));

        int xPos = 8;
        int yPos = 84;

        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
            }
        }

        for (int x = 0; x < 9; ++x) {
            this.addSlotToContainer(new Slot(playerInv, x, xPos + x * 18, yPos + 58));
        }

    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return false;
    }
}
