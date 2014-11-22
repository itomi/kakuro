package org.itomi.kakuro.model;

import org.itomi.kakuro.model.grid.Grid;

public class KakuroInstance {

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
}
