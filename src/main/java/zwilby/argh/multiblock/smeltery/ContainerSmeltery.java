package zwilby.argh.multiblock.smeltery;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wilby.argh.multiblock.tileentity.TileEntitySmeltery;

public class ContainerSmeltery extends Container
{

	private TileEntitySmeltery tes;
	
	private int cookTime;
    private int furnaceBurnTime;
	
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
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) 
	{
		ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
        }
        
        return itemstack;
    }
	
	@Override
	public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tes);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
	@Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icontainerlistener = this.listeners.get(i);

            if (this.cookTime != this.tes.getField(0))
            {
                icontainerlistener.sendWindowProperty(this, 0, this.tes.getField(0));
            }

            if (this.furnaceBurnTime != this.tes.getField(1))
            {
                icontainerlistener.sendWindowProperty(this, 1, this.tes.getField(1));
            }
        }

        this.cookTime = this.tes.getField(0);
        this.furnaceBurnTime = this.tes.getField(1);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.tes.setField(id, data);
    }
	
	public class SlotSmelteryFuel extends Slot
	{

		ItemStack[] fuels = {new ItemStack(Items.COAL), 
				new ItemStack(Item.getItemFromBlock(Blocks.COAL_BLOCK)), 
				new ItemStack(Item.getItemFromBlock(Blocks.DIAMOND_BLOCK))};
		
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
