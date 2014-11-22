package org.itomi.kakuro.model.fields;

/**
 * 
 * Klasa bazowa dla pol na krzyzowce, sluzy tylko i wylacznie jako spinacz typow.
 * 
 * @author Karol Kulesza
 *
 */
public class Field {
	private Tuple<Integer, Integer> position;
	
	public Field() {
		position = new Tuple<Integer, Integer>(0, 0);
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
}
