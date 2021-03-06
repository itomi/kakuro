package org.itomi.kakuro.configuration;

import java.util.List;


import org.itomi.kakuro.model.grid.Density;

/**
 * Configuration file representing the current configuration of the generator.
 * 
 * @author kkulesza
 *
 */
public abstract class Configuration {

	public abstract int getInstanceWidth();

	public abstract int getInstanceHeight();

	public abstract Density getDesiredDensity();

	public abstract List<Object> getObservers();
}
