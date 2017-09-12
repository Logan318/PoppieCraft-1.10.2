package net.logan31.poppiecraft.blocks;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by johanjulien on 24/07/2017.
 */
public class Mefferite_ore extends Block{
    public Mefferite_ore(String name) {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setHardness(15.0f);
        this.setResistance(75f);
        this.setHarvestLevel("pickaxe", 5);
        this.setCreativeTab(PoppieCraftMod.PoppieCraft);
    }
}
