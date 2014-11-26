package org.itomi.kakuro.gen;

import java.util.Random;
import java.util.Set;

import org.itomi.kakuro.integer.Tuple;
import org.itomi.kakuro.model.KakuroInstance;
import org.itomi.kakuro.model.fields.BlankField;
import org.itomi.kakuro.model.fields.ConstraintHolder;
import org.itomi.kakuro.model.fields.Field;
import org.itomi.kakuro.model.fields.SumField;
import org.itomi.kakuro.model.fields.SumField.Direction;
import org.itomi.kakuro.model.fields.ValueField;
import org.itomi.kakuro.model.grid.FieldBoundaryException;
import org.itomi.kakuro.model.grid.Grid;
import org.itomi.kakuro.model.grid.ImmutableSubMatrix;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Sets;

/**
 * 
 * Klasa odpowiedzialna za generacje instancji krzyzowki kakuro z zadanymi
 * parametrami.
 * 
 * @author Karol Kulesza
 *
 */
public class TraversingGenerator implements GeneratorInterface {

	private static final int MAXIMUM_SUM_VALUE = 45;
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

	public KakuroInstance generate(final Long seed) throws Exception {
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
	 * @throws Exception
	 */
	public KakuroInstance generate(final Long seed, final int density)
			throws Exception {
		Random random = new Random(seed);
		KakuroInstance instance = new KakuroInstance(horizontalLength,
				verticalLength);

		ValueField currentField = initializeField(random, instance);
		int currentValue = currentField.getValue();

		while (!instanceIsReady(instance)) {
			Field field = pickPlaceToCreateValue(currentField, instance, random);
			if (field == null) {
				throw new Exception("Could not pick the field");
			}

			if (fieldIsAssignable(field)) {
				currentValue = createValueForField(field, instance, random);
				currentField = assignTheValue(field, currentValue);
				updateSums(instance, currentField);
				instance.notifyObservers();
			} else {

			}
		}

		return instance;
	}

	private int createValueForField(Field field, KakuroInstance instance,
			Random random) throws Exception {
		ImmutableSubMatrix<Field> neighbours = instance.getNeighbours(field
				.getPosition());
		if (field instanceof SumField) {
			// jesli sum field
			// bierzemy konstrainty z sum
			SumField fild = (SumField) field;
			int horizontalSum = getSumValueForDirection(fild, Direction.EAST);
			int verticalSum = getSumValueForDirection(fild, Direction.SOUTH);
			Set<Integer> allProhibitetValues = getProhibitedValuesForSum(fild);

			SumField upperSum = getUpperSum(instance, fild);
			SumField leftSup = getLeftSum(instance, fild);
			if (upperSum != null) {
				allProhibitetValues.getClass();
			}

		} else if (field instanceof ValueField) {

		} else if (field instanceof BlankField) {

		}
		return 0;
	}

	private Set<Integer> getProhibitedValuesForSum(SumField fild)
			throws Exception {
		Set<ValueField> horizontalFieldValues = fild
				.getFieldsForDirection(Direction.EAST);
		Set<Integer> horizontalValues = extractValues(horizontalFieldValues);
		Set<ValueField> verticalFieldValues = fild
				.getFieldsForDirection(Direction.SOUTH);
		Set<Integer> verticalValues = extractValues(verticalFieldValues);
		Set<Integer> allProhibitetValues = Sets.newHashSet();
		allProhibitetValues.addAll(horizontalValues);
		allProhibitetValues.addAll(verticalValues);
		return allProhibitetValues;
	}

	private int getSumValueForDirection(SumField fild, Direction direction)
			throws Exception {
		Optional<ConstraintHolder> sumForDirection = fild
				.getSumForDirection(direction);
		if (!sumForDirection.isPresent()) {
			throw new Exception("no sum specified");
		}
		return sumForDirection.get().getSum();
	}

	private Set<Integer> extractValues(Set<ValueField> fields) throws Exception {
		Set<Integer> values = Sets.newHashSet();

		for (ValueField field : fields) {
			values.add(field.getValue());
		}

		if (values.contains(0)) {
			throw new Exception(" not so good !, value is not assigned");
		}

		return values;
	}

	private void updateSums(KakuroInstance instance, ValueField field) {
		// TODO

	}

	private ValueField assignTheValue(Field field, int currentValue) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean fieldIsAssignable(Field field) {
		return field.isAssignable(); // potem tutaj beda dodatkowe checki, jesli
										// wprowadze nadpisywanie ValueFielda
										// (zamiana wartosi i ich proagowanie)
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
			KakuroInstance instance, Random rand) throws Exception {
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

		return getFirstAssignableFieldFromInstance(instance);
	}

	private Field getFirstAssignableFieldFromInstance(KakuroInstance instance) throws Exception {
		Grid grid = instance.getGrid();
		for (int i = 1; i < grid.getHorizontalLenght(); i++) {
			for (int j = 1; j < grid.getVerticalLength(); j++) {
				Field fieldAt = grid.getFieldAt(i, j);
				if (isAssgnableInContext(instance, fieldAt)) {
					return fieldAt;
				}
			}
		}
		return null;
	}

	private boolean isAssgnableInContext(KakuroInstance instance,
			Field pickedField) throws Exception {
		// pole bedzie assignable tylko wtedy gdy
		// kiedy ono samo posiada conajmniej tyle ile posiada to pole po lewo od
		// niego,
		// a suma pola nad nim
		// |/S3|
		// -
		// -
		// |/S2| - - - |/S1| - - - - |/XX|
		// -
		// -
		// |/XX|
		// true gdy SUM(S2_ilosc_horizontal, S1_ilosc_horizontal) < 9 i
		// SUM(S3_ilosc_vertical, S1_ilosc_vertical) < 9

		SumField upperSum = getUpperSum(instance, pickedField);
		SumField leftSum = getLeftSum(instance, pickedField);
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

			boolean upperSumOk = upperSum == null;
			boolean leftSumOk = leftSum == null;
			if (upperSum != null) {
				Set<ValueField> upperSumFields = upperSum
						.getFieldsForDirection(Direction.SOUTH);
				upperSumOk = (upperSumFields.size() + verticalFieldsCountS1 + 1 <= 9)
						&& setsAreDisjoint(upperSumFields,
								S1.getFieldsForDirection(Direction.SOUTH))
						&& sumLessThanConstrinant(S1, upperSum,Direction.SOUTH);
			}
			if (leftSum != null) {
				Set<ValueField> leftSumFields = leftSum
						.getFieldsForDirection(Direction.EAST);
				leftSumOk = (leftSumFields.size() + horizontalFieldsCountS1 + 1 <= 9
						&& setsAreDisjoint(leftSumFields,
								S1.getFieldsForDirection(Direction.EAST)) && sumLessThanConstrinant(
						S1, leftSum, Direction.EAST));
			}

			return upperSumOk && leftSumOk;

		} else if (pickedField instanceof ValueField) {
			return false; // no jak value field, to zostawiamy
		} else if (pickedField instanceof BlankField) {

			boolean upperSumOk = upperSum == null;
			boolean leftSumOk = leftSum == null;

			if (upperSum != null) {
				Set<ValueField> upperSumFields = leftSum
						.getFieldsForDirection(Direction.EAST);
				leftSumOk = (upperSumFields.size() + 1 <= 9);
			}
			if (leftSum != null) {
				Set<ValueField> leftSumFields = leftSum
						.getFieldsForDirection(Direction.EAST);
				leftSumOk = (leftSumFields.size() + 1 <= 9);
			}

			return upperSumOk && leftSumOk;
		}
		return false;
	}

