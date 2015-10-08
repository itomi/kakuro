package org.itomi.kakuro.entrypoint;

import org.itomi.kakuro.configuration.Configuration;
import org.itomi.kakuro.configuration.ConfigurationProvider;
import org.itomi.kakuro.gen.Generator;

public class Application {

	@Inject
	Generator generator;
	
	@Inject
	ConfigurationProvider configurationProvider;
	
	public void run() {
		Configuration defaultConfiguration = configurationProvider.getDefaultConfiguration();
		generator.registerListeners(defaultConfiguration.getObservers());
		generator.generate(System.currentTimeMillis(), defaultConfiguration);
		generator.unregisterListeners(defaultConfiguration.getObservers());
	}
}
