package io.leavesfly.algori.leetcode.search;

import java.util.Arrays;

/**
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author yefei.yf
 * 
 */
public class SearForaRange {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchForRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
	}

	public static int[] searchForRange(int[] array, int target) {
		int[] result = new int[] { -1, -1 };
		if (array == null || array.length <= 2) {
			return result;
		}
		int low = findLowPosition(array, target, 0, array.length - 1);
		int high = findHighPosition(array, target, 0, array.length - 1);

		result[0] = low;
		result[1] = high;

		return result;
	}

	private static int findLowPosition(int[] array, int target, int low, int high) {
		int position = -1;
		if (target > array[array.length - 1]) {
			return position;
		}

		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (target == array[mid]) {
				position = mid;
				int next = findLowPosition(array, target, low, mid - 1);
				if (next != -1) {
					position = next;
				}
				break;
			} else if (target > array[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return position;
	}

	private static int findHighPosition(int[] array, int target, int low, int high) {
		int position = -1;
		if (target < array[0]) {
			return position;
		}

		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (target == array[mid]) {
				position = mid;
				int next = findLowPosition(array, target, mid + 1, high);
				if (next != -1) {
					position = next;
				}
				break;
			} else if (target > array[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return position;
	}

}
