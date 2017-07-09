package wilby.argh.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import wilby.argh.Argh;
import wilby.argh.common.blocks.ArghBlocks;
import wilby.argh.common.blocks.Vector4ib;

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

	public Structure loadStructure(String structureLocation) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new FileReader(new File(structDir.getPath() + "/" + structureLocation + ".strct")));
		
		String[] line = br.readLine().split("-");
		
		int maxX = Integer.parseInt(line[0]), maxY = Integer.parseInt(line[1]), maxZ = Integer.parseInt(line[2]);
		
		ArrayList<Vector4ib> list = new ArrayList<Vector4ib>();
		
		int x = 0, y = 0, z = 0;
		
		String nextLine;
		
		int offsetX = 0;
		int offsetY = 0;
		while(!((nextLine = br.readLine()) == null))
		{
			line = nextLine.split("-");
			
			int offsetZ = 0;
			for(int i = 0; i < line.length; i++)
			{
				if(line[i].startsWith("a"))
				{
					list.add(new Vector4ib(x + offsetX, y + offsetY, z + offsetZ, ArghBlocks.getBlockFromId(line[i])));
				}
				else
				{
					list.add(new Vector4ib(x + offsetX, y + offsetY, z + offsetZ, Block.getBlockById(Integer.parseInt(line[i]))));
				}
				offsetZ++;
			}
			if(offsetZ >= maxZ)
			{
				offsetZ = 0;
			}
			if(offsetX >= maxX)
			{
				offsetX = 0;
				offsetY+=1;
			}
			if(offsetY >= maxY)
			{
				break;
			}
		}
		
		br.close();
		
		return new Structure(list);
	}
	
}
