package org.itomi.kakuro.gen;


import org.itomi.kakuro.configuration.Configuration;
import org.itomi.kakuro.model.KakuroInstance;

public interface Generator {
	/**
	 * Generuje jedna instancje kakuro.
	 * @param seed
	 * 		ziarno do generacji
	 * @param configuration
	 * 		konfiguracja zewntrzna dla generatora
	 * @return
	 * 		wygenerowana instancja problemu
	 */
	public KakuroInstance generate(Long seed, Configuration configuration) throws GenerationException;
}
