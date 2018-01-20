package cpebud.hcm.entity;

import cpebud.hcm.init.ItemInit;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityEggEnder extends EntityEggBase
{
	public EntityEggEnder(World worldIn)
	{
		super(worldIn);
		setEggs(ItemInit.EGG_ENDER);
	}
	
	public EntityEggEnder(World worldIn, EntityLivingBase throwerIn)
	{
		super(worldIn, throwerIn);
	}
	
	public EntityEggEnder(World worldIn, double x, double y, double z)
	{
		super(worldIn, x, y, z);
	}
	
	@Override
	protected void setNewChicken()
	{
		EntityChickenEnder entitychicken = new EntityChickenEnder(this.world);
        entitychicken.setGrowingAge(-24000);
        entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        this.world.spawnEntity(entitychicken);
	}
}
