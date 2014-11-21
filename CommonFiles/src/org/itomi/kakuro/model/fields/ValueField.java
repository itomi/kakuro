package org.itomi.kakuro.model.fields;

import com.google.common.base.Optional;

public class ValueField extends Field {
	
	private SumField verticalSum;
	private SumField horizontalSum;
	
	Optional<Integer> value = Optional.absent();

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
}
