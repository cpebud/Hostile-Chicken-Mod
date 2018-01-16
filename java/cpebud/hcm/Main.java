package cpebud.hcm;

import cpebud.hcm.proxy.CommonProxy;
import cpebud.hcm.tabs.HostileChickenTab;
import cpebud.hcm.util.Reference;
import cpebud.hcm.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main
{
    @Instance
    public static Main instance;
    
    public static final CreativeTabs HCMTAB = new HostileChickenTab("HCMTAB");
    
    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;
    
    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) { RegistryHandler.preInitRegistries(); }
    
    @EventHandler
    public static void init(FMLInitializationEvent event) {}
    
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {}
}
