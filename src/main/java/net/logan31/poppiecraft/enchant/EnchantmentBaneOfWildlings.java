package net.logan31.poppiecraft.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

/**
 * Created by johanjulien on 07/10/2017.
 */
public class EnchantmentBaneOfWildlings extends Enchantment {


    public EnchantmentBaneOfWildlings(String name) {
        super(Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{});
        this.setName(name);
        this.setRegistryName(name);

    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }


    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 17;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return 30;
    }


}
