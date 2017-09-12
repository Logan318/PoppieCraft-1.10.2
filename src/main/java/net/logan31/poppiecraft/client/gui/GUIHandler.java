package net.logan31.poppiecraft.client.gui;

import net.logan31.poppiecraft.container.ContainerGeneratorBlock;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;



public class GUIHandler implements IGuiHandler {

    public static final int GENERATOR_BLOCK = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GENERATOR_BLOCK) {
            return new ContainerGeneratorBlock(player.inventory, (TileEntityGeneratorBlock) world.getTileEntity(new BlockPos(x, y, z)));
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GENERATOR_BLOCK) {
            return new GUIGeneratorBlock(player.inventory, (TileEntityGeneratorBlock) world.getTileEntity(new BlockPos(x, y, z)));
        }
        return null;
    }
}
