package net.logan31.poppiecraft.init;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;

import net.logan31.poppiecraft.items.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by johanjulien on 11/07/2017.
 */
public class ModArmor {
    public ModArmor() {
        init();
        register();

    }

        public static ItemArmor.ArmorMaterial redstoneMat = EnumHelper.addArmorMaterial("redstoneMat", References.MODID + ":redstoneArmor", 15, new int[]{2,5,6,2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);
        public static ItemArmor.ArmorMaterial lapisMat = EnumHelper.addArmorMaterial("lapisMat", References.MODID + ":lapisArmor", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);
        public static ItemArmor.ArmorMaterial quartzMat = EnumHelper.addArmorMaterial("quartzMat", References.MODID + ":quartzArmor", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);
        public static ItemArmor.ArmorMaterial glowstoneMat = EnumHelper.addArmorMaterial("glowstoneMat", References.MODID + ":glowstoneArmor", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);
        public static ItemArmor.ArmorMaterial leafcloverMat = EnumHelper.addArmorMaterial("leafcloverMat", References.MODID + ":leafcloverArmor", 11, new int[]{3, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);
        public static ItemArmor.ArmorMaterial obsidianMat = EnumHelper.addArmorMaterial("obsidianMat", References.MODID + ":obsidianArmor", 18, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);
        public static ItemArmor.ArmorMaterial coalMat = EnumHelper.addArmorMaterial("coalMat", References.MODID + ":coalArmor", 13, new int[]{2, 4, 5, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);
        public static ItemArmor.ArmorMaterial emeraldMat = EnumHelper.addArmorMaterial("emeraldMat", References.MODID + ":emeraldArmor", 50, new int[]{4, 7, 9, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0f);

    public static ItemArmor Redstone_helmet, Redstone_chestplate, Redstone_leggings, Redstone_boots, Lapis_helmet;
    public static ItemArmor Lapis_chestplate, Lapis_leggings, Lapis_boots, Quartz_helmet, Quartz_chestplate, Quartz_leggings;
    public static ItemArmor Quartz_boots, Glowstone_helmet, Glowstone_chestplate, Glowstone_leggings, Glowstone_boots;
    public static ItemArmor Emerald_helmet, Emerald_chestplate, Emerald_leggings, Emerald_boots, Obsidian_helmet;
    public static ItemArmor Obsidian_chestplate, Obsidian_leggings, Obsidian_boots, Four_leaf_clover_helmet;
    public static ItemArmor Four_leaf_clover_chestplate, Four_leaf_clover_leggings, Four_leaf_clover_boots, Coal_helmet;
    public static ItemArmor Coal_chestplate, Coal_leggings, Coal_boots;

    public static void init() {
        Redstone_helmet = new RedstoneArmor(redstoneMat, 1, EntityEquipmentSlot.HEAD, "Redstone_helmet");
        Redstone_chestplate = new RedstoneArmor(redstoneMat, 1, EntityEquipmentSlot.CHEST, "Redstone_chestplate");
        Redstone_leggings = new RedstoneArmor(redstoneMat, 1, EntityEquipmentSlot.LEGS, "Redstone_leggings");
        Redstone_boots = new RedstoneArmor(redstoneMat, 1, EntityEquipmentSlot.FEET, "Redstone_boots");

        Lapis_helmet = new LapisArmor(lapisMat, 1, EntityEquipmentSlot.HEAD, "Lapis_helmet");
        Lapis_chestplate = new LapisArmor(lapisMat, 1, EntityEquipmentSlot.CHEST, "Lapis_chestplate");
        Lapis_leggings = new LapisArmor(lapisMat, 1, EntityEquipmentSlot.LEGS, "Lapis_leggings");
        Lapis_boots = new LapisArmor(lapisMat, 1, EntityEquipmentSlot.FEET, "Lapis_boots");

        Quartz_helmet = new QuartzArmor(quartzMat, 1, EntityEquipmentSlot.HEAD, "Quartz_helmet");
        Quartz_chestplate = new QuartzArmor(quartzMat, 1, EntityEquipmentSlot.CHEST, "Quartz_chestplate");
        Quartz_leggings = new QuartzArmor(quartzMat, 1, EntityEquipmentSlot.LEGS, "Quartz_leggings");
        Quartz_boots = new QuartzArmor(quartzMat, 1, EntityEquipmentSlot.FEET, "Quartz_boots");

        Glowstone_helmet = new GlowstoneArmor(glowstoneMat, 1, EntityEquipmentSlot.HEAD, "Glowstone_helmet");
        Glowstone_chestplate = new GlowstoneArmor(glowstoneMat, 1, EntityEquipmentSlot.CHEST, "Glowstone_chestplate");
        Glowstone_leggings = new GlowstoneArmor(glowstoneMat, 1, EntityEquipmentSlot.LEGS, "Glowstone_leggings");
        Glowstone_boots = new GlowstoneArmor(glowstoneMat, 1, EntityEquipmentSlot.FEET, "Glowstone_boots");

        Obsidian_helmet = new ObsidianArmor(obsidianMat, 1, EntityEquipmentSlot.HEAD, "Obsidian_helmet");
        Obsidian_chestplate = new ObsidianArmor(obsidianMat, 1, EntityEquipmentSlot.CHEST, "Obsidian_chestplate");
        Obsidian_leggings = new ObsidianArmor(obsidianMat, 1, EntityEquipmentSlot.LEGS, "Obsidian_leggings");
        Obsidian_boots = new ObsidianArmor(obsidianMat, 1, EntityEquipmentSlot.FEET, "Obsidian_boots");

        Four_leaf_clover_helmet = new FourleafcloverArmor(leafcloverMat, 1, EntityEquipmentSlot.HEAD, "Four_leaf_clover_helmet");
        Four_leaf_clover_chestplate = new FourleafcloverArmor(leafcloverMat, 1, EntityEquipmentSlot.CHEST, "Four_leaf_clover_chestplate");
        Four_leaf_clover_leggings = new FourleafcloverArmor(leafcloverMat, 1, EntityEquipmentSlot.LEGS, "Four_leaf_clover_leggings");
        Four_leaf_clover_boots = new FourleafcloverArmor(leafcloverMat, 1, EntityEquipmentSlot.FEET, "Four_leaf_clover_boots");

        Coal_helmet = new CoalArmor(coalMat, 1, EntityEquipmentSlot.HEAD, "Coal_helmet");
        Coal_chestplate = new CoalArmor(coalMat, 1, EntityEquipmentSlot.CHEST, "Coal_chestplate");
        Coal_leggings = new CoalArmor(coalMat, 1, EntityEquipmentSlot.LEGS, "Coal_leggings");
        Coal_boots = new CoalArmor(coalMat, 1, EntityEquipmentSlot.FEET, "Coal_boots");

        Emerald_helmet = new EmeraldArmor(emeraldMat, 1, EntityEquipmentSlot.HEAD, "Emerald_helmet");
        Emerald_chestplate= new EmeraldArmor(emeraldMat, 1, EntityEquipmentSlot.CHEST, "Emerald_chestplate");
        Emerald_leggings = new EmeraldArmor(emeraldMat, 1, EntityEquipmentSlot.LEGS, "Emerald_leggings");
        Emerald_boots = new EmeraldArmor(emeraldMat, 1, EntityEquipmentSlot.FEET, "Emerald_boots");
    }

    public static void register() {
        registerItem(Redstone_helmet);
        registerItem(Redstone_chestplate);
        registerItem(Redstone_leggings);
        registerItem(Redstone_boots);

        registerItem(Lapis_helmet);
        registerItem(Lapis_chestplate);
        registerItem(Lapis_leggings);
        registerItem(Lapis_boots);

        registerItem(Quartz_helmet);
        registerItem(Quartz_chestplate);
        registerItem(Quartz_leggings);
        registerItem(Quartz_boots);

        registerItem(Glowstone_helmet);
        registerItem(Glowstone_chestplate);
        registerItem(Glowstone_leggings);
        registerItem(Glowstone_boots);

        registerItem(Obsidian_helmet);
        registerItem(Obsidian_chestplate);
        registerItem(Obsidian_leggings);
        registerItem(Obsidian_boots);

        registerItem(Four_leaf_clover_helmet);
        registerItem(Four_leaf_clover_chestplate);
        registerItem(Four_leaf_clover_leggings);
        registerItem(Four_leaf_clover_boots);

        registerItem(Coal_helmet);
        registerItem(Coal_chestplate);
        registerItem(Coal_leggings);
        registerItem(Coal_boots);

        registerItem(Emerald_helmet);
        registerItem(Emerald_chestplate);
        registerItem(Emerald_leggings);
        registerItem(Emerald_boots);

    }

    public static void registerRenders() {
        registerRender(Redstone_helmet);
        registerRender(Redstone_chestplate);
        registerRender(Redstone_leggings);
        registerRender(Redstone_boots);

        registerRender(Lapis_helmet);
        registerRender(Lapis_chestplate);
        registerRender(Lapis_leggings);
        registerRender(Lapis_boots);

        registerRender(Quartz_helmet);
        registerRender(Quartz_chestplate);
        registerRender(Quartz_leggings);
        registerRender(Quartz_boots);

        registerRender(Glowstone_helmet);
        registerRender(Glowstone_chestplate);
        registerRender(Glowstone_leggings);
        registerRender(Glowstone_boots);

        registerRender(Obsidian_helmet);
        registerRender(Obsidian_chestplate);
        registerRender(Obsidian_leggings);
        registerRender(Obsidian_boots);

        registerRender(Four_leaf_clover_helmet);
        registerRender(Four_leaf_clover_chestplate);
        registerRender(Four_leaf_clover_leggings);
        registerRender(Four_leaf_clover_boots);

        registerRender(Coal_helmet);
        registerRender(Coal_chestplate);
        registerRender(Coal_leggings);
        registerRender(Coal_boots);

        registerRender(Emerald_helmet);
        registerRender(Emerald_chestplate);
        registerRender(Emerald_leggings);
        registerRender(Emerald_boots);

    }

    public static void registerItem(Item item) {
        GameRegistry.register(item);

    }

    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(References.MODID, item.getUnlocalizedName().substring(5)), "inventory"));

    }


}
