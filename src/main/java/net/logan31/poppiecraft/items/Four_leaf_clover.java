package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by johanjulien on 14/09/2017.
 */
public class Four_leaf_clover extends Item {
    public Four_leaf_clover(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(PoppieCraftMod.PoppieArmor);


    }

}
