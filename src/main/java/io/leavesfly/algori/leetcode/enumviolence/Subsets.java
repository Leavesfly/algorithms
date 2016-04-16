package io.leavesfly.algori.leetcode.enumviolence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author yefei.yf
 * 
 */
public class Subsets {

	public static void main(String[] args) {
		// Subsets.printSubSet(new int[] { 1, 2, 3 }, -1, new int[] { 0, 0, 0
		// });
		// Subsets.genSubSet(new int[] { 1, 2, 3 });
		System.out.println(Subsets.subsets(new int[] { 1, 2, 3, 7 }));
	}

	public static List<String> genSubSet(int[] set) {
		if (set == null || set.length == 0) {
			throw new IllegalArgumentException();
		}

		Arrays.sort(set);
		printSubSet(set, -1, new int[set.length]);

		return null;
	}

	public static void printSubSet(int[] set, int position, int[] flags) {
		if (set.length - 1 == position) {
			print(set, flags);
		} else {
			int nextPosition = ++position;
			for (int i = 0; i <= 1; i++) {
				flags[position] = i;
				printSubSet(set, nextPosition, flags);
			}
		}
	}

	private static void print(int[] set, int[] flags) {
		System.out.print('[');
		for (int i = 0; i < flags.length; i++) {
			if (flags[i] == 1) {
				System.out.print(set[i]);
				System.out.print(' ');
			}
		}
		System.out.println(']');
	}

	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		subsets.add(new ArrayList<Integer>());
		for (int i = 0; i < S.length; i++) {
			int size = subsets.size();
			for (int j = 0; j < size; j++) {
				ArrayList<Integer> subset = new ArrayList<Integer>(subsets.get(j));
				subset.add(S[i]);
				subsets.add(subset);
			}
		}
		return subsets;
	}

}
