package net.logan31.poppiecraft.Proxy;

import net.logan31.poppiecraft.PoppieCraftMod;


import net.logan31.poppiecraft.init.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.net.NetworkInterface;

/**
 * Created by johanjulien on 28/06/2017.
 */

public class ClientProxy extends CommonProxy {


    @Override
    public void preInit() {
        super.preInit();
        ModBlocks.registerRenders();
        ModItems.registerRenders();
        ModArmor.registerRenders();


    }

    @Override
    public void init() {
        super.init();



    }

}




