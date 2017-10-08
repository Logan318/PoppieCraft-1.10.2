package net.logan31.poppiecraft.entity.render;

import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.entity.Darker;
import net.logan31.poppiecraft.entity.GoldenChicken;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * Created by johanjulien on 26/09/2017.
 */

@SideOnly(Side.CLIENT)
public class RenderGoldenChicken extends RenderLiving<GoldenChicken> {


    private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/entity/Golden_Chicken/Golden_Chicken.png");


    public RenderGoldenChicken(RenderManager rendermanagerIn)
    {
        super(rendermanagerIn, new ModelChicken(), 0.4f);
    }



    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GoldenChicken entity) {
        return getEntityTextureLocation();
    }

    private ResourceLocation getEntityTextureLocation() {

        return texture;
    }


}
