package cpebud.hcm.util;

public class Reference
{
	public static final String MODID = "hcm";
	public static final String NAME = "HostileChickenMod";
	public static final String VERSION = "0.1";
	
	public static final String CLIENT = "cpebud.hcm.proxy.ClientProxy";
	public static final String COMMON = "cpebud.hcm.proxy.CommonProxy";
	
	//EntityChicken IDs
	private static int ChickenID = 100;
	public static final int ENTITY_CHICKENBASE = ChickenID;
	public static final int ENTITY_CHICKENENDER = ++ChickenID;
	public static final int ENTITY_CHICKENEXPLOSIVE = ++ChickenID;
	public static final int ENTITY_CHICKENFIERY = ++ChickenID;
	public static final int ENTITY_CHICKENGHASTLY = ++ChickenID;
	public static final int ENTITY_CHICKENGIANTOVERWORLD = ++ChickenID;
	
	//EntityEgg IDs
	private static int EggID = 200;
	public static final int ENTITY_EGGBASE = EggID;
	public static final int ENTITY_EGGENDER = ++EggID;
	public static final int ENTITY_EGGEXPLOSIVE = ++EggID;
	public static final int ENTITY_EGGFIERY = ++EggID;
	public static final int ENTITY_EGGGHASTLY = ++EggID;
}
