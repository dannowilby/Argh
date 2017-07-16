package wilby.argh.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wilby.argh.multiblock.ArghMultiblock;
import wilby.argh.multiblock.smeltery.TileEntitySmeltery;

public class CommonProxy
{
	
	public static Map<String, ArghMultiblock> multiblocks = new HashMap<String, ArghMultiblock>();
	
	public static Logger log;
	
	public void registerEntityRenderers() 
	{
	}
	public void registerItemRenderers() 
	{
	}
	
	public void preInit(FMLPreInitializationEvent e)
	{
		log = e.getModLog();
	}
	
	public void init(FMLInitializationEvent e)
	{
		
	}
	
	public void postInit(FMLPostInitializationEvent e)
	{
		
	}

}
