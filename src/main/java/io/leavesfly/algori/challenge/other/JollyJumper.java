package io.leavesfly.algori.challenge.other;

import java.util.HashSet;
import java.util.Set;

public class JollyJumper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 4, 2, 3 };
		int[] nums2 = new int[] { 5, 1, 4, 2, -1, 6 };
		System.out.println(JollyJumper.isJollyJumper(nums));
		System.out.println(JollyJumper.isJollyJumper(nums2));

	}

	public static boolean isJollyJumper(int[] numbers) {

		int tmp = Integer.MIN_VALUE;
		Set<Integer> numSet = new HashSet<Integer>();

		for (int i = 0; i < numbers.length - 1; i++) {
			tmp = Math.abs(numbers[i + 1] - numbers[i]);
			numSet.add(tmp);
		}

		for (int i = 1; i < numbers.length; i++) {
			if (!numSet.contains(i)) {
				return false;
			}
		}

		return true;
	}

}
