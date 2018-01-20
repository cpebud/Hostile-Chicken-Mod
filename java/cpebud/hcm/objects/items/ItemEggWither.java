package cpebud.hcm.objects.items;

import cpebud.hcm.util.interfaces.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemEggWither extends ItemEggBase implements IHasModel
{
	public ItemEggWither(String name)
	{
		super(name);
	}

	@Override
	protected void setEggThrown(World worldIn, EntityPlayer playerIn)
	{
		
	}
}
