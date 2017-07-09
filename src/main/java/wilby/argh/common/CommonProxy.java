package wilby.argh.common;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import wilby.argh.common.blocks.ArghMultiblock;

public class CommonProxy implements IGuiHandler
{
	
	public static Map<String, ArghMultiblock> multiblocks = new HashMap<String, ArghMultiblock>();
	
	public void preInit(FMLPreInitializationEvent e)
	{
		
	}
	
	public void init(FMLInitializationEvent e)
	{
		ArghMultiblock testBlock = new ArghMultiblock("smeltery", null, "smeltery");
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
