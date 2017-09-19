package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.minecraft.item.Item;

/**
 * Created by johanjulien on 16/09/2017.
 */
public class Coal_gem extends Item {
    public Coal_gem(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(PoppieCraftMod.PoppieArmor);

    }
}
