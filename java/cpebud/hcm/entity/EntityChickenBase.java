package cpebud.hcm.entity;

import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import cpebud.hcm.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public abstract class EntityChickenBase extends EntityHostileAnimal
{
    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
    public float wingRotation;
    public float destPos;
    public float oFlapSpeed;
    public float oFlap;
    public float wingRotDelta = 1.0F;
    /** The time until the next egg is spawned. */
    public int timeUntilNextEgg;
	
    private Item EGG;
	protected Item getEgg() 
	{
	    return EGG;
	}
    protected void setEgg(Item EGG)
	{
	    this.EGG = EGG;
	}

    public EntityChickenBase(World worldIn)
    {
        super(worldIn);
        this.setSize(0.4F, 0.7F);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        this.setPathPriority(PathNodeType.WATER, 0.0F);
    }

    public float getEyeHeight()
    {
        return this.height;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
    	
        super.onLivingUpdate();
        this.oFlap = this.wingRotation;
        this.oFlapSpeed = this.destPos;
        this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);
        this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);

        if (!this.onGround && this.wingRotDelta < 1.0F)
        {
            this.wingRotDelta = 1.0F;
        }

        this.wingRotDelta = (float)((double)this.wingRotDelta * 0.9D);

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }

        this.wingRotation += this.wingRotDelta * 2.0F;

        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextEgg <= 0)
        {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(getEgg(), 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
    }

    public void fall(float distance, float damageMultiplier)
    {
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableList.ENTITIES_CHICKEN;
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack stack)
    {
        return TEMPTATION_ITEMS.contains(stack.getItem());
    }
   
    public static void registerFixesChicken(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityChicken.class);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);

        if (compound.hasKey("EggLayTime"))
        {
            this.timeUntilNextEgg = compound.getInteger("EggLayTime");
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("EggLayTime", this.timeUntilNextEgg);
    }

    public void updatePassenger(Entity passenger)
    {
        super.updatePassenger(passenger);
        float f = MathHelper.sin(this.renderYawOffset * 0.017453292F);
        float f1 = MathHelper.cos(this.renderYawOffset * 0.017453292F);
        float f2 = 0.1F;
        float f3 = 0.0F;
        passenger.setPosition(this.posX + (double)(0.1F * f), this.posY + (double)(this.height * 0.5F) + passenger.getYOffset() + 0.0D, this.posZ - (double)(0.1F * f1));

        if (passenger instanceof EntityLivingBase)
        {
            ((EntityLivingBase)passenger).renderYawOffset = this.renderYawOffset;
        }
    }
}