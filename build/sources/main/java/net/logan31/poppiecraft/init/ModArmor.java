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
        public static ItemArmor.ArmorMaterial emeraldMat = EnumHelper.addArmorMaterial("emeraldMat", References.MODID + ":emeraldArmor", 50, new int[]{4, 7, 10, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0f);

    public static ItemArmor Redstone_helmet, Redstone_chestplate, Redstone_leggings, Redstone_boots, Lapis_helmet, Lapis_chestplate, Lapis_leggings, Lapis_boots, Quartz_helmet, Quartz_chestplate, Quartz_leggings, Quartz_boots, Glowstone_helmet, Glowstone_chestplate, Glowstone_leggings, Glowstone_boots, Emerald_helmet, Emerald_chestplate, Emerald_leggings, Emerald_boots;

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
