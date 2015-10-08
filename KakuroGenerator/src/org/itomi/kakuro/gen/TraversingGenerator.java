package org.itomi.kakuro.gen;

import java.util.Observable;
import java.util.Set;
import java.util.Stack;

import javax.inject.Inject;

import org.itomi.kakuro.annotations.Traversing;
import org.itomi.kakuro.configuration.Configuration;
import org.itomi.kakuro.model.KakuroInstance;
import org.itomi.kakuro.model.fields.Field;
import org.itomi.kakuro.model.grid.Density;

import com.google.common.collect.Sets;

/**
 * 
 * Klasa odpowiedzialna za generacje instancji krzyzowki kakuro z zadanymi
 * parametrami.
 * 
 * @author Karol Kulesza
 *
 */
@Traversing
public class TraversingGenerator extends Observable implements Generator {

	private static final int MAXIMUM_SUM_VALUE = 45;

	private static final Set<Integer> allowedValues = Sets.newHashSet(1, 2, 3,
			4, 5, 6, 7, 8, 9);
	
	@Inject
	private GenerationContextProvider contextPorvider;
	
	@Override
	public KakuroInstance generate(Long seed, Configuration configuration) {
		KakuroInstance instance = new KakuroInstance(configuration.getInstanceWidth(), configuration.getInstanceHeight());
		Density desiredDensity = configuration.getDesiredDensity();
		GenerationPolicy generationPolicy = contextPorvider.createContextBasingOnConfiguration(configuration);
		Stack<Field> visitedFields = new Stack<>();
		do{
			
		} while(desiredDensity.lower(instance.getDensity()));
		return null;
	}

}
