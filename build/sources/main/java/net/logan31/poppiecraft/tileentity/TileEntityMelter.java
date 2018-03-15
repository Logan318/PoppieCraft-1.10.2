package net.logan31.poppiecraft.tileentity;

import net.logan31.poppiecraft.Utils.Utils;
import net.logan31.poppiecraft.init.ModBlocks;
import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Created by johanjulien on 17/10/2017.
 */
public class TileEntityMelter extends TileEntity  implements ITickable, ICapabilityProvider, ISidedInventory{

    private ItemStackHandler handler;
    private int cooldown;
    private  int melterBurnTime;




    public TileEntityMelter() {
        this.cooldown = 0;
        this.handler = new ItemStackHandler(21);


    }


    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        this.cooldown = nbt.getInteger("Cooldown");
        this.handler.deserializeNBT(nbt.getCompoundTag("ItemStackHandler"));
        super.readFromNBT(nbt);



    }


    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        nbt.setInteger( "Cooldown", this.cooldown );
        nbt.setInteger( "Random", this.cooldown );
        nbt.setTag( "ItemStackHandler", this.handler.serializeNBT() );
        return super.writeToNBT( nbt );
    }


    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
        return oldState.getBlock() != newSate.getBlock();
    }

    @Override
    public void update() {

        Item carbon = ModItems.Compressed_carbon;
        Item iron = ModItems.Compressed_iron;
        Item poppie = ModItems.Poppie_nugget;
        Item steelPower = ModItems.Steel_power;
        if(this.isBurning()) {
            melterBurnTime--;

        }
            if(this.handler.getStackInSlot( 0 ) != null && this.handler.getStackInSlot( 1 ) != null && this.handler.getStackInSlot( 2 ) != null && this.handler.getStackInSlot( 3 ) != null &&
                    this.handler.getStackInSlot( 0 ).getItem() == carbon && this.handler.getStackInSlot( 1 ).getItem() == iron && this.handler.getStackInSlot( 2 ).getItem() == poppie && this.handler.getStackInSlot( 3 ).getItem() == steelPower) {

                if(this.handler.getStackInSlot( 0 ).stackSize >= 3 && this.handler.getStackInSlot( 1 ).stackSize >= 3
                        && this.handler.getStackInSlot( 2 ).stackSize >= 3) {

                    Item burning = ModItems.Burning_carbon;
                    if(isBurning()) {

                        //Lancement steel
                        int amountCarbon = this.handler.getStackInSlot( 0 ).stackSize;
                        this.handler.setStackInSlot( 0, new ItemStack(ModItems.Compressed_carbon, amountCarbon - 1, 0));


                    }

                    else {
                        if (this.handler.getStackInSlot( 5 ) != null && this.handler.getStackInSlot( 5 ).getItem() == burning && this.isBurning() == false) {

                            ItemStack burningStack = new ItemStack( burning );
                            int amount = burningStack.stackSize;
                            this.handler.setStackInSlot( 5, new ItemStack( burning, amount - 1 ) );
                            this.melterBurnTime = this.melterBurnTime + 200;
                            //lancement burn
                            //lancement steel
                        }
                    }
                }
            }


        ItemStack slotBurn1 = this.handler.getStackInSlot( 5 );
        ItemStack slotBurn2 = this.handler.getStackInSlot( 6 );
        ItemStack slotBurn3 = this.handler.getStackInSlot( 7 );

        if(this.handler.getStackInSlot( 4 ) == null && this.handler.getStackInSlot( 5 ) != null) {
            this.handler.setStackInSlot( 4, slotBurn1 );
            this.handler.setStackInSlot( 5, null );
        }

        if(this.handler.getStackInSlot( 5 ) == null && this.handler.getStackInSlot( 6 ) != null) {
            this.handler.setStackInSlot( 5, slotBurn2 );
            this.handler.setStackInSlot( 6, null );
        }

        if(this.handler.getStackInSlot( 6 ) == null && this.handler.getStackInSlot( 7 ) != null) {
            this.handler.setStackInSlot( 6, slotBurn3 );
            this.handler.setStackInSlot( 7, null );
        }


    }

    public boolean isBurning() {
        return this.melterBurnTime > 0;
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
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
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

    /**
     * Reads the nbt when it receives a packet
     */
    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.getNbtCompound());
    }

    /**
     * Gets the nbt for a new packet
     */
    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return nbt;
    }

    /**
     * Handles when you get an update
     */
    @Override
    public void handleUpdateTag(NBTTagCompound tag) {
        this.readFromNBT(tag);
    }

    /**
     * Gets the tile entities nbt with all of the data stored in it
     */
    @Override
    public NBTTagCompound getTileData() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return nbt;
    }

}

