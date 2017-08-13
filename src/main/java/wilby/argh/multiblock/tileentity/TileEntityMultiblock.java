package wilby.argh.multiblock.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityMultiblock extends TileEntity implements ITickable
{

	private String name;
	
	public TileEntityMultiblock(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public void update() 
	{
		
	}
	
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		return compound;
	}
	
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
	}
}
