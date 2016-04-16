package io.leavesfly.algori.leetcode.detail;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * Have you thought about this? Here are some good questions to ask before
 * coding. Bonus points for you if you have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 * 
 * Throw an exception? Good, but what if throwing an exception is not an option?
 * You would then have to re-design the function (ie, add an extra parameter).
 * 
 */
public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverseInteger(123));
		System.out.println(reverseInteger(-123));
		System.out.println(reverseInteger(100));
	}

	public static int reverseInteger(int reversedInt) {
		int result = 0;
		for (; reversedInt != 0; reversedInt = reversedInt / 10) {
			result = result * 10 + reversedInt % 10;
		}
		return result;
	}

}
