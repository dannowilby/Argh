package wilby.argh.common.blocks;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import wilby.argh.Argh;
import wilby.argh.common.blocks.decoration.BlockMarble;
import wilby.argh.common.blocks.decoration.BlockMarbleBrick;
import wilby.argh.common.blocks.decoration.BlockMarbleLamp;

@ObjectHolder(Argh.MODID)
public class ArghBlocks 
{
	
	public static final Block marble = new BlockMarble("marble", Material.ROCK);
	public static final Block marbleBrick = new BlockMarbleBrick("marblebrick", Material.ROCK);
	public static final Block marbleLamp = new BlockMarbleLamp("marblelamp", Material.CIRCUITS);
	
	public static Block getBlockFromId(String id)
	{
		if(id.matches("a0"))
			return marbleBrick;
		if(id.matches("a1"))
			return marble;
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
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			final IForgeRegistry<Block> registry = event.getRegistry();

			final Block[] blocks = {
					marble,
					marbleBrick,
					marbleLamp,
			};

			registry.registerAll(blocks);

		}
		
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			final ItemBlock[] items = {
					new ItemBlock(marble),
					new ItemBlock(marbleBrick),
					new ItemBlock(marbleLamp),
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final ItemBlock item : items) {
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}

		}
	}
		
	
}
