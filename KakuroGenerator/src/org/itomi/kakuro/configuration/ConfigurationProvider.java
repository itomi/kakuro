package org.itomi.kakuro.configuration;

import javax.inject.Inject;

/**
 * Class providing configuration, whether got from the gui or from file.
 * 
 * @author Hertz
 *
 */
public class ConfigurationProvider {

	@Inject
	ConfigurationFactory configurationFactory;

	public Configuration getDefaultConfiguration() {
		return configurationFactory.createDefaultConfiguration();
	}
}
