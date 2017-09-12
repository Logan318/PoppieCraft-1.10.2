package net.logan31.poppiecraft.blocks;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

/**
 * Created by johanjulien on 19/07/2017.
 */
public class Steel_block extends Block {
    public Steel_block(String unlocalizedName, String registryName) {
        super(Material.ROCK);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(References.MODID, registryName));
        this.setHardness(20.0f);
        this.setResistance(100f);
        this.setHarvestLevel("pickaxe", 5);
        this.setCreativeTab(PoppieCraftMod.PoppieCraft);
    }
}
