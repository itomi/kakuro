package org.itomi.kakuro.model.fields;

import org.itomi.kakuro.integer.Tuple;

/**
 * 
 * Klasa bazowa dla pol na krzyzowce, sluzy tylko i wylacznie jako spinacz typow.
 * 
 * @author Karol Kulesza
 *
 */
public abstract class Field extends IndentifiableEntity{
	protected Tuple<Integer, Integer> position;
	
	public Field() {
		position = new Tuple<Integer, Integer>(0, 0);
	}
	
	public Field(int x, int y) {
		position = new Tuple<Integer, Integer>(x, y);
	}

	public Tuple<Integer, Integer> getPosition() {
		return position;
	}

	public void setPosition(Tuple<Integer, Integer> position) {
		this.position = position;
	}
	
	public void setPosition(int x, int y) {
		position = new Tuple<Integer, Integer>(x, y);
	}
	
	public abstract int getFieldProportionValue();
	
	public abstract boolean isAssignable();
}
