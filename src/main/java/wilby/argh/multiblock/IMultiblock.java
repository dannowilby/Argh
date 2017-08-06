package wilby.argh.multiblock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IMultiblock
{
	
	void createMultiblock(World world, BlockPos pos, EntityPlayer player);
	
	boolean checkIsMultiblock(World world, BlockPos pos);
	
	ItemStack[][][] getStructure();
	
}
