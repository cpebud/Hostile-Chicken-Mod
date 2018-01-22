package cpebud.hcm.util.handlers;

import cpebud.hcm.entity.EntityChickenEnder;
import cpebud.hcm.entity.EntityChickenExplosive;
import cpebud.hcm.entity.EntityChickenFiery;
import cpebud.hcm.entity.EntityChickenGhastly;
import cpebud.hcm.entity.EntityChickenGiantOverworld;
import cpebud.hcm.entity.EntityEggEnder;
import cpebud.hcm.entity.EntityEggExplosive;
import cpebud.hcm.entity.EntityEggFiery;
import cpebud.hcm.entity.EntityEggGhastly;
import cpebud.hcm.entity.render.RenderChickenEnder;
import cpebud.hcm.entity.render.RenderChickenExplosive;
import cpebud.hcm.entity.render.RenderChickenFiery;
import cpebud.hcm.entity.render.RenderChickenGhastly;
import cpebud.hcm.entity.render.RenderChickenGiantOverworld;
import cpebud.hcm.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
{
    public static void registerEntityRenders()
    {
    	RenderingRegistry.registerEntityRenderingHandler(EntityChickenEnder.class, new IRenderFactory<EntityChickenEnder>()
    	{
    		@Override
    		public Render<? super EntityChickenEnder> createRenderFor(RenderManager manager)
    		{
    			return new RenderChickenEnder(manager);
    		}
    	});
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityChickenExplosive.class, new IRenderFactory<EntityChickenExplosive>()
    	{
    		@Override
    		public Render<? super EntityChickenExplosive> createRenderFor(RenderManager manager)
    		{
    			return new RenderChickenExplosive(manager);
    		}
    	});
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityChickenFiery.class, new IRenderFactory<EntityChickenFiery>()
    	{
    		@Override
    		public Render<? super EntityChickenFiery> createRenderFor(RenderManager manager)
    		{
    			return new RenderChickenFiery(manager);
    		}
    	});
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityChickenGhastly.class, new IRenderFactory<EntityChickenGhastly>()
    	{
    		@Override
    		public Render<? super EntityChickenGhastly> createRenderFor(RenderManager manager)
    		{
    			return new RenderChickenGhastly(manager);
    		}
    	});
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityChickenGiantOverworld.class, new IRenderFactory<EntityChickenGiantOverworld>()
    	{
    		@Override
    		public Render<? super EntityChickenGiantOverworld> createRenderFor(RenderManager manager)
    		{
    			return new RenderChickenGiantOverworld(manager);
    		}
    	});
    }
    
    public static void registerEntityItemRenders()
    {
    	RenderingRegistry.registerEntityRenderingHandler(EntityEggEnder.class, new RenderSnowball<EntityEggEnder>(Minecraft.getMinecraft().getRenderManager(), ItemInit.EGG_ENDER, Minecraft.getMinecraft().getRenderItem()));;
    	RenderingRegistry.registerEntityRenderingHandler(EntityEggExplosive.class, new RenderSnowball<EntityEggExplosive>(Minecraft.getMinecraft().getRenderManager(), ItemInit.EGG_EXPLOSIVE, Minecraft.getMinecraft().getRenderItem()));;
    	RenderingRegistry.registerEntityRenderingHandler(EntityEggFiery.class, new RenderSnowball<EntityEggFiery>(Minecraft.getMinecraft().getRenderManager(), ItemInit.EGG_FIERY, Minecraft.getMinecraft().getRenderItem()));;
    	RenderingRegistry.registerEntityRenderingHandler(EntityEggGhastly.class, new RenderSnowball<EntityEggGhastly>(Minecraft.getMinecraft().getRenderManager(), ItemInit.EGG_GHASTLY, Minecraft.getMinecraft().getRenderItem()));;

    }
}
