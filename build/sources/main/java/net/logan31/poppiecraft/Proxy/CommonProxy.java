package net.logan31.poppiecraft.Proxy;


import net.logan31.poppiecraft.Utils.References;

import net.logan31.poppiecraft.blocks.GeneratorBlock;
import net.logan31.poppiecraft.gen.OreGen;
import net.logan31.poppiecraft.init.*;

import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by johanjulien on 28/06/2017.
 */

public class CommonProxy {



    public void preInit() {
ModEntities.RegisterEntities();


    }


    public void init() {


    }

    public void postInit() {

    }

    public void registerModelBakeryStuff() {

    }

    public void registerTileEntities() {
            GameRegistry.registerTileEntity(TileEntityGeneratorBlock.class, References.MODID + ":GUIGeneratorBlock");

    }



}

