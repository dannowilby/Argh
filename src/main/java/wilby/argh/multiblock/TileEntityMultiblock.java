package wilby.argh.multiblock;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import wilby.argh.block.ArghBlocks;

public abstract class TileEntityMultiblock extends TileEntity implements IMultiblock
{
	
	private ArrayList<BlockPos> partsList;
	
	private BlockPos masterPos;
	
	private boolean master;
	
	public TileEntityMultiblock()
	{
		
	}
	
	public boolean isMaster()
	{
		return master;
	}
	
	public void setMasterPos(BlockPos b)
	{
		this.masterPos = b;
	}
	
	public void setMaster(boolean b)
	{
		master = b;
	}
	
	public BlockPos getMaster()
	{
		return masterPos;
	}
	
	@Override
	public boolean isMultiblockPart(BlockPos bp)
	{
		if(partsList != null)
		{
			int size = partsList.size();
			
			for(int i = 0; i < size; i++)
			{
				if(partsList.get(i) == bp)
				{
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<BlockPos> getMultiblockPartsList() 
	{
		return partsList;
	}
	
	@Override
	public void setMultiblockPartsList(ArrayList<BlockPos> bp) 
	{
		partsList = bp;
	}
	
	@Override
	public abstract void birthChildren();
	
	@Override
	public abstract void deleteChildren();
	
	@Override
	public abstract void update();
	
	@Override
	public abstract boolean isFullMultiblock();
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		return compound;
	}
	
}
