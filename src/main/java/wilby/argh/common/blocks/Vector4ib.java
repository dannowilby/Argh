package wilby.argh.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class Vector4ib 
{
	
	private int x, y, z;
	private Block block;
	
	public Vector4ib(int x, int y, int z, Block block)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.block = block;
	}
	
	public Vector4ib(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.block = Blocks.AIR;
	}
	
	public Vector4ib(Block block)
	{
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.block = block;
	}
	
	public Vector4ib()
	{
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.block = Blocks.AIR;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setZ(int z)
	{
		this.z = z;
	}
	
	public int getZ()
	{
		return z;
	}
	
	public void setBlock(Block block)
	{
		this.block = block;
	}
	
	public Block getBlock()
	{
		return block;
	}
	
}
