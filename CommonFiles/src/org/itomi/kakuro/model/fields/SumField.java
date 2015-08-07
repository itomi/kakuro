package org.itomi.kakuro.model.fields;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Optional;
import com.google.common.collect.Sets;

public class SumField extends Field {
	
	private Map<SumField.Direction, ConstraintHolder> constraints = new HashMap<>();
	
	private Set<ValueField> horizontalFields = Sets.newHashSet();
	
	private Set<ValueField> verticalFields = Sets.newHashSet();
	
	public SumField() {}
	
	public SumField(int x, int y) {
		super(x,y);
	}
	
	public void setSumForDirection(Direction direction, int value) {
		constraints.put(direction, new ConstraintHolder(value));
	}
	
	public void replaceSumForDirection(Direction direction, int value) {
		ConstraintHolder constraintHolder = constraints.get(direction);
		constraintHolder.setSum(value);
	}
	
	public void addHorizontalField(ValueField field) {
		horizontalFields.add(field);
	}
	
	public void addVerticalField(ValueField field) {
		verticalFields.add(field);
	}
	
	public Optional<ConstraintHolder> getSumForDirection(Direction dir) {
		return Optional.of(constraints.get(dir));
	}
	
	public Set<ValueField> getFieldsForDirection(Direction dir) {
		switch(dir) {
			case SOUTH:
				return verticalFields;
			case EAST:
				return horizontalFields;
			default:
				return Sets.newHashSet();
				
		}
	}
	
	public enum Direction {
		NORTH,
		WEST,
		EAST, // and this one 
		SOUTH // this one
		// are used, north and west, are for future modification
	}

	@Override
	public int getFieldProportionValue() {
		return 0;
	}

	@Override
	public boolean isAssignable() {
		return true;
	}
}
