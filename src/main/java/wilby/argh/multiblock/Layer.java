package wilby.argh.multiblock;

import net.minecraft.block.Block;

public class Layer 
{
	
	private Block[][] layout;
	
	private int x, z;	
	
	public Layer()
	{
		
	}
	
	public Layer(int sX, int sZ)
	{
		layout = new Block[sX][sZ];
		this.x = sX;
		this.z = sZ;
	}
	
	public void setLayerSize(int x, int z)
	{
		layout = new Block[x][z];
		this.x = x;
		this.z = z;
	}
	
	public int getSizeX()
	{
		return this.x;
	}
	
	public int getSizeZ()
	{
		return this.z;
	}
	
	public void setIndex(int x, int z, Block b)
	{
		layout[x][z] = b;
	}
	
	public Block getBlockAtIndex(int x, int z)
	{
		return layout[x][z];
	}
	
}
