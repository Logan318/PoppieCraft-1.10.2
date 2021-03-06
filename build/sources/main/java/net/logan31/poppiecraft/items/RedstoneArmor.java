package net.logan31.poppiecraft.items;

import com.sun.prism.shader.FillRoundRect_LinearGradient_REFLECT_Loader;
import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.handler.AchievementHandler;
import net.logan31.poppiecraft.init.ModArmor;
import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


import java.util.Iterator;

/**
 * Created by johanjulien on 06/07/2017.
 */
public class RedstoneArmor extends ItemArmor {


int i = 0;
    private Potion potion;

    public RedstoneArmor(String name, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, 2, equipmentSlotIn);
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(References.MODID, name));
        this.setCreativeTab(PoppieCraftMod.PoppieArmor);

    }



    private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestplate, Item leggings, Item boots)

    {
        System.out.print("Wearing Full Set" + helmet + chestplate + leggings + boots);

        return player.inventory.armorInventory[3] != null && player.inventory.armorInventory[3].getItem() == helmet

                && player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem() == chestplate

                && player.inventory.armorInventory[1] != null && player.inventory.armorInventory[1].getItem() == leggings

                && player.inventory.armorInventory[0] != null && player.inventory.armorInventory[0].getItem() == boots;
    }






    private void uneffectPlayer(EntityPlayer player) {
        if(this.isWearingFullSet(player, ModArmor.Redstone_helmet, ModArmor.Redstone_chestplate, ModArmor.Redstone_leggings, ModArmor.Redstone_boots)) {
            return;
        }
        else {

            player.removePotionEffect(Potion.getPotionById(12));
        }

    }
    private void effectPlayer(EntityPlayer player, Potion potion, int amplifier, int duration)

    {

        if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 230)

            player.addPotionEffect(new PotionEffect(potion , duration, amplifier, false, false));

    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {

        Item helmet;
        Item chestplate;
        Item leggings;
        Item boots;


        helmet = ModArmor.Redstone_helmet;
        chestplate = ModArmor.Redstone_chestplate;
        leggings = ModArmor.Redstone_leggings;
        boots = ModArmor.Redstone_boots;

        if(isWearingFullSet(player, helmet, chestplate, leggings, boots)) {
            this.effectPlayer(player, Potion.getPotionById(12), 0, 230);
        }
        this.uneffectPlayer(player);

        int redstoneArmourPeices = 0;
        if(player.getArmorInventoryList() != null) {
            Iterator<ItemStack> iterator = player.getArmorInventoryList().iterator();
            while(iterator.hasNext()) {
                ItemStack stack = iterator.next();
                if(stack != null) {
                    if(stack.getItem() instanceof RedstoneArmor) {
                        RedstoneArmor item = (RedstoneArmor) stack.getItem();
                        if(item.getArmorMaterial() == ModArmor.redstoneMat) {
                            redstoneArmourPeices++;
                            continue;
                        }
                    }
                }
            }
        }

        if(redstoneArmourPeices == 4) {
            if(!player.hasAchievement(AchievementHandler.RedstoneArmor)) {
                player.addStat(AchievementHandler.RedstoneArmor);
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
        return repair.getItem() == ModItems.Redstone_gem;
    }




}




