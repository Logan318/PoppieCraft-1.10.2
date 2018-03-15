package net.logan31.poppiecraft.Proxy;


import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.client.gui.GUIHandler;
import net.logan31.poppiecraft.entity.Darker;
import net.logan31.poppiecraft.entity.GoldenChicken;
import net.logan31.poppiecraft.entity.Jumper;
import net.logan31.poppiecraft.entity.Speedster;
import net.logan31.poppiecraft.init.*;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeBeach;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;


import java.util.ArrayList;
import java.util.Iterator;



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

    @Override
    public void postInit() {

        super.postInit();
        ModEntities.RegisterEntitiesRenders();

    }

    @Override
    public void registerModelBakeryStuff() {
        ModelBakery.registerItemVariants(ModItems.Loot_upgrade, new ResourceLocation(References.MODID, "Loot_upgrade_basic"), new ResourceLocation(References.MODID, "Loot_upgrade_advanced"), new ResourceLocation(References.MODID, "Loot_upgrade_ultimate"));

    }





}




