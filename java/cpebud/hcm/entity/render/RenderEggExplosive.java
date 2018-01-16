package cpebud.hcm.entity.render;

import cpebud.hcm.entity.EntityEggExplosive;
import cpebud.hcm.init.ItemInit;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;

public class RenderEggExplosive extends RenderSnowball<EntityEggExplosive>
{
	public RenderEggExplosive(RenderManager renderManagerIn, RenderItem itemRendererIn)
	{
		super(renderManagerIn, ItemInit.EGG_EXPLOSIVE, itemRendererIn);
	}

}
