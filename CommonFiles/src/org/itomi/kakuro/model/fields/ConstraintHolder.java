package org.itomi.kakuro.model.fields;


public class ConstraintHolder {
	private Integer sum;

	public ConstraintHolder() {
		
	}
	
	public ConstraintHolder(int value) {
		this.sum = value;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}
}
