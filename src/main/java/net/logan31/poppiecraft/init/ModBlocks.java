package net.logan31.poppiecraft.init;

import net.logan31.poppiecraft.PoppieCraftMod;

import net.logan31.poppiecraft.blocks.*;
import net.logan31.poppiecraft.blocks.item.ItemGeneratorBlock;
import net.logan31.poppiecraft.handler.EnumHandler;
import net.minecraftforge.client.model.ModelLoader;
import net.logan31.poppiecraft.Utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.openal.AL;

import javax.tools.Tool;

/**
 * Created by johanjulien on 29/06/2017.
 */
public class ModBlocks {
    public ModBlocks() {
        init();
        register();

    }



    public static Block Carbon_ore, Carbon_block, Compressed_iron_block, Melter, Pironnite_block, Pironnite_ore_OW;
    public static Block  Pironnite_ore_N, Poppie_block, Steel_block, Mefferite_ore, Alzanite_ore, Ragmarite_ore;
    public static Block Generator_block;

    public static void init() {

        Carbon_ore = new Block(Material.ROCK).setRegistryName("Carbon_ore").setUnlocalizedName("Carbon_ore").setHardness(3.0f).setResistance(25f).setCreativeTab(PoppieCraftMod.PoppieCraft);
        Carbon_block = new Block(Material.IRON).setRegistryName("Carbon_block").setUnlocalizedName("Carbon_block").setHardness(3.0f).setResistance(25f).setCreativeTab(PoppieCraftMod.PoppieCraft);
        Compressed_iron_block = new Compressed_iron_block("Compressed_iron_block", "Compressed_iron_block");
        Melter = new Melter("Melter", "Melter");
        Pironnite_block = new Pironnite_block("Pironnite_block", "Pironnite_block");
        Pironnite_ore_OW = new Pironnite_ore_OW("Pironnite_ore_OW", "Pironnite_ore_OW");
        Pironnite_ore_N = new Pironnite_ore_N("Pironnite_ore_N", "Pironnite_ore_N");
        Poppie_block = new Poppie_block("Poppie_block", "Poppie_block");
        Steel_block = new Steel_block("Steel_block", "Steel_block");
        Mefferite_ore = new Mefferite_ore("Mefferite_ore");
        Alzanite_ore = new Alzanite_ore("Alzanite_ore");
        Ragmarite_ore = new Ragmarite_ore("Ragmarite_ore");
        Generator_block = new GeneratorBlock("Generator_block");
    }


    public static void register() {
        registerBlock(Carbon_ore);
        registerBlock(Carbon_block);
        registerBlock(Compressed_iron_block);
        registerBlock(Melter);
        registerBlock(Pironnite_block);
        registerBlock(Pironnite_ore_OW);
        registerBlock(Pironnite_ore_N);
        registerBlock(Poppie_block);
        registerBlock(Steel_block);
        registerBlock(Mefferite_ore);
        registerBlock(Alzanite_ore);
        registerBlock(Ragmarite_ore);
        registerBlock(Generator_block, new ItemGeneratorBlock(Generator_block));

    }


    public static void registerRenders() {
        registerRender(Carbon_ore);
        registerRender(Carbon_block);
        registerRender(Compressed_iron_block);
        registerRender(Melter);
        registerRender(Pironnite_block);
        registerRender(Pironnite_ore_OW);
        registerRender(Pironnite_ore_N);
        registerRender(Poppie_block);
        registerRender(Steel_block);
        registerRender(Mefferite_ore);
        registerRender(Alzanite_ore);
        registerRender(Ragmarite_ore);
        for(int i = 0; i < EnumHandler.UpgradeTypes.values().length; i++) {
            registerRender(Generator_block, i, "Generator_block_" + EnumHandler.UpgradeTypes.values()[i].getName());
        }
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

    private static void registerRender(Block block, int meta, String fileName) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(References.MODID, fileName), "inventory"));
    }

}

