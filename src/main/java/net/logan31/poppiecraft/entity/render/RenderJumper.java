package net.logan31.poppiecraft.entity.render;

import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.entity.Jumper;
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
public class RenderJumper extends RenderLiving<Jumper> {


    private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/entity/Jumper/Jumper.png");


    public RenderJumper(RenderManager rendermanagerIn)
    {
        super(rendermanagerIn, new ModelZombie(), 0.4f);
    }



    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Jumper entity) {
        return getEntityTextureLocation();
    }

    private ResourceLocation getEntityTextureLocation() {

        return texture;
    }


}
