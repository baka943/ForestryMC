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
package forestry.factory.gui;

import forestry.core.config.Defaults;
import forestry.core.gui.GuiForestryTitled;
import forestry.core.gui.widgets.TankWidget;
import forestry.factory.gadgets.MachineMoistener;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiMoistener extends GuiForestryTitled<MachineMoistener> {

	public GuiMoistener(InventoryPlayer inventory, MachineMoistener tile) {
		super(Defaults.TEXTURE_PATH_GUI + "/moistener.png", new ContainerMoistener(inventory, tile), tile);
		widgetManager.add(new TankWidget(this.widgetManager, 16, 16, 0));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int mouseX, int mouseY) {
		super.drawGuiContainerBackgroundLayer(var1, mouseX, mouseY);
		MachineMoistener machine = tile;

		// Mycelium production progress
		if (machine.isProducing()) {
			int i1 = machine.getProductionProgressScaled(16);
			drawTexturedModalRect(guiLeft + 124, guiTop + 36, 176, 74, 16 - i1, 16);
		}

		// Resource consumption progress
		if (machine.isWorking()) {
			int i1 = machine.getConsumptionProgressScaled(54);
			drawTexturedModalRect(guiLeft + 93, guiTop + 18 + i1, 176, 92 + i1, 29, 54 - i1);
		}
	}

}
