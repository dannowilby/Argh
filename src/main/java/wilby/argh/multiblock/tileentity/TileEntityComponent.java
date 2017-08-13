package wilby.argh.multiblock.tileentity;

import net.minecraft.nbt.NBTTagCompound;

public class TileEntityComponent extends TileEntityMultiblock
{

	private boolean master;
	
	public TileEntityComponent() 
	{
		super("component");
	}
	
	public void setIsMaster(boolean b)
	{
		this.master = b;
	}
	
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setBoolean("master", master);
		return compound;
	}
	
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.master = compound.getBoolean("master");
	}
	
}
