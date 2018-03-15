package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by johanjulien on 04/12/2017.
 */
public class FoundryPower extends Item {

    public static final String[] subTypes = new String[]{"Normal", "Normal2", "Very_Slightly_Damaged", "Very_Slightly_Damaged2"
    , "Slightly_Damaged", "Slightly_Damaged2", "Damaged", "Very_Damaged", "Extremely_Damaged"};

    public FoundryPower(String name) {
        this.setUnlocalizedName( name );
        this.setRegistryName( name );
        this.setCreativeTab( PoppieCraftMod.PoppieCraft );
        this.maxStackSize = 1;
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        int metadata = stack.getItemDamage();
        if(metadata < 0 || metadata > subTypes.length)
            metadata = 0;
        return super.getUnlocalizedName(stack) + "_" + subTypes[metadata];
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for(int i = 0; i < subTypes.length; i++) {
            subItems.add(new ItemStack(itemIn, 1, i));
        }

    }
}
