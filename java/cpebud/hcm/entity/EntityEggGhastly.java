package cpebud.hcm.entity;

import cpebud.hcm.init.ItemInit;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityEggGhastly extends EntityEggBase
{
	public EntityEggGhastly(World worldIn)
	{
		super(worldIn);
		setEggs(ItemInit.EGG_GHASTLY);
	}
	
	public EntityEggGhastly(World worldIn, EntityLivingBase throwerIn)
	{
		super(worldIn, throwerIn);
	}
	
	public EntityEggGhastly(World worldIn, double x, double y, double z)
	{
		super(worldIn, x, y, z);
	}
	
	@Override
	protected void setNewChicken()
	{
		EntityChickenGhastly entitychicken = new EntityChickenGhastly(this.world);
        entitychicken.setGrowingAge(-24000);
        entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        this.world.spawnEntity(entitychicken);
	}
}
