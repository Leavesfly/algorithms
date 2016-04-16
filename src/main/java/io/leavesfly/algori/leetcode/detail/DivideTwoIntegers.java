package io.leavesfly.algori.leetcode.detail;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * @author yefei.yf
 * 
 */
public class DivideTwoIntegers {

	public static void main(String[] args) {

		// System.out.println(divideInefficiency(10, 3));
		System.out.println(divideEfficiency(1024, 2));

	}

	public static int divideInefficiency(int divisor, int dividend) {
		int result = 0;
		while (divisor >= dividend) {
			divisor -= dividend;
			result++;
		}

		return result;
	}

	public static int divideEfficiency(int divisor, int dividend) {
		int result = 0;
		int count = 0;
		while (divisor >= dividend) {
			while (divisor >= dividend << count) {
				divisor = divisor - dividend << count;
				if (count == 0) {
					++result;
				} else {
					result += 2 << count;
					++count;
				}
			}
			count = 0;
		}
		return result;
	}

}
