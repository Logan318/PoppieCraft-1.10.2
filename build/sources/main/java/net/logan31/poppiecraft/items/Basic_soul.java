package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by johanjulien on 17/07/2017.
 */
public class Basic_soul extends Item {

    public static final String[] subTypes = new String[]{"Bat", "Chicken", "Cow", "Endermite", "Mooshroom", "Ocelot", "Pig", "PolarBear", "Rabbit", "Sheep", "Shulker", "Silverfish", "Squid", "Wolf"};

    public Basic_soul(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(PoppieCraftMod.PoppieCraft);
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
