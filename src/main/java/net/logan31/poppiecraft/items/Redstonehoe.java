package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

/**
 * Created by johanjulien on 30/06/2017.
 */
public class Redstonehoe extends ItemHoe {


    public Redstonehoe(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }


    @Override
    public boolean isRepairable() {
        return true;

    }


    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return repair.getItem() == ModItems.Redstone_gem;
    }
}



