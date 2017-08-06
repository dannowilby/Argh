package zwilby.argh.multiblock.smeltery;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class SmelteryRecipes 
{
	
	private static final SmelteryRecipes SMELTING_BASE = new SmelteryRecipes();
	
	private Map<Item, Integer> smeltList = new HashMap<Item, Integer>();
	private Map<Item, Item> itemList = new HashMap<Item, Item>();
	private Map<Item, Float> xpList = new HashMap<Item, Float>();
	
	public static SmelteryRecipes getInstance()
	{
		return SMELTING_BASE;
	}
	
	public SmelteryRecipes()
	{
		addRecipe(Item.getItemFromBlock(Blocks.IRON_ORE), Items.IRON_INGOT, 3, 1.0f);
		addRecipe(Item.getItemFromBlock(Blocks.GOLD_ORE), Items.GOLD_INGOT, 3, 1.0f);
        addRecipe(Item.getItemFromBlock(Blocks.DIAMOND_ORE), Items.DIAMOND, 2, 1.0F);
		addRecipe(Item.getItemFromBlock(Blocks.COAL_ORE), Items.COAL, 2, 1.0F);
        addRecipe(Item.getItemFromBlock(Blocks.REDSTONE_ORE), Items.REDSTONE, 4, 1.0F);
        addRecipe(Item.getItemFromBlock(Blocks.QUARTZ_ORE),Items.QUARTZ, 4, 1.0F);
	}
	
	public void addRecipe(Item in, Item out, int amount, float xp)
	{
		smeltList.put(in, amount);
		itemList.put(in, out);
		xpList.put(in, xp);
	}
	
	public ItemStack getSmeltingResult(ItemStack in)
	{
		if(itemList.containsKey(in.getItem()))
			return new ItemStack(itemList.get(in.getItem()), smeltList.get(in.getItem()));
		return null;
	}
	
	public Float getXpResult(ItemStack in)
	{
		return xpList.get(in.toString());
	}
}
