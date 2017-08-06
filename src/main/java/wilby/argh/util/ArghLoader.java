package wilby.argh.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import wilby.argh.Argh;
import wilby.argh.block.ArghBlocks;

public class ArghLoader 
{
	
	static File modFile;
	
	static Configuration config;
	
	public void installConfigs()
	{
		
	}
	
	public static void installStructures(String fileName)
	{
		
	}
	
	public static boolean alreadyInstalled()
	{
		return false;
	}
	
	public static void setLoaderConfigurationDirectory(File file)
	{
		modFile = file;
		
		config = new Configuration(file);
		
	}
	
	public static void loadConfigurations()
	{
		
	}
	
	public static ItemStack[][][] loadStructureFromFile(File struct)
	{
		ItemStack[][][] structure = null;
		long start = System.currentTimeMillis();
		long stop;
		try
		{
			BufferedReader br;
			br = new BufferedReader(new FileReader(struct));
			String line = br.readLine();
			String[] size = line.split("-");
			
			int x = Integer.parseInt(size[0]);
			int y = Integer.parseInt(size[1]);
			int z = Integer.parseInt(size[2]);
			ArghLogger.log("Size = " + x + " - " + y + " - " + z);
			structure = new ItemStack[x][y][z];
			int x1 = 0;
			
			while((line = br.readLine()) != null)
			{
				String[] s = line.split("-");
				int y1 = Integer.parseInt(s[0]) - 1;
				
				for(int p = 0; p < (s.length - 1); p++)
				{
					Block b;
					if(s[p+1].startsWith("a"))
					{
						b = ArghBlocks.getBlockFromId(s[p+1]);
						structure[x1][y1][p] = new ItemStack(b);
					}
					else
					{
						b = Block.getBlockById(Integer.parseInt(s[p+1]));
						structure[x1][y1][p] = new ItemStack(b);
					}
				}
				x1++;
				
				if(x1 >= x)
				{
					x1 = 0;
				}
			}
			
			br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			stop = System.currentTimeMillis();
			long time = stop - start;
			ArghLogger.log("Finished loading structure from " + struct.getName());
			ArghLogger.log("Loading structure took " + ((float)time/(float)1000) + " seconds");
		}
		
		return structure;
	}
	
	public static ItemStack[][][] loadStructure(String fileName)
	{
		File struct = new File(modFile.getPath() + "/" + Argh.MODID + "/structures/" + fileName + ".strct");
		
		ItemStack[][][] structure;
		
		ArghLogger.log("Loading structure from " + struct.getName());
		
		if(struct.exists())
		{
			structure = loadStructureFromFile(struct);
		}
		else
		{
			ArghLogger.log("Structure file not found! Downloading default!");
			installStructures(fileName);
			structure = null; //loadStructure(fileName);
		}
		
		return structure;
	}
	
}
