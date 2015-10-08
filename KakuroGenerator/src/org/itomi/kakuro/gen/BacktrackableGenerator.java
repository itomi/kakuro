package org.itomi.kakuro.gen;

import java.util.Random;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import org.itomi.kakuro.annotations.Backtrackable;
import org.itomi.kakuro.configuration.Configuration;
import org.itomi.kakuro.model.KakuroInstance;
import org.itomi.kakuro.model.grid.Density;

/**
 * Generator that bases its generation on stack which is able to hold information 
 * about which fields were already analyzed.
 * 
 * @author kkulesza
 *
 */
@Default
@Backtrackable
public class BacktrackableGenerator implements Generator {
	
	@Inject
	Configuration configuration;
	
	/* (non-Javadoc)
	 * @see org.itomi.kakuro.gen.GeneratorInterface#generate(java.lang.Long)
	 */
	@Override
	public KakuroInstance generate(Long seed, Configuration configuration) {
		KakuroInstance instance = new KakuroInstance(configuration.getInstanceWidth(), configuration.getInstanceHeight());
		Density desiredDensity = configuration.getDesiredDensity();
		while(desiredDensity.lower(instance.getDensity())) {
			
		}
		
		return null;
	}

}
