package org.itomi.kakuro.model.grid;

import java.util.List;

import org.itomi.kakuro.model.fields.BlankField;
import org.itomi.kakuro.model.fields.Field;
import org.itomi.kakuro.model.fields.IndentifiableEntity;
import org.itomi.kakuro.model.fields.SumField;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;

public class Grid extends IndentifiableEntity{
	private int x;
	private int y;
	
	Field[][] fieldMatrix;
	
	List<SumField> sumsList = Lists.newLinkedList();
	
	public Grid() {}

	/**
	 * Inicjalizuje matryce pol przy pomocy {@link Grid#initialize(int, int)}.
	 * @param x
	 * 			pozioma wielkosc matrycy
	 * @param y
	 * 			pozioma wielkosc matrycy
	 */
	public Grid(int x, int y) {
		initialize(x,y);
	}
	
	/**
	 * Inicjalizuje matryce z podanymi argumentami.
	 * @param x
	 * 			pozioma wielkosc matrycy
	 * @param y
	 * 			pozioma wielkosc matrycy
	 * @return
	 * 			instancja na ktorej wolana jest metoda
	 */
	public Grid initialize(int x, int y) {
		fieldMatrix = new Field[x][y];
		for(int i = 1 ; i < x ; i ++) {
			for(int j = 1 ; j < y ; j++ ) {
				fieldMatrix[i][j] = BlankField.BLANK;
			}
		}
		return this;
	}
	
	public Field getFieldAt(int x, int y) throws Exception {
		assertValuesInRange(x, y);
		return fieldMatrix[x][y];
	}

	private void assertValuesInRange(int x, int y) throws Exception {
		if( (x >= this.x && x <0 ) || (y >= this.y && y < 0 ) ) {
			throw new Exception("OutOfBound");
		}
	}
	
	public void setField(int x, int y, Field field) throws Exception {
		assertValuesInRange(x, y);
		fieldMatrix[x][y] = field;
	}
	
	@VisibleForTesting
	public Field[][] getMatrix() {
		return fieldMatrix;
	}
}
