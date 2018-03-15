package net.logan31.poppiecraft.tileentity;

import net.logan31.poppiecraft.Utils.Utils;
import net.logan31.poppiecraft.blocks.Generator_block_advanced;
import net.logan31.poppiecraft.blocks.Generator_block_basic;
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
import net.minecraft.inventory.InventoryHelper;
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
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Created by johanjulien on 17/10/2017.
 */
public class TileEntityGeneratorBlockBasic extends TileEntity  implements ITickable, ICapabilityProvider, ISidedInventory{

    private ItemStackHandler handler;
    private int cooldown;
    private int index = 0;
    private Block block;




    public TileEntityGeneratorBlockBasic() {
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

    public void generate(Item itemGenerate, int metaItem, Item itemGenerateBurn, int metaItemBurn) {

        Item bookEnch = Items.ENCHANTED_BOOK;
        ItemStack stack;
        ItemStack stackBurn;
        stack = new ItemStack( itemGenerate, 1, metaItem );
        stackBurn = new ItemStack( itemGenerateBurn, 1, metaItemBurn );

        for (int slot = 0, stop = 0; (slot < 18 && stop == 0); slot++) {


            if (this.handler.getStackInSlot( 18 ) != null && this.handler.getStackInSlot( 18 ).getItem() == bookEnch) {


                Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments( this.handler.getStackInSlot( 18 ) );
                if (enchantments.containsKey( Enchantments.FIRE_ASPECT )) {
                    if (this.handler.getStackInSlot( slot ) == null || this.handler.getStackInSlot( slot ).getItem() == itemGenerateBurn && this.handler.getStackInSlot( slot ).stackSize < 64 && this.handler.getStackInSlot( slot ).getMetadata() == metaItemBurn) {
                        this.handler.insertItem( slot, stackBurn, false );
                        stop = 1;

                    } else {
                        stop = 0;
                    }

                } else {
                    if (this.handler.getStackInSlot( slot ) == null || this.handler.getStackInSlot( slot ).getItem() == itemGenerate && this.handler.getStackInSlot( slot ).stackSize < 64 && this.handler.getStackInSlot( slot ).getMetadata() == metaItem) {
                        this.handler.insertItem( slot, stack, false );
                        stop = 1;
                    } else {
                        stop = 0;
                    }
                }

            } else {
                if (this.handler.getStackInSlot( slot ) == null || this.handler.getStackInSlot( slot ).getItem() == itemGenerate && this.handler.getStackInSlot( slot ).stackSize < 64 && this.handler.getStackInSlot( slot ).getMetadata() == metaItem) {
                    this.handler.insertItem( slot, stack, false );

                    stop = 1;
                } else {
                    stop = 0;

                }
            }
        }
    }



    public void generateItem(Item item, int metaSoul, int valueRadomMin, int valueRandomMax, Item itemGenerate, int metaItem, Item itemGenerateBurn, int metaItemBurn) {

        int slot;
        int stop;
        int min = 0;
        int max = 0;
        Item bookEnch = Items.ENCHANTED_BOOK;
        ItemStack stack;
        ItemStack stackBurn;
        stack = new ItemStack( itemGenerate, 1, metaItem );
        stackBurn = new ItemStack( itemGenerateBurn, 1, metaItemBurn );


        if (this.worldObj.isBlockPowered( pos )) {
            if (this.handler.getStackInSlot( 20 ) != null) {
                if (this.handler.getStackInSlot( 20 ).getMetadata() == 0) {
                    max = 9500;


                    int random = (int) (Math.random() * (max - min)) + min;

                    if (this.handler.getStackInSlot( 19 ) != null) {


                        if (this.handler.getStackInSlot( 19 ).getItem() == item)
                            if (this.handler.getStackInSlot( 19 ).getMetadata() == metaSoul) {
                                if (random >= valueRadomMin && random <= valueRandomMax) {
                                    generate( itemGenerate, metaItem, itemGenerateBurn, metaItemBurn );

                                }

                            }


                    }

                }
            } else {
                max = 10000;


                int random = (int) (Math.random() * (max - min)) + min;

                if (this.handler.getStackInSlot( 19 ) != null) {


                    if (this.handler.getStackInSlot( 19 ).getItem() == item)
                        if (this.handler.getStackInSlot( 19 ).getMetadata() == metaSoul) {

                            if (random >= valueRadomMin && random <= valueRandomMax) {

                                generate(itemGenerate, metaItem, itemGenerateBurn, metaItemBurn   );

                            }

                        }


                }


            }


        }
    }


    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
        return oldState.getBlock() != newSate.getBlock();
    }

