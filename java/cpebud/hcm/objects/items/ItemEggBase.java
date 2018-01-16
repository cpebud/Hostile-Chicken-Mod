package cpebud.hcm.objects.items;

import cpebud.hcm.Main;
import cpebud.hcm.init.ItemInit;
import cpebud.hcm.util.IHasModel;
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

public class ItemEggBase extends Item
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
}