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
package forestry.core.genetics;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Locale;

import forestry.api.genetics.IClassification;
import forestry.api.genetics.alleles.AlleleManager;
import forestry.api.genetics.alleles.IAlleleSpeciesForestry;
import forestry.core.utils.Translator;

public class Classification implements IClassification {

	private final EnumClassLevel level;
	private final String uid;
	private final String scientific;
	@Nullable
	private IClassification parent;

	private final ArrayList<IAlleleSpeciesForestry> members = new ArrayList<>();
	private final ArrayList<IClassification> groups = new ArrayList<>();

	public Classification(EnumClassLevel level, String uid, String scientific) {
		this.level = level;
		this.uid = level.name().toLowerCase(Locale.ENGLISH) + "." + uid;
		this.scientific = scientific;
		AlleleManager.alleleRegistry.registerClassification(this);
	}

	@Override
	public EnumClassLevel getLevel() {
		return level;
	}

	@Override
	public String getUID() {
		return uid;
	}

	@Override
	@Nullable
	public IClassification getParent() {
		return parent;
	}

	@Override
	public void setParent(IClassification parent) {
		this.parent = parent;
	}

	@Override
	public String getScientific() {
		return this.scientific;
	}

	@Override
	public String getName() {
		return Translator.translateToLocal("for." + uid);
	}

	@Override
	public String getDescription() {
		return Translator.translateToLocal("for." + uid + ".description");
	}

	@Override
	public IClassification[] getMemberGroups() {
		return groups.toArray(new IClassification[groups.size()]);
	}

	@Override
	public void addMemberGroup(IClassification group) {
		groups.add(group);
		group.setParent(this);
	}

	@Override
	public IAlleleSpeciesForestry[] getMemberSpecies() {
		return members.toArray(new IAlleleSpeciesForestry[members.size()]);
	}

	@Override
	public void addMemberSpecies(IAlleleSpeciesForestry species) {
		members.add(species);
	}

}
