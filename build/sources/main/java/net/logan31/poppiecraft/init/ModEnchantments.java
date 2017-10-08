package net.logan31.poppiecraft.init;

import net.logan31.poppiecraft.enchant.EnchantmentSoulStealer;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by johanjulien on 07/10/2017.
 */
public class ModEnchantments {

    public static final Enchantment SoulStealer = new EnchantmentSoulStealer("Soul Stealer");


    public static void registerEnchantments() {

        GameRegistry.register(SoulStealer);


    }

}