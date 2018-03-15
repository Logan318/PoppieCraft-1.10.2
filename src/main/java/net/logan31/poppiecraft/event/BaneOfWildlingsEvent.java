package net.logan31.poppiecraft.event;

import net.logan31.poppiecraft.entity.Darker;
import net.logan31.poppiecraft.entity.Jumper;
import net.logan31.poppiecraft.entity.Speedster;
import net.logan31.poppiecraft.init.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by johanjulien on 02/11/2017.
 */
public class BaneOfWildlingsEvent {

    @SubscribeEvent
    public void BaneOfWildlingsEvent(LivingHurtEvent event) {

        if (event.getSource().getEntity() != null && event.getSource().getEntity() instanceof EntityPlayer) {
            int stop = 0;

            System.out.println( "Player" );

            if (event.getEntity() instanceof Speedster || event.getEntity() instanceof Jumper || event.getEntity() instanceof Darker) {
                System.out.println( "Entity" );
                EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
                ItemStack stack = player.getHeldItem( EnumHand.MAIN_HAND );
                if (player != null && player.getHeldItem( EnumHand.MAIN_HAND ) != null && player.getHeldItem( EnumHand.MAIN_HAND ) == stack) {
                    for (int level = 0; stop == 0; level++) {


                        if (EnchantmentHelper.getEnchantmentLevel( ModEnchantments.BaneWildlings, stack ) == level) {
                            System.out.println( "Good" );
                            float damage = event.getAmount();
                            System.out.println( "damange : " + damage + ", level : " + level );
                            event.setAmount( event.getAmount() + event.getAmount() / 4.8f * level );
                            stop = 1;
                        } else {
                            stop = 0;
                        }
                    }


                }
            }
        }

    }
}
