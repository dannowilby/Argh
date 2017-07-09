package wilby.argh.common.blocks.decoration;

import net.minecraft.block.material.Material;
import wilby.argh.common.blocks.BlockArghDecoration;

public class BlockMarbleLamp extends BlockArghDecoration {

	public BlockMarbleLamp(String name, Material materialIn) {
		super(name, materialIn);
		this.setLightLevel(1.0f);
	}

}
