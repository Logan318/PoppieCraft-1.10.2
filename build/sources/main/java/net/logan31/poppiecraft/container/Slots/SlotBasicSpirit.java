package net.logan31.poppiecraft.container.Slots;

import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Created by johanjulien on 21/10/2017.
 */
public class SlotBasicSpirit extends SlotItemHandler{

    public SlotBasicSpirit(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }


        Item Loot = ModItems.Basic_spirit;


        @Override
        public boolean isItemValid(ItemStack stack) {
            return super.isItemValid(stack) && stack.getItem() == Loot;
        }

    }

