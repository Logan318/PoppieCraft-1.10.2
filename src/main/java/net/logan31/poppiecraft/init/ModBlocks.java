package net.logan31.poppiecraft.init;

import net.logan31.poppiecraft.PoppieCraftMod;

import net.logan31.poppiecraft.blocks.*;

import net.minecraftforge.client.model.ModelLoader;
import net.logan31.poppiecraft.Utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

/**
 * Created by johanjulien on 29/06/2017.
 */
public class ModBlocks {
    public ModBlocks() {
        init();
        register();

    }



    public static Block Carbon_ore, Carbon_block, Compressed_carbon_block, Compressed_iron_block, Foundry, Lit_foundry,
    Pironnite_block, Pironnite_ore_OW, Pironnite_ore_N, Poppie_block, Steel_block, Mefferite_ore, Alzanite_ore, Ragmarite_ore,
    Generator_block_basic, Generator_block_advanced, Generator_block_ultimate, Mefferite_block,
    Ragmarite_block, Alzanite_block, Medolite_block;

    public static void init() {

        Carbon_ore = new Block(Material.ROCK).setRegistryName("Carbon_ore").setUnlocalizedName("Carbon_ore").setHardness(3.0f).setResistance(25f).setCreativeTab(PoppieCraftMod.PoppieCraft);
        Carbon_block = new Block(Material.IRON).setRegistryName("Carbon_block").setUnlocalizedName("Carbon_block").setHardness(3.0f).setResistance(25f).setCreativeTab(PoppieCraftMod.PoppieCraft);
        Compressed_carbon_block = new Compressed_iron_block("Compressed_carbon_block");
        Compressed_iron_block = new Compressed_iron_block("Compressed_iron_block");
        Pironnite_block = new Pironnite_block("Pironnite_block", "Pironnite_block");
        Pironnite_ore_OW = new Pironnite_ore_OW("Pironnite_ore_OW", "Pironnite_ore_OW");
        Pironnite_ore_N = new Pironnite_ore_N("Pironnite_ore_N", "Pironnite_ore_N");
        Poppie_block = new Poppie_block("Poppie_block", "Poppie_block");
        Steel_block = new Steel_block("Steel_block", "Steel_block");
        Mefferite_ore = new Mefferite_ore("Mefferite_ore");
        Alzanite_ore = new Alzanite_ore("Alzanite_ore");
        Ragmarite_ore = new Ragmarite_ore("Ragmarite_ore");
        Generator_block_basic = new Generator_block_basic("Generator_block_basic");
        Generator_block_advanced = new Generator_block_advanced("Generator_block_advanced");
        Generator_block_ultimate = new Generator_block_ultimate( "Generator_block_ultimate" );
        Foundry = new Foundry( "Foundry", false );
        Lit_foundry = new Foundry( "Lit_foundry", true );
        Mefferite_block = new Power5_block( "Mefferite_block" );
        Ragmarite_block = new Power5_block( "Ragmarite_block" );
        Alzanite_block = new Power5_block( "Alzanite_block" );
        Medolite_block = new Power5_block( "Medolite_block" );
    }


    public static void register() {
        registerBlock(Carbon_ore);
        registerBlock(Carbon_block);
        registerBlock( Compressed_carbon_block );
        registerBlock(Compressed_iron_block);
        registerBlock(Pironnite_block);
        registerBlock(Pironnite_ore_OW);
        registerBlock(Pironnite_ore_N);
        registerBlock(Poppie_block);
        registerBlock(Steel_block);
        registerBlock(Mefferite_ore);
        registerBlock(Alzanite_ore);
        registerBlock(Ragmarite_ore);
        registerBlock(Generator_block_basic);
        registerBlock(Generator_block_advanced);
        registerBlock( Generator_block_ultimate );
        registerBlock( Foundry );
        registerBlock( Lit_foundry );
        registerBlock( Mefferite_block );
        registerBlock( Ragmarite_block );
        registerBlock( Alzanite_block );
        registerBlock( Medolite_block );

    }


    public static void registerRenders() {
        registerRender(Carbon_ore);
        registerRender(Carbon_block);
        registerRender( Compressed_carbon_block );
        registerRender(Compressed_iron_block);
        registerRender(Pironnite_block);
        registerRender(Pironnite_ore_OW);
        registerRender(Pironnite_ore_N);
        registerRender(Poppie_block);
        registerRender(Steel_block);
        registerRender(Mefferite_ore);
        registerRender(Alzanite_ore);
        registerRender(Ragmarite_ore);
        registerRender(Generator_block_basic);
        registerRender(Generator_block_advanced);
        registerRender( Generator_block_ultimate );
        registerRender( Foundry );
        registerRender( Lit_foundry );
        registerRender( Mefferite_block );
        registerRender( Ragmarite_block );
        registerRender( Alzanite_block );
        registerRender( Medolite_block );

    }



    //-----------------------------------------------------------------------------------------------


    public static void registerBlock(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));

    }

    public static void registerBlock(Block block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));

    }


    private static void registerRender(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(References.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
    }

    private static void registerRenderMeta(Block block, int meta) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(References.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
    }

    private static void registerRender(Block block, int meta, String fileName) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(References.MODID, fileName), "inventory"));
    }

}

