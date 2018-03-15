package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.handler.AchievementHandler;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Iterator;

/**
 * Created by johanjulien on 06/07/2017.
 */
public class GlowstoneArmor extends ItemArmor {


    public GlowstoneArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String unlocalizedName) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(References.MODID, unlocalizedName));
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
        if(this.isWearingFullSet(player, ModArmor.Glowstone_helmet, ModArmor.Glowstone_chestplate, ModArmor.Glowstone_leggings, ModArmor.Glowstone_boots))
            return;
        else {

            player.removePotionEffect(Potion.getPotionById(16));

        }
    }

    private void effectPlayer(EntityPlayer player, Potion potion, int amplifier, int duration)

    {

        if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 230)

            player.addPotionEffect(new PotionEffect(potion , duration, amplifier, false, false));

    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {

        ItemArmor helmet;
        ItemArmor chestplate;
        ItemArmor leggings;
        ItemArmor boots;

        helmet = ModArmor.Glowstone_helmet;
        chestplate = ModArmor.Glowstone_chestplate;
        leggings = ModArmor.Glowstone_leggings;
        boots = ModArmor.Glowstone_boots;

        if(isWearingFullSet(player, helmet, chestplate, leggings, boots)) {    this.effectPlayer(player, Potion.getPotionById(16), 0 , 230);
        }
        this.uneffectPlayer(player);

        int glowstoneArmourPeices = 0;
        if(player.getArmorInventoryList() != null) {
            Iterator<ItemStack> iterator = player.getArmorInventoryList().iterator();
            while(iterator.hasNext()) {
                ItemStack stack = iterator.next();
                if(stack != null) {
                    if(stack.getItem() instanceof GlowstoneArmor) {
                        GlowstoneArmor item = (GlowstoneArmor) stack.getItem();
                        if(item.getArmorMaterial() == ModArmor.glowstoneMat) {
                            glowstoneArmourPeices++;
                            continue;
                        }
                    }
                }
            }
        }
        if(glowstoneArmourPeices == 4) {
            if(!player.hasAchievement(AchievementHandler.GlowstoneArmor)) {
                player.addStat(AchievementHandler.GlowstoneArmor);
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
        return repair.getItem() == ModItems.Glowstone_gem;
    }

}


