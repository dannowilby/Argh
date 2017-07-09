package wilby.argh.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockEvents 
{
	
	@SubscribeEvent
	public void onLivingJump(LivingJumpEvent event)
	{
		if(event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			if(player.isSneaking())
			{
				player.addVelocity(0, 1.0d, 0);
				player.cameraPitch = 0;
				player.cameraYaw = 0;
			}
		}
	}
	
	@SubscribeEvent
	public void createMultiblock(BlockEvent.PlaceEvent e)
	{
		System.out.println("argh");
		if(Block.isEqualTo(e.getPlacedBlock().getBlock(), Blocks.marbleBrick))
		{
			System.out.println("nice choice in block!");
		}
	}
	
}
