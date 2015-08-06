package org.itomi.kakuro.gen;

import java.util.Stack;

import org.itomi.kakuro.model.KakuroInstance;
import org.itomi.kakuro.model.fields.Field;

/**
 * Generator that bases its generation on stack which is able to hold information about which fields were already analyzed.
 * 
 * @author kkulesza
 *
 */
public class BacktrackableGenerator implements GeneratorInterface {
	
	/* (non-Javadoc)
	 * @see org.itomi.kakuro.gen.GeneratorInterface#generate(java.lang.Long)
	 */
	@Override
	public KakuroInstance generate(Long seed) throws Exception {
		
		return null;
	}

}
