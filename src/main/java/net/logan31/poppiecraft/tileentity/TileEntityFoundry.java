package net.logan31.poppiecraft.tileentity;

import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

/**
 * Created by johanjulien on 17/10/2017.
 */
public class TileEntityFoundry extends TileEntity  implements ITickable, ICapabilityProvider, ISidedInventory {

    private ItemStackHandler handler;
    public static int foundryBurnTime;
    public static int durationSmelting;
    public static int levelFoundry;
    public static int typeSmelt;
    private Boolean isSmelt;
    private int cooldown = 0;

    public TileEntityFoundry() {
        this.handler = new ItemStackHandler( 21 );


    }


    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        this.handler.deserializeNBT( nbt.getCompoundTag( "ItemStackHandler" ) );
        super.readFromNBT( nbt );


    }

    @SideOnly(Side.CLIENT)
    public static int getBurnTime(IInventory inventory) {
        return foundryBurnTime;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        nbt.setTag( "ItemStackHandler", this.handler.serializeNBT() );
        return super.writeToNBT( nbt );
    }


    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
        return oldState.getBlock() != newSate.getBlock();
    }

    @Override
    public void update() {


        if(isFuel())
            cooldown++;
        else
            cooldown = 0;

        Item upgrade = ModItems.Foundry_upgrade;

        for (int slot = 0; slot < 10; slot++) {
            if (this.handler.getStackInSlot( slot ) != null && this.handler.getStackInSlot( slot ).stackSize == 0) {
                this.handler.setStackInSlot( slot, null );
            }
        }

        if (isBurning() || foundryBurnTime == 0) {
            foundryBurnTime--;
        }

        if(foundryBurnTime < 0) {
            durationSmelting = 0;
        }


        if(this.handler.getStackInSlot( 9 ) == null) {
            setField( 3, 4 );
        }
        else if(this.handler.getStackInSlot( 9 ) != null && this.handler.getStackInSlot( 9 ).getItem() == upgrade) {
            if(this.handler.getStackInSlot( 9 ).getMetadata() == 0) {
                setField( 3, 3 );
            }
            else if(this.handler.getStackInSlot( 9 ).getMetadata() == 1) {
                setField( 3, 2 );
            }
            else if(this.handler.getStackInSlot( 9 ).getMetadata() == 2) {
                setField( 3, 1 );
            }
            else {

            }
        }
        else {

        }
        int time = getField( 3 ) * 1000;

        if (durationSmelting > 0 && durationSmelting < time) {
            durationSmelting++;
            isSmelt = true;
            for(int id = 0; id < 2; id++) {
                if (typeSmelt == id) {
                    if (isCraftValid( id ) == false) {
                        durationSmelting = 0;
                    }
                }
            }

        } else if (durationSmelting >= time - 1) {
            Item steelNugget = ModItems.Steel_nugget;
            Item medoliteNugget = ModItems.Medolite_nugget;

            for(int id = 0; id < 2; id++) {
                if (typeSmelt == id) {
                    int amountItem1 = this.handler.getStackInSlot( 0 ).stackSize;
                    int amountItem2 = this.handler.getStackInSlot( 1 ).stackSize;
                    int amountItem3 = this.handler.getStackInSlot( 2 ).stackSize;


                    if (amountItem1 > 1)
                        this.handler.setStackInSlot( 0, new ItemStack( getItemCraft( id, 0 ), amountItem1 - 1, 0 ) );
                    else
                        this.handler.setStackInSlot( 0, null );
                    if (amountItem2 > 1)
                        this.handler.setStackInSlot( 1, new ItemStack( getItemCraft( id, 1 ), amountItem2 - 1, 0 ) );
                    else
                        this.handler.setStackInSlot( 1, null );
                    if (amountItem3 > 1)
                        this.handler.setStackInSlot( 2, new ItemStack( getItemCraft( id, 2 ), amountItem3 - 1, 0 ) );
                    else
                        this.handler.setStackInSlot( 2, null );

                    int metaPower = this.handler.getStackInSlot( 3 ).getMetadata();
                    if (metaPower < 8)
                        this.handler.setStackInSlot( 3, new ItemStack( getItemCraft( id, 3 ), 1, metaPower + 1 ) );
                    else
                        this.handler.setStackInSlot( 3, null );


                    if (this.handler.getStackInSlot( 8 ) == null) {
                        this.handler.setStackInSlot( 8, new ItemStack( getItemCraft( id, 4 ) ) );
                        durationSmelting = 0;
                    } else if (this.handler.getStackInSlot( 8 ) != null && this.handler.getStackInSlot( 8 ).getItem() == getItemCraft( id, 4 )) {
                        int amount = this.handler.getStackInSlot( 8 ).stackSize;
                        this.handler.setStackInSlot( 8, new ItemStack( getItemCraft( id, 4 ), amount + 1 ) );
                        durationSmelting = 0;
                    }
                }
            }


            isSmelt = false;
        } else {
            isSmelt = false;
        }

        if(!this.worldObj.isRemote) {
        if(foundryBurnTime == 1) {
            System.out.println( "coucou" );
            Item burning = ModItems.Burning_carbon;
            if (this.handler.getStackInSlot( 4 ) != null && this.handler.getStackInSlot( 4 ).getItem() == burning) {

                ItemStack burningStack = new ItemStack( burning );
                int amount = this.handler.getStackInSlot( 4 ).stackSize;
                if (amount > 1)
                    this.handler.getStackInSlot( 4 ).stackSize--;
                else
                    this.handler.setStackInSlot( 4, null );

                foundryBurnTime = foundryBurnTime + 1001;
                isSmelt = true;
            }

            }
        }

        System.out.println( this.handler.getStackInSlot( 4 ) );

        if (isSmelt == false) {
            if(!this.worldObj.isRemote) {

                for (int id = 0; id < 2; id++)
                    if (isCraftValid( id )) {

                        Item burning = ModItems.Burning_carbon;
                        if (isBurning()) {


                            isSmelt = true;
                            durationSmelting = 1;
                            typeSmelt = id;

                        } else {
                            if (this.handler.getStackInSlot( 4 ) != null && this.handler.getStackInSlot( 4 ).getItem() == burning && this.isBurning() == false) {
                                if (cooldown > 4) {
                                    int amount = this.handler.getStackInSlot( 4 ).stackSize;
                                    if (amount > 1)
                                        this.handler.getStackInSlot( 4 ).stackSize--;
                                    else {
                                        this.handler.setStackInSlot( 4, null );

                                    }
                                    foundryBurnTime = foundryBurnTime + 1001;
                                    isSmelt = true;
                                }

                            }
                        }

                    } else {

                    }
            }


        }


        if(this.handler.getStackInSlot( 4 ) == null && this.handler.getStackInSlot( 5 ) != null) {
            ItemStack slotBurn1 = this.handler.getStackInSlot( 5 );
            this.handler.setStackInSlot( 4, slotBurn1 );
            this.handler.setStackInSlot( 5, null );
        }
        if(this.handler.getStackInSlot( 4 ) != null && this.handler.getStackInSlot( 5 ) != null
                && this.handler.getStackInSlot( 4 ).getItem() == this.handler.getStackInSlot( 5 ).getItem()) {
            Item slotBurn1 = this.handler.getStackInSlot( 5 ).getItem();
            int amountSlot4 = this.handler.getStackInSlot( 4 ).stackSize;
            int amountSlot5 = this.handler.getStackInSlot( 5 ).stackSize;
            if(amountSlot4 + amountSlot5 <= 64) {
                this.handler.setStackInSlot( 4 , new ItemStack( slotBurn1, amountSlot4 + amountSlot5 ));
                this.handler.setStackInSlot( 5, null );
            }
            else {
                this.handler.setStackInSlot( 4, new ItemStack( slotBurn1, 64 ) );
                this.handler.setStackInSlot( 5, new ItemStack( slotBurn1, amountSlot4 + amountSlot5 - 64 ) );
            }
        }

        if(this.handler.getStackInSlot( 5 ) == null && this.handler.getStackInSlot( 6 ) != null) {
            ItemStack slotBurn2 = this.handler.getStackInSlot( 6 );
            this.handler.setStackInSlot( 5, slotBurn2);
            this.handler.setStackInSlot( 6, null );
        }
        if(this.handler.getStackInSlot( 5 ) != null && this.handler.getStackInSlot( 6 ) != null
                && this.handler.getStackInSlot( 5 ).getItem() == this.handler.getStackInSlot( 6 ).getItem()) {
            Item slotBurn1 = this.handler.getStackInSlot( 6 ).getItem();
            int amountSlot5 = this.handler.getStackInSlot( 5 ).stackSize;
            int amountSlot6 = this.handler.getStackInSlot( 6 ).stackSize;
            if(amountSlot5 + amountSlot6 <= 64) {
                this.handler.setStackInSlot( 5 , new ItemStack( slotBurn1, amountSlot5 + amountSlot6 ));
                this.handler.setStackInSlot( 6, null );
            }
            else {
                this.handler.setStackInSlot( 5, new ItemStack( slotBurn1, 64 ) );
                this.handler.setStackInSlot( 6, new ItemStack( slotBurn1, amountSlot5 + amountSlot6 - 64 ) );
            }
        }

        if(this.handler.getStackInSlot( 6 ) == null && this.handler.getStackInSlot( 7 ) != null) {
            ItemStack slotBurn3 = this.handler.getStackInSlot( 7 );
            this.handler.setStackInSlot( 6, slotBurn3 );
            this.handler.setStackInSlot( 7, null );
        }
        if(this.handler.getStackInSlot( 6 ) != null && this.handler.getStackInSlot( 7 ) != null
                && this.handler.getStackInSlot( 6 ).getItem() == this.handler.getStackInSlot( 7 ).getItem()) {
            Item slotBurn1 = this.handler.getStackInSlot( 7 ).getItem();
            int amountSlot6 = this.handler.getStackInSlot( 6 ).stackSize;
            int amountSlot7 = this.handler.getStackInSlot( 7 ).stackSize;
            if(amountSlot6 + amountSlot7 <= 64) {
                this.handler.setStackInSlot( 6 , new ItemStack( slotBurn1, amountSlot6 + amountSlot7 ));
                this.handler.setStackInSlot( 7, null );
            }
            else {
                this.handler.setStackInSlot( 6, new ItemStack( slotBurn1, 64 ) );
                this.handler.setStackInSlot( 7, new ItemStack( slotBurn1, amountSlot6 + amountSlot7 - 64 ) );
            }
        }



    }

    public boolean isFuel() {
        Item burning = ModItems.Burning_carbon;
        if(this.handler.getStackInSlot( 4 ) != null && this.handler.getStackInSlot( 4 ).getItem() == burning) {
            return true;
        }
        else
            return false;
    }





    public boolean isBurning() {
        return this.foundryBurnTime > 0;
    }

    public boolean isCraftValid(int id) {
            if (craftValid( getItemCraft( id, 0 ), getItemCraft( id, 1 )
                    , getItemCraft( id, 2 ), getItemCraft( id, 3 ), getItemCraft( id, 4 ) )) {
                return true;
            } else
                return false;

    }

    public boolean craftValid(Item item1, Item item2, Item item3, Item power, Item result) {
        //Steel

            if(this.handler.getStackInSlot( 0 ) != null && this.handler.getStackInSlot( 1 ) != null
                    && this.handler.getStackInSlot( 2 ) != null && this.handler.getStackInSlot( 0 ).getItem() == item1
                    && this.handler.getStackInSlot( 1 ).getItem() == item2 && this.handler.getStackInSlot( 2 ).getItem() == item3
                    && this.handler.getStackInSlot( 3 ) != null
                    && this.handler.getStackInSlot( 3 ).getItem() == power && this.handler.getStackInSlot( 8 ) == null
                    || this.handler.getStackInSlot( 8 ) != null && this.handler.getStackInSlot( 8 ).getItem() == result) {

                    return true;


            }
            else
                return false;
    }

    public Item getItemCraft(int id, int idItem) {
         switch (id) {
             case 0:
                 switch (idItem) {
                     case 0:
                         return ModItems.Compressed_carbon;
                     case 1:
                         return ModItems.Compressed_iron;
                     case 2:
                         return ModItems.Poppie_nugget;
                     case 3:
                         return ModItems.Steel_power;
                     case 4:
                         return ModItems.Steel_nugget;
                     default:
                         return null;
                 }
             case 1:
                 switch (idItem) {
                     case 0:
                         return ModItems.Mefferite_nugget;
                     case 1:
                         return ModItems.Ragmarite_nugget;
                     case 2:
                         return ModItems.Alzanite_nugget;
                     case 3:
                         return ModItems.Medolite_power;
                     case 4:
                         return ModItems.Medolite_nugget;
                     default:
                         return null;
                 }
             default:
                 return null;
         }
    }



    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return (T) this.handler;
        return super.getCapability(capability, facing);

    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return true;
        return super.hasCapability(capability, facing);
    }


    @Override
    public int getSizeInventory() {
        return 0;
    }

    @Nullable
    @Override
    public ItemStack getStackInSlot(int index) {
        return null;
    }

    @Nullable
    @Override
    public ItemStack decrStackSize(int index, int count) {
        return null;
    }

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {

    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return false;
    }

    @Override
    public int getField(int id) {
        switch (id)
        {
            case 0:
                return this.foundryBurnTime;
            case  1:
                return this.durationSmelting;
            case 2:
                return this.typeSmelt;
            case 3:
                return this.levelFoundry;
            default:
                return 0;
        }
    }

    @Override
    public void setField(int id, int value) {
        switch (id)
        {
            case 0:
                this.foundryBurnTime = value;
                break;
            case 1:
                this.durationSmelting = value;
            case 2:
                this.typeSmelt = value;
            case 3:
                this.levelFoundry = value;
                break;
        }

    }

    @Override
    public int getFieldCount() {
        return 2;
    }

    @Override
    public void clear() {

    }


    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return false;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {

        if (index <= 17)
        {
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET)
            {
                return false;
            }
            return true;
        }

        return false;
    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        int metadata = getBlockMetadata();
        return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return nbt;
    }

    @Override
    public void handleUpdateTag(NBTTagCompound tag) {
        this.readFromNBT(tag);
    }

    @Override
    public NBTTagCompound getTileData() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return nbt;
    }



}

