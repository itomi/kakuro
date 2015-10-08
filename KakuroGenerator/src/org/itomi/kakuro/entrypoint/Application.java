package org.itomi.kakuro.entrypoint;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.itomi.kakuro.annotations.Traversing;
import org.itomi.kakuro.configuration.Configuration;
import org.itomi.kakuro.configuration.ConfigurationProvider;
import org.itomi.kakuro.gen.GenerationException;
import org.itomi.kakuro.gen.Generator;
import org.itomi.kakuro.model.KakuroInstance;
import org.itomi.kakuro.model.fields.Field;
import org.itomi.kakuro.model.grid.Grid;

@Singleton
public class Application {

	@Inject
	@Traversing
	Generator generator;
	
	@Inject
	ConfigurationProvider configurationProvider;
	
	public void run() {
		Configuration defaultConfiguration = configurationProvider.getDefaultConfiguration();
		try {
			KakuroInstance generate = generator.generate(System.currentTimeMillis(), defaultConfiguration);
			Grid grid = generate.getGrid();
			Field[][] matrix = grid.getMatrix();
			for(int i = 0 ; i < matrix.length ; i++) {
				for( int j = 0 ; j < matrix[i].length; j++ ) {
					System.out.print(matrix[i][j].toString() + "\t");
				}
				System.out.println();
			}
		} catch (GenerationException e) {
			throw new RuntimeException(e);
		}
	}
}
