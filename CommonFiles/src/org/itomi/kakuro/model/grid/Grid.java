package org.itomi.kakuro.model.grid;

import java.util.List;

import org.itomi.kakuro.integer.Tuple;
import org.itomi.kakuro.model.fields.BlankField;
import org.itomi.kakuro.model.fields.Field;
import org.itomi.kakuro.model.fields.IndentifiableEntity;
import org.itomi.kakuro.model.fields.SumField;
import org.itomi.kakuro.model.fields.UnasignableField;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;

public class Grid extends IndentifiableEntity{
	private int x;
	private int y;
	private int fullfillment = 1;
	
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
		for(int i = 0 ; i < x ; i ++) {
			for(int j = 0 ; j < y ; j++ ) {
				fieldMatrix[i][j] = new BlankField(i,j);
			}
		}
		return this;
	}
	
	public Field getFieldAt(int x, int y) {
		try{
			return fieldMatrix[x][y];
		} catch(Exception e) {
			return new UnasignableField();
		}
	}

	private void assertValuesInRange(int x, int y) throws FieldBoundaryException {
		if( (x >= this.x && x <0 ) || (y >= this.y && y < 0 ) ) {
			throw new FieldBoundaryException("out of bound");
		}
	}
	
	public void setField(int x, int y, Field field) throws FieldBoundaryException {
		assertValuesInRange(x, y);
		Field currentField = fieldMatrix[x][y];
		if( currentField.getFieldProportionValue() != field.getFieldProportionValue() ) {
			fullfillment += field.getFieldProportionValue();
		}
		fieldMatrix[x][y] = field;
	}
	
	@VisibleForTesting
	public Field[][] getMatrix() {
		return fieldMatrix;
	}

	public int getFillProportion() {
		return fullfillment;
	}

	public ImmutableSubMatrix<Field> getNeighbours(Tuple<Integer, Integer> position) {
		return new ImmutableSubMatrix<Field>(this.fieldMatrix, position.getFirst(), position.getSecond(), 3, 3);		
	}

	public void addSum(SumField verticalSum) {
		this.sumsList.add(verticalSum);
	}
	
	public int getHorizontalLenght() {
		return x;
	}
	
	public int getVerticalLength() {
		return y;
	}
}
