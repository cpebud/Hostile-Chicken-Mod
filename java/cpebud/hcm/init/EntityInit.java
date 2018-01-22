package cpebud.hcm.init;

import cpebud.hcm.Main;
import cpebud.hcm.entity.EntityChickenEnder;
import cpebud.hcm.entity.EntityChickenExplosive;
import cpebud.hcm.entity.EntityChickenFiery;
import cpebud.hcm.entity.EntityChickenGhastly;
import cpebud.hcm.entity.EntityChickenGiantOverworld;
import cpebud.hcm.entity.EntityEggEnder;
import cpebud.hcm.entity.EntityEggExplosive;
import cpebud.hcm.entity.EntityEggFiery;
import cpebud.hcm.entity.EntityEggGhastly;
import cpebud.hcm.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit
{
	public static void registerEntities()
	{
		//Registering Entities
		registerEntity("chicken_ender", EntityChickenEnder.class, Reference.ENTITY_CHICKENENDER, 64, 1447446, 13369594);
		registerEntity("chicken_explosive", EntityChickenExplosive.class, Reference.ENTITY_CHICKENEXPLOSIVE, 64, 1747737, 7500402);
		registerEntity("chicken_fiery", EntityChickenFiery.class, Reference.ENTITY_CHICKENFIERY, 64, 16776759, 12874776);
		registerEntity("chicken_ghastly", EntityChickenGhastly.class, Reference.ENTITY_CHICKENGHASTLY, 64, 15790320, 5658198);
		registerEntity("chicken_giantoverworld", EntityChickenGiantOverworld.class, Reference.ENTITY_CHICKENGIANTOVERWORLD, 64, 13027014, 16711680);
		
		//Registering ItemEntities
		registerEntityItem("entityegg_ender", EntityEggEnder.class, Reference.ENTITY_EGGENDER);
		registerEntityItem("entityegg_explosive", EntityEggExplosive.class, Reference.ENTITY_EGGEXPLOSIVE);
		registerEntityItem("entityegg_fiery", EntityEggFiery.class, Reference.ENTITY_EGGFIERY);
		registerEntityItem("entityegg_ghastly", EntityEggGhastly.class, Reference.ENTITY_EGGGHASTLY);

	}
	
	private static void registerEntityItem(String name, Class<? extends Entity> entity, int id)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, 64, 1, true);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
}
