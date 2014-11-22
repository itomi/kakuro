package org.itomi.kakuro.gen;

import org.itomi.kakuro.model.KakuroInstance;

public interface GeneratorInterface {
	/**
	 * Generuje jedna instancje kakuro.
	 * @param seed
	 * 		ziarno do generacji
	 * @return
	 * 		wygenerowana instancja problemu
	 */
	public KakuroInstance generate(Long seed);
}
