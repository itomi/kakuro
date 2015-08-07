package org.itomi.kakuro.rand;

import java.util.Random;

import javax.inject.Inject;

import org.itomi.kakuro.annotations.Regular;

/**
 * @author kkulesza
 *
 */
public class RandomnessGenerator {

	@Inject
	@Regular
	Random random;
	
	public int nextInt() {
		return random.nextInt();
	}
}
