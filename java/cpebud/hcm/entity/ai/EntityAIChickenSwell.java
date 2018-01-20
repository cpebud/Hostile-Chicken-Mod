package cpebud.hcm.entity.ai;

import cpebud.hcm.entity.EntityChickenExplosive;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityCreeper;

public class EntityAIChickenSwell extends EntityAIBase
{
	/** The chicken that is swelling. */
    EntityChickenExplosive swellingChicken;
    /** The creeper's attack target. This is used for the changing of the chicken's state. */
    EntityLivingBase chickenAttackTarget;

    public EntityAIChickenSwell(EntityChickenExplosive entitychickenIn)
    {
        this.swellingChicken = entitychickenIn;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.swellingChicken.getAttackTarget();
        return this.swellingChicken.getChickenState() > 0 || entitylivingbase != null && this.swellingChicken.getDistanceSq(entitylivingbase) < 9.0D;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.swellingChicken.getNavigator().clearPath();
        this.chickenAttackTarget = this.swellingChicken.getAttackTarget();
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
        this.chickenAttackTarget = null;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
        if (this.chickenAttackTarget == null)
        {
            this.swellingChicken.setChickenState(-1);
        }
        else if (this.swellingChicken.getDistanceSq(this.chickenAttackTarget) > 49.0D)
        {
            this.swellingChicken.setChickenState(-1);
        }
        else if (!this.swellingChicken.getEntitySenses().canSee(this.chickenAttackTarget))
        {
            this.swellingChicken.setChickenState(-1);
        }
        else
        {
            this.swellingChicken.setChickenState(1);
        }
    }
}
