package net.logan31.poppiecraft.event;

import net.logan31.poppiecraft.entity.Darker;
import net.logan31.poppiecraft.entity.GoldenChicken;
import net.logan31.poppiecraft.entity.Jumper;
import net.logan31.poppiecraft.entity.Speedster;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by johanjulien on 07/10/2017.
 */
public class onTouchEntityEvent {



    @SubscribeEvent
    public void onKill(AttackEntityEvent e) {

        if(e.getEntityPlayer() != null) {

            EntityPlayer player = e.getEntityPlayer();


            ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);


            if(e.getTarget() != null) {
                Entity entity = e.getTarget();

                if(entity instanceof Darker) {
                    player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 600, 1));

                }

                if(entity instanceof Jumper) {
                    player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 600, 241));

                }

                if(entity instanceof Speedster) {
                    player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 600, 1));

                }

                if(entity instanceof GoldenChicken) {
                    player.addPotionEffect(new PotionEffect(MobEffects.POISON, 200, 1));

                }

            }
        }


    }
}
