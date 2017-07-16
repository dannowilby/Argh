package wilby.argh;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wilby.argh.common.ArghEvents;
import wilby.argh.common.ArghGuiHandler;
import wilby.argh.common.CommonProxy;
import wilby.argh.common.Config;
import wilby.argh.multiblock.ArghMultiblock;
import wilby.argh.multiblock.smeltery.TileEntitySmeltery;

@Mod(modid = Argh.MODID, version = Argh.VERSION, name = Argh.NAME)

public class Argh 
{
	public static final String MODID = "argh";
	public static final String VERSION = "3";
	public static final String NAME = "Argh-mod 3";
	    
	@SidedProxy(clientSide = "wilby.argh.client.ClientProxy", serverSide = "wilby.argh.common.CommonProxy")
	public static CommonProxy proxy = new CommonProxy();
	    
	@Instance("argh")
	public static Argh argh = new Argh();

	public static Logger modlogger;
	
	private static Config config;
	    
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		proxy.preInit(e);
		
		config = new Config(e.getModConfigurationDirectory());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		proxy.init(e);
		
		GameRegistry.registerTileEntity(TileEntitySmeltery.class, "smeltery");
		ArghMultiblock.init();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(Argh.argh, new ArghGuiHandler());
		
		MinecraftForge.EVENT_BUS.register(new ArghEvents());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit(e);
		
	}
	
	public static Config getConfig()
	{
		return config;
	}
	
}
