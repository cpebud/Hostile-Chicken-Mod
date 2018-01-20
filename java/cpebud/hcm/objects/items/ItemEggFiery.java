package cpebud.hcm.objects.items;

import cpebud.hcm.entity.EntityEggFiery;
import cpebud.hcm.util.interfaces.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemEggFiery extends ItemEggBase implements IHasModel
{
	public ItemEggFiery(String name)
	{
		super(name);
	}
	
	@Override
	protected void setEggThrown(World worldIn, EntityPlayer playerIn)
	{
        EntityEggFiery entityegg = new EntityEggFiery(worldIn, playerIn);
        entityegg.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
        worldIn.spawnEntity(entityegg);
	}
}
