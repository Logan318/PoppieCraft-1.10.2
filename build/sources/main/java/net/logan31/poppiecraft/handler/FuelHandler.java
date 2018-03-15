package net.logan31.poppiecraft.handler;

import net.logan31.poppiecraft.init.ModBlocks;
import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

/**
 * Created by johanjulien on 04/12/2017.
 */
public class FuelHandler implements IFuelHandler {
    @Override
    public int getBurnTime(ItemStack fuel) {
        if(fuel.getItem() == ModItems.Carbon_ingot) {
            return 6400;
        }
        if(fuel.getItem() == Item.getItemFromBlock(ModBlocks.Carbon_block)) {
            return 57600;
        }
        if(fuel.getItem() == ModItems.Burning_carbon) {
            return 38400;
        }
        return 0;
    }
}
