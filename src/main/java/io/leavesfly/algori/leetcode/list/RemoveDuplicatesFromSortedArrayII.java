package io.leavesfly.algori.leetcode.list;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3], Your function should
 * return length = 5, and A is now [1,1,2,2,3]
 * 
 * @author yefei.yf
 * 
 */
public class RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 1, 1, 2, 2, 2, 3, 3 };
		System.out.println(removeAllowedDuplicates(A, 2));

	}

	public static int removeAllowedDuplicates(int[] sortedIntArray, int allowedDuplicateNum) {
		if (sortedIntArray.length == 0 || sortedIntArray.length == 1 || sortedIntArray.length == 2) {
			return sortedIntArray.length;
		} else {
			int position = 0;
			int duplicateCount = 0;
			for (int i = 1; i < sortedIntArray.length; i++) {

				if (sortedIntArray[position] != sortedIntArray[i]) {
					position++;
					sortedIntArray[position] = sortedIntArray[i];
					duplicateCount = 0;
				} else {
					if (duplicateCount < allowedDuplicateNum - 1) {
						duplicateCount++;
						position++;
						sortedIntArray[position] = sortedIntArray[i];
					}
				}
			}
			return ++position;
		}
	}
}
