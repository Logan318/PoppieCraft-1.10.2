package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.blocks.Generator_block_basic;
import net.logan31.poppiecraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by johanjulien on 06/12/2017.
 */
public class Generator_basic_upgrade extends Item{

    public Generator_basic_upgrade(String name) {
        this.setUnlocalizedName( name );
        this.setRegistryName( name );
        this.setCreativeTab( PoppieCraftMod.PoppieCraft );
        this.setMaxStackSize( 1 );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        Block block = ModBlocks.Generator_block_basic;
        BlockPos pos = Minecraft.getMinecraft().objectMouseOver.getBlockPos();
        IBlockState state = worldIn.getBlockState( pos );
        if(state == block.getDefaultState().withProperty( Generator_block_basic.FACING, EnumFacing.NORTH )
                || state == block.getDefaultState().withProperty( Generator_block_basic.FACING, EnumFacing.SOUTH )
                || state == block.getDefaultState().withProperty( Generator_block_basic.FACING, EnumFacing.EAST )
                || state == block.getDefaultState().withProperty( Generator_block_basic.FACING, EnumFacing.WEST ) || state == block.getDefaultState().withProperty( Generator_block_basic.ACTIVATED, Boolean.TRUE )) {
            System.out.println( "That work" );
        }


        return super.onItemRightClick( itemStackIn, worldIn, playerIn, hand );
    }
}
