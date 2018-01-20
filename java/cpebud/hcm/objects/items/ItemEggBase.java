package cpebud.hcm.objects.items;

import cpebud.hcm.Main;
import cpebud.hcm.entity.EntityEggExplosive;
import cpebud.hcm.init.ItemInit;
import cpebud.hcm.util.interfaces.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public abstract class ItemEggBase extends Item
{
    public ItemEggBase(String name)
    {
    	setUnlocalizedName(name);
    	setRegistryName(name);
    	setCreativeTab(Main.HCMTAB);
    	setMaxStackSize(16);
    	
    	ItemInit.ITEMS.add(this);
    }
    
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	protected abstract void setEggThrown(World worldIn, EntityPlayer playerIn);
	
	
    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!playerIn.capabilities.isCreativeMode)
        {
            itemstack.shrink(1);
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
            setEggThrown(worldIn, playerIn);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}