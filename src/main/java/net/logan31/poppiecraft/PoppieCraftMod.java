package net.logan31.poppiecraft;

import com.sun.org.apache.bcel.internal.generic.POP;
import net.logan31.poppiecraft.Proxy.CommonProxy;


import net.logan31.poppiecraft.Utils.Utils;
import net.logan31.poppiecraft.blocks.GeneratorBlock;
import net.logan31.poppiecraft.client.gui.GUIGeneratorBlock;
import net.logan31.poppiecraft.client.gui.GUIHandler;
import net.logan31.poppiecraft.init.*;
import net.logan31.poppiecraft.Utils.References;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.ref.Reference;


/**
 * Created by johanjulien on 28/06/2017.
 */

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, acceptedMinecraftVersions = "[1.10.2]")
public class PoppieCraftMod {


    @SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.Instance(References.MODID)
    public static PoppieCraftMod instance;

    public static final CreativeTabs PoppieCraft = new CreativeTabs("PoppieCraft") {
        @Override
        public Item getTabIconItem() {
            return ModItems.Carbon_ingot;


        }

    };


    public static final CreativeTabs PoppieArmor = new CreativeTabs("PoppieArmor") {
        @Override
        public Item getTabIconItem() {
            return ModItems.Redstone_gem;
        }
    };


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit();
        proxy.registerTileEntities();


    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init();

    }


}

