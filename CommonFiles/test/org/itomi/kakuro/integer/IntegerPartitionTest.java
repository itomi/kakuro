package org.itomi.kakuro.integer;

import java.util.Set;

import org.itomi.kakuro.integer.IntegerPartition;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Sets;


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

	@Test
	public void test_getAvailibleNumbersForFieldWithAlreadyUsed() {
		int sum1 = 19;
		int size1 = 3;
		int sum2 = 10;
		int size2 = 4;
		Set<Integer> horizontal = Sets.newHashSet(7);
		Set<Integer> vertical = Sets.newHashSet(2);
		Set<Integer> intersectionOfSums = IntegerPartition.getIntersectionOfSums(sum1, size1, sum2, size2, horizontal, vertical);
		
		Set<Integer> expected = Sets.newHashSet(3,4);
		Assert.assertEquals(2 ,intersectionOfSums.size());
		Assert.assertEquals(intersectionOfSums, expected);
		
	}
	
	private String partToString(Set<Integer> generatedPartition) {
		StringBuilder builder = new StringBuilder();
		for( Integer integ : generatedPartition ) {
			builder.append(integ + " ");
		}
		return builder.toString();
	}
}
