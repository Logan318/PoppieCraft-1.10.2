package net.logan31.poppiecraft.blocks;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.client.gui.GUIHandler;
import net.logan31.poppiecraft.init.ModItems;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockAdvanced;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockBasic;
import net.minecraft.block.Block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import javax.annotation.Nullable;


public class Generator_block_advanced extends Block implements ITileEntityProvider{

    public static final PropertyDirection FACING = PropertyDirection.create( "facing");
    public static final PropertyBool ACTIVATED = PropertyBool.create("activated");


    public Generator_block_advanced(String name) {
        super(Material.IRON);
        this.setRegistryName(new ResourceLocation( References.MODID, name));
        this.setUnlocalizedName(name);
        this.setCreativeTab(PoppieCraftMod.PoppieCraft);
        this.setHardness( 17.5f );
        this.setResistance( 100f );
        this.setHarvestLevel( "pickaxe", 5 );
        this.setDefaultState( this.blockState.getBaseState().withProperty( FACING, EnumFacing.NORTH ).withProperty( ACTIVATED, Boolean.valueOf( false ) ));

    }



    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityGeneratorBlockAdvanced();
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityGeneratorBlockAdvanced();
    }


    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityGeneratorBlockAdvanced te = (TileEntityGeneratorBlockAdvanced) world.getTileEntity( pos );
        if (te != null) {
            IItemHandler handler = te.getCapability( CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null );

                for (int slot = 0; slot < handler.getSlots(); slot++) {
                    System.out.println( "slot: " + slot );
                    if(handler.getStackInSlot( slot ) != null) {
                        Item item = handler.getStackInSlot( slot ).getItem();
                        int meta = handler.getStackInSlot( slot ).getMetadata();
                        int amount = handler.getStackInSlot( slot ).stackSize;
                        InventoryHelper.spawnItemStack( world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack( item, amount, meta) );
                    }
                }

        }
    }


    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    /**
     * Called by ItemBlocks after a block is set in the world, to allow post-place logic
     */
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

        if (stack.hasDisplayName())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

        }
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.setDefaultFacing(worldIn, pos, state);
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.north());
            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            playerIn.openGui(PoppieCraftMod.instance, GUIHandler.GENERATOR_BLOCK_ADVANCED, worldIn, pos.getX(), pos.getY(), pos.getZ() );
        }
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }



    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
        if(worldIn.isBlockPowered(pos)) {
            worldIn.setBlockState(pos, state.withProperty(ACTIVATED, Boolean.valueOf(true)), 2);
        }

        else {
            worldIn.setBlockState(pos, state.withProperty(ACTIVATED, Boolean.valueOf(false)), 2);
        }
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer( this, new IProperty[] {FACING, ACTIVATED} );
    }


    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }





}
