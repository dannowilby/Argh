package wilby.argh.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import wilby.argh.multiblock.ArghTileEntities;

public class BlockContainerArgh extends BlockContainer
{
	
	private String name;
	private String id;
	
	public BlockContainerArgh(String name, String tileEntity, Material materialIn) 
	{
		super(materialIn);
		this.name = name;
		this.id = tileEntity;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return ArghTileEntities.getTileEntity(id);
	}
	
	public String getName()
	{
		return this.name;
	}

}
