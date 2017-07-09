package wilby.argh.common.blocks;

import net.minecraft.tileentity.TileEntity;

public class ArghMultiblock 
{
	
	private int[][][] sl;
	private String id;
	
	public ArghMultiblock(String structureLocation, String id)
	{
		this.id = id;
		sl = loadStructure(structureLocation);
	}

	public int[][][] getBlockStructure()
	{
		return sl;
	}
	
	public String getId()
	{
		return id;
	}
	
	public TileEntity getTileEntity()
	{
		
		return null;
	}
	
	private int[][][] loadStructure(String structureLocation) 
	{
		
		
		return null;
	}
	
}
