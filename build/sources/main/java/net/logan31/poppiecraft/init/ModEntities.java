package net.logan31.poppiecraft.init;


import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.enchant.EnchantmentSoulStealer;
import net.logan31.poppiecraft.entity.Darker;
import net.logan31.poppiecraft.entity.GoldenChicken;
import net.logan31.poppiecraft.entity.Jumper;
import net.logan31.poppiecraft.entity.render.RenderGoldenChicken;
import net.logan31.poppiecraft.entity.render.RenderSpeedster;
import net.logan31.poppiecraft.entity.render.RenderJumper;
import net.logan31.poppiecraft.entity.render.RenderDarker;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.HorseType;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.logan31.poppiecraft.entity.Speedster;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;

import static net.logan31.poppiecraft.PoppieCraftMod.instance;


/**
 * Created by johanjulien on 26/09/2017.
 */
public class ModEntities {

    private static int mobID = 0;


    public static void RegisterEntities() {
        HorseType donkey = HorseType.DONKEY;

        EntityRegistry.registerModEntity(Speedster.class, "Speedster", mobID++, PoppieCraftMod.instance,60, 1, true, 13744128, '餳');
        EntityRegistry.registerModEntity(Jumper.class, "Jumper", mobID++, PoppieCraftMod.instance,60, 1, true);
        EntityRegistry.registerModEntity(Darker.class, "Darker", mobID++, PoppieCraftMod.instance,60, 1, true);
        EntityRegistry.registerModEntity(GoldenChicken.class, "Golden_Chicken", mobID++, PoppieCraftMod.instance,60, 1, true);
        EntityRegistry.registerEgg( EntitySnowman.class, 60, 60 );





    }

    @SideOnly(Side.CLIENT)
    public static void RegisterEntitiesRenders() {


        RenderingRegistry.registerEntityRenderingHandler(Speedster.class, new RenderSpeedster(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(Jumper.class, new RenderJumper(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(Darker.class, new RenderDarker(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(GoldenChicken.class, new RenderGoldenChicken(Minecraft.getMinecraft().getRenderManager()));

    }
}
