package org.itomi.kakuro.configuration;

import org.itomi.kakuro.model.grid.Density;

public class DefaultConfiguration extends Configuration{

	public static final int DEFAULT_WIDTH = 100;
	public static final int DEFAULT_HEIGHT = 100;
	public static final int DEFAULT_DENSITY = 75;
	
	@Override
	public int getInstanceWidth() {
		return DEFAULT_WIDTH;
	}

	@Override
	public int getInstanceHeight() {
		return DEFAULT_HEIGHT;
	}

	@Override
	public Density getDesiredDensity() {
		return new Density(DEFAULT_DENSITY);
	}

}
