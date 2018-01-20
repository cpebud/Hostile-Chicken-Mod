package cpebud.hcm.entity;

import cpebud.hcm.init.ItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class EntityEggBase extends EntityThrowable
{
    public EntityEggBase(World worldIn)
    {
        super(worldIn);
    }

    public EntityEggBase(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityEggBase(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public static void registerFixesEgg(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "ThrownEgg");
    }
    
    protected abstract void setNewChicken();
    
	private Item EGGS;
	protected Item getEggs() 
	{
	    return EGGS;
	}
    protected void setEggs(Item EGGS)
	{
	    this.EGGS = EGGS;
	}

    /**
     * Handler for {@link World#setEntityState}
     */
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            double d0 = 0.08D;

            for (int i = 0; i < 8; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(getEggs()));
            }
        }
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if (!this.world.isRemote)
        {
            if (this.rand.nextInt(8) == 0)
            {
                int i = 1;

                if (this.rand.nextInt(32) == 0)
                {
                    i = 4;
                }

                for (int j = 0; j < i; ++j)
                {
                    setNewChicken();
                }
            }

            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }

	
}
