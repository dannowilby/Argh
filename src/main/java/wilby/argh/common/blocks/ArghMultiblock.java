package wilby.argh.common.blocks;

import java.util.HashMap;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import wilby.argh.Argh;
import wilby.argh.common.Structure;

public class ArghMultiblock 
{
	
	public static HashMap<String, Structure> structures = new HashMap<String, Structure>();
	
	public static void removeStructure(String id)
	{
		structures.remove(id);
	}
	
	public static void setStructure(String id, Structure structure)
	{
		structures.put(id, structure);
	}
	
	public ArghMultiblock(String id, TileEntity te, String structureLocation)
	{
		try 
		{
			setStructure(id, Argh.getConfig().loadStructure(structureLocation));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean isMultiblock(String structureId, World world, BlockPos pos)
	{
		
		
		return false;
	}
	
	public static BlockPos getControlBlock(String structureId, World world, BlockPos pos)
	{
		if(isMultiblock(structureId, world, pos))
		{
			
		}
		
		return null;
	}
	
}
