package wilby.argh.multiblock.smeltery;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;

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
        String s = this.tes.getRenderName();
        this.fontRenderer.drawString(s, 8, 6, 4210752);
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
        
        if (TileEntitySmeltery.isBurning(this.tes))
        {
            int k = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(i + 105, j + 55 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(i + 99, j + 35, 176, 14, l + 1, 16);
    }
	
	private int getCookProgressScaled(int pixels)
    {
		int i = this.tes.getField(0);
        return i * pixels / this.tes.getTotalCookTime();
    }

    private int getBurnLeftScaled(int pixels)
    {
        int i = this.tes.getField(1);
        return i * pixels / this.tes.getTotalBurnTime();
    }
}
