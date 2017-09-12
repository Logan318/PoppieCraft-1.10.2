package net.logan31.poppiecraft.tileentity;

import net.logan31.poppiecraft.Utils.Utils;
import net.logan31.poppiecraft.blocks.GeneratorBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;


/**
 * Created by johanjulien on 29/07/2017.
 */
public class TileEntityGeneratorBlock extends TileEntity implements ITickable, ICapabilityProvider{

    public EnumFacing facing;

    private ItemStackHandler handler;
    private int cooldown;


    public TileEntityGeneratorBlock() {
        this.cooldown = 0;
        this.handler = new ItemStackHandler(9);

    }



    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        this.cooldown = nbt.getInteger("Cooldown");
        this.handler.deserializeNBT(nbt.getCompoundTag("ItemStackHandler"));
        this.facing = EnumFacing.byName(nbt.getString("facing"));
        super.readFromNBT(nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

        if(this.facing == null) {
            nbt.setString("facing", this.facing.getName2());
            nbt.setInteger("Cooldown", this.cooldown);
            nbt.setTag("ItemStackHandler", this.handler.serializeNBT());

        }
        return super.writeToNBT(nbt);
    }

    @Override
    public void update() {
        if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            if(this.facing == null) {
                this.facing = this.worldObj.getBlockState(pos).getValue(GeneratorBlock.FACING);
                this.worldObj.setBlockState(pos, worldObj.getBlockState(pos).withProperty(GeneratorBlock.FACING, this.facing), 2);
                Utils.getLogger().info("facing: " + this.facing);
            }
        }
        this.cooldown++;
        this.cooldown %= 100;
        Utils.getLogger().info("Cooldown: " + this.cooldown);

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


}
