package org.itomi.kakuro.gen;

import org.itomi.kakuro.configuration.Configuration;

public class GenerationContextProvider {

	public GenerationPolicy createContextBasingOnConfiguration(Configuration configuration) {
		return new GenerationPolicy(configuration.getInstanceWidth(), configuration.getInstanceHeight(), configuration.getDesiredDensity());
	}

}
