package wilby.argh.common;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wilby.argh.multiblock.TileEntityMultiblock;

public class ArghEvents 
{
	
	@SubscribeEvent
	public void onLivingJump(LivingJumpEvent event)
	{	
		if(event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			KeyBinding k = new KeyBinding("argh", 19, "what");
			if(player.getName().equalsIgnoreCase("queserah") && GameSettings.isKeyDown(k))
			{
				player.addVelocity(0, .5d, 0);
			}
		}
	}
	
	@SubscribeEvent
	public void interactMultiblock(PlayerInteractEvent e)
	{
		if(e.getWorld().getTileEntity(e.getPos()) instanceof TileEntityMultiblock)
		{
			TileEntityMultiblock temb = (TileEntityMultiblock) e.getWorld().getTileEntity(e.getPos());
			System.out.println("Is tile entity multiblock" + temb.toString());
		}
	}
	
}
