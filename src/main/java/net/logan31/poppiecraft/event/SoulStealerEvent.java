package net.logan31.poppiecraft.event;

import com.google.common.eventbus.DeadEvent;
import net.logan31.poppiecraft.init.ModEnchantments;
import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.xml.stream.Location;

/**
 * Created by johanjulien on 07/10/2017.
 */
public class SoulStealerEvent {

    @SubscribeEvent
    public void onSoulStealer(AttackEntityEvent e) {



        if (e.getEntityPlayer() != null) {

            EntityPlayer player = e.getEntityPlayer();

            if (player.getHeldItem(EnumHand.MAIN_HAND) != null) {

                ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);

                if (EnchantmentHelper.getEnchantmentLevel(ModEnchantments.SoulStealer, stack) == 1 || EnchantmentHelper.getEnchantmentLevel(ModEnchantments.SoulStealer, stack) == 2 || EnchantmentHelper.getEnchantmentLevel(ModEnchantments.SoulStealer, stack) == 3) {


                    if (e.getTarget() != null) {
                        Entity entity = e.getTarget();
                        World world = entity.getEntityWorld();

                        if(!world.isRemote) {


                            if (entity instanceof EntityBat) {
                                if (((EntityBat) entity).getHealth() == ((EntityBat) entity).getMaxHealth()) {
                                    ((EntityBat) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 0 ), 0f );
                                }
                            }
                            if (entity instanceof EntityChicken) {
                                if (((EntityChicken) entity).getHealth() == ((EntityChicken) entity).getMaxHealth()) {

                                    ((EntityChicken) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 1 ), 0f ).setDropItemsWhenDead( true );

                                }
                            }

                            if (entity instanceof EntityCow) {
                                if (((EntityCow) entity).getHealth() == ((EntityCow) entity).getMaxHealth()) {
                                    ((EntityCow) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 2 ), 0f );
                                }
                            }

                            if (entity instanceof EntityEndermite) {
                                if (((EntityEndermite) entity).getHealth() == ((EntityEndermite) entity).getMaxHealth()) {
                                    ((EntityEndermite) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 3 ), 0f );
                                }
                            }

                            if (entity instanceof EntityMooshroom) {
                                if (((EntityMooshroom) entity).getHealth() == ((EntityMooshroom) entity).getMaxHealth()) {
                                    ((EntityMooshroom) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 4 ), 0f );
                                }
                            }

