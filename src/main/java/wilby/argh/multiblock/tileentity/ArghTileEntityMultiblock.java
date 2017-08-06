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
	
	public static ArrayList<ITileEntityMultiblock> entityList;
	public static ArrayList<IMultiblock> multiblockList;
	
	@SuppressWarnings("unchecked")
	public static void init()
	{
		entityList = new ArrayList<ITileEntityMultiblock>();
		multiblockList = new ArrayList<IMultiblock>();
		
		entityList.add(new TileEntitySmeltery());
		entityList.add(new TileEntityMiner());
		entityList.add(new TileEntityBricker());
		entityList.add(new TileEntityMultiblockBase());
		
		multiblockList.add(MultiblockMiner.instance);
		multiblockList.add(MultiblockBricker.instance);
		multiblockList.add(MultiblockSmeltery.instance);
		
		entityList.forEach((te) -> {
			GameRegistry.registerTileEntity((Class<? extends TileEntity>) te.getClass(), te.getOfficialName());
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
		if(s.equals("base"))
		{
			return new TileEntityMultiblockBase();
		}
		return null;
	}
	
}
