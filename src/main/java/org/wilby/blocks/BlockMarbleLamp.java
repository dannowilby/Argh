package org.wilby.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMarbleLamp extends ArghBlock {

	public BlockMarbleLamp(String name, Material materialIn) {
		super(name, materialIn);
		this.setLightLevel(1.0f);
	}

}
