package net.logan31.poppiecraft.event;

import net.logan31.poppiecraft.entity.Darker;
import net.logan31.poppiecraft.entity.Jumper;
import net.logan31.poppiecraft.entity.Speedster;
import net.logan31.poppiecraft.handler.EnumHandler;
import net.logan31.poppiecraft.init.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.math.Equiv;

/**
 * Created by johanjulien on 02/11/2017.
 */
public class WildlingsProtectionEvent {

    @SubscribeEvent
    public void BaneOfWildlingsEvent(LivingHurtEvent event) {
        if(event.getSource().getEntity() instanceof Speedster || event.getSource().getEntity() instanceof Jumper || event.getSource().getEntity() instanceof Darker) {
            System.out.println("PlayerTouch");
            if(event.getEntity() instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) event.getEntity();
                System.out.println("EntityTouch, level : " + wearingEnch(player));
                event.setAmount( event.getAmount() - event.getAmount() / 27 * wearingEnch( player ));

            }
        }
    }

    public int wearingEnch(EntityPlayer player) {
        ItemStack helmet;
        helmet = player.inventory.armorInventory[3];
        int head = 0;
        ItemStack chestplate;
        chestplate = player.inventory.armorInventory[2];
        int chest = 0;
        ItemStack leggings;
        leggings = player.inventory.armorInventory[1];
        int legs = 0;
        ItemStack boots;
        boots = player.inventory.armorInventory[0];
        int feet = 0;
        int level;
        int stop;


        for (level = 0, stop = 0; stop == 0; level++) {
            if (EnchantmentHelper.getEnchantmentLevel( ModEnchantments.WildlingsProtect, helmet ) == level) {
                head = level;
                stop = 1;
            }

            else {
                stop = 0;
            }
        }

        for(level = 0, stop = 0; stop == 0; level++) {
            if (EnchantmentHelper.getEnchantmentLevel( ModEnchantments.WildlingsProtect, chestplate ) == level) {
                chest = level;
                stop = 1;
            }

            else {
                stop = 0;
            }
        }

        for(level = 0, stop = 0; stop == 0; level++) {
            if (EnchantmentHelper.getEnchantmentLevel( ModEnchantments.WildlingsProtect, leggings ) == level) {
                legs = level;
                stop = 1;
            }

            else {
                stop = 0;
            }
        }

        for(level = 0, stop = 0; stop == 0; level++) {
            if (EnchantmentHelper.getEnchantmentLevel( ModEnchantments.WildlingsProtect, boots ) == level) {
                feet = level;
                stop = 1;
            }

            else {
                stop = 0;
            }
        }


            return head + chest + legs + feet;
        }




    }