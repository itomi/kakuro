package org.itomi.kakuro.model.fields;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Sets;

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
	private static HashMultimap<Tuple<Integer, Integer>, Set<Integer> > setSizeAndValueToPosiblePartitions = HashMultimap.create();
	
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
			valueToPartitions.put(partition.getValue(), partition.partitions);
			for( Set<Integer> party : partition.partitions ) {
				setSizeAndValueToPosiblePartitions.put(new Tuple<Integer,Integer>(party.size(), partition.getValue()), party);
			}
		}
	}
	
	public static Set<Integer> getPossibleValuesForField(int sum1, int size1, int sum2, int size2, Set<Integer> sum1Values, Set<Integer> sum2values) {
		
		Set<Set<Integer>> partitions1 = setSizeAndValueToPosiblePartitions.get(new Tuple<Integer,Integer>(size1,sum1));
		Set<Set<Integer>> partitions2 = setSizeAndValueToPosiblePartitions.get(new Tuple<Integer,Integer>(size2, sum2));
		
		Set<Integer> horizontal = Sets.newHashSet();
		FluentIterable.from(partitions1).forEach(new Consumer<Set<Integer>>() {
			@Override
			public void accept(Set<Integer> t) {
				if(t.containsAll(sum1Values)) {
					HashSet<Integer> newHashSet = Sets.newHashSet(t);
					newHashSet.removeAll(sum1Values);
					horizontal.addAll(t);
				}
			}
		});
		
		Set<Integer> vertical = Sets.newHashSet();
		FluentIterable.from(partitions2).forEach(new Consumer<Set<Integer>>() {
			@Override
			public void accept(Set<Integer> t) {
				if(t.containsAll(sum2values)) {
					HashSet<Integer> copyOfT = Sets.newHashSet(t);
					copyOfT.removeAll(sum2values);
					vertical.addAll(t);
				}
			}
		});
		
		HashSet<Integer> possibleValues = Sets.newHashSet(Sets.intersection(horizontal, vertical));
		
		return possibleValues;
		
	}
	
	public static Set<Set<Integer>> getPartitionsBySumAndSize(int sum ,int size) {
		return setSizeAndValueToPosiblePartitions.get(new Tuple<Integer, Integer>(size, sum));
	}
	
	public static Set<Set<Integer>> getPartitionsBySumAndSizeAndAlreadyUsedValues(int sum, int size, Set<Integer> usedValues ) {
		Set<Set<Integer>> partitionsBySumAndSize = getPartitionsBySumAndSize(sum, size);
		
		return FluentIterable.from(partitionsBySumAndSize).filter(new Predicate<Set<Integer>>() {
			@Override
			public boolean apply(Set<Integer> input) {
				return input.containsAll(usedValues);
			}
		}).toSet();
		
	}

	public int getValue() {
		return value;
	}
}