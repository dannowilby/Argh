package wilby.argh.common;

import net.minecraft.block.Block;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wilby.argh.Argh;
import wilby.argh.block.ArghBlocks;
import wilby.argh.multiblock.ArghMultiblock;
import wilby.argh.multiblock.smeltery.TileEntitySmeltery;

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
	public void interactMultiblock(PlayerInteractEvent.RightClickBlock e)
	{
		Block b = e.getWorld().getBlockState(e.getPos()).getBlock();
		
		if(Block.isEqualTo(b, Blocks.BRICK_BLOCK) || Block.isEqualTo(b, ArghBlocks.blastbrick))
		{
			TileEntitySmeltery tes = (TileEntitySmeltery) ArghMultiblock.getPartMultiblock(e.getPos());
			if(tes != null && !e.getWorld().isRemote)
			{
				e.getEntityPlayer().openGui(Argh.argh, ArghGuiHandler.smeltery, e.getWorld(), e.getPos().getX(), e.getPos().getY(), e.getPos().getZ());
			}
		}
	}
	
}
