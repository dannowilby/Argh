package zwilby.argh.multiblock.smeltery;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import wilby.argh.multiblock.tileentity.TileEntitySmeltery;

public class GuiSmeltery extends GuiContainer
{
	
	private ResourceLocation guipng = new ResourceLocation("argh:textures/gui/smeltery.png");
	private TileEntitySmeltery tes;
	private IInventory player;
	
	public GuiSmeltery(IInventory playerInv, TileEntitySmeltery te) 
	{
        super(new ContainerSmeltery(playerInv, te));
        
        this.tes = te;
        this.player = playerInv;
        
    }
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) 
	{
	    this.drawDefaultBackground();
	    super.drawScreen(mouseX, mouseY, partialTicks);
	    this.renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	public boolean doesGuiPauseGame() 
	{
	    return false;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }
	
	@Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(guipng);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        
    }
}
