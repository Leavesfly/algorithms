package io.leavesfly.algori.leetcode.detail;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * @author yefei.yf
 * 
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] result = twoSum(new int[] { 2, 7, 11, 15 }, 18);
		System.out.println(result[0] + "," + result[1]);

	}

	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[] { -1, -1 };
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}

		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[0] = i;
				result[1] = map.get(target - numbers[i]);
				return result;
			}
		}

		return result;
	}

}
