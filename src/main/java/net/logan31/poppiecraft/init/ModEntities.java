package net.logan31.poppiecraft.init;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.entity.render.RenderSpeedster;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.logan31.poppiecraft.entity.Speedster;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;


/**
 * Created by johanjulien on 26/09/2017.
 */
public class ModEntities {

    private static int mobID = 0;

    public static void RegisterEntities() {

        EntityRegistry.registerModEntity(Speedster.class, "Speedster", mobID++, PoppieCraftMod.instance,60, 1, true);


    }

    @SideOnly(Side.CLIENT)
    public static void RegisterEntitiesRenders() {

        RenderingRegistry.registerEntityRenderingHandler(Speedster.class, new RenderSpeedster(Minecraft.getMinecraft().getRenderManager()));

    }
}
