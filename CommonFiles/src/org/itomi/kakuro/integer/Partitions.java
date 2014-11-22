package org.itomi.kakuro.integer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * 
 * Integer Partitioning algorithm
 * 
 * Zapozyczone do zautomatyzowania podzialu liczb na cyfry do gry kakuro.
 * 
 * @author Chris Greene @ https://github.com/cwgreene/algorithms
 *
 */
public class Partitions {
	public static List<List<Integer>> partitions(int n) {
		List<List<Integer>> partitions = new ArrayList<List<Integer>>();
		if (n <= 0) {
			partitions.add(new ArrayList<Integer>());
			return partitions;
		}
		List<List<Integer>> prev_partitions = partitions(n - 1);
		int ppsize = prev_partitions.size();
		for (int i = 0; i < ppsize; i++) {
			List<Integer> p = prev_partitions.get(i);
			List<Integer> a = new ArrayList<Integer>();
			a.add(1);
			a.addAll(p);
			partitions.add(a);

			int psize = p.size();
			if (psize != 0) {
				if ((psize < 2) || (p.get(1) > p.get(0))) {
					List<Integer> b = new ArrayList<Integer>();
					b.add(p.get(0) + 1);
					b.addAll(p.subList(1, psize));
					partitions.add(b);
				}
			}
		}
		return partitions;
	}

	public static List<Set<Integer>> partitionsWithAllowedValues(int value,
			Set<Integer> allowedValuesOfPartition) {
		List<Set<Integer>> party = new LinkedList<Set<Integer>>();
		int n = value;
		Set<Integer> allowedInts = allowedValuesOfPartition;
		List<List<Integer>> partitions = partitions(n);
		for (List<Integer> part : partitions) {
			HashSet<Integer> hashSet = new HashSet<Integer>(part);
			if (sumsUp(hashSet, n) && allowedInts.containsAll(hashSet)
					&& hashSet.size() > 1) {
				party.add(hashSet);
			}
		}
		return party;
	}

	public static void main(String[] args) {
		int n = 45;
		HashSet<Integer> allowedInts = Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8,
				9);
		List<List<Integer>> partitions = partitions(n);
		for (List<Integer> part : partitions) {
			HashSet<Integer> treeSet = new HashSet<Integer>(part);
			if (sumsUp(treeSet, 45) && allowedInts.containsAll(treeSet)) {
				print(treeSet);
			}
		}
	}

	private static void print(HashSet<Integer> treeSet) {
		for (Integer integ : treeSet) {
			System.out.print(integ + " ");
		}
		System.out.println();
	}

	private static boolean sumsUp(HashSet<Integer> treeSet, int i) {
		int sum = 0;
		for (Integer integer : treeSet) {
			sum += integer.intValue();
		}
		return sum == i;
	}
}