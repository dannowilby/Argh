package wilby.argh.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import wilby.argh.Argh;

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

	public Structure loadStructure(String structureLocation, TileEntity te) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new FileReader(new File(structDir.getPath() + "/" + structureLocation + ".strct")));
		
		String[] line = br.readLine().split("-");
		
		int x = Integer.parseInt(line[0]);
		int y = Integer.parseInt(line[1]);
		int z = Integer.parseInt(line[2]);
		
		Block[][][] struct= new Block[x][y][z];
		
		struct[0][0][0] = Blocks.STONE;
		
		br.close();
		
		return new Structure(struct, te);
	}
	
}
