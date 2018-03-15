package net.logan31.poppiecraft.Proxy;


import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;


import net.logan31.poppiecraft.client.gui.GUIHandler;
import net.logan31.poppiecraft.entity.Darker;
import net.logan31.poppiecraft.entity.GoldenChicken;
import net.logan31.poppiecraft.entity.Jumper;
import net.logan31.poppiecraft.entity.Speedster;
import net.logan31.poppiecraft.handler.FuelHandler;
import net.logan31.poppiecraft.init.*;

import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockAdvanced;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockBasic;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockUltimate;
import net.logan31.poppiecraft.tileentity.TileEntityFoundry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by johanjulien on 28/06/2017.
 */

public class CommonProxy {



    public void preInit() {
        ModEntities.RegisterEntities();
        ModEnchantments.registerEnchantments();

        EntityRegistry.addSpawn(Speedster.class, 30, 1, 5, EnumCreatureType.MONSTER, clean( Biome.REGISTRY));
        EntityRegistry.addSpawn(Jumper.class, 30, 1, 5, EnumCreatureType.MONSTER, clean(Biome.REGISTRY));
        EntityRegistry.addSpawn(Darker.class, 25, 1, 3, EnumCreatureType.MONSTER, clean(Biome.REGISTRY));
        EntityRegistry.addSpawn(GoldenChicken.class, 13, 1, 3, EnumCreatureType.CREATURE, Biome.getBiomeForId(1), Biome.getBiomeForId(4), Biome.getBiomeForId(5), Biome.getBiomeForId(132), Biome.getBiomeForId(27), Biome.getBiomeForId(29), Biome.getBiomeForId(6));


    }


    public void init() {
        NetworkRegistry.INSTANCE.registerGuiHandler( PoppieCraftMod.instance, new GUIHandler());
        GameRegistry.registerFuelHandler( new FuelHandler() );
    }

    public void postInit() {

    }

    public void registerModelBakeryStuff() {

    }

    public void registerTileEntities() {
            GameRegistry.registerTileEntity(TileEntityGeneratorBlockBasic.class, References.MODID + ":GeneratorBlockBasic");
            GameRegistry.registerTileEntity(TileEntityGeneratorBlockAdvanced.class, References.MODID + ":GeneratorBlockAdvanced");
            GameRegistry.registerTileEntity(TileEntityGeneratorBlockUltimate.class, References.MODID + ":GeneratorBlockUltimate");
            GameRegistry.registerTileEntity(TileEntityFoundry.class, References.MODID + ":Foundry");
    }


    public static Biome[] clean(RegistryNamespaced<ResourceLocation, Biome> in) {
        Iterator<Biome> itr = in.iterator();
        ArrayList ls = new ArrayList();

        while(itr.hasNext()) {
            ls.add(itr.next());
        }

        return (Biome[])ls.toArray(new Biome[ls.size()]);
    }


}

