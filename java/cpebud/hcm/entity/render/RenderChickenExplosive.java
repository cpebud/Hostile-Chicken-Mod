package cpebud.hcm.entity.render;

import cpebud.hcm.entity.EntityChickenExplosive;
import cpebud.hcm.entity.model.ModelChickenBase;
import cpebud.hcm.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderChickenExplosive extends RenderLiving<EntityChickenExplosive>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/chicken_explosive.png");

    public RenderChickenExplosive(RenderManager manager)
    {
        super(manager, new ModelChickenBase(), 0.3F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityChickenExplosive entity)
    {
        return TEXTURES;
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityChickenExplosive livingBase, float partialTicks)
    {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
    
    
    //Creeper Swell and Explosion
    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityChickenExplosive entitylivingbaseIn, float partialTickTime)
    {
        float f = entitylivingbaseIn.getChickenFlashIntensity(partialTickTime);
        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        GlStateManager.scale(f2, f3, f2);
    }

    /**
     * Gets an RGBA int color multiplier to apply.
     */
    protected int getColorMultiplier(EntityChickenExplosive entitylivingbaseIn, float lightBrightness, float partialTickTime)
    {
        float f = entitylivingbaseIn.getChickenFlashIntensity(partialTickTime);

        if ((int)(f * 10.0F) % 2 == 0)
        {
            return 0;
        }
        else
        {
            int i = (int)(f * 0.2F * 255.0F);
            i = MathHelper.clamp(i, 0, 255);
            return i << 24 | 822083583;
        }
    }
}
