package org.itomi.kakuro.configuration;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Factory class for configuration.
 * 
 * @author Hertz
 *
 */
public class ConfigurationFactory {

	public Configuration createDefaultConfiguration() {
		return new DefaultConfiguration();
	}
	
	public Configuration getConfigurationFromFile() {
		throw new NotImplementedException();
	}
}
