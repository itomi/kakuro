package org.itomi.kakuro.gen;

import java.util.Observable;
import java.util.Random;

import org.itomi.kakuro.model.KakuroInstance;
import org.itomi.kakuro.model.fields.ValueField;

/**
 * 
 * Klasa odpowiedzialna za generacje instancji krzyzowki kakuro z zadanymi parametrami.
 * 
 * @author Karol Kulesza
 *
 */
public class TraversingGenerator extends Observable implements GeneratorInterface {
	
	private int horizontalLength;
	private int verticalLength;

	/**
	 * Tworzy generator z podanymi wartosciami odzwierciedlajacymi wielkosc instancji.
	 * @param x
	 * 		pozioma dlugosc matrycy instancji
	 * @param y
	 * 		pionowa dlugosc matrycy instancji
	 */
	public TraversingGenerator(int x, int y) {
		this.horizontalLength = x;
		this.verticalLength = y;
		}
	
	/**
	 * Generuje instancje problemu kakuro z podanego ziarna
	 * 
	 * @param seed
	 * 		ziarno ktore uzywane jest do zainicjalizowania pola startowego i startowej liczby
	 * @return
	 */
	public KakuroInstance generate(final Long seed) {
		Random random = new Random(seed);
		KakuroInstance instance = new KakuroInstance(horizontalLength, verticalLength);
		
		int currentValue = (random.nextInt(9) + 1);
		ValueField currentField = initializeField(instance);
		
		
		while(!instanceIsReady(instance)) {
			ValueField field = pickPlaceToCreateValue(instance);
			
			if(fieldIsAssignable(field)) {
				assignTheValue(field);
				updateSums(field);
			} else {
				
			}
			notifyObservers(this);
		}
		
		
		return instance;
	}

	private void updateSums(ValueField field) {
		// TODO Auto-generated method stub
		
	}

	private void assignTheValue(ValueField field) {
		// TODO Auto-generated method stub
		
	}

	private boolean fieldIsAssignable(ValueField field) {
		// TODO Auto-generated method stub
		return false;
	}

	private ValueField initializeField(KakuroInstance instance) {
		// TODO Auto-generated method stub
		return null;
	}

	private ValueField pickPlaceToCreateValue(KakuroInstance instance) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean instanceIsReady(KakuroInstance instance) {
		return false;
	}
}
