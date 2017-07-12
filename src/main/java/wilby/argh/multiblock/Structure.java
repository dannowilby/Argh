package wilby.argh.multiblock;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class Structure 
{
	
	private ArrayList<Layer> structure;
	private BlockPos central;
	
	public Structure(ArrayList<Layer> b, BlockPos central)
	{
		structure = b;
		this.central = central;
	}
	
	public ArrayList<Layer> getStructureLayout()
	{
		return structure;
	}
	
	public BlockPos getCentralBlockLocation()
	{
		return central;
	}
}

