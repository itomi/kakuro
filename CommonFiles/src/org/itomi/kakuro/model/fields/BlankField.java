package org.itomi.kakuro.model.fields;


/**
 * Klasa stub sluzy do rozpoznawania ze dane pole w krzyzowce jest niezajete.
 * 
 * @author Karol Kulesza
 *
 */
public class BlankField extends Field {
	
	public BlankField(int x, int y) {
		super(x,y);
	}
	
	@Override
	public int getFieldProportionValue() {
		return 0;
	}

	@Override
	public boolean isAssignable() {
		return true;
	}
}