    @Override
    public void update() {

        this.cooldown++;
        this.cooldown %= 100;
        generateBasic();
        Item upgrade = ModItems.Basic_generator_upgrade;
        Item slot0;
        Item slot1;
        Item slot2;
        Item slot3;
        Item slot4;
        Item slot5;
        Item slot6;
        Item slot7;
        Item slot8;
        Item slot9;
        Item slot10;
        Item slot11;
        Item slot12;
        Item slot13;
        Item slot14;
        Item slot15;
        Item slot16;
        Item slot17;
        Item slot18;
        Item slot19;
        if(this.handler.getStackInSlot( 0 ) != null) {
            slot0 = this.handler.getStackInSlot( 0 ).getItem();
        } else {
            slot0 = null;
        }
        if(this.handler.getStackInSlot( 1 ) != null) {
            slot1 = this.handler.getStackInSlot( 1 ).getItem();
        } else {
            slot1 = null;
        }
        if(this.handler.getStackInSlot( 2 ) != null) {
            slot2 = this.handler.getStackInSlot( 2 ).getItem();
        }else {
            slot2 = null;
        }
        if(this.handler.getStackInSlot( 3 ) != null) {
            slot3 = this.handler.getStackInSlot( 3 ).getItem();
        }else{
            slot3 = null;
        }
        if(this.handler.getStackInSlot( 4 ) != null) {
            slot4 = this.handler.getStackInSlot( 4 ).getItem();
        }else{
            slot4 = null;
        }
        if(this.handler.getStackInSlot( 5 ) != null) {
            slot5 = this.handler.getStackInSlot( 5 ).getItem();
        }else{
            slot5 = null;
        }
        if(this.handler.getStackInSlot( 6 ) != null) {
            slot6 = this.handler.getStackInSlot( 6 ).getItem();
        }else{
            slot6 = null;
        }
        if(this.handler.getStackInSlot( 7 ) != null) {
            slot7 = this.handler.getStackInSlot( 7 ).getItem();
        }else{
            slot7 = null;
        }
        if(this.handler.getStackInSlot( 8 ) != null) {
            slot8 = this.handler.getStackInSlot( 8 ).getItem();
        }else{
            slot8 = null;
        }
        if(this.handler.getStackInSlot( 9 ) != null) {
            slot9 = this.handler.getStackInSlot( 9 ).getItem();
        }else{
            slot9 = null;
        }
        if(this.handler.getStackInSlot( 10 ) != null) {
            slot10 = this.handler.getStackInSlot( 10 ).getItem();
        }else{
            slot10 = null;
        }
        if(this.handler.getStackInSlot( 11 ) != null) {
            slot11 = this.handler.getStackInSlot( 11 ).getItem();
        }else{
            slot11 = null;
        }
        if(this.handler.getStackInSlot( 12 ) != null) {
            slot12 = this.handler.getStackInSlot( 12 ).getItem();
        }else{
            slot12 = null;
        }
        if(this.handler.getStackInSlot( 13 ) != null) {
            slot13 = this.handler.getStackInSlot( 13 ).getItem();
        }else{
            slot13 = null;
        }
        if(this.handler.getStackInSlot( 14 ) != null) {
            slot14 = this.handler.getStackInSlot( 14 ).getItem();
        }else{
            slot14 = null;
        }
        if(this.handler.getStackInSlot( 15 ) != null) {
            slot15 = this.handler.getStackInSlot( 15 ).getItem();
        }else{
            slot15 = null;
        }
        if(this.handler.getStackInSlot( 16 ) != null) {
            slot16 = this.handler.getStackInSlot( 16 ).getItem();
        }else{
            slot16 = null;
        }
        if(this.handler.getStackInSlot( 17 ) != null) {
            slot17 = this.handler.getStackInSlot( 17 ).getItem();
        }else{
            slot17 = null;
        }
        if(this.handler.getStackInSlot( 18 ) != null) {
            slot18 = this.handler.getStackInSlot( 18 ).getItem();
        }else{
            slot18 = null;
        }
        if(this.handler.getStackInSlot( 19 ) != null) {
            slot19 = this.handler.getStackInSlot( 19 ).getItem();
        }else{
            slot19 = null;
        }


        if(this.worldObj.isBlockPowered( pos ) && this.handler.getStackInSlot( 20 ) != null && this.handler.getStackInSlot( 20 ).getItem() == upgrade) {
            for(int i = 0; i <= 10; i++) {
                if(i == 10) {
                    if(!worldObj.isRemote) {
                        IBlockState state = this.worldObj.getBlockState( this.pos );
                        this.worldObj.setBlockState( this.pos, ModBlocks.Generator_block_advanced.getDefaultState().withProperty( Generator_block_advanced.FACING, state.getValue( Generator_block_basic.FACING ) ), 2 );
                        TileEntityGeneratorBlockAdvanced te = (TileEntityGeneratorBlockAdvanced) worldObj.getTileEntity( pos );
                        ItemStackHandler handler2 = (ItemStackHandler) te.getCapability( CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null );




                    }
                }
            }

        }

    }

