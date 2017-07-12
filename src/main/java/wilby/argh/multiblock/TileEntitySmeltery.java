package wilby.argh.multiblock;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntitySmeltery extends TileEntityMultiblock implements ISidedInventory
{
	
	private boolean master = false;
	ArrayList<BlockPos> children;
	
	@Override
	public void update() 
	{
		if(refreshRate())
		{
			if(!isMaster())
			{
				
			}
			
			if(isMaster() && isFullMultiblock())
			{
				if(children == null)
				{
					birthChildren();
				}
			}
			if(isMaster() && !isFullMultiblock())
			{
				if(children != null)
				{
					deleteChildren();
				}
			}
		}
	}

	@Override
	public boolean isMaster() 
	{
		if(isFullMultiblock())
		{
			return (master = true);
		}
		
		return master;
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
		children = this.getMultiblockPartsList();
		this.getMultiblockPartsList().forEach((l) -> {
			if(!(world.getTileEntity(l) instanceof TileEntitySmeltery))
			{
				world.setTileEntity(l, new TileEntitySmeltery());
			}
		});
		
	}

	@Override
	@SideOnly(Side.SERVER)
	public void deleteChildren()
	{
		System.out.println("deleting children");
		children.forEach((l) -> {
			if(world.getTileEntity(l) instanceof TileEntitySmeltery)
			{
				TileEntitySmeltery tes = (TileEntitySmeltery) world.getTileEntity(l);
				
				if(!tes.isMaster())
					world.removeTileEntity(l);
				
			}
		});
		children = null;
		this.setMultiblockPartsList(null);
	}
	
	private boolean refreshRate() 
	{
		if(world.getWorldTime() % 30 == 0)
		{
			return true;
		}
		
		return false;
	}
	
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

	//Inventory Data --------------------------------------------------------------------------------------------------------------
	
	private static final int[] SLOTS_TOP = new int[] {0};
    private static final int[] SLOTS_BOTTOM = new int[] {2, 1};
    private static final int[] SLOTS_SIDES = new int[] {1};
    private NonNullList<ItemStack> furnaceItemStacks = NonNullList.<ItemStack>withSize(15, ItemStack.EMPTY);
	
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
	public ItemStack getStackInSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		// TODO Auto-generated method stub
		return false;
	}

}
