package io.leavesfly.algori.leetcode.list;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length. Do not allocate extra space for
 * another array, you must do this in place with constant memory.
 * 
 * For example, Given input array A = [1,1,2], Your function should return
 * length = 2, and A is now [1,2].
 * 
 * @author yefei.yf
 * 
 */
public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 2, 2, 3 };
		System.out.println(removeDuplicates(A));

	}

	public static int removeDuplicates(int[] sortedIntArray) {
		if (sortedIntArray.length == 0 || sortedIntArray.length == 1) {
			return sortedIntArray.length;
		} else {
			int position = 0;
			for (int i = 1; i < sortedIntArray.length; i++) {
				if (sortedIntArray[position] != sortedIntArray[i]) {
					position++;
					sortedIntArray[position] = sortedIntArray[i];
				}
			}
			return ++position;
		}

	}

}
