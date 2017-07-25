package wilby.argh.common;

import net.minecraft.block.Block;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
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
	
	private boolean isMenuBlock(Block b) {
		return Block.isEqualTo(b, Blocks.BRICK_BLOCK) || Block.isEqualTo(b, ArghBlocks.blastbrick); 
	}
	
	private Block toBlock(PlayerInteractEvent.RightClickBlock rcb) {
		return rcb.getWorld().getBlockState(rcb.getPos()).getBlock();
	}
	
	@SubscribeEvent
	public void interactMultiblock(PlayerInteractEvent.RightClickBlock rcb)
	{
		Block block = this.toBlock(rcb); 
		
		if(this.isMenuBlock(block))
		{
			TileEntitySmeltery tes = (TileEntitySmeltery) ArghMultiblock.getPartMultiblock(rcb.getPos());
			if(tes != null && !rcb.getWorld().isRemote)
			{
				rcb.getEntityPlayer().openGui(Argh.argh, ArghGuiHandler.smeltery, rcb.getWorld(), rcb.getPos().getX(), rcb.getPos().getY(), rcb.getPos().getZ());
				rcb.setCanceled(true);
			}
		}
	}
	
}
