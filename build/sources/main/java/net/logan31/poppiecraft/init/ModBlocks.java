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
        registers();
        registerItemBlocks();
    }



    public static Block Carbon_ore, Carbon_block, Compressed_iron_block, Melter, Pironnite_block, Pironnite_ore_OW;
    public static Block  Pironnite_ore_N, Poppie_block, Steel_block, Mefferite_ore, Alzanite_ore, Ragmarite_ore;

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
    }


    public static void registers() {
        register(Carbon_ore);
        register(Carbon_block);
        register(Compressed_iron_block);
        register(Melter);
        register(Pironnite_block);
        register(Pironnite_ore_OW);
        register(Pironnite_ore_N);
        register(Poppie_block);
        register(Steel_block);
        register(Mefferite_ore);
        register(Alzanite_ore);
        register(Ragmarite_ore);

    }


    public static void registerRenders() {
        registerRender(Carbon_ore, 0);
        registerRender(Carbon_block, 0);
        registerRender(Compressed_iron_block, 0);
        registerRender(Melter, 0);
        registerRender(Pironnite_block, 0);
        registerRender(Pironnite_ore_OW, 0);
        registerRender(Pironnite_ore_N, 0);
        registerRender(Poppie_block, 0);
        registerRender(Steel_block, 0);
        registerRender(Mefferite_ore, 0);
        registerRender(Alzanite_ore, 0);
        registerRender(Ragmarite_ore, 0);
    }

    public static void registerItemBlocks() {
            registerItemBlock(Carbon_ore);
            registerItemBlock(Carbon_block);
            registerItemBlock(Compressed_iron_block);
            registerItemBlock(Melter);
            registerItemBlock(Pironnite_block);
            registerItemBlock(Pironnite_ore_OW);
            registerItemBlock(Pironnite_ore_N);
            registerItemBlock(Poppie_block);
            registerItemBlock(Steel_block);
            registerItemBlock(Mefferite_ore);
            registerItemBlock(Alzanite_ore);
            registerItemBlock(Ragmarite_ore);
    }


    //-----------------------------------------------------------------------------------------------


    public static void register(Block block) {
        GameRegistry.register(block);

    }


    private static void registerRender(Block block, int meta) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(References.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
    }

    public static void registerItemBlock(Block block) {
        ItemBlock ib = new ItemBlock(block);
        ib.setRegistryName(block.getRegistryName());
        GameRegistry.register(ib);
    }

}

