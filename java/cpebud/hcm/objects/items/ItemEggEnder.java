package cpebud.hcm.objects.items;

import cpebud.hcm.entity.EntityEggEnder;
import cpebud.hcm.util.interfaces.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemEggEnder extends ItemEggBase implements IHasModel
{
	public ItemEggEnder(String name)
	{
		super(name);
	}
	
	@Override
	protected void setEggThrown(World worldIn, EntityPlayer playerIn)
	{
        EntityEggEnder entityegg = new EntityEggEnder(worldIn, playerIn);
        entityegg.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
        worldIn.spawnEntity(entityegg);
	}
}
