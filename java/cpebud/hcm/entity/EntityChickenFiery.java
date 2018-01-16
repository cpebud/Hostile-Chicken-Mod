package cpebud.hcm.entity;

import cpebud.hcm.init.ItemInit;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

public class EntityChickenFiery extends EntityChickenBase
{
	public EntityChickenFiery(World worldIn)
	{
		super(worldIn);
		setEgg(ItemInit.EGG_FIERY);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable)
	{
		return new EntityChickenFiery(world);
	}
}
