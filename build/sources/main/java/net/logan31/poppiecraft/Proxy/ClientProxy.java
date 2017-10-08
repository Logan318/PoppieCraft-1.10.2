package net.logan31.poppiecraft.Proxy;


import net.logan31.poppiecraft.Utils.References;
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

        EntityRegistry.addSpawn(Speedster.class, 30, 1, 5, EnumCreatureType.MONSTER, clean(Biome.REGISTRY));
        EntityRegistry.addSpawn(Jumper.class, 30, 1, 5, EnumCreatureType.MONSTER, clean(Biome.REGISTRY));
        EntityRegistry.addSpawn(Darker.class, 25, 1, 3, EnumCreatureType.MONSTER, clean(Biome.REGISTRY));
        EntityRegistry.addSpawn(GoldenChicken.class, 13, 1, 3, EnumCreatureType.CREATURE, Biome.getBiomeForId(1), Biome.getBiomeForId(4), Biome.getBiomeForId(5), Biome.getBiomeForId(132), Biome.getBiomeForId(27), Biome.getBiomeForId(29), Biome.getBiomeForId(6));
        ModEnchantments.registerEnchantments();
    }

    @Override
    public void init() {

        super.init();



    }

    @Override
    public void postInit() {
        ModEntities.RegisterEntitiesRenders();
        super.postInit();


    }

    @Override
    public void registerModelBakeryStuff() {
        ModelBakery.registerItemVariants(ModItems.Loot_upgrade, new ResourceLocation(References.MODID, "Loot_upgrade_basic"), new ResourceLocation(References.MODID, "Loot_upgrade_advanced"), new ResourceLocation(References.MODID, "Loot_upgrade_ultimate"));
        ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.Generator_block), new ResourceLocation(References.MODID, "Generator_block_basic"), new ResourceLocation(References.MODID, "Generator_block_advanced"), new ResourceLocation(References.MODID, "Generator_block_ultimate "));

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




