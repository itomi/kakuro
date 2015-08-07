package org.itomi.kakuro.model;

import java.util.Observable;

import org.itomi.kakuro.integer.Tuple;
import org.itomi.kakuro.model.grid.Density;
import org.itomi.kakuro.model.grid.Grid;
import org.itomi.kakuro.model.grid.ImmutableSubMatrix;

public class KakuroInstance extends Observable {

	private int horizontal;
	private int vertical;
	private Grid grid;

	public KakuroInstance(int x, int y) {
		this.horizontal = x;
		this.vertical = y;
		grid = new Grid().initialize(x, y);
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public int getHorizontalLength() {
		return horizontal;
	}
	
	public int getVerticalLength() {
		return vertical;
	}
	
	public void notifyObservers() {
		notifyObservers(this);
	}
	
	public Density getDensity() {
		return grid.getFillProportion();
	}

	public ImmutableSubMatrix getNeighbours(Tuple<Integer, Integer> position) {
		return grid.getNeighbours(position);
	}
	
}
