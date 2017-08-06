package wilby.argh.multiblock.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityMultiblockBase extends TileEntity implements ITileEntityMultiblock, ITickable
{
	
	private TileEntityMultiblockBrain brain;
	
	public TileEntityMultiblockBase()
	{
		brain = null;
	}
	
	@Override
	public void update()
	{
	}
	
	public void setBrain(TileEntityMultiblockBrain m)
	{
		this.brain = m;
	}
	
	public TileEntityMultiblockBrain getBrain()
	{
		return this.brain;
	}

	@Override
	public String getOfficialName() 
	{
		return "base";
	}
	
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setString("brain", brain.getOfficialName());
		return compound;
	}
	
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		brain = (TileEntityMultiblockBrain) ArghTileEntityMultiblock.getMultiblockTileEntity(compound.getString("brain"));
	}
	
	
}
