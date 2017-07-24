package wilby.argh.multiblock.smeltery;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerSmeltery extends Container
{

	private TileEntitySmeltery tes;
	
	public ContainerSmeltery(IInventory i, TileEntitySmeltery tes)
	{
		this.tes = tes;
		
		for (int il = 0; il < 3; ++il)
        {
            for (int j = 0; j < 3; ++j)
            {
            	this.addSlotToContainer(new Slot(tes, j + il * 3, 40 + j * 18, 17 + il * 18));
            }
        }
		
		for(int t = 0; t < 3; t++)
		{
			this.addSlotToContainer(new SlotSmelteryFuel(tes, 9 + t, 12, 17 + t * 18));
		}
		
		for(int t = 0; t < 3; t++)
		{
			for(int j = 0; j < 2; j++)
			{
				this.addSlotToContainer(new SlotFurnaceOutput(((InventoryPlayer)i).player, tes, 12 + t + j * 3, 131 + j * 18, 17 + t * 18));
			}
		}
		
        for (int k = 0; k < 3; ++k)
        {
            for (int i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(i, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }

        for (int l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(i, l, 8 + l * 18, 142));
        }
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return tes.isUsableByPlayer(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) 
	{
	    ItemStack previous = null;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (current.getCount() == 0)
	            slot.putStack((ItemStack) null);
	        else
	            slot.onSlotChanged();

	        if (current.getCount() == previous.getCount())
	            return null;
	        slot.onTake(playerIn, current);
	    }
	    return previous;
	}
	
	public class SlotSmelteryFuel extends Slot
	{

		ItemStack[] fuels = {new ItemStack(Items.COAL), new ItemStack(Item.getItemFromBlock(Blocks.COAL_BLOCK)), new ItemStack(Item.getItemFromBlock(Blocks.DIAMOND_BLOCK))};
		
		public SlotSmelteryFuel(IInventory inventoryIn, int index, int xPosition, int yPosition) 
		{
			super(inventoryIn, index, xPosition, yPosition);
		}
		
		@Override
		public boolean isItemValid(ItemStack stack)
		{
			for(ItemStack i : fuels)
			{
				if(i.getItem().equals(stack.getItem()))
				{
					return true;
				}
			}
			return false;
		}
		
	}
	
}
