package wilby.argh.block;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import wilby.argh.Argh;
import wilby.argh.block.multiblock.BlockBlastBrick;
import wilby.argh.block.multiblock.BlockMarble;
import wilby.argh.block.multiblock.BlockMarbleBrick;
import wilby.argh.block.multiblock.BlockMetalStructure;
import wilby.argh.block.multiblock.BlockSmeltery;

@ObjectHolder(Argh.MODID)
public class ArghBlocks 
{
	public static ArghBlock marble = new BlockMarble("marble", Material.ROCK);
	public static ArghBlock marbleBrick = new BlockMarbleBrick("marblebrick", Material.ROCK);
	public static ArghBlock blastbrick = new BlockBlastBrick("blastbrick", Material.ROCK);
	public static ArghBlock metalStructure = new BlockMetalStructure("metalstructure", Material.IRON);
	public static ArghBlock smelteryVent = new BlockSmeltery("smelteryvent", Material.IRON);
	
	public static Block getBlockFromId(String id)
	{
		if(id.matches("a0"))
			return marbleBrick;
		if(id.matches("a1"))
			return marble;
		if(id.matches("a2"))
			return blastbrick;
		if(id.matches("a3"))
			return smelteryVent;
		if(id.matches("a4"))
			return metalStructure;
		else
			return null;
	}
	
	@Mod.EventBusSubscriber(modid = Argh.MODID)
	public static class RegistrationHandler 
	{
		
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) 
		{
			final IForgeRegistry<Block> registry = event.getRegistry();
			
			final Block[] blocks = 
			{
					marble,
					marbleBrick,
					blastbrick,
					metalStructure,
					smelteryVent
			};

			registry.registerAll(blocks);
			
		}
		
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) 
		{
			final ItemBlock[] items = 
				{
					new ItemBlock(marble),
					new ItemBlock(marbleBrick),
					new ItemBlock(smelteryVent),
					new ItemBlock(metalStructure),
					new ItemBlock(blastbrick)
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final ItemBlock item : items) 
			{
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}
			
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ArghBlocks.smelteryVent), 0, new ModelResourceLocation(ArghBlocks.smelteryVent.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ArghBlocks.blastbrick), 0, new ModelResourceLocation(ArghBlocks.blastbrick.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ArghBlocks.marble), 0, new ModelResourceLocation(ArghBlocks.marble.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ArghBlocks.marbleBrick), 0, new ModelResourceLocation(ArghBlocks.marbleBrick.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ArghBlocks.metalStructure), 0, new ModelResourceLocation(ArghBlocks.metalStructure.getRegistryName(), "inventory"));			
		}
	}	
	
}
