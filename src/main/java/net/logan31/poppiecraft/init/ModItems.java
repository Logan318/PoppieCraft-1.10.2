package net.logan31.poppiecraft.init;

/**
 * Created by johanjulien on 28/06/2017.
 */




import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.handler.EnumHandler;
import net.logan31.poppiecraft.items.*;
import net.minecraft.item.Item;
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



    public static Item Carbon_ingot, Molten_carbon, Redstone_gem, Lapis_gem, Quartz_gem, Glowstone_gem;
    public static Item Pironnite_fragment, Pironnite_nugget, Pironnite_ingot, Poppie_nugget, Poppie_ingot;
    public static Item Molten_iron, Compressed_iron, Carbon_stick, Renforced_string, Golden_string;
    public static Item Compressed_iron_bottle, Molten_carbon_bottle, Poppie_bottle, Steel_piece, Steel_nugget, Steel_ingot;
    public static Item Speed_fragment, Speed_element, Jump_fragment, Jump_element, Darkness_fragment, Darkness_element;
    public static Item Steel_power, Loot_upgrade, Generator_power;

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

    public static final Item Emerald_sword = new Emeraldsword("Emerald_sword", ToolMaterials.emeraldMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Emerald_pickaxe = new Emeraldpickaxe("Emerald_pickaxe", ToolMaterials.emeraldMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Emerald_shovel = new Emeraldshovel("Emerald_shovel", ToolMaterials.emeraldMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Emerald_hoe = new Emeraldhoe("Emerald_hoe", ToolMaterials.emeraldMat).setCreativeTab(PoppieCraftMod.PoppieArmor);
    public static final Item Emerald_axe = new Emeraldaxe("Emerald_axe", ToolMaterials.emeraldMat, 10.0f, -3.1f).setCreativeTab(PoppieCraftMod.PoppieArmor);


    public static void initItems() {
       Carbon_ingot = new Carbon_ingot("Carbon_ingot");
        Molten_carbon = new Molten_carbon("Molten_carbon");
        Pironnite_fragment = new Pironnite_fragment("Pironnite_fragment");
        Pironnite_nugget = new Pironnite_nugget("Pironnite_nugget");
        Pironnite_ingot = new Pironnite_ingot("Pironnite_ingot");
        Poppie_nugget = new Poppie_nugget("Poppie_nugget");
        Poppie_ingot = new Poppie_ingot("Poppie_ingot");
        Molten_iron = new Molten_iron("Molten_iron");
        Compressed_iron = new Compressed_iron("Compressed_iron");
        Carbon_stick = new Carbon_stick("Carbon_stick");
        Renforced_string = new Renforced_string("Renforced_string");
        Golden_string = new Golden_string("Golden_string");
        Compressed_iron_bottle = new Compressed_iron_bottle("Compressed_iron_bottle");
        Molten_carbon_bottle = new Molten_carbon_bottle("Molten_carbon_bottle");
        Poppie_bottle = new Poppie_bottle("Poppie_bottle");
        Steel_piece = new Steel_piece("Steel_piece");
        Steel_nugget = new Steel_nugget("Steel_nugget");
        Steel_ingot = new Steel_ingot("Steel_ingot");
        Speed_fragment = new Speed_fragment("Speed_fragment");
        Speed_element = new Speed_element("Speed_element");
        Jump_fragment = new Jump_fragment("Jump_fragment");
        Jump_element = new Jump_element("Jump_element");
        Darkness_fragment = new Darkness_fragment("Darkness_fragment");
        Darkness_element = new Darkness_element("Darkness_element");
        Steel_power = new Steel_power("Steel_power");
        Loot_upgrade = new LootUpgrade("Loot_upgrade");
        Generator_power = new Generator_power("Generator_power");

        Redstone_gem = new Item().setRegistryName("Redstone_gem").setUnlocalizedName("Redstone_gem").setCreativeTab(PoppieCraftMod.PoppieArmor);
        Lapis_gem = new Item().setRegistryName("Lapis_gem").setUnlocalizedName("Lapis_gem").setCreativeTab(PoppieCraftMod.PoppieArmor);
        Quartz_gem = new Item().setRegistryName("Quartz_gem").setUnlocalizedName("Quartz_gem").setCreativeTab(PoppieCraftMod.PoppieArmor);
        Glowstone_gem = new Item().setRegistryName("Glowstone_gem").setUnlocalizedName("Glowstone_gem").setCreativeTab(PoppieCraftMod.PoppieArmor);

    }


    public static void registerItems() {
        registerItem(Carbon_ingot);
        registerItem(Molten_carbon);
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

        GameRegistry.register(Emerald_sword);
        GameRegistry.register(Emerald_pickaxe);
        GameRegistry.register(Emerald_shovel);
        GameRegistry.register(Emerald_hoe);
        GameRegistry.register(Emerald_axe);


    }


    public static void registerRenders() {
        registerRender(Carbon_ingot);
        registerRender(Molten_carbon);
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
        public static final Item.ToolMaterial emeraldMat = EnumHelper.addToolMaterial("emeraldMat", 4, 2000, 10.0f, 4.0f, 8);

    }


}
