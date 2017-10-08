package net.logan31.poppiecraft.event;

import com.google.common.eventbus.DeadEvent;
import net.logan31.poppiecraft.init.ModEnchantments;
import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by johanjulien on 07/10/2017.
 */
public class SoulStealerEvent {

    @SubscribeEvent
    public void onSoulStealer(AttackEntityEvent e) {

        if(e.getEntityPlayer() != null) {

            EntityPlayer player = e.getEntityPlayer();

            if(player.getHeldItem(EnumHand.MAIN_HAND) != null) {

                ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);

                if(EnchantmentHelper.getEnchantmentLevel(ModEnchantments.SoulStealer, stack) == 1) {


                    if(e.getTarget() != null) {
                        Entity entity = e.getTarget();


                            if (entity instanceof EntityBat) {
                                ((EntityBat) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 0), 0f);
                            }

                            if (entity instanceof EntityChicken) {
                                if(((EntityChicken) entity).getHealth() <= 1)
                                    ((EntityChicken) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 1), 0f);
                                }


                            if (entity instanceof EntityCow) {


                                ((EntityCow) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 2), 0f);

                            }

                            if (entity instanceof EntityEndermite) {
                                ((EntityEndermite) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 3), 0f);

                            }

                            if (entity instanceof EntityMooshroom) {
                                ((EntityMooshroom) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 4), 0f);

                            }

                            if (entity instanceof EntityOcelot) {
                                ((EntityOcelot) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 5), 0f);

                            }

                            if (entity instanceof EntityPig) {
                                ((EntityPig) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 6), 0f);

                            }

                            if (entity instanceof EntityPolarBear) {
                                ((EntityPolarBear) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 7), 0f);

                            }


                            if (entity instanceof EntityRabbit) {
                                ((EntityRabbit) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 8), 0f);

                            }


                            if (entity instanceof EntitySheep) {
                                ((EntitySheep) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 9), 0f);

                            }


                            if (entity instanceof EntityShulker) {
                                ((EntityShulker) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 10), 0f);

                            }


                            if (entity instanceof EntitySilverfish) {
                                ((EntitySilverfish) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 11), 0f);

                            }


                            if (entity instanceof EntitySquid) {
                                ((EntitySquid) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 12), 0f);

                            }


                            if (entity instanceof EntityWolf) {
                                ((EntityWolf) entity).entityDropItem(new ItemStack(ModItems.Basic_soul, 1, 13), 0f);

                            }
                        }
                    }
                }
            }
        }


    }

