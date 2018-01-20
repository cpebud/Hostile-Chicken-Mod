package cpebud.hcm.objects.items;

import cpebud.hcm.entity.EntityEggGhastly;
import cpebud.hcm.util.interfaces.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemEggGhastly extends ItemEggBase implements IHasModel
{
	public ItemEggGhastly(String name)
	{
		super(name);
	}

	@Override
	protected void setEggThrown(World worldIn, EntityPlayer playerIn)
	{
        EntityEggGhastly entityegg = new EntityEggGhastly(worldIn, playerIn);
        entityegg.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
        worldIn.spawnEntity(entityegg);
	}
}
