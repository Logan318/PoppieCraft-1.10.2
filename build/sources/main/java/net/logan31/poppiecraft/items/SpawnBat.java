package net.logan31.poppiecraft.items;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.HorseType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by johanjulien on 31/10/2017.
 */
public class SpawnBat extends Item {

    public SpawnBat(String name) {
        this.setUnlocalizedName( name );
        this.setRegistryName( name );
        this.setCreativeTab( CreativeTabs.MISC );
        this.setMaxDamage( 1 );

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if (!worldIn.isRemote) {
            EntityBat entity = new EntityBat( worldIn );
            entity.setPosition( Minecraft.getMinecraft().objectMouseOver.getBlockPos().getX(), Minecraft.getMinecraft().objectMouseOver.getBlockPos().getY() + 1, Minecraft.getMinecraft().objectMouseOver.getBlockPos().getZ());
            worldIn.spawnEntityInWorld( entity );
            ItemStack egg = playerIn.getHeldItemMainhand();
            egg.damageItem( 2, playerIn );
        }
            return super.onItemRightClick( itemStackIn, worldIn, playerIn, hand );
        }



}
