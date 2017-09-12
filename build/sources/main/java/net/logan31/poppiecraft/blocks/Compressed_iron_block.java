package net.logan31.poppiecraft.blocks;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

/**
 * Created by johanjulien on 19/07/2017.
 */
public class Compressed_iron_block extends Block {
    public Compressed_iron_block(String unlocalizedName, String registryName) {
        super(Material.IRON);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(References.MODID, registryName));
        this.setHardness(3.0f);
        this.setResistance(25f);
        this.setHarvestLevel("pickaxe", 3);
        this.setCreativeTab(PoppieCraftMod.PoppieCraft);
    }
}
