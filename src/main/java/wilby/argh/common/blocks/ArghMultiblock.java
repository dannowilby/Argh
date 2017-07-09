package wilby.argh.common.blocks;

import java.util.HashMap;

import net.minecraft.tileentity.TileEntity;
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
			setStructure(id, Argh.getConfig().loadStructure(structureLocation, te));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public TileEntity getTileEntity(String id)
	{
		return structures.get(id).getTileEntity();
	}
	
}
