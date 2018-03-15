package net.logan31.poppiecraft.container.Slots;

import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Created by johanjulien on 21/10/2017.
 */
public class SlotUltimateSpirit extends SlotItemHandler{

    public SlotUltimateSpirit(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        Item basicSoul = ModItems.Basic_soul;
        Item advancedSoul = ModItems.Advanced_soul;
        Item ultimateSoul = ModItems.Ultimate_soul;


        @Override
        public boolean isItemValid(ItemStack stack) {
            return super.isItemValid(stack) && stack.getItem() == basicSoul || stack.getItem() == advancedSoul || stack.getItem() == ultimateSoul;
        }

    }

