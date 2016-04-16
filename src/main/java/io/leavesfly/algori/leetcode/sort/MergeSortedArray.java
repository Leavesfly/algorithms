package io.leavesfly.algori.leetcode.sort;

import java.util.Arrays;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space to hold additional elements from
 * B. The number of elements initialized in A and B are m and n respectively.
 * 
 * @author yefei.yf
 * 
 */
public class MergeSortedArray {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(merge(new int[] { 1, 4, 5, 7, 9, 14 }, new int[] { 3, 3, 5, 6, 7, 8, 10 })));

	}

	public static int[] merge(int[] from, int[] to) {
		if (from == null || to == null) {
			throw new NullPointerException();
		}
		int[] result = new int[from.length + to.length];

		int fromPointer = 0;
		int toPointer = 0;
		int pointer = -1;

		while (fromPointer < from.length && toPointer < to.length) {
			int tmp = 0;
			if (from[fromPointer] > to[toPointer]) {
				tmp = to[toPointer];
				++toPointer;
			} else {
				tmp = from[fromPointer];
				++fromPointer;
			}
			result[++pointer] = tmp;
		}
		if (fromPointer < from.length) {
			for (int i = fromPointer; i < from.length; i++) {
				result[++pointer] = from[i];
			}
		} else {
			for (int i = toPointer; i < to.length; i++) {
				result[++pointer] = to[i];
			}
		}

		return result;
	}
}
