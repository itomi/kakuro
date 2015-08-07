package org.itomi.kakuro.producers;

import java.util.Random;

import javax.enterprise.inject.Produces;

import org.itomi.kakuro.annotations.Regular;

/**
 * Produces {@link Random} object that behave certain way.
 * 
 * @author kkulesza
 *
 */
public class RandomProducer {

	/**
	 * Producer for {@link Random} regularly initialized.
	 * 
	 * @return
	 */
	@Produces
	@Regular
	public Random crateRegularRandom() {
		return new Random();
	}
	
}
