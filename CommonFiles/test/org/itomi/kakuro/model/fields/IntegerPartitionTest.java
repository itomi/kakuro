package org.itomi.kakuro.model.fields;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;


public class IntegerPartitionTest {

	@Test
	public void test_checkThatHardcodedPartitionsAreSameAsGenerated() {
		GeneratedIntegerPartition[] generated = GeneratedIntegerPartition.values();
		
		for(GeneratedIntegerPartition partition : generated) {
			for (Set<Integer> generatedPartition : partition.getPartitions()) {
				int value = partition.getValue();
				int size = generatedPartition.size();
				Set<Set<Integer>> hardcodedPartitions = IntegerPartition.getPartitionForSum(value, size);
				if(hardcodedPartitions != null) {
					int counter=0;
					for(Set<Integer> part : hardcodedPartitions) {
						if(part.equals(generatedPartition)) {
							counter++;
						}
					}
					if(counter > 1 || counter < 1) {
						Assert.fail("Expected number of same sets in partition of ["+ value + "] and size [" + size +"] is not equal [1] but: " + counter + " for partition: " + partToString(generatedPartition));
					}
				}else {
					Assert.fail("Could not find partition for: " + value + " with size: " + size);
				}
			}
		}
		
	}

	private String partToString(Set<Integer> generatedPartition) {
		StringBuilder builder = new StringBuilder();
		for( Integer integ : generatedPartition ) {
			builder.append(integ + " ");
		}
		return builder.toString();
	}
}
