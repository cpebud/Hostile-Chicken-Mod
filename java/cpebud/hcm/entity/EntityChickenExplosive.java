package cpebud.hcm.entity;

import cpebud.hcm.init.ItemInit;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

public class EntityChickenExplosive extends EntityChickenBase
{
	public EntityChickenExplosive(World worldIn)
	{
		super(worldIn);
		setEgg(ItemInit.EGG_EXPLOSIVE);
	}
		
	@Override
	public EntityAgeable createChild(EntityAgeable ageable)
	{
		return new EntityChickenExplosive(world);
	}
}
