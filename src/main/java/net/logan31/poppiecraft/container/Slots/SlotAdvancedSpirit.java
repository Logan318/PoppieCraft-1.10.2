package net.logan31.poppiecraft.container.Slots;

import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nullable;

/**
 * Created by johanjulien on 21/10/2017.
 */
public class SlotAdvancedSpirit extends SlotItemHandler{

    public SlotAdvancedSpirit(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        Item lootBasic = ModItems.Basic_spirit;
        Item lootAdvanced = ModItems.Advanced_spirit;


        @Override
        public boolean isItemValid(ItemStack stack) {
            return super.isItemValid(stack) && stack.getItem() == lootBasic || stack.getItem() == lootAdvanced;
        }


}

