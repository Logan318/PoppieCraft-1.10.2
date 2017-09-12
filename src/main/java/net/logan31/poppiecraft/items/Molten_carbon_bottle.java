package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by johanjulien on 17/07/2017.
 */
public class Molten_carbon_bottle extends net.minecraft.item.Item {

    public static final String[] subTypes = new String[]{"1", "2", "max"};

    public Molten_carbon_bottle(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(PoppieCraftMod.PoppieCraft);
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);


    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        int metadata = stack.getItemDamage();
        if(metadata < 0 || metadata > subTypes.length)
            metadata = 0;
        return super.getUnlocalizedName(stack) + "_" + subTypes[metadata];
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for(int i = 0; i < subTypes.length; i++) {
            subItems.add(new ItemStack(itemIn, 1, i));
        }

    }
}
