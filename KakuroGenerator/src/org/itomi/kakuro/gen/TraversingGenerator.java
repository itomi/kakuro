package org.itomi.kakuro.gen;

import java.util.Random;
import java.util.Set;

import org.itomi.kakuro.integer.Tuple;
import org.itomi.kakuro.model.KakuroInstance;
import org.itomi.kakuro.model.fields.BlankField;
import org.itomi.kakuro.model.fields.Field;
import org.itomi.kakuro.model.fields.SumField;
import org.itomi.kakuro.model.fields.SumField.Direction;
import org.itomi.kakuro.model.fields.ValueField;
import org.itomi.kakuro.model.grid.FieldBoundaryException;
import org.itomi.kakuro.model.grid.Grid;
import org.itomi.kakuro.model.grid.ImmutableSubMatrix;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

/**
 * 
 * Klasa odpowiedzialna za generacje instancji krzyzowki kakuro z zadanymi
 * parametrami.
 * 
 * @author Karol Kulesza
 *
 */
public class TraversingGenerator implements GeneratorInterface {

	private int horizontalLength;
	private int verticalLength;

	/**
	 * Tworzy generator z podanymi wartosciami odzwierciedlajacymi wielkosc
	 * instancji.
	 * 
	 * @param x
	 *            pozioma dlugosc matrycy instancji
	 * @param y
	 *            pionowa dlugosc matrycy instancji
	 */
	public TraversingGenerator(int x, int y) {
		this.horizontalLength = x;
		this.verticalLength = y;
	}

	public KakuroInstance generate(final Long seed)
			throws FieldBoundaryException {
		return generate(seed, 60);
	}

	/**
	 * Generuje instancje problemu kakuro z podanego ziarna
	 * 
	 * @param seed
	 *            ziarno ktore uzywane jest do zainicjalizowania pola startowego
	 *            i startowej liczby
	 * 
	 * @param density
	 *            wspolczynnik okreslajacy jak bardzo instancja ma byc
	 *            zapelniona polami do uzupelnienia
	 * 
	 * @return
	 * @throws FieldBoundaryException
	 *             when generation fails,
	 */
	public KakuroInstance generate(final Long seed, final int density)
			throws FieldBoundaryException {
		Random random = new Random(seed);
		KakuroInstance instance = new KakuroInstance(horizontalLength,
				verticalLength);

		ValueField currentField = initializeField(random, instance);
		int currentValue = currentField.getValue();

		while (!instanceIsReady(instance)) {
			Field field = pickPlaceToCreateValue(currentField, instance, random);

			if (fieldIsAssignable(field)) {
				currentValue = createValueForField(random);
				currentField = assignTheValue(field, currentValue);
				updateSums(instance, currentField);
				instance.notifyObservers();
			} else {

			}
		}

		return instance;
	}

	private int createValueForField(Random random) {
		// TODO createValueForField from random
		return 0;
	}

	private void updateSums(KakuroInstance instance, ValueField field) {
		// TODO

	}

	private ValueField assignTheValue(Field field, int currentValue) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean fieldIsAssignable(Field field) {
		// TODO Auto-generated method stub
		return false;
	}

	private ValueField initializeField(Random random, KakuroInstance instance)
			throws FieldBoundaryException {

		// te dwa pola beda w przedzialach od <1, x/2> wiec nie tkna gornych
		// krawedzi
		int startingX = random.nextInt(instance.getHorizontalLength() / 2) + 1;
		int startingY = random.nextInt(instance.getVerticalLength() / 2) + 1;

		// wartosc z przedzialu <1, 9>
		int startingValue = random.nextInt(9) + 1;

		SumField verticalSum = new SumField(startingX, startingY - 1);
		SumField horizontalSum = new SumField(startingX - 1, startingY);

		updateConstraints(verticalSum);
		updateConstraints(horizontalSum);

		ValueField startingField = new ValueField(verticalSum, horizontalSum,
				startingX, startingY);
		startingField.setValue(startingValue);

		verticalSum.addVerticalField(startingField);
		horizontalSum.addHorizontalField(startingField);

		Grid grid = instance.getGrid();

		grid.setField(startingX, startingY - 1, verticalSum);
		grid.setField(startingX - 1, startingY, horizontalSum);
		grid.setField(startingX, startingY, startingField);

		grid.addSum(verticalSum);
		grid.addSum(horizontalSum);

		return startingField;
	}

	private void updateConstraints(SumField horizontalSum) {
		// TODO IMPLEMENT
	}

	private Field pickPlaceToCreateValue(ValueField currentField,
			KakuroInstance instance, Random rand) throws FieldBoundaryException {
		Tuple<Integer, Integer> position = currentField.getPosition();
		ImmutableSubMatrix<Field> neighbours = instance.getNeighbours(position);
		// pick field by mixing with random
		Field[] horizontalAndVerticalNeighbors = neighbours
				.getHorizontalAndVerticalNeighbors();
		boolean picked = false;
		Field pickedField = null;
		while (!picked) {
			int nextInt = rand.nextInt(horizontalAndVerticalNeighbors.length);
			pickedField = horizontalAndVerticalNeighbors[nextInt];
			picked = pickedField.isAssignable()
					&& isAssgnableInContext(instance, pickedField);
		}

		// if unable to pick the field, choose random place
		
		return getRandomAssignablefieldFromInstance(instance, rand);
	}

