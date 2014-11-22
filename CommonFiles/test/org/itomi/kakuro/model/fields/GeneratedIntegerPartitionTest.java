package org.itomi.kakuro.model.fields;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Sets;


public class GeneratedIntegerPartitionTest {
	
	@Test
	public void test_checkIfGeneratedPartitionsSumUpRightValue() {
		for( GeneratedIntegerPartition partition : GeneratedIntegerPartition.values() ) {
			List<Set<Integer>> partitions = partition.getPartitions();
			int value = partition.getValue();
			for(Set<Integer> uniquepartition : partitions) {
				if(!(sumValues(uniquepartition) == value)) {
					Assert.fail("Generated partitions does not add up to the given value");
				}
			}
			
		}
	}
	
	private int sumValues(Set<Integer> uniquepartition) {
		int sum = 0;
		for(Integer integ : uniquepartition ) {
			sum += integ.intValue();
		}
		return sum;
	}

	@Test
	public void test_checkThatEachPartitionIsUniqueInEachNumber() {
		for(GeneratedIntegerPartition partition : GeneratedIntegerPartition.values() ) {
			List<Set<Integer>> partitions = partition.getPartitions();
			for( Set<Integer> uniquePartition : partitions ) {
				int counter = 0;
				for( Set<Integer> part : partitions ) {
					if(part.containsAll(uniquePartition)) {
						counter++;
					}
				}
				if(counter > 1 || counter < 1 ) {
					Assert.fail("There is problem with uniqueness of sets in " + partition.name() + " insufficien number of unique sets.");
				}
			}
		}
	}
	
	@Test 
	public void test_checkInterssectionOfTwoValuesWithForbiddenSet() {
		Set<Integer> horizontalValues = Sets.newHashSet(7);
		Set<Integer> verticalValues = Sets.newHashSet(2);
		int horizontalSum = 19;
		int verticalSum = 10;
		
		Set<Integer> possibleValuesForField = GeneratedIntegerPartition.getPossibleValuesForField(horizontalSum, 3, verticalSum, 4, horizontalValues, verticalValues);
		
		Set<Integer> expectedReturn = Sets.newHashSet(3,4);
		Assert.assertEquals(possibleValuesForField.size(), 2);
		Assert.assertTrue(possibleValuesForField.containsAll(expectedReturn));
	}
	
	@Test
	public void test_checkThatGeneratedPartitionsAreSameAsHardcoded() {		
		for(IntegerPartition partition : IntegerPartition.values()) {
			for (Set<Integer> hardcodedPartition : partition.getPartitions()) {
				int value = partition.getValue();
				int size = hardcodedPartition.size();
				Set<Set<Integer>> generatedPartitions = GeneratedIntegerPartition.getPartitionsBySumAndSize(value, size);
				if(generatedPartitions != null) {
					int counter=0;
					for(Set<Integer> part : generatedPartitions) {
						if(part.equals(hardcodedPartition)) {
							counter++;
						}
					}
					if(counter > 1 || counter < 1) {
						Assert.fail("Expected number of same sets in partition of ["+ value + "] and size [" + size +"] is not equal [1] but: " + counter + " for partition: " + partToString(hardcodedPartition));
					}
				}else {
					Assert.fail("Could not find partition for: " + value + " with size: " + size);
				}
			}
		}
		
	}

	private String partToString(Set<Integer> hardcodedPartition) {
		StringBuilder builder = new StringBuilder();
		for( Integer integ : hardcodedPartition ) {
			builder.append(integ + " ");
		}
		return builder.toString();
	}
}
