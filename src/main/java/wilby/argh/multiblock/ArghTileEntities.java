package wilby.argh.multiblock;

import net.minecraft.tileentity.TileEntity;

public class ArghTileEntities 
{

	public static TileEntity getTileEntity(String id) 
	{
		if(id.equalsIgnoreCase("smeltery"))
		{
			return new TileEntitySmeltery();
		}
		
		return null;
	}

}
