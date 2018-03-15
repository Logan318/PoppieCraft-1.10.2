package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.minecraft.item.Item;


public class ItemMod1Stack extends Item {


public ItemMod1Stack(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(PoppieCraftMod.PoppieCraft);
        this.setMaxStackSize( 1 );
        }
}
