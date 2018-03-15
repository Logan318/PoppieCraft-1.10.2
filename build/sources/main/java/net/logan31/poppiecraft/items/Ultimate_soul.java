package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by johanjulien on 17/07/2017.
 */
public class Ultimate_soul extends Item {

    public static final String[] subTypes = new String[]{"Blaze", "Elder_Guardian", "Ender_Dragon", "Enderman", "Ghast", "Iron_Golem", "Magma_Cube", "Slime", "Stray", "Witch", "Wither", "Wither_Skeleton", "Zombie_Pigman"};

    public Ultimate_soul(String name) {
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
