package org.itomi.kakuro.model.fields;

import com.google.common.base.Optional;

public class ValueField extends Field {
	
	private SumField verticalSum;
	private SumField horizontalSum;
	
	Optional<Integer> value = Optional.absent();
	
	public ValueField(int x, int y) {
		super(x,y);
	}
	
	public ValueField(SumField verticalSum, SumField horizontalSum, int x, int y) {
		super(x,y);
		this.verticalSum = verticalSum;
		this.horizontalSum = horizontalSum;
	}
	
	public SumField getHorizontalSum() {
		return horizontalSum;
	}

	public void setHorizontalSum(SumField horizontalSum) {
		this.horizontalSum = horizontalSum;
	}

	public SumField getVerticalSum() {
		return verticalSum;
	}

	public void setVerticalSum(SumField verticalSum) {
		this.verticalSum = verticalSum;
	}
	
	public void setValueAbsent() {
		value = Optional.absent();
	}
	
	public void setValue(Integer value) {
		this.value = Optional.of(value);
	}
	
	public int getValue() {
		Integer integer = value.get();
		return Optional.fromNullable(integer).or(0);
	}

	@Override
	public int getFieldProportionValue() {
		return 1;
	}

	@Override
	public boolean isAssignable() {
		return false; // moze w przyslosci 
	}
	
	@Override
	public String toString() {
		return "ValueField " + position.toString();
	}
}
