package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.Utils.References;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by johanjulien on 28/09/2017.
 */

public class ItemFoodMod extends net.minecraft.item.ItemFood {


    private PotionEffect[] effects;

    public ItemFoodMod(String unlocalizedName, int amount, boolean isWolfFood, PotionEffect...potionEffects) {
        super(amount, isWolfFood);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(References.MODID, unlocalizedName));
        this.effects = potionEffects;
    }

    public ItemFoodMod(String unlocalizedName, int amount, float saturation, boolean isWolfFood, PotionEffect...potionEffects) {
        super(amount, saturation, isWolfFood);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(References.MODID, unlocalizedName));
        this.effects = potionEffects;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        for(PotionEffect effect : effects) {
            player.addPotionEffect(new PotionEffect(effect));
        }
    }
}
