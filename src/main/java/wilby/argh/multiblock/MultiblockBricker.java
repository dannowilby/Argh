package wilby.argh.multiblock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import wilby.argh.util.ArghLoader;

public class MultiblockBricker implements IMultiblock
{

	public static MultiblockBricker instance = new MultiblockBricker();
	
	static ItemStack[][][] structure;
	
	static 
	{
		structure = ArghLoader.loadStructure("bricker");
	}
	
	@Override
	public void createMultiblock(World world, BlockPos pos, EntityPlayer player) 
	{
		
	}

	@Override
	public boolean checkIsMultiblock(World world, BlockPos pos) 
	{
		return false;
	}

	@Override
	public ItemStack[][][] getStructure() 
	{
		return structure;
	}

}
