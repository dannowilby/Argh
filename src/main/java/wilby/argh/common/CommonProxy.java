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
	
	Map<String, ArghMultiblock> multiblocks = new HashMap<String, ArghMultiblock>();
	
	public void preInit(FMLPreInitializationEvent e)
	{
		multiblocks.put("smeltery", new ArghMultiblock("structure_smeltery", "smeltery"));
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
