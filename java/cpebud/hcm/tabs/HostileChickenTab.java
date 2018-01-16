package cpebud.hcm.tabs;

import cpebud.hcm.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class HostileChickenTab extends CreativeTabs
{
	public HostileChickenTab(String label)
	{
		super("HCMTAB");
	    this.setBackgroundImageName("hostilechickentab.png");
	}
	
	public ItemStack getTabIconItem() { return new ItemStack(ItemInit.EGG_EXPLOSIVE); }

}
