package net.logan31.poppiecraft.init;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by johanjulien on 30/06/2017.
 */
public class ModRecipes {

    public void registerCraftRecipes() {


        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Generator_power), new Object[]{"EGE", "GPG", "EGE", 'E', Items.EMERALD, 'G', Blocks.GOLD_BLOCK, 'P', Items.ENDER_PEARL});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Loot_upgrade, 1, 0), new Object[]{"CDC", "DBD", "CMC", 'C', ModBlocks.Carbon_block, 'D', Items.DIAMOND, 'M', Items.BLAZE_ROD, 'B', Items.BOOK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Loot_upgrade, 1, 1), new Object[]{"CDC", "DBD", "CMC", 'C', ModBlocks.Carbon_block, 'D', Items.EMERALD, 'M', Items.GHAST_TEAR, 'B', new ItemStack(ModItems.Loot_upgrade, 0, 0)});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Loot_upgrade, 1, 2), new Object[]{"CDC", "DBD", "CMC", 'C', ModBlocks.Carbon_block, 'D', Items.NETHER_STAR, 'M', new ItemStack(Items.SKULL, 1, 1), 'B', new ItemStack(ModItems.Loot_upgrade, 0, 1)});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Generator_block, 1, 0), new Object[]{"CDC", "DBD", "CDC", 'C', Blocks.COAL_BLOCK, 'D', ModItems.Pironnite_ingot, 'B', ModItems.Generator_power});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Generator_block, 1, 1), new Object[]{"CDC", "DBD", "CDC", 'C', Blocks.LAPIS_BLOCK, 'D', ModItems.Poppie_ingot, 'B', new ItemStack(ModBlocks.Generator_block, 1, 0)});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Generator_block, 1, 2), new Object[]{"CDC", "DBD", "CDC", 'C', Blocks.DIAMOND_BLOCK, 'D', ModItems.Steel_ingot, 'B', new ItemStack(ModBlocks.Generator_block, 1, 1)});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Carbon_block), new Object[]{"CCC", "CCC", "CCC", 'C', ModItems.Carbon_ingot});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Carbon_ingot, 9), new Object[] {ModBlocks.Carbon_block});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Pironnite_nugget), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Pironnite_fragment});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Pironnite_fragment, 9), new Object[] {ModItems.Pironnite_nugget});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Pironnite_ingot), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Pironnite_nugget});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Pironnite_nugget, 9), new Object[] {ModItems.Pironnite_ingot});

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Speed_element), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Speed_fragment});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Speed_fragment, 9), new Object[] {ModItems.Speed_element});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Jump_element), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Jump_fragment});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Jump_fragment, 9), new Object[] {ModItems.Jump_element});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Darkness_element), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Darkness_fragment});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Darkness_fragment, 9), new Object[] {ModItems.Darkness_element});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Steel_power), new Object[] {"sSs", "dDd", "jJj", 's', ModItems.Speed_fragment, 'S', ModItems.Speed_element, 'd', ModItems.Darkness_fragment, 'D', ModItems.Darkness_element, 'j', ModItems.Jump_fragment, 'J', ModItems.Jump_element});

        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.Carbon_block), new Object[] {ModItems.Molten_carbon});
        GameRegistry.addRecipe(new ItemStack(ModItems.Carbon_stick), "C", "C", " ", 'C', ModItems.Carbon_ingot);
        GameRegistry.addRecipe(new ItemStack(ModItems.Carbon_stick), " ", "C", "C", 'C', ModItems.Carbon_ingot);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Renforced_string), new Object[] {"CSC", "SBS", "CSC", 'C', ModItems.Carbon_ingot, 'S', Items.STRING, 'B', ModBlocks.Carbon_block});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Golden_string), new Object[] {"BSB", "ISI", "BSB", 'B', Blocks.GOLD_BLOCK, 'S', ModItems.Renforced_string, 'I', Items.GOLD_INGOT});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Compressed_iron_bottle, 3), new Object[] {"C C", " C ", "   ", 'C', ModItems.Compressed_iron});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Compressed_iron_bottle, 3), new Object[] {"   ", "C C", " C ", 'C', ModItems.Compressed_iron});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Pironnite_block), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Pironnite_ingot});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Pironnite_ingot, 9), new Object[] {ModBlocks.Pironnite_block});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Pironnite_block), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Pironnite_ingot});

        //Steel
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Steel_nugget), new Object[] {ModItems.Steel_piece, ModItems.Steel_piece, ModItems.Steel_piece});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Steel_ingot), new Object[]{"CCC", "CCC", "CCC", 'C', ModItems.Steel_nugget});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Steel_nugget, 9), new Object[] {ModItems.Steel_ingot});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Steel_block), new Object[]{"CCC", "CCC", "CCC", 'C', ModItems.Steel_ingot});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Steel_ingot, 9), new Object[] {ModBlocks.Steel_block});

        //Poppie
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Poppie_nugget, 3), new Object[] {"FDF", "FEF", "FPF", 'F', Blocks.IRON_BLOCK, 'D', Items.DIAMOND, 'E', Items.EMERALD, 'P', ModItems.Pironnite_ingot});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Poppie_ingot), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Poppie_nugget});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Poppie_nugget, 9), new Object[] {ModItems.Poppie_ingot});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Poppie_block), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Poppie_ingot});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Poppie_ingot, 9), new Object[] {ModBlocks.Poppie_block});

        //Compressed iron
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.IRON_BLOCK), new Object[] {ModItems.Molten_iron});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Compressed_iron), new Object[] {"   ", " MM", " MM", 'M', ModItems.Molten_iron});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Compressed_iron), new Object[] {"   ", "MM ", "MM ", 'M', ModItems.Molten_iron});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Compressed_iron), new Object[] {" MM", " MM", "   ", 'M', ModItems.Molten_iron});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Compressed_iron), new Object[] {"MM ", "MM ", "   ", 'M', ModItems.Molten_iron});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Molten_iron, 4), new Object[] {ModItems.Compressed_iron});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Compressed_iron_block), new Object[] {"CCC", "CCC", "CCC", 'C', ModItems.Compressed_iron});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Compressed_iron, 9), new Object[] {ModBlocks.Compressed_iron_block});

        //Redstone
        GameRegistry.addRecipe(new ItemStack(ModItems.Redstone_sword), "R", "R", "S", 'R', ModItems.Redstone_gem, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(ModItems.Redstone_shovel), "R", "S", "S", 'R', ModItems.Redstone_gem, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Redstone_hoe), new Object[]{"RR ", " S ", " S ", 'R', ModItems.Redstone_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Redstone_hoe), new Object[]{" RR", " S ", " S ", 'R', ModItems.Redstone_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Redstone_axe), new Object[]{" RR", " SR", " S ", 'R', ModItems.Redstone_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Redstone_axe), new Object[]{"RR ", "RS ", " S ", 'R', ModItems.Redstone_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Redstone_pickaxe), new Object[]{"RRR", " S ", " S ", 'R', ModItems.Redstone_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Redstone_helmet), new Object[]{"RRR", "R R", "   ", 'R', ModItems.Redstone_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Redstone_helmet), new Object[]{"   ", "RRR", "R R", 'R', ModItems.Redstone_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Redstone_chestplate), new Object[]{"R R", "RRR", "RRR", 'R', ModItems.Redstone_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Redstone_leggings), new Object[]{"RRR", "R R", "R R", 'R', ModItems.Redstone_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Redstone_boots), new Object[]{"   ", "R R", "R R", 'R', ModItems.Redstone_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Redstone_boots), new Object[]{"R R", "R R", "   ", 'R', ModItems.Redstone_gem});

        //Lapis
        GameRegistry.addRecipe(new ItemStack(ModItems.Lapis_sword), "R", "R", "S", 'R', ModItems.Lapis_gem, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(ModItems.Lapis_shovel), "R", "S", "S", 'R', ModItems.Lapis_gem, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Lapis_hoe), new Object[]{"RR ", " S ", " S ", 'R', ModItems.Lapis_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Lapis_hoe), new Object[]{" RR", " S ", " S ", 'R', ModItems.Lapis_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Lapis_axe), new Object[]{" RR", " SR", " S ", 'R', ModItems.Lapis_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Lapis_axe), new Object[]{"RR ", "RS ", " S ", 'R', ModItems.Lapis_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Lapis_pickaxe), new Object[]{"RRR", " S ", " S ", 'R', ModItems.Lapis_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Lapis_helmet), new Object[]{"RRR", "R R", "   ", 'R', ModItems.Lapis_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Lapis_helmet), new Object[]{"   ", "RRR", "R R", 'R', ModItems.Lapis_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Lapis_chestplate), new Object[]{"R R", "RRR", "RRR", 'R', ModItems.Lapis_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Lapis_leggings), new Object[]{"RRR", "R R", "R R", 'R', ModItems.Lapis_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Lapis_boots), new Object[]{"   ", "R R", "R R", 'R', ModItems.Lapis_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Lapis_boots), new Object[]{"R R", "R R", "   ", 'R', ModItems.Lapis_gem});

        //Quartz
        GameRegistry.addRecipe(new ItemStack(ModItems.Quartz_sword), "R", "R", "S", 'R', ModItems.Quartz_gem, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(ModItems.Quartz_shovel), "R", "S", "S", 'R', ModItems.Quartz_gem, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Quartz_hoe), new Object[]{"RR ", " S ", " S ", 'R', ModItems.Quartz_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Quartz_hoe), new Object[]{" RR", " S ", " S ", 'R', ModItems.Quartz_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Quartz_axe), new Object[]{" RR", " SR", " S ", 'R', ModItems.Quartz_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Quartz_axe), new Object[]{"RR ", "RS ", " S ", 'R', ModItems.Quartz_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Quartz_pickaxe), new Object[]{"RRR", " S ", " S ", 'R', ModItems.Quartz_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Quartz_helmet), new Object[]{"RRR", "R R", "   ", 'R', ModItems.Quartz_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Quartz_helmet), new Object[]{"   ", "RRR", "R R", 'R', ModItems.Quartz_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Quartz_chestplate), new Object[]{"R R", "RRR", "RRR", 'R', ModItems.Quartz_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Quartz_leggings), new Object[]{"RRR", "R R", "R R", 'R', ModItems.Quartz_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Quartz_boots), new Object[]{"   ", "R R", "R R", 'R', ModItems.Quartz_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Quartz_boots), new Object[]{"R R", "R R", "   ", 'R', ModItems.Quartz_gem});

        //Glowstone
        GameRegistry.addRecipe(new ItemStack(ModItems.Glowstone_sword), "R", "R", "S", 'R', ModItems.Glowstone_gem, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(ModItems.Glowstone_shovel), "R", "S", "S", 'R', ModItems.Glowstone_gem, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Glowstone_hoe), new Object[]{"RR ", " S ", " S ", 'R', ModItems.Glowstone_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Glowstone_hoe), new Object[]{" RR", " S ", " S ", 'R', ModItems.Glowstone_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Glowstone_axe), new Object[]{" RR", " SR", " S ", 'R', ModItems.Glowstone_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Glowstone_axe), new Object[]{"RR ", "RS ", " S ", 'R', ModItems.Glowstone_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Glowstone_pickaxe), new Object[]{"RRR", " S ", " S ", 'R', ModItems.Glowstone_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Glowstone_helmet), new Object[]{"RRR", "R R", "   ", 'R', ModItems.Glowstone_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Glowstone_helmet), new Object[]{"   ", "RRR", "R R", 'R', ModItems.Glowstone_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Glowstone_chestplate), new Object[]{"R R", "RRR", "RRR", 'R', ModItems.Glowstone_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Glowstone_leggings), new Object[]{"RRR", "R R", "R R", 'R', ModItems.Glowstone_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Glowstone_boots), new Object[]{"   ", "R R", "R R", 'R', ModItems.Glowstone_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Glowstone_boots), new Object[]{"R R", "R R", "   ", 'R', ModItems.Glowstone_gem});

        //Emerald
        GameRegistry.addRecipe(new ItemStack(ModItems.Emerald_sword), "R", "R", "S", 'R', Items.EMERALD, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(ModItems.Emerald_shovel), "R", "S", "S", 'R', Items.EMERALD, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Emerald_hoe), new Object[]{"RR ", " S ", " S ", 'R', Items.EMERALD, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Emerald_hoe), new Object[]{" RR", " S ", " S ", 'R', Items.EMERALD, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Emerald_axe), new Object[]{" RR", " SR", " S ", 'R', Items.EMERALD, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Emerald_axe), new Object[]{"RR ", "RS ", " S ", 'R', Items.EMERALD, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Emerald_pickaxe), new Object[]{"RRR", " S ", " S ", 'R', Items.EMERALD, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Emerald_helmet), new Object[]{"RRR", "R R", "   ", 'R', Items.EMERALD});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Emerald_helmet), new Object[]{"   ", "RRR", "R R", 'R', Items.EMERALD});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Emerald_chestplate), new Object[]{"R R", "RRR", "RRR", 'R', Items.EMERALD});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Emerald_leggings), new Object[]{"RRR", "R R", "R R", 'R', Items.EMERALD});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Emerald_boots), new Object[]{"   ", "R R", "R R", 'R', Items.EMERALD});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Emerald_boots), new Object[]{"R R", "R R", "   ", 'R', Items.EMERALD});
    }

    public void registerFurnaceRecipes() {

        GameRegistry.addSmelting(Blocks.REDSTONE_BLOCK, new ItemStack(ModItems.Redstone_gem, 1), 0.7f);
        GameRegistry.addSmelting(Blocks.LAPIS_BLOCK, new ItemStack(ModItems.Lapis_gem, 1), 0.7f);
        GameRegistry.addSmelting(Blocks.QUARTZ_BLOCK, new ItemStack(ModItems.Quartz_gem, 1), 0.7f);
        GameRegistry.addSmelting(Blocks.GLOWSTONE, new ItemStack(ModItems.Glowstone_gem, 1), 0.7f);
        GameRegistry.addSmelting(ModBlocks.Carbon_ore, new ItemStack(ModItems.Carbon_ingot, 1), 0.7f);

        GameRegistry.addSmelting(Blocks.IRON_BLOCK, new ItemStack(ModItems.Molten_iron, 1), 0.7f);



    }

    public void registerBrewingRecipes() {

        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Compressed_iron_bottle), new ItemStack(ModItems.Molten_carbon), new ItemStack(ModItems.Molten_carbon_bottle, 1, 0));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Molten_carbon_bottle, 1, 0), new ItemStack(ModItems.Molten_carbon), new ItemStack(ModItems.Molten_carbon_bottle, 1, 1));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Molten_carbon_bottle, 1, 1), new ItemStack(ModItems.Molten_carbon), new ItemStack(ModItems.Molten_carbon_bottle, 1, 2));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Molten_carbon_bottle, 1, 2), new ItemStack(ModItems.Poppie_nugget), new ItemStack(ModItems.Poppie_bottle, 1, 0));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Poppie_bottle, 1, 0), new ItemStack(ModItems.Poppie_nugget), new ItemStack(ModItems.Poppie_bottle, 1, 1));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Poppie_bottle, 1, 1), new ItemStack(ModItems.Poppie_nugget), new ItemStack(ModItems.Poppie_bottle, 1, 2));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Poppie_bottle, 1, 2), new ItemStack(Items.LAVA_BUCKET), new ItemStack(ModItems.Steel_piece));


    }




}
