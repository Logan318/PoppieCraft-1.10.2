package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.minecraft.item.Item;

/**
 * Created by johanjulien on 23/07/2017.
 */
public class Jump_fragment extends Item {
    public Jump_fragment(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(PoppieCraftMod.PoppieCraft);
    }
}