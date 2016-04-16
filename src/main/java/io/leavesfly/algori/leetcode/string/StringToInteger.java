package io.leavesfly.algori.leetcode.string;

/**
 * Implement atoi to convert a string to an integer. Hint: Carefully consider
 * all possible input cases. If you want a challenge, please do not see below
 * and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * Requirements for atoi: The function first discards as many whitespace
 * characters as necessary until the first non-whitespace character is found.
 * starting from this character, takes an optional initial plus or minus sign
 * followed by as many numerical digits as possible, and interprets them as a
 * numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function. If the first sequence of non-whitespace characters in str is not a
 * valid integral number, or if no such sequence exists because either str is
 * empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * @author yefei.yf
 * 
 */
public class StringToInteger {
	private static final int DIFFERENCE = 48;

	public static void main(String[] args) {
		System.out.println(stringToInt("-2147483647"));
	}

	public static int stringToInt(String intStr) {
		if (intStr == null || intStr.length() == 0 || !isNumStr(intStr)) {
			throw new IllegalArgumentException();
		}

		intStr = intStr.trim();
		long plus = 0L;
		long result = 0L;
		long INT_MIN = Integer.MIN_VALUE;
		long INT_MAX = Integer.MAX_VALUE;

		for (int i = intStr.length() - 1; i > 0; i--) {
			result += ((int) intStr.charAt(i) - DIFFERENCE) * Math.pow(10, intStr.length() - 1 - i);
		}

		char start = intStr.charAt(0);
		if (start == '-') {

			result = -result;
			if (result < INT_MIN) {
				throw new IllegalArgumentException("overflow");
			}

		} else {
			plus = ((int) start - DIFFERENCE) * (long) Math.pow(10, intStr.length() - 1);
			result += plus;
			if (result > INT_MAX) {
				throw new IllegalArgumentException("overflow");
			}
		}

		return (int) result;

	}

	private static boolean isNumStr(String intStr) {
		if (intStr == null || intStr.length() == 0) {
			return false;
		}
		intStr = intStr.trim();
		char start = intStr.charAt(0);
		if (!(start == '-' || (start >= '0' && start <= '9'))) {
			return false;
		}
		for (int i = 1; i < intStr.length(); i++) {
			if (intStr.charAt(i) < '0' || intStr.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
}
