package net.logan31.poppiecraft.client.gui;

import net.logan31.poppiecraft.container.ContainerGeneratorBlockAdvanced;
import net.logan31.poppiecraft.container.ContainerGeneratorBlockBasic;
import net.logan31.poppiecraft.container.ContainerGeneratorBlockUltimate;
import net.logan31.poppiecraft.container.ContainerMelter;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockAdvanced;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockBasic;
import net.logan31.poppiecraft.tileentity.TileEntityGeneratorBlockUltimate;
import net.logan31.poppiecraft.tileentity.TileEntityMelter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;



public class GUIHandler implements IGuiHandler {

    public static final int GENERATOR_BLOCK_BASIC = 0;
    public static final int GENERATOR_BLOCK_ADVANCED = 1;
    public static final int GENERATOR_BLOCK_ULTIMATE = 2;
    public static final int MELTER = 3;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        switch(ID) {
            case GENERATOR_BLOCK_BASIC:
            return new ContainerGeneratorBlockBasic(player.inventory, (TileEntityGeneratorBlockBasic) world.getTileEntity(new BlockPos(x, y, z)));


            case GENERATOR_BLOCK_ADVANCED:
            return new ContainerGeneratorBlockAdvanced(player.inventory, (TileEntityGeneratorBlockAdvanced) world.getTileEntity(new BlockPos(x, y, z)));

            case GENERATOR_BLOCK_ULTIMATE:
                return new ContainerGeneratorBlockUltimate(player.inventory, (TileEntityGeneratorBlockUltimate) world.getTileEntity(new BlockPos(x, y, z)));

            case MELTER:
                return new ContainerMelter(player.inventory, (TileEntityMelter) world.getTileEntity(new BlockPos(x, y, z)));

        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GENERATOR_BLOCK_BASIC:
                return new GUIGeneratorBlockBasic( player.inventory, (TileEntityGeneratorBlockBasic) world.getTileEntity( new BlockPos( x, y, z ) ) );

            case GENERATOR_BLOCK_ADVANCED:
                return new GUIGeneratorBlockAdvanced( player.inventory, (TileEntityGeneratorBlockAdvanced) world.getTileEntity( new BlockPos( x, y, z ) ) );

            case GENERATOR_BLOCK_ULTIMATE:
                return new GUIGeneratorBlockUltimate( player.inventory, (TileEntityGeneratorBlockUltimate) world.getTileEntity( new BlockPos( x, y, z ) ) );

            case MELTER:
                return new GUIMelter( player.inventory, (TileEntityMelter) world.getTileEntity( new BlockPos( x, y, z ) ) );


        }
        return null;
    }
}
