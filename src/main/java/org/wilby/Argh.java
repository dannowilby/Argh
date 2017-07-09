package org.wilby;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Argh.MODID, version = Argh.VERSION, name = Argh.NAME)

public class Argh 
{
	public static final String MODID = "argh";
	public static final String VERSION = "3";
	public static final String NAME = "argh";
	    
	@SidedProxy(clientSide = "org.wilby.ClientProxy", serverSide = "org.wilby.CommonProxy")
	public static CommonProxy proxy = new CommonProxy();
	    
	@Instance("argh")
	public static Argh argh = new Argh();

	public static Logger modlogger;
	    
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		System.out.println("argh");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		
	}
}
