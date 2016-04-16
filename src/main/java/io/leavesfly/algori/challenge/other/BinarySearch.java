package io.leavesfly.algori.challenge.other;

import java.util.Arrays;

public class BinarySearch {

	public static int rank(int key, int[] a) {
		int low = 0;
		int hight = a.length - 1;

		while (low <= hight) {
			int mid = low + (hight - low) / 2;
			if (key < a[mid]) {
				hight = mid - 1;
			} else if (key > a[mid]) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 3, 56, 7, 22, 44, 66, 88, 2, 1, 78, 44 };
		Arrays.sort(a);
		int i = BinarySearch.rank(44, a);
		System.out.println(i);
		System.out.println(a[i]);

	}
}