	private boolean sumLessThanConstrinant(SumField oneSum, SumField second, Direction direction) throws Exception {
		Optional<ConstraintHolder> sumForDirection = oneSum.getSumForDirection(direction);
		Optional<ConstraintHolder> sumForDirection2 = second.getSumForDirection(direction);
		
		if(!sumForDirection.isPresent() || !sumForDirection2.isPresent()) {
			throw new Exception("sum unspecified");
		}
		
		return sumForDirection.get().getSum() + sumForDirection2.get().getSum() < MAXIMUM_SUM_VALUE ;
	}

	private boolean setsAreDisjoint(Set<ValueField> upperSumFields,
			Set<ValueField> fieldsForDirection) {
		FluentIterable<ValueField> from = FluentIterable
				.from(fieldsForDirection);
		for (ValueField field : upperSumFields) {
			if (from.anyMatch(new Predicate<ValueField>() {
				@Override
				public boolean apply(ValueField input) {
					return input.getValue() == field.getValue();
				}
			})) {
				return false;
			}
		}
		return true;
	}

	private SumField getLeftSum(KakuroInstance instance, Field s1) {
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

	private SumField getUpperSum(KakuroInstance instance, Field s1) {
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

	public static void main(String[] args) throws Exception {
		new TraversingGenerator(100, 100).generate(100L);
	}
}
