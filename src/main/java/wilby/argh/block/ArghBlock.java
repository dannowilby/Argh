package wilby.argh.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import wilby.argh.item.ArghItems;
import wilby.argh.multiblock.tileentity.ArghTileEntityMultiblock;
import wilby.argh.util.ArghLogger;

public class ArghBlock extends Block
{

	private String name;
	
	public ArghBlock(String name, Material materialIn) 
	{
		super(materialIn);
		this.name = name;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	@Override
	public void onBlockClicked(World world, BlockPos pos, EntityPlayer player)
	{
		if(player.getActiveItemStack().getItem().equals(ArghItems.hammer))
		{
			System.out.println("Hammer Time!");
		}
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return false;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return null;
	}
	
	public String getName()
	{
		return this.name;
	}
	
}
