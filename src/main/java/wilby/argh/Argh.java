package wilby.argh;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
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
import wilby.argh.common.ArghTileEntity;
import wilby.argh.common.CommonProxy;
import wilby.argh.multiblock.MultiblockMiner;
import wilby.argh.multiblock.MultiblockSmeltery;
import wilby.argh.multiblock.tileentity.TileEntityMiner;
import wilby.argh.multiblock.tileentity.TileEntityMultiblockBase;
import wilby.argh.multiblock.tileentity.TileEntitySmeltery;
import wilby.argh.util.ArghLoader;
import wilby.argh.util.ArghLogger;

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
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		ArghLogger.setLogger(e.getModLog());
		ArghLoader.setLoaderConfigurationDirectory(e.getModConfigurationDirectory());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		ArghLogger.log("Initialising Arghmod-3...");
		
		ArghTileEntity.init();
		
		ClientRegistry.registerKeyBinding(new ArghEvents().k);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(Argh.argh, new ArghGuiHandler());
		MinecraftForge.EVENT_BUS.register(new ArghEvents());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		ArghLogger.log("Finished loading Arghmod-3...");
		ArghLogger.log("Prepare for Greatness!");
	}
	
}
