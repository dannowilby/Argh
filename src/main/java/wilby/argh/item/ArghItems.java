package wilby.argh.item;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import wilby.argh.Argh;

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
		}
	}
	
}
