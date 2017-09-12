package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;

/**
 * Created by johanjulien on 18/07/2017.
 */
public class Compressed_iron_bottle extends net.minecraft.item.Item {
    public Compressed_iron_bottle(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(PoppieCraftMod.PoppieCraft);
        this.setMaxStackSize(1);
    }
}
