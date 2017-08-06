package wilby.argh.multiblock.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import wilby.argh.multiblock.IMultiblock;

public class TileEntityMultiblockBrain<T extends IMultiblock> extends TileEntity implements ITickable, IInventory, ITileEntityMultiblock
{
	
	T multiblock;
	
	public TileEntityMultiblockBrain()
	{
		this(null);
	}
	
	public TileEntityMultiblockBrain(IMultiblock multiblocks)
	{
		this.multiblock = (T) multiblocks;
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
	
	@Override
	public String getName() 
	{
		return null;
	}

	@Override
	public boolean hasCustomName() 
	{
		return false;
	}

	@Override
	public int getSizeInventory() 
	{
		return 0;
	}

	@Override
	public boolean isEmpty() 
	{
		return false;
	}

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return null;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 0;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		return false;
	}

	@Override
	public void openInventory(EntityPlayer player) 
	{
		
	}

	@Override
	public void closeInventory(EntityPlayer player) 
	{
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		return false;
	}

	@Override
	public int getField(int id) 
	{
		return 0;
	}

	@Override
	public void setField(int id, int value) 
	{
		
	}

	@Override
	public int getFieldCount() 
	{
		return 0;
	}

	@Override
	public void clear() 
	{
		
	}

	@Override
	public String getOfficialName() 
	{
		return null;
	}

}
