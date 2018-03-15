package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.init.ModBlocks;
import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by johanjulien on 17/07/2017.
 */
public class Advanced_soul extends Item {

    public static final String[] subTypes = new String[]{"Cave_Spider", "Creeper", "Donkey", "Guardian", "Horse", "Husk", "Mule", "Skeleton", "Skeleton_Horse", "Snow_Man", "Spider", "Villager", "Zombie", "Zombie_Horse"};

    public Advanced_soul(String name) {
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
