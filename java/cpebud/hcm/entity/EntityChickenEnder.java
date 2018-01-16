package cpebud.hcm.entity;

import cpebud.hcm.init.ItemInit;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

public class EntityChickenEnder extends EntityChickenBase
{
	public EntityChickenEnder(World worldIn)
	{
		super(worldIn);
		setEgg(ItemInit.EGG_ENDER);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable)
	{
		return new EntityChickenEnder(world);
	}
}
