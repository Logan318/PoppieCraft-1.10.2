package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.minecraft.item.Item;

/**
 * Created by johanjulien on 30/07/2017.
 */
public class Generator_power extends Item {

    public Generator_power(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(PoppieCraftMod.PoppieCraft);

    }
}
