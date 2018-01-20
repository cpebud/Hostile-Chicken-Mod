package cpebud.hcm.init;

import java.util.ArrayList;
import java.util.List;

import cpebud.hcm.objects.items.ItemEggBase;
import cpebud.hcm.objects.items.ItemEggEnder;
import cpebud.hcm.objects.items.ItemEggExplosive;
import cpebud.hcm.objects.items.ItemEggFiery;
import cpebud.hcm.objects.items.ItemEggGhastly;
import cpebud.hcm.objects.items.ItemEggPoison;
import cpebud.hcm.objects.items.ItemEggSkeleton;
import cpebud.hcm.objects.items.ItemEggUndead;
import cpebud.hcm.objects.items.ItemEggWither;
import net.minecraft.item.Item;

public class ItemInit
{
	//Items
    public static final List<Item> ITEMS = new ArrayList<Item>();
    
    //Eggs
    public static final Item EGG_ENDER = new ItemEggEnder("egg_ender");
    public static final Item EGG_EXPLOSIVE = new ItemEggExplosive("egg_explosive");
    public static final Item EGG_FIERY = new ItemEggFiery("egg_fiery");
    public static final Item EGG_GHASTLY = new ItemEggGhastly("egg_ghastly");
    public static final Item EGG_POISON = new ItemEggPoison("egg_poison");
    public static final Item EGG_SKELETON = new ItemEggSkeleton("egg_skeleton");
    public static final Item EGG_UNDEAD = new ItemEggUndead("egg_undead");
    public static final Item EGG_WITHER = new ItemEggWither("egg_wither");

}
