package net.logan31.poppiecraft.init;

/**
 * Created by johanjulien on 28/06/2017.
 */




import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.handler.EnumHandler;
import net.logan31.poppiecraft.items.*;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

public class ModItems {
    public ModItems() {
        initItems();
        registerItems();

    }



    public static Item Carbon_ingot, Molten_carbon, Redstone_gem, Lapis_gem, Quartz_gem, Glowstone_gem, Pironnite_fragment,
            Pironnite_nugget, Pironnite_ingot, Poppie_nugget, Poppie_ingot, Molten_iron, Compressed_iron, Carbon_stick,
            Renforced_string, Golden_string, Compressed_iron_bottle, Molten_carbon_bottle, Poppie_bottle, Steel_piece,
            Steel_nugget, Steel_ingot, Speed_fragment, Speed_element, Jump_fragment, Jump_element, Darkness_fragment,
            Darkness_element, Steel_power, Loot_upgrade, Generator_power, Obsidian_gem, Four_leaf_clover, Coal_gem,
            Speedster_flesh, Jumper_flesh, Darker_flesh, Golden_feather, Basic_soul, Advanced_soul, Ultimate_soul,
            Basic_spirit, Advanced_spirit, Ultimate_spirit, Broken_basic_spirit_power, Basic_spirit_power,
            Broken_advanced_spirit_power, Advanced_spirit_power, Broken_ultimate_spirit_power, Ultimate_spirit_power,
            Compressed_carbon, Bat_Spawn, Chicken_Spawn, Cow_Spawn, Endermite_Spawn, Mooshroom_Spawn, Ocelot_Spawn, Pig_Spawn,
            Polar_Bear_Spawn, Rabbit_Spawn, Sheep_Spawn, Shulker_Spawn, Silverfish_Spawn, Squid_Spawn, Wolf_Spawn,
            Cave_Spider_Spawn, Creeper_Spawn, Donkey_Spawn, Guardian_Spawn, Horse_Spawn, Husk_Spawn, Mule_Spawn, Skeleton_Spawn,
            Skeleton_Horse_Spawn, Snow_Man_Spawn, Spider_Spawn, Villager_Spawn, Zombie_Spawn, Zombie_Horse_Spawn,
            Basic_generator_upgrade, Advanced_generator_upgrade, Burning_carbon;



