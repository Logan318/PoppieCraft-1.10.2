package net.logan31.poppiecraft.Proxy;

import net.logan31.poppiecraft.PoppieCraftMod;


import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.client.gui.GUIHandler;
import net.logan31.poppiecraft.init.*;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.net.NetworkInterface;

/**
 * Created by johanjulien on 28/06/2017.
 */

public class ClientProxy extends CommonProxy {


    @Override
    public void preInit() {
        super.preInit();
        ModBlocks.registerRenders();
        ModItems.registerRenders();
        ModArmor.registerRenders();


    }

    @Override
    public void init() {

        super.init();



    }

    @Override
    public void registerModelBakeryStuff() {
        ModelBakery.registerItemVariants(ModItems.Loot_upgrade, new ResourceLocation(References.MODID, "Loot_upgrade_basic"), new ResourceLocation(References.MODID, "Loot_upgrade_advanced"), new ResourceLocation(References.MODID, "Loot_upgrade_ultimate"));
        ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.Generator_block), new ResourceLocation(References.MODID, "Generator_block_basic"), new ResourceLocation(References.MODID, "Generator_block_advanced"), new ResourceLocation(References.MODID, "Generator_block_ultimate "));
    }

}




