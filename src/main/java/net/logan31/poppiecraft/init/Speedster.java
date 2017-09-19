package net.logan31.poppiecraft.init;

/**
 * Created by johanjulien on 18/09/2017.
 */


        import net.minecraftforge.fml.relauncher.SideOnly;
        import net.minecraftforge.fml.relauncher.Side;
        import net.minecraftforge.fml.common.registry.EntityRegistry;
        import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
        import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
        import net.minecraftforge.fml.common.event.FMLInitializationEvent;
        import net.minecraftforge.fml.client.registry.RenderingRegistry;

        import net.minecraft.world.biome.Biome;
        import net.minecraft.world.World;
        import net.minecraft.util.math.MathHelper;
        import net.minecraft.util.ResourceLocation;
        import net.minecraft.util.EnumHand;
        import net.minecraft.util.DamageSource;
        import net.minecraft.potion.PotionEffect;
        import net.minecraft.item.ItemStack;
        import net.minecraft.item.Item;
        import net.minecraft.inventory.EntityEquipmentSlot;
        import net.minecraft.init.MobEffects;
        import net.minecraft.init.Items;
        import net.minecraft.init.Blocks;
        import net.minecraft.entity.player.EntityPlayerMP;
        import net.minecraft.entity.player.EntityPlayer;
        import net.minecraft.entity.monster.EntityMob;
        import net.minecraft.entity.effect.EntityLightningBolt;
        import net.minecraft.entity.ai.EntityAIWatchClosest;
        import net.minecraft.entity.ai.EntityAIWander;
        import net.minecraft.entity.ai.EntityAISwimming;
        import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
        import net.minecraft.entity.ai.EntityAILookIdle;
        import net.minecraft.entity.ai.EntityAIHurtByTarget;
        import net.minecraft.entity.SharedMonsterAttributes;
        import net.minecraft.entity.EnumCreatureType;
        import net.minecraft.entity.EntityLivingBase;
        import net.minecraft.entity.Entity;
        import net.minecraft.client.renderer.entity.RenderBiped;
        import net.minecraft.client.model.ModelZombie;
        import net.minecraft.client.Minecraft;

        import java.util.Random;
        import java.util.Iterator;
        import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class Speedster {


    public int mobid = 0;
    public static Object instance;

    public void load(FMLInitializationEvent event) {
    }

    public void generateNether(World world, Random random, int chunkX, int chunkZ) {
    }

    public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
    }

    public int addFuel(ItemStack fuel) {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public void registerRenderers() {
        RenderBiped customRender = new RenderBiped(Minecraft.getMinecraft().getRenderManager(), new ModelZombie(), 0) {
            protected ResourceLocation getEntityTexture(Entity par1Entity) {
                return new ResourceLocation("Speedster.png");
            }
        };
        customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerHeldItem(customRender));
        customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerBipedArmor(customRender) {
            protected void initArmor() {
                this.modelLeggings = new ModelZombie();
                this.modelArmor = new ModelZombie();
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(Speedster.Entityspeedster.class, customRender);

    }

    public void serverLoad(FMLServerStartingEvent event) {
    }

    public void preInit(FMLPreInitializationEvent event) {
        int entityID = MathHelper.getRandomUUID().hashCode();
        mobid = entityID;
        EntityRegistry.registerModEntity(Speedster.Entityspeedster.class, "speedster", entityID, instance, 64, 1, true, (209 << 16)
                + (184 << 8) + 0, (0 << 16) + (153 << 8) + 51);
        EntityRegistry.addSpawn(Speedster.Entityspeedster.class, 20, 3, 30, EnumCreatureType.MONSTER, clean(Biome.REGISTRY));

    }

    public static Biome[] clean(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
        Iterator<Biome> itr = in.iterator();
        ArrayList<Biome> ls = new ArrayList<Biome>();
        while (itr.hasNext()) {
            ls.add(itr.next());
        }
        return ls.toArray(new Biome[ls.size()]);
    }

    public static class Entityspeedster extends EntityMob {
        World world = null;

        public Entityspeedster(World var1) {
            super(var1);
            world = var1;
            experienceValue = 10;
            this.isImmuneToFire = false;
            addRandomArmor();
            setNoAI(!true);

            this.tasks.addTask(10, new EntityAIWander(this, 0.8D));
            this.targetTasks.addTask(9, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, true));
            this.targetTasks.addTask(10, new EntityAIHurtByTarget(this, false));
            this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
            this.targetTasks.addTask(9, new EntityAIHurtByTarget(this, false));
            this.tasks.addTask(7, new EntityAILookIdle(this));
            this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayerMP.class, 6.0F));
            this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
            this.tasks.addTask(4, new EntityAISwimming(this));

        }

        protected void applyEntityAttributes() {
            super.applyEntityAttributes();
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.0D);
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
            if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
                this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(25D);
        }

        protected void addRandomArmor() {


        }

        @Override
        protected Item getDropItem() {
            return new ItemStack(Blocks.SPONGE).getItem();
        }

        @Override
        protected net.minecraft.util.SoundEvent getAmbientSound() {
            return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.zombie.ambient"));
        }

        @Override
        protected net.minecraft.util.SoundEvent getHurtSound() {
            return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.zombie.hurt"));
        }

        @Override
        protected net.minecraft.util.SoundEvent getDeathSound() {
            return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.zombie.death"));
        }

        @Override
        public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
            super.onStruckByLightning(entityLightningBolt);
            int i = (int) this.posX;
            int j = (int) this.posY;
            int k = (int) this.posZ;
            Entity entity = this;

        }

        @Override
        public void fall(float l, float d) {
            super.fall(l, d);
            int i = (int) this.posX;
            int j = (int) this.posY;
            int k = (int) this.posZ;
            super.fall(l, d);
            Entity entity = this;

        }

        @Override
        public void onDeath(DamageSource source) {
            super.onDeath(source);
            int i = (int) this.posX;
            int j = (int) this.posY;
            int k = (int) this.posZ;
            Entity entity = this;

            if (true) {
                if (entity instanceof EntityLivingBase)
                    ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 20, 1));
            }

        }

        @Override
        public boolean processInteract(EntityPlayer entity, EnumHand hand, ItemStack stack) {
            super.processInteract(entity, hand, stack);
            int i = (int) this.posX;
            int j = (int) this.posY;
            int k = (int) this.posZ;

            return true;
        }

        @Override
        protected float getSoundVolume() {
            return 1.0F;
        }

    }

}
