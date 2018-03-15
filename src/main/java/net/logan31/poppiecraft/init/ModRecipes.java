package net.logan31.poppiecraft.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;


/**
 * Created by johanjulien on 30/06/2017.
 */
public class ModRecipes {

    public void registerCraftRecipes() {

        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.Carbon_block), new Object[] {ModItems.Molten_carbon});
        GameRegistry.addRecipe(new ItemStack(ModItems.Carbon_stick), "C", "C", 'C', ModItems.Carbon_ingot);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Renforced_string), new Object[] {"CSC", "SBS", "CSC", 'C', ModItems.Carbon_ingot, 'S', Items.STRING, 'B', ModBlocks.Carbon_block});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Golden_string), new Object[] {"BSB", "ISI", "BSB", 'B', Blocks.GOLD_BLOCK, 'S', ModItems.Renforced_string, 'I', Items.GOLD_INGOT});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Compressed_iron_bottle, 3), new Object[] {"C C", " C ", "   ", 'C', ModItems.Compressed_iron});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Compressed_iron_bottle, 3), new Object[] {"   ", "C C", " C ", 'C', ModItems.Compressed_iron});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Pironnite_block), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Pironnite_ingot});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Pironnite_ingot, 9), new Object[] {ModBlocks.Pironnite_block});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Pironnite_block), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Pironnite_ingot});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Carbon_block), new Object[]{"CCC", "CCC", "CCC", 'C', ModItems.Carbon_ingot});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Carbon_ingot, 9), new Object[] {ModBlocks.Carbon_block});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Pironnite_nugget), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Pironnite_fragment});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Pironnite_fragment, 9), new Object[] {ModItems.Pironnite_nugget});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Pironnite_ingot), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Pironnite_nugget});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Pironnite_nugget, 9), new Object[] {ModItems.Pironnite_ingot});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Burning_carbon, 2), new Object[] {"PCP", "CPC", "PCP", 'P', Items.GUNPOWDER, 'C', ModItems.Carbon_ingot});

        //Medolite
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Medolite_ingot), new Object[] {"MMM", "MMM", "MMM", 'M', ModItems.Medolite_nugget});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Medolite_block), new Object[] {"MMM", "MMM", "MMM", 'M', ModItems.Medolite_ingot});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Medolite_ingot, 9), new Object[] {ModBlocks.Medolite_block});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Medolite_nugget, 9), new Object[] {ModItems.Medolite_ingot});
        //Foundry
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Foundry_upgrade, 1, 0), new Object[] {"PCP", "CSC", "PCP", 'P', ModItems.Pironnite_ingot, 'C', ModItems.Burning_carbon, 'S', ModItems.Steel_power});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Foundry_upgrade, 1, 1), new Object[] {"PCP", "CSC", "PCP", 'P', ModItems.Poppie_ingot, 'C', ModItems.Burning_carbon, 'S', new ItemStack( ModItems.Foundry_upgrade, 1, 0 )});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Foundry ), new Object[] {"CIC", "IPI", "CIC", 'P', ModBlocks.Pironnite_block, 'C', ModItems.Compressed_carbon, 'I', ModItems.Compressed_iron});

        //Mefferite / Ragmarite / Alzanite
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Mefferite_ingot), new Object[] {"MMM", "MMM", "MMM", 'M', ModItems.Mefferite_nugget});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Mefferite_block), new Object[] {"MMM", "MMM", "MMM", 'M', ModItems.Mefferite_ingot});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Mefferite_ingot, 9), new Object[] {ModBlocks.Mefferite_block});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Mefferite_nugget, 9), new Object[] {ModItems.Mefferite_ingot});

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Ragmarite_ingot), new Object[] {"MMM", "MMM", "MMM", 'M', ModItems.Ragmarite_nugget});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Ragmarite_block), new Object[] {"MMM", "MMM", "MMM", 'M', ModItems.Ragmarite_ingot});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Ragmarite_ingot, 9), new Object[] {ModBlocks.Ragmarite_block});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Ragmarite_nugget, 9), new Object[] {ModItems.Ragmarite_ingot});

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Alzanite_ingot), new Object[] {"MMM", "MMM", "MMM", 'M', ModItems.Alzanite_nugget});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Alzanite_block), new Object[] {"MMM", "MMM", "MMM", 'M', ModItems.Alzanite_ingot});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Alzanite_ingot, 9), new Object[] {ModBlocks.Alzanite_block});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Alzanite_nugget, 9), new Object[] {ModItems.Alzanite_ingot});

        //Craft Generators
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Generator_power), new Object[]{"EGE", "GPG", "EGE", 'E', Items.EMERALD, 'G', Blocks.GOLD_BLOCK, 'P', Items.ENDER_PEARL});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Loot_upgrade, 1, 0), new Object[]{"CDC", "DBD", "CMC", 'C', ModBlocks.Carbon_block, 'D', Items.DIAMOND, 'M', Items.BLAZE_ROD, 'B', Items.BOOK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Loot_upgrade, 1, 1), new Object[]{"CDC", "DBD", "CMC", 'C', ModBlocks.Carbon_block, 'D', Items.EMERALD, 'M', Items.GHAST_TEAR, 'B', new ItemStack(ModItems.Loot_upgrade, 0, 0)});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Loot_upgrade, 1, 2), new Object[]{"CDC", "DBD", "CMC", 'C', ModBlocks.Carbon_block, 'D', Items.NETHER_STAR, 'M', new ItemStack(Items.SKULL, 1, 1), 'B', new ItemStack(ModItems.Loot_upgrade, 0, 1)});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Generator_block_basic, 1), new Object[]{"CDC", "DBD", "CDC", 'C', Blocks.COAL_BLOCK, 'D', ModItems.Pironnite_ingot, 'B', ModItems.Generator_power});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Generator_block_advanced, 1), new Object[]{"CDC", "DBD", "CDC", 'C', Blocks.LAPIS_BLOCK, 'D', ModItems.Poppie_ingot, 'B', new ItemStack(ModBlocks.Generator_block_basic, 1)});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Generator_block_ultimate, 1), new Object[]{"CDC", "DBD", "CDC", 'C', Blocks.DIAMOND_BLOCK, 'D', ModItems.Steel_ingot, 'B', new ItemStack(ModBlocks.Generator_block_advanced, 1)});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Basic_generator_upgrade, 1), new Object[]{"CDC", "DBD", "CDC", 'C', Blocks.LAPIS_BLOCK, 'D', ModItems.Poppie_ingot, 'B', Items.COAL});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Advanced_generator_upgrade, 1), new Object[]{"CDC", "DBD", "CDC", 'C', Blocks.DIAMOND_BLOCK, 'D', ModItems.Steel_ingot, 'B', new ItemStack( Items.DYE, 1, 4 )});

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Broken_basic_spirit_power), new Object[]{"EPE", "CDI", "WEY", 'E', Items.EMERALD, 'P', Items.ENDER_PEARL, 'I', ModBlocks.Compressed_iron_block, 'C', ModBlocks.Compressed_carbon_block, 'D', Blocks.DIAMOND_BLOCK, 'W', ModItems.Compressed_carbon, 'Y', ModItems.Compressed_iron});
        GameRegistry.addShapedRecipe( new ItemStack( ModItems.Basic_spirit_power ), new Object[]{"BWB", "WPW", "BWB", 'B', Items.BLAZE_ROD, 'W', Blocks.NETHER_WART_BLOCK, 'P', ModItems.Broken_basic_spirit_power} );
        GameRegistry.addShapedRecipe( new ItemStack( ModItems.Broken_advanced_spirit_power ), new Object[]{"CPC", "BEB", "CBC", 'C', Items.END_CRYSTAL, 'P', ModItems.Basic_spirit_power, 'B', ModItems.Broken_basic_spirit_power, 'E', Blocks.EMERALD_BLOCK} );
        GameRegistry.addShapedRecipe( new ItemStack( ModItems.Advanced_spirit_power ), new Object[]{"TMT", "MBM", "TMT", 'T', Blocks.TNT, 'M', ModItems.Molten_iron, 'B', ModItems.Broken_advanced_spirit_power} );
        GameRegistry.addShapedRecipe( new ItemStack( ModItems.Broken_ultimate_spirit_power ), new Object[]{"NAN", "BDB", "NBN", 'N', Items.NETHER_STAR, 'A', ModItems.Advanced_spirit_power, 'B', ModItems.Broken_advanced_spirit_power, 'D', Blocks.DRAGON_EGG} );

        for(int meta = 0; meta <= 13; meta++) {
            GameRegistry.addShapedRecipe( new ItemStack( ModItems.Basic_spirit, 1, meta), new Object[]{"BBB", "BPB", "BBB", 'B', new ItemStack(ModItems.Basic_soul, 1, meta), 'P', ModItems.Basic_spirit_power} );
        }

        for(int meta = 0; meta <= 12; meta++) {
            GameRegistry.addShapedRecipe( new ItemStack( ModItems.Advanced_spirit, 1, meta), new Object[]{"BBB", "BPB", "BBB", 'B', new ItemStack(ModItems.Advanced_soul, 1, meta), 'P', ModItems.Advanced_spirit_power} );
        }

        for(int meta = 0; meta <= 12; meta++) {
            GameRegistry.addShapedRecipe( new ItemStack( ModItems.Ultimate_spirit, 1, meta), new Object[]{"BBB", "BPB", "BBB", 'B', new ItemStack(ModItems.Ultimate_soul, 1, meta), 'P', ModItems.Ultimate_spirit_power} );
        }


        //Craft Loot Mobs
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Speed_element), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Speed_fragment});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Speed_fragment, 9), new Object[] {ModItems.Speed_element});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Jump_element), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Jump_fragment});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Jump_fragment, 9), new Object[] {ModItems.Jump_element});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Darkness_element), new Object[] {"PPP", "PPP", "PPP", 'P', ModItems.Darkness_fragment});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Darkness_fragment, 9), new Object[] {ModItems.Darkness_element});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Steel_power), new Object[] {"sSs", "dDd", "jJj", 's', ModItems.Speed_fragment, 'S', ModItems.Speed_element, 'd', ModItems.Darkness_fragment, 'D', ModItems.Darkness_element, 'j', ModItems.Jump_fragment, 'J', ModItems.Jump_element});

        //Steel
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Steel_nugget), new Object[] {ModItems.Steel_piece, ModItems.Steel_piece, ModItems.Steel_piece});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Steel_ingot), new Object[]{"CCC", "CCC", "CCC", 'C', ModItems.Steel_nugget});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Steel_nugget, 9), new Object[] {ModItems.Steel_ingot});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Steel_block), new Object[]{"CCC", "CCC", "CCC", 'C', ModItems.Steel_ingot});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Steel_ingot, 9), new Object[] {ModBlocks.Steel_block});

        //Poppie
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Poppie_nugget, 3), new Object[] {"FDF", "FEF", "FPF", 'F', Blocks.GOLD_BLOCK, 'D', Items.DIAMOND, 'E', Items.EMERALD, 'P', ModItems.Pironnite_ingot});
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

        //Compressed carbon
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Compressed_carbon), new Object[] {"   ", " MM", " MM", 'M', ModItems.Molten_carbon});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Compressed_carbon), new Object[] {"   ", "MM ", "MM ", 'M', ModItems.Molten_carbon});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Compressed_carbon), new Object[] {" MM", " MM", "   ", 'M', ModItems.Molten_carbon});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Compressed_carbon), new Object[] {"MM ", "MM ", "   ", 'M', ModItems.Molten_carbon});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Molten_carbon, 4), new Object[] {ModItems.Compressed_carbon});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Compressed_carbon_block), new Object[] {"CCC", "CCC", "CCC", 'C', ModItems.Compressed_carbon});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Compressed_carbon, 9), new Object[] {ModBlocks.Compressed_carbon_block});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Carbon_ingot), new Object[] {"CC", "CC", 'C', Items.COAL});

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

        //Obsidian
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Obsidian_helmet), new Object[]{"RRR", "R R", "   ", 'R', ModItems.Obsidian_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Obsidian_helmet), new Object[]{"   ", "RRR", "R R", 'R', ModItems.Obsidian_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Obsidian_chestplate), new Object[]{"R R", "RRR", "RRR", 'R', ModItems.Obsidian_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Obsidian_leggings), new Object[]{"RRR", "R R", "R R", 'R', ModItems.Obsidian_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Obsidian_boots), new Object[]{"   ", "R R", "R R", 'R', ModItems.Obsidian_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Obsidian_boots), new Object[]{"R R", "R R", "   ", 'R', ModItems.Obsidian_gem});
        GameRegistry.addRecipe(new ItemStack(ModItems.Obsidian_sword), "R", "R", "S", 'R', ModItems.Obsidian_gem, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(ModItems.Obsidian_shovel), "R", "S", "S", 'R', ModItems.Obsidian_gem, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Obsidian_hoe), new Object[]{"RR ", " S ", " S ", 'R', ModItems.Obsidian_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Obsidian_hoe), new Object[]{" RR", " S ", " S ", 'R', ModItems.Obsidian_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Obsidian_axe), new Object[]{" RR", " SR", " S ", 'R', ModItems.Obsidian_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Obsidian_axe), new Object[]{"RR ", "RS ", " S ", 'R', ModItems.Obsidian_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Obsidian_pickaxe), new Object[]{"RRR", " S ", " S ", 'R', ModItems.Obsidian_gem, 'S', Items.STICK});

        //Four_leaf_clover
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Four_leaf_clover_helmet), new Object[]{"RRR", "R R", "   ", 'R', ModItems.Four_leaf_clover});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Four_leaf_clover_helmet), new Object[]{"   ", "RRR", "R R", 'R', ModItems.Four_leaf_clover});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Four_leaf_clover_chestplate), new Object[]{"R R", "RRR", "RRR", 'R', ModItems.Four_leaf_clover});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Four_leaf_clover_leggings), new Object[]{"RRR", "R R", "R R", 'R', ModItems.Four_leaf_clover});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Four_leaf_clover_boots), new Object[]{"   ", "R R", "R R", 'R', ModItems.Four_leaf_clover});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Four_leaf_clover_boots), new Object[]{"R R", "R R", "   ", 'R', ModItems.Four_leaf_clover});
        GameRegistry.addRecipe(new ItemStack(ModItems.Four_leaf_clover_sword), "R", "R", "S", 'R', ModItems.Four_leaf_clover, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(ModItems.Four_leaf_clover_shovel), "R", "S", "S", 'R', ModItems.Four_leaf_clover, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Four_leaf_clover_hoe), new Object[]{"RR ", " S ", " S ", 'R', ModItems.Four_leaf_clover, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Four_leaf_clover_hoe), new Object[]{" RR", " S ", " S ", 'R', ModItems.Four_leaf_clover, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Four_leaf_clover_axe), new Object[]{" RR", " SR", " S ", 'R', ModItems.Four_leaf_clover, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Four_leaf_clover_axe), new Object[]{"RR ", "RS ", " S ", 'R', ModItems.Four_leaf_clover, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Four_leaf_clover_pickaxe), new Object[]{"RRR", " S ", " S ", 'R', ModItems.Four_leaf_clover, 'S', Items.STICK});

        //Coal
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Coal_helmet), new Object[]{"RRR", "R R", "   ", 'R', ModItems.Coal_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Coal_helmet), new Object[]{"   ", "RRR", "R R", 'R', ModItems.Coal_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Coal_chestplate), new Object[]{"R R", "RRR", "RRR", 'R', ModItems.Coal_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Coal_leggings), new Object[]{"RRR", "R R", "R R", 'R', ModItems.Coal_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Coal_boots), new Object[]{"   ", "R R", "R R", 'R', ModItems.Coal_gem});
        GameRegistry.addShapedRecipe(new ItemStack(ModArmor.Coal_boots), new Object[]{"R R", "R R", "   ", 'R', ModItems.Coal_gem});
        GameRegistry.addRecipe(new ItemStack(ModItems.Coal_sword), "R", "R", "S", 'R', ModItems.Coal_gem, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(ModItems.Coal_shovel), "R", "S", "S", 'R', ModItems.Coal_gem, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Coal_hoe), new Object[]{"RR ", " S ", " S ", 'R', ModItems.Coal_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Coal_hoe), new Object[]{" RR", " S ", " S ", 'R', ModItems.Coal_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Coal_axe), new Object[]{" RR", " SR", " S ", 'R', ModItems.Coal_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Coal_axe), new Object[]{"RR ", "RS ", " S ", 'R', ModItems.Coal_gem, 'S', Items.STICK});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Coal_pickaxe), new Object[]{"RRR", " S ", " S ", 'R', ModItems.Coal_gem, 'S', Items.STICK});

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
        GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(ModItems.Obsidian_gem, 1), 0.7f);
        GameRegistry.addSmelting(Blocks.COAL_BLOCK, new ItemStack(ModItems.Coal_gem, 1), 0.7f);
        GameRegistry.addSmelting(ModBlocks.Carbon_ore, new ItemStack(ModItems.Carbon_ingot, 1), 0.7f);
        GameRegistry.addSmelting( ModBlocks.Carbon_block, new ItemStack(ModItems.Molten_carbon, 1), 0.7f );
        GameRegistry.addSmelting(Blocks.IRON_BLOCK, new ItemStack(ModItems.Molten_iron, 1), 0.7f);

    }

    public void registerBrewingRecipes() {

        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Compressed_iron_bottle), new ItemStack(ModItems.Compressed_carbon), new ItemStack(ModItems.Molten_carbon_bottle, 1, 0));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Molten_carbon_bottle, 1, 0), new ItemStack(ModItems.Compressed_carbon), new ItemStack(ModItems.Molten_carbon_bottle, 1, 1));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Molten_carbon_bottle, 1, 1), new ItemStack(ModItems.Compressed_carbon), new ItemStack(ModItems.Molten_carbon_bottle, 1, 2));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Molten_carbon_bottle, 1, 2), new ItemStack(ModItems.Poppie_nugget), new ItemStack(ModItems.Poppie_bottle, 1, 0));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Poppie_bottle, 1, 0), new ItemStack(ModItems.Poppie_nugget), new ItemStack(ModItems.Poppie_bottle, 1, 1));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Poppie_bottle, 1, 1), new ItemStack(ModItems.Poppie_nugget), new ItemStack(ModItems.Poppie_bottle, 1, 2));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Poppie_bottle, 1, 2), new ItemStack(Items.LAVA_BUCKET), new ItemStack(ModItems.Steel_piece));


    }




}
