package wilby.argh.multiblock;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public abstract class TileEntityMultiblock extends TileEntity implements IMultiblock
{
	
	private ArrayList<BlockPos> partsList;
	
	public TileEntityMultiblock()
	{
		
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
	public abstract boolean isMaster();
	
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
