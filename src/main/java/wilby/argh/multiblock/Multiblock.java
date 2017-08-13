package wilby.argh.multiblock;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import wilby.argh.util.ArghLoader;

public class Multiblock implements IMultiblock 
{
	
	public static ArrayList<Multiblock> multiblockList = new ArrayList<Multiblock>();
	
	public static Multiblock instance_miner = new MultiblockMiner("miner");
	public static Multiblock instance_smeltery = new MultiblockSmeltery("smeltery");
	public static Multiblock instance_bricker = new MultiblockBricker("bricker");
	
	static 
	{
		multiblockList.add(instance_bricker);
		multiblockList.add(instance_miner);
		multiblockList.add(instance_smeltery);
	}
	
	private ItemStack[][][] structure;
	
	private int sizeX, sizeY, sizeZ;
	
	private String name;
	
	public Multiblock(String name)
	{
		Object[] attributes = ArghLoader.loadStructure(name);
		
		structure = (ItemStack[][][]) attributes[0];
		sizeX = (Integer) attributes[1];
		sizeY = (Integer) attributes[2];
		sizeZ = (Integer) attributes[3];
		
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public void addToWorld(World world, BlockPos pos, EntityPlayer player) 
	{
		
	}
	
	@Override
	public boolean createMultiblock(World world, BlockPos pos, EnumFacing side, EntityPlayer player) 
	{
		
		side = side.getOpposite();
		if(side == EnumFacing.UP || side == EnumFacing.DOWN)
		{
			side = EnumFacing.fromAngle(player.rotationYaw);
		}
		
		boolean a;
		
		for(int i = 0; i < sizeY; i++)
		{
			BlockPos nextPos = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
			
			a = structureCheck(world, nextPos, side, false);
			
			if(a)
			{
				addToWorld(world, nextPos, player);
				return true;
			}
			else if(a = structureCheck(world, nextPos, side, false))
			{
				addToWorld(world, nextPos, player);
				return true;
			}
			else
			{
				
			}
		}
		
		return false;
	}

	@Override
	public boolean structureCheck(World world, BlockPos pos, EnumFacing facing, boolean mirror) 
	{
		for(int y = 0; y < sizeY; y++)
		{
			for(int x = 0; x < sizeX; x++)
			{
				for(int z = 0; z < sizeZ; z++)
				{
					
					int z1 = mirror? -z : z;
					
					BlockPos nextPos = pos.offset(facing, 0).offset(facing.rotateY(), z1).add(0, y, 0); 
					
					ItemStack a = new ItemStack(Item.getItemFromBlock(world.getBlockState(nextPos).getBlock()));
					
					if(!ItemStack.areItemsEqual(a, structure[x][y][z]))
					{
						return false;
					}
				}
			}
		}
		
		return true;
	}

	@Override
	public ItemStack[][][] getStructure() 
	{
		return structure;
	}
	
}
