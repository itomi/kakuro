package org.itomi.kakuro.gen;

import java.util.Random;

import org.itomi.kakuro.model.KakuroInstance;
import org.itomi.kakuro.model.fields.Field;
import org.itomi.kakuro.model.grid.Grid;

/**
 * 
 * Generator ktory generuje kakuro o wielkosci maksymalnie 10x10 ( razem z definicjami sum ), 
 * jego dzialanie polega na zapelnieniu planczy losowymi liczbami i usuwanie losowych pol z owej planszy do
 * momentu uzyskania wymaganej gestosci.
 * 
 * @author Karol Kulesza
 *
 */
public class SusbtractingGenerator implements GeneratorInterface {
	
	private int x;
	private int y;
	private int percentage;
	
	public SusbtractingGenerator(int x, int y, int percentage) {
		this.x=x%10;
		this.y=y%10;		
	}
	
	@Override
	public KakuroInstance generate(Long seed) {
		Random rand = new Random(seed);
		KakuroInstance instance = new KakuroInstance(x, y);
		Field field;
		
		fillGridWithPseudoRandomData(instance);
		
		while(!percentageSatisfied(instance, percentage)) {
			field = removeRandomField(instance, rand);
			updateSums(instance, field);
		}
		
		
		return instance;
	}

	private void fillGridWithPseudoRandomData(KakuroInstance instance) {
		Grid grid = instance.getGrid();
		//set upper band to sum fields
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
