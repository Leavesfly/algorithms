package io.leavesfly.algori.leetcode.divide;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author yefei.yf
 * 
 */
public class Sqrt {

	public static void main(String[] args) {
		System.out.println(sqrt(8));
	}

	public static int sqrt(int sqrtedNum) {
		int low = 0;
		int high = sqrtedNum;
		int mid = 0;

		while (low < high) {
			mid = low + (high - low) / 2;
			int tmp = mid * mid;
			if (tmp > sqrtedNum) {
				high = mid - 1;
			} else if (tmp < sqrtedNum) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
