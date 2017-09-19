package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.init.ModArmor;
import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by johanjulien on 16/09/2017.
 */
public class CoalArmor extends ItemArmor {


        public CoalArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String unlocalizedName) {
            super(materialIn, renderIndexIn, equipmentSlotIn);
            this.setUnlocalizedName(unlocalizedName);
            this.setRegistryName(new ResourceLocation(References.MODID, unlocalizedName));
            this.setCreativeTab(PoppieCraftMod.PoppieArmor);
        }

int i = 0;

        private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestplate, Item leggings, Item boots)

        {

            return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == helmet

                    && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == chestplate

                    && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == leggings

                    && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == boots;

        }



        private void uneffectPlayer(EntityPlayer player) {
            if(this.isWearingFullSet(player, ModArmor.Coal_helmet, ModArmor.Coal_chestplate, ModArmor.Coal_leggings, ModArmor.Coal_boots))
                return;
            else {

                player.removePotionEffect(Potion.getPotionById(21));

            }
        }
        private void effectPlayer(EntityPlayer player, Potion potion, int amplifier, int duration)

        {

            if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 230)

                player.addPotionEffect(new PotionEffect(potion , duration, amplifier, false, false));
                i = 0;
        }

        @Override
        public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
            if(this.isWearingFullSet(player, ModArmor.Coal_helmet, ModArmor.Coal_chestplate, ModArmor.Coal_leggings, ModArmor.Coal_boots)) {
                this.effectPlayer(player, Potion.getPotionById(21), 1 , 2147483647);

            }
            this.uneffectPlayer(player);
        }

        @Override
        public boolean isRepairable() {
            return true;

        }


        @Override
        public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
        {
            return repair.getItem() == ModItems.Coal_gem;
        }


    }

