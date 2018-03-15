package net.logan31.poppiecraft.container;


import net.logan31.poppiecraft.container.Slots.SlotBasicSpirit;
import net.logan31.poppiecraft.container.Slots.SlotFurnaceEffect;
import net.logan31.poppiecraft.container.Slots.SlotBasicUpgrade;
import net.logan31.poppiecraft.init.ModItems;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockBasic;
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
public class ContainerGeneratorBlockBasic extends Container {


    private TileEntityGeneratorBlockBasic te;
    private IItemHandler handler;


    public ContainerGeneratorBlockBasic(IInventory playerInv, TileEntityGeneratorBlockBasic te) {

        this.te = te;
        this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);


        this.addSlotToContainer(new SlotItemHandler(handler,0, 8, 40));
        this.addSlotToContainer(new SlotItemHandler(handler, 1, 26, 40));
        this.addSlotToContainer(new SlotItemHandler(handler, 2, 44, 40));
        this.addSlotToContainer(new SlotItemHandler(handler, 3, 62, 40));
        this.addSlotToContainer(new SlotItemHandler(handler, 4, 80, 40));
        this.addSlotToContainer(new SlotItemHandler(handler, 5, 98, 40));
        this.addSlotToContainer(new SlotItemHandler(handler, 6, 116, 40));
        this.addSlotToContainer(new SlotItemHandler(handler, 7, 134, 40));
        this.addSlotToContainer(new SlotItemHandler(handler, 8, 152, 40));
        this.addSlotToContainer(new SlotItemHandler(handler, 9, 8, 58));
        this.addSlotToContainer(new SlotItemHandler(handler, 10, 26, 58));
        this.addSlotToContainer(new SlotItemHandler(handler, 11, 44, 58));
        this.addSlotToContainer(new SlotItemHandler(handler, 12, 62, 58));
        this.addSlotToContainer(new SlotItemHandler(handler, 13, 80, 58));
        this.addSlotToContainer(new SlotItemHandler(handler, 14, 98, 58));
        this.addSlotToContainer(new SlotItemHandler(handler, 15, 116, 58));
        this.addSlotToContainer(new SlotItemHandler(handler, 16, 134, 58));
        this.addSlotToContainer(new SlotItemHandler(handler, 17, 152, 58));
        this.addSlotToContainer(new SlotFurnaceEffect(handler, 18, 8, 8));
        this.addSlotToContainer(new SlotBasicSpirit(handler, 19, 80, 8));
        this.addSlotToContainer(new SlotBasicUpgrade(handler, 20, 152, 8));





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

    @Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack previous = (ItemStack)null;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();

            if (fromSlot < this.handler.getSlots()) {
                if (!this.mergeItemStack(current, handler.getSlots(), handler.getSlots() + 36, true))
                    return null;
            } else {
                // From the player's inventory to block breaker's inventory
                if(current.getItem() == Items.ENCHANTED_BOOK) {
                    if(!this.mergeItemStack(current, 18, handler.getSlots(), false))
                        return null;
                }

                else if(current.getItem() == ModItems.Basic_spirit) {
                    if(!this.mergeItemStack(current, 19, handler.getSlots(), false))
                        return null;
                }

                else if(current.getItem() == ModItems.Loot_upgrade) {
                    if(!this.mergeItemStack(current, 20, handler.getSlots(), false))
                        return null;
                }

                else if(current.getItem() == ModItems.Basic_generator_upgrade) {
                    if(!this.mergeItemStack(current, 20, handler.getSlots(), false))
                        return null;
                }
                if (!this.mergeItemStack(current, 0, handler.getSlots(), false))
                    return null;
            }

            if (current.stackSize == 0) //Use func_190916_E() instead of stackSize 1.11 only 1.11.2 use getCount()
                slot.putStack((ItemStack)null); //Use ItemStack.field_190927_a instead of (ItemStack)null for a blank item stack. In 1.11.2 use ItemStack.EMPTY
            else
                slot.onSlotChanged();

            if (current.stackSize == previous.stackSize)
                return null;
            slot.onPickupFromSlot(playerIn, current);
        }
        return previous;
    }


    }

