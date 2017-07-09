package wilby.argh.common;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class Structure 
{
	
	private Block[][][] structure;
	private TileEntity te;
	
	public Structure(Block[][][] b, TileEntity te)
	{
		structure = b;
		this.te = te;
	}
	
	public Block[][][] getStructureLayout()
	{
		return structure;
	}
	
	public TileEntity getTileEntity()
	{
		return te;
	}
	
}
