package net.logan31.poppiecraft.entity;

import com.google.common.collect.Maps;
import net.logan31.poppiecraft.Utils.References;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.util.Calendar;
import java.util.Map;


public class GoldenChicken extends EntityMob {



    public GoldenChicken(World worldIn) {

        super(worldIn);
        this.isImmuneToFire = true;
        this.setSize(0.4F, 0.7F);
        this.canDamagePlayer();
        this.attackEntityAsMob(this);
        EntityPlayer attackingPlayer = this.attackingPlayer;


    }



    protected static final IAttribute SPAWN_REINFORCEMENTS_CHANCE = (new RangedAttribute((IAttribute)null, "zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).setDescription("Spawn Reinforcements Chance");
    public boolean isBurning()
    {
        return false;
    }


    @Override
    public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
        return super.canAttackClass(cls);
    }



    protected void initEntityAI()
    {

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(10, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }



    protected boolean canDamagePlayer()
    {
        return true;
    }


    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(27.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.34D);

    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(References.MODID, "GoldenChickenLoot");
    }


    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);

        if (flag) {
            float f = this.worldObj.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();

            if (this.getHeldItemMainhand() == null) {
                if (this.isBurning() && this.rand.nextFloat() < f * 0.3F) {
                    entityIn.setFire(2 * (int) f);
                }

                if (entityIn instanceof EntityLivingBase) {
                    ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 200, 1));
                }
            }
        }

        return flag;

    }

        public boolean getCanSpawnHere()
        {
            return this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.getCanSpawnHere();
        }


        public float getBlockPathWeight(BlockPos pos)
        {
            return 0.5F - this.worldObj.getLightBrightness(pos);
        }


        public void onLivingUpdate()
        {
            if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild())
            {
                float f = this.getBrightness(1.0F);
                BlockPos blockpos = this.getRidingEntity() instanceof EntityBoat ? (new BlockPos(this.posX, (double)Math.round(this.posY), this.posZ)).up() : new BlockPos(this.posX, (double)Math.round(this.posY), this.posZ);

                if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canSeeSky(blockpos))
                {
                    boolean flag = true;
                    ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.HEAD);

                    if (itemstack != null)
                    {
                        if (itemstack.isItemStackDamageable())
                        {
                            itemstack.setItemDamage(itemstack.getItemDamage() + this.rand.nextInt(2));

                            if (itemstack.getItemDamage() >= itemstack.getMaxDamage())
                            {
                                this.renderBrokenItemStack(itemstack);
                                this.setItemStackToSlot(EntityEquipmentSlot.HEAD, (ItemStack)null);
                            }
                        }

                        flag = false;
                    }

                    if (flag)
                    {
                        this.setFire(8);
                    }
                }
            }

            super.onLivingUpdate();
        }


        private static final Map<Class<?>, SpawnPlacementType> ENTITY_PLACEMENTS = Maps.<Class<?>, EntityLiving.SpawnPlacementType>newHashMap();

        public static EntityLiving.SpawnPlacementType getPlacementForEntity(Class<?> entityClass) {
        return (EntityLiving.SpawnPlacementType) ENTITY_PLACEMENTS.get(entityClass);
    }

        public static void setPlacementType(Class<? extends Entity> entityClass, EntityLiving.SpawnPlacementType placementType) {
        if (!ENTITY_PLACEMENTS.containsKey(entityClass))
            ENTITY_PLACEMENTS.put(entityClass, placementType);
    }

        static {
        ENTITY_PLACEMENTS.put(GoldenChicken.class, EntityLiving.SpawnPlacementType.ON_GROUND);

    }


    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        float f = difficulty.getClampedAdditionalDifficulty();
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
        this.removeActivePotionEffect(Potion.getPotionById(18));

        if (livingdata == null)
        {
            livingdata = new GoldenChicken.GroupData(this.worldObj.rand.nextFloat() < net.minecraftforge.common.ForgeModContainer.zombieBabyChance, this.worldObj.rand.nextFloat() < 0.05F);
        }

        if (livingdata instanceof GoldenChicken.GroupData)
        {
            GoldenChicken.GroupData entityzombie$groupdata = (GoldenChicken.GroupData)livingdata;
            boolean flag = false;
            Biome biome = this.worldObj.getBiome(new BlockPos(this));



        }



        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);


        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806D, 0));
        double d0 = this.rand.nextDouble() * 1.5D * (double)f;

        if (d0 > 1.0D)
        {
            this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Random zombie-spawn bonus", d0, 2));
        }

        if (this.rand.nextFloat() < f * 0.05F)
        {
            this.getEntityAttribute(SPAWN_REINFORCEMENTS_CHANCE).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 0.25D + 0.5D, 0));
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0D + 1.0D, 2));

        }

        return livingdata;
    }

    class GroupData implements IEntityLivingData
    {
        public boolean isChild;
        public boolean isVillager;

        private GroupData(boolean isBaby, boolean isVillagerZombie)
        {
            this.isChild = isBaby;
            this.isVillager = isVillagerZombie;
        }
    }
    }

