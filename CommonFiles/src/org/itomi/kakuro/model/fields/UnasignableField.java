package org.itomi.kakuro.model.fields;

public class UnasignableField extends Field {

	@Override
	public int getFieldProportionValue() {
		return 0;
	}

	@Override
	public boolean isAssignable() {
		return false;
	}

}
