package org.itomi.kakuro.gen;

import org.itomi.kakuro.model.grid.Density;

/**
 * @author Hertz
 *
 */
public class GenerationPolicy {

	int desiredWidth;
	int desiredHeight;
	Density desiredDensity;

	/**
	 * @param instanceWidth
	 * @param instanceHeight
	 * @param desiredDensity
	 */
	public GenerationPolicy(int instanceWidth, int instanceHeight,
			Density desiredDensity) {
		this.desiredWidth = instanceWidth;
		this.desiredHeight = instanceHeight;
		this.desiredDensity = desiredDensity;
	}

}
