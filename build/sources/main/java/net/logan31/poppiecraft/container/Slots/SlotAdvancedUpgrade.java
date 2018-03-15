package net.logan31.poppiecraft.container.Slots;

import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Created by johanjulien on 21/10/2017.
 */
public class SlotAdvancedUpgrade extends SlotItemHandler{

    public SlotAdvancedUpgrade(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }





        @Override
        public boolean isItemValid(ItemStack stack) {

                Item Loot = ModItems.Loot_upgrade;
                Item upgrade = ModItems.Advanced_generator_upgrade;

            return super.isItemValid(stack) && stack.getItem() == Loot || stack.getItem() == upgrade;
        }

    }

