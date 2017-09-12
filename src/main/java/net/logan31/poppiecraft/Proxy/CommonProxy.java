package net.logan31.poppiecraft.Proxy;


import net.logan31.poppiecraft.Utils.References;

import net.logan31.poppiecraft.gen.OreGen;
import net.logan31.poppiecraft.init.*;

import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by johanjulien on 28/06/2017.
 */

public class CommonProxy {



    public void preInit() {
     new ModItems();
        new ModBlocks();
       new ModArmor();
       GameRegistry.registerWorldGenerator(new OreGen(), 0);


    }


    public void init() {
        new ModRecipes().registerCraftRecipes();
        new ModRecipes().registerFurnaceRecipes();
        new ModRecipes().registerBrewingRecipes();

    }

    public void registerModelBakeryStuff() {

    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityGeneratorBlock.class, References.MODID + ":Generator_block");
    }



}

