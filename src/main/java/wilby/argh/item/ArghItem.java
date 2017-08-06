package wilby.argh.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ArghItem extends Item
{
	
	private String name;
	
	public String getName()
	{
		return name;
	}
	
	public ArghItem(String name)
	{
		super();
		this.name = name;
		this.setCreativeTab(CreativeTabs.MATERIALS);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
}
