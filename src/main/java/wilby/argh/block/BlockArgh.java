package wilby.argh.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockArgh extends Block 
{

	private String name;
	
	public BlockArgh(String name, Material materialIn) 
	{
		super(materialIn);
		this.name = name;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	public String getName()
	{
		return this.name;
	}

}
