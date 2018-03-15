package net.logan31.poppiecraft.container;


import net.logan31.poppiecraft.container.Slots.SlotFoundryOutput;
import net.logan31.poppiecraft.container.Slots.SlotFoundryUpgrade;
import net.logan31.poppiecraft.container.Slots.SlotFuelFoundry;
import net.logan31.poppiecraft.container.Slots.SlotPowerFoundry;
import net.logan31.poppiecraft.init.ModItems;
import net.logan31.poppiecraft.tileentity.TileEntityFoundry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nullable;

/**
 * Created by johanjulien on 17/10/2017.
 */
public class ContainerFoundry extends Container {


    private TileEntityFoundry te;
    private IItemHandler handler;


    public ContainerFoundry(IInventory playerInv, TileEntityFoundry te) {

        this.te = te;
        this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);


        this.addSlotToContainer(new SlotItemHandler(handler,0, 20, 17));
        this.addSlotToContainer(new SlotItemHandler(handler, 1, 38, 17));
        this.addSlotToContainer(new SlotItemHandler(handler, 2, 56, 17));
        this.addSlotToContainer(new SlotPowerFoundry(handler, 3, 74, 17));
        this.addSlotToContainer(new SlotFuelFoundry(handler, 4, 20, 53));
        this.addSlotToContainer(new SlotFuelFoundry(handler, 5, 38, 53));
        this.addSlotToContainer(new SlotFuelFoundry(handler, 6, 56, 53));
        this.addSlotToContainer(new SlotFuelFoundry(handler, 7, 74, 53));
        this.addSlotToContainer(new SlotFoundryOutput(handler, 8, 130, 35));
        this.addSlotToContainer(new SlotFoundryUpgrade(handler, 9, 150, 9));


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
        return this.te.isUseableByPlayer(player);
    }



    }

