package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

/**
 * Created by johanjulien on 16/09/2017.
 */
public class Coal_shovel extends ItemSpade {
    public Coal_shovel(String name, ToolMaterial material) {
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
        return repair.getItem() == ModItems.Coal_gem;
    }
}
