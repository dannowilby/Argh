package wilby.argh.item;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import wilby.argh.Argh;
import wilby.argh.block.ArghBlocks;

@ObjectHolder(Argh.MODID)
public class ArghItems 
{
	
	public static ArghItem hammer = new ItemHammer("hammer");
	
	@Mod.EventBusSubscriber(modid = Argh.MODID)
	public static class RegistrationHandler {
		public static final Set<Item> ITEMS = new HashSet<>();
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			final Item[] items = {
					hammer
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Item item : items) {
				registry.register(item);
				ITEMS.add(item);
			}
			
			ModelLoader.setCustomModelResourceLocation(hammer, 0, new ModelResourceLocation(hammer.getRegistryName(), "inventory"));
			
		}
	}
	
}