    public static final Item Redstone_sword = new Redstonesword("Redstone_sword", ToolMaterials.redstoneMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Redstone_pickaxe = new Redstonepickaxe("Redstone_pickaxe", ToolMaterials.redstoneMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Redstone_shovel = new Redstoneshovel("Redstone_shovel", ToolMaterials.redstoneMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Redstone_hoe = new Redstonehoe("Redstone_hoe", ToolMaterials.redstoneMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Redstone_axe = new Redstoneaxe("Redstone_axe", ToolMaterials.redstoneMat, 8.0f, -3.1f).setCreativeTab(PoppieCraftMod.PoppieArmor);

    public static final Item Lapis_sword = new Lapissword("Lapis_sword", ToolMaterials.lapisMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Lapis_pickaxe = new Lapispickaxe("Lapis_pickaxe", ToolMaterials.lapisMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Lapis_shovel = new Lapisshovel("Lapis_shovel", ToolMaterials.lapisMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Lapis_hoe = new Lapishoe("Lapis_hoe", ToolMaterials.lapisMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Lapis_axe = new Lapisaxe("Lapis_axe", ToolMaterials.lapisMat, 8.0f, -3.1f).setCreativeTab(PoppieCraftMod.PoppieArmor);

    public static final Item Quartz_sword = new Quartzsword("Quartz_sword", ToolMaterials.quartzMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Quartz_pickaxe = new Quartzpickaxe("Quartz_pickaxe", ToolMaterials.quartzMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Quartz_shovel = new Quartzshovel("Quartz_shovel", ToolMaterials.quartzMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Quartz_hoe = new Quartzhoe("Quartz_hoe", ToolMaterials.quartzMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Quartz_axe = new Quartzaxe("Quartz_axe", ToolMaterials.quartzMat, 8.0f, -3.1f).setCreativeTab(PoppieCraftMod.PoppieArmor);

    public static final Item Glowstone_sword = new Glowstonesword("Glowstone_sword", ToolMaterials.glowstoneMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Glowstone_pickaxe = new Glowstonepickaxe("Glowstone_pickaxe", ToolMaterials.glowstoneMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Glowstone_shovel = new Glowstoneshovel("Glowstone_shovel", ToolMaterials.glowstoneMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Glowstone_hoe = new Glowstonehoe("Glowstone_hoe", ToolMaterials.glowstoneMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Glowstone_axe = new Glowstoneaxe("Glowstone_axe", ToolMaterials.glowstoneMat, 8.0f, -3.1f).setCreativeTab(PoppieCraftMod.PoppieArmor);

    public static final Item Obsidian_sword = new Obsidian_sword("Obsidian_sword", ToolMaterials.obsidianMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Obsidian_pickaxe = new Obsidian_pickaxe("Obsidian_pickaxe", ToolMaterials.obsidianMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Obsidian_shovel = new Obsidian_shovel("Obsidian_shovel", ToolMaterials.obsidianMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Obsidian_hoe = new Obsidian_hoe("Obsidian_hoe", ToolMaterials.obsidianMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Obsidian_axe = new Obsidian_axe("Obsidian_axe", ToolMaterials.obsidianMat, 8.0f, -3.1f).setCreativeTab(PoppieCraftMod.PoppieArmor);

    public static final Item Four_leaf_clover_sword = new Four_leaf_clover_sword("Four_leaf_clover_sword", ToolMaterials.leafcloverMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Four_leaf_clover_pickaxe = new Four_leaf_clover_pickaxe("Four_leaf_clover_pickaxe", ToolMaterials.leafcloverMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Four_leaf_clover_shovel = new Four_leaf_clover_shovel("Four_leaf_clover_shovel", ToolMaterials.leafcloverMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Four_leaf_clover_hoe = new Four_leaf_clover_hoe("Four_leaf_clover_hoe", ToolMaterials.leafcloverMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Four_leaf_clover_axe = new Four_leaf_clover_axe("Four_leaf_clover_axe", ToolMaterials.leafcloverMat, 8.0f, -3.1f).setCreativeTab(PoppieCraftMod.PoppieArmor);

    public static final Item Coal_sword = new Coal_sword("Coal_sword", ToolMaterials.coalMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Coal_pickaxe = new Coal_pickaxe("Coal_pickaxe", ToolMaterials.coalMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Coal_shovel = new Coal_shovel("Coal_shovel", ToolMaterials.coalMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Coal_hoe = new Coal_hoe("Coal_hoe", ToolMaterials.coalMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Coal_axe = new Coal_axe("Coal_axe", ToolMaterials.coalMat, 8.0f, -3.1f).setCreativeTab(PoppieCraftMod.PoppieArmor);

    public static final Item Emerald_sword = new Emeraldsword("Emerald_sword", ToolMaterials.emeraldMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Emerald_pickaxe = new Emeraldpickaxe("Emerald_pickaxe", ToolMaterials.emeraldMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Emerald_shovel = new Emeraldshovel("Emerald_shovel", ToolMaterials.emeraldMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Emerald_hoe = new Emeraldhoe("Emerald_hoe", ToolMaterials.emeraldMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Emerald_axe = new Emeraldaxe("Emerald_axe", ToolMaterials.emeraldMat, 10.0f, -3.1f).setCreativeTab(PoppieCraftMod.PoppieArmor);



    public static void initItems() {
       Carbon_ingot = new ItemMod("Carbon_ingot");
        Molten_carbon = new ItemMod("Molten_carbon");
        Compressed_carbon = new ItemMod( "Compressed_carbon" );
        Pironnite_fragment = new ItemMod("Pironnite_fragment");
        Pironnite_nugget = new ItemMod("Pironnite_nugget");
        Pironnite_ingot = new ItemMod("Pironnite_ingot");
        Poppie_nugget = new ItemMod("Poppie_nugget");
        Poppie_ingot = new ItemMod("Poppie_ingot");
        Molten_iron = new ItemMod("Molten_iron");
        Compressed_iron = new ItemMod("Compressed_iron");
        Carbon_stick = new ItemMod("Carbon_stick");
        Renforced_string = new ItemMod("Renforced_string");
        Golden_string = new ItemMod("Golden_string");
        Compressed_iron_bottle = new Compressed_iron_bottle("Compressed_iron_bottle");
        Molten_carbon_bottle = new Molten_carbon_bottle("Molten_carbon_bottle");
        Poppie_bottle = new Poppie_bottle("Poppie_bottle");
        Steel_piece = new ItemMod("Steel_piece");
        Steel_nugget = new ItemMod("Steel_nugget");
        Steel_ingot = new ItemMod("Steel_ingot");
        Speed_fragment = new ItemMod("Speed_fragment");
        Speed_element = new ItemMod("Speed_element");
        Jump_fragment = new ItemMod("Jump_fragment");
        Jump_element = new ItemMod("Jump_element");
        Darkness_fragment = new ItemMod("Darkness_fragment");
        Darkness_element = new ItemMod("Darkness_element");
        Steel_power = new SteelPower("Steel_power");
        Loot_upgrade = new LootUpgrade("Loot_upgrade");
        Generator_power = new ItemMod("Generator_power");
        Obsidian_gem = new ItemModPoppieArmor("Obsidian_gem");
        Four_leaf_clover = new ItemModPoppieArmor("Four_leaf_clover");
        Coal_gem = new ItemModPoppieArmor("Coal_gem");
        Speedster_flesh = new ItemFoodMod("Speedster_flesh", 5, 4, true, new PotionEffect(Potion.getPotionById(1), 400, 2));
        Jumper_flesh = new ItemFoodMod("Jumper_flesh", 5, 4, true, new PotionEffect(Potion.getPotionById(8), 400, 2));
        Darker_flesh = new ItemFoodMod("Darker_flesh", 8, 6, true, new PotionEffect(Potion.getPotionById(10), 200, 2));
        Golden_feather = new ItemMod("Golden_feather");
        Redstone_gem = new ItemModPoppieArmor("Redstone_gem");
        Lapis_gem = new ItemModPoppieArmor("Lapis_gem");
        Quartz_gem = new ItemModPoppieArmor("Quartz_gem");
        Glowstone_gem = new ItemModPoppieArmor("Glowstone_gem");
        Basic_soul = new Basic_soul("Basic_soul");
        Advanced_soul = new Advanced_soul("Advanced_soul");
        Ultimate_soul = new Ultimate_soul("Ultimate_soul");
        Basic_spirit = new Basic_soul("Basic_spirit").setMaxStackSize( 1 );
        Advanced_spirit = new Advanced_soul( "Advanced_spirit" ).setMaxStackSize( 1 );
        Ultimate_spirit = new Ultimate_soul( "Ultimate_spirit" ).setMaxStackSize( 1 );
        Broken_basic_spirit_power = new ItemMod("Broken_basic_spirit_power");
        Basic_spirit_power = new ItemMod("Basic_spirit_power").setContainerItem(Broken_basic_spirit_power);
        Broken_advanced_spirit_power = new ItemMod("Broken_advanced_spirit_power");
        Advanced_spirit_power = new ItemMod("Advanced_spirit_power").setContainerItem(Broken_advanced_spirit_power);
        Broken_ultimate_spirit_power = new ItemMod("Broken_ultimate_spirit_power");
        Ultimate_spirit_power = new ItemMod("Ultimate_spirit_power").setContainerItem(Broken_ultimate_spirit_power);
        Basic_generator_upgrade = new ItemMod1Stack( "Basic_generator_upgrade" );
        Advanced_generator_upgrade = new ItemMod1Stack( "Advanced_generator_upgrade" );
        Burning_carbon = new ItemMod( "Burning_carbon" );

        Bat_Spawn = new SpawnBat("Bat_spawn");
        Chicken_Spawn = new SpawnChicken( "Chicken_spawn" );
        Cow_Spawn = new SpawnCow( "Cow_spawn" );
        Endermite_Spawn = new SpawnEndermite( "Endermite_spawn" );
        Mooshroom_Spawn = new SpawnMooshroom( "Mooshroom_spawn" );
        Ocelot_Spawn = new SpawnOcelot( "Ocelot_spawn" );
        Pig_Spawn = new SpawnPig( "Pig_spawn" );
        Polar_Bear_Spawn = new SpawnPolarBear( "Polar_Bear_spawn" );
        Rabbit_Spawn = new SpawnRabbit( "Rabbit_spawn" );
        Sheep_Spawn = new SpawnSheep( "Sheep_spawn" );
        Shulker_Spawn = new SpawnShulker( "Shulker_spawn" );
        Silverfish_Spawn = new SpawnSilverfish( "Silverfish_spawn" );
        Squid_Spawn = new SpawnSquid( "Squid_spawn" );
        Wolf_Spawn = new SpawnWolf( "Wolf_spawn" );
        Cave_Spider_Spawn = new SpawnCaveSpider( "Cave_Spider_spawn" );
        Creeper_Spawn = new SpawnCreeper( "Creeper_spawn" );
        Donkey_Spawn = new SpawnDonkey( "Donkey_spawn" );
        Guardian_Spawn = new SpawnGuardian( "Guardian_spawn" );
        Horse_Spawn = new SpawnHorse( "Horse_spawn" );
        Husk_Spawn = new SpawnHusk( "Husk_spawn" );
        Mule_Spawn = new SpawnMule( "Mule_spawn" );
        Skeleton_Spawn = new SpawnSkeleton( "Skeleton_spawn" );
        Skeleton_Horse_Spawn = new SpawnSkeletonHorse( "Skeleton_Horse_spawn" );
        Snow_Man_Spawn = new SpawnSnowMan( "Snow_Man_spawn" );
        Spider_Spawn = new SpawnSpider( "Spider_spawn" );
        Villager_Spawn = new SpawnVillager( "Villager_spawn" );
        Zombie_Spawn = new SpawnZombie( "Zombie_spawn" );
        Zombie_Horse_Spawn = new SpawnZombieHorse( "Zombie_Horse_spawn" );

    }





    public static void registerItems() {
        registerItem(Carbon_ingot);
        registerItem(Molten_carbon);
        registerItem( Compressed_carbon );
        registerItem(Pironnite_fragment);
        registerItem(Pironnite_nugget);
        registerItem(Pironnite_ingot);
        registerItem(Poppie_nugget);
        registerItem(Poppie_ingot);
        registerItem(Molten_iron);
        registerItem(Compressed_iron);
        registerItem(Carbon_stick);
        registerItem(Renforced_string);
        registerItem(Golden_string);
        registerItem(Compressed_iron_bottle);
        registerItem(Molten_carbon_bottle);
        registerItem(Poppie_bottle);
        registerItem(Steel_piece);
        registerItem(Steel_nugget);
        registerItem(Steel_ingot);
        registerItem(Speed_fragment);
        registerItem(Speed_element);
        registerItem(Jump_fragment);
        registerItem(Jump_element);
        registerItem(Darkness_fragment);
        registerItem(Darkness_element);
        registerItem(Steel_power);
        registerItem(Loot_upgrade);
        registerItem(Generator_power);
        registerItem(Speedster_flesh);
        registerItem(Jumper_flesh);
        registerItem(Darker_flesh);
        registerItem(Golden_feather);
        registerItem(Basic_soul);
        registerItem(Advanced_soul);
        registerItem(Ultimate_soul);
        registerItem(Basic_spirit);
        registerItem( Advanced_spirit );
        registerItem( Ultimate_spirit );
        registerItem( Broken_basic_spirit_power );
        registerItem( Basic_spirit_power );
        registerItem( Broken_advanced_spirit_power );
        registerItem( Advanced_spirit_power );
        registerItem( Broken_ultimate_spirit_power );
        registerItem( Ultimate_spirit_power );
        registerItem( Basic_generator_upgrade );
        registerItem( Advanced_generator_upgrade );
        registerItem( Burning_carbon );

        registerItem( Bat_Spawn );
        registerItem( Chicken_Spawn );
        registerItem( Cow_Spawn );
        registerItem( Endermite_Spawn );
        registerItem( Mooshroom_Spawn );
        registerItem( Ocelot_Spawn );
        registerItem( Pig_Spawn );
        registerItem( Polar_Bear_Spawn );
        registerItem( Rabbit_Spawn );
        registerItem( Sheep_Spawn );
        registerItem( Shulker_Spawn );
        registerItem( Silverfish_Spawn);
        registerItem( Squid_Spawn );
        registerItem( Wolf_Spawn );
        registerItem( Cave_Spider_Spawn );
        registerItem( Creeper_Spawn );
        registerItem( Donkey_Spawn );
        registerItem( Guardian_Spawn );
        registerItem( Horse_Spawn );
        registerItem( Husk_Spawn );
        registerItem( Mule_Spawn );
        registerItem( Skeleton_Spawn );
        registerItem( Skeleton_Horse_Spawn );
        registerItem( Snow_Man_Spawn );
        registerItem( Spider_Spawn );
        registerItem( Villager_Spawn );
        registerItem( Zombie_Spawn );
        registerItem( Zombie_Horse_Spawn );


        GameRegistry.register(Redstone_gem);
        GameRegistry.register(Redstone_sword);
        GameRegistry.register(Redstone_pickaxe);
        GameRegistry.register(Redstone_shovel);
        GameRegistry.register(Redstone_hoe);
        GameRegistry.register(Redstone_axe);

        GameRegistry.register(Lapis_gem);
        GameRegistry.register(Lapis_sword);
        GameRegistry.register(Lapis_pickaxe);
        GameRegistry.register(Lapis_shovel);
        GameRegistry.register(Lapis_hoe);
        GameRegistry.register(Lapis_axe);

        GameRegistry.register(Quartz_gem);
        GameRegistry.register(Quartz_sword);
        GameRegistry.register(Quartz_pickaxe);
        GameRegistry.register(Quartz_shovel);
        GameRegistry.register(Quartz_hoe);
        GameRegistry.register(Quartz_axe);

        GameRegistry.register(Glowstone_gem);
        GameRegistry.register(Glowstone_sword);
        GameRegistry.register(Glowstone_pickaxe);
        GameRegistry.register(Glowstone_shovel);
        GameRegistry.register(Glowstone_hoe);
        GameRegistry.register(Glowstone_axe);

        GameRegistry.register(Obsidian_gem);
        GameRegistry.register(Obsidian_sword);
        GameRegistry.register(Obsidian_pickaxe);
        GameRegistry.register(Obsidian_shovel);
        GameRegistry.register(Obsidian_hoe);
        GameRegistry.register(Obsidian_axe);

        GameRegistry.register(Four_leaf_clover);
        GameRegistry.register(Four_leaf_clover_sword);
        GameRegistry.register(Four_leaf_clover_pickaxe);
        GameRegistry.register(Four_leaf_clover_shovel);
        GameRegistry.register(Four_leaf_clover_hoe);
        GameRegistry.register(Four_leaf_clover_axe);

        GameRegistry.register(Coal_gem);
        GameRegistry.register(Coal_sword);
        GameRegistry.register(Coal_pickaxe);
        GameRegistry.register(Coal_shovel);
        GameRegistry.register(Coal_hoe);
        GameRegistry.register(Coal_axe);

        GameRegistry.register(Emerald_sword);
        GameRegistry.register(Emerald_pickaxe);
        GameRegistry.register(Emerald_shovel);
        GameRegistry.register(Emerald_hoe);
        GameRegistry.register(Emerald_axe);


    }


    public static void registerRenders() {
        registerRender(Carbon_ingot);
        registerRender(Molten_carbon);
        registerRender( Compressed_carbon );
        registerRender(Pironnite_fragment);
        registerRender(Pironnite_nugget);
        registerRender(Pironnite_ingot);
        registerRender(Poppie_nugget);
        registerRender(Poppie_ingot);
        registerRender(Molten_iron);
        registerRender(Compressed_iron);
        registerRender(Carbon_stick);
        registerRender(Renforced_string);
        registerRender(Golden_string);
        registerRender(Generator_power);
        registerRender(Compressed_iron_bottle);
        registerRenderMeta(Molten_carbon_bottle, 0);
        registerRenderMeta(Molten_carbon_bottle, 1);
        registerRenderMeta(Molten_carbon_bottle, 2);
        registerRenderMeta(Poppie_bottle, 0);
        registerRenderMeta(Poppie_bottle, 1);
        registerRenderMeta(Poppie_bottle, 2);
        for(int i = 0; i < EnumHandler.UpgradeTypes.values().length; i++) {
            registerRender(Loot_upgrade, i, "Loot_upgrade_" + EnumHandler.UpgradeTypes.values()[i].getName());
        }
        registerRender(Steel_piece);
        registerRender(Steel_nugget);
        registerRender(Steel_ingot);
        registerRender(Speed_fragment);
        registerRender(Speed_element);
        registerRender(Jump_fragment);
        registerRender(Jump_element);
        registerRender(Darkness_fragment);
        registerRender(Darkness_element);
        registerRender(Steel_power);
        registerRender(Four_leaf_clover);
        registerRender(Coal_gem);
        registerRender(Speedster_flesh);
        registerRender(Jumper_flesh);
        registerRender(Darker_flesh);
        registerRender(Golden_feather);
        registerRenderMeta(Basic_soul, 0);
        registerRenderMeta(Basic_soul, 1);
        registerRenderMeta(Basic_soul, 2);
        registerRenderMeta(Basic_soul, 3);
        registerRenderMeta(Basic_soul, 4);
        registerRenderMeta(Basic_soul, 5);
        registerRenderMeta(Basic_soul, 6);
        registerRenderMeta(Basic_soul, 7);
        registerRenderMeta(Basic_soul, 8);
        registerRenderMeta(Basic_soul, 9);
        registerRenderMeta(Basic_soul, 10);
        registerRenderMeta(Basic_soul, 11);
        registerRenderMeta(Basic_soul, 12);
        registerRenderMeta(Basic_soul, 13);

        registerRenderMeta(Advanced_soul, 0);
        registerRenderMeta(Advanced_soul, 1);
        registerRenderMeta(Advanced_soul, 2);
        registerRenderMeta(Advanced_soul, 3);
        registerRenderMeta(Advanced_soul, 4);
        registerRenderMeta(Advanced_soul, 5);
        registerRenderMeta(Advanced_soul, 6);
        registerRenderMeta(Advanced_soul, 7);
        registerRenderMeta(Advanced_soul, 8);
        registerRenderMeta(Advanced_soul, 9);
        registerRenderMeta(Advanced_soul, 10);
        registerRenderMeta(Advanced_soul, 11);
        registerRenderMeta(Advanced_soul, 12);
        registerRenderMeta(Advanced_soul, 13);

        registerRenderMeta(Ultimate_soul, 0);
        registerRenderMeta(Ultimate_soul, 1);
        registerRenderMeta(Ultimate_soul, 2);
        registerRenderMeta(Ultimate_soul, 3);
        registerRenderMeta(Ultimate_soul, 4);
        registerRenderMeta(Ultimate_soul, 5);
        registerRenderMeta(Ultimate_soul, 6);
        registerRenderMeta(Ultimate_soul, 7);
        registerRenderMeta(Ultimate_soul, 8);
        registerRenderMeta(Ultimate_soul, 9);
        registerRenderMeta(Ultimate_soul, 10);
        registerRenderMeta(Ultimate_soul, 11);
        registerRenderMeta(Ultimate_soul, 12);

        registerRenderMeta(Basic_spirit, 0);
        registerRenderMeta(Basic_spirit, 1);
        registerRenderMeta(Basic_spirit, 2);
        registerRenderMeta(Basic_spirit, 3);
        registerRenderMeta(Basic_spirit, 4);
        registerRenderMeta(Basic_spirit, 5);
        registerRenderMeta(Basic_spirit, 6);
        registerRenderMeta(Basic_spirit, 7);
        registerRenderMeta(Basic_spirit, 8);
        registerRenderMeta(Basic_spirit, 9);
        registerRenderMeta(Basic_spirit, 10);
        registerRenderMeta(Basic_spirit, 11);
        registerRenderMeta(Basic_spirit, 12);
        registerRenderMeta(Basic_spirit, 13);

        registerRenderMeta(Advanced_spirit, 0);
        registerRenderMeta(Advanced_spirit, 1);
        registerRenderMeta(Advanced_spirit, 2);
        registerRenderMeta(Advanced_spirit, 3);
        registerRenderMeta(Advanced_spirit, 4);
        registerRenderMeta(Advanced_spirit, 5);
        registerRenderMeta(Advanced_spirit, 6);
        registerRenderMeta(Advanced_spirit, 7);
        registerRenderMeta(Advanced_spirit, 8);
        registerRenderMeta(Advanced_spirit, 9);
        registerRenderMeta(Advanced_spirit, 10);
        registerRenderMeta(Advanced_spirit, 11);
        registerRenderMeta(Advanced_spirit, 12);
        registerRenderMeta(Advanced_spirit, 13);

        registerRenderMeta(Ultimate_spirit, 0);
        registerRenderMeta(Ultimate_spirit, 1);
        registerRenderMeta(Ultimate_spirit, 2);
        registerRenderMeta(Ultimate_spirit, 3);
        registerRenderMeta(Ultimate_spirit, 4);
        registerRenderMeta(Ultimate_spirit, 5);
        registerRenderMeta(Ultimate_spirit, 6);
        registerRenderMeta(Ultimate_spirit, 7);
        registerRenderMeta(Ultimate_spirit, 8);
        registerRenderMeta(Ultimate_spirit, 9);
        registerRenderMeta(Ultimate_spirit, 10);
        registerRenderMeta(Ultimate_spirit, 11);
        registerRenderMeta(Ultimate_spirit, 12);

        registerRender(Broken_basic_spirit_power);
        registerRender( Basic_spirit_power );
        registerRender( Broken_advanced_spirit_power );
        registerRender( Advanced_spirit_power );
        registerRender( Broken_ultimate_spirit_power );
        registerRender( Ultimate_spirit_power );
        registerRender( Basic_generator_upgrade );
        registerRender( Advanced_generator_upgrade );
        registerRender( Burning_carbon );

        registerRender( Bat_Spawn );
        registerRender( Chicken_Spawn );
        registerRender( Cow_Spawn );
        registerRender( Endermite_Spawn );
        registerRender( Mooshroom_Spawn );
        registerRender( Ocelot_Spawn );
        registerRender( Pig_Spawn );
        registerRender( Polar_Bear_Spawn );
        registerRender( Rabbit_Spawn );
        registerRender( Sheep_Spawn );
        registerRender( Shulker_Spawn );
        registerRender( Silverfish_Spawn);
        registerRender( Squid_Spawn );
        registerRender( Wolf_Spawn );
        registerRender( Cave_Spider_Spawn );
        registerRender( Creeper_Spawn );
        registerRender( Donkey_Spawn );
        registerRender( Guardian_Spawn );
        registerRender( Horse_Spawn );
        registerRender( Husk_Spawn );
        registerRender( Mule_Spawn );
        registerRender( Skeleton_Spawn );
        registerRender( Skeleton_Horse_Spawn );
        registerRender( Snow_Man_Spawn );
        registerRender( Spider_Spawn );
        registerRender( Villager_Spawn );
        registerRender( Zombie_Spawn );
        registerRender( Zombie_Horse_Spawn );


        registerRender(Redstone_gem);
        registerRender(Redstone_sword);
        registerRender(Redstone_pickaxe);
        registerRender(Redstone_shovel);
        registerRender(Redstone_hoe);
        registerRender(Redstone_axe);

        registerRender(Lapis_gem);
        registerRender(Lapis_sword);
        registerRender(Lapis_pickaxe);
        registerRender(Lapis_shovel);
        registerRender(Lapis_hoe);
        registerRender(Lapis_axe);

        registerRender(Quartz_gem);
        registerRender(Quartz_sword);
        registerRender(Quartz_pickaxe);
        registerRender(Quartz_shovel);
        registerRender(Quartz_hoe);
        registerRender(Quartz_axe);

        registerRender(Glowstone_gem);
        registerRender(Glowstone_sword);
        registerRender(Glowstone_pickaxe);
        registerRender(Glowstone_shovel);
        registerRender(Glowstone_hoe);
        registerRender(Glowstone_axe);

        registerRender(Obsidian_gem);
        registerRender(Obsidian_sword);
        registerRender(Obsidian_pickaxe);
        registerRender(Obsidian_shovel);
        registerRender(Obsidian_hoe);
        registerRender(Obsidian_axe);

        registerRender(Four_leaf_clover);
        registerRender(Four_leaf_clover_sword);
        registerRender(Four_leaf_clover_pickaxe);
        registerRender(Four_leaf_clover_shovel);
        registerRender(Four_leaf_clover_hoe);
        registerRender(Four_leaf_clover_axe);

        registerRender(Coal_gem);
        registerRender(Coal_sword);
        registerRender(Coal_pickaxe);
        registerRender(Coal_shovel);
        registerRender(Coal_hoe);
        registerRender(Coal_axe);

        registerRender(Emerald_sword);
        registerRender(Emerald_pickaxe);
        registerRender(Emerald_shovel);
        registerRender(Emerald_hoe);
        registerRender(Emerald_axe);

    }

    private static void registerRenderMeta(Item item, int meta) {

        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(References.MODID, item.getUnlocalizedName().substring(5) + meta), "inventory"));

    }




    public static void registerItem(Item item) {GameRegistry.register(item);
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(References.MODID, item.getUnlocalizedName().substring(5)), "inventory"));

    }

    private static void registerRender(Item item, int meta , String fileName) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(References.MODID, fileName), "inventory"));

    }



    public static class ToolMaterials {

        public static final Item.ToolMaterial redstoneMat = EnumHelper.addToolMaterial("redstoneMat", 2, 250, 6.0f, 2.0f, 14);
        public static final Item.ToolMaterial lapisMat = EnumHelper.addToolMaterial("lapisMat", 2, 250, 6.0f, 2.0f, 14);
        public static final Item.ToolMaterial quartzMat = EnumHelper.addToolMaterial("quartzMat", 2, 250, 6.0f, 2.0f, 14);
        public static final Item.ToolMaterial glowstoneMat = EnumHelper.addToolMaterial("glowstoneMat", 2, 250, 6.0f, 2.0f, 14);
        public static final Item.ToolMaterial obsidianMat = EnumHelper.addToolMaterial("obsidianMat", 2, 400, 6.0f, 2.0f, 14);
        public static final Item.ToolMaterial leafcloverMat = EnumHelper.addToolMaterial("leafcloverMat", 3, 175, 7.0f, 2.5f, 12);
        public static final Item.ToolMaterial coalMat = EnumHelper.addToolMaterial("coalMat", 2, 175, 5.0f, 2.0f, 14);
        public static final Item.ToolMaterial emeraldMat = EnumHelper.addToolMaterial("emeraldMat", 4, 2000, 10.0f, 4.0f, 8);

    }


}
