package net.logan31.poppiecraft.blocks;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

/**
 * Created by johanjulien on 19/07/2017.
 */
public class Pironnite_block extends Block {
    public Pironnite_block(String unlocalizedName, String registryName) {
        super(Material.ROCK);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(References.MODID, registryName));
        this.setHardness(7.0f);
        this.setResistance(50f);
        this.setHarvestLevel("pickaxe", 4);
        this.setCreativeTab(PoppieCraftMod.PoppieCraft);
    }
}
