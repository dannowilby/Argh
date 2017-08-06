package wilby.argh.common;

import net.minecraft.tileentity.TileEntity;
import wilby.argh.multiblock.tileentity.ArghTileEntityMultiblock;
import wilby.argh.multiblock.tileentity.TileEntityMiner;
import wilby.argh.multiblock.tileentity.TileEntitySmeltery;

public class ArghTileEntity 
{
	
	public static void init()
	{
		ArghTileEntityMultiblock.init();
	}
	
	public static TileEntity getTileEntity(String id) 
	{
		if(id.equalsIgnoreCase("smeltery"))
		{
			return new TileEntitySmeltery();
		}
		
		if(id.equalsIgnoreCase("miner"))
		{
			return new TileEntityMiner();
		}
		
		return null;
	}

}
