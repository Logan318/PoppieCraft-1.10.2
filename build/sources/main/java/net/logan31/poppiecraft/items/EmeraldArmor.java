package net.logan31.poppiecraft.items;

import com.sun.prism.shader.FillRoundRect_LinearGradient_REFLECT_Loader;
import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.handler.AchievementHandler;
import net.logan31.poppiecraft.init.ModArmor;
import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Iterator;

/**
 * Created by johanjulien on 06/07/2017.
 */
public class EmeraldArmor extends ItemArmor {


    public EmeraldArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String unlocalizedName) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(References.MODID, unlocalizedName));
        this.setCreativeTab(PoppieCraftMod.PoppieArmor);
    }



    private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestplate, Item leggings, Item boots)

    {

        return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == helmet

                && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == chestplate

                && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == leggings

                && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == boots;

    }


    private void uneffectPlayer(EntityPlayer player) {
        if(this.isWearingFullSet(player, ModArmor.Emerald_helmet, ModArmor.Emerald_chestplate, ModArmor.Emerald_leggings, ModArmor.Emerald_boots)) {
            return;
        }
        else {

                player.removePotionEffect(Potion.getPotionById(5));
            }

        }
    private void effectPlayer(EntityPlayer player, Potion potion, int amplifier, int duration)

    {

        if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 230)

            player.addPotionEffect(new PotionEffect(potion , duration, amplifier, false, false));

    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if(this.isWearingFullSet(player, ModArmor.Emerald_helmet, ModArmor.Emerald_chestplate, ModArmor.Emerald_leggings, ModArmor.Emerald_boots)) {
            this.effectPlayer(player, Potion.getPotionById(5), 1 , 2147483647);
        }
        this.uneffectPlayer(player);

        int emeraldArmourPeices = 0;
        if(player.getArmorInventoryList() != null) {
            Iterator<ItemStack> iterator = player.getArmorInventoryList().iterator();
            while(iterator.hasNext()) {
                ItemStack stack = iterator.next();
                if(stack != null) {
                    if(stack.getItem() instanceof EmeraldArmor) {
                        EmeraldArmor item = (EmeraldArmor) stack.getItem();
                        if(item.getArmorMaterial() == ModArmor.emeraldMat) {
                            emeraldArmourPeices++;
                            continue;
                        }
                    }
                }
            }
        }
        if(emeraldArmourPeices == 4) {
            if(!player.hasAchievement(AchievementHandler.EmeraldArmor)) {
                player.addStat(AchievementHandler.EmeraldArmor);
            }
        }
    }

    @Override
    public boolean isRepairable() {
        return true;

    }


    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return repair.getItem() == Items.EMERALD;
    }


}


