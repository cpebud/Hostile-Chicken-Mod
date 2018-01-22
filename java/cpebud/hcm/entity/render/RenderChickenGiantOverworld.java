package cpebud.hcm.entity.render;

import cpebud.hcm.entity.EntityChickenGiantOverworld;
import cpebud.hcm.entity.model.ModelChickenGiantBase;
import cpebud.hcm.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderChickenGiantOverworld extends RenderLiving<EntityChickenGiantOverworld>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/chicken_giantoverworld.png");

    public RenderChickenGiantOverworld(RenderManager manager)
    {
        super(manager, new ModelChickenGiantBase(), 1.2F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityChickenGiantOverworld entity)
    {
        return TEXTURES;
    }
    
    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityChickenGiantOverworld livingBase, float partialTicks)
    {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
}
