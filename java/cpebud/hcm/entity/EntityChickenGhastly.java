package cpebud.hcm.entity;

import cpebud.hcm.init.ItemInit;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

public class EntityChickenGhastly extends EntityChickenBase
{
	public EntityChickenGhastly(World worldIn)
	{
		super(worldIn);
		setEgg(ItemInit.EGG_GHASTLY);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable)
	{
		return new EntityChickenGhastly(world);
	}
}
