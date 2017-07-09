package wilby.argh.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ArghEvents 
{
	
	@SubscribeEvent
	public void onLivingJump(LivingJumpEvent event)
	{
		if(event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			if(player.isSneaking() && player.getName().equalsIgnoreCase("queserah"))
			{
				player.addVelocity(0, .5d, 0);
			}
		}
	}
	
	@SubscribeEvent
	public void createMultiblock(BlockEvent.PlaceEvent e)
	{
		if(ArghMultiblock.isMultiblock("smeltery", e.getWorld(), e.getPos()))
		{
			
		}
	}
	
}
