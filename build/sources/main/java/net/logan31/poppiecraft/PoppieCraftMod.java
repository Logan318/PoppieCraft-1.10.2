package net.logan31.poppiecraft;

import net.logan31.poppiecraft.Proxy.CommonProxy;


import net.logan31.poppiecraft.client.gui.GUIHandler;

import net.logan31.poppiecraft.event.*;

import net.logan31.poppiecraft.gen.OreGen;
import net.logan31.poppiecraft.handler.AchievementHandler;
import net.logan31.poppiecraft.handler.EventHandler;
import net.logan31.poppiecraft.init.*;
import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockAdvanced;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockBasic;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockUltimate;
import net.logan31.poppiecraft.tileentity.TileEntityMelter;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;


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


    EventHandler eventHandler = new EventHandler();

    public static final CreativeTabs PoppieArmor = new CreativeTabs("PoppieArmor") {
        @Override
        public Item getTabIconItem() {
            return ModItems.Redstone_gem;
        }
    };


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {

        new ModItems();
        new ModBlocks();
        new ModArmor();
        GameRegistry.registerWorldGenerator(new OreGen(), 0);

        proxy.preInit();
        proxy.registerTileEntities();


    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        new ModRecipes().registerCraftRecipes();
        new ModRecipes().registerFurnaceRecipes();
        new ModRecipes().registerBrewingRecipes();
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.Four_leaf_clover), 1);
        eventHandler.registerEvents();
        proxy.init();

        AchievementHandler.registerAchievements();

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {

        proxy.postInit();
    }

    @Mod.EventHandler
    public void registerTileEntities() {

        GameRegistry.registerTileEntity(TileEntityGeneratorBlockBasic.class, References.MODID + ":Generator_block_basic");
        GameRegistry.registerTileEntity(TileEntityGeneratorBlockAdvanced.class, References.MODID + ":Generator_block_advanced");
        GameRegistry.registerTileEntity(TileEntityGeneratorBlockUltimate.class, References.MODID + ":Generator_block_ultimate");
        GameRegistry.registerTileEntity(TileEntityMelter.class, References.MODID + ":Melter");
    }

}

