package cpebud.hcm.entity;

import cpebud.hcm.init.ItemInit;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityEggFiery extends EntityEggBase
{
	public EntityEggFiery(World worldIn)
	{
		super(worldIn);
		setEggs(ItemInit.EGG_FIERY);
	}
	
	public EntityEggFiery(World worldIn, EntityLivingBase throwerIn)
	{
		super(worldIn, throwerIn);
	}
	
	public EntityEggFiery(World worldIn, double x, double y, double z)
	{
		super(worldIn, x, y, z);
	}
	
	@Override
	protected void setNewChicken()
	{
		EntityChickenFiery entitychicken = new EntityChickenFiery(this.world);
        entitychicken.setGrowingAge(-24000);
        entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        this.world.spawnEntity(entitychicken);
	}
}
