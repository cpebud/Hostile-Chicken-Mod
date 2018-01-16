package cpebud.hcm.objects.items;

import cpebud.hcm.entity.EntityEggExplosive;
import cpebud.hcm.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemEggExplosive extends ItemEggBase implements IHasModel
{
	public ItemEggExplosive(String name)
	{
		super(name);
	}
	
	@Override
	public void setEggThrown(World worldIn, EntityPlayer playerIn)
	{
        EntityEggExplosive entityegg = new EntityEggExplosive(worldIn, playerIn);
        entityegg.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
        worldIn.spawnEntity(entityegg);
	}
}
