package wilby.argh.multiblock.smeltery;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import wilby.argh.multiblock.ArghMultiblock;
import wilby.argh.multiblock.TileEntityMultiblock;

public class TileEntitySmeltery extends TileEntityMultiblock implements ISidedInventory
{
	
	private ArrayList<BlockPos> children;
	
	public TileEntitySmeltery(BlockPos master, boolean isMaster)
	{
		super(master, isMaster);
	}
	
	@Override
	public void update() 
	{
		if(refreshRate())
		{
			if(isMaster())
			{
				if(isFullMultiblock() && children == null)
				{
					birthChildren();
					this.markDirty();
				}
				if(!isFullMultiblock() && children != null)
				{
					deleteChildren();
					this.markDirty();
				}
			}
		}
	}
	
	public boolean hasChildren()
	{
		if(children == null)
			return false;
		else
			return true;
	}
	
	@Override
    public NBTTagCompound getUpdateTag() 
	{
        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() 
    {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new SPacketUpdateTileEntity(this.getMaster(), 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) 
    {
    	this.readFromNBT(packet.getNbtCompound());
    }
	
	@Override
	public boolean isFullMultiblock() 
	{
		return ArghMultiblock.isMultiblock("smeltery", world, pos, this);
	}
	
	@Override
	public void birthChildren() 
	{
		System.out.println("giving birth");
		children = new ArrayList<BlockPos>();
		this.getMultiblockPartsList().forEach((i) -> {
			ArghMultiblock.putTiles(i, new TileEntitySmeltery(pos, false));
			children.add(i);
		});
	}
	
	@Override
	public void deleteChildren()
	{
		System.out.println("aborting children");
		children.forEach((i) -> {
			ArghMultiblock.removeTiles(i);
		});
		children = null;
	}
	
	private boolean refreshRate() 
	{
		if(world.getWorldTime() % 15 == 0)
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		
		boolean mast = compound.getBoolean("master");
		
		if(mast)
		{
			ItemStackHelper.loadAllItems(compound, this.furnaceItemStacks);
			this.setMaster(true);
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		if(this.isMaster())
		{
			this.setMaster(compound.getBoolean("master"));
			ItemStackHelper.saveAllItems(compound, this.furnaceItemStacks);
		}
		return compound;
	}

	//Inventory Data --------------------------------------------------------------------------------------------------------------
	
    private NonNullList<ItemStack> furnaceItemStacks = NonNullList.<ItemStack>withSize(9, ItemStack.EMPTY);
	
	@Override
	public int getSizeInventory() 
	{
		return furnaceItemStacks.size();
	}

	@Override
	public boolean isEmpty() 
	{
		for(ItemStack stack : furnaceItemStacks)
		{
			if(!stack.isEmpty())
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return furnaceItemStacks.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
        this.furnaceItemStacks.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit())
        {
            stack.setCount(this.getInventoryStackLimit());
        }
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		return true;
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
		 this.furnaceItemStacks.clear();
	}
	
	public String getRenderName()
	{
		return "Smeltery";
	}
	
	@Override
	public String getName() 
	{
		return "container.smeltery";
	}
	
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerSmeltery(playerInventory, this);
    }
	
	@Override
	public boolean hasCustomName() 
	{
		return false;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) 
	{
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) 
	{
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) 
	{
		return false;
	}

}
