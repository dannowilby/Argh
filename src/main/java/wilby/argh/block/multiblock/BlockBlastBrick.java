package wilby.argh.block.multiblock;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import wilby.argh.block.ArghBlock;
import wilby.argh.multiblock.tileentity.TileEntityComponent;

public class BlockBlastBrick extends ArghBlock 
{

	public BlockBlastBrick(String name, Material materialIn) 
	{
		super(name, materialIn);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileEntityComponent();
	}

}
