package net.logan31.poppiecraft.items;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.blocks.Generator_block_advanced;
import net.logan31.poppiecraft.blocks.Generator_block_basic;
import net.logan31.poppiecraft.init.ModBlocks;
import net.logan31.poppiecraft.init.ModItems;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockAdvanced;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockBasic;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import scala.actors.InputChannel;

/**
 * Created by johanjulien on 06/12/2017.
 */
public class Generator_basic_upgrade extends Item{

    public Generator_basic_upgrade(String name) {
        this.setUnlocalizedName( name );
        this.setRegistryName( name );
        this.setCreativeTab( PoppieCraftMod.PoppieCraft );
        this.setMaxStackSize( 1 );
        this.setMaxDamage( 1 );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        Block block = ModBlocks.Generator_block_basic;
        BlockPos pos = Minecraft.getMinecraft().objectMouseOver.getBlockPos();
        IBlockState state = worldIn.getBlockState( pos );
        if(state == block.getDefaultState().withProperty( Generator_block_basic.FACING, EnumFacing.NORTH ).withProperty( Generator_block_basic.ACTIVATED, Boolean.valueOf( false ))
                || state == block.getDefaultState().withProperty( Generator_block_basic.FACING, EnumFacing.NORTH ).withProperty( Generator_block_basic.ACTIVATED, Boolean.valueOf( true ) )
                || state == block.getDefaultState().withProperty( Generator_block_basic.FACING, EnumFacing.SOUTH ).withProperty( Generator_block_basic.ACTIVATED, Boolean.valueOf( false ) )
                || state == block.getDefaultState().withProperty( Generator_block_basic.FACING, EnumFacing.SOUTH ).withProperty( Generator_block_basic.ACTIVATED, Boolean.valueOf( true ) )
                || state == block.getDefaultState().withProperty( Generator_block_basic.FACING, EnumFacing.EAST ).withProperty( Generator_block_basic.ACTIVATED, Boolean.valueOf( false ) )
                || state == block.getDefaultState().withProperty( Generator_block_basic.FACING, EnumFacing.EAST ).withProperty( Generator_block_basic.ACTIVATED, Boolean.valueOf( true ) )
                || state == block.getDefaultState().withProperty( Generator_block_basic.FACING, EnumFacing.WEST ).withProperty( Generator_block_basic.ACTIVATED, Boolean.valueOf( false ) )
                || state == block.getDefaultState().withProperty( Generator_block_basic.FACING, EnumFacing.WEST ).withProperty( Generator_block_basic.ACTIVATED, Boolean.valueOf( true ) )) {

            Item slot0, slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9, slot10, slot11, slot12, slot13, slot14, slot15, slot16, slot17, slot18, slot19, slot20;
            int meta0, meta1, meta2, meta3, meta4, meta5, meta6, meta7, meta8, meta9, meta10, meta11, meta12, meta13, meta14, meta15, meta16, meta17, meta18, meta19, meta20;
            int amount0, amount1, amount2, amount3, amount4, amount5, amount6, amount7, amount8, amount9, amount10, amount11, amount12, amount13, amount14, amount15, amount16, amount17, amount18, amount19, amount20;

            Item upgrade = ModItems.Basic_generator_upgrade;

            TileEntityGeneratorBlockBasic te = (TileEntityGeneratorBlockBasic) worldIn.getTileEntity( pos );
            ItemStackHandler handler = (ItemStackHandler) te.getCapability( CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null );



            if(handler.getStackInSlot( 0 ) != null) {
                slot0 = handler.getStackInSlot( 0 ).getItem();
                meta0 = handler.getStackInSlot( 0 ).getMetadata();
                amount0 = handler.getStackInSlot( 0 ).stackSize;

            } else {
                slot0 = null;
                meta0 = 0;
                amount0 = 0;
            }
            if(handler.getStackInSlot( 1 ) != null) {
                slot1 = handler.getStackInSlot( 1 ).getItem();
                meta1 = handler.getStackInSlot( 1 ).getMetadata();
                amount1 = handler.getStackInSlot( 1 ).stackSize;
            } else {
                slot1 = null;
                meta1 = 0;
                amount1 = 0;
            }
            if(handler.getStackInSlot( 2 ) != null) {
                slot2 = handler.getStackInSlot( 2 ).getItem();
                meta2 = handler.getStackInSlot( 2 ).getMetadata();
                amount2 = handler.getStackInSlot( 2 ).stackSize;

            } else {
                slot2 = null;
                meta2 = 0;
                amount2 = 0;
            }
            if(handler.getStackInSlot( 3 ) != null) {
                slot3 = handler.getStackInSlot( 3 ).getItem();
                meta3 = handler.getStackInSlot( 3 ).getMetadata();
                amount3 = handler.getStackInSlot( 3 ).stackSize;

            } else {
                slot3 = null;
                meta3 = 0;
                amount3 = 0;
            }
            if(handler.getStackInSlot( 4 ) != null) {
                slot4 = handler.getStackInSlot( 4 ).getItem();
                meta4 = handler.getStackInSlot( 4 ).getMetadata();
                amount4 = handler.getStackInSlot( 4 ).stackSize;

            } else {
                slot4 = null;
                meta4 = 0;
                amount4 = 0;
            }
            if(handler.getStackInSlot( 5 ) != null) {
                slot5 = handler.getStackInSlot( 5 ).getItem();
                meta5 = handler.getStackInSlot( 5 ).getMetadata();
                amount5 = handler.getStackInSlot( 5 ).stackSize;

            } else {
                slot5 = null;
                meta5 = 0;
                amount5 = 0;
            }
            if(handler.getStackInSlot( 6 ) != null) {
                slot6 = handler.getStackInSlot( 6 ).getItem();
                meta6 = handler.getStackInSlot( 6 ).getMetadata();
                amount6 = handler.getStackInSlot( 6 ).stackSize;

            } else {
                slot6 = null;
                meta6 = 0;
                amount6 = 0;
            }
            if(handler.getStackInSlot( 7 ) != null) {
                slot7 = handler.getStackInSlot( 7 ).getItem();
                meta7 = handler.getStackInSlot( 7 ).getMetadata();
                amount7 = handler.getStackInSlot( 7 ).stackSize;

            } else {
                slot7 = null;
                meta7 = 0;
                amount7 = 0;
            }
            if(handler.getStackInSlot( 8 ) != null) {
                slot8 = handler.getStackInSlot( 8 ).getItem();
                meta8 = handler.getStackInSlot( 8 ).getMetadata();
                amount8 = handler.getStackInSlot( 8 ).stackSize;

            } else {
                slot8 = null;
                meta8 = 0;
                amount8 = 0;
            }
            if(handler.getStackInSlot( 9 ) != null) {
                slot9 = handler.getStackInSlot( 9 ).getItem();
                meta9 = handler.getStackInSlot( 9 ).getMetadata();
                amount9 = handler.getStackInSlot( 9 ).stackSize;

            } else {
                slot9 = null;
                meta9 = 0;
                amount9 = 0;
            }
            if(handler.getStackInSlot( 10 ) != null) {
                slot10 = handler.getStackInSlot( 10 ).getItem();
                meta10 = handler.getStackInSlot( 10 ).getMetadata();
                amount10 = handler.getStackInSlot( 10 ).stackSize;

            } else {
                slot10 = null;
                meta10 = 0;
                amount10 = 0;
            }
            if(handler.getStackInSlot( 11 ) != null) {
                slot11 = handler.getStackInSlot( 11 ).getItem();
                meta11 = handler.getStackInSlot( 11 ).getMetadata();
                amount11 = handler.getStackInSlot( 11 ).stackSize;

            } else {
                slot11 = null;
                meta11 = 0;
                amount11 = 0;
            }
            if(handler.getStackInSlot( 12 ) != null) {
                slot12 = handler.getStackInSlot( 12 ).getItem();
                meta12 = handler.getStackInSlot( 12 ).getMetadata();
                amount12 = handler.getStackInSlot( 12 ).stackSize;

            } else {
                slot12 = null;
                meta12 = 0;
                amount12 = 0;
            }
            if(handler.getStackInSlot( 13 ) != null) {
                slot13 = handler.getStackInSlot( 13 ).getItem();
                meta13 = handler.getStackInSlot( 13 ).getMetadata();
                amount13 = handler.getStackInSlot( 13 ).stackSize;

            } else {
                slot13 = null;
                meta13 = 0;
                amount13 = 0;
            }
            if(handler.getStackInSlot( 14 ) != null) {
                slot14 = handler.getStackInSlot( 14 ).getItem();
                meta14 = handler.getStackInSlot( 14 ).getMetadata();
                amount14 = handler.getStackInSlot( 14 ).stackSize;

            } else {
                slot14 = null;
                meta14 = 0;
                amount14 = 0;
            }
            if(handler.getStackInSlot( 15 ) != null) {
                slot15 = handler.getStackInSlot( 15 ).getItem();
                meta15 = handler.getStackInSlot( 15 ).getMetadata();
                amount15 = handler.getStackInSlot( 15 ).stackSize;

            } else {
                slot15 = null;
                meta15 = 0;
                amount15 = 0;
            }
            if(handler.getStackInSlot( 16 ) != null) {
                slot16 = handler.getStackInSlot( 16 ).getItem();
                meta16 = handler.getStackInSlot( 16 ).getMetadata();
                amount16 = handler.getStackInSlot( 16 ).stackSize;

            } else {
                slot16 = null;
                meta16 = 0;
                amount16 = 0;
            }
            if(handler.getStackInSlot( 17 ) != null) {
                slot17 = handler.getStackInSlot( 17 ).getItem();
                meta17 = handler.getStackInSlot( 17 ).getMetadata();
                amount17 = handler.getStackInSlot( 17 ).stackSize;

            } else {
                slot17 = null;
                meta17 = 0;
                amount17 = 0;
            }
            if(handler.getStackInSlot( 18 ) != null) {
                slot18 = handler.getStackInSlot( 18 ).getItem();
                meta18 = handler.getStackInSlot( 18 ).getMetadata();
                amount18 = handler.getStackInSlot( 18 ).stackSize;

            } else {
                slot18 = null;
                meta18 = 0;
                amount18 = 0;
            }
            if(handler.getStackInSlot( 19 ) != null) {
                slot19 = handler.getStackInSlot( 19 ).getItem();
                meta19 = handler.getStackInSlot( 19 ).getMetadata();
                amount19 = handler.getStackInSlot( 19 ).stackSize;

            } else {
                slot19 = null;
                meta19 = 0;
                amount19 = 0;
            }
            if(handler.getStackInSlot( 20 ) != null) {
                slot20 = handler.getStackInSlot( 20 ).getItem();
                meta20 = handler.getStackInSlot( 20 ).getMetadata();
                amount20 = handler.getStackInSlot( 20 ).stackSize;

            } else {
                slot20 = null;
                meta20 = 0;
                amount20 = 0;
            }

            if(worldIn.isBlockPowered( pos )) {
                for(int i = 0; i <= 10; i++) {
                    if(i == 10) {
                        if(!worldIn.isRemote) {
                            ItemStack stack = new ItemStack( getItemFromBlock( Blocks.TRIPWIRE_HOOK ) );
                            handler.setStackInSlot( 20, stack );
                            IBlockState state2 = worldIn.getBlockState( pos );
                            worldIn.setBlockState( pos, ModBlocks.Generator_block_advanced.getDefaultState().withProperty( Generator_block_advanced.FACING, state2.getValue( Generator_block_basic.FACING ) ), 2 );
                            TileEntityGeneratorBlockAdvanced te2 = (TileEntityGeneratorBlockAdvanced) worldIn.getTileEntity( pos );
                            ItemStackHandler handler2 = (ItemStackHandler) te2.getCapability( CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null );
                            ItemStack main = playerIn.getHeldItemMainhand();
                            main.damageItem( 2, playerIn );

                            ItemStack stack0, stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9, stack10, stack11, stack12, stack13, stack14, stack15, stack16, stack17, stack18, stack19, stack20;
                            if(slot0 != null) {
                                stack0 = new ItemStack( slot0 , amount0, meta0);
                            }
                            else {
                                stack0 = null;
                            }
                            if(slot1 != null) {
                                stack1 = new ItemStack( slot1 , amount1, meta1);
                            }
                            else {
                                stack1 = null;
                            }
                            if(slot2 != null) {
                                stack2 = new ItemStack( slot2 , amount2, meta2);
                            }
                            else {
                                stack2 = null;
                            }
                            if(slot3 != null) {
                                stack3 = new ItemStack( slot3 , amount3, meta3);
                            }
                            else {
                                stack3 = null;
                            }
                            if(slot4 != null) {
                                stack4 = new ItemStack( slot4 , amount4, meta4);
                            }
                            else {
                                stack4 = null;
                            }
                            if(slot5 != null) {
                                stack5 = new ItemStack( slot5 , amount5, meta5);
                            }
                            else {
                                stack5 = null;
                            }
                            if(slot6 != null) {
                                stack6 = new ItemStack( slot6 , amount6, meta6);
                            }
                            else {
                                stack6 = null;
                            }
                            if(slot7 != null) {
                                stack7 = new ItemStack( slot7 , amount7, meta7);
                            }
                            else {
                                stack7 = null;
                            }
                            if(slot8 != null) {
                                stack8 = new ItemStack( slot8 , amount8, meta8);
                            }
                            else {
                                stack8 = null;
                            }
                            if(slot9 != null) {
                                stack9 = new ItemStack( slot9 , amount9, meta9);
                            }
                            else {
                                stack9 = null;
                            }
                            if(slot10 != null) {
                                stack10 = new ItemStack( slot10 , amount10, meta10);
                            }
                            else {
                                stack10 = null;
                            }
                            if(slot11 != null) {
                                stack11 = new ItemStack( slot11 , amount11, meta11);
                            }
                            else {
                                stack11 = null;
                            }
                            if(slot12 != null) {
                                stack12 = new ItemStack( slot12 , amount12, meta12);
                            }
                            else {
                                stack12 = null;
                            }
                            if(slot13 != null) {
                                stack13 = new ItemStack( slot13 , amount13, meta13);
                            }
                            else {
                                stack13 = null;
                            }
                            if(slot14 != null) {
                                stack14 = new ItemStack( slot14 , amount14, meta14);
                            }
                            else {
                                stack14 = null;
                            }
                            if(slot15 != null) {
                                stack15 = new ItemStack( slot15 , amount15, meta15);
                            }
                            else {
                                stack15 = null;
                            }
                            if(slot16 != null) {
                                stack16 = new ItemStack( slot16 , amount16, meta16);
                            }
                            else {
                                stack16 = null;
                            }
                            if(slot17 != null) {
                                stack17 = new ItemStack( slot17 , amount17, meta17);
                            }
                            else {
                                stack17 = null;
                            }
                            if(slot18 != null) {
                                stack18 = new ItemStack( slot18 , amount18, meta18);
                            }
                            else {
                                stack18 = null;
                            }
                            if(slot19 != null) {
                                stack19 = new ItemStack( slot19 , amount19, meta19);
                            }
                            else {
                                stack19 = null;
                            }
                            if(slot20 != null) {
                                stack20 = new ItemStack( slot20 , amount20, meta20);
                            }
                            else {
                                stack20 = null;
                            }
                            handler2.setStackInSlot( 0, stack0 );
                            handler2.setStackInSlot( 1, stack1 );
                            handler2.setStackInSlot( 2, stack2 );
                            handler2.setStackInSlot( 3, stack3 );
                            handler2.setStackInSlot( 4, stack4 );
                            handler2.setStackInSlot( 5, stack5 );
                            handler2.setStackInSlot( 6, stack6 );
                            handler2.setStackInSlot( 7, stack7 );
                            handler2.setStackInSlot( 8, stack8 );
                            handler2.setStackInSlot( 9, stack9 );
                            handler2.setStackInSlot( 10, stack10 );
                            handler2.setStackInSlot( 11, stack11 );
                            handler2.setStackInSlot( 12, stack12 );
                            handler2.setStackInSlot( 13, stack13 );
                            handler2.setStackInSlot( 14, stack14 );
                            handler2.setStackInSlot( 15, stack15 );
                            handler2.setStackInSlot( 16, stack16 );
                            handler2.setStackInSlot( 17, stack17 );
                            handler2.setStackInSlot( 18, stack18 );
                            handler2.setStackInSlot( 20, stack19 );
                            handler2.setStackInSlot( 22, stack20 );

                        }
                    }
                }

            }


        }


        return super.onItemRightClick( itemStackIn, worldIn, playerIn, hand );
    }
}
