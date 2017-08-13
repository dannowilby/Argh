package wilby.argh.common;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import wilby.argh.item.ArghItems;
import wilby.argh.multiblock.Multiblock;
import wilby.argh.multiblock.MultiblockMiner;
import wilby.argh.util.ArghLogger;

public class ArghEvents 
{
	
	public KeyBinding k = new KeyBinding("Who knows?", 19, "Arghmod-3");
	
	@SubscribeEvent
	public void onLivingJump(LivingJumpEvent event)
	{	
		if(event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			
			if(player.getName().equalsIgnoreCase("queserah") && GameSettings.isKeyDown(k))
			{
				player.addVelocity(0, .5d, 0);
			}
		}
	}
	
	@SubscribeEvent
	public void interactMultiblock(PlayerInteractEvent.RightClickBlock rcb)
	{
		if(rcb.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND).getItem().getRegistryName() == (ArghItems.hammer.getRegistryName()))
		{
			Multiblock.multiblockList.forEach((m) -> 
			{
				boolean t = m.createMultiblock(rcb.getWorld(), rcb.getPos(), rcb.getFace(), rcb.getEntityPlayer());
				
				if(t)
				{
					ArghLogger.log(m.getName());
					return;
				}
			});
		}
	}
	
}
