package org.wilby;

import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Argh.MODID)
public class ArghEvents 
{
	
	@SubscribeEvent
	public void genMarble(ChunkEvent.Load e)
	{
		System.out.println("argh");
	}
	
}
