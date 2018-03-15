package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by johanjulien on 04/12/2017.
 */
public class SteelPower extends Item {

    public SteelPower(String name) {
        this.setUnlocalizedName( name );
        this.setRegistryName( name );
        this.setCreativeTab( PoppieCraftMod.PoppieCraft );
        this.setMaxDamage( 8 );

    }
}
