package org.itomi.kakuro.model;

import org.itomi.kakuro.model.fields.Field;

public class KakuroInstance {

	private Field[] instanceGrid = null;

	public KakuroInstance() {
	}
	
	public Field[] getInstanceGrid() {
		return instanceGrid;
	}

	public void setInstanceGrid(Field[] instanceGrid) {
		this.instanceGrid = instanceGrid;
	}
	
}
