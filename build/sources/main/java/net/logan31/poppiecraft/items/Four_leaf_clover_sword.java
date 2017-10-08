package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

/**
 * Created by johanjulien on 16/09/2017.
 */
public class Four_leaf_clover_sword extends ItemSword{
    public Four_leaf_clover_sword(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(PoppieCraftMod.PoppieArmor);
    }
    @Override
    public boolean isRepairable() {
        return true;

    }


    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return repair.getItem() == ModItems.Four_leaf_clover;
    }
}
