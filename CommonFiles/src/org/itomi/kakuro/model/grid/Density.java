package org.itomi.kakuro.model.grid;

public class Density {
	
	private int density;
	
	public int getDensity() {
		return density;
	}
	
	public void setDensity(int newDensity) {
		this.density = newDensity;
	}
	
	public void addDensity(int incremental) {
		this.density += incremental;
	}

	/**
	 * Calculates whether {@link Density} given by argument is lower than this object.
	 * 
	 * @param density2
	 * @return
	 */
	public boolean lower(Density density2) {
		return density2.density < this.density; 
	}
}
