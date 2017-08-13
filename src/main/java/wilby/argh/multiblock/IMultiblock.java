package wilby.argh.multiblock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IMultiblock
{
	
	void addToWorld(World world, BlockPos pos, EntityPlayer player);
	
	boolean createMultiblock(World world, BlockPos pos, EnumFacing side, EntityPlayer player);
	
	boolean structureCheck(World world, BlockPos pos, EnumFacing facing, boolean mirror);
	
	ItemStack[][][] getStructure();
	
}
