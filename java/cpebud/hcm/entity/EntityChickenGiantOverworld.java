package cpebud.hcm.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

public class EntityChickenGiantOverworld extends EntityChickenGiantBase
{
	public EntityChickenGiantOverworld(World worldIn)
	{
		super(worldIn);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable)
	{
		return null;
	}	
}
