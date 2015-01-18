/*******************************************************************************
 * Copyright (c) 2011-2014 SirSengir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Various Contributors including, but not limited to:
 * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges
 ******************************************************************************/
package forestry.arboriculture.worldgen;

import forestry.api.world.ITreeGenData;
import forestry.core.worldgen.BlockType;
import net.minecraft.init.Blocks;

public class WorldGenBirch extends WorldGenTree {

	public WorldGenBirch(ITreeGenData tree) {
		super(tree);
	}

	@Override
	public BlockType getWood() {
		return new BlockType(Blocks.log, 2);
	}

}
