package cpebud.hcm.entity;

import cpebud.hcm.init.ItemInit;
import net.minecraft.entity.EntityLivingBase;
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
}
