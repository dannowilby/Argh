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
import wilby.argh.multiblock.TileEntitySmeltery;

public class CommonProxy implements IGuiHandler
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
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		return null;
	}

}
