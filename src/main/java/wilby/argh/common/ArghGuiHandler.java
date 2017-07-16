package wilby.argh.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import wilby.argh.multiblock.ArghMultiblock;
import wilby.argh.multiblock.smeltery.ContainerSmeltery;
import wilby.argh.multiblock.smeltery.GuiSmeltery;
import wilby.argh.multiblock.smeltery.TileEntitySmeltery;

public class ArghGuiHandler implements IGuiHandler
{

	public static int smeltery = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{	
		
		if(ID == smeltery)
		{
			TileEntitySmeltery tes = (TileEntitySmeltery) world.getTileEntity(ArghMultiblock.getPartMultiblock(new BlockPos(x,y,z)).getMaster());
			
			return new ContainerSmeltery(player.inventory, tes);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == smeltery)
		{
			
			TileEntitySmeltery tes = (TileEntitySmeltery) world.getTileEntity(ArghMultiblock.getPartMultiblock(new BlockPos(x,y,z)).getMaster());
			return new GuiSmeltery(player.inventory, tes);
		}
		
		return null;
	}

}
