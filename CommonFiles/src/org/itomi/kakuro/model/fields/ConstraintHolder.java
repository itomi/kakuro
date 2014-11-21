package org.itomi.kakuro.model.fields;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class ConstraintHolder {
	private Integer sum;

	public ConstraintHolder() {
		
	}
	
	public ConstraintHolder(int value) {
		this.sum = value;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
	// performance purposes
	@SuppressWarnings("unchecked")
	public enum IntegerPartition {
		THREE(3, set(1,2)),
		FOUR(4, set(1,3)),
		FIVE(5, set(1,4), set(2,3)),
		SIX(6, set(1,5), set(2,4), set(1,2,3)),
		SEVEN(7, set(1,6), 
				set(2,5), 
				set(3,4), 
				set(1,2,4)),
		
		EIGHT(8, set(1,7), 
				set(2,6), 
				set(3,5), 
				set(1,2,5), 
				set(1,3,4)),
		NINE(9, set(1,8), 
				set(2,7), 
				set(3,6), 
				set(4,5), 
				set(1,2,6), 
				set(1,3,5), 
				set(2,3,4)),
		TEN(10, set(1,9), 
				set(2,8), 
				set(3,7), 
				set(4,6), 
				set(1,2,7), 
				set(1,3,6), 
				set(1,4,5), 
				set(2,3,5), 
				set(1,2,3,4)),
		ELEVEN(11, set(2,9), 
				set(3,8), 
				set(4,7), 
				set(5,6), 
				set(1,2,8), 
				set(1,3,7), 
				set(1,4,6), 
				set(2,3,6), 
				set(2,4,5), 
				set(1,2,3,5)),
		TWELVE(12, set(3,9),
				set(4,8), 
				set(5,7), 
				set(1,2,9), 
				set(1,3,8), 
				set(1,4,7), 
				set(1,5,6), 
				set(2,3,7), 
				set(2,4,6), 
				set(3,4,5), 
				set(1,2,3,6), 
				set(1,2,4,5)),
		THIRTEEN(13, set(4,9),
				set(5,8),
				set(6,7),
				set(1,3,9),
				set(1,4,8),
				set(1,5,7),
				set(2,3,8),
				set(2,4,7),
				set(2,5,6),
				set(3,4,6),
				set(1,2,3,7),
				set(1,2,4,6),
				set(1,3,4,5)),
		FOURTEEN(14, set(5,9),
				set(6,8),
				set(1,4,9),
				set(1,5,8),
				set(1,6,7),
				set(2,3,9),
				set(2,4,8),
				set(2,5,7),
				set(3,4,7),
				set(3,5,6),
				set(1,2,3,8),
				set(1,2,4,7),
				set(1,2,5,6),
				set(1,3,4,6),
				set(2,3,4,5)),
		FIFTEEN(15, set(6,9),
				set(7,8),
				set(1,5,9),
				set(1,6,8),
				set(2,4,9),
				set(2,5,8),
				set(2,6,7),
				set(3,4,8),
				set(3,5,7),
				set(4,5,6),
				set(1,2,3,9),
				set(1,2,4,8),
				set(1,2,5,7),
				set(1,3,4,7),
				set(1,3,5,6),
				set(2,3,4,6),
				set(1,2,3,4,5)),
		SIXTEEN(16, set(7,9),
				set(1,6,9),
				set(1,7,8),
				set(2,5,9),
				set(2,6,8),
				set(3,4,9),
				set(3,5,8),
				set(3,6,7),
				set(4,5,7),
				set(1,2,4,9),
				set(1,2,5,8),
				set(1,2,6,7),
				set(1,3,4,8),
				set(1,3,5,7),
				set(1,4,5,6),
				set(2,3,4,7),
				set(2,3,5,6),
				set(1,2,3,4,6)),
		SEVENTEEN(17, set(8,9),
				set(1,7,9),
				set(2,6,9),
				set(2,7,8),
				set(3,5,9),
				set(3,6,8),
				set(4,5,8),
				set(4,6,7),
				set(1,2,5,9),
				set(1,2,6,8),
				set(1,3,4,9),
				set(1,3,5,8),
				set(1,3,6,7),
				set(1,4,5,7),
				set(2,3,4,8),
				set(2,3,5,7),
				set(2,4,5,6),
				set(1,2,3,4,7),
				set(1,2,3,5,6)),
		EIGHTEEN(18, set(1,8,9),
				set(2,7,9),
				set(3,6,9),
				set(3,7,8),
				set(4,5,9),
				set(4,6,8),
				set(5,6,7),
				set(1,2,6,9),
				set(1,2,7,8),
				set(1,3,5,9),
				set(1,3,6,8),
				set(1,4,5,8),
				set(1,4,6,7),
				set(2,3,4,9),
				set(2,3,5,8),
				set(2,3,6,7),
				set(2,4,5,7),
				set(3,4,5,6),
				set(1,2,3,4,8),
				set(1,2,3,5,7),
				set(1,2,4,5,6)),
		NINETEEN(19, set(2,8,9),
				set(3,7,9),
				set(4,6,9),
				set(4,7,8),
				set(5,6,8),
				set(1,2,7,9),
				set(1,3,6,9),
				set(1,3,7,8),
				set(1,4,5,9),
				set(1,4,6,8),
				set(1,5,6,7),
				set(2,3,5,9),
				set(2,3,6,8),
				set(2,4,5,8),
				set(2,4,6,7),
				set(3,4,5,7),
				set(1,2,3,4,9),
				set(1,2,3,5,8),
				set(1,2,3,6,7),
				set(1,2,4,5,7),
				set(1,3,4,5,6)),
		TWENTY(20, set(3,8,9),
				set(4,7,9),
				set(5,6,9),
				set(5,7,8),
				set(1,2,8,9),
				set(1,3,7,9),
				set(1,4,6,9),
				set(1,4,7,8),
				set(1,5,6,8),
				set(2,3,6,9),
				set(2,3,7,8),
				set(2,4,5,9),
				set(2,4,6,8),
				set(2,5,6,7),
				set(3,4,5,8),
				set(3,4,6,7),
				set(1,2,3,5,9),
				set(1,2,3,6,8),
				set(1,2,4,5,8),
				set(1,2,4,6,7),
				set(1,3,4,5,7),
				set(2,3,4,5,6)),
		TWENTY_ONE(21, set(4,8,9),
				set(5,7,9),
				set(6,7,8),
				set(1,3,8,9),
				set(1,4,7,9),
				set(1,5,6,9),
				set(1,5,7,8),
				set(2,3,7,9),
				set(2,4,6,9),
				set(2,4,7,8),
				set(2,5,6,8),
				set(3,4,5,9),
				set(3,4,6,8),
				set(3,5,6,7),
				set(1,2,3,6,9),
				set(1,2,3,7,8),
				set(1,2,4,5,9),
				set(1,2,5,6,7),
				set(1,3,4,5,8),
				set(1,3,4,6,7),
				set(2,3,4,5,7),
				set(1,2,3,4,5,6)),
		TWENTY_TWO(22, set(5,8,9),
				set(6,7,9),
				set(1,4,8,9),
				set(1,5,7,9),
				set(1,6,7,8),
				set(2,3,8,9),
				set(2,4,7,9),
				set(2,5,6,9),
				set(2,5,7,8),
				set(3,4,6,9),
				set(3,4,7,8),
				set(3,5,6,8),
				set(4,5,6,7),
				set(1,2,3,7,9),
				set(1,2,4,6,9),
				set(1,2,4,7,8),
				set(1,2,5,6,8),
				set(1,3,4,5,9),
				set(1,3,4,6,8),
				set(1,3,5,6,7),
				set(2,3,4,5,8),
				set(2,3,4,6,7),
				set(1,2,3,4,5,7)),
		TWENTY_THRE(23, set()),
		TWENTY_FOUR,
		TWENTY_FIVE,
		TWENTY_SIX,
		TWENTY_SEVEN,
		TWENTY_EIGTH,
		TWENTY_NINE,
		THIRTY,
		THIRTY_ONE,
		THIRTY_TWO,
		THIRTY_THREE,
		THIRTY_FOUR,
		THIRTY_FIVE,
		THIRTY_SIX,
		THIRTY_SEVEN,
		THIRTY_EIGHT,
		THIRTY_NINE,
		FOURTY(40, set(1,2,3,4,6,7,8,9)),
		FOURTY_ONE(41, set(2,4,5,6,7,8,9), 
				set(1,2,3,5,6,7,8,9)),
		FOURTY_TWO(42, set(3,4,5,6,7,8,9), 
				set(1,2,4,5,6,7,8,9)),
		FROUTY_THREE(43, set(1,3,4,5,6,7,8,9)),
		FOURTY_FOUR(44, set(2,3,4,5,6,7,8,9)),
		FOURTY_FIVE(45, set(1,2,3,4,5,6,7,8,9)); //FINALLY ! 
		
		private Integer sum;
		private List<Set<Integer>> partitions;
		
		private IntegerPartition() {
			this.partitions = new ArrayList<>();
		}
		
		private IntegerPartition(Integer sum, Set<Integer>...possiblePartitions) {
			this.sum = sum;
			partitions = Arrays.asList(possiblePartitions);
			for( Set<Integer> partition : partitions ) {
				if(!this.sum.equals(sum(partition))) {
					String partitionValues = "";
					for(Integer integer : partition) {
						partitionValues += (" " + integer.intValue());
					}
					System.out.println(sum + " is not equal to sum of: " + partitionValues);
				}
			}
		}
		
		private Integer sum(Set<Integer> partition) {
			Integer sum = new Integer(0);
			for(Integer value : partition) {
				sum += value;
			}
			return sum;
		}

		private static Set<Integer> set(Integer...values) {
			return new TreeSet<Integer>(Arrays.asList(values));
		}
		
		static {
			// mapping for size of set to values
			// mapping for number to possible sets
			// possible sets for given values of value
			// intersection of two sets from two sums given by value

		}
		
	}
	
	public enum GeneratedIntegerPartition {
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		ELEVEN(11),
		TWELVE(12),
		THIRTEEN(13),
		FOURTEEN(14),
		FIFTEEN(15),
		SIXTEEN(16),
		SEVENTEEN(17),
		EIGHTEEN(18),
		NINETEEN(19),
		TWENTY(20),
		TWENTY_ONE(21),
		TWENTY_TWO(22),
		TWENTY_THRE(23),
		TWENTY_FOUR(24),
		TWENTY_FIVE(25),
		TWENTY_SIX(26),
		TWENTY_SEVEN(27),
		TWENTY_EIGTH(28),
		TWENTY_NINE(29),
		THIRTY(30),
		THIRTY_ONE(31),
		THIRTY_TWO(32),
		THIRTY_THREE(33),
		THIRTY_FOUR(34),
		THIRTY_FIVE(35),
		THIRTY_SIX(36),
		THIRTY_SEVEN(37),
		THIRTY_EIGHT(38),
		THIRTY_NINE(39),
		FOURTY(40),
		FOURTY_ONE(41),
		FOURTY_TWO(42),
		FROUTY_THREE(43),
		FOURTY_FOUR(44),
		FOURTY_FIVE(45);
		
		private static HashMap<Integer, List<Set<Integer>> > valueToPartitions = new HashMap<>();
		private static HashMap<Tuple<Integer, Integer>, Set<Integer> > setSizeAndValueToPosiblePartitions = new HashMap<>();
		
		private int value;
		private List<Set<Integer>> partitions;
		
		private GeneratedIntegerPartition(int value) {
			this.value = value;	
			this.partitions = Partitions.partitionsWithAllowedValues(value, Sets.newHashSet(1,2,3,4,5,6,7,8,9));			
		}
		
		public List<Set<Integer>> getPartitions() {
			return partitions;
		}
		
		static {
			for(GeneratedIntegerPartition partition : GeneratedIntegerPartition.values()) {
				valueToPartitions.put(partition.value, partition.partitions);
				for( Set<Integer> party : partition.partitions ) {
					setSizeAndValueToPosiblePartitions.put(new Tuple<Integer,Integer>(party.size(), partition.value), party);
				}
			}
		}
		
		public static Set<Integer> getPossibleValuesForField(int sum1, int size1, int sum2, int size2, Set<Integer> alreadyTakenValues) {
			
			Set<Integer> set = setSizeAndValueToPosiblePartitions.get(new Tuple<Integer,Integer>(size1,sum1));
			Set<Integer> set2 = setSizeAndValueToPosiblePartitions.get(new Tuple<Integer,Integer>(size2, sum2));
			
			Set<Integer> intersection = new HashSet<Integer>(Sets.intersection(set, set2));
			
			intersection.removeAll(alreadyTakenValues);
			
			return intersection;
		}
	}
	
	public static void main(String[] args) {
		Set<Integer> possibleValuesForField = GeneratedIntegerPartition.getPossibleValuesForField(45, 9, 45, 9, Sets.newHashSet(1,2,3,4));
		
		for(Integer integ : possibleValuesForField) {
			System.out.println(integ.intValue());
		}
	}
}
