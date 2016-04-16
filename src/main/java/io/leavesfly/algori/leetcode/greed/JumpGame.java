package io.leavesfly.algori.leetcode.greed;

/**
 * 
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * @author yefei.yf
 * 
 */
public class JumpGame {

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
	}

	public static boolean canJump(int[] jumpArray) {
		if (jumpArray == null || !isNonNegativeIntArray(jumpArray)) {
			throw new IllegalArgumentException();
		}

		int canReachIndex = 0;
		for (int i = 0; i < jumpArray.length; i++) {
			if (i > canReachIndex) {
				return false;
			}
			if (canReachIndex >= jumpArray.length - 1) {
				return true;
			}
			canReachIndex = (i + jumpArray[i]) > canReachIndex ? (i + jumpArray[i])
					: canReachIndex;
		}

		return true;
	}

	private static boolean isNonNegativeIntArray(int[] jumpArray) {

		for (int i = 0; i < jumpArray.length; i++) {
			if (jumpArray[i] < 0) {
				return false;
			}
		}
		return true;
	}

}