                            if (entity instanceof EntityOcelot) {
                                if (((EntityOcelot) entity).getHealth() == ((EntityOcelot) entity).getMaxHealth()) {
                                    ((EntityOcelot) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 5 ), 0f );
                                }
                            }

                            if (entity instanceof EntityPig) {
                                if (((EntityPig) entity).getHealth() == ((EntityPig) entity).getMaxHealth()) {
                                    ((EntityPig) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 6 ), 0f );
                                }
                            }

                            if (entity instanceof EntityPolarBear) {
                                if (((EntityPolarBear) entity).getHealth() == ((EntityPolarBear) entity).getMaxHealth()) {
                                    ((EntityPolarBear) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 7 ), 0f );
                                }
                            }


                            if (entity instanceof EntityRabbit) {
                                if (((EntityRabbit) entity).getHealth() == ((EntityRabbit) entity).getMaxHealth()) {
                                    ((EntityRabbit) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 8 ), 0f );
                                }
                            }


                            if (entity instanceof EntitySheep) {
                                if (((EntitySheep) entity).getHealth() == ((EntitySheep) entity).getMaxHealth()) {
                                    ((EntitySheep) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 9 ), 0f );
                                }
                            }


                            if (entity instanceof EntityShulker) {
                                if (((EntityShulker) entity).getHealth() == ((EntityShulker) entity).getMaxHealth()) {
                                    ((EntityShulker) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 10 ), 0f );
                                }
                            }


                            if (entity instanceof EntitySilverfish) {
                                if (((EntitySilverfish) entity).getHealth() == ((EntitySilverfish) entity).getMaxHealth()) {
                                    ((EntitySilverfish) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 11 ), 0f );
                                }
                            }


                            if (entity instanceof EntitySquid) {
                                if (((EntitySquid) entity).getHealth() == ((EntitySquid) entity).getMaxHealth()) {
                                    ((EntitySquid) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 12 ), 0f );
                                }
                            }


                            if (entity instanceof EntityWolf) {

                                boolean tame = ((EntityWolf) entity).isTamed();

                                if (tame) {

                                    if (((EntityWolf) entity).getHealth() == ((EntityWolf) entity).getMaxHealth()) {

                                        ((EntityWolf) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 13 ), 1f );
                                    }

                                } else {
                                    if (((EntityWolf) entity).getHealth() == ((EntityWolf) entity).getMaxHealth()) {
                                        ((EntityWolf) entity).entityDropItem( new ItemStack( ModItems.Basic_soul, 1, 13 ), 1f );
                                    }

                                }

                            }
                        }
                    }
                }

                if (EnchantmentHelper.getEnchantmentLevel(ModEnchantments.SoulStealer, stack) == 2 || EnchantmentHelper.getEnchantmentLevel(ModEnchantments.SoulStealer, stack) == 3) {

                    if (e.getTarget() != null) {
                        Entity entity = e.getTarget();
                        World world = entity.getEntityWorld();

                        if(!world.isRemote) {

                            if (entity instanceof EntityCaveSpider) {
                                if (((EntityCaveSpider) entity).getHealth() == ((EntityCaveSpider) entity).getMaxHealth()) {
                                    ((EntityCaveSpider) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 0 ), 0f );
                                }
                            }

                            if (entity instanceof EntityCreeper) {
                                if (((EntityCreeper) entity).getHealth() == ((EntityCreeper) entity).getMaxHealth()) {
                                    ((EntityCreeper) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 1 ), 0f );
                                }
                            }

                            if (entity instanceof EntityHorse) {

                                HorseType donkey = HorseType.DONKEY;
                                HorseType horse = HorseType.HORSE;
                                HorseType mule = HorseType.MULE;
                                HorseType skeleton = HorseType.SKELETON;
                                HorseType zombie = HorseType.ZOMBIE;

                                if (((EntityHorse) entity).getType() == donkey) {

                                    if (((EntityHorse) entity).getHealth() == ((EntityHorse) entity).getMaxHealth()) {
                                        ((EntityHorse) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 2 ), 0f );
                                    }
                                }


                                if (((EntityHorse) entity).getType() == horse) {

                                    if (((EntityHorse) entity).getHealth() == ((EntityHorse) entity).getMaxHealth()) {
                                        ((EntityHorse) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 4 ), 0f );
                                    }
                                }


                                if (((EntityHorse) entity).getType() == mule) {

                                    if (((EntityHorse) entity).getHealth() == ((EntityHorse) entity).getMaxHealth()) {
                                        ((EntityHorse) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 6 ), 0f );
                                    }
                                }

                                if (((EntityHorse) entity).getType() == skeleton) {

                                    if (((EntityHorse) entity).getHealth() == ((EntityHorse) entity).getMaxHealth()) {
                                        ((EntityHorse) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 8 ), 0f );
                                    }
                                }

                                if (((EntityHorse) entity).getType() == zombie) {

                                    if (((EntityHorse) entity).getHealth() == ((EntityHorse) entity).getMaxHealth()) {
                                        ((EntityHorse) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 13 ), 0f );
                                    }
                                }

                            }


                            if (entity instanceof EntityGuardian) {
                                if (((EntityGuardian) entity).getHealth() == ((EntityGuardian) entity).getMaxHealth()) {
                                    ((EntityGuardian) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 3 ), 0f );
                                }
                            }

                            if (entity instanceof EntityZombie) {

                                ZombieType husk = ZombieType.HUSK;
                                ZombieType zombie = ZombieType.NORMAL;

                                if (((EntityZombie) entity).getZombieType() == husk) {

                                    if (((EntityZombie) entity).getHealth() == ((EntityZombie) entity).getMaxHealth()) {
                                        ((EntityZombie) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 5 ), 0f );
                                    }
                                }


                                if (((EntityZombie) entity).getZombieType() == zombie) {

                                    if (((EntityZombie) entity).getHealth() == ((EntityZombie) entity).getMaxHealth()) {
                                        ((EntityZombie) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 12 ), 0f );
                                    }
                                }

                            }


                            if (entity instanceof EntitySkeleton) {

                                SkeletonType skeleton = SkeletonType.NORMAL;

                                if (((EntitySkeleton) entity).getSkeletonType() == skeleton) {
                                    if (((EntitySkeleton) entity).getHealth() == ((EntitySkeleton) entity).getMaxHealth()) {
                                        ((EntitySkeleton) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 7 ), 0f );
                                    }
                                }

                            }

                            if (entity instanceof EntitySnowman) {
                                if (((EntitySnowman) entity).getHealth() == ((EntitySnowman) entity).getMaxHealth()) {
                                    ((EntitySnowman) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 9 ), 0f );
                                }
                            }

                            if (entity instanceof EntitySpider) {
                                if (((EntitySpider) entity).getHealth() == ((EntitySpider) entity).getMaxHealth()) {
                                    ((EntitySpider) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 10 ), 0f );
                                }
                            }

                            if (entity instanceof EntityVillager) {
                                if (((EntityVillager) entity).getHealth() == ((EntityVillager) entity).getMaxHealth()) {
                                    ((EntityVillager) entity).entityDropItem( new ItemStack( ModItems.Advanced_soul, 1, 11 ), 0f );
                                }
                            }
                        }


                    }


                }


                if (EnchantmentHelper.getEnchantmentLevel(ModEnchantments.SoulStealer, stack) == 3) {

                    if (e.getTarget() != null) {
                        Entity entity = e.getTarget();
                        World world = entity.getEntityWorld();

                        if(world.isRemote) {


                            if (entity instanceof EntityBlaze) {
                                if (((EntityBlaze) entity).getHealth() == ((EntityBlaze) entity).getMaxHealth()) {
                                    ((EntityBlaze) entity).entityDropItem( new ItemStack( ModItems.Ultimate_soul, 1, 0 ), 0f );
                                }
                            }

                            if (entity instanceof EntityGuardian) {
                                if (((EntityGuardian) entity).isElder() == true) {

                                    if (((EntityGuardian) entity).getHealth() == ((EntityGuardian) entity).getMaxHealth()) {
                                        ((EntityGuardian) entity).entityDropItem( new ItemStack( ModItems.Ultimate_soul, 1, 1 ), 0f );
                                    }
                                }
                            }

                            if (entity instanceof EntityDragon) {
                                if (((EntityDragon) entity).getHealth() == ((EntityDragon) entity).getMaxHealth()) {
                                    ((EntityDragon) entity).entityDropItem( new ItemStack( ModItems.Ultimate_soul, 1, 2 ), 0f );
                                }
                            }

                            if (entity instanceof EntityEnderman) {
                                if (((EntityEnderman) entity).getHealth() == ((EntityEnderman) entity).getMaxHealth()) {
                                    ((EntityEnderman) entity).entityDropItem( new ItemStack( ModItems.Ultimate_soul, 1, 3 ), 0f );
                                }
                            }


                            if (entity instanceof EntityGhast) {
                                if (((EntityGhast) entity).getHealth() == ((EntityGhast) entity).getMaxHealth()) {
                                    ((EntityGhast) entity).entityDropItem( new ItemStack( ModItems.Ultimate_soul, 1, 4 ), 0f );
                                }
                            }


                            if (entity instanceof EntityIronGolem) {
                                if (((EntityIronGolem) entity).getHealth() == ((EntityIronGolem) entity).getMaxHealth()) {
                                    ((EntityIronGolem) entity).entityDropItem( new ItemStack( ModItems.Ultimate_soul, 1, 5 ), 0f );
                                }
                            }

                            if (entity instanceof EntityMagmaCube) {
                                if (((EntityMagmaCube) entity).getHealth() == ((EntityMagmaCube) entity).getMaxHealth()) {
                                    ((EntityMagmaCube) entity).entityDropItem( new ItemStack( ModItems.Ultimate_soul, 1, 6 ), 0f );
                                }
                            }

                            if (entity instanceof EntitySlime) {
                                if (((EntitySlime) entity).getHealth() == ((EntitySlime) entity).getMaxHealth()) {
                                    ((EntitySlime) entity).entityDropItem( new ItemStack( ModItems.Ultimate_soul, 1, 7 ), 0f );
                                }
                            }

                            if (entity instanceof EntitySkeleton) {

                                SkeletonType stray = SkeletonType.STRAY;
                                SkeletonType wither = SkeletonType.WITHER;

                                if (((EntitySkeleton) entity).getSkeletonType() == stray) {
                                    if (((EntitySkeleton) entity).getHealth() == ((EntitySkeleton) entity).getMaxHealth()) {
                                        ((EntitySkeleton) entity).entityDropItem( new ItemStack( ModItems.Ultimate_soul, 1, 8 ), 0f );
                                    }
                                }


                                if (((EntitySkeleton) entity).getSkeletonType() == wither) {
                                    if (((EntitySkeleton) entity).getHealth() == ((EntitySkeleton) entity).getMaxHealth()) {
                                        ((EntitySkeleton) entity).entityDropItem( new ItemStack( ModItems.Ultimate_soul, 1, 11 ), 0f );
                                    }
                                }


                            }
                            if (entity instanceof EntityWitch) {
                                if (((EntityWitch) entity).getHealth() == ((EntityWitch) entity).getMaxHealth()) {
                                    ((EntityWitch) entity).entityDropItem( new ItemStack( ModItems.Ultimate_soul, 1, 9 ), 0f );
                                }
                            }

                            if (entity instanceof EntityWither) {
                                if (((EntityWither) entity).getHealth() == ((EntityWither) entity).getMaxHealth()) {
                                    ((EntityWither) entity).entityDropItem( new ItemStack( ModItems.Ultimate_soul, 1, 10 ), 0f );
                                }
                            }

                            if (entity instanceof EntityPigZombie) {
                                if (((EntityPigZombie) entity).getHealth() == ((EntityPigZombie) entity).getMaxHealth()) {
                                    ((EntityPigZombie) entity).entityDropItem( new ItemStack( ModItems.Ultimate_soul, 1, 12 ), 0f );
                                }
                            }
                        }



                    }

                }

            }
        }


    }

}