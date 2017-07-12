package wilby.argh.block;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import wilby.argh.Argh;

@ObjectHolder(Argh.MODID)
public class ArghBlocks 
{
	
	public static Map<String, Block> modRegistry = new HashMap<String, Block>();
	
	public static BlockArgh marble;
	public static BlockArgh marbleBrick;
	public static BlockArgh blastbrick;
	public static BlockArgh marbleLamp;
	
	public static BlockContainerArgh smelteryVent;
	
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
		else
			return null;
	}
	
	@Mod.EventBusSubscriber(modid = Argh.MODID)
	public static class RegistrationHandler {
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

		/**
		 * Register this mod's {@link Block}s.
		 *
		 * @param event The event
		 */
		
		public static void registerModels(ModelRegistryEvent event)
		{
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(marbleBrick), 0, new ModelResourceLocation(marbleBrick.getRegistryName(), "inventory"));
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			final IForgeRegistry<Block> registry = event.getRegistry();
			
			String marbleBlock = "marble";
			modRegistry.put(marbleBlock, (marble = new BlockArgh(marbleBlock, Material.ROCK)));
			
			String marbleBrickBlock = "marblebrick";
			modRegistry.put(marbleBrickBlock, (marbleBrick  = new BlockArgh(marbleBrickBlock, Material.ROCK)));
			
			String marblelampBlock = "marblelamp";
			modRegistry.put(marblelampBlock, (marbleLamp  = new BlockArgh(marblelampBlock, Material.CIRCUITS)).setLightLevel(.9f));
			
			String smelteryVentBlock = "smelteryvent";
			modRegistry.put(smelteryVentBlock, (smelteryVent = new BlockArghSmeltery(smelteryVentBlock, "smeltery", Material.IRON)));
			
			String blastbrickBlock = "blastbrick";
			modRegistry.put(blastbrickBlock, (blastbrick = new BlockArgh(blastbrickBlock, Material.IRON)));
			
			final Block[] blocks = {
					marble,
					marbleBrick,
					marbleLamp,
					blastbrick,
					smelteryVent
			};

			registry.registerAll(blocks);
			
		}
		
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			final ItemBlock[] items = {
					new ItemBlock(marble),
					new ItemBlock(marbleBrick),
					new ItemBlock(marbleLamp),
					new ItemBlock(smelteryVent),
					new ItemBlock(blastbrick)
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final ItemBlock item : items) {
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}
			
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ArghBlocks.smelteryVent), 0, new ModelResourceLocation(ArghBlocks.smelteryVent.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ArghBlocks.blastbrick), 0, new ModelResourceLocation(ArghBlocks.blastbrick.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ArghBlocks.marble), 0, new ModelResourceLocation(ArghBlocks.marble.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ArghBlocks.marbleBrick), 0, new ModelResourceLocation(ArghBlocks.marbleBrick.getRegistryName(), "inventory"));
			
		}
	}

	public static boolean isModBlock(Block placedBlock) 
	{
		String[] i = ResourceLocation.splitObjectName(placedBlock.getRegistryName().toString());
		if(modRegistry.containsKey(i[1]))
			return true;
		return false;
	}
		
	
}
