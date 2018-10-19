package forestry.api.gui;

import javax.annotation.Nullable;
import java.util.function.BiFunction;
import java.util.function.Function;

import forestry.api.genetics.IAllele;
import forestry.api.genetics.IBreedingTracker;
import forestry.api.genetics.IChromosomeType;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.IIndividualForestry;
import forestry.api.genetics.IMutation;
import forestry.api.genetics.gaget.DatabaseMode;
import forestry.api.gui.style.ITextStyle;

public interface IDatabaseElement extends IElementLayout {

	/**
	 * Adds the chromosomeName and the name of the active/not active allele, of the chromosome, with {@link #label}.
	 */
	void addLine(String chromosomeName, IChromosomeType chromosome);

	/**
	 * Adds the chromosomeName and the result of toString with {@link #label}.
	 */
	<A extends IAllele> void addLine(String chromosomeName, BiFunction<A, Boolean, String> toText, IChromosomeType chromosome);

	<A extends IAllele> void addLine(String chromosomeName, BiFunction<A, Boolean, String> toText, IChromosomeType chromosome, boolean dominant);

	void addLine(String leftText, Function<Boolean, String> toText, IChromosomeType chromosome);

	void addLine(String firstText, String secondText, ITextStyle firstStyle, ITextStyle secondStyle);

	void addLine(String leftText, String rightText, boolean dominant);

	void addLine(String leftText, Function<Boolean, String> toText, boolean dominant);

	void addFertilityLine(String chromosomeName, IChromosomeType chromosome, int texOffset);

	void addToleranceLine(IChromosomeType chromosome);

	void addMutation(int x, int y, int width, int height, IMutation mutation, IAllele species, IBreedingTracker breedingTracker);

	void addMutationResultant(int x, int y, int width, int height, IMutation mutation, IBreedingTracker breedingTracker);

	//void addRow(String firstText, String secondText, String thirdText, ITextStyle firstStyle, ITextStyle secondStyle, ITextStyle thirdStyle);


	//void addRow(String firstText, String secondText, String thirdText, boolean secondDominant, boolean thirdDominant);

	//void addRow(String firstText, String secondText, String thirdText, IIndividual individual, IChromosomeType chromosome);

	void addSpeciesLine(String firstText, @Nullable String secondText, IChromosomeType chromosome);

	void init(DatabaseMode mode, IIndividualForestry individual, int secondColumn, int thirdColumn);

	@Nullable
	IIndividualForestry getIndividual();

	IGenome getGenome();

	//void addSpeciesLine(String firstText, @Nullable String secondText, @Nullable String thirdText, IIndividual individual, IChromosomeType chromosome);
}
