package wilby.argh.block.multiblock;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import wilby.argh.block.ArghBlock;
import wilby.argh.multiblock.tileentity.TileEntitySmeltery;

public class BlockSmeltery extends ArghBlock 
{

	public BlockSmeltery(String name, Material materialIn) 
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
		return new TileEntitySmeltery();
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		return new AxisAlignedBB(0, .875d, 0, 1, 1, 1);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return new AxisAlignedBB(0, .875d, 0, 1, 1, 1);
	}
	
	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
	{
		return new AxisAlignedBB(pos.getX(), pos.getY() + .875d, pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1);
	}
	
	@Override
	public boolean isBlockNormalCube(IBlockState state)
	{
		return false;
	}
	
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState ibs)
	{
		return EnumBlockRenderType.MODEL;
	}
	
}
