package lib.manual;

import net.minecraft.item.ItemStack;

public class ManualMultiblockPage implements IManualPage
{

	private ItemStack[][][] structure;
	
	private String name;
	private String info;
	
	private int cubes;
	private int maxCubes;
	
	public ManualMultiblockPage(String name, String info, ItemStack[][][] structure)
	{
		this.structure = structure;
		
		this.name = name;
		this.info = info;
		
		this.maxCubes = structure.length;
		this.cubes = 0;
	}
	
	@Override
	public void render() 
	{
		
	}

	@Override
	public String getName() 
	{
		return name;
	}
	
	public void showNextCube()
	{
		cubes++;
	}
	
}