	private Field getRandomAssignablefieldFromInstance(KakuroInstance instance) {
		Grid grid = instance.getGrid();
		for( int i = 1; i < grid.getHorizontalLenght() ; i++ ) {
			Field fieldAt = grid.getFieldAt(rand.nextInt(instance.getHorizontalLength()), instance.getVerticalLength());
			if(isAssgnableInContext(instance, fieldAt)) {
				return fieldAt;
			}
		}
	}

	private boolean isAssgnableInContext(KakuroInstance instance,
			Field pickedField) {
		// pole bedzie assignable tylko wtedy gdy
		// kiedy ono samo posiada conajmniej tyle ile posiada to pole po lewo od
		// niego,
		// a suma pola nad nim
		// 				|/S3|
		//				 -
		// 				-
		// |/S2| - - - |/S1| - - - - |/XX|
		//               -
		//               -
		// 				|/XX|
		// true gdy SUM(S2_ilosc_horizontal, S1_ilosc_horizontal) < 9 i
		// SUM(S3_ilosc_vertical, S1_ilosc_vertical) < 9
		if (pickedField instanceof SumField) {
			SumField S1 = (SumField) pickedField;
			int verticalFieldsCountS1 = S1.getFieldsForDirection(
					Direction.SOUTH).size();
			int horizontalFieldsCountS1 = S1.getFieldsForDirection(
					Direction.EAST).size();
			if (verticalFieldsCountS1 == 9 || horizontalFieldsCountS1 == 9) {
				return false; // jesli chociaz jedna z tych wielkosci jest rowna
								// dziewiec , to to pole automarycznie jest nie
								// do wziecia
			}

			SumField upperSum = getUpperSum(instance, S1);
			SumField leftSum = getLeftSum(instance, S1);

			boolean upperSumOk = upperSum == null;
			boolean leftSumOk = leftSum == null;
			if (upperSum != null) {
				upperSumOk = true;
			} else {
				Set<ValueField> upperSumFields = upperSum.getFieldsForDirection(Direction.SOUTH);
				upperSumOk = (upperSumFields.size() + verticalFieldsCountS1 + 1 <= 9) && setsAreDisjoint(upperSumFields, S1.getFieldsForDirection(Direction.SOUTH));
			}
			if (leftSum != null) {
				Set<ValueField> leftSumFields = leftSum.getFieldsForDirection(Direction.EAST);
				leftSumOk = (leftSumFields.size() + horizontalFieldsCountS1 + 1 <= 9 && setsAreDisjoint(leftSumFields, S1.getFieldsForDirection(Direction.EAST)));
			}
			
			return upperSumOk && leftSumOk;

		} else if (pickedField instanceof ValueField) {
			return false; // no jak value field, to zostawiamy
		} else if (pickedField instanceof BlankField) {
			return true;
		}
		return false;
	}

	private boolean setsAreDisjoint(Set<ValueField> upperSumFields,
			Set<ValueField> fieldsForDirection) {
		FluentIterable<ValueField> from = FluentIterable.from(fieldsForDirection);
		for(ValueField field : upperSumFields ) {
			if(from.anyMatch(new Predicate<ValueField>() {
				@Override
				public boolean apply(ValueField input) {
					return input.getValue() == field.getValue();
				}
			})){
				return false;
			}
		}
		return true;
	}

	private SumField getLeftSum(KakuroInstance instance, SumField s1) {
		ImmutableSubMatrix<Field> neighbours = instance.getNeighbours(s1
				.getPosition());
		Field leftSideNeigbor = neighbours.getLeftSideNeigbor(s1);
		if (leftSideNeigbor instanceof ValueField) {
			return ((ValueField) leftSideNeigbor).getHorizontalSum();
		} else if (leftSideNeigbor instanceof SumField) {
			return (SumField) leftSideNeigbor;
		}
		return null;
	}

	private SumField getUpperSum(KakuroInstance instance, SumField s1) {
		ImmutableSubMatrix<Field> neighbours = instance.getNeighbours(s1
				.getPosition());
		Field upperSideNeigbor = neighbours.getUpperSideNeighbor(s1);
		if (upperSideNeigbor instanceof ValueField) {
			return ((ValueField) upperSideNeigbor).getVerticalSum();
		} else if (upperSideNeigbor instanceof SumField) {
			return (SumField) upperSideNeigbor;
		}
		return null;
	}

	private boolean instanceIsReady(KakuroInstance instance) {
		return instance.getDensity() > 60;
	}

	public static void main(String[] args) throws FieldBoundaryException {
		new TraversingGenerator(100, 100).generate(100L);
	}
}
