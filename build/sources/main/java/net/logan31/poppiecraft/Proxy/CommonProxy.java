package net.logan31.poppiecraft.Proxy;


import net.logan31.poppiecraft.Utils.References;

import net.logan31.poppiecraft.gen.OreGen;
import net.logan31.poppiecraft.init.*;

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



}

