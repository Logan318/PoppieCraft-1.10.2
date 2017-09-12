package net.logan31.poppiecraft.entity;

import javax.annotation.Nullable;

import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.ZombieType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import java.util.UUID;

public class Speedster extends EntityZombie
{

        private static final UUID ATTACK_SPEED_BOOST_MODIFIER_UUID = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
        private static final AttributeModifier ATTACK_SPEED_BOOST_MODIFIER = (new AttributeModifier(ATTACK_SPEED_BOOST_MODIFIER_UUID, "Attacking speed boost", 0.05D, 0)).setSaved(false);
        /** Above zero if this PigZombie is Angry. */
        private int angerLevel;
        /** A random delay until this PigZombie next makes a sound. */
        private int randomSoundDelay;
        private UUID angerTargetUUID;

        public Speedster(World worldIn)
        {
            super(worldIn);
            this.isImmuneToFire = true;
        }

        public void setRevengeTarget(@Nullable EntityLivingBase livingBase)
        {
            super.setRevengeTarget(livingBase);

            if (livingBase != null)
            {
                this.angerTargetUUID = livingBase.getUniqueID();
            }
        }


        protected void applyEntityAttributes()
        {
            super.applyEntityAttributes();
            this.getEntityAttribute(SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(0.0D);
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
            this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
        }

        /**
         * Called to update the entity's position/logic.
         */
        public void onUpdate()
        {
            super.onUpdate();
        }

        protected void updateAITasks()
        {
            IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);

            if (this.isAngry())
            {


                --this.angerLevel;
            }
            else if (iattributeinstance.hasModifier(ATTACK_SPEED_BOOST_MODIFIER))
            {
                iattributeinstance.removeModifier(ATTACK_SPEED_BOOST_MODIFIER);
            }


            if (this.angerLevel > 0 && this.angerTargetUUID != null && this.getAITarget() == null)
            {
                EntityPlayer entityplayer = this.worldObj.getPlayerEntityByUUID(this.angerTargetUUID);
                this.setRevengeTarget(entityplayer);
                this.attackingPlayer = entityplayer;
                this.recentlyHit = this.getRevengeTimer();
            }

            super.updateAITasks();
        }

        /**
         * Checks if the entity's current position is a valid location to spawn this entity.
         */
        public boolean getCanSpawnHere()
        {
            return this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL;
        }

        /**
         * Checks that the entity is not colliding with any blocks / liquids
         */
        public boolean isNotColliding()
        {
            return this.worldObj.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.worldObj.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.worldObj.containsAnyLiquid(this.getEntityBoundingBox());
        }

        public static void registerFixesPigZombie(DataFixer fixer)
        {
            EntityLiving.registerFixesMob(fixer, "Speedster");
        }

        /**
         * (abstract) Protected helper method to write subclass entity data to NBT.
         */
        public void writeEntityToNBT(NBTTagCompound compound)
        {
            super.writeEntityToNBT(compound);
            compound.setShort("Anger", (short)this.angerLevel);

            if (this.angerTargetUUID != null)
            {
                compound.setString("HurtBy", this.angerTargetUUID.toString());
            }
            else
            {
                compound.setString("HurtBy", "");
            }
        }

        /**
         * (abstract) Protected helper method to read subclass entity data from NBT.
         */
        public void readEntityFromNBT(NBTTagCompound compound)
        {
            super.readEntityFromNBT(compound);
            this.angerLevel = compound.getShort("Anger");
            String s = compound.getString("HurtBy");

            if (!s.isEmpty())
            {
                this.angerTargetUUID = UUID.fromString(s);
                EntityPlayer entityplayer = this.worldObj.getPlayerEntityByUUID(this.angerTargetUUID);
                this.setRevengeTarget(entityplayer);

                if (entityplayer != null)
                {
                    this.attackingPlayer = entityplayer;
                    this.recentlyHit = this.getRevengeTimer();
                }
            }
        }

        /**
         * Called when the entity is attacked.
         */
        public boolean attackEntityFrom(DamageSource source, float amount)
        {
            if (this.isEntityInvulnerable(source))
            {
                return false;
            }
            else
            {
                Entity entity = source.getEntity();

                if (entity instanceof EntityPlayer)
                {
                    this.becomeAngryAt(entity);
                }

                return super.attackEntityFrom(source, amount);
            }
        }

        /**
         * Causes this PigZombie to become angry at the supplied Entity (which will be a player).
         */
        private void becomeAngryAt(Entity p_70835_1_)
        {
            this.angerLevel = 400 + this.rand.nextInt(400);
            this.randomSoundDelay = this.rand.nextInt(40);

            if (p_70835_1_ instanceof EntityLivingBase)
            {
                this.setRevengeTarget((EntityLivingBase)p_70835_1_);
            }
        }

        public boolean isAngry()
        {
            return this.angerLevel > 0;
        }

        protected SoundEvent getAmbientSound()
        {
            return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
        }

        protected SoundEvent getHurtSound()
        {
            return SoundEvents.ENTITY_ZOMBIE_HURT;
        }

        protected SoundEvent getDeathSound()
        {
            return SoundEvents.ENTITY_ZOMBIE_DEATH;
        }

        @Nullable
        protected ResourceLocation getLootTable()
        {
            return LootTableList.ENTITIES_ZOMBIE;
        }

        public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack)
        {
            return false;
        }

        /**
         * Gives armor or weapon for entity based on given DifficultyInstance
         */
        protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
        {
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ModItems.Lapis_sword));
        }

        /**
         * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
         * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
         */
        @Nullable
        public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
        {
            super.onInitialSpawn(difficulty, livingdata);
            this.setZombieType(ZombieType.NORMAL);
            return livingdata;
        }


    }