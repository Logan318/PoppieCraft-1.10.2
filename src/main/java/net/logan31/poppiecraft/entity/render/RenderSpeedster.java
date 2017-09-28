package net.logan31.poppiecraft.entity.render;

import net.logan31.poppiecraft.PoppieCraftMod;
import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.entity.Speedster;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by johanjulien on 26/09/2017.
 */

@SideOnly(Side.CLIENT)
public class RenderSpeedster extends RenderLiving<Speedster> {


    private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/entity/Speedster/Speedster.png");


    public RenderSpeedster(RenderManager rendermanagerIn)
    {
        super(rendermanagerIn, new ModelZombie(), 0.7f);
    }

    protected ResourceLocation getEntityTexture(Speedster entity) {
        return getEntityTextureLocation();
    }

    private ResourceLocation getEntityTextureLocation() {

        return texture;
    }


}
