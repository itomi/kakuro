package org.itomi.kakuro.model.fields;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

public class SumField extends Field {
	
	private Map<SumField.Direction, ConstraintHolder> constraints = new HashMap<>();
	
	private Set<ValueField> horizontalFields = Sets.newHashSet();
	
	private Set<ValueField> verticalFields = Sets.newHashSet();
	
	public enum Direction {
		NORTH,
		WEST,
		EAST, // and this one 
		SOUTH // this one
		// are used, north and west, are for future modification
	}
}
