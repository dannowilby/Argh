package wilby.argh.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import wilby.argh.Argh;
import wilby.argh.block.ArghBlocks;
import wilby.argh.multiblock.Layer;
import wilby.argh.multiblock.Structure;

public class Config 
{
	
	private File modDir;
	private File structDir;
	
	public Config(File mainDir)
	{
		modDir = new File(mainDir.getPath() + "/" + Argh.MODID);
		structDir = new File(modDir.getPath() + "/structures");
		
		if(!modDir.exists())
		{
			modDir.mkdir();
		}
		if(!structDir.exists())
		{
			structDir.mkdir();
		}
	}
	
	public File getModConfigDirectory()
	{
		return modDir;
	}

	public Structure loadStructure(String structureLocation)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(structDir.getPath() + "/" + structureLocation + ".strct")));
			
			String[] line = br.readLine().split("-");
			int maxX = Integer.parseInt(line[0]), maxY = Integer.parseInt(line[1]), maxZ = Integer.parseInt(line[2]);
			
			line = br.readLine().split("-");
			
			BlockPos central = new BlockPos(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
			
			ArrayList<Layer> list = new ArrayList<Layer>();
			
			for(int i = 0; i < maxY; i++)
			{
				list.add(new Layer(maxX, maxZ));
			}
			
			String nextLine;
			
			int x = 0, z = 0;
			
			while(!((nextLine = br.readLine()) == null))
			{
				line = nextLine.split("-");
				String[] line2 = {line[1], line[2] ,line[3]};
				Layer l = list.get(Integer.parseInt(line[0]) - 1);
				for(String i : line2)
				{
					if(i.startsWith("a"))
					{
						l.setIndex(x, z, ArghBlocks.getBlockFromId(i));
					}
					else
					{
						l.setIndex(x, z, Block.getBlockById(Integer.parseInt(i)));
					}
					z++;
				}
				x++;
				
				if(x >= maxX)
				{
					x = 0;
				}
				if(z >= maxZ)
				{
					z = 0;
				}
			}
			
			br.close();
			
			return new Structure(list, central);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
