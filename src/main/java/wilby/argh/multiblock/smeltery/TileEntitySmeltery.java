package wilby.argh.multiblock.smeltery;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wilby.argh.block.ArghBlocks;
import wilby.argh.multiblock.ArghMultiblock;
import wilby.argh.multiblock.TileEntityMultiblock;

public class TileEntitySmeltery extends TileEntityMultiblock implements ISidedInventory
{
	
	private ArrayList<BlockPos> children;
	
	private int burnTime;
	private int cookTime;
	
	public int getBurnTime()
	{
		return burnTime;
	}
	
	public int getCookTime()
	{
		return cookTime;
	}
	
	public TileEntitySmeltery()
	{
		super();
	}
	
	@Override
	public void update() 
	{
		
		boolean flag = false;
		
		if (!this.world.isRemote)
        {
			if(this.canSmelt())
			{
				System.out.println(cookTime + " " + burnTime);
				if(this.isBurning() && cookTime >= this.getTotalCookTime())
				{
					cookTime = 0;
					smeltItem();
				}
				if(this.isBurning())
				{
					this.cookTime++;
		    	  	this.burnTime--;
		    	  	flag = true;
		       	}
				if(!this.isBurning() && hasFuel())
		       	{
		    	   	burnTime = this.getTotalBurnTime();
		    	   	removeFuel(1);
		       	}
			}
        }

		if(flag)
		{
			this.setField(2, burnTime);
			this.setField(0, cookTime);
			this.markDirty();
			flag = false;
		}
		
     	if(refreshRate())
		{
			if(Block.isEqualTo(world.getBlockState(pos).getBlock(), ArghBlocks.smelteryVent))
			{
				this.setMaster(true);
			}
			
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
			TileEntitySmeltery tes = new TileEntitySmeltery();
			tes.setMasterPos(pos);
			ArghMultiblock.putTiles(i, tes);
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
	
	public int getTotalCookTime()
	{
		return 100;
	}
	
	public int getTotalBurnTime()
	{
		return 500;
	}
	
	public void removeFuel(int amount)
	{
		for(int i = 0; i < 3; i++)
		{
			ItemStack t = this.furnaceItemStacks.get(9 + i);
			if(!(t == null))
			{
				if(!t.isEmpty())
				{
					t.setCount(t.getCount() - amount);
					return;
				}
			}
		}
		System.out.println("MAJOR ERROR! REPORT IT PLEASE -----------------------------------------------");
	}
	
	public boolean canSmelt()
	{
		if(this.isBurning())
		{
			for(int il = 0; il < 9; il++)
			{
				ItemStack in = (ItemStack) this.furnaceItemStacks.get(il);
				ItemStack t = SmelteryRecipes.getInstance().getSmeltingResult(in.getItem());
				if(t != null)
						if(!t.isEmpty())
							return true;
				else
					return false;
			}
		}
		if(!this.isBurning())
		{
			if(!hasFuel())
			{
				return false;
			}
			for(int k = 0; k < 9; k++)
			{
				ItemStack in = (ItemStack) this.furnaceItemStacks.get(k);
				System.out.println(in);
				ItemStack t = SmelteryRecipes.getInstance().getSmeltingResult(in.getItem());
				System.out.println("k = " + k + " " + in + " " + t);
				if(t != null)
					if(!t.isEmpty())
						return true;
			}
			return false;
		}
		return false;
	}

	public boolean hasFuel()
	{
		ItemStack[] t = new ItemStack[3];
		int l = 0;
		for(int i = 0; i < 3; i++)
		{
			t[i] = (ItemStack) this.furnaceItemStacks.get(9 + i);
			if(t[i].isEmpty() || t[i] == null)
			{
				l++;
			}
			if(l >= 3)
			{
				return false;
			}
		}
		return true;
	}
	
	public void smeltItem()
	{
		
	}
	
	public boolean isBurning()
    {
        return this.burnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory)
    {
        return inventory.getField(1) > 0;
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
	public int getField(int id) 
	{
		switch (id)
		{
			case 0:
				return this.cookTime;
			case 1:
				return this.getTotalCookTime();
			case 2:
				return this.burnTime;
			case 3: 
				return this.getTotalBurnTime();
			default:
				return -1;
		}
	}

	@Override
	public void setField(int id, int value) 
	{
		switch (id)
		{
		case 0:
			cookTime = value;
			break;
		case 1:
			burnTime = value;
			break;
		}
	}

	@Override
	public int getFieldCount() 
	{
		return 4;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		
		cookTime = compound.getInteger("cook");
		burnTime = compound.getInteger("burn");
		
		ItemStackHelper.loadAllItems(compound, this.furnaceItemStacks);
		
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		compound.setInteger("cook", cookTime);
		compound.setInteger("burn", burnTime);
		
		ItemStackHelper.saveAllItems(compound, this.furnaceItemStacks);
		
		return compound;
	}

	//Inventory Data --------------------------------------------------------------------------------------------------------------
	
    private NonNullList<ItemStack> furnaceItemStacks = NonNullList.<ItemStack>withSize(18, ItemStack.EMPTY);
	
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
