package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.minecraft.item.Item;

/**
 * Created by johanjulien on 23/07/2017.
 */
public class Steel_power extends Item {
    public Steel_power(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(PoppieCraftMod.PoppieCraft);
    }
}
