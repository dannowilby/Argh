package lib.manual;

import net.minecraft.item.Item;

public class ManualItemPage implements IManualPage
{

	private String name;
	private String info;
	
	private Item item;
	
	public ManualItemPage(String name, String info, Item item)
	{
		this.name = name;
		this.info = info;
		
		this.item = item;
	}
	
	@Override
	public void render() 
	{
		
	}

	@Override
	public String getName() 
	{
		return this.name;
	}

}
