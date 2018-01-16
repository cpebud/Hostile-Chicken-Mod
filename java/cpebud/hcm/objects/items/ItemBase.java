package cpebud.hcm.objects.items;

import cpebud.hcm.Main;
import cpebud.hcm.init.ItemInit;
import cpebud.hcm.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.HCMTAB);

		ItemInit.ITEMS.add(this);
	}
		
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
