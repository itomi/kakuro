package org.itomi.kakuro.model.grid;

import java.util.Arrays;
import java.util.List;

import org.itomi.kakuro.model.fields.BlankField;
import org.itomi.kakuro.model.fields.Field;
import org.itomi.kakuro.model.fields.SumField;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;

public class Grid {
	Field[][] fieldMatrix;
	
	List<SumField> sumsList = Lists.newLinkedList();
	
	public Grid() {}

	/**
	 * Initalizes the grid with given arguments.
	 * @param x
	 * 			horizontal size of grid
	 * @param y
	 * 			vertical size of grid
	 */
	public Grid(int x, int y) {
		initialize(x,y);
	}
	
	/**
	 * Initalizes the grid with given arguments.
	 * @param x
	 * 			horizontal size of grid
	 * @param y
	 * 			vertical size of grid
	 * @return
	 * 			same instance on which the call has been performed
	 */
	public Grid initialize(int x, int y) {
		fieldMatrix = new Field[x][y];
		Arrays.fill(fieldMatrix, new BlankField());
		return this;
	}
	
	
	@VisibleForTesting
	public Field[][] getMatrix() {
		return fieldMatrix;
	}
}
