package wilby.argh.multiblock;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import wilby.argh.Argh;

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
	
	public ArghMultiblock(String id)
	{
		setStructure(id, Argh.getConfig().loadStructure(id));
	}
	
	public static void init()
	{
		System.out.println("Now Starting to Load Structures...");
		long time = System.currentTimeMillis();
		
		new ArghMultiblock("smeltery");
		
		System.out.println("Finished Loading Structures: Took " + ((double)(System.currentTimeMillis() - time) / (double)1000) + " seconds");
	}
	
	public static boolean isMultiblock(String structureId, World world, BlockPos pos, TileEntityMultiblock temb)
	{
		Structure st = structures.get(structureId);
		BlockPos cent = st.getCentralBlockLocation();
		int sizeY = st.getStructureLayout().size();
		
		ArrayList<BlockPos> positions = new ArrayList<BlockPos>();
		
		Layer top = st.getStructureLayout().get(sizeY - 1);
		int sizeX = top.getSizeX();
		int sizeZ = top.getSizeZ();
		
		for(int y = 0; y < sizeY; y++)
		{
			Layer current = st.getStructureLayout().get(y);
			for(int x = 0; x < sizeX; x++)
			{
				for(int z = 0; z < sizeZ; z++)
				{
					Block b = current.getBlockAtIndex(x, z);
					int x1 = pos.getX() + (x - cent.getX());
					int y1 = pos.getY() + (y - (sizeY - 1));
					int z1 = pos.getZ() + (z - cent.getZ());
					BlockPos p = new BlockPos(x1, y1, z1);
					Block other = world.getBlockState(p).getBlock();
					if(Block.isEqualTo(b, other))
					{
						positions.add(p);
					}
					else
					{
						temb.setMultiblockPartsList(null);
						return false;
					}
				}
			}
		}
		
		temb.setMultiblockPartsList(positions);
		
		return true;
	}
}
