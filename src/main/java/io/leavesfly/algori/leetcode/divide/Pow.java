package io.leavesfly.algori.leetcode.divide;

/**
 * Implement pow(x, n).
 * 
 * @author yefei.yf
 * 
 */
public class Pow {

	public static void main(String[] args) {
		System.out.println(pow(2, 0));
		System.out.println(pow(2, 1));
		System.out.println(pow(2, 2));
		System.out.println(pow(2, 3));
		System.out.println(pow(3, 4));
	}

	public static long pow(int background, int exponent) {
		if (background <= 0 || exponent < 0) {
			throw new IllegalArgumentException();
		}
		if (exponent == 0) {
			return 1L;
		}
		if (exponent == 1) {
			return background;
		}

		long result = 0L;
		long tmp = 0L;
		tmp = pow(background, exponent / 2);

		if (exponent % 2 == 0) {
			result = tmp * tmp;
		} else {
			result = tmp * tmp * background;
		}

		return result;
	}
}
