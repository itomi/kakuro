package org.itomi.kakuro.model.grid;

/**
 * Represents the density of some object ( used for density of grid ).
 * 
 * TODO: get better name for it
 * @author Hertz
 *
 */
public class Density {
	
	private int density;
	
	public Density() {}
	
	public Density(int startingDensity) {
		this.density = startingDensity;
	}
	
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
