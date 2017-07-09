package wilby.argh.common;

import java.util.ArrayList;

import wilby.argh.common.blocks.Vector4ib;

public class Structure 
{
	
	private ArrayList<Vector4ib> structure;
	
	public Structure(ArrayList<Vector4ib> b)
	{
		structure = b;
	}
	
	public ArrayList<Vector4ib> getStructureLayout()
	{
		return structure;
	}
	
}
