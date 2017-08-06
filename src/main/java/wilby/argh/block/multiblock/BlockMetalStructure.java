package wilby.argh.block.multiblock;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import wilby.argh.block.ArghBlock;
import wilby.argh.multiblock.tileentity.TileEntityMultiblockBase;
import wilby.argh.multiblock.tileentity.TileEntityMultiblockBrain;

public class BlockMetalStructure extends ArghBlock 
{

	public BlockMetalStructure(String name, Material materialIn) 
	{
		super(name, materialIn);
	}
	
	@Override
	public void onBlockClicked(World world, BlockPos pos, EntityPlayer player)
	{
		TileEntity t;
		if((t = world.getTileEntity(pos)) != null)
		{
			if(t instanceof TileEntityMultiblockBase)
			{
				TileEntityMultiblockBase te = (TileEntityMultiblockBase) t;
				TileEntityMultiblockBrain temb = te.getBrain();
				System.out.println(temb.getName());
			}
		}
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileEntityMultiblockBase();
	}
	
}
