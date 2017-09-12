package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

/**
 * Created by johanjulien on 30/06/2017.
 */
public class Lapishoe extends ItemHoe {


    public Lapishoe(String name, ToolMaterial material) {
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
        return repair.getItem() == ModItems.Lapis_gem;
    }
}


