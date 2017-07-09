package org.wilby.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

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
	
	public String getName()
	{
		return this.name;
	}

}