    public void generateBasic() {

        if (this.handler.getStackInSlot( 19 ) != null && this.handler.getStackInSlot( 19 ) == null) {
            this.cooldown++;
            this.cooldown %= 100;
            Utils.getLogger().info( "Cooldown : " + this.cooldown );

        }

        //bat
        generateItem(ModItems.Basic_spirit, 0, 0, 0, ModItems.Bat_Spawn, 0, ModItems.Bat_Spawn, 0);

        //Chicken
        generateItem(ModItems.Basic_spirit, 1, 0, 20, Items.CHICKEN, 0, Items.COOKED_CHICKEN, 0);
        generateItem(ModItems.Basic_spirit, 1, 21, 36, Items.FEATHER, 0, Items.FEATHER, 0);
        generateItem(ModItems.Basic_spirit, 1, 37, 40, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 1, 41, 41, ModItems.Chicken_Spawn, 0, ModItems.Chicken_Spawn, 0);

        //Cow
        generateItem(ModItems.Basic_spirit, 2, 0, 20, Items.BEEF, 0, Items.COOKED_BEEF, 0);
        generateItem(ModItems.Basic_spirit, 2, 21, 36, Items.LEATHER, 0, Items.LEATHER, 0);
        generateItem(ModItems.Basic_spirit, 2, 37, 40, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 2, 41, 41, ModItems.Cow_Spawn, 0, ModItems.Cow_Spawn, 0);

        //Endermite
        generateItem(ModItems.Basic_spirit, 3, 0, 6, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 3, 7, 7, ModItems.Endermite_Spawn, 0, ModItems.Endermite_Spawn, 0);

        //Mooshroom
        generateItem(ModItems.Basic_spirit, 4, 0, 20, Items.BEEF, 0, Items.COOKED_BEEF, 0);
        generateItem(ModItems.Basic_spirit, 4, 21, 36, Items.LEATHER, 0, Items.LEATHER, 0);
        generateItem(ModItems.Basic_spirit, 4, 37, 40, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 4, 41, 41, ModItems.Mooshroom_Spawn, 0, ModItems.Mooshroom_Spawn, 0);

        //Ocelot
        generateItem(ModItems.Basic_spirit, 5, 0, 3, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 5, 4, 4, ModItems.Ocelot_Spawn, 0, ModItems.Ocelot_Spawn, 0);

        //Pig
        generateItem(ModItems.Basic_spirit, 6, 0, 20, Items.PORKCHOP, 0, Items.COOKED_PORKCHOP, 0);
        generateItem(ModItems.Basic_spirit, 6, 21, 24, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 6, 25, 25, ModItems.Pig_Spawn, 0, ModItems.Pig_Spawn, 0);

        //Polar_Bear
        generateItem(ModItems.Basic_spirit, 7, 0, 20, Items.FISH, 0, Items.COOKED_FISH, 0);
        generateItem(ModItems.Basic_spirit, 7, 21, 41, Items.FISH, 1, Items.COOKED_FISH, 1);
        generateItem(ModItems.Basic_spirit, 7, 42, 45, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 7, 46, 46, ModItems.Polar_Bear_Spawn, 0, ModItems.Polar_Bear_Spawn, 0);

        //Rabbit
        generateItem(ModItems.Basic_spirit, 8, 0, 20, Items.RABBIT, 0, Items.COOKED_RABBIT, 0);
        generateItem(ModItems.Basic_spirit, 8, 21, 36, Items.RABBIT_HIDE, 0, Items.RABBIT_HIDE, 0);
        generateItem(ModItems.Basic_spirit, 8, 37, 37, Items.RABBIT_FOOT, 0, Items.RABBIT_FOOT, 0);
        generateItem(ModItems.Basic_spirit, 8, 38, 41, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 8, 42, 42, ModItems.Rabbit_Spawn, 0, ModItems.Rabbit_Spawn, 0);

        //Sheep
        generateItem(ModItems.Basic_spirit, 9, 0, 20, Items.MUTTON, 0, Items.COOKED_MUTTON, 0);
        generateItem(ModItems.Basic_spirit, 9, 21, 36, ItemBlock.getItemFromBlock(Blocks.WOOL), 0, ItemBlock.getItemFromBlock(Blocks.WOOL), 0);
        generateItem(ModItems.Basic_spirit, 9, 37, 44, ItemBlock.getItemFromBlock(Blocks.WOOL), 7, ItemBlock.getItemFromBlock(Blocks.WOOL), 7);
        generateItem(ModItems.Basic_spirit, 9, 45, 52, ItemBlock.getItemFromBlock(Blocks.WOOL), 8, ItemBlock.getItemFromBlock(Blocks.WOOL), 8);
        generateItem(ModItems.Basic_spirit, 9, 53, 60, ItemBlock.getItemFromBlock(Blocks.WOOL), 15, ItemBlock.getItemFromBlock(Blocks.WOOL), 15);
        generateItem(ModItems.Basic_spirit, 9, 61, 64, ItemBlock.getItemFromBlock(Blocks.WOOL), 12, ItemBlock.getItemFromBlock(Blocks.WOOL), 12);
        generateItem(ModItems.Basic_spirit, 9, 65, 68, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 9, 69, 69, ModItems.Sheep_Spawn, 0, ModItems.Sheep_Spawn, 0);

        int max = 100, min = 0;
        int random = (int)(Math.random()*(max-min))+min;

        if(random <= 1)
            generateItem( ModItems.Basic_spirit, 9, 70, 70, ItemBlock.getItemFromBlock(Blocks.WOOL), 6, ItemBlock.getItemFromBlock(Blocks.WOOL), 6);

        //Shulker
        generateItem(ModItems.Basic_spirit, 10, 0, 10, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 10, 11, 11, ModItems.Shulker_Spawn, 0, ModItems.Shulker_Spawn, 0);

        //Silverfish
        generateItem(ModItems.Basic_spirit, 11, 0, 10, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 11, 11, 11, ModItems.Silverfish_Spawn, 0, ModItems.Silverfish_Spawn, 0);

        //Squid

        generateItem(ModItems.Basic_spirit, 12, 0, 3, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 12, 4, 4, ModItems.Squid_Spawn, 0, ModItems.Squid_Spawn, 0);

        //Wolf
        generateItem(ModItems.Basic_spirit, 13, 0, 3, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 13, 4, 4, ModItems.Wolf_Spawn, 0, ModItems.Wolf_Spawn, 0);

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

