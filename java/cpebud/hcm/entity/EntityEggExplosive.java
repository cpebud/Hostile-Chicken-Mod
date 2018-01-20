package cpebud.hcm.entity;

import cpebud.hcm.init.ItemInit;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.world.World;

public class EntityEggExplosive extends EntityEggBase
{
	public EntityEggExplosive(World worldIn)
	{
		super(worldIn);
		setEggs(ItemInit.EGG_EXPLOSIVE);
	}
	
	public EntityEggExplosive(World worldIn, EntityLivingBase throwerIn)
	{
		super(worldIn, throwerIn);
	}
	
	public EntityEggExplosive(World worldIn, double x, double y, double z)
	{
		super(worldIn, x, y, z);
	}
	
	@Override
	protected void setNewChicken()
	{
		EntityChickenExplosive entitychicken = new EntityChickenExplosive(this.world);
        entitychicken.setGrowingAge(-24000);
        entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        this.world.spawnEntity(entitychicken);
	}
}
