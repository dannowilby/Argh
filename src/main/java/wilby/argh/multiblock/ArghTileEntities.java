package wilby.argh.multiblock;

import net.minecraft.tileentity.TileEntity;
import wilby.argh.multiblock.smeltery.TileEntitySmeltery;

public class ArghTileEntities 
{

	public static TileEntity getTileEntity(String id) 
	{
		if(id.equalsIgnoreCase("smeltery"))
		{
			return new TileEntitySmeltery(null, true);
		}
		
		return null;
	}

}
