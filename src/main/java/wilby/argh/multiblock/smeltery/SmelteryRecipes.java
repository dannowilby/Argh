package wilby.argh.multiblock.smeltery;

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
	
	private Map<Item, ItemStack> smeltList = new HashMap<Item, ItemStack>();
	private Map<Item, Float> xpList = new HashMap<Item, Float>();
	
	public static SmelteryRecipes getInstance()
	{
		return SMELTING_BASE;
	}
	
	public SmelteryRecipes()
	{
		addRecipe(Item.getItemFromBlock(Blocks.IRON_ORE), new ItemStack(Items.IRON_INGOT, 3), 1.0f);
		addRecipe(Item.getItemFromBlock(Blocks.GOLD_ORE), new ItemStack(Items.GOLD_INGOT, 3), 1.0f);
        addRecipe(Item.getItemFromBlock(Blocks.DIAMOND_ORE), new ItemStack(Items.DIAMOND, 2), 1.0F);
		addRecipe(Item.getItemFromBlock(Blocks.COAL_ORE), new ItemStack(Items.COAL, 2), 1.0F);
        addRecipe(Item.getItemFromBlock(Blocks.REDSTONE_ORE), new ItemStack(Items.REDSTONE, 4), 1.0F);
        addRecipe(Item.getItemFromBlock(Blocks.LAPIS_ORE), new ItemStack(Items.DYE, 4, EnumDyeColor.BLUE.getDyeDamage()), 1.0F);
        addRecipe(Item.getItemFromBlock(Blocks.QUARTZ_ORE), new ItemStack(Items.QUARTZ, 4), 1.0F);
	}
	
	public void addRecipe(Item in, ItemStack out, float xp)
	{
		smeltList.put(in, out);
		xpList.put(in, xp);
	}
	
	public ItemStack getSmeltingResult(Item in)
	{
		return smeltList.get(in);
	}
	
	public Float getXpResult(ItemStack in)
	{
		return xpList.get(in.toString());
	}
	
	public Map<Item, ItemStack> getSmeltList()
	{
		return smeltList;
	}
	
}
