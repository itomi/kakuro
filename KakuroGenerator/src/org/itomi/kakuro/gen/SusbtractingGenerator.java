package org.itomi.kakuro.gen;

import java.util.Random;
import java.util.Set;

import org.itomi.kakuro.annotations.Substracting;
import org.itomi.kakuro.configuration.Configuration;
import org.itomi.kakuro.model.KakuroInstance;
import org.itomi.kakuro.model.fields.Field;
import org.itomi.kakuro.model.fields.ValueField;
import org.itomi.kakuro.model.grid.FieldBoundaryException;
import org.itomi.kakuro.model.grid.Grid;

import com.google.common.collect.Sets;

/**
 * 
 * Generator ktory generuje kakuro o wielkosci maksymalnie 10x10 ( razem z definicjami sum ), 
 * jego dzialanie polega na zapelnieniu planczy losowymi liczbami i usuwanie losowych pol z owej planszy do
 * momentu uzyskania wymaganej gestosci.
 * 
 * @author Karol Kulesza
 *
 */
@Substracting
public class SusbtractingGenerator implements Generator {
	
	private static final Set<Integer> allowedValues = Sets.newHashSet(1,2,3,4,5,6,7,9);
	
	private int x;
	private int y;
	private int percentage;
	
	public SusbtractingGenerator(int x, int y, int percentage) {
		this.x=x%11;
		this.y=y%11;		
	}
	
	@Override
	public KakuroInstance generate(Long seed, Configuration configuration) throws FieldBoundaryException {
		Random rand = new Random(seed);
		KakuroInstance instance = new KakuroInstance(x, y);
		Field field;
		
		fillGridWithPseudoRandomData(instance, rand);
		
		while(!percentageSatisfied(instance, percentage)) {
			field = removeRandomField(instance, rand);
			updateSums(instance, field);
		}
		
		
		return instance;
	}

	private void fillGridWithPseudoRandomData(KakuroInstance instance, Random rand) throws FieldBoundaryException {
		Grid grid = instance.getGrid();
		for(int i = 1 ; i < instance.getHorizontalLength()-1 ; i++ ) {
			for(int j = 1 ; j < instance.getVerticalLength()-1 ; j ++ ) {
				ValueField field = new ValueField(i,j);
				Set<Integer> takenValues = getTakenValues(instance, i,j);
				Integer value = randomizeValueWithRestrictedOnes(takenValues,rand);
				field.setValue(value);
				grid.setField(i, j, field);
			}
		}
	}

	private Integer randomizeValueWithRestrictedOnes(Set<Integer> takenValues,
			Random rand) {
		// TODO Auto-generated method stub
		return null;
	}

	private Set<Integer> getTakenValues(KakuroInstance instance, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	private void updateSums(KakuroInstance instance, Field field) {
		// TODO Auto-generated method stub
		
	}

	private Field removeRandomField(KakuroInstance instance, Random rand) {
		Grid grid = instance.getGrid();
		

		
		return null;
	}

	private boolean percentageSatisfied(KakuroInstance instance, int percentage2) {
		// TODO Auto-generated method stub
		return false;
	}

}
