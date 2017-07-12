package wilby.argh.multiblock;

import java.util.ArrayList;

import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public interface IMultiblock extends ITickable
{
	@Override
	void update();
	
	boolean isFullMultiblock();
	
	boolean isMultiblockPart(BlockPos bp);
	
	boolean isMaster();
	
	ArrayList<BlockPos> getMultiblockPartsList();
	
	void setMultiblockPartsList(ArrayList<BlockPos> bp);
	
	void birthChildren();
	
	void deleteChildren();
}
