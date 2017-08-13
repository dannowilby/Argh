package wilby.argh.multiblock.tileentity;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wilby.argh.multiblock.IMultiblock;
import wilby.argh.multiblock.MultiblockBricker;
import wilby.argh.multiblock.MultiblockMiner;
import wilby.argh.multiblock.MultiblockSmeltery;

public class ArghTileEntityMultiblock 
{
	
	public static ArrayList<TileEntityMultiblock> entityList;
	
	@SuppressWarnings("unchecked")
	public static void init()
	{
		entityList = new ArrayList<TileEntityMultiblock>();
		
		entityList.add(new TileEntitySmeltery());
		entityList.add(new TileEntityMiner());
		entityList.add(new TileEntityBricker());
		entityList.add(new TileEntityComponent());
		
		entityList.forEach((te) -> {
			GameRegistry.registerTileEntity((Class<? extends TileEntity>) te.getClass(), te.getName());
		});
	}
	
	public static TileEntity getMultiblockTileEntity(String s)
	{
		if(s.equals("smeltery"))
		{
			return new TileEntitySmeltery();
		}
		if(s.equals("miner"))
		{
			return new TileEntityMiner();
		}
		if(s.equals("bricker"))
		{
			return new TileEntityBricker();
		}
		return null;
	}
	
}
